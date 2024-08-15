package com.qa.pages.market;

//import io.appium.java_client.MobileElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class MarketStockPage extends MarketModulePage {

    @AndroidFindBy(id = appPackage+":id/tvViewAll")
    @iOSXCUITFindBy(accessibility = "ViewAll")
    public WebElement ViewAll;

    @AndroidFindBy(id = appPackage+":id/llItemStock")
    @iOSXCUITFindBy(xpath = "/XCUIElementTypeScrollView[1]/XCUIElementTypeOther")
    public WebElement StockContent;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='"+appPackage+":id/tvNameIndices' and @text='Top Volume']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='BTN_TOP_VOLUME']")
    public WebElement TopVolume;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='"+appPackage+":id/tvNameIndices' and @text='Top Gainers']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='BTN_TOP_GAINERS']")
    public WebElement TopGainer;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='"+appPackage+":id/tvNameIndices' and @text='Top Losers']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='BTN_TOP_LOSERS']")
    public WebElement TopLosers;

    public void clickOnViewAll()
    {
        clickWithExplicitWait(ViewAll);
    }

    public void clickOnTopVolume()
    {
        clickWithExplicitWait(TopVolume);
    }

    public void clickOnTopGainer()
    {
        swipeGestureByElement(StockContent,"up", 1);
        clickWithExplicitWait(TopGainer);
    }

    public void clickOnTopLosers()
    {
        swipeGestureByElement(StockContent,"up", 1);
        clickWithExplicitWait(TopLosers);
    }
}
