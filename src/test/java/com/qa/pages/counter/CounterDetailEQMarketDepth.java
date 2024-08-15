package com.qa.pages.counter;

import com.qa.pages.CommonContentPage;
import org.openqa.selenium.WebElement;

public class CounterDetailEQMarketDepth extends CommonContentPage {
    public WebElement getHeaderLabel()
    {
        return getElementBaseOnAnElement(BackBtn, ".//following-sibling::XCUIElementTypeStaticText[@name='Market Depth']");
    }

}
