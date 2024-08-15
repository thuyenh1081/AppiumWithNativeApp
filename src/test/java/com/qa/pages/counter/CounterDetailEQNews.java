package com.qa.pages.counter;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class CounterDetailEQNews extends CounterDetailEQ {
    @AndroidFindBy(id = appPackage+":id/vppCounterDetail")
    @iOSXCUITFindBy(xpath = "dadd")
    public WebElement CounterDetail;

    @AndroidFindBy(id = appPackage+":id/llTopCounter")
    @iOSXCUITFindBy(xpath = "dadada")
    public WebElement TopCounter;

    @AndroidFindBy(id = appPackage+":id/ivBackCounterDetail")
    @iOSXCUITFindBy(xpath = "dadad")
    public WebElement BackBtn;

//    public void tabOnBackBtn()
//    {
//        clickWithExplicitWait(BackBtn);}

}
