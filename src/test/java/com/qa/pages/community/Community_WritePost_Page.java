package com.qa.pages.community;

//import io.appium.java_client.MobileElement;

import com.qa.pages.CommonContentPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class Community_WritePost_Page extends CommonContentPage {

//    @AndroidFindBy(id = appPackage+":id/btnBack")
//    @iOSXCUITFindBy(accessibility = "ic_cancel")
//    private WebElement BackBtn;
    
    @AndroidFindBy(id = appPackage+":id/btnPostComment")
    @iOSXCUITFindBy(accessibility = "Post")
    private WebElement PostIcon;

    @AndroidFindBy(id = appPackage+":id/imvChooseGallery")
    @iOSXCUITFindBy(accessibility = "ic_gallery")
    private WebElement PhotoIcon;

    public void clickOnChooseGallery()
    {
        clickWithExplicitWait(PhotoIcon);
    }
}
