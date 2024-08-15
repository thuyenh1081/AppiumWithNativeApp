package com.qa.stepdef.watchlist;

import com.qa.pages.watchlist.WatchlistGroup;
import com.qa.pages.watchlist.WatchlistSettingDisplay;
import com.qa.pages.watchlist.WatchListSetting;
import com.qa.pages.watchlist.WatchlistSettingColumns;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WatchlistSettingDef {

    @When("^Tap on WatchlistSetting icon Back$")
    public WatchlistGroup iTabOnWatchlistSettingBackIcon()
    {
        return new WatchListSetting().tabOnBackBtn();
    }


    @When("^Tap on WatchlistSetting tab Columns$")
    public void iTabOnWatchlistSettingColumnTab()
    {
       new WatchListSetting().tabOnCoumnTab();
    }
    @When("^Tap on WatchlistSetting tab Display")
    public void iTabOnWatchlistSettingDisplayTab()
    {
        new WatchListSetting().tabOnDisplayTab();
    }

    @When("^Turn on WatchlistSetting tab Display icon ShowPreAndPostMarket")
    public void showPreAndPostMarket()
    {
        new WatchlistSettingDisplay().showPreAndPostMarket();
    }
    @When("^Turn off WatchlistSetting tab Display icon ShowPreAndPostMarket")
    public void unShowPreAndPostMarket()
    {
        new WatchlistSettingDisplay(true).unShowPreAndPostMarket();
    }
    @When("^Turn on WatchlistSetting tab Display icon ShowNewStream")
    public void showNewStream()
    {
        new WatchlistSettingDisplay().ShowNewStream();
    }
    @When("^Turn off WatchlistSetting tab Display icon ShowNewStream")
    public void unShowNewStream()
    {
        new WatchlistSettingDisplay(true).unShowNewStream();
    }
    @When("^Tap on WatchlistSetting tab Group$")
    public void iTabOnWatchlistSettingGroupTab()
    {
        new WatchListSetting().tabOnGroupTab();
    }
    @When("^Tap on WatchlistSetting tab Columns row \"([^\"]*)\"$")
    public void iTabOnWatchlistSettingColumnName(String columnName)
    {
        new WatchlistSettingColumns().tabOnRow(columnName);
    }

    @When("^Scroll to see WatchlistSetting tab Columns checkBox \"([^\"]*)\"$")
    public void scrollToSeeCheckBox(String checkBoxName)
    {
        WatchlistSettingColumns settingColumns = new WatchlistSettingColumns();
        settingColumns.swipeToFindCheckBox(checkBoxName);
        settingColumns.VerifyTheExistingOfAnElement(settingColumns.getCheckBox(checkBoxName),
                "true", checkBoxName + " is not existed !");
    }

    @When("^Tap on WatchlistSetting tab Columns checkBox \"([^\"]*)\"$")
    public void iCheckOnColumnNamed(String columnBoxName)
    {
        new WatchlistSettingColumns().checkOnCheckBox(columnBoxName);
    }

    @When("^Drag WatchlistSetting tab Columns checkBox \"([^\"]*)\" to \"([^\"]*)\"$")
    public void DragCheckBox(String checkBox1, String checkBox2)
    {
        new WatchlistSettingColumns().dragCheckBox(checkBox1, checkBox2);
    }
    @Then("^Verify checking on WatchlistSetting column \"([^\"]*)\" is \"([^\"]*)\"$")
    public void verifyColumnIsChecked(String columnName, String isChecked) throws Exception {
        WatchlistSettingColumns settingColumns = new WatchlistSettingColumns();
        settingColumns.verifyCheckBoxIsChecked(columnName, isChecked);

    }
}
