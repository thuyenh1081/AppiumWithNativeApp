package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class PreMarketPage extends CommonContentPage {

	@AndroidFindBy(id = appPackage+":id/llLogin")
	@iOSXCUITFindBy(accessibility = "Have an account?, Log In")
	private WebElement llLogin;

	@AndroidFindBy(id = appPackage+":id/tvDoNotHaveAccount")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Have an account?']//following::XCUIElementTypeStaticText")
	private WebElement Signup;

	@AndroidFindBy(id = appPackage+":id/btnLogin")
//	@AndroidFindBy(id = appPackage+":id/tvLogin")
	@iOSXCUITFindBy(accessibility = "LOGIN")
	public WebElement PreMarket_LoginLink;

	public LoginPage clickOnPreMarket_LoginLink() {
		System.out.println("starting click PreMarket_LoginBtn-----" +  utils.dateTime());
		click(PreMarket_LoginLink);
//		waitForVisibilityWithExplicitWait(new LoginPage().accountTxtFld);
		System.out.println("stoping click PreMarket_LoginBtn-----" +  utils.dateTime());
		return new LoginPage(true);
	}
}
