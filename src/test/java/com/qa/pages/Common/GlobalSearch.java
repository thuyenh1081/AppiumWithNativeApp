package com.qa.pages.Common;

import com.qa.pages.CommonContentPage;
import com.qa.pages.TradeTicket.TradeTicketCFD;
import com.qa.pages.trade.TradeCFDPage;
import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GlobalSearch extends CommonContentPage {

    @AndroidFindAll({
            @AndroidBy(id = appPackage+":id/edtSearch")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(accessibility = "TF_SEARCH")
    })
    public WebElement SearchTxt;

    @AndroidFindBy(id = appPackage+":id/ivSearchTopNavBar")// tai community là "+appPackage+":id/ivDiscoverSearch
    @iOSXCUITFindBy(accessibility = "ic search white")
    public WebElement SearchIcon;

    @AndroidFindBy(id = appPackage+":id/tabLayoutSearch")
    @iOSXCUITFindBy(accessibility = "later")
    public WebElement tabLayoutSearch;

    @AndroidFindBy(id = appPackage+":id/rvFilterProduct")
    @iOSXCUITFindBy(accessibility = "later")
    public WebElement rvFilterProduct;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Counters']")
    @iOSXCUITFindBy(accessibility = "Counters")
    private WebElement Counters;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='News']")
    @iOSXCUITFindBy(accessibility = "News")
    private WebElement News;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Community']")
    @iOSXCUITFindBy(accessibility = "Community")
    private WebElement Community;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Articles']")
    @iOSXCUITFindBy(accessibility = "Articles")
    private WebElement Articles;


    @AndroidFindBy(id = appPackage+":id/rvContainerStockCompanies")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeScrollView'")
    private WebElement ResultArea;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget." +
            "RecyclerView[@resource-id='"+appPackage+":id/rvContainerStockCompanies']/android.widget.LinearLayout[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]")
    private WebElement FirstResult;

    public void tabOnNews()
    {
        clickWithExplicitWait(News);
    }
    public void tabOnCounters()
    {
        clickWithExplicitWait(Counters);
    }
    public void tabOnCommunity()
    {
        clickWithExplicitWait(Community);
    }
    public void tabOnArticles()
    {
        clickWithExplicitWait(Articles);
    }

    public void makeASeach(String searchKey)
    {
        sendKeys(SearchTxt, searchKey);
        waitForFullDisplayOFAPage();
    }

    public List<WebElement> getListOfResult()
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform))
            return ResultArea.findElements(AppiumBy.className("android.view.ViewGroup"));
        else return ResultArea.findElements(AppiumBy.className("XCUIElementTypeButton"));
    }
    public WebElement getResultByIndex(int rowNumber)
    {
        if (rowNumber == 0) return FirstResult;
        return getListOfResult().get(rowNumber);
    }

    public TradeTicketCFD clickOnResultAtRowIndex(int rowNumber)
    {
        WebElement element = getResultByIndex(rowNumber);
        clickByCoordinator(element, element.getLocation().x + element.getSize().width/2, element.getLocation().y + element.getSize().height/2);
        return new TradeTicketCFD();
    }

    @Override
    public void waitForFullDisplayOFAPage()
    {
        waitForVisibilityWithExplicitWait(FirstResult);
    }
}
