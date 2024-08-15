package com.qa.stepdef.popup;

import com.qa.pages.CommonContentPage;
import com.qa.pages.Popup.CommonPopup;
import com.qa.pages.Popup.HaveAllowAndNotAllowPopup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PopupDef {
    @Then("^Verify the display of Popup PhotoAccessPermission is \"([^\"]*)\"$")
    public void verifyExistingOfPhotoAccessPermissionPopup(String isExisted)  {
        HaveAllowAndNotAllowPopup haveAllowAndNotAllowPopup = new HaveAllowAndNotAllowPopup();
        haveAllowAndNotAllowPopup.VerifyTheExistingOfAnElement(haveAllowAndNotAllowPopup.allowBtn, isExisted,
                "Content screen is expected " + isExisted + " but not" +isExisted);
    }
}
