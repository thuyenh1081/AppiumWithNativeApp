package com.qa.pages.counter;

import com.qa.entity.Counter;
import com.qa.pages.BasePage;
import com.qa.pages.CommonContentPage;
import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CounterRow extends CommonContentPage {

    WebElement parent;
    public CounterRow(WebElement counterRow)
    {
        parent = counterRow;
    }
    public WebElement getCounterName()
    {
        return null;
    }
    public WebElement getCounterType()
    {
            return null;
    }
    public WebElement getCounterCode()
    {
        return null;
    }
    public WebElement getDelayImg()
    {
            return null;
    }
    public WebElement getFractionalShareIndicator()
    {
        return null;
    }
    public WebElement getChartImg()
    {
        return null;
    }
    public WebElement getFirstLabel()
    {
        return null;
    }
    public WebElement getSecondLabel()
    {
        return null;
    }

    public WebElement getLastDonePrice()
    {
        return null;
    }
    public WebElement getChangePercent()
    {
        return null;
    }

    public void verifyValueOfCounterName(String expectName)
    {
        if(expectName.equalsIgnoreCase("not empty"))
            Assert.assertFalse(getCounterName().getText().equalsIgnoreCase(""));
        else Assert.assertTrue(getCounterName().getText().equalsIgnoreCase(expectName));
    }

    public void verifyValueOfCounterType(String expectedType)
    {
        if(expectedType.equalsIgnoreCase("not empty"))
            Assert.assertFalse(getCounterType().getText().equalsIgnoreCase(""));
        else Assert.assertTrue(getCounterType().getText().equalsIgnoreCase(expectedType));
    }

    public void verifyValueOfCounterCode(String expectedCode)
    {
        if(expectedCode.equalsIgnoreCase("not empty"))
            Assert.assertFalse(getCounterCode().getText().equalsIgnoreCase(""));
        else Assert.assertTrue(getCounterCode().getText().equalsIgnoreCase(expectedCode));
    }
    public void verifyValueOfCounterChart(String counterChart)
    {
        if(counterChart.equalsIgnoreCase("empty"))
            Assert.assertFalse(isExistingOfAnElement(getChartImg()));
        else Assert.assertTrue(isExistingOfAnElement(getChartImg()));
    }

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
                            Assert.assertTrue(!isExistingOfAnElement(getFirstLabel()), "expect empty but NOT empty ");
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


    public void verifyValueOfSecondLabel(String secondLabel, String isShowReAndPost, String counterType,
                                         Date currentTime, Date startTradeTime, Date endTradeTime)
    {
        switch(counterType)
        {
            case "CFD":
                if(isShowReAndPost.equalsIgnoreCase("true")) {
                    if (getCounterCode().getText().contains("AGG") ||
                            getCounterCode().getText().contains("BTI") ||
                            getCounterCode().getText().contains("DBA") ||
                            getCounterCode().getText().contains("ITF") ||
                            getCounterCode().getText().contains("AAPL") ||
                            getCounterCode().getText().contains("MCD")) {
                        if ((currentTime.after(startTradeTime) & currentTime.before(endTradeTime))) {
                            Assert.assertTrue(getSecondLabel().getText().contains("PRE"), " not show Pre");
                        } else
                            Assert.assertTrue(getSecondLabel().getText().equalsIgnoreCase("ASK"), "value is not ASK");
                    }
                }
                else
                {
//                    if(secondLabel.equalsIgnoreCase("not empty"))
//                        Assert.assertFalse(getSecondLabel().getText().equalsIgnoreCase(""));
//                    else Assert.assertTrue(getSecondLabel().getText().equalsIgnoreCase(secondLabel));
                     Assert.assertTrue(getSecondLabel().getText().equalsIgnoreCase("ASK"),"value is not ASK");
                }
                break;
            default:
                if(secondLabel.equalsIgnoreCase("not empty"))
                    Assert.assertFalse(getSecondLabel().getText().equalsIgnoreCase(""));
                else Assert.assertTrue(getSecondLabel().getText().equalsIgnoreCase(secondLabel));
                break;
        }

    }

    public void verifyValueOfLastDonePrice(String lastDonePrice)
    {
        if(lastDonePrice.equalsIgnoreCase("not empty"))
            Assert.assertFalse(getLastDonePrice().getText().equalsIgnoreCase(""));
        else Assert.assertTrue(getLastDonePrice().getText().equalsIgnoreCase(lastDonePrice));
    }

    public void verifyValueOfChangePCT(String changePCT, String isShowReAndPost, String counterType,
                                       Date currentTime, Date startTradeTime, Date endTradeTime)
    {
        if(changePCT.equalsIgnoreCase("not empty"))
            Assert.assertFalse(getChangePercent().getText().equalsIgnoreCase(""));
        else Assert.assertTrue(getChangePercent().getText().equalsIgnoreCase(changePCT));
    }
    public void verifyValueOfChange(String change, String isShowReAndPost, String counterType,
                                   Date currentTime, Date startTradeTime, Date endTradeTime)
    {}
}
