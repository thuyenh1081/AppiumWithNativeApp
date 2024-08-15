package com.qa.pages.watchlist;

import com.qa.pages.CommonContentPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class WatchListSetting extends CommonContentPage {
    public WatchListSetting()
    {super();}
    public WatchListSetting(Boolean isCheckPopup)
    {
        super(isCheckPopup);
    }


//    @AndroidFindBy(accessibility = "btnBack")
//    @iOSXCUITFindBy(iOSNsPredicate = "name == 'BTN_BACK'")
//    private WebElement BackBtn;

    @AndroidFindBy(accessibility = "Display")
    @iOSXCUITFindBy(accessibility = "Display")
    private WebElement DisplayTab;

    @AndroidFindBy(accessibility = "Columns")
    @iOSXCUITFindBy(accessibility = "Columns")
    private WebElement Columns;

    @AndroidFindBy(accessibility = "Groups")
    @iOSXCUITFindBy(accessibility = "Groups")
    private WebElement Groups;

    @Override
    public WatchlistGroup tabOnBackBtn()
    {
        clickWithExplicitWait(BackBtn);
        return new WatchlistGroup(true);
    }


    public WatchlistSettingDisplay tabOnDisplayTab()
    {
        clickWithExplicitWait(DisplayTab);
        return new WatchlistSettingDisplay();
    }

    public WatchlistSettingColumns tabOnCoumnTab()
    {
        clickWithExplicitWait(Columns);
        return new WatchlistSettingColumns();
    }

    public WatchlistSettingGroup tabOnGroupTab()
    {
        clickWithExplicitWait(Groups);
        return new WatchlistSettingGroup();
    }

//    @Override
//    public void waitForTheDisplayOfThePage()
//    {
//        super.waitForTheDisplayOfThePage();
//        waitForVisibilityWithExplicitWait(Columns);
//    }
}

