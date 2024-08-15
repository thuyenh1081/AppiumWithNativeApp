package com.qa.stepdef;

import com.qa.pages.Common.GlobalSearch;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class GlobalSearchStepDef {
    @When("^Enter GlobalSearch textBox Search as \"([^\"]*)\"$")
    public void iMakeASearch(String search) throws Exception {
        new GlobalSearch().makeASeach(search);
    }
    @And("Tap on Global Search row name {int}")
    public void iTabOnTheResultAtRow(int number) {
        new GlobalSearch().clickOnResultAtRowIndex(number -1 );
    }
}
