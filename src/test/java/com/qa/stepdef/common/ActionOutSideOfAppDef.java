package com.qa.stepdef.common;

import com.qa.pages.BasePage;
import com.qa.pages.Popup.CommonPopup;
import com.qa.utils.TestUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class ActionOutSideOfAppDef {

    @When("^Touch the snapshort of app")
    public void iTouchToAppearAppAgain() throws IOException {
        new BasePage().touchToAppearAppAgain();
    }

    @When("^Kill app")
    public void iKillApp() throws IOException {
        new BasePage().activeApp();
//        new BasePage().backToApp();
    }

    @When("^Background the app$")
    public void iRunAppInBackground() throws IOException {
        new BasePage().backgroundApp();
    }
    @When("^Background the app by open Setting app$")
    public void iRunAppInBackgroundByOpenSettingApp() throws IOException {
        new BasePage().openSettingOfDevice();
    }
    @When("^Terminate the app$")
    public void iterminateApp() throws IOException {
        new BasePage().terminateApp();
    }

    @When("^Lock device$")
    public void iLockTheDevice() throws IOException {
        new BasePage().closeScreen();
    }
    @When("^Turn on Wifi mode$")
    public void iTurnOnWifi() throws IOException {
        new BasePage().configureWifiMode("true");
    }
    @When("^Turn off Wifi mode$")
    public void iTurnOffWifi() throws IOException {
            new BasePage().configureWifiMode("false");
    }
    @When("^Open Setting of Device$")
    public void iOpenSettingOfDevice() throws IOException {
        new BasePage().openSettingOfDevice();
    }
    @Then("^Verify Popup incase no internet connection is \"([^\"]*)\"$")
    public void verifyTheExisitngOfPayNowScreen(String message) throws Exception {
        new CommonPopup().verifyErrorMessage(message);
    }

}
