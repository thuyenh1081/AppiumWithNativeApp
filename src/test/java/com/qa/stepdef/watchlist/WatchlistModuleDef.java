package com.qa.stepdef.watchlist;

import com.qa.pages.trade.TradeModulePage;
import com.qa.pages.watchlist.WatchlistModulePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

public class WatchlistModuleDef {

    @When("^Tap on WatchlistModule group \"([^\"]*)\"$")
    public void iTabOnWatchlistGroup(String name)  {
        new WatchlistModulePage().openWatchlistGroupView(name);
    }

    @When("^Tap on WatchlistModule icon WatchListMenu$")
    public void iTabOnWatchlistMenuIcon()
    {
        new WatchlistModulePage().OpenWatchlistMenu();
    }

    @When("^Scroll to see WatchlistModule button EditIncides$")
    public void iScrollToSeeEditIncidesIcon()
    {
        new WatchlistModulePage().scrollWatchlistToSeeEditIndicies();
    }

    @When("^Tap on WatchlistModule icon EditIncides$")
    public void iTabOnWatchlistEditIncidesIcon()
    {
        new WatchlistModulePage().OpenEditIncidesScreen();
    }

    @When("^Scroll to see WatchlistModule incides \"([^\"]*)\"$")
    public WebElement scrollToSeeIncides(String incidiesName)
    {
        return new WatchlistModulePage().swipeToFindIncidesByName(incidiesName);
    }
    @When("^Scroll to see WatchlistModule group \"([^\"]*)\"$")
    public WebElement scrollToSeeGroup(String groupName)
    {
        return new WatchlistModulePage().horizontalToFindWatchlistGroupTypeByName(groupName);
    }

    @Then("^Verify the display of WatchlistModule incides \"([^\"]*)\" is \"([^\"]*)\"$")
    public void verifyExistingOfIndices(String incidiesName, String isExisted) throws Exception {
        WatchlistModulePage modulePage = new WatchlistModulePage();
        modulePage.VerifyTheExistingOfAnElement(modulePage.findIncidesByName(incidiesName), isExisted,
                "Content screen is expected " + isExisted + " but not" +isExisted);
    }

    @Then("^Verify the display of the screen WatchlistModule is \"([^\"]*)\"$")
    public void verifyExistingOfWatchlistModulePage(String isExisted) throws Exception {
        new WatchlistModulePage().verifyTheDisplayOfPage(isExisted);
    }
}
