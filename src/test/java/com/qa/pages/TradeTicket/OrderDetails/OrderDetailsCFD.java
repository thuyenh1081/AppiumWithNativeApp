package com.qa.pages.TradeTicket.OrderDetails;

import com.qa.entity.OrderCDF;
import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class OrderDetailsCFD extends OrderDetails {

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='"+appPackage+":id/recycleItemDetail']" +
            "//android.view.ViewGroup[1]//android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "later")
    public WebElement OrderNo;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='"+appPackage+":id/recycleItemDetail']" +
            "//android.view.ViewGroup[2]//android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "later")
    public WebElement OrderType;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='"+appPackage+":id/recycleItemDetail']" +
            "android.view.ViewGroup[3]//android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "later")
    public WebElement Side;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='"+appPackage+":id/recycleItemDetail']" +
            "android.view.ViewGroup[4]//android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Price'])[2]/following-sibling::XCUIElementTypeStaticText[1]")
    public WebElement Price;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='"+appPackage+":id/recycleItemDetail']" +
            "android.view.ViewGroup[5]//android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Quantity'])[1]/following-sibling::XCUIElementTypeStaticText[1]")
    public WebElement Quantity;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='"+appPackage+":id/recycleItemDetail']" +
            "android.view.ViewGroup[6]//android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "later")
    public WebElement Currency;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='"+appPackage+":id/recycleItemDetail']" +
            "android.view.ViewGroup[7]//android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "later")
    public WebElement StopPrice;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='"+appPackage+":id/recycleItemDetail']" +
            "android.view.ViewGroup[8]//android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "later")
    public WebElement StopPriceTrigger;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='"+appPackage+":id/recycleItemDetail']" +
            "android.view.ViewGroup[9]//android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "later")
    public WebElement TraillingStop;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='"+appPackage+":id/recycleItemDetail']" +
            "android.view.ViewGroup[10]//android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "later")
    public WebElement LimitSpread;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='"+appPackage+":id/recycleItemDetail']" +
            "android.view.ViewGroup[11]//android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "later")
    public WebElement CurrentNo;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='"+appPackage+":id/recycleItemDetail']" +
            "android.view.ViewGroup[12]//android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "later")
    public WebElement Validity;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='"+appPackage+":id/recycleItemDetail']" +
            "android.view.ViewGroup[13]//android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Submitted By']/following-sibling::XCUIElementTypeStaticText[1]")
    public WebElement SubmittedBy;

    @AndroidFindBy(id = appPackage+":id/tvOrderDetailMsgFeature")
    @iOSXCUITFindBy(className = "XCUIElementTypeScrollView")
    public WebElement Message;

    @AndroidFindBy(id = "later")
    @iOSXCUITFindBy(className = "XCUIElementTypeScrollView")
    public WebElement ParentContent;

    public void VerifyValueInConfirmDetail(OrderCDF order)
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform))
        {
            Assert.assertTrue(Quantity.getText().replace(",","").equalsIgnoreCase
                    (String.valueOf(Integer.parseInt(order.getQuantity())*10000)),"Quantity is not correct");
        }
        else
        {
            Assert.assertTrue(findElementByName(ParentContent,order.getLimitPrice() ) != null,"LimitPrice is not correct");
            Assert.assertTrue(Quantity.getText().replace(",","").equalsIgnoreCase
                    (String.valueOf(Integer.parseInt(order.getQuantity())*10000)),"Quantity is not correct");
        }

    }
    @Override
    public void waitForFullDisplayOFAPage()
    {
        waitForVisibilityWithExplicitWait(OrderNo);
    }
}
