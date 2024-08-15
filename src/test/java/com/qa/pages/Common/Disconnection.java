package com.qa.pages.Common;

import com.qa.pages.CommonContentPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class Disconnection extends CommonContentPage {
    @AndroidFindBy(id = appPackage+":id/imageComingSoon")
    @iOSXCUITFindBy(accessibility = "img_placeholder_no_internet")
    public WebElement NoInternetImage;

    @AndroidFindBy(id = "btnLoadingIcon")
    @iOSXCUITFindBy(accessibility = "later")
    public WebElement LoadingIcon;

    @AndroidFindBy(id = "//android.widget.TextView[@text='No Internet Connection']")
    @iOSXCUITFindBy(accessibility = "No Internet Connection")
    public WebElement NoInternetImageTxt;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Looks like you are offline. Check your network connection and try again.']")
    @iOSXCUITFindBy(accessibility = "Looks like you are offline. Check your network connection and try again.")
    public WebElement LookLikeOfflineTxt;

    @AndroidFindBy(id = appPackage+":id/btnRetryIcon")
    @iOSXCUITFindBy(accessibility = "img_button_refresh")
    public WebElement RefreshBtn;

    @AndroidFindBy(id = appPackage+":id/btnText")
    @iOSXCUITFindBy(accessibility = "Try again")
    public WebElement TryAgainTxt;

    public void clickOnTryAgainBtn()
    {
        clickWithExplicitWait(RefreshBtn);
    }
}
