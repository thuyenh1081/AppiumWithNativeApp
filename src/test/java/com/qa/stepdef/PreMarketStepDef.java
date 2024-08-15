package com.qa.stepdef;

import com.qa.pages.Popup.HaveAllowAndNotAllowPopup;
import com.qa.pages.PreMarketPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class PreMarketStepDef {

    @Given("Login page is open$")
    public void login() {
        new HaveAllowAndNotAllowPopup().denyAllowNotification();
        new PreMarketPage().clickOnPreMarket_LoginLink();
    }

    @When("^Verify the display of PremarketData is \"([^\"]*)\"$")
    public void verifyExistingOfPopup(String isExisted) {
        PreMarketPage premarketData = new PreMarketPage();
        premarketData.VerifyTheExistingOfAnElement(premarketData.PreMarket_LoginLink, isExisted,
                "Content screen is expected " + isExisted + " but not" + isExisted);
    }
}