package com.qa.pages.TradeTicket;

import com.qa.entity.OrderCDF;
import com.qa.pages.TradeTicket.OrderConfirmation.OrderConfirmationCFD;
import com.qa.pages.trade.TradeCFDOrdersPage;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TradeTicketCFD extends TradeTicket {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Market']")
    @iOSXCUITFindBy(accessibility = "Limit")
    public WebElement LimitTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Limit']")
    @iOSXCUITFindBy(accessibility = "Stop Limit")
    public WebElement StopLimitTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stop Limit']")
    @iOSXCUITFindBy(accessibility = "OCO")
    public WebElement OCOTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='OCO']")
    @iOSXCUITFindBy(accessibility = "Market")
    public WebElement MarketTab;

    @AndroidFindBy(id = appPackage+":id/tvPlaceBuySell")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'PLACE BUY LIMIT ORDER'")
    public WebElement PlaceBuyLimitOrder;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='"+appPackage+":id/iclLimitPriceCFD']/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Limit Price (CAD)']/following-sibling::XCUIElementTypeTextField[1]")
    public WebElement LimitPrice;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='"+appPackage+":id/iclQuantityCFD']//android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Quantity (X 10K)']/following-sibling::XCUIElementTypeTextField[1]")
    public WebElement Quantity;

    @AndroidFindBy(xpath = "//"+appPackage+":id/llContentEQ//chiu")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Validity']/following-sibling::XCUIElementTypeTextField[1]")
    public WebElement Validity;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='"+appPackage+":id/iclMinInvest'])[1]//android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Gross Contract Value']/following-sibling::*[1]")
    public WebElement GrossContractValue;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id='"+appPackage+":id/iclMinSubInvest'])[1]//android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Margin Requirement']/following-sibling::*[1]")
    public WebElement MarginRequirement;

    @AndroidFindBy(xpath = "((//android.view.ViewGroup[@resource-id='"+appPackage+":id/iclMinSubInvest'])[2]//android.widget.EditText[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Account Number']/following-sibling::*[1]")
    public WebElement AccountNumber;

    @AndroidFindBy(id = "//android.view.ViewGroup[@resource-id='"+appPackage+":id/iclMinInvest'])[2]//android.widget.EditText[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Cash Balance']/following-sibling::*[1]")
    public WebElement CashBalance;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='"+appPackage+":id/iclMinSubInvest'])[2]//android.widget.EditText[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Exposure Limit Left']/following-sibling::*[1]")
    public WebElement ExposureLimitLeft;




    public OrderCDF getListValueNeedToCheckOnConfirmDialog()
    {
        OrderCDF orderCDF = new OrderCDF();
        orderCDF.resetAllValue();
        orderCDF.setLimitPrice(LimitPrice.getText());
//        orderCDF.setQuantity(Validity.getText());
        orderCDF.setQuantity("Day");
//        orderCDF.setGrossContractValue(GrossContractValue.getText());
//        orderCDF.setMarginRequirement(MarginRequirement.getText());
//        orderCDF.setAccountNumber(AccountNumber.getText());
//        orderCDF.setCashBalance(CashBalance.getText());
//        orderCDF.setExposureLimitLeft(ExposureLimitLeft.getText());

        return orderCDF;
    }

    public OrderConfirmationCFD clickOnPlaceBuyLimitOrder()
    {
        clickWithExplicitWait(PlaceBuyLimitOrder);
        return new OrderConfirmationCFD();
    }
}