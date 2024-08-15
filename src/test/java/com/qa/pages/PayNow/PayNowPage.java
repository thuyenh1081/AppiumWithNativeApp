package com.qa.pages.PayNow;

import com.qa.pages.CommonContentPage;
import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PayNowPage extends CommonContentPage {
	@AndroidFindBy(xpath= "//android.widget.TextView[@resource-id='"+appPackage+":id/tvBack']")
	@iOSXCUITFindBy(xpath = "dasddasd")
	public WebElement HeaderPage;

	@AndroidFindBy(id = appPackage+":id/btnBack")
	@iOSXCUITFindBy(iOSNsPredicate = "name == 'BTN_BACK'")
	public WebElement backBtn;

	@AndroidFindBy(id = appPackage+":id/tvTransfer")
	@iOSXCUITFindBy(xpath = "dadasds")
	public WebElement AccountLable;

	@AndroidFindBy(id = appPackage+":id/tvTransferAccount")
	@iOSXCUITFindBy(xpath = "dadasda")
	public WebElement TransferAccount;

	@AndroidFindBy(id = appPackage+":id/rcvOption")
	@iOSXCUITFindBy(xpath = "dadadas")
	public WebElement accountDroplist;

	@AndroidFindBy(id = appPackage+":id/textInputLayout")
	@iOSXCUITFindBy(xpath = "dasdada")
	public WebElement textInputLayout;

	@AndroidFindBy(id = appPackage+":id/edtTradeDepositAmount")
	@iOSXCUITFindBy(xpath = "dadadasd")
	public WebElement amountTxt;

	@AndroidFindBy(xpath = "//"+appPackage+":id/textInputLayout/android.widget.TextView")
	@iOSXCUITFindBy(xpath = "dadadsd")
	public WebElement amountMessage;

	@AndroidFindBy(id = appPackage+":id/edtInputAccount")
	@iOSXCUITFindBy(xpath = "dasdadsds")
	public WebElement messageWrongFormatOfAmount;

	@AndroidFindBy(id = appPackage+":id/edtInputAccount")
	@iOSXCUITFindBy(xpath = "dadadad")
	public WebElement continueBtn;

	public void openAccountDropDownList()
	{
		clickWithExplicitWait(TransferAccount);
	}

	public void clickOnBackBtn()
	{
		clickWithExplicitWait(backBtn);
	}

	public void clickOnContinueBtn()
	{
		clickWithExplicitWait(continueBtn);
	}
	public WebElement swipeToFindAccount(String account) throws Exception {
		String xpathToGetName = null;
		String xpathToGetElements = null;
		String xpathToGetRow = null;
		if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
			xpathToGetRow = ".//android.widget.TextView[@resource-id='"+appPackage+":id/tvAccountNo'" +
					" and @text ='"+getDataFromXMLFile("data/robo.xml").get(account)+"']/..";
			xpathToGetName = "";
			xpathToGetElements = ".//android.widget.TextView";
		}
		else {
			xpathToGetRow = ".//XCUIElementTypeStaticText/parent";
			xpathToGetName = ".//XCUIElementTypeStaticText";
			xpathToGetElements = ".//XCUIElementTypeCell";
		}
		return verticalToFindElementByName(xpathToGetRow,xpathToGetName,xpathToGetElements,accountDroplist);
	}

	private WebElement findAccountByName(String account) throws Exception {
		return findElementByName(accountDroplist,getDataFromXMLFile("data/robo.xml").get(account) );
	}
	public WebElement verticalTToFindTradeTypeByName(String name)
	{
		return verticalToFindElementByName("","","",accountDroplist);
	}
	public void clickOnAccount(String account) throws Exception {
		clickWithExplicitWait(findAccountByName(account));
	}


	private WebElement getAccountElementByAccountNo(String account)
	{
		clickWithExplicitWait(TransferAccount);
		return null; // lấy từ vùng parent ra 1 row theo account
	}

	public void verifyFormatOfAccount(String TRCode, String account, String accountType)
	{
		String expectedAccount = TRCode + account + accountType;
		WebElement element = getAccountElementByAccountNo(account);
		String actualAccount = getText(element);
		verifyText(expectedAccount, actualAccount);
	}
	public void verifyFormatOfAmount()
	{
		verifyNumberOfDecimal(amountTxt, 2);
		verifySeparatorInNumber(amountTxt.getText(), ',');
	}

	public void verifyFormatOfAllAccount(String TRCode, String account, String accountType)
	{
		// lấy danh sách 3 mảng từ API trả về
		// cho vào vòng for, gọi lần lượt hàm verifyFormatOfAccount()
	}

	public void verifyLabelOfAmount(String currentcy)
	{
        verifyText("Amount ("+currentcy+")", textInputLayout.getText());
	}

	public List<String> verticalToGetAllValueOfAccount()
	{
		String xpathToGetName = null;
		String xpathToGetElements = null;
		String xpathToGetRow = null;

		if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
			xpathToGetRow = ".//android.widget.TextView[@resource-id='"+appPackage+":id/tvAccountNo' and @text ='";
			xpathToGetName = "";
			xpathToGetElements = ".//android.widget.TextView";
		}
		else {
			xpathToGetRow = ".//XCUIElementTypeStaticText/parent";
			xpathToGetName = ".//XCUIElementTypeStaticText";
			xpathToGetElements = ".//XCUIElementTypeCell";
		}
		return verticalToGetAllName(accountDroplist,xpathToGetRow, xpathToGetName,xpathToGetElements);
	}
}
