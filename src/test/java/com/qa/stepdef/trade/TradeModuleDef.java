package com.qa.stepdef.trade;

import com.qa.pages.trade.TradeModulePage;
import com.qa.pages.trade.TradeStockPositionsPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

public class TradeModuleDef {

    @When("^Scroll to see TradeModule type \"([^\"]*)\"$")
    public WebElement scrollToSeeTradeType(String tradeType)
    {
        return new TradeModulePage(true).horizontalToFindTradeTypeByName(tradeType);
    }
    @When("^Tap on TradeModule type \"([^\"]*)\"$")
    public TradeModulePage iTabOnTradeType(String type)  {
        return new TradeModulePage().clickOnTradeType(type);
    }
    @When ("^Tap on TradePosition")
    public void iTapOnPositionTab (){
        new TradeStockPositionsPage().tapOnPositionTab();
    }

    @When("^Tap on TradeOrders")
    public void iTapOnOrdersTab (){
        new TradeStockPositionsPage().tapOnOrdersTab();
    }

    @When("Tap on OrderList row order {int}")
    public void openAnOrder(int number) {
        new TradeStockPositionsPage().tapOnAnOrder(number);
    }
}
