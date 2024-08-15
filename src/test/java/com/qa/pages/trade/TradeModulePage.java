package com.qa.pages.trade;

import com.qa.pages.CommonContentPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class TradeModulePage extends CommonContentPage {
    public TradeModulePage()
    {
    }
    public TradeModulePage(Boolean isCheckPopup)
    {
        super(isCheckPopup);
    }

    @AndroidFindBy(id = appPackage+":id/tabLayoutTradeScreen")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView[1]/XCUIElementTypeOther")
    public WebElement tabLayoutTrade;

    private WebElement findTradeTypeByName(String name)
    {
        return findElementByName(tabLayoutTrade, name);
    }

    public TradeModulePage clickOnTradeType(String type)
    {
        TradeModulePage tradeModulePage;
        switch (type)
        {
            case "Stock":
                tradeModulePage = new TradeStockPage();
                break;
            case "UT":
                tradeModulePage = new TradeUTPage();
                break;
            case "Robo":
                tradeModulePage = new TradeRoboPage();
                break;
            case "CFD":
                tradeModulePage = new TradeCFDPage(true);
                break;
            default:
                tradeModulePage = new TradeModulePage();
                break;
        }
        clickWithExplicitWait(findTradeTypeByName(type));
        return tradeModulePage;
    }


    public WebElement horizontalToFindTradeTypeByName(String name)
    {
        return horizontalToFindElementByName(name, tabLayoutTrade);
    }

    @Override
    public void waitForFullDisplayOFAPage()
    {
        waitForVisibilityWithExplicitWait(tabLayoutTrade);
        System.out.println("Trade");
    }
}
