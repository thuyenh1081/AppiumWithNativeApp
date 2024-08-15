package com.qa.pages.home;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class Widget extends HomeModulePage{
    @AndroidFindBy(id = "later")
    @iOSXCUITFindBy(xpath = "later")
    public WebElement Title;

    @AndroidFindBy(id = "later")
    @iOSXCUITFindBy(xpath = "later")
    public WebElement MoveDetailIcon;

    @AndroidFindBy(className = "android.widget.FrameLayout")
    @iOSXCUITFindBy(xpath = "later")
    public WebElement FrameLayout;
    //android.widget.FrameLayout[@resource-id=appPackage+":id/cvWatchListTab"]


}
