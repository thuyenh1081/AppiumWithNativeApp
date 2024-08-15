package com.qa.stepdef;

import com.qa.pages.BasePage;
import com.qa.pages.Common.Disconnection;
import com.qa.pages.Common.GlobalSearch;
import com.qa.pages.CommonContentPage;
import com.qa.pages.LoginPage;
import com.qa.pages.Popup.HaveOkAndCancelBtnPopup;
import com.qa.pages.Popup.SessionTimoutPopup;
import com.qa.pages.Setting.Settings;
import com.qa.pages.counter.CounterDetail;
import com.qa.pages.market.*;
import com.qa.pages.me.Me;
import com.qa.pages.trade.TradeModulePage;
import com.qa.pages.watchlist.WatchListSetting;
import com.qa.pages.watchlist.WatchlistGroup;
import com.qa.pages.watchlist.WatchlistModulePage;
import com.qa.stepdef.trade.TradeModuleDef;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

public class CommonContentStepDef {

    @When("^Tap on Poems notification cancel$")
    public void iTabOnCancelBtnOfPoemsNotification()  {
            new HaveOkAndCancelBtnPopup().cancelPOEMSNotification();
    }
    @When("^Tap on Poems notification agree$")
    public void iTabOnAgreeBtnOfPoemsNotification()  {
            new HaveOkAndCancelBtnPopup().clickOKBtn();
    }

    @Then("^Verify value footer back online$")
    public void verifyValueOfFooterBackOnline() throws Exception {
        CommonContentPage commonContentPage = new CommonContentPage();
        commonContentPage.verifyText("data/NoInternet.xml", "BackOnlineMsg" ,
                commonContentPage.getText(commonContentPage.Footer_incaseInternet));
    }

    @Then("^Verify value footer is \"([^\"]*)\"$")
    public void verifyValueOfFooter(String key) throws Exception {
        CommonContentPage commonContentPage = new CommonContentPage();
        commonContentPage.verifyText("data/NoInternet.xml", key , commonContentPage.getText(commonContentPage.Footer));
    }

    @When("^Verify the display of Footer is \"([^\"]*)\"$")
    public void verifyExistingOfFooter(String isExisted){
        CommonContentPage commonContentPage = new CommonContentPage();
        commonContentPage.VerifyTheExistingOfAnElement(commonContentPage.Footer, isExisted,
                "Footer is expected " + isExisted + " but not" +isExisted);
    }

    @When("^Switch to landscape mode for the \"([^\"]*)\"")
    public void iSwitchScreenToLandscapse(String screen) throws InterruptedException {

        switch (screen)
        {
            case "Watchlist":
                new WatchlistGroup().tapOnRotateIcon();
                break;
            default:
                break;
        }
    }

    @When("^Scroll down to load more data screen \"([^\"]*)\"$")
    public void iScrollScreenToGetMoreData(String screen) throws InterruptedException {
        CommonContentPage commonContentPage = new CommonContentPage();
        WebElement element = null;
        switch (screen)
        {
            case "Watchlist":
                element = new WatchlistGroup().CounterTableDefault;
                break;
            default:
                break;
        }
        commonContentPage.scrollGestureByElement(element, "down", 1);
    }

    @When("^Wait for \"([^\"]*)\" second$")
    public void iWaitForAConstanstTime(String second){

        new BasePage().waitWithConstantTime(Long.parseLong(second));
    }

    @When("^Open an url \"([^\"]*)\"$")
    public void iOpenUrl(String url) throws Exception {
        new BasePage().openURL(new BasePage().getDataFromXMLFile("data/strings.xml").get(url));
    }
    @When("^Verify the display of Popup SessionTimout is \"([^\"]*)\"$")
    public void verifyExistingOfPopup(String isExisted){
        SessionTimoutPopup sessionTimoutPopup = new SessionTimoutPopup();
        sessionTimoutPopup.waitForClickableWithExplicitWait(sessionTimoutPopup.passTxt);
        sessionTimoutPopup.VerifyTheExistingOfAnElement(sessionTimoutPopup.passTxt, isExisted,
                "Popup is expected " + isExisted + " but not" +isExisted);
    }
    @When("^Enter pass for SSTO popup$")
    public void iEnterPassForSSTO() throws Exception {
        SessionTimoutPopup sessionTimoutPopup = new SessionTimoutPopup();
        sessionTimoutPopup.waitForClickableWithExplicitWait(sessionTimoutPopup.passTxt);
        sessionTimoutPopup.sendKeys(sessionTimoutPopup.passTxt, sessionTimoutPopup.
                getDataFromXMLFile("data/strings.xml").get("passForTimeout"));
    }
    @When("^Verify the display of Disconnect is \"([^\"]*)\"$")
    public void verifyExistingOfDisconnect(String isExisted){
        Disconnection disconnect = new Disconnection();
        disconnect.VerifyTheExistingOfAnElement(disconnect.NoInternetImage, isExisted,
                "NoInternetImage is expected " + isExisted + " but not" +isExisted);
        disconnect.VerifyTheExistingOfAnElement(disconnect.LookLikeOfflineTxt, isExisted,
                "LookLikeOfflineTxt is expected " + isExisted + " but not" +isExisted);
        disconnect.VerifyTheExistingOfAnElement(disconnect.NoInternetImageTxt, isExisted,
                "NoInternetImageTxt is expected " + isExisted + " but not" +isExisted);
        disconnect.VerifyTheExistingOfAnElement(disconnect.RefreshBtn, isExisted,
                "RefreshBtn is expected " + isExisted + " but not" +isExisted);
        disconnect.VerifyTheExistingOfAnElement(disconnect.TryAgainTxt, isExisted,
                "TryAgainTxt is expected " + isExisted + " but not" +isExisted);
    }

    @When("^Tap on Disconnection button TryAgain$")
    public void iTapOnDisconnectionTryAgainBtn(String second) throws Exception {

        Disconnection disconnection = new Disconnection();
        disconnection.clickOnTryAgainBtn();
    }
    @When("^Wait for run out of time the display of Back Online message$")
    public void iWaitForDisappearBackOnlineMsg(String second) throws Exception {

        BasePage basePage = new BasePage();
        iWaitForAConstanstTime(basePage.getDataFromXMLFile("data/NoInternet.xml").get("TimeForDisplayBackOnlineMsg"));
    }
    @When("^Wait for try connecting internet$")
    public void iWaitForRecheckingInternet(String second) throws Exception {

        BasePage basePage = new BasePage();
        iWaitForAConstanstTime(basePage.getDataFromXMLFile("data/NoInternet.xml").get("TimeForReCheckInternet"));
    }
    @When("^Wait for session timeout$")
    public void iWaitForSessionTimeOut() throws Exception {
        BasePage basePage = new BasePage();
        iWaitForAConstanstTime(basePage.getDataFromXMLFile("data/strings.xml").get("sessionTimeOut"));

    }
    @When("^Pull down the page \"([^\"]*)\"$")
    public void iPullDownThePage(String screen) throws InterruptedException {
        CommonContentPage commonContentPage = new CommonContentPage();
        WebElement element = null;
        switch (screen)
        {
            case "Market":
                element = new MarketModulePage().rvStockMarkets;
                break;
            default:
                break;
        }
        commonContentPage.swipeToPullDownPage(element);
    }

    @When("^Tap on another tab on the \"([^\"]*)\"$")
    public void iTapOnOtherTabOnTheScreen(String screen) throws InterruptedException {
        CommonContentPage commonContentPage = new CommonContentPage();
        switch (screen)
        {
            case "WatchlistSetting":
                WatchListSetting watchListSetting = new WatchListSetting();
                watchListSetting.tabOnCoumnTab();
                break;
            default:
                break;
        }
        commonContentPage.reloadPage();
    }

    @When("^Tap on an element of \"([^\"]*)\" that init a new screen$")
    public void iTapOnElementToCallAScreen(String screen) throws InterruptedException {
        CommonContentPage commonContentPage = new CommonContentPage();
        switch (screen)
        {
            case "Watchlist":
                new WatchlistGroup().tapOnSettingIcon();
                break;
            default:
                break;
        }
        commonContentPage.reloadPage();
    }
    @When("^Tap on an element of \"([^\"]*)\" that require call API but not init a new screen$")
    public void iTapOnElementToCallAPIButNotMoveToOTherScreen(String screen) throws InterruptedException {
        CommonContentPage commonContentPage = new CommonContentPage();
        switch (screen)
        {
            case "Watchlist":
                new WatchlistGroup().turnOnChart();
                break;
            default:
                break;
        }
        commonContentPage.reloadPage();
    }
    @When("^Tap on an element to trigger popup displaying at \"([^\"]*)\"$")
    public void iTapOnElementToShowPopup(String screen) throws InterruptedException {
        CommonContentPage commonContentPage = new CommonContentPage();
        switch (screen)
        {
            case "Setting":
                new Settings().logout();
                break;
            default:
                break;
        }
        commonContentPage.reloadPage();
    }

    @When("^Tap on Watchlist$")
    public void iTabOnWatchlist(){
        new CommonContentPage().OpenWatchlistTab();
    }
    @When("^Tap on Trade")
    public TradeModulePage iTabOnTrade(){
        return new CommonContentPage().OpenTradeTab();
    }
    @When("^Tap on TradeStock")
    public TradeModulePage iTabOnTradeStock(){
        TradeModuleDef tradeModuleDef = new TradeModuleDef();
        tradeModuleDef.scrollToSeeTradeType("Stock");
        return tradeModuleDef.iTabOnTradeType("Stock");
    }
    @When("^Tap on TradeUT")
    public TradeModulePage iTabOnTradeUT(){
        TradeModuleDef tradeModuleDef = new TradeModuleDef();
        tradeModuleDef.scrollToSeeTradeType("UT");
        return tradeModuleDef.iTabOnTradeType("UT");
    }
    @When("^Tap on TradeRobo")
    public TradeModulePage iTabOnTradeRobo(){
        TradeModuleDef tradeModuleDef = new TradeModuleDef();
        tradeModuleDef.scrollToSeeTradeType("Robo");
        return tradeModuleDef.iTabOnTradeType("Robo");
    }
    @When("^Yen test$")
    public void test() throws InterruptedException {
        new CommonContentPage().OpenTradeTab();
    }
    @When("^Tap on Home$")
    public void iTabOnHomeTab(){
        new CommonContentPage().OpenHomeTab();
    }
    @When("^Tap on Market$")
    public void iTabOnMarketTab(){
        new CommonContentPage().OpenMarketTab();
    }
    @When("^Tap on Community$")
    public void iTabCommunityTab(){
        new CommonContentPage().OpenCommunityTab();
    }
    @When("^Tap on Me")
    public void iTabMeTab(){
        new CommonContentPage().OpenMeTab();
    }
    @Then("^Verify the display of ContentApp is \"([^\"]*)\"$")
    public void contentAppIsOpen(String isExisted)  {
        CommonContentPage contentPage = new CommonContentPage();
        contentPage.VerifyTheExistingOfAnElement(contentPage.Home, isExisted,
                "Content screen is expected " + isExisted + " but not" +isExisted);
    }
    @When("^Go to screen Watchlist$")
    public WatchlistModulePage iGoToWatchlist() throws InterruptedException {
        return new CommonContentPage().OpenWatchlistTab();
    }

    @When("^Go to screen Me")
    public void iGoToMe() throws InterruptedException {
        iTabMeTab();
    }
    @When("^Go to screen Search Counter$")
    public void iGoToSearchCounter() throws InterruptedException {
        iGoToWatchlist();
        new WatchlistGroup().OpenWatchlistToSeeCounterDetail(0);
        new CounterDetail().tabOnSearchIcon();
    }
    @When("^Go to screen Edit Counter$")
    public void iGoToEditCounter() throws InterruptedException {
        iGoToWatchlist();
        new WatchlistGroup().tapOnEditIcon();
    }
    @When("^Go to screen WatchlistSetting$")
    public WatchListSetting iGoToWatchlistSetting() throws InterruptedException {
        iGoToWatchlist();
        return new WatchlistGroup().tapOnSettingIcon();
    }
    @When("^Go to screen WatchlistSetting Display$")
    public void iGoToWatchlistSettingDisplay() throws InterruptedException {
        iGoToWatchlistSetting().tabOnDisplayTab();
    }
    @When("^Go to screen WatchlistSetting Groups$")
    public void iGoToWatchlistSettingGroup() throws InterruptedException {
        iGoToWatchlistSetting().tabOnGroupTab();
    }
    @When("^Go to screen WatchlistSetting Columns$")
    public void iGoToWatchlistSettingColumn() throws InterruptedException {
        iGoToWatchlistSetting().tabOnCoumnTab();
    }
    @When("^Go to screen Global Search$")
    public void iGoToGlobalSearch() throws InterruptedException {
        new CommonContentPage().tabOnSearchIcon();
    }
    @When("^Go to screen Global Search News$")
    public void iGoToGlobalSearchNews() throws InterruptedException {
        iGoToGlobalSearch();
        new GlobalSearch().tabOnNews();
    }
    @When("^Go to screen Global Search Community$")
    public void iGoToGlobalSearchCommunity() throws InterruptedException {
        iGoToGlobalSearch();
        new GlobalSearch().tabOnCommunity();
    }
    @When("^Go to screen Global Search Articles$")
    public void iGoToGlobalSearchArticles() throws InterruptedException {
        iGoToGlobalSearch();
        new GlobalSearch().tabOnArticles();
    }
    @When("^Go to screen Global Search Counters$")
    public void iGoToGlobalSearchCounters() throws InterruptedException {
        iGoToGlobalSearch();
        new GlobalSearch().tabOnCounters();
    }
    @When("^Go to screen Market$")
    public MarketModulePage iGoToMarket() throws InterruptedException {
        MarketModulePage market  = new CommonContentPage().OpenMarketTab();
        return market;
    }
    @When("^Go to screen Market Stock$")
    public void iGoToMarketStock() throws InterruptedException {
        MarketModulePage marketModulePage = iGoToMarket();
        marketModulePage.horizontalToFindMarketTypeByName("Stocks");
        marketModulePage.clickOnMarketType("Stocks");
    }
    @When("^Go to screen Market Stock Indicies Change$")
    public void iGoToMarketStockIndiciesChange() throws InterruptedException {
        iGoToMarketStock();
        new MarketStockPage().clickOnViewAll();
        new MarketStockIndices().ClickOnChangeOption();
    }
    @When("^Go to screen Market Top Volumn$")
    public void iGoToMarketStockTopVolumn() throws InterruptedException {
        iGoToMarketStock();
        new MarketStockPage().clickOnTopVolume();
    }
    @When("^Go to screen Market Top Gainer$")
    public void iGoToMarketStockTopGainer() throws InterruptedException {
        iGoToMarketStock();
        new MarketStockPage().clickOnTopGainer();
    }
    @When("^Go to screen Market Top Gainer Change%$")
    public void iGoToMarketStockTopGainerChangePercent() throws InterruptedException {
        iGoToMarketStockTopGainer();
        new MarketStockTopGainers().ClickOnChangeOption();
    }
    @When("^Go to screen Market Top Gainer Change$")
    public void iGoToMarketStockTopGainerChange() throws InterruptedException {
        iGoToMarketStockTopGainer();
        new MarketStockTopGainers().ClickOnChangePercentOption();
    }
    @When("^Go to screen Market Top Losers$")
    public void iGoToMarketStockTopLoser() throws InterruptedException {
        iGoToMarketStock();
        new MarketStockPage().clickOnTopGainer();
    }
    @When("^Go to screen Market Top Losers Change%$")
    public void iGoToMarketStockTopLoserChangePercent() throws InterruptedException {
        iGoToMarketStockTopLoser();
        new MarketStockTopLosers().ClickOnChangeOption();
    }
    @When("^Go to screen Market Top Losers Change$")
    public void iGoToMarketStockTopLoserChange() throws InterruptedException {
        iGoToMarketStockTopLoser();
        new MarketStockTopLosers().ClickOnChangePercentOption();
    }
    @When("^Go to screen Market UT$")
    public void iGoToMarketUT() throws InterruptedException {
        MarketModulePage marketModulePage = iGoToMarket();
        marketModulePage.horizontalToFindMarketTypeByName("UT");
        marketModulePage.clickOnMarketType("UT");
    }
    @When("^Go to screen Market Top Performing$")
    public void iGoToMarketStockTopPerforming() throws InterruptedException {
        iGoToMarketUT();
        new MarketUTPage().clickOnTopPerforming();
    }
    @When("^Go to screen Market Top Performing Daily$")
    public void iGoToMarketUTTopPerformingDaily() throws InterruptedException {
        iGoToMarketStockTopPerforming();
        new MarketUTTopPerforming().clickOnDaily();
    }
    @When("^Go to screen Market Top Performing Weekly$")
    public void iGoToMarketUTTopPerformingWeekly() throws InterruptedException {
        iGoToMarketStockTopPerforming();
        new MarketUTTopPerforming().clickOnWeekly();
    }
    @When("^Go to screen Market Top Performing Monthly$")
    public void iGoToMarketUTTopPerformingMonthly() throws InterruptedException {
        iGoToMarketStockTopPerforming();
        new MarketUTTopPerforming().clickOnMonthly();
    }
    public void iGoToMarketStockWorstPerforming() throws InterruptedException {
        iGoToMarketUT();
        new MarketUTPage().clickOnWorstPerforming();
    }
    @When("^Go to screen Market Worst Performing Daily$")
    public void iGoToMarketUTWorstPerformingDaily() throws InterruptedException {
        iGoToMarketStockWorstPerforming();
        new MarketUTTopPerforming().clickOnDaily();
    }
    @When("^Go to screen Market Worst Performing Weekly$")
    public void iGoToMarketUTWorstPerformingWeekly() throws InterruptedException {
        iGoToMarketStockWorstPerforming();
        new MarketUTTopPerforming().clickOnWeekly();
    }
    @When("^Go to screen Market Worst Performing Monthly$")
    public void iGoToMarketUTWorstPerformingMonthly() throws InterruptedException {
        iGoToMarketStockWorstPerforming();
        new MarketUTTopPerforming().clickOnMonthly();
    }

    @When("^Go to screen Market News$")
    public void iGoToMarketNews() throws InterruptedException {
        MarketModulePage marketModulePage = iGoToMarket();
        marketModulePage.horizontalToFindMarketTypeByName("News");
        marketModulePage.clickOnMarketType("News");
    }
    @When("^Go to screen Market News MyNews$")
    public void iGoToMarketNewsMyNews() throws InterruptedException {
        iGoToMarketNews();
        MarketNews marketNews = new MarketNews();
        marketNews.horizontalToFindNewsTypeByName("My News");
        marketNews.clickOnNewsType("My News");
    }
    @When("^Go to screen Market Calender$")
    public void iGoToMarketCalender() throws InterruptedException {
        MarketModulePage marketModulePage = iGoToMarket();
        marketModulePage.horizontalToFindMarketTypeByName("Calendar");
        marketModulePage.clickOnMarketType("Calendar");
    }
    @When("^Go to screen Market Calender Setting$")
    public void iGoToMarketCalenderSetting() throws InterruptedException {
        iGoToMarketCalender();
        new MarketCalenderPage().clickOnSettingIcon();
    }
    @When("^Go to screen Setting$")
    public void iGoToSetting() throws InterruptedException {
        iGoToMe();
        new Me().clickOnSettingIcon();
    }
    @When("^Go to screen \"([^\"]*)\"$")
    public void iGoToScreen(String screen) throws InterruptedException {
        CommonContentPage commonContentPage;
        switch(screen)
        {
            case "Watchlist":
                commonContentPage = iGoToWatchlist();
                break;
            case "Trade":
                commonContentPage = iTabOnTrade();
                break;
            case "TradeStock":
                iTabOnTrade();
                commonContentPage = iTabOnTradeStock();
                break;
            case "TradeUT":
                iTabOnTrade();
                commonContentPage = iTabOnTradeUT();
                break;
            case "TradeRobo":
                iTabOnTrade();
                commonContentPage = iTabOnTradeRobo();
                break;
            default:
                commonContentPage = new CommonContentPage();
                break;
        }
        commonContentPage.waitForFullDisplayOFAPage();
    }

    @Then("Verify the display of the screen \"([^\"]*)\" is \"([^\"]*)\"$")
    public void verifyTheExistingOfCounterDetail$(String screen, String expected) throws Exception {
        switch(screen) {
            case "Watchlist":
                WatchlistModulePage watchlistModulePage = new WatchlistModulePage();
                watchlistModulePage.verifyTheDisplayOfPage(expected);
                break;
            case "Login":
                LoginPage loginPage = new LoginPage();
                loginPage.verifyTheDisplayOfPage(expected);
                break;
            case "CounterDetai":
                CounterDetail counterDetail = new CounterDetail();
                counterDetail.verifyTheDisplayOfPage(expected);
                break;
            default:
                break;
        }
    }

    @When("^Tap on button Back$")
    public void iBackToPreviousScreen(String message) throws Exception {
        CommonContentPage commonContentPage = new CommonContentPage();
        commonContentPage.clickOnBackBtn();
    }

    @When("^Get the time for the display of Footer with message \"([^\"]*)\"$")
    public void iTimeOfTheDisplayMessage(String message){
//        CommonContentPage commonContentPage = new CommonContentPage();
//        if(commonContentPage.getDataFromXMLFile("data/NoInternet.xml").get(message).equalsIgnoreCase(
//                TestUtils.ConnectingMsg))
//        {
//            commonContentPage.waitForClickableWithExplicitWait(commonContentPage.getFooterByMessage(
//                    commonContentPage.getDataFromXMLFile("data/NoInternet.xml").get(message)));
//            commonContentPage.getTimeOfPreviousDisplayOfConnectingMsg = commonContentPage.getTimeOfCurrentDisplayOfConnectingMsg;
//            commonContentPage.getTimeOfCurrentDisplayOfConnectingMsg = new TestUtils().dateTime();
//
//        }
    }
    @Then("^Verify the display of Disconnection icon Loading is \"([^\"]*)\"$")
    public void verifyExistingOfLoadingConnectingIcon(String isExisted){
        Disconnection disconnection = new Disconnection();
        disconnection.VerifyTheExistingOfAnElement(disconnection.LoadingIcon, isExisted,
                "LoadingIcon is expected " + isExisted + " but not" +isExisted);
    }
    @Then("^Verify the display of Disconnection button TryAgain is \"([^\"]*)\"$")
    public void verifyExistingOfTryAgainConnectingIcon(String isExisted){
        Disconnection disconnection = new Disconnection();
        disconnection.VerifyTheExistingOfAnElement(disconnection.RefreshBtn, isExisted,
                "RefreshTryAgainBtn is expected " + isExisted + " but not" +isExisted);
    }

}
