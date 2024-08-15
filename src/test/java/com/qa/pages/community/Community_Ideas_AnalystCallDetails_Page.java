package com.qa.pages.community;

//import io.appium.java_client.MobileElement;

import org.openqa.selenium.WebElement;

public class Community_Ideas_AnalystCallDetails_Page extends Community_Common_Page {

    public WebElement getHeaderLabel()
    {
        return getElementBaseOnAnElement(BackBtn, ".//following-sibling::XCUIElementTypeStaticText[@name='Analyst Call Details']");
    }
}
