package com.qa.pages.watchlist;

//import io.appium.java_client.MobileElement;

import com.qa.entity.Counter;
import com.qa.pages.counter.CounterRow;
import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.*;

public class WatchlistGroup extends WatchlistModulePage {
    public WatchlistGroup()
    {
    }
    public WatchlistGroup(Boolean isCheckPopup)
    {
        super(isCheckPopup);
//        waitForVisibilityWithExplicitWait(CounterTableDefault);
    }
    @AndroidFindBy(id = appPackage+":id/ivRotateScreenWatchList")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'BTN_ROTATE_PORTRAIT'")
    private WebElement RotateScreenWatchList;

    @AndroidFindBy(id = appPackage+":id/ivEditWatchList")
    @iOSXCUITFindBy(xpath= "//XCUIElementTypeButton[@name='BTN_ROTATE_PORTRAIT']/following-sibling::XCUIElementTypeButton[1]")
    private WebElement EditWatchList;

    @AndroidFindBy(id = appPackage+":id/ivShowChartWatchList")
    @iOSXCUITFindBy(xpath= "//XCUIElementTypeButton[@name='BTN_ROTATE_PORTRAIT']/following-sibling::XCUIElementTypeButton[2]")
    private WebElement ShowChartWatchList;

    @AndroidFindBy(id = appPackage+":id/ivScrollableHorizontal")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'ic_horizontal_scroll'")
    private WebElement ScrollableHorizontal;

//    @AndroidFindBy(id = appPackage+":id/ivSettingWatchList")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='"+appPackage+":id/containerWatchList']//android.view.ViewGroup[@resource-id='"
            +appPackage+":id/layoutData']//android.widget.RelativeLayout[@resource-id='"+appPackage+":id/iclSwitchMode']/" +
        "android.widget.ImageView[@resource-id='"+appPackage+":id/ivSettingWatchList']")
    @iOSXCUITFindBy(xpath= "(//XCUIElementTypeButton[@name='ic_setting'])[2]")
    private WebElement SettingWatchList;

    @AndroidFindBy(id = appPackage+":id/btnAddCounter")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Add Counter'")
    private WebElement AddCounterBtn;

    @AndroidFindBy(id = appPackage+":id/tvNameColumn")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Name']")
    private WebElement NameColumn;


    @AndroidFindBy(id = appPackage+":id/iclPricePortrait")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Price']")
    private WebElement ColumnPrice;

    @AndroidFindBy(id = appPackage+":id/hscPmpAndPriceChart")
    @iOSXCUITFindBy(accessibility = "later")
    private WebElement ColumnPriceChart;

    @AndroidFindBy(id = appPackage+":id/svhCountersPmpFields")
    @iOSXCUITFindBy(xpath = "later")
    private WebElement ScrollableHorizontalArea;

    @AndroidFindBy(id = appPackage+":id/rvCountersNamePortrait")
    @iOSXCUITFindBy(className = "XCUIElementTypeCollectionView")
    public WebElement CounterTableDefault;

    @AndroidFindBy(id = appPackage+":id/layoutData")
    @iOSXCUITFindBy(className = "later")
    public WebElement LayoutData;

    public void tapOnRotateIcon() {
        clickWithExplicitWait(RotateScreenWatchList);
    }

    public void tapOnEditIcon() {
        clickWithExplicitWait(EditWatchList);
    }

    public void turnOnChart() {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            if (!isExistingOfAnElement(ColumnPriceChart))
                clickWithExplicitWait(ShowChartWatchList);
        }
        else  clickWithExplicitWait(ShowChartWatchList);
        iCloseNotification();
    }
    public void turnOffChart() {
        if(isExistingOfAnElement(ColumnPriceChart))
            clickWithExplicitWait(ShowChartWatchList);
    }
    public void turnOnScrollableHorizontalIcon() {
        if(!isExistingOfAnElement(ScrollableHorizontalArea)) {
            clickWithExplicitWait(ScrollableHorizontal);
            waitForVisibilityWithExplicitWait(ScrollableHorizontalArea);
        }
        iCloseNotification();
    }
    public void turnOffScrollableHorizontalIcon() {
        if(isExistingOfAnElement(ScrollableHorizontalArea))
            clickWithExplicitWait(ScrollableHorizontal);
    }
    public WatchListSetting tapOnSettingIcon() {
        System.out.println("start clicking on Setting icon: " + utils.dateTime());
        clickWithExplicitWait(SettingWatchList);
        System.out.println("end clicking on Setting icon: " + utils.dateTime());

        return new WatchListSetting(true);
    }

    public void tapOnColumnName() {
        clickWithExplicitWait(NameColumn);
    }

    public void tapOnColumnChart() {
        clickWithExplicitWait(ColumnPrice);
    }

//    @Override
//    public void waitForTheDisplayOfThePage()
//    {
//        super.waitForTheDisplayOfThePage();
//        waitForVisibilityWithExplicitWait(SettingWatchList);
//    }



    public void scrollWatchlistToSeeAddbtn() {
        while (!isExistingOfAnElement(AddCounterBtn)) {
            scrollScreen("down");
        }
    }

    public void scrollWatchlistToSeeCounterType(String counterType)
    {   WebElement row  = getCounterByType(counterType);
        while (!isExistingOfAnElement(AddCounterBtn)& (row == null)) {
            scrollScreen("down");
            row = getCounterByType(counterType);
            if (row != null) break;
        }
    }
    public void scrollWatchlistToSeeCounterName(String counterName)
    {   WebElement row  = getCounterByName(counterName);
        while (!isExistingOfAnElement(AddCounterBtn)& (row == null)) {
            scrollScreen("down");
            row = getCounterByName(counterName);
            if (row != null) break;
        }
    }
    public void tapOnACounterRowSearchByType(String counterType) {
        clickWithExplicitWait(getCounterByType(counterType));
    }

    public void tapOnACounterRowSearchByName(String counterName) {
        clickWithExplicitWait(getCounterByName(counterName));
    }

    public void swipeWatchlistToSeeAddbtn() throws InterruptedException {
        while (!isExistingOfAnElement(AddCounterBtn)) {
//            driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
////                "left", 100, "top", 100, "width", 200, "height", 1000,
//                    "elementId", ((RemoteWebElement) CounterTableDefault).getId(),
//                    "direction", "up",
//                    "percent", 1
//            ));
            swipeGestureByElement(CounterTableDefault, "up", 1);
            }
    }

    public void OpenWatchlistToSeeCounterDetail(int index) {
        clickWithExplicitWait(getCounterRow(index));
    }

    private List<WebElement> getListOfVisibleCounterRow() {
        return CounterTableDefault.findElements(AppiumBy.className("android.view.ViewGroup"));
    }


    private HashMap<Integer, WebElement> getCounterRow(String searchBy, String value) {
        WebElement e1 = null;
        HashMap<Integer, WebElement> values = new HashMap<Integer, WebElement>();
        List<WebElement> rows = listOfCounter();
        int size = rows.size();
        for(int i= 0; i< size; i++)
        {
            try {
                if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
                    switch (searchBy) {
                        case "name":
                            e1 = rows.get(i).findElement(AppiumBy.xpath(".//android.widget.TextView[@resource-id='"+appPackage+":id/tvProductName' and contains(@text,'" + value + "')]"));
                            break;
                        case "type":
                            e1 = rows.get(i).findElement(AppiumBy.xpath(".//android.widget.TextView[@resource-id='"+appPackage+":id/tvProductCounter' and @text='" + value + "']"));
                            break;
                        default:
                            break;
                    }
                }
                else
                {
                    switch (searchBy) {
                        case "name":
                            e1 = rows.get(i).findElement(AppiumBy.xpath(".//XCUIElementTypeStaticText[@name='"+value+"']"));
                            break;
                        case "type":
                            e1 = rows.get(i).findElement(AppiumBy.accessibilityId(value));
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception ex) {
                e1 = null;
            }
            if(e1 != null) {
                values.put(i, rows.get(i));
                return values;
            }
        }
        return null;
    }
    public HashMap<Integer, WebElement> getCounterRowByName(String value) {
        return getCounterRow("name", value);
    }
    public HashMap<Integer, WebElement> getCounterRowByType(String value) {
        return getCounterRow("type", value);
    }
    public WebElement getCounterByName(String value)
    {
        return getTheFirstWebElementOfAMap(getCounterRowByName(value));
    }

    public WebElement getCounterByType(String value)
    {
        return getTheFirstWebElementOfAMap(getCounterRowByType(value));
    }
    public List<WebElement> listOfCounter() {
        waitForVisibilityWithExplicitWait(CounterTableDefault);
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform))
        return CounterTableDefault.findElements(AppiumBy.className("android.view.ViewGroup"));
        else return CounterTableDefault.findElements(AppiumBy.className("XCUIElementTypeCell"));

    }

    public WebElement getCounterRow(int index) {
        // qua index trả về row
        List<WebElement> e = listOfCounter();
        WebElement el = e.get(index);
        return el;
    }

    private int getIndexOfRow(String counterName)
    {
        return getKeyOfMap(getCounterRowByName(counterName));
    }

    public void clickAddBtn() {
        clickWithExplicitWait(AddCounterBtn);
    }

    public void verifyNumberOfCounter(int numberOfCounter) {
        int actual = listOfCounter().size();
        while (!isExistingOfAnElement(AddCounterBtn)) {
            scrollScreen("down");
            actual = actual + listOfCounter().size();
        }
        Assert.assertEquals(actual, numberOfCounter, "The expected counter is " + numberOfCounter
                + "but actual is :" + actual);
    }

    private String getCounterName(WebElement counterRow) {
        try {
            return counterRow.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='"+appPackage+":id/tvProductName']")).getText();
        }
        catch(Exception e)
        {
            System.out.println("could not get counterName");
        }
        return "";
    }

    public void reloadPage()
    {
        scrollGestureByElement(new WatchlistGroup().CounterTableDefault,"up",1);
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
        return verticalToGetAllName(CounterTableDefault,xpathToGetRow, xpathToGetName,xpathToGetElements);
        ////////
//        List<String> list = new ArrayList<String>();
//        int size = listOfCounter().size();
//
//        String nameOfPreviousLast = "   ";
//        String nameOflast = getCounterName(getCounterRow(size - 1));
//        while (!nameOflast.equalsIgnoreCase(nameOfPreviousLast)) {
//            String nameOfFirstOne = getCounterName(getCounterRow(0));
//            if(!nameOfFirstOne.equals(nameOfPreviousLast) & nameOfFirstOne != "")
//            {
//                list.add(nameOfFirstOne);
//            }
//            if (getTheFirstWebElementOfAMap(getCounterRowByName(nameOfPreviousLast)) == null) {
//                for (int i = 1; i < size-1; i++) {
//                    list.add(getCounterName(getCounterRow(i)));
//                }
//            } else {
//                int indexOfLast = getIndexOfRow(nameOfPreviousLast);
//                for (int i = indexOfLast + 1; i < size-1; i++) {
//                    list.add(getCounterName(getCounterRow(i)));
//                }
//            }
//            WebElement lastRow = getCounterRow(size - 1);
//            nameOflast = getCounterName(lastRow);
//            if(nameOflast != "")
//            {
//                list.add(nameOflast);
//                nameOfPreviousLast = nameOflast;
//            }
//            else {
//                nameOfPreviousLast = getCounterName(getCounterRow(size-2));
//            }
//            scrollGestureByElement(CounterTableDefault, "down", 1);
//
//            size = listOfCounter().size();
//            nameOflast = getCounterName(getCounterRow(size - 1));
//        }
//        return list;
    }
    public Counter getValueOfACounter(CounterRow counterRow)
    {
        Counter counter = new Counter();

        counter.setCounterType(getText(counterRow.getCounterType()));
        counter.setCounterName(getText(counterRow.getCounterName()));
        counter.setCounterCode(getText(counterRow.getCounterCode()));
//        if(counterRow.getDelayImg() != null) counter.setDelayImg("true");
//        else counter.setDelayImg("false");
        if(counterRow.getChartImg() != null) counter.setChartImg("true");
        else counter.setChartImg("false");
        counter.setFirstLabel(getText(counterRow.getFirstLabel()));
        counter.setSecondLabel(getText(counterRow.getSecondLabel()));
        counter.setLastDonePrice(getText(counterRow.getLastDonePrice()));
        counter.setChangePercent(getText(counterRow.getChangePercent()));

        return counter;
    }
    public void verifyValueOfCounter(Counter counter)
    {
        String counterType = counter.getCounterType();
        switch (counterType)
        {
            case "CFD":
                Assert.assertTrue(counter.getCounterType().equalsIgnoreCase("CFD"));
                Assert.assertFalse(counter.getCounterName().equalsIgnoreCase(""));
                Assert.assertFalse(counter.getCounterCode().equalsIgnoreCase(""));
//                Assert.assertTrue(counter.getDelayImg());
//                Assert.assertTrue(counter.getChartImg().equalsIgnoreCase("true"));
                Assert.assertFalse(counter.getFirstLabel().equalsIgnoreCase(""));

                Assert.assertFalse(counter.getSecondLabel().equalsIgnoreCase(""));

                Assert.assertFalse(counter.getLastDonePrice().equalsIgnoreCase(""));
                Assert.assertFalse(counter.getChangePercent().equalsIgnoreCase(""));
                break;
            case "BO":
                break;
            case "ETF":
                break;
            case "BOND":
                break;
            default:
                break;
        }
    }

    public Counter getValueOfACounterFindByCounterType(String counterType)
    {
        WebElement counterRow = getCounterByType(counterType);
        return getValueOfACounter(new CounterRow(counterRow));
    }
    public Counter getValueOfACounterFindByCounterName(String counterName)
    {
        WebElement counterRow = getCounterByName(counterName);
        return getValueOfACounter(new CounterRow(counterRow));
    }
    public void verifyValueOfCounterFindByCounterType(String counterType)
    {
        Counter counter = getValueOfACounterFindByCounterType(counterType);
        verifyValueOfCounter(counter);
    }
    public void verifyValueOfCounterFindByCounterName(String counterName)
    {
        Counter counter = getValueOfACounterFindByCounterName(counterName);
        verifyValueOfCounter(counter);
    }
    @Override
    public void waitForFullDisplayOFAPage()
    {
        waitForVisibilityWithExplicitWait(CounterTableDefault);
    }
}