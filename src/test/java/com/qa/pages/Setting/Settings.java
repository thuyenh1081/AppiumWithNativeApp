package com.qa.pages.Setting;

import com.qa.pages.CommonContentPage;
import com.qa.pages.LoginPage;
import com.qa.pages.Popup.CommonPopup;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class Settings extends CommonContentPage {

//	public Settings()
//	{
//		super();
//		waitForVisibilityWithExplicitWait(General);
//	}
	@AndroidFindBy(id = appPackage+":id/btnLogout")
	@iOSXCUITFindBy(accessibility = "Logout")
	public WebElement Logout;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='"+appPackage+":id/tvValueMeSettingCommon' and @text = 'General']")
	@iOSXCUITFindBy(iOSNsPredicate = "name == 'General' AND label == 'General' AND type == 'XCUIElementTypeButton'")
	public WebElement General;

	public LoginPage logout()
	{
		clickWithExplicitWait(Logout);
		new CommonPopup().clickOKBtn();
		return new LoginPage();
	}

	public General tapOnGeneral()
	{
		clickWithExplicitWait(General);
		return new General();
	}
//	@Override
//	public void waitForTheDisplayOfThePage()
//	{
//		super.waitForTheDisplayOfThePage();
//		waitForVisibilityWithExplicitWait(General);
//	}
}
