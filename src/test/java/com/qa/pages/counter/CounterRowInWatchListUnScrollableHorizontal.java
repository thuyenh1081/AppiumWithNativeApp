package com.qa.pages.counter;

import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Date;

public class CounterRowInWatchListUnScrollableHorizontal extends CounterRow {

    public CounterRowInWatchListUnScrollableHorizontal(WebElement counterRow)
    {
        super(counterRow);
    }

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
    public WebElement getChartImg()
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            return findElementByXpath(parent, "//android.view.ViewGroup[@resource-id='" + appPackage + ":id/lineHistoryChartCounterItem']");
        }
        else
            return null;
    }
    @Override
    public WebElement getFirstLabel()
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
             return findElementByXpath(parent, "//androidx.appcompat.widget.LinearLayoutCompat[@resource-id='"
                     + appPackage+":id/pricePMPField']/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView");
        }
        else
            return null;
    }
    @Override
    public WebElement getSecondLabel()
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            return findElementByXpath(parent, "//androidx.appcompat.widget.LinearLayoutCompat[@resource-id='"
                        +appPackage+":id/pctChangePMPField']/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView");
        }
        else
            return null;
    }

    @Override
    public WebElement getLastDonePrice()
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            return findElementByXpath(parent, "//androidx.appcompat.widget.LinearLayoutCompat[@resource-id='"
                        +appPackage+":id/pricePMPField']/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.TextView");
        }
        else
            return null;
    }

    @Override
    public WebElement getChangePercent()
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            return findElementByXpath(parent, "//androidx.appcompat.widget.LinearLayoutCompat[@resource-id='"
                        +appPackage+":id/pctChangePMPField']/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.TextView");
        }
        else
            return null;
    }
    @Override
    public void verifyValueOfFirstLabel(String firstLabel,String showPrePostOption, String counterType,
                                        Date currentTime, Date startTradeTime, Date endTradeTime)
    {
        switch(counterType)
        {
            case "CFD":
                if(showPrePostOption.equalsIgnoreCase("true")) {
                    if (getCounterCode().getText().contains("AGG") ||
                            getCounterCode().getText().contains("BTI") ||
                            getCounterCode().getText().contains("DBA") ||
                            getCounterCode().getText().contains("ITF") ||
                            getCounterCode().getText().contains("AAPL") ||
                            getCounterCode().getText().contains("MCD")) {
                        if ((currentTime.after(startTradeTime) & currentTime.before(endTradeTime))) {
                            Assert.assertFalse(getFirstLabel().getText().equalsIgnoreCase(""), "expect non empty but display " + getFirstLabel().getText());
                        } else
                            Assert.assertTrue(getFirstLabel().getText().equalsIgnoreCase("BID"), "value is not BID");
                    }
                }
                else
                    Assert.assertTrue(getFirstLabel().getText().equalsIgnoreCase("BID"), "value is not BID");
                break;
            default:
                if(firstLabel.equalsIgnoreCase("not empty"))
                    Assert.assertFalse(getFirstLabel().getText().equalsIgnoreCase(""));
                else Assert.assertTrue(getFirstLabel().getText().equalsIgnoreCase(firstLabel));
                break;
        }
    }
}
