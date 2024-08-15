package com.qa.pages.trade;

//import io.appium.java_client.MobileElement;

import org.openqa.selenium.WebElement;

public class TradeStockCashOutstandingPositionsPage extends TradeStockCashPage {

    public WebElement getHeaderLabel()
    {
        return getElementBaseOnAnElement(BackBtn, ".//following-sibling::XCUIElementTypeStaticText[@name='Stocks']");
    }


}
