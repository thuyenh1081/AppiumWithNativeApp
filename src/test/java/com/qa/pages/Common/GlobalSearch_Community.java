package com.qa.pages.Common;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class GlobalSearch_Community extends GlobalSearch {

    @AndroidFindBy(id = "fill later")
    @iOSXCUITFindBy(accessibility = "Posts")
    private WebElement Posts;

    @AndroidFindBy(id = "fill later")
    @iOSXCUITFindBy(accessibility = "Users")
    private WebElement Users;

    @AndroidFindBy(id = "fill later")
    @iOSXCUITFindBy(accessibility = "Groups")
    private WebElement Groups;

}
