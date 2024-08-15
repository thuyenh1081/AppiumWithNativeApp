package com.qa.pages.me;

//import io.appium.java_client.MobileElement;

import com.qa.pages.community.Community_Education_Page;
import org.openqa.selenium.WebElement;

public class Me_Setting_Watchlist_Page extends Community_Education_Page {

    public WebElement getHeaderLabel()
    {
        return getElementBaseOnAnElement(BackBtn, ".//following-sibling::XCUIElementTypeStaticText[@name='Watchlist']");
    }

}
