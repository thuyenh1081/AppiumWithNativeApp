package com.qa.stepdef.PayNow;

import com.qa.pages.PayNow.QRcodePage;
import com.qa.utils.TestUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class QRCodeDef {

    @Then("^Verify the display of QRCode is \"([^\"]*)\"$")
    public void verifyTheExisitngOfQRCodeScreen(String isExisted){
        QRcodePage qRcodePage = new QRcodePage();
        qRcodePage.VerifyTheExistingOfAnElement(qRcodePage.QRCodeImage, isExisted,
                "Content screen is expected " + isExisted + " but not" +isExisted);
    }

    @Then("^Verify value QRCode message QRCodeMessage$")
    public void verifyMessageOfQRCode(){
        QRcodePage qRcodePage = new QRcodePage();
        TestUtils testUtils = new TestUtils();
        String expireDate = testUtils.transformFormatOfDate(testUtils.getDateAfterToday(1),"dd MM yyyy");
        qRcodePage.verifyText
                ("The QR code will due on <"+expireDate+"> 00:00AM. Please scan and complete payment before due " +
                        "date", qRcodePage.QRCodeMessage.getText());
    }

    @Then("^Verify value QRCode field DepositAmount is \"([^\"]*)\"$")
    public void verifyValueOfDepositAmount(String amount){
        QRcodePage qRcodePage = new QRcodePage();
        qRcodePage.verifyText(qRcodePage.DepositAmount.getText(), amount);
    }

    @Then("^Verify value QRCode label ReferenNo is \"([^\"]*)\"$")
    public void verifyValueOfReferenNo(String account) throws IOException {
        String expected="";
        QRcodePage qRcodePage = new QRcodePage();
        if(qRcodePage.getAccountType(account).equalsIgnoreCase("CFD")) expected = account + "CFD";
        qRcodePage.verifyText(expected, qRcodePage.ReferenceNo.getText());
    }

    @Then("^Verify value QRCode Amount is \"([^\"]*)\"$")
    public void verifyValueOfAmount(String amount){
        QRcodePage qRcodePage = new QRcodePage();
        qRcodePage.verifyText(qRcodePage.Amount.getText(), amount);
    }

    @Then("^Verify value QRCode field UEN is \"([^\"]*)\"$")
    public void verifyValueOfUEN(String key) throws Exception {
        QRcodePage qRcodePage = new QRcodePage();
        qRcodePage.verifyTextWithDataInRoboXML(key, qRcodePage.UEN.getText());
    }

    @Then("^Verify value QRCode message QRCodeGuide is \"([^\"]*)\"$")
    public void verifyValueOfGuide(String key) throws Exception {
        QRcodePage qRcodePage = new QRcodePage();
        qRcodePage.verifyTextWithDataInRoboXML(key,qRcodePage.QRCodeGuide.getText());
    }

    @When("^Tap on QRCode icon Back$")
    public void iTapOnBackBtn(String amount){
        new QRcodePage().clickOnBackBtn();
    }

    @When("^Tap on QRCode button SaveQRCode$")
    public void iTapOnSaveQRCodeBtn(String amount){
        new QRcodePage().clickOnSaveQRCodeBtn();
    }

    @Then("^Verify value QRCode icon toast incase no internet is \"([^\"]*)\"$")
    public void iTapOnSaveQRCodeBtnInCaseNoInternet(String key) throws IOException {
        QRcodePage qRcodePage = new QRcodePage();
        try {
            qRcodePage.configureWifiModeByConfigThroughSettingOfDevice("true");
            qRcodePage.activeApp();
            qRcodePage.clickOnSaveQRCodeBtn();
            verifyValueOfToast(key);
        }
        catch (Exception ex)
        {
            qRcodePage.configureWifiModeByConfigThroughSettingOfDevice("true");
            qRcodePage.activeApp();
        }
        qRcodePage.configureWifiModeByConfigThroughSettingOfDevice("true");
        qRcodePage.activeApp();
    }

    @Then("^Verify the display of QRCode icon toast is \"([^\"]*)\"$")
    public void verifyTheExisitngOfToast(String isExisted){
        QRcodePage qRcodePage = new QRcodePage();
        qRcodePage.VerifyTheExistingOfAnElement(qRcodePage.Toast, isExisted,
                "Content screen is expected " + isExisted + " but not" +isExisted);
    }

    @Then("^Verify value QRCode icon toast is \"([^\"]*)\"$")
    public void verifyValueOfToast(String key) throws Exception {
        QRcodePage qRcodePage = new QRcodePage();
        qRcodePage.verifyText("data/robo.xml", key,qRcodePage.Toast.getText());
    }

    @Then("^Verify saving QRCode icon QRCodeImage$")
    public void verifyVSavingQRImage(){
        //todo
         }
}
