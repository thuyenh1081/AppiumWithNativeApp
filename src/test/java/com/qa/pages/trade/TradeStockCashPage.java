package com.qa.pages.trade;

//import io.appium.java_client.MobileElement;

import com.qa.pages.CommonContentPage;
import org.openqa.selenium.WebElement;

public class TradeStockCashPage extends CommonContentPage {

    public WebElement getHeaderLabel()
    {
        return getElementBaseOnAnElement(BackBtn, ".//following-sibling::XCUIElementTypeStaticText[@name='Stocks']");
    }
}
