package com.qa.pages.home;

//import io.appium.java_client.MobileElement;

import com.qa.entity.Counter;
import com.qa.pages.CommonContentPage;
import com.qa.pages.counter.CounterRow;
import com.qa.pages.counter.CounterRowInHome;
import com.qa.pages.watchlist.WatchlistGroup;
import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindAll;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeModulePage extends CommonContentPage {

    public HomeModulePage()
    {
    }
    public HomeModulePage(Boolean isCheckPopup)
    {
        super(isCheckPopup);
    }

    @AndroidFindBy(id = appPackage+":id/recyclerViewData")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable")
    public WebElement AreaOfAllWidget;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='"+appPackage+":id/tvTitleChildHome' and @text='Watchlist']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Watchlist'])[1]")
    public WebElement WatchlistWidgetTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='"+appPackage+":id/tvTitleChildHome' " +
            "and @text='Watchlist']//following-sibling::android.widget.ImageView")
//    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='ic expand right'])[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Watchlist'])[1]/following-sibling::XCUIElementTypeButton")
    public WebElement WatchlistWidgetMoveDetail;

    @AndroidFindBy(id = appPackage+":id/cvWatchListTab")
    @iOSXCUITFindBy(xpath = "later")
    public WebElement WatchlistWidgetTable;

    @AndroidFindBy(id = appPackage+":id/tabLayoutWatchList")
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "(//XCUIElementTypeStaticText[@name='Watchlist'])[1]/../XCUIElementTypeOther/XCUIElementTypeOther[2]"),
            @iOSXCUITBy(xpath = "(//XCUIElementTypeStaticText[@name='Watchlist'])[1]/..")
    })
    public WebElement TabLayoutWatchList;

    @AndroidFindBy(xpath = "(//androidx.recyclerview.widget.RecyclerView[@resource-id='"+appPackage+":id/rvCounter'])[2]")
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "(//XCUIElementTypeStaticText[@name='Watchlist'])[1]/following-sibling::XCUIElementTypeOther/XCUIElementTypeCollectionView//XCUIElementTypeTable"),
            @iOSXCUITBy(xpath = "(//XCUIElementTypeStaticText[@name='Watchlist'])[1]/preceding-sibling::XCUIElementTypeTable")
    })
    public WebElement AreaOfCounterRows;

    public WatchlistGroup clickOnWatchlistWidgetMoveDetail()
    {
        clickWithExplicitWait(WatchlistWidgetMoveDetail);
        WatchlistGroup watchlistGroup = new WatchlistGroup(true);
        watchlistGroup.waitForFullDisplayOFAPage();
        return watchlistGroup;
    }
    public WebElement findWidgetByNameInCurrentView(String widgetName)
    {
        try {
            return driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='"+appPackage+":id/tvTitleChildHome' and @text='" + widgetName + "']"));
        }
        catch (Exception e)
        {
            return driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='"+widgetName+"']"));
        }
    }


    public List<WebElement> getListOfCounterRow()
    {
        return AreaOfCounterRows.findElements(AppiumBy.xpath(".//android.view.ViewGroup" +
                "[@resource-id='"+appPackage+":id/rootLayout'])[1]"));
    }

    public CounterRowInHome findCounterRowByName(String counterName)
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform))
            return new CounterRowInHome(AreaOfCounterRows.findElement(AppiumBy.xpath(".//android.widget.TextView" +
                "[@resource-id='"+appPackage+":id/tvCounterName' and @text='"+counterName+"']/../..")));
        else
            clickWithExplicitWait(WatchlistWidgetMoveDetail);
            clickWithExplicitWait(Home);
            clickOnWatchlistGroup("AutoPre");
            return new CounterRowInHome(AreaOfCounterRows.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='COUNTER_NAME' and @label='"+counterName+"']/..")));
    }
    public void clickOnCounterRow(String counterName)
    {
        clickWithExplicitWait(findCounterRowByName(counterName).getCounterName());
    }
    public CounterRowInHome findCounterRowByType(String counterType)
    {
        return new CounterRowInHome(AreaOfCounterRows.findElement(AppiumBy.xpath(".//android.widget.TextView" +
                "[@resource-id='"+appPackage+":id/tvCounterIcon' and @text='"+counterType+"']/../../..")));
    }
    public CounterRowInHome findCounterRowByCode(String counterCode)
    {
        return new CounterRowInHome(AreaOfCounterRows.findElement(AppiumBy.xpath(".//android.widget.TextView" +
                "[@resource-id='"+appPackage+":id/tvCounterCode' and @text='"+counterCode+"']/../../..")));
    }

    public void scrollToSeeWidget(String widgetName)
    {
        WebElement element = findWidgetByNameInCurrentView(widgetName);
        while (!isExistingOfAnElement(element)) // add more creteria to stop swipe
        {
            swipeGestureByElement(AreaOfAllWidget, "down", 1);
            element = findWidgetByNameInCurrentView(widgetName);
        }
        while (!isExistingOfAnElement(element)) // add more creteria to stop swipe
        {
            swipeGestureByElement(AreaOfAllWidget, "up", 1);
            element = findWidgetByNameInCurrentView(widgetName);
        }

        int x = AreaOfAllWidget.getLocation().x;
        int y = AreaOfAllWidget.getLocation().y;
        int width = AreaOfAllWidget.getSize().width;
        int height = element.getLocation().y - AreaOfAllWidget.getLocation().y;

        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform))
        {
            swipeGestureByCoodinator(x, y, width, height, "up", 1);
        }
        else
        {
//            scrollGestureByCoodinator(x, y, width, height, "down", 1);
            swipeGestureByElement(element, "up", 1);
        }
    }

    public void scrollToSeeWidgetWatchlist()
    {
        scrollToSeeWidget("Watchlist");
        waitForInvisibleWithExplicitWait(ProgressBar);
//        for (int i = 0; i< 5 ; i++ ) {
//            if(isExistingOfAnElement(TabLayoutWatchList)) break;
//            try {
//                waitForVisibilityWithExplicitWait(TabLayoutWatchList);
//            } catch (Exception e) {
//
//            }
//        }
    }

    public void clickOnWatchlistGroup(String watchlistGroup) {
        waitForVisibilityWithExplicitWait(AreaOfCounterRows);
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform))
            clickWithExplicitWait(TabLayoutWatchList.findElement(AppiumBy.xpath("//android.widget.TextView[@text='"+watchlistGroup+"']")));
        else {
            WebElement tab = TabLayoutWatchList.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name='" + watchlistGroup + "']"));
            clickWithExplicitWait(tab);
        }
        waitForInvisibleWithExplicitWait(ProgressBar);
        iCloseNotification();
    }


    public void clickOnWidget(String widgetName)
    {
        clickWithExplicitWait(findWidgetByNameInCurrentView(widgetName));
    }

    public void openWatchlistDetail()
    {
        clickWithExplicitWait(WatchlistWidgetMoveDetail);
    }
    @Override
    public void waitForFullDisplayOFAPage()
    {
        waitForVisibilityWithExplicitWait(Home);
    }
}
