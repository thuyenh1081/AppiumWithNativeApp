package com.qa.pages.market;

import com.qa.pages.CommonContentPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class MarketUTWorstPerforming extends CommonContentPage {
    public WebElement getHeaderLabel()
    {
        return getElementBaseOnAnElement(BackBtn, ".//following-sibling::XCUIElementTypeStaticText[@name='Worst Performing']");
    }
    @AndroidFindBy(id = appPackage+":id/tvDailyMarketTop")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Daily']']")
    public WebElement Daily;

    @AndroidFindBy(id = appPackage+":id/tvWeeklyMarketTop")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Weekly']")
    public WebElement Weekly;

    @AndroidFindBy(id = appPackage+":id/tvMonthlyMarketTop")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Monthly']")
    public WebElement Monthly;

    public void clickOnDaily()
    {
        clickWithExplicitWait(Daily);
    }
    public void clickOnWeekly()
    {
        clickWithExplicitWait(Weekly);
    }
    public void clickOnMonthly()
    {
        clickWithExplicitWait(Monthly);
    }
}
