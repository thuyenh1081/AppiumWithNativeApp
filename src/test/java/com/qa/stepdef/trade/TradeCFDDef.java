package com.qa.stepdef.trade;

import com.qa.entity.OrderCDF;
import com.qa.pages.trade.TradeCFDOrdersPage;
import com.qa.pages.trade.TradeCFDPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TradeCFDDef {
    OrderCDF order = new OrderCDF();
    @When("^Tap on TradeCFD button Trade$")
    public void iChooseTradeIcon(){
        new TradeCFDPage().clickOnTradeBtn();
    }

    @When("^Tap on TradeCFD icon Order")
    public void iChooseOrderIcon(){
        new TradeCFDPage().clickOnOderTab().waitForFullDisplayOFAPage();
    }

    @When("^Tap on TradeCFD tab Order")
    public void iTapOnOrder() {
        TradeCFDPage tradeCFDPage = new TradeCFDPage();
        tradeCFDPage.clickOnOderTab().waitForFullDisplayOFAPage();
    }

    @When("^Count number of Today order TradeCFD")
    public void iCountNumberOfOderInTday() {
        TradeCFDOrdersPage tradeCFDOrdersPage = new TradeCFDOrdersPage();
        order.setTotalOfOrder(tradeCFDOrdersPage.getTotalOfTodayOrder().size());
    }

    @Then("Verify the increasing of number of Today order is {int}")
    public void iTabOnTheResultAtRow(int number) {
        int oldOrder = order.getTotalOfOrder();
        int updatedOrder =  new TradeCFDOrdersPage().getTotalOfOrderInCurrentView().size();
        Assert.assertTrue(updatedOrder - oldOrder == 1,"number of order is not increased 1" +
                "----before adding: " + oldOrder + " ---- after: " + updatedOrder);
    }
}
