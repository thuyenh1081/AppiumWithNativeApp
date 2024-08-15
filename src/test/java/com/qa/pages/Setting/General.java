package com.qa.pages.Setting;

import com.qa.pages.CommonContentPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class General extends CommonContentPage {
    @AndroidFindBy(id = appPackage+":id/containerLanguage")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Language' AND label == 'Language' AND type == 'XCUIElementTypeButton'")
    public WebElement Language;

    @AndroidFindBy(id = appPackage+":id/containerTheme")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Theme, Dark'")
    public WebElement Theme;

    public Theme tapOnTheme()
    {
        clickWithExplicitWait(Theme);
        return new Theme();
    }
}
