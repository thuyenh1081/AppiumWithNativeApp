package com.qa.pages.trade;

import com.qa.pages.PayNow.PayNowPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class TradeRoboPage extends TradeModulePage {

    @AndroidFindBy(id = appPackage+":id/tvCurrency")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Cash']")
    private WebElement Cash;

    @AndroidFindBy(id = appPackage+":id/tvRoboAccountTypeDeposit")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Deposit']")
    private WebElement Deposit;

    @AndroidFindBy(id = appPackage+":id/tvDepositName")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PayNow']")
    private WebElement PayNow;

    @AndroidFindBy(id = appPackage+":id/tvDepositContent")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Use PayNow to deposit via banking app']")
    private WebElement DescriptionOfPayNow;

    @AndroidFindBy(id = appPackage+":id/rvMenuAccount")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView[2]/XCUIElementTypeOther")
    private WebElement MenuRoboAccount;

    @AndroidFindBy(id = "later")
    @iOSXCUITFindBy(accessibility = "img_general_investment")
    private WebElement InvestmentImg;

    public void clickOnCash()
    {
        clickWithExplicitWait(Cash);
    }

    public void clickOnDeposit()
    {
        clickWithExplicitWait(Deposit);
    }

    public void clickOnPaynow()
    {
        clickWithExplicitWait(PayNow);
        waitForClickableWithExplicitWait(new PayNowPage().amountTxt);
    }

    public WebElement findRoboAccountByName(String name) throws Exception {
        return findElementByName(MenuRoboAccount, name);
    }

    public void clickOnRoboAccount(String roboAccount) throws Exception {
        clickWithExplicitWait(findRoboAccountByName(getDataFromXMLFile("data/robo.xml").get(roboAccount)));
        waitForVisibilityWithExplicitWait(MenuRoboAccount);
    }

    public WebElement horizontalToFindRoboAccountByName(String name) throws Exception {
        return horizontalToFindElementByName(getDataFromXMLFile("data/robo.xml").get(name), MenuRoboAccount);
    }

    @Override
    public void waitForFullDisplayOFAPage()
    {
        waitForVisibilityWithExplicitWait(InvestmentImg);
    }
}
