package com.qa.stepdef.PayNow;

import com.qa.pages.PayNow.PayNowPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class PayNowDef {
    @Then("^Verify format PayNow label amount$")
    public void verifyFormatOfAmountLable(){
        PayNowPage payNowPage = new PayNowPage();
        payNowPage.verifyText(payNowPage.textInputLayout.getText(), "Amount (SGD)");
    }
    @Then("^Verify just could be input number PayNow textBox Amount$")
    public void verifyAmountJustAcceptNumberic(String currency){
        PayNowPage payNowPage = new PayNowPage();
        payNowPage.verifyJustOnlyInputNumberic(payNowPage.amountTxt);
    }
    @When("^Enter PayNow textBox amount \"([^\"]*)\"$")
    public void iEnterValueForAmount(String amount){
        PayNowPage payNowPage = new PayNowPage();
        payNowPage.sendKeys(payNowPage.amountTxt, amount);
    }
    @Then("^Verify enable PayNow button Continue is \"([^\"]*)\"$")
    public void verifyTheEnableOfContinueBtn(String isEnable){
        PayNowPage payNowPage = new PayNowPage();
        payNowPage.verifyAttributeOfAnElement(payNowPage.continueBtn, "isEnable",
                "true");
    }

    @Then("^Verify editable PayNow textBox Amount is \"([^\"]*)\"$")
    public void verifyTheEditableOfAmountTxt(String isEnable){
        PayNowPage payNowPage = new PayNowPage();
        payNowPage.verifyIsEditableOfAnElement(payNowPage.amountTxt,"true");
    }

    @Then("^Verify format PayNow textBox amount is \"([^\"]*)\"$")
    public void verifyFormatOfAmountValue(String fomrat){
        PayNowPage payNowPage = new PayNowPage();
        payNowPage.sendKeys(payNowPage.amountTxt, fomrat);
        payNowPage.verifyFormatOfAmount();
    }

    @When("^Tap on PayNow icon Back$")
    public void iTapOnBackBtn(String amount){
        new PayNowPage().clickOnBackBtn();
    }

    @When("^Tap on PayNow textBox TransferAccount")
    public void iTapOnDropdownIcon(){
        new PayNowPage().openAccountDropDownList();
    }

    @When("^Scroll to see PayNow dropDownList Account\"([^\"]*)\"$")
    public void scrollToSee(String account) throws Exception {
        PayNowPage payNowPage = new PayNowPage();
        payNowPage.swipeToFindAccount(account);
    }

    @When("^Tap on PayNow dropDownList account \"([^\"]*)\"$")
    public void iChooseAnccount(String account) throws Exception {
        PayNowPage payNowPage = new PayNowPage();
        payNowPage.clickOnAccount(account);
    }

    @When("^Tap on PayNow icon Continue$")
    public void iTapOnContinueBtn(String amount){
        new PayNowPage().clickOnContinueBtn();
    }

    @Then("^Verify the display of screen PayNow is \"([^\"]*)\"$")
    public void verifyTheExisitngOgPayNowScreen(String isExisted){
        PayNowPage payNowPage = new PayNowPage();
        payNowPage.VerifyTheExistingOfAnElement(payNowPage.accountDroplist, isExisted,
                "Content screen is expected " + isExisted + " but not" +isExisted);
    }
    @Then("Verify the sorting of PayNow list of Account is correct$")
    public void verifyCounterTableSortedByColumnName() throws InterruptedException {
        //lay thong tin danh sach account tu API tra ve
        // roi goi ham new TestUtils().sortAscendingWithoutSensitive(danhsach account);
        List<String> expectedList = null;

        PayNowPage payNowPage = new PayNowPage();
        payNowPage.openAccountDropDownList();
        List<String> listOfAccount = payNowPage.verticalToGetAllValueOfAccount();

        if (!listOfAccount.equals(expectedList)) {
            Assert.fail("Default of sorting is not Ascending");
        }

    }
    @Then("^Verify value PayNow message amount is \"([^\"]*)\"$")
    public void verifyDefaultMessageOfAmount(String value){
        PayNowPage payNowPage = new PayNowPage();
         payNowPage.verifyText(payNowPage.amountMessage.getText(), value);

    }
}
