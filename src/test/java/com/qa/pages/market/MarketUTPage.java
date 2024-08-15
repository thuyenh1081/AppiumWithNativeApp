package com.qa.pages.market;

//import io.appium.java_client.MobileElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class MarketUTPage extends MarketModulePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='"+appPackage+":id/tvNameSection' and @text='Top Performing']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Top Performing']")
    public WebElement TopPerforming;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='"+appPackage+":id/tvNameSection' and @text='Worst Performing']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Worst Performing']")
    public WebElement WorstPerforming;

    public void clickOnTopPerforming()
    {
        clickWithExplicitWait(TopPerforming);
    }

    public void clickOnWorstPerforming()
    {
        clickWithExplicitWait(WorstPerforming);
    }
}
