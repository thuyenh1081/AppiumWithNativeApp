package com.qa.pages.market;

import com.qa.pages.CommonContentPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class MarketStockTopGainers extends CommonContentPage {
    public WebElement getHeaderLabel()
    {
        return getElementBaseOnAnElement(BackBtn, ".//following-sibling::XCUIElementTypeStaticText[@name='Top Gainers']");
    }

    @AndroidFindBy(id = appPackage+":id/tvChangeMarketTop")
    @iOSXCUITFindBy(accessibility = "Change")
    public WebElement ChangeOption;

    @AndroidFindBy(id = appPackage+":id/tvPCTChangeMarketTop")
    @iOSXCUITFindBy(accessibility = "Change%")
    public WebElement ChangePercentOption;

    public void ClickOnChangePercentOption()
    {
        clickWithExplicitWait(ChangePercentOption);
    }
    public void ClickOnChangeOption()
    {
        clickWithExplicitWait(ChangeOption);
    }
}
