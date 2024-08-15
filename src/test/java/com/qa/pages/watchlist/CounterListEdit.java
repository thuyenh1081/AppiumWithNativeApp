package com.qa.pages.watchlist;

import com.qa.pages.CommonContentPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class CounterListEdit extends CommonContentPage {

    @AndroidFindBy(id = appPackage+":id/imageBack")
    @iOSXCUITFindBy(xpath = "dadasd")
    private WebElement BackImg;

//    public void tabOnBackBtn()
//    {
//        clickWithExplicitWait(BackImg);}
}
