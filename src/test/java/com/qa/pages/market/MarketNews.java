package com.qa.pages.market;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class MarketNews extends  MarketModulePage{

    @AndroidFindBy(id = appPackage+":id/layoutGroup")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView[1]")
    public WebElement tabLayoutNews;

    private WebElement findNewsTypeByName(String name)
    {
        return findElementByName(tabLayoutNews, name);
    }
    public void clickOnNewsType(String type)
    {
        clickWithExplicitWait(findNewsTypeByName(type));
        waitForVisibilityWithExplicitWait(tabLayoutNews);
    }

    public WebElement horizontalToFindNewsTypeByName(String name)
    {
        return horizontalToFindElementByName(name, tabLayoutNews);
    }


}
