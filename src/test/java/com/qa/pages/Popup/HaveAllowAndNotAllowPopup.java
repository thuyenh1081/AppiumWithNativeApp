package com.qa.pages.Popup;

//import io.appium.java_client.MobileElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindAll;
import org.openqa.selenium.WebElement;

import java.util.Date;

public class HaveAllowAndNotAllowPopup extends CommonPopup {

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    @iOSXCUITFindAll({
            @iOSXCUITBy(accessibility = "Don’t Allow"),
            @iOSXCUITBy(xpath = "//XCUIElementTypeOther[@name='Horizontal scroll bar, 1 page'])[2]")
    })
    public WebElement denyBtn;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    @iOSXCUITFindAll({
            @iOSXCUITBy(accessibility = "Allow"),
            @iOSXCUITBy(accessibility = "Allow Access to All Photos")
    })
    public WebElement allowBtn;

    public void denyAllowNotification()
    {
        System.out.println("Doi Deny" + utils.dateTime());
        if(isExistingOfAnElement(denyBtn))
        {
            clickWithExplicitWait(denyBtn);
        }
        System.out.println("Stop Doi Deny" + utils.dateTime());

    }
}
