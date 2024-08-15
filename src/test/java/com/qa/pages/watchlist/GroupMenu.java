package com.qa.pages.watchlist;

import com.qa.pages.CommonContentPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class GroupMenu extends CommonContentPage {

    @AndroidFindBy(id = appPackage+":id/imvSettingWatchList")
    @iOSXCUITFindBy(xpath = "dadadd")
    private WebElement SettingWatchList;
    public void tapOnSettingIcon()
    {
        clickWithExplicitWait(SettingWatchList);}
}
