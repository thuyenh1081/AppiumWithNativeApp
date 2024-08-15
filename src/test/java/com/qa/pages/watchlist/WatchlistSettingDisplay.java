package com.qa.pages.watchlist;

import com.qa.pages.BasePage;
import com.qa.pages.CommonContentPage;
import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class WatchlistSettingDisplay extends WatchListSetting {

    public WatchlistSettingDisplay()
    {
        super();
    }
    public WatchlistSettingDisplay(Boolean isCheckPopup)
    {
        super(isCheckPopup);
    }

    @AndroidFindBy(id = appPackage+":id/tvIndicesSetting")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Indices']/XCUIElementTypeImage")
    private WebElement Indicies;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='"+appPackage+":id/tvTitle'" +
            " and @text='Show News Stream']/../android.widget.Switch")
    @iOSXCUITFindBy(accessibility = "Show News Stream")
    private WebElement ShowNewsStream;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='"+appPackage+":id/tvTitle'" +
            " and @text='Show Pre and Post Market']/../android.widget.Switch")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='Show Pre and Post Market']")
    private WebElement ShowPreAndPostMarket;

    public void showPreAndPostMarket()
    {
        checkOnCheckBox(ShowPreAndPostMarket);
    }

    public void unShowPreAndPostMarket()
    {
        unCheckOnCheckBox(ShowPreAndPostMarket);
    }
    public void ShowNewStream()
    {
        checkOnCheckBox(ShowNewsStream);
    }

    public void unShowNewStream()
    {
        unCheckOnCheckBox(ShowNewsStream);
    }
}
