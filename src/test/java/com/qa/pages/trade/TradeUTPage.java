package com.qa.pages.trade;

//import io.appium.java_client.MobileElement;

import com.qa.pages.CommonContentPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class TradeUTPage extends TradeModulePage {

    @AndroidFindBy(id = "later")
    @iOSXCUITFindBy(accessibility = "INVEST")
    private WebElement Invest;

    @Override
    public void waitForFullDisplayOFAPage()
    {
        waitForVisibilityWithExplicitWait(Invest);
    }
}
