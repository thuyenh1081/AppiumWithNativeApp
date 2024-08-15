package com.qa.pages.Popup;

import com.qa.pages.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.*;
import org.apache.commons.beanutils.BeanUtils;
import org.openqa.selenium.WebElement;

public class CommonPopup extends BasePage {

    @AndroidFindAll({
            @AndroidBy(id = appPackage+":id/containerDialogAlert"),
            @AndroidBy(id = appPackage+":id/disclaimerDialog"),
            @AndroidBy(id = appPackage+":id/tvTitleDialog"),
            @AndroidBy(id = appPackage+":id/tvTitleAlert")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(accessibility = "POEMS Mobile 3"),
            @iOSXCUITBy(accessibility = "Portfolio Disclaimer"),
            @iOSXCUITBy(xpath = "//XCUIElementTypeStaticText[@name='No SIM Card Installed']"),
            @iOSXCUITBy(accessibility = "Opps! Looks like you are away for too long")
    })
    public WebElement DialogAlert;

    @AndroidFindBy(id = appPackage+":id/tvMessageAlert")
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//XCUIElementTypeStaticText[@name='POEMS Mobile 3']/following-sibling::XCUIElementTypeStaticText[1]"),
            @iOSXCUITBy(xpath = "//XCUIElementTypeStaticText[@name='Portfolio Disclaimer']//following::XCUIElementTypeStaticText"),
            @iOSXCUITBy(xpath = "//XCUIElementTypeStaticText[@name='No SIM Card Installed']"),
            @iOSXCUITBy(accessibility = "Please re-verify yourself to continue")
    })
    public WebElement Message;

    @AndroidFindAll({
            @AndroidBy(id = appPackage+":id/btnOkDialog"), // something wwhen wwro, unable to connect serrver
            @AndroidBy(id = appPackage+":id/btnIAgree"),
            @AndroidBy(id = appPackage+":id/btnPositive")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(accessibility = "BTN_POP_UP_CONFIRM"),//something went wrong, Portfolio Disclaimer
            @iOSXCUITBy(accessibility = "OK"),//Do you want to receive POEMS Notifications for this account on this device?
            @iOSXCUITBy(accessibility = "BTN_OK"),
            @iOSXCUITBy(accessibility = "BTN_CONFIRM_BASIC_DIALOG"),//session timeout
            @iOSXCUITBy(accessibility = "You do not have any position")
    })
    public WebElement OKBtn;

    public  void clickOKBtn()
    {
//        click(OKBtn);
        int x = (int)(OKBtn.getLocation().x + OKBtn.getSize().width/2);
        int y = (int) (OKBtn.getLocation().y + OKBtn.getSize().height*0.9);
        clickByCoordinator(OKBtn, x,  y);
    }

    public String getMessage()
    {
        return  getText(Message);
    }

    public void verifyErrorMessage(String errorMsg) throws Exception {
        String expected = getDataFromXMLFile("data/strings.xml").get(errorMsg);
        verifyText(expected, getMessage());
    }
}
