package com.qa.pages.community;

//import io.appium.java_client.MobileElement;

import org.openqa.selenium.WebElement;

public class Community_Education_Guide_Beginners_Page extends Community_Education_Page {

    public WebElement getHeaderLabel()
    {
        return getElementBaseOnAnElement(BackBtn, ".//following-sibling::XCUIElementTypeStaticText[@name='Beginners']");
    }

}
