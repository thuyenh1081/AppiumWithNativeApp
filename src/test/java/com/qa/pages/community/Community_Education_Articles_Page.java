package com.qa.pages.community;

//import io.appium.java_client.MobileElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class Community_Education_Articles_Page extends Community_Education_Page {

    @AndroidFindBy(id = "need to fill")
    @iOSXCUITFindBy(accessibility = "Articles")
    private WebElement Articles;
}
