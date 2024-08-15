package com.qa.pages.watchlist;

//import io.appium.java_client.MobileElement;

import com.qa.pages.CommonContentPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WatchlistModulePage extends CommonContentPage {
    public WatchlistModulePage()
    {
    }
    public WatchlistModulePage(Boolean isCheckPopup)
    {
        super(isCheckPopup);
    }
    @AndroidFindBy(id = appPackage+":id/btnWatchListMenu")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'ic_hamburger'")
    public WebElement WatchListMenuBtn;

//    com.tdt.pmobile3.p2:id/tabLayoutWatchList
    @AndroidFindBy(id = appPackage+":id/tabLayoutWatchList")
//    @AndroidFindBy(className = "android.widget.HorizontalScrollView")
//    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView[@resource-id='"+appPackage+":id/tabLayoutWatchList']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView[@name='SV_TOP_WATCH_LIST']")
    public WebElement tabLayoutWatchList;

    @AndroidFindBy(id = appPackage+":id/rvTopCounterWorldIndices")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='ic_bell']/following-sibling::[XCUIElementTypeScrollView]")
    public WebElement TopCounterWorldIndices;

    @AndroidFindBy(id = appPackage+":id/tvEditIndices")
    @iOSXCUITFindBy(className = "Edit Indices")
    private WebElement EditIndices;

    private List<CounterIndicesView> counterIndicesViewList;

    private  List<WebElement> listOfGroup()
     {
         return listOfElements(tabLayoutWatchList, ".//android.widget.LinearLayout[@content-desc !='']");
     }
    public  WebElement findIncidesByName(String IncidesName)
    {
        return findElementByName(TopCounterWorldIndices, IncidesName);
    }
    private  WebElement findGroupByName(String name)
    {
        return findElementByName(tabLayoutWatchList, name);
    }

    private String getNameOfIncides(WebElement incides)
    {
        return getNameOfElement(incides,appPackage+":id/tvNameCounterIndices");

    }

    private int[] pointsBasedOnTopCounterWorldIndices()
    {
        int[] points = new int[4];
        points[0] = TopCounterWorldIndices.getLocation().x+50;
        points[1] = TopCounterWorldIndices.getLocation().y;
        points[2] = TopCounterWorldIndices.getSize().width-150;
        points[3] = TopCounterWorldIndices.getSize().height;
        return points;
    }

    public void scrollWatchlistToSeeEditIndicies()
    {
        int[] points = pointsBasedOnTopCounterWorldIndices();
        while(!isExistingOfAnElement( EditIndices))
        {
            swipeGestureByCoodinator(points[0],points[1],points[2],points[3],"left", 1);
        }
    }

    public WebElement swipeToFindIncidesByName(String incidesName)
    {
        WebElement incides = findIncidesByName(incidesName);
        int[] points = pointsBasedOnTopCounterWorldIndices();
        while((incides == null))
        {
            swipeGestureByCoodinator(points[0],points[1],points[2],points[3],"left", 1);
            incides = findIncidesByName(incidesName);
            if(incides != null) break;

            if(isExistingOfAnElement( EditIndices)) {
                break;
            }
        }
        while((incides == null))
        {
           String firstName = getNameOfIncides(listOfIndices().get(0));
            swipeGestureByCoodinator(points[0],points[1],points[2],points[3],"right", 1);

            incides = findIncidesByName(incidesName);
            if(incides != null) break;
            String currentFirstName = getNameOfIncides(listOfIndices().get(0));
            System.out.println("firstName : " + firstName + "----" + currentFirstName);
            if(firstName.equals(currentFirstName)) {
                break;
            }
        }

        return incides;
    }
     public WebElement horizontalToFindWatchlistGroupTypeByName(String name)
     {
//         System.out.println("bat dau wait for" + utils.dateTime());
//         waitForVisibilityWithExplicitWait(driver.findElement(AppiumBy.xpath("" +
//                 "//android.view.ViewGroup[@resource-id=\"com.tdt.pmobile3.p2:id/swipeRefreshLayoutWatchList\"]" +
//                 "/android.widget.LinearLayout/android.view.ViewGroup[@resource-id=\"com.tdt.pmobile3.p2:id" +
//                 "/layoutTopBarWatchList\"]android.widget.HorizontalScrollView[@resource-id='"+appPackage+":id/tabLayoutWatchList']")));
//         System.out.println("tim tab lay out watuclist" + utils.dateTime());
//         WebElement e = driver.findElement(AppiumBy.xpath("" +
//                 "//android.widget.HorizontalScrollView[@resource-id='"+appPackage+":id/tabLayoutWatchList']"));
//         if(isExistingOfAnElement(e))  System.out.println("end tim tab lay out watuclist" +  utils.dateTime());
//            else System.out.println("cha thay me gi" + utils.dateTime());
         return horizontalToFindElementByName(name,tabLayoutWatchList);
     }


     private String getNameOfGroup(WebElement group)
     {
         return group.findElement(AppiumBy.className("android.widget.TextView")).getText();
     }


    public void OpenWatchlistMenu()
    {
        clickWithExplicitWait(WatchListMenuBtn);
    }

    public void OpenEditIncidesScreen()
    {
        clickWithExplicitWait(EditIndices);
    }

    public WatchlistGroup openWatchlistGroupView(String name)
    {
        clickWithExplicitWait(findGroupByName(name));
        return new WatchlistGroup();
    }


    public void openWatchlistGroupView(int groupNo)
    {
        clickWithExplicitWait(listOfGroup().get(groupNo -1));
    }


    private List<WebElement> listOfIndices()
    {
        return listOfElements(TopCounterWorldIndices,appPackage+":id/counterIndicesView");
    }

    public void verifyTheDisplayOfPage( String expected)
    {
        verifyTheDisplayOfPage(tabLayoutWatchList, "WatchlistModule screen", expected);
    }
@Override
    public void waitForFullDisplayOFAPage()
    {
        waitForVisibilityWithExplicitWait(tabLayoutWatchList);
        System.out.println("Watch");
    }
}
