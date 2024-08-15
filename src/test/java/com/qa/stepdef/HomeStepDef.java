package com.qa.stepdef;

import com.qa.pages.CommonContentPage;
import com.qa.pages.home.HomeModulePage;
import com.qa.pages.counter.CounterRow;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Date;
import java.util.List;

public class HomeStepDef {

    @And("^Scroll to see HomePage widget Watchlist")
    public void scrollToSeeWidgetWatchlist() {
        new HomeModulePage().scrollToSeeWidgetWatchlist();
    }
    @And("^Tap on HomePage icon WatchlistMoveDetail")
    public void tapOnWatchlistMoveDetail() {
        new HomeModulePage().clickOnWatchlistWidgetMoveDetail();
    }
    @When("^Tap on HomePage widget Watchlist tab \"([^\"]*)\"$")
    public void iLoginByHolderAccount(String watchlistGroup) throws Exception {
        new HomeModulePage().clickOnWatchlistGroup(watchlistGroup);
    }
    @And("^Tap on HomePage widget Watchlist counter row found by counterName \"([^\"]*)\"$")
    public void iTapOnCounterRow(String counterName) throws Exception {
        new HomeModulePage().clickOnCounterRow(counterName);
    }
    @And("^Scroll to see HomePage counter counterName \"([^\"]*)\"$")
    public void ScrollToSeeCounter() {
        new HomeModulePage().clickOnWatchlistWidgetMoveDetail();
    }
    @Then("^Verify the value of counter HomePage found by counterName \"([^\"]*)\" : counterType \"([^\"]*)\" counterCode " +
            "\"([^\"]*)\" counterChart \"([^\"]*)\" firstLabel \"([^\"]*)\" secondLabel \"([^\"]*)\" lastDonePrice \"([^\"]*)\" changePCT \"([^\"]*)\"" +
            " with showPrePostOption is \"([^\"]*)\"$")
    public void verifyValueOfCounterInHomePageFindByCounterName(String counterName, String counterType, String counterCode
            , String counterChart, String firstLabel, String secondLabel, String lastDonePrice, String changePCT, String showPrePostOption) throws Exception {
        CommonContentPage commonContentPage = new CommonContentPage();
        List<Date> dates = commonContentPage.getSGTradingTime();
        CounterRow counterRow = new HomeModulePage().findCounterRowByName(counterName);
        counterRow.verifyValueOfCounterName(counterName);
        counterRow.verifyValueOfCounterType(counterType);
        counterRow.verifyValueOfCounterCode(counterCode);
        counterRow.verifyValueOfCounterChart(counterChart);
        counterRow.verifyValueOfFirstLabel(firstLabel,showPrePostOption, counterType,dates.get(0), dates.get(1), dates.get(2));
        counterRow.verifyValueOfSecondLabel(secondLabel,showPrePostOption, counterType, dates.get(0), dates.get(1), dates.get(2));
        counterRow.verifyValueOfLastDonePrice(lastDonePrice);
        counterRow.verifyValueOfChangePCT(changePCT,showPrePostOption, counterType, dates.get(0), dates.get(1), dates.get(2));
    }

}
