package com.qa.pages.community;

//import io.appium.java_client.MobileElement;

import com.qa.pages.CommonContentPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class Community_Common_Page extends CommonContentPage {

    @AndroidFindBy(id = appPackage+":id/btnAccountInfo")
    @iOSXCUITFindBy(xpath = "dadasdsad")
    private WebElement AccountInfoIcon;

    @AndroidFindBy(id = appPackage+":id/fbPostYourWall")
    @iOSXCUITFindBy(accessibility = "ic_post_your_wall")
    private WebElement PostYourWallIcon;

    @AndroidFindBy(id = appPackage+":id/fbPostGroupWall")
    @iOSXCUITFindBy(accessibility = "ic_post_your_group")
    private WebElement PostGroupWallIcon;

    @AndroidFindBy(id = appPackage+":id/tvNameCounterIndices")
    @iOSXCUITFindBy(accessibility = "ic_pencil_write")
    private WebElement EditIcon;
}
