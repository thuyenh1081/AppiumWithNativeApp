package com.qa.pages;

//import io.appium.java_client.MobileElement;

import com.qa.pages.Popup.CommonPopup;
import com.qa.pages.Popup.HaveAllowAndNotAllowPopup;
import com.qa.pages.Popup.HaveOkAndCancelBtnPopup;
import com.qa.pages.Popup.SessionTimoutPopup;
import com.qa.pages.home.HomeModulePage;
import com.qa.pages.market.MarketModulePage;
import com.qa.pages.me.Me;
import com.qa.pages.trade.TradeModulePage;
import com.qa.pages.watchlist.WatchlistGroup;
import com.qa.pages.watchlist.WatchlistModulePage;
import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommonContentPage extends BasePage{

    public CommonContentPage()
    {

    }
    public CommonContentPage(Boolean isCheckPopup)
    {
        waitForInvisibleWithExplicitWait(ProgressBar);

        if(isCheckPopup) {
            try {
                iCloseNotification();
                System.out.println("check popup from common content Page");
            } catch (Exception ex) {
            }
        }
    }

    @AndroidFindBy(className = "android.widget.ProgressBar")
    @iOSXCUITFindBy(accessibility = "In progress")
    public WebElement ProgressBar;

    @AndroidFindBy(id = appPackage+":id/bottomNavDashBoard")
    @iOSXCUITFindBy(accessibility = "Tab Bar")
    private WebElement bottomNavDashBoard;

    @AndroidFindBy(id = appPackage+":id/item_home")
    @iOSXCUITFindBy( accessibility = "Home")
    public WebElement Home;

    @AndroidFindBy(id = appPackage+":id/item_watch_list")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Watchlist'")
    public WebElement Watchlist;

    @AndroidFindBy(id = appPackage+":id/item_market")
    @iOSXCUITFindBy(accessibility = "Markets")
    public WebElement Market;

    @AndroidFindBy(id = appPackage+":id/item_trade")
    @iOSXCUITFindBy(accessibility = "Trade")
    public WebElement Trade;

    @AndroidFindBy(id = appPackage+":id/item_community")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Community'")
    public WebElement Community;

    @AndroidFindBy(id = appPackage+":id/item_me")
    @iOSXCUITFindBy(accessibility = "Me")
    public WebElement Me;

    @AndroidFindAll({
            @AndroidBy(id = appPackage+":id/iv_search"),
            @AndroidBy(id = appPackage+":id/ivSearchTopNavBar"),
            @AndroidBy(id = appPackage+":id/ivDiscoverSearch")
    })
    @iOSXCUITFindBy(accessibility = "ic search white")
    public WebElement SearchIcon;

    @AndroidFindBy(id = appPackage+":id/iclNotifyTopNavBar")//tai man hinh cimmunity là "+appPackage+":id/ivNotifyTopNavBar
    @iOSXCUITFindBy(accessibility = "ic_db_notification")
    private WebElement Notify;


    @AndroidFindAll({
            @AndroidBy(accessibility = "btnBack"),
            @AndroidBy(id = appPackage+":id/imageBack"),
            @AndroidBy(id = appPackage+":id/btnBack")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(iOSNsPredicate = "name == 'BTN_BACK'"),
            @iOSXCUITBy(accessibility = "ic_arrow_left"),
            @iOSXCUITBy(accessibility = "ic_arrow_left_black"),
            @iOSXCUITBy(accessibility = "_TtGC7SwiftUI19UIHosting")
    })
    public WebElement BackBtn;

    @AndroidFindBy(id = appPackage+":id/connectivityStatus")
    @iOSXCUITFindBy(accessibility = "No internet connection")
    public WebElement Footer;

    @AndroidFindBy(id = appPackage+":id/connectivityStatus")
    @iOSXCUITFindBy(accessibility = "Back online")
    public WebElement Footer_incaseInternet;

    public <T extends CommonContentPage> T tabOnBackBtn()
    {
        clickWithExplicitWait(BackBtn);
        waitForInvisibleWithExplicitWait(ProgressBar);
        return null;
    }

    public void tabOnSearchIcon()
    {
        clickWithExplicitWait(SearchIcon);
        closeKeyBoard();
    }

    public HomeModulePage OpenHomeTab() {
        clickWithExplicitWait(Home);
        return new HomeModulePage(true);
    }

    public WatchlistModulePage OpenWatchlistTab() {
        clickWithExplicitWait(Watchlist);
        return new WatchlistModulePage(true);
    }

    public TradeModulePage OpenTradeTab(){
        clickWithExplicitWait(Trade);
        return new TradeModulePage(true);
    }

    public MarketModulePage OpenMarketTab(){
        clickWithExplicitWait(Market);
        MarketModulePage marketModulePage = new MarketModulePage();
//        marketModulePage.waitForTheDisplayOfThePage();
        return marketModulePage;
    }
    public void OpenCommunityTab(){
        clickWithExplicitWait(Community);
    }
    public Me OpenMeTab(){
        clickWithExplicitWait(Me);
        return new Me();
    }
    public List<Date> getSGTradingTime()
    {
        String currentTime = utils.dateTime(); //yyyy-MM-dd-HH-mm-ss
        String year = currentTime.substring(0,4);
        String month = currentTime.substring(5,7);
        String day = currentTime.substring(8,10);
        String hour = currentTime.substring(11,13);
        String minute = currentTime.substring(14,16);
        String second = currentTime.substring(17,19);
        String daylightDate = year+"-"+"03"+"-"+"10"+"-"+hour+"-"+minute+"-"+second;
        Date currentTimeInEST = utils.getHourAfterToday(-12);
        Date currentTimeInSGT = utils.getHourAfterToday(1);
        String startESTradingHour = year+"-"+month+"-"+day+"-"+"04"+"-"+"00"+"-"+"00";
        String endESTradingHour = year+"-"+month+"-"+day+"-"+"09"+"-"+"30"+"-"+"00";
        String startSGTradingHour;
        String endSGTradingHour ;
        Date currentDateInDateFomat = utils.convertStringToDate(currentTime);
        if(currentDateInDateFomat.after(utils.convertStringToDate(daylightDate)))
        {
            startSGTradingHour = year+"-"+month+"-"+day+"-"+"16"+"-"+"00"+"-"+"00";
            endSGTradingHour = year+"-"+month+"-"+day+"-"+"21"+"-"+"30"+"-"+"00";
        }
        else
        {
            startSGTradingHour = year+"-"+month+"-"+day+"-"+"17"+"-"+"00"+"-"+"00";
            endSGTradingHour = year+"-"+month+"-"+day+"-"+"22"+"-"+"30"+"-"+"00";
        }
        Date startSGTradingHourInDateFomat = utils.convertStringToDate(startSGTradingHour);
        Date endSGTradingHourInDateFomat = utils.convertStringToDate(endSGTradingHour);

        List<Date> times =  new ArrayList<Date>();
        times.add(currentTimeInSGT);
        times.add(startSGTradingHourInDateFomat);
        times.add(endSGTradingHourInDateFomat);
        return times;
    }
    public void reloadPage()
    {
        new BasePage().swipeToPullDownPage();
    }
    public void iCloseNotification() {
        String title ="";

        while (isExistingOfAnElement(new CommonPopup().DialogAlert))
        {
            System.out.println( "has found the popup" + utils.dateTime());

            CommonPopup commonPopup = new CommonPopup();
            title= commonPopup.getMessage();
            switch(title)
            {
                case "Do you want to receive POEMS Notifications for this account on this device?":
                    new HaveOkAndCancelBtnPopup().cancelPOEMSNotification();
                    break;
//                case "Unauthorized":
//                    commonPopup.clickOKBtn();
//                    break;
//                case "We're sorry, but something went wrong. Please try again later.":
//                    commonPopup.clickOKBtn();
//                    break;
                case "Please re-verify yourself to continue":
                    SessionTimoutPopup sessionTimoutPopup = new SessionTimoutPopup();
                    sessionTimoutPopup.inputPass(getDataFromXMLFile("data/strings.xml").get("passForTimeout"));
                    sessionTimoutPopup.clickOKBtn();
                    break;
                default:
                    commonPopup.clickOKBtn();
                    break;
            }
        }
        System.out.println( "stop checking pop up" + utils.dateTime());
    }

    public PreMarketPage goToPremarketPage(){

//        CommonContentPage commonContentPage = new CommonContentPage();

        if(isExistingOfAnElement(new PreMarketPage().PreMarket_LoginLink)) return new PreMarketPage();

        while(!isExistingOfAnElement(Me))
        {
            if(isExistingOfAnElement(new PreMarketPage().PreMarket_LoginLink)) break;
            clickWithExplicitWait(BackBtn);
        }
        OpenMeTab().clickOnSettingIcon().logout().clickOnBackBtn();

        return new PreMarketPage();

    }


    public void allowAccessPhoto()
    {
        HaveAllowAndNotAllowPopup haveAllowAndNotAllowPopup = new HaveAllowAndNotAllowPopup();
        if( isExistingOfAnElement(haveAllowAndNotAllowPopup.allowBtn))
        {
            clickWithExplicitWait(haveAllowAndNotAllowPopup.allowBtn);
        }
    }

    public WebElement getFooterByContent(String message)
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform))
        {
            return null;
        }
        else
        {
            return driver.findElement(AppiumBy.accessibilityId(message));
        }
    }

    public void clickOnBackBtn()
    {
        clickWithExplicitWait(BackBtn);
    }


    public void verifyTheDisplayOfPage(WebElement signalToMakeSurePageIsDisplayed, String pageName, String expected)
    {
        VerifyTheExistingOfAnElement(signalToMakeSurePageIsDisplayed, expected,
                pageName +" screen is expected " + expected + " but not" + expected);
    }


}
