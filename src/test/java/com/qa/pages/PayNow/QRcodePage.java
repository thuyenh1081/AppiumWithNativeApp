package com.qa.pages.PayNow;

import com.qa.pages.CommonContentPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class QRcodePage extends CommonContentPage {

    @AndroidFindBy(id = appPackage+":id/edtInputAccount")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='POEMS Account Number']/../XCUIElementTypeTextField")
    public WebElement backBtn;

    @AndroidFindBy(id = appPackage+":id/edtInputAccount")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='POEMS Account Number']/../XCUIElementTypeTextField")
    public WebElement QRCodeMessage;

    @AndroidFindBy(id = appPackage+":id/edtInputAccount")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='POEMS Account Number']/../XCUIElementTypeTextField")
    public WebElement QRCodeGuide;

    @AndroidFindBy(id = appPackage+":id/edtInputAccount")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='POEMS Account Number']/../XCUIElementTypeTextField")
    public WebElement DiscountLable;

    @AndroidFindBy(id = appPackage+":id/edtInputAccount")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='POEMS Account Number']/../XCUIElementTypeTextField")
    public WebElement DepositAmount;

    @AndroidFindBy(id = appPackage+":id/edtInputAccount")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='POEMS Account Number']/../XCUIElementTypeTextField")
    public WebElement QRCodeImage;

    @AndroidFindBy(id = appPackage+":id/edtInputAccount")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='POEMS Account Number']/../XCUIElementTypeTextField")
    public WebElement QRCodeSaveBtn;

    @AndroidFindBy(id = appPackage+":id/edtInputAccount")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='POEMS Account Number']/../XCUIElementTypeTextField")
    public WebElement ReferenceNo;

    @AndroidFindBy(id = appPackage+":id/edtInputAccount")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='POEMS Account Number']/../XCUIElementTypeTextField")
    public WebElement Amount;

    @AndroidFindBy(id = appPackage+":id/edtInputAccount")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='POEMS Account Number']/../XCUIElementTypeTextField")
    public WebElement UEN;

    @AndroidFindBy(id = appPackage+":id/edtInputAccount")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='POEMS Account Number']/../XCUIElementTypeTextField")
    public WebElement Message;

    @AndroidFindBy(id = appPackage+":id/edtInputAccount")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='POEMS Account Number']/../XCUIElementTypeTextField")
    public WebElement Toast;

    public void clickOnBackBtn()
    {
        clickWithExplicitWait(backBtn);
    }
    public void clickOnSaveQRCodeBtn()
    {
        clickWithExplicitWait(QRCodeSaveBtn);
    }

}
