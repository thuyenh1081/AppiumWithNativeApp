package com.qa.stepdef;

import com.qa.pages.CommonContentPage;
import com.qa.pages.Setting.Settings;
import io.cucumber.java.en.When;

public class SettingStepDef {

    @When("^Change app to light theme mode$")
    public void iChangeThemeToLight() throws InterruptedException {
        new CommonContentStepDef().iGoToSetting();
        new Settings().tapOnGeneral().tapOnTheme().changeToLightTheme();
    }

    @When("^Logout")
    public void iLogout() throws Exception {
        new CommonContentPage().goToPremarketPage();
    }

}
