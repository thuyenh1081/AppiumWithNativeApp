package com.qa.pages.watchlist;

import com.qa.pages.BasePage;
import com.qa.pages.CommonContentPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class CounterIndicesView extends CommonContentPage {

    @AndroidFindBy(id = appPackage+":id/tvNameCounterIndices")
    @iOSXCUITFindBy(xpath = "dadasdsad")
    private WebElement NameCounterIndices;

    @AndroidFindBy(id = appPackage+":id/tvLastDoneCounterIndices")
    @iOSXCUITFindBy(xpath = "dadad")
    private WebElement LastDoneCounterIndices;

    @AndroidFindBy(id = appPackage+":id/tvNetChangeIndices")
    @iOSXCUITFindBy(xpath = "dadad")
    private WebElement NetChangeIndices;

    @AndroidFindBy(id = appPackage+":id/tvPCTChangeIndices")
    @iOSXCUITFindBy(xpath = "dadad")
    private WebElement PCTChangeIndices;

}
