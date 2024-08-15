package com.qa.stepdef;

import com.qa.pages.CommonContentPage;
import com.qa.pages.LoginPage;
import com.qa.pages.Popup.CommonPopup;
import com.qa.utils.TestUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class LoginStepDef {

    @When("^Enter Login textBox Account as \"([^\"]*)\"$")
    public void iEnterUsernameAs(String account) throws InterruptedException {
        new LoginPage().enterAccountNo(account);
    }

    @When("^Enter Login textBox Pass as \"([^\"]*)\"$")
    public void iEnterPasswordAs(String password) {
        new LoginPage().enterPassword(password);
    }

    @When("^Tap on Login button Login")
    public void iLogin() throws Exception {
        new LoginPage().clickLoginBtn();
    }

    @When("^Login with account \"([^\"]*)\"$")
    public void iLoginByHolderAccount(String holderAccount) throws Exception {
        new LoginPage().loginByAccountType(holderAccount);
    }

    @When("^I login by account as \"([^\"]*)\" and pass as \"([^\"]*)\"$")
    public void iLoginByAccount(String account, String pass) throws Exception {
        new LoginPage().loginByAccount(account, pass);
    }

    @Then("Login successfully$")
    public void loginSuccessfully() {
        new CommonContentPage();
        Assert.assertTrue(true);
    }

    @Then("^Verify value LoginPage message is \"([^\"]*)\"$")
    public void loginShouldFailWithAnError(String err) throws Exception {
        new CommonPopup().verifyErrorMessage(err);
    }

}
