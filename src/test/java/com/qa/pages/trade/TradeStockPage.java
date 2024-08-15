package com.qa.pages.trade;

//import io.appium.java_client.MobileElement;

import com.qa.pages.CommonContentPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class TradeStockPage extends TradeModulePage {

    @AndroidFindBy(id = "later")
    @iOSXCUITFindBy(accessibility = "Intraday")
    private WebElement Intraday;

    @Override
    public void waitForFullDisplayOFAPage()
    {
        waitForVisibilityWithExplicitWait(Intraday);
    }

}
