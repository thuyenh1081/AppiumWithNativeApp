package com.qa.stepdef.trade;

import com.qa.pages.trade.TradeRoboPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class RoboTradeDef {

    @When("^Choose RoboTrade payment PayNow$")
    public void iChoosePaymentPaynow() throws IOException, InterruptedException {
        TradeRoboPage roboTradePage = new TradeRoboPage();
        roboTradePage.clickOnCash();
        roboTradePage.clickOnDeposit();
        roboTradePage.clickOnPaynow();
    }
    @When("^Tap on RoboTrade icon Cash")
    public void iTapOnCash() throws IOException, InterruptedException {
        TradeRoboPage roboTradePage = new TradeRoboPage();
        roboTradePage.clickOnCash();
    }
    @When("^Tap on RoboTrade icon Deposit$")
    public void iTapOnDeposit() throws IOException, InterruptedException {
        TradeRoboPage roboTradePage = new TradeRoboPage();
        roboTradePage.clickOnDeposit();
    }
    @When("^Tap on RoboTrade icon PayNow$")
    public void iTapOnPaynow() throws IOException, InterruptedException {
        TradeRoboPage roboTradePage = new TradeRoboPage();
        roboTradePage.clickOnPaynow();
    }

    @When("^Scroll to see RoboTrade\"([^\"]*)\"$")
    public WebElement scrollToSeeRoboAccount(String roboAccount) throws Exception {
        return new TradeRoboPage().horizontalToFindRoboAccountByName(roboAccount);
    }

    @When("^Tap on RoboTrade icon \"([^\"]*)\"$")
    public void iTabOnRoboAccount(String roboAccount) throws Exception {
        new TradeRoboPage().clickOnRoboAccount(roboAccount);
    }
    @Then("^Verify the display of screen RoboTrade is \"([^\"]*)\"$")
    public void verifyTheExisitngOgRoboTrade(String isExisted){
        TradeRoboPage roboTradePage = new TradeRoboPage();
        roboTradePage.VerifyTheExistingOfAnElement(roboTradePage.tabLayoutTrade, isExisted,
                "Content screen is expected " + isExisted + " but not" +isExisted);
    }


}
