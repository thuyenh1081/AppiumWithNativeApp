package com.qa.stepdef.watchlist;

import com.qa.pages.BasePage;
import com.qa.pages.CommonContentPage;
import com.qa.pages.counter.CounterRow;
import com.qa.pages.counter.CounterRowInWatchListScrollableHorizontal;
import com.qa.pages.counter.CounterRowInWatchListUnScrollableHorizontal;
import com.qa.pages.home.HomeModulePage;
import com.qa.pages.watchlist.WatchlistGroup;
import com.qa.utils.TestUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class WatchlistGroupDef{

    @When("^Tap on WatchlistGroup column Name$")
    public void iTabOnNameColumn()
    {
        new WatchlistGroup().tapOnColumnName();
    }

    @When("^Tap on WatchlistGroup column Price$")
    public void iTabOnPriceColumn()
    {
        new WatchlistGroup().tapOnColumnChart();
    }

    @When("^Tap on WatchlistGroup icon Rotate$")
    public void iTabOnWatchlistRotateIcon()
    {
        new WatchlistGroup().tapOnRotateIcon();
    }

    @When("^Tap on WatchlistGroup icon Edit$")
    public void iTabOnWatchlistEditIcon()
    {
        new WatchlistGroup().tapOnEditIcon();
    }

    @When("^Turn on WatchlistGroup icon Chart$")
    public void iTabOnWatchlistChartIcon()
    {
        new WatchlistGroup().turnOnChart();
    }
    @When("^Turn off WatchlistGroup icon Chart$")
    public void iTabOffWatchlistChartIcon()
    {
        new WatchlistGroup().turnOffChart();
    }
    @When("^Turn on WatchlistGroup icon ScrollableHorizontal$")
    public void iTabOnWatchlistScrollableHorizontalIcon()
    {
        new WatchlistGroup().turnOnScrollableHorizontalIcon();
    }
    @When("^Turn off WatchlistGroup icon ScrollableHorizontal$")
    public void iTabOffWatchlistScrollableHorizontalIcon()
    {
        new WatchlistGroup().turnOffScrollableHorizontalIcon();
    }
    @When("^Tap on WatchlistGroup icon Setting$")
    public void iTabOnWatchlistSettingIcon()
    {
        new WatchlistGroup().tapOnSettingIcon();
    }

    @And("Scroll to see WatchlistGroup button Add Group")
    public void scrollWatchlistGroupToSeeAddGroupButton() throws InterruptedException {
        new WatchlistGroup().scrollWatchlistToSeeAddbtn();
    }
    @And("Scroll to see WatchlistGroup counter type \"([^\"]*)\"$")
    public void scrollWatchlistGroupToSeeCounterRowSearchByType(String counterType) throws InterruptedException {
        new WatchlistGroup().scrollWatchlistToSeeCounterType(counterType);
    }
    @And("Scroll to see WatchlistGroup counter name \"([^\"]*)\"$")
    public void scrollWatchlistGroupToSeeCounterRowSearchByName(String counterName) throws InterruptedException {
        new WatchlistGroup().scrollWatchlistToSeeCounterName(counterName);
    }
    @And("Tap on WatchlistGroup counter type \"([^\"]*)\"$")
    public void iTapOnACounterRowSearchByType(String counterType) throws InterruptedException {
        new WatchlistGroup().tapOnACounterRowSearchByType(counterType);
    }

    @And("Tap on WatchlistGroup counter name \"([^\"]*)\"$")
    public void iTapOnACounterRow(String counterName) throws InterruptedException {
        new WatchlistGroup().tapOnACounterRowSearchByName(counterName);
    }

    @And("Swipe WatchlistGroup to see Add Group button")
    public void swipeWatchlistGroupToSeeAddGroupButton() throws InterruptedException {
        new WatchlistGroup().swipeWatchlistToSeeAddbtn();
    }

    @And("Tap on WatchlistGroup row counter {int}")
    public void scrollWatchlistGroupOnFirstDetailRow(int number) {
        new WatchlistGroup().OpenWatchlistToSeeCounterDetail(number -1 );
    }

    @And("Tap on WatchlistGroup button Add Group")
    public void iTabonWatchlistGroupAddGroupBtn()
    {
        new WatchlistGroup().clickAddBtn();
    }

    @Then("Verify the number of Counter is {int}")
    public void verifyNumberOfCounter(int number)
    {
        new WatchlistGroup().verifyNumberOfCounter(number);
    }

    @Then("^Verify the value of counter WatchlistGroup counterType \"([^\"]*)\"$")
    public void verifyValueOfCounterInWatchlistGroupFindByCounterType(String counterType) throws Exception {
        new WatchlistGroup().verifyValueOfCounterFindByCounterType(counterType);
    }
    @Then("^Verify the value of counter WatchlistGroup counterName \"([^\"]*)\"$")
    public void verifyValueOfCounterInWatchlistGroupFindByCounterName(String counterName) throws Exception {
        new WatchlistGroup().verifyValueOfCounterFindByCounterName(counterName);
    }
    @Then("Verify the sorting of WatchlistGroup CounterTable column Name is correct$")
    public void verifyCounterTableSortedByColumnName() throws InterruptedException {
        WatchlistGroup watchlistGroupView = new WatchlistGroup();
        List<String> listOfName = watchlistGroupView.verticalToGetAllValueOfColumnName();
        new TestUtils().sortDescendingWithoutSensitive(listOfName);
        watchlistGroupView.tapOnColumnName();

        List<String> currentlistOfName = watchlistGroupView.verticalToGetAllValueOfColumnName();
        if (!listOfName.equals(currentlistOfName)) {
            Assert.fail("Descending sorting is not correct!");
        }

    }

    @Then("^Verify the value of counter Watchlist found by counterName \"([^\"]*)\" : counterType \"([^\"]*)\" counterCode " +
            "\"([^\"]*)\" counterChart \"([^\"]*)\" firstLabel \"([^\"]*)\" secondLabel \"([^\"]*)\" lastDonePrice \"([^\"]*)\" change \"([^\"]*)\" changePCT \"([^\"]*)\"" +
            " with showPrePostOption is \"([^\"]*)\" and scrollableHorizontal is \"([^\"]*)\" and landscapeMode is \"([^\"]*)\"$")
    public void verifyValueOfCounterInHomePageFindByCounterName(String counterName, String counterType, String counterCode
            , String counterChart, String firstLabel, String secondLabel, String lastDonePrice, String change, String changePCT
            , String showPrePostOption, String scrollableHorizontal, String landscape) throws Exception {
        CommonContentPage commonContentPage = new CommonContentPage();
        List<Date> dates = commonContentPage.getSGTradingTime();
        CounterRow counterRow;
        if(scrollableHorizontal.equalsIgnoreCase("true") || landscape.equalsIgnoreCase("true"))
        {
            HashMap<Integer, WebElement> counterAndRowIndex =  new WatchlistGroup().getCounterRowByName(counterName);
            BasePage basePage = new BasePage();
            WebElement row = basePage.getTheFirstWebElementOfAMap(counterAndRowIndex);
            int rowIndex = basePage.getKeyOfMap(counterAndRowIndex);
            counterRow = new CounterRowInWatchListScrollableHorizontal(row,rowIndex);
        }
        else {

            counterRow = new CounterRowInWatchListUnScrollableHorizontal(new WatchlistGroup().getCounterByName(counterName));

        }
        counterRow.verifyValueOfCounterName(counterName);
        counterRow.verifyValueOfCounterType(counterType);
        counterRow.verifyValueOfCounterCode(counterCode);
        counterRow.verifyValueOfCounterChart(counterChart);
        counterRow.verifyValueOfLastDonePrice(lastDonePrice);
        counterRow.verifyValueOfChange(change,showPrePostOption, counterType, dates.get(0), dates.get(1), dates.get(2));
        counterRow.verifyValueOfChangePCT(changePCT,showPrePostOption, counterType, dates.get(0), dates.get(1), dates.get(2));
        counterRow.verifyValueOfSecondLabel(secondLabel,showPrePostOption, counterType, dates.get(0), dates.get(1), dates.get(2));
        counterRow.verifyValueOfFirstLabel(firstLabel,showPrePostOption, counterType,dates.get(0), dates.get(1), dates.get(2));
    }
}
