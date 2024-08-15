package com.qa.pages.Popup;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindAll;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class HaveOkAndCancelBtnPopup extends CommonPopup {

    @AndroidFindBy(id = appPackage+":id/btnCancelDialog")
    @iOSXCUITFindAll({
            @iOSXCUITBy(accessibility = "BTN_CANCEL"),
            @iOSXCUITBy(accessibility = "BTN_CANCEL_BASIC_DIALOG")
    })
    public WebElement CancelBtn;


    public void cancelPOEMSNotification()
    {
//        click(CancelBtn);
        int x = (int)(CancelBtn.getLocation().x + CancelBtn.getSize().width/2);
        int y = (int) (CancelBtn.getLocation().y + CancelBtn.getSize().height/2);
        clickByCoordinator(CancelBtn, x,  y);
    }

}
