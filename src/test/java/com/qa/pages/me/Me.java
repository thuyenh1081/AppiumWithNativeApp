package com.qa.pages.me;

//import io.appium.java_client.MobileElement;

import com.qa.pages.CommonContentPage;
import com.qa.pages.Setting.Settings;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;

public class Me extends CommonContentPage {

    @AndroidFindAll({
            @AndroidBy(id = appPackage+":id/btnSetting")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "(//XCUIElementTypeButton[@name='ic_setting'])[2]"),
            @iOSXCUITBy(xpath = "(//XCUIElementTypeButton[@name='ic_setting_light'])[2]")
    })
    public WebElement SettingIcon;

    public Settings clickOnSettingIcon()
    {
        clickWithExplicitWait(SettingIcon);
        Settings settings = new Settings();
//        settings.waitForTheDisplayOfThePage();
        return settings;
    }

}
