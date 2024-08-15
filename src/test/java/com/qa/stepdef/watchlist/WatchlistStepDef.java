package com.qa.stepdef.watchlist;

import com.qa.pages.watchlist.WatchlistModulePage;
import io.cucumber.java.en.When;

public class WatchlistStepDef {

    @When("^Tap on three line icon$")
    public void iTabOnThreeLineIcon(String account) throws InterruptedException {
        new WatchlistModulePage().OpenWatchlistMenu();
    }
}
