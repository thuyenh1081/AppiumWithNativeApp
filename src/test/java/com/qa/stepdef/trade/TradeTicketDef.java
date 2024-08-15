package com.qa.stepdef.trade;

import com.qa.entity.OrderCDF;
import com.qa.pages.TradeTicket.*;
import com.qa.pages.TradeTicket.OrderConfirmation.OrderConfirmationCFD;
import com.qa.pages.TradeTicket.OrderDetails.OrderDetailsCFD;
import com.qa.pages.trade.TradeCFDOrdersPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TradeTicketDef {
    OrderCDF orderCDF = new OrderCDF();
    @When("^Tap on TradeTicketCFD button Buy$")
    public void iTapOnIconBuy() {
        new TradeTicketCFD().clickOnBuyBtn();
    }

    @When("Tap on TradeCFDOrdersPage tab Order row {int}")
    public void iTapOnCFDTradeTicketRow(int number) {
        new TradeCFDOrdersPage().clickOnOrderRow(number-1).waitForFullDisplayOFAPage();
    }

    @When("^Tap on TradeTicketCFD button PlaceBuyLimitOrder$")
    public void iTapOnPlaceBuyMauyMarketOrder(){

        TradeTicketCFD tradeTicketCFD = new TradeTicketCFD();
        orderCDF = tradeTicketCFD.getListValueNeedToCheckOnConfirmDialog();
        tradeTicketCFD.clickOnPlaceBuyLimitOrder().waitForFullDisplayOFAPage();
    }

    @Then("^Verify value TradeTicketCFD dialog OrderConfirmation$")
    public void verifyValueInTheOrderConfirmation(){
        new OrderConfirmationCFD().VerifyValueInConfirmOder(orderCDF);
    }

    @When("^Tap on TradeTicketCFD OrderConfirmation button Confirm$")
    public void iTapOnConfirmOrderBtn() {
        new OrderConfirmationCFD().clickOnConfirmBtn().waitForFullDisplayOFAPage();
    }

    @When("^Tap on Global Search row name {1}$")
    public void iTapOntheOrderAtRow( int r) {

    }
    @Then("^Verify value TradeTicket dialog OrderDetail$")
    public void verifyValueInTheOrderDetail(){
        new OrderDetailsCFD().VerifyValueInConfirmDetail(orderCDF);
    }
}
