package com.qa.pages.counter;

import com.qa.pages.CommonContentPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class CounterDetail extends CommonContentPage {
    @AndroidFindBy(id = appPackage+":id/vppCounterDetail")
    @iOSXCUITFindBy(accessibility = "Quotes")
    public WebElement CounterDetail;

    @AndroidFindBy(id = appPackage+":id/llTopCounter")
    @iOSXCUITFindBy(xpath = "dadada")
    public WebElement TopCounter;

    @AndroidFindBy(id = appPackage+":id/ivBackCounterDetail")
    @iOSXCUITFindBy(xpath = "dadad")
    public WebElement BackBtn;

    @Override
    public void waitForFullDisplayOFAPage()
    {
        waitForVisibilityWithExplicitWait(CounterDetail);
    }

    public void verifyTheDisplayOfPage( String expected)
    {
        verifyTheDisplayOfPage(CounterDetail, "CounterDetail screen", expected);
    }
}
