package com.qa.stepdef.common;

import com.qa.pages.Common.GlobalSearch;
import com.qa.pages.CommonContentPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GlobalSearchDef {

    @When("^Tap on Global Search icon Back$")
    public void iTabOnGlobalSearchBackIcon()
    {
        new CommonContentPage().tabOnBackBtn();
    }

    @Then("^Verify the display of GlobalSearch is \"([^\"]*)\"$")
    public void verifyTheExistingOfGlobalSearch(String isExisted) throws Exception {
        GlobalSearch globalSearch = new GlobalSearch();
        globalSearch.VerifyTheExistingOfAnElement(globalSearch.SearchIcon, isExisted,
                "GlobalSearch screen is expected " + isExisted + " but not" +isExisted);
    }
}
