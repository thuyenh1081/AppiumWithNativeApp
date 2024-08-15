package com.qa.pages.community;

//import io.appium.java_client.MobileElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class Community_Group_YourGroups_Page extends Community_Group_Page {

    @AndroidFindBy(id = "fill later")
    @iOSXCUITFindBy(accessibility = "Browse Groups")
    private WebElement BrowseGroups;
}
