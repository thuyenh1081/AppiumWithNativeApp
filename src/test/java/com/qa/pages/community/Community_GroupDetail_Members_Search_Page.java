package com.qa.pages.community;

//import io.appium.java_client.MobileElement;

import com.qa.pages.CommonContentPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class Community_GroupDetail_Members_Search_Page extends CommonContentPage {

    @AndroidFindBy(id = "need to fill")
    @iOSXCUITFindBy(accessibility = "ic_search_gray_bold")
    private WebElement Search;
}
