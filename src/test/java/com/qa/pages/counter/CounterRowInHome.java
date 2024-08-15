package com.qa.pages.counter;

import com.qa.pages.BasePage;
import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Date;

public class CounterRowInHome extends CounterRow {
    public CounterRowInHome(WebElement counterRow) {
        super(counterRow);
    }
    @Override
    public WebElement getCounterName()
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            return findElementByXpath(parent, "//android.widget.TextView[@resource-id='" + appPackage + ":id/tvCounterName']");
        }
        else
            return findElementByXpath(parent, "//XCUIElementTypeStaticText[@name='COUNTER_NAME']");
    }
    @Override
    public WebElement getCounterType()
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            return  findElementByXpath(parent, "//android.widget.TextView[@resource-id='" + appPackage + ":id/tvCounterIcon']");
       }
        else
            return findElementByXpath(parent, "//XCUIElementTypeStaticText[@name='COUNTER_TYPE']");
    }
    @Override
    public WebElement getCounterCode()
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            return findElementByXpath(parent, "//android.widget.TextView[@resource-id='" + appPackage + ":id/tvCounterCode']");
        }
        else
            return findElementByXpath(parent, "//XCUIElementTypeStaticText[@name='COUNTER_CODE']");
    }
    @Override
    public WebElement getDelayImg()
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            return findElementByXpath(parent, "//android.widget.ImageView[@resource-id='" + appPackage + "id/imgDelay']");
          }
        else
            return findElementByXpath(parent, "//XCUIElementTypeImage[@name='ICON_DELAY']");
    }
    public WebElement getFractionalShareIndicator()
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            return findElementByXpath(parent, "//android.widget.ImageView[@resource-id='" + appPackage + "id/fractionShareIndicator']");
        }
        else
            return findElementByXpath(parent, "//XCUIElementTypeStaticText[@name='ICON_FRACTIONAL']");
    }
    @Override
    public WebElement getChartImg()
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            return findElementByXpath(parent, "//android.view.ViewGroup[@resource-id='"+appPackage+":id/lineChartCounter']");
        }
        else
            return findElementByXpath(parent, "//XCUIElementTypeOther");
    }
    @Override
    public WebElement getFirstLabel()
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            return findElementByXpath(parent, "//androidx.appcompat.widget.LinearLayoutCompat[@resource-id='"
                    + appPackage +":id/tvFirstLabel']/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView");
        }
        else
            return findElementByXpath(parent, "//XCUIElementTypeStaticText[@name='TOP_LABEL']");
    }
    @Override
    public WebElement getSecondLabel()
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            return findElementByXpath(parent, "//androidx.appcompat.widget.LinearLayoutCompat[@resource-id='"+
                    appPackage + ":id/tvSecondLabel']/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView");
        }
        else
            return findElementByXpath(parent, "//XCUIElementTypeStaticText[@name='BOTTOM_LABEL']");
    }

    @Override
    public WebElement getLastDonePrice()
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            return findElementByXpath(parent, "//androidx.appcompat.widget.LinearLayoutCompat[@resource-id='"
                    + appPackage + ":id/pmpFirstData']/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.TextView");
           }
        else
            return findElementByXpath(parent, "//XCUIElementTypeStaticText[@name='TOP_PRICE']");
    }
    @Override
    public WebElement getChangePercent()
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            return findElementByXpath(parent, "//androidx.appcompat.widget.LinearLayoutCompat[@resource-id='"
                    + appPackage + ":id/pmpSecondData']/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.TextView");
            }
        else
            return findElementByXpath(parent, "//XCUIElementTypeStaticText[@name='BOTTOM_PRICE']");
    }
}
