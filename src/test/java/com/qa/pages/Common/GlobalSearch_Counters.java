package com.qa.pages.Common;

import com.qa.pages.CommonContentPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class GlobalSearch_Counters extends GlobalSearch {

    @AndroidFindBy(id = "fill later")
    @iOSXCUITFindBy(accessibility = "All")
    private WebElement All;

    @AndroidFindBy(id = "fill later")
    @iOSXCUITFindBy(accessibility = "EQ")
    private WebElement EQ;

    @AndroidFindBy(id = "fill later")
    @iOSXCUITFindBy(accessibility = "ETF")
    private WebElement ETF;

    @AndroidFindBy(id = "fill later")
    @iOSXCUITFindBy(accessibility = "CFD")
    private WebElement CFD;

    @AndroidFindBy(id = "fill later")
    @iOSXCUITFindBy(accessibility = "UT")
    private WebElement UT;

    @AndroidFindBy(id = "fill later")
    @iOSXCUITFindBy(accessibility = "BO")
    private WebElement BO;
}
