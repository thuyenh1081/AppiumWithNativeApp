package com.qa.stepdef.watchlist;

import com.qa.pages.Common.GlobalSearch;
import com.qa.pages.watchlist.GroupMenu;
import io.cucumber.java.en.When;

public class GroupMenuDef {

    @When("^Tap on Watchlist GroupMenu icon Setting$")
    public void iTabOnWatchlistGroupMenuSettingIcon()
    {
        new GroupMenu().tapOnSettingIcon();
    }
}
