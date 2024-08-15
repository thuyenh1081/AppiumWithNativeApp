package com.qa.pages.trade;

//import io.appium.java_client.MobileElement;

import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TradeStockPositionsPage extends TradeStockPage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Positions']")
    @iOSXCUITFindBy(xpath = "XCUIElementTypeStaticText[@label = 'Positions']")
    private WebElement TradePositionTab;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Orders']")
    @iOSXCUITFindBy (xpath = "XCUIElementTypeStaticText[@label = 'Orders']")
    private WebElement TradeOrdersTab;

    @AndroidFindBy (id=appPackage+":id/rvContainerTradeOrder")
    private WebElement TradeOrderList;

    public void tapOnPositionTab() {
        clickWithExplicitWait(TradePositionTab);
    }

    public void tapOnOrdersTab() {
        clickWithExplicitWait(TradeOrdersTab);
    }

    public void tapOnAnOrder(int index) {
        clickWithExplicitWait(getOrderRow(index));
    }

    public List<WebElement> listOfOrder() {
        waitForVisibilityWithExplicitWait(TradeOrderList);
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform))
//            return CounterTableDefault.findElements(AppiumBy.className("android.view.ViewGroup"));
//            return TradeOrderList.findElements(AppiumBy.("layoutProductParent"));
            return TradeOrderList.findElements(AppiumBy.id(appPackage+":id/layoutProductParent"));
        else return TradeOrderList.findElements(AppiumBy.className("XCUIElementTypeCell"));

    }

    public WebElement getOrderRow(int index) {
        // qua index trả về row
        List<WebElement> e = listOfOrder();
        WebElement el = e.get(index);
        return el;
    }

}
