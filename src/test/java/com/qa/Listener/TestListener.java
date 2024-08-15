package com.qa.Listener;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.qa.pages.BasePage;
import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;
import io.cucumber.testng.PickleWrapper;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.qa.report.ExtentReport;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestListener implements ITestListener {
	TestUtils utils = new TestUtils();
	PickleWrapper pickleWrapper;
	private List<Object> takePicture(ITestResult result)
	{
		List<Object> returnedvalues = new ArrayList<>();

		if(result.getThrowable() != null) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			result.getThrowable().printStackTrace(pw);
		}

		BasePage base = new BasePage();
		File file = base.getDriver().getScreenshotAs(OutputType.FILE);

		byte[] encoded = null;
		try {
			encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Map <String, String> params = new HashMap<String, String>();
		params = result.getTestContext().getCurrentXmlTest().getAllParameters();

		String imagePath = "Screenshots" + File.separator + params.get("platformName")
				+ "_" + params.get("deviceName") + File.separator + utils.dateTime() + File.separator
				+ result.getTestClass().getRealClass().getSimpleName() + File.separator + result.getName() + ".png";

		String completeImagePath = System.getProperty("user.dir") + File.separator + imagePath;

		returnedvalues.add(file);
		returnedvalues.add(imagePath);
		returnedvalues.add(completeImagePath);
		returnedvalues.add(encoded);
		return returnedvalues;
	}
	public void onTestFailure(ITestResult result) {

		List<Object> values = takePicture(result);
		try {
			FileUtils.copyFile((File) values.get(0), new File(values.get(1).toString()));
			Reporter.log("This is the sample screenshot");
			Reporter.log("<a href='"+ values.get(2).toString() + "'> <img src='"+ values.get(2).toString() + "' height='400' width='400'/> </a>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ExtentReport.getTest().fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(values.get(2).toString()).build());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		try {
			ExtentReport.getTest().fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromBase64String(new String((byte[]) values.get(3), StandardCharsets.US_ASCII)).build());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		ExtentReport.getTest().fail(result.getThrowable());
	}

	public String get(PickleWrapper pickleWrapper)
	{
		this.pickleWrapper = pickleWrapper;
		return pickleWrapper.toString();
	}
	@Override
	public void onTestStart(ITestResult result) {
		GlobalParams globalValue = new GlobalParams();
		ExtentReport.startTest(result.getName(), result.getMethod().getDescription())
		.assignCategory(globalValue.getPlatformName() + "_" + globalValue.getDeviceName())
		.assignAuthor("Huyen");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentReport.getTest().log(Status.PASS, "Test Passed");

		List<Object> values = takePicture(result);
		try {
			FileUtils.copyFile((File) values.get(0), new File(values.get(1).toString()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentReport.getTest().log(Status.SKIP, "Test Skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentReport.getReporter().flush();
	}

}
