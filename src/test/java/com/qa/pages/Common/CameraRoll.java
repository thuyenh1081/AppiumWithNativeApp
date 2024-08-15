package com.qa.pages.Common;

import com.qa.pages.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class CameraRoll extends BasePage {

    @AndroidFindBy(id = appPackage+":id/recycler")
    @iOSXCUITFindBy(xpath = "adadad")
    private WebElement ImageView;

    @AndroidFindBy(id = appPackage+":id/ps_tv_complete")
    @iOSXCUITFindBy(accessibility = "Add")
    private WebElement AddIcon;

    @AndroidFindBy(id = appPackage+":id/ps_tv_select_num")
    @iOSXCUITFindBy(accessibility = "Cancel")
    private WebElement SelectedImageIcon;

    public WebElement getImage(int index)
    {
        return listOfElements(ImageView, "//android.widget.RelativeLayout").get(index);
    }
    public WebElement getTheFirstImage()
    {   return getImage(0);}
    private WebElement getCheckBoxIcon(WebElement image)
    {
        return image.findElement(AppiumBy.id(appPackage+":id/tvCheck"));
    }
    public void checkOnImage(WebElement image)
    {
        clickWithExplicitWait(getCheckBoxIcon(image));
    }
    public void checkOnTheFirstImage()
    {
        clickWithExplicitWait(getCheckBoxIcon(getTheFirstImage()));
    }
}
