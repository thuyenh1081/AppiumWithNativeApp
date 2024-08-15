package com.qa.pages.trade;

//import io.appium.java_client.MobileElement;

import com.qa.pages.TradeTicket.OrderConfirmation.OrderConfirmationCFD;
import com.qa.pages.TradeTicket.OrderDetails.OrderDetailsCFD;
import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TradeCFDOrdersPage extends TradeCFDPage {
    public TradeCFDOrdersPage()
    {
    }
    public TradeCFDOrdersPage(Boolean isCheckPopup)
    {
        super(isCheckPopup);
//        waitForVisibilityWithExplicitWait(tabLayoutTrade);
    }

    @AndroidFindBy(id = appPackage+":id/rvContainerTradeOrder")
    @iOSXCUITFindBy(iOSNsPredicate = "l")
    public WebElement OrderTable;

    @AndroidFindBy(id = appPackage+":id/tvSpinner")
    @iOSXCUITFindBy(iOSNsPredicate = "value == 'Today’s Orders'")
    public WebElement OrderDropBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='"+appPackage+":id/tvDateOrder' and @text='Today's Orders']")
    @iOSXCUITFindBy(accessibility = "Today’s Orders")
    public WebElement TodayOrder;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='"+appPackage+":id/tvDateOrder' and @text='Today's Orders']")
    @iOSXCUITFindBy(accessibility = "GTD (Past 7 Days)")
    public WebElement Past7Days;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='"+appPackage+":id/layoutProductParent'][1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Filled Qty, Total Qty']/following-sibling::*[1]")
    public WebElement FirstOrder;

    public List<WebElement> getListOfOrder()
    {
        return listOfElements(OrderTable, "//android.view.ViewGroup[@resource-id='"+appPackage+":id/layoutProductParent']");
    }

    public void clickOnThefirstOrderRow()
    {
        clickWithExplicitWait(FirstOrder);
    }
    public OrderDetailsCFD clickOnOrderRow(int index)
    {
        clickWithExplicitWait(getListOfOrder().get(index));
        return new OrderDetailsCFD();
    }

    private void clickOnOrderDropBox()
    {
        clickWithExplicitWait(OrderDropBox);
    }

    public void filterOrderByToday()
    {
        clickOnOrderDropBox();
        clickWithExplicitWait(TodayOrder);
    }

    public List<String> getTotalOfOrderInCurrentView()
    {
        String xpathToGetName = null;
        String xpathToGetElements = null;
        String xpathToGetRow = null;
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            xpathToGetRow = ".//android.widget.TextView[@resource-id='"+appPackage+":id/layoutProductParent' and @text='";
            xpathToGetName = ".//android.widget.TextView[@resource-id='"+appPackage+":id/tvProductName']";
            xpathToGetElements = ".//android.view.ViewGroup";
        }
        else {
            xpathToGetRow = ".//XCUIElementTypeStaticText[@name='";
            xpathToGetName = ".//XCUIElementTypeStaticText";
            xpathToGetElements = ".//XCUIElementTypeCell";
        }
        List<String> order = verticalToGetAllName(OrderTable,xpathToGetRow, xpathToGetName,xpathToGetElements);
//        scrollTradeCFDToSeeTradebtn();
        swipeTradeCFDToSeeTradebtn();
        return order;
//        // fix by ios
//        return driver.findElements(AppiumBy.xpath("//XCUIElementTypeButton[@name='Filled Qty, Total Qty']/following-sibling::XCUIElementTypeButton")).size();

    }


    public List<String> getTotalOfTodayOrder()
    {
        filterOrderByToday();
        return getTotalOfOrderInCurrentView();
         }

    public List<String> verticalToGetAllValueOfColumnName() {
        /////////
        String xpathToGetName = null;
        String xpathToGetElements = null;
        String xpathToGetRow = null;
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            xpathToGetRow = ".//android.widget.TextView[@resource-id='"+appPackage+":id/tvProductName' and @text='";
            xpathToGetName = ".//android.widget.TextView[@resource-id='"+appPackage+":id/tvProductName']";
            xpathToGetElements = ".//android.view.ViewGroup";
        }
        else {
            xpathToGetRow = ".//XCUIElementTypeStaticText[@name='";
            xpathToGetName = ".//XCUIElementTypeStaticText";
            xpathToGetElements = ".//XCUIElementTypeCell";
        }
//        return verticalToGetAllName(CounterTableDefault, xpathToGetRow, xpathToGetName,xpathToGetElements);
        return null;
    }

    @Override
    public void waitForFullDisplayOFAPage()
    {
        waitForVisibilityWithExplicitWait(OrderTable);
    }
}
