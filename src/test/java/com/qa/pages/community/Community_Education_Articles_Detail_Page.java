package com.qa.pages.community;

//import io.appium.java_client.MobileElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class Community_Education_Articles_Detail_Page extends Community_Education_Page {

    // sử dụng thêm constructor có tham số truyền vào là tên guide, trong hoàm khởi tạo này thì để
    // gán giá trị header = Beginners là //XCUIElementTypeStaticText[@name="giá trị truyền vào"]
    @AndroidFindBy(id = "need to fill")
    @iOSXCUITFindBy(accessibility = "Article")
    private WebElement Article;
}
