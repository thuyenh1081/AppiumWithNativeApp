package com.qa.pages.market;

//import io.appium.java_client.MobileElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class MarketCalenderPage extends MarketModulePage {

    @AndroidFindBy(id = appPackage+":id/ivSettingMarketCalendar")
    @iOSXCUITFindBy(accessibility = "ic_setting")
    public WebElement SettingIcon;

    public void clickOnSettingIcon()
    {
        clickWithExplicitWait(SettingIcon);
    }
}
