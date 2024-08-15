package com.qa.pages;

//import io.appium.java_client.MobileElement;
import com.qa.pages.home.HomeModulePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;

public class LoginPage extends CommonContentPage {
	public LoginPage()
	{
	}
	public LoginPage(Boolean isCheckPopup)
	{
		super(isCheckPopup);
	}

	@AndroidFindBy(id = appPackage+":id/edtInputAccount")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='POEMS Account Number']/../XCUIElementTypeTextField")
	public WebElement accountTxtFld;

	@AndroidFindBy(id = appPackage+":id/ctContentPassWord")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='POEMS Account Password']/../XCUIElementTypeSecureTextField")
	private WebElement passwordTxtFld;

	@AndroidFindBy(id = appPackage+":id/buttonPlaceholder")
	@iOSXCUITFindBy(accessibility = "LOGIN")
	public WebElement loginBtn;

	@AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView")
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name='BTN_POP_UP_CONFIRM']/preceding-sibling::XCUIElementTypeStaticText")
	private WebElement errTxt;


	public void enterAccountNo(String username) {
		clear(accountTxtFld);
		sendKeys(accountTxtFld, username, "login with " + username);
	}

	public void enterPassword(String pass) {
		clear(passwordTxtFld);
		sendKeys(passwordTxtFld, pass, "login with " + pass);
	}

	public HomeModulePage clickLoginBtn(){
		int x = (int)(driver.manage().window().getSize().width/2);
		int y = (int) (loginBtn.getLocation().y + Math.round(loginBtn.getSize().height*0.65));
//		clickByCoordinator(loginBtn, x,  y);
		clickWithExplicitWait(loginBtn);
		waitForInvisibleWithExplicitWait(loginBtn);
		HomeModulePage homeModulePage = new HomeModulePage();
		for (int i = 0; i< 5 ; i++ ) {
			if(isExistingOfAnElement(homeModulePage.Home)) break;
			try {
				System.out.println("still could not login successfully");
				waitForInvisibleWithExplicitWait(ProgressBar);
				iCloseNotification();
				clickWithExplicitWait(loginBtn);
			} catch (Exception e) {

			}
		}
		return homeModulePage;
	}

	public void loginByAccountType(String accountType) throws Exception {
		JSONObject loginUsers = getDataByKey("data/loginUsers.json");
		enterAccountNo(loginUsers.getJSONObject(accountType).getString("username"));
		enterPassword(loginUsers.getJSONObject(accountType).getString("password"));
//		closeKeyBoard();
	    HomeModulePage home  = clickLoginBtn();
	}

	public void loginByAccount(String account, String pass) throws Exception {
		enterAccountNo(account);
		enterPassword(pass);
		clickLoginBtn();
	}


	public void verifyTheDisplayOfPage( String expected)
	{
		verifyTheDisplayOfPage(loginBtn, "Login screen", expected);
	}

	@Override
	public void waitForFullDisplayOFAPage()
	{
		waitForVisibilityWithExplicitWait(loginBtn);
		System.out.println("Login");
	}
}
