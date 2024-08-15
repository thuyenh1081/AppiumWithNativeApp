package com.qa.pages.community;

//import io.appium.java_client.MobileElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class Community_Group_GroupsYouJoined_Page extends Community_Group_YourGroups_Page {

    @AndroidFindBy(id = "fill later")
    @iOSXCUITFindBy(accessibility = "Groups You Joined")
    private WebElement GroupsYouJoined;
}
