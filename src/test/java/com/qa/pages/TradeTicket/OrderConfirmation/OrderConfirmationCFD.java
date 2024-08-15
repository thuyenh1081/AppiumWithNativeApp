package com.qa.pages.TradeTicket.OrderConfirmation;

import com.qa.entity.OrderCDF;
import com.qa.pages.TradeTicket.OrderDetails.OrderDetailsCFD;
import com.qa.pages.trade.TradeCFDOrdersPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class OrderConfirmationCFD extends OrderConfirmation{


    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup")
    @iOSXCUITFindBy(className = "XCUIElementTypeScrollView")
    public WebElement ParentContent;

    public TradeCFDOrdersPage clickOnConfirmBtn()
    {
        clickWithExplicitWait(ConfirmBtn);
        return new TradeCFDOrdersPage();
    }

    public void VerifyValueInConfirmOder(OrderCDF order)
    {
        Assert.assertTrue(findElementByName(ParentContent,order.getLimitPrice() ) != null,"LimitPrice is not correct");
//        Assert.assertTrue(findElementByName(ParentContent,order.getQuantity() ) != null,"Quantity is not correct");
//        Assert.assertTrue(findElementByName(ParentContent,order.getValidity() ) != null,"Validity is not correct");
//        Assert.assertTrue(findElementByName(ParentContent,order.getAccountNumber() ) != null,"AccountNumber is not correct");
    }

    @Override
    public void waitForFullDisplayOFAPage()
    {
        waitForVisibilityWithExplicitWait(ConfirmBtn);
    }
}
