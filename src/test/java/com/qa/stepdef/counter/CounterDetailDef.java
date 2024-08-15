package com.qa.stepdef.counter;

import com.qa.pages.counter.CounterDetail;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CounterDetailDef {

    @Then("^CounterDetail is opened$")
    public void theCounterDetailIsOpened() throws Exception {

        Assert.assertNotNull(new CounterDetail().CounterDetail, "CounterDetail is not opened");

    }

    @Given("^Tab on CounterDetail icon Back$")
    public void tabOnCounterDetailBackIcon() throws Exception {
        new CounterDetail().tabOnBackBtn();
    }

    @Then("Verify the display of CounterDetail is \"([^\"]*)\"$")
    public void verifyTheExistingOfCounterDetail$(String isExisted) throws Exception {
        CounterDetail conterDetail = new CounterDetail();
        conterDetail.VerifyTheExistingOfAnElement(conterDetail.CounterDetail, isExisted,
                "CounterDetail screen is expected " + isExisted + " but not" +isExisted);
    }
}
