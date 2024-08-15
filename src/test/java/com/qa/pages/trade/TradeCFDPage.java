package com.qa.pages.trade;

//import io.appium.java_client.MobileElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class TradeCFDPage extends TradeModulePage {

    public TradeCFDPage()
    {
    }
    public TradeCFDPage(Boolean isCheckPopup)
    {
        super(isCheckPopup);
    }
    @AndroidFindBy(id = appPackage+":id/tvTradeClick")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'TRADE'")
    public WebElement TradeBtn;

    @AndroidFindBy(accessibility = "Orders")////android.widget.TextView[@text="Orders"]
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Orders'")
    private WebElement Orders;

    @AndroidFindBy(id = appPackage+":id/viewPaperTrade")
    @iOSXCUITFindBy(iOSNsPredicate = "later")
    public WebElement viewPaperTrade;

    public TradeCFDOrdersPage clickOnOderTab()
    {
        clickWithExplicitWait(Orders);
        return new TradeCFDOrdersPage(true);
    }

    public void clickOnTradeBtn()
    {
        clickWithExplicitWait(TradeBtn);
    }

    public void scrollTradeCFDToSeeTradebtn() {
        while (!isExistingOfAnElement(TradeBtn)) {
            scrollScreen("up");
        }
    }
    public void swipeTradeCFDToSeeTradebtn() {
        try {
            while (!isExistingOfAnElement(TradeBtn)) {

                swipeGestureByElement(viewPaperTrade, "up", 1);
            }
        }
        catch (Exception e){}
    }
    @Override
    public void waitForFullDisplayOFAPage()
    {
        waitForVisibilityWithExplicitWait(Orders);
    }
}
