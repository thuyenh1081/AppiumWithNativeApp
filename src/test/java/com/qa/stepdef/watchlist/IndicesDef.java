package com.qa.stepdef.watchlist;

import com.qa.pages.watchlist.IndicesSetting;
import io.cucumber.java.en.Then;

public class IndicesDef {

    @Then("^Verify the display of WatchlistModule IndicesSetting is \"([^\"]*)\"$")
    public void verifyExistingOfIndicesSetting(String isExisted) throws Exception {
        IndicesSetting indices = new IndicesSetting();
        indices.VerifyTheExistingOfAnElement(indices.ListSettingIndices, isExisted,
                "Content screen is expected " + isExisted + " but not" +isExisted);
    }
}
