package com.qa.pages.TradeTicket.OrderDetails;

import com.qa.entity.OrderCDF;
import com.qa.pages.BasePage;
import com.qa.pages.TradeTicket.TradeTicketCFD;
import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class OrderDetails extends BasePage {

    @AndroidFindBy(id = appPackage+":id/tvOrderDetail")
    @iOSXCUITFindBy(accessibility = "Order Details")
    public WebElement OrderDetailsLabel;

    @AndroidFindBy(id = appPackage+":id/tvOrderStatus")
    @iOSXCUITFindBy(accessibility = "later")
    public WebElement OrderStatus;


}
