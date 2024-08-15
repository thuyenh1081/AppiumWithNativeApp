package com.qa.pages.Popup;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class SessionTimoutPopup extends HaveOkAndCancelBtnPopup {


    @AndroidFindBy(id = "later")
    @iOSXCUITFindBy(accessibility = "Please re-verify yourself to continue")
    public WebElement txt2;

    @AndroidFindBy(id = "later")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeSecureTextField'")
    public WebElement passTxt;

    public void inputPass(String pass)
    {
        sendKeys(passTxt, pass);
    }

}
