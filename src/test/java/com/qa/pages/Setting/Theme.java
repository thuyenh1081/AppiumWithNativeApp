package com.qa.pages.Setting;

import com.qa.pages.CommonContentPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class Theme extends CommonContentPage {


	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Dark']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Dark']/preceding-sibling::XCUIElementTypeButton")
	public WebElement Dark;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Light']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Light']/preceding-sibling::XCUIElementTypeButton[1]")
	public WebElement Light;

	public void changeToLightTheme()
	{
		clickWithExplicitWait(Light);
		clickWithExplicitWait(BackBtn);
		clickWithExplicitWait(BackBtn);
		clickWithExplicitWait(BackBtn);
	}

	public void clickOnDark()
	{
		clickWithExplicitWait(Dark);
	}
}
