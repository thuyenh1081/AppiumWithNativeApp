package com.qa.pages.TradeTicket;

import com.qa.pages.CommonContentPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class TradeTicket extends CommonContentPage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='"+appPackage+":id/tvText' and @text='BUY']")
    @iOSXCUITFindBy(accessibility = "BUY")
    public WebElement BuyBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='"+appPackage+":id/tvText' and @text='BUY']")
    @iOSXCUITFindBy(accessibility = "SELL")
    public WebElement SellBtn;

    public void clickOnBuyBtn()
    {
        clickWithExplicitWait(BuyBtn);
    }

    public void clickOnSellBtn()
    {
        clickWithExplicitWait(SellBtn);
    }

}