package com.qa.pages.watchlist;

import com.qa.pages.BasePage;
import com.qa.pages.CommonContentPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class IndicesSetting extends CommonContentPage {

    @AndroidFindBy(id = appPackage+":id/rvListSettingIndices")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Indices']/following::XCUIElementTypeTable")
    public WebElement ListSettingIndices;

}
