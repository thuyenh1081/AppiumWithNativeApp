package com.qa.pages.TradeTicket.OrderConfirmation;

import com.qa.pages.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class OrderConfirmation extends BasePage {
    @AndroidFindBy(id = appPackage+":id/tvOrderConfirmation")
    @iOSXCUITFindBy(accessibility = "Order Confirmation")
    public WebElement OrderConfirmation;

    @AndroidFindBy(id = appPackage+":id/tvTradeTicketConfirm")
    @iOSXCUITFindBy(accessibility = "CONFIRM")
    public WebElement ConfirmBtn;
}
