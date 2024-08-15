package com.qa.pages.counter;

import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Date;
import java.util.List;

public class CounterRowInWatchListScrollableHorizontal extends CounterRow {

    int index;
    public CounterRowInWatchListScrollableHorizontal(WebElement counterRow, int rowIndex)
    {
        super(counterRow);
        index = rowIndex;
    }
    @AndroidFindBy(id = appPackage+":id/rvCountersPriceChart")
    @iOSXCUITFindBy(xpath = "later")
    public WebElement CountersPriceChart;

    @AndroidFindBy(id = appPackage+":id/rvCountersPmpFields")
    @iOSXCUITFindBy(xpath = "later")
    public WebElement CountersPmpFields;

    @AndroidFindBy(id = appPackage+":id/llContainerCountersFieldsHeader")
    @iOSXCUITFindBy(xpath = "later")
    public WebElement CountersFieldsHeader;

    @AndroidFindBy(id = appPackage+":id/svhCountersPmpFields")
    @iOSXCUITFindBy(xpath = "later")
    public WebElement CountersPmpFieldsTable;

    @Override
    public WebElement getCounterName()
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            return findElementByXpath(parent, "//android.widget.TextView[@resource-id='"+appPackage+":id/tvProductName']");
        }
        else
            return null;
    }
    @Override
    public WebElement getCounterType()
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
             return findElementByXpath(parent, "//android.widget.TextView[@resource-id='"+appPackage+":id/tvProductCounter']");
        }
        else
            return null;
    }
    @Override
    public WebElement getCounterCode()
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            return findElementByXpath(parent, "//android.widget.TextView[@resource-id='"+ appPackage + ":id/tvSymbolDisplay']");
        }
        else
            return null;
    }
    @Override
    public WebElement getDelayImg()
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            return findElementByXpath(parent, "//android.widget.ImageView[@resource-id='"+appPackage+":id/imgDelay']");
        }
        else
            return null;
    }

    @Override
    public WebElement getFractionalShareIndicator()
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            return findElementByXpath(parent, "//android.widget.ImageView[@resource-id='"+appPackage+":id/fractionalShareIndicator']");
        }
        else
            return null;
    }
    //android.widget.ImageView[@resource-id="com.tdt.pmobile3.p2:id/fractionalShareIndicator"]
    @Override
    public WebElement getChartImg()
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
//            return CountersPriceChart.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id='"
//                    +appPackage+":id/lineHistoryChartCounterItem'])["+(index + 1) +"]"));
            return findElementByXpath(CountersPriceChart, "(//android.view.ViewGroup[@resource-id='"
                    +appPackage+":id/lineHistoryChartCounterItem'])["+(index + 1) +"]");
        }
        else
            return null;
    }
    @Override
    public WebElement getFirstLabel()
    {
        int indexOfBid = scrollToFindColumn("Bid");
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            return CountersPmpFields.findElement(AppiumBy.xpath("(.//android.widget.LinearLayout" +
                    "[@resource-id='"+appPackage+":id/llRootView'])["+(index + 1) +"]")).findElement(AppiumBy
                    .xpath("(.//android.widget.TextView[@resource-id='"
                            +appPackage+":id/tvPrimaryCounterField'])["+(indexOfBid+1)+"]"));
        }
        else
            return null;
    }
    @Override
    public WebElement getSecondLabel()
    {
        int indexOfAsk = scrollToFindColumn("Ask");
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            return CountersPmpFields.findElement(AppiumBy.xpath("(.//android.widget.LinearLayout" +
                    "[@resource-id='"+appPackage+":id/llRootView'])["+(index + 1) +"]")).findElement(AppiumBy
                    .xpath("(.//android.widget.TextView[@resource-id='"
                            +appPackage+":id/tvPrimaryCounterField'])["+(indexOfAsk+1)+"]"));
        }
        else
            return null;
    }

    @Override
    public WebElement getLastDonePrice()
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            return CountersPriceChart.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id='"
                    +appPackage+":id/tvPrimaryCounterField'])["+(index + 1) +"]"));
        }
        else
            return null;
    }

    public WebElement getChange()
    {
        int indexOfChange = scrollToFindColumn("Change");
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            try {
               return CountersPmpFields.findElement(AppiumBy.xpath("(.//android.widget.LinearLayout" +
                        "[@resource-id='" + appPackage + ":id/llRootView'])[" + (index + 1) + "]")).findElement(AppiumBy
                        .xpath("(.//android.widget.TextView[@resource-id='"
                                + appPackage + ":id/tvSecondCounterField'])[" + (indexOfChange + 1) + "]"));
            }
            catch (Exception ex)
            {
                return null;
            }
        }
        else
            return null;
    }

    @Override
    public WebElement getChangePercent()
    {
        int indexOfChangePCT = scrollToFindColumn("Change %");
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            try {
                return CountersPmpFields.findElement(AppiumBy.xpath("(.//android.widget.LinearLayout" +
                        "[@resource-id='" + appPackage + ":id/llRootView'])[" + (index + 1) + "]")).findElement(AppiumBy
                        .xpath("(.//android.widget.TextView[@resource-id='"
                                + appPackage + ":id/tvSecondCounterField'])[" + (indexOfChangePCT + 1) + "]"));
            }
            catch (Exception e)
            {return null;}
        }
        else
            return null;
    }

    public int scrollToFindColumn(String columnName)
    {
        int index = findIndexColumnOfHorizontalScrollView(columnName);
        WebElement element = horizontalToFindElementByName(columnName,CountersPmpFieldsTable);
        if(element!= null)
        {
            return findIndexColumnOfHorizontalScrollView(columnName);
        }

        return index;
    }

    private List<WebElement> getColumnOfCountersPmpFieldsTable()
    {
        return CountersPmpFieldsTable.findElements(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id='"
                +appPackage+":id/llContainerCountersFieldsHeader']/android.widget.TextView"));
    }
    public int findIndexColumnOfHorizontalScrollView(String columnName)
    {
        int index = -1;
        List<WebElement> columns = getColumnOfCountersPmpFieldsTable();
        for (int i = 0; i < columns.size(); i++)
        {
            if(columns.get(i).getText().equalsIgnoreCase(columnName))
            {
                index = i;
                break;
            }
        }
        return index;
    }
    @Override
    public void verifyValueOfFirstLabel(String firstLabel, String showPrePostOption, String counterType,
                                        Date currentTime, Date startTradeTime, Date endTradeTime)
    {
        switch(counterType)
        {
            case "CFD":
                if ((currentTime.after(startTradeTime) & currentTime.before(endTradeTime)))
                {
                    Assert.assertFalse(getFirstLabel().getText().equalsIgnoreCase(""), "expect empty but display " + getFirstLabel().getText());
                }
                else
                    Assert.assertFalse(getFirstLabel().getText().equalsIgnoreCase(""),"no data for BID");
                break;
            default:
                if(firstLabel.equalsIgnoreCase("not empty"))
                    Assert.assertFalse(getFirstLabel().getText().equalsIgnoreCase(""));
                else Assert.assertTrue(getFirstLabel().getText().equalsIgnoreCase(firstLabel));
                break;
        }
    }

    @Override
    public void verifyValueOfSecondLabel(String secondLabel, String isShowReAndPost, String counterType,
                                         Date currentTime, Date startTradeTime, Date endTradeTime)
    {
        if(secondLabel.equalsIgnoreCase("not empty"))
            Assert.assertFalse(getSecondLabel().getText().equalsIgnoreCase(""));
        else Assert.assertTrue(getSecondLabel().getText().equalsIgnoreCase(secondLabel));

    }

    public void verifyValueOfChangePCT(String changePCT, String isShowReAndPost, String counterType,
                                       Date currentTime, Date startTradeTime, Date endTradeTime) {
        switch (counterType) {
            case "CFD":
                if (isShowReAndPost.equalsIgnoreCase("true")) {
                    if (getCounterCode().getText().contains("AGG") ||
                            getCounterCode().getText().contains("BTI") ||
                            getCounterCode().getText().contains("DBA") ||
                            getCounterCode().getText().contains("ITF") ||
                            getCounterCode().getText().contains("AAPL") ||
                            getCounterCode().getText().contains("MCD")) {
                        if ((currentTime.after(startTradeTime) & currentTime.before(endTradeTime))) {
                            Assert.assertTrue(getChangePercent().getText().contains("PRE"), " not show Pre");
                        }
//                    else Assert.assertFalse(getChangePercent().getText().equalsIgnoreCase(""), "no data for ASK");
                    }
                } else {
//                    if (changePCT.equalsIgnoreCase("not empty"))
//                        Assert.assertFalse(getChangePercent().getText().equalsIgnoreCase(""), "no data for ASK");
//                    else Assert.assertTrue(getChangePercent().getText().equalsIgnoreCase(changePCT));
                    Assert.assertTrue(!isExistingOfAnElement(getChange()));
                }
                break;
            default:
                if (changePCT.equalsIgnoreCase("not empty"))
                    Assert.assertFalse(getChangePercent().getText().equalsIgnoreCase(""));
                else Assert.assertTrue(getChangePercent().getText().equalsIgnoreCase(changePCT));
                break;
        }
    }

    @Override
    public void verifyValueOfChange(String Change, String isShowReAndPost, String counterType,
                                       Date currentTime, Date startTradeTime, Date endTradeTime) {
        switch (counterType) {
            case "CFD":
                if (isShowReAndPost.equalsIgnoreCase("true")) {
                    if (getCounterCode().getText().contains("AGG") ||
                            getCounterCode().getText().contains("BTI") ||
                            getCounterCode().getText().contains("DBA") ||
                            getCounterCode().getText().contains("ITF") ||
                            getCounterCode().getText().contains("AAPL") ||
                            getCounterCode().getText().contains("MCD")) {
                        if ((currentTime.after(startTradeTime) & currentTime.before(endTradeTime))) {
                            Assert.assertTrue(getChange().getText().contains("PRE"), " not show Pre");
                        }
//                    else Assert.assertFalse(getSecondLabel().getText().equalsIgnoreCase(""), "no data for ASK");
                    }
                }
                else {
//                    if (Change.equalsIgnoreCase("not empty"))
//                        Assert.assertFalse(getChange().getText().equalsIgnoreCase(""), "no data for ASK");
//                    else Assert.assertTrue(getChange().getText().equalsIgnoreCase(Change));
                      Assert.assertTrue(!isExistingOfAnElement(getChange()));
                }
                break;
            default:
                if (Change.equalsIgnoreCase("not empty"))
                    Assert.assertFalse(getChange().getText().equalsIgnoreCase(""));
                else Assert.assertTrue(getChange().getText().equalsIgnoreCase(Change));
                break;
        }
    }
}
