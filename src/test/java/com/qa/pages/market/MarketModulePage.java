package com.qa.pages.market;

import com.qa.pages.CommonContentPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class MarketModulePage extends CommonContentPage {
//    public MarketModulePage()
//    {
//        super();
//        waitForVisibilityWithExplicitWait(llItemStock);
//    }

    @AndroidFindBy(id = appPackage+":id/tabLayoutWatchList")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView[1]/XCUIElementTypeOther")
    public WebElement tabLayoutMarket;

    @AndroidFindBy(id = appPackage+":id/llItemStock")
    @iOSXCUITFindBy(xpath = "later")
    public WebElement llItemStock;

    @AndroidFindBy(id = appPackage+":id/rvStockMarkets")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView[1]/XCUIElementTypeOther")
    public WebElement rvStockMarkets;

    private WebElement findMarketTypeByName(String name)
    {
        return findElementByName(tabLayoutMarket, name);
    }

    public void clickOnMarketType(String type)
    {
        clickWithExplicitWait(findMarketTypeByName(type));
        waitForVisibilityWithExplicitWait(tabLayoutMarket);
    }


    public WebElement horizontalToFindMarketTypeByName(String name)
    {
        return horizontalToFindElementByName(name, tabLayoutMarket);
    }
//    @Override
//    public void waitForTheDisplayOfThePage()
//    {
//        super.waitForTheDisplayOfThePage();
//        waitForVisibilityWithExplicitWait(llItemStock);
//    }
}
