package com.qa.stepdef.market;

import com.qa.pages.CommonContentPage;
import com.qa.pages.market.MarketModulePage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

public class MarketModulePageDef{
    @When("^Scroll MarketModule to see type \"([^\"]*)\"$")
    public WebElement scrollToSeeMarketType(String marketType)
    {
        return new MarketModulePage().horizontalToFindMarketTypeByName(marketType);
    }
    @When("^Tap on MarketModule type \"([^\"]*)\"$")
    public void iTabOnMarketType(String type)  {
        new MarketModulePage().clickOnMarketType(type);
    }
}
