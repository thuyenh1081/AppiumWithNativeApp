package com.qa.pages.watchlist;

import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class WatchlistSettingColumns extends WatchListSetting {

    @AndroidFindBy(id = appPackage+":id/rvContainerSettingItem")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable")
    private WebElement ColumnItemTable;


    private List<WebElement> listOfColumn()
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform))
        return ColumnItemTable.findElements(AppiumBy.id(appPackage+":id/cardView"));
        else
        return ColumnItemTable.findElements(AppiumBy.xpath("//XCUIElementTypeCell"));
    }


    public String getNameOfColumn(WebElement row)
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform))
            return row.findElement(AppiumBy.id(appPackage+":id/tvTitleItemSetting")).getText();
        else return row.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText")).getText();
    }

    public WebElement getColumnRow(String nameOfColumn)
    {
        String pathToGetRow = "";
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform))
            pathToGetRow = "//android.widget.TextView[@text='"+nameOfColumn+"']/parent::*[1]/..";
//            else return ColumnItemTable.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='"+nameOfColumn+"']"));
        else pathToGetRow = "//XCUIElementTypeStaticText[@name='"+nameOfColumn+"']";

        return getRow(ColumnItemTable, pathToGetRow);
    }
    public WebElement getCheckBox(String nameOfCheckbox)
    {
            return getCheckBox(getColumnRow(nameOfCheckbox));
    }
    public WebElement getCheckBox(WebElement columnRow)
    {
        try
        {
            if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform))
                return columnRow.findElement(AppiumBy.className("android.widget.CheckBox"));
//            return ColumnItemTable.findElement(AppiumBy.androidUIAutomator("new UiSelector().text('"+nameOfCheckbox+"')"));
            else return ColumnItemTable.findElement(AppiumBy.xpath("//XCUIElementTypeButton"));
        }
        catch (Exception ignored)
        {}
        return null;
    }
    public WebElement getColumnRow(int index)
    {
        return listOfColumn().get(index);
    }

    public void tabOnRow(String columnName)
    {
        clickWithExplicitWait(swipeToFindColumn(columnName));
    }

    public void checkOnCheckBox(String checkBoxName)
    {
        WebElement e = getCheckBox(checkBoxName);
        checkOnCheckBox(e);
    }
    public void verifyCheckBoxIsChecked(String checkBoxName, String isChecked)
    {
        WebElement e = getCheckBox(checkBoxName);
            if(isChecked.equalsIgnoreCase("true")) {
                Assert.assertTrue(isChecked(e), "Column " + checkBoxName + "is expected to check is : " + isChecked + " but not" + isChecked);
            }
            if(isChecked.equalsIgnoreCase("false"))
            {
                Assert.assertFalse(isChecked(e), "Column " + checkBoxName + "is expected to check is : " + isChecked + " but not" + isChecked);
            }
    }


    public WebElement swipeToFindCheckBox(String checkBoxName)
    {
        try
        {
            return getCheckBox(swipeToFindColumn(checkBoxName));
        }
        catch (Exception ex)
        {
            return null;
        }
    }

    public void dragCheckBox(String checkBox1, String checkBox2)
    {
        WebElement row1 = swipeToFindColumn(checkBox1);
        VerifyTheExistingOfAnElement(row1 ,"true", checkBox1 + "is not displayed");

        WebElement row2 = getColumnRow(checkBox2);

        while((row2 == null))
        {
            WebElement lastRow = listOfColumn().get(listOfColumn().size()-1);
            int endX = lastRow.getLocation().x;
            int endY = lastRow.getLocation().y + lastRow.getSize().height;
            dragByElement(row1,endX,endY);
            swipeGestureByElement(ColumnItemTable, "up", 1);

            row2 = getColumnRow(checkBox2);
            if(row2 != null) break;

            String lastName = getNameOfColumn(lastRow);
            System.out.println("lastName : getNameOfColumn" + lastName);
            if(lastName.equals(checkBox1)) {
                break;
            }
        }

        if(row2 != null)
        {
            int endX = 0;
            int endY = row2.getLocation().y + row2.getSize().height;
            dragByElement(row1,endX,endY);

            return;
        }

        while((row2 == null))
        {
            WebElement firstRow = listOfColumn().get(listOfColumn().size()-1);

            int endX = firstRow.getLocation().x;
            int endY = firstRow.getLocation().y;
            dragByElement(row1,endX,endY);

            swipeGestureByElement(ColumnItemTable, "down", 1);

            row2 = getColumnRow(checkBox2);
            if(row2 != null) break;

            String firstName = getNameOfColumn(firstRow);
            System.out.println("firstName : " + firstName );
            if(firstName.equals(checkBox1)) {
                break;
            }
        }

        VerifyTheExistingOfAnElement(row2 ,"true", checkBox2 + "is not displayed");

        int endX = row2.getLocation().x;
        int endY = row2.getLocation().y;
        dragByElement(row1,endX,endY);
    }

    public WebElement swipeToFindColumn(String checkBoxName)
    {
        String xpathToGetName = null;
        String xpathToGetElements = null;
        String xpathToGetRow = null;
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            xpathToGetRow = ".//android.widget.TextView[@text='"+checkBoxName+"']/parent::*[1]/..";
            xpathToGetName = ".//android.widget.TextView[@resource-id='"+appPackage+":id/tvTitleItemSetting']";
            xpathToGetElements = ".//android.view.ViewGroup[@resource-id='"+appPackage+":id/cardView']";
        }
        else {
            xpathToGetRow = ".//XCUIElementTypeStaticText[@name='"+checkBoxName+"']";
            xpathToGetName = ".//XCUIElementTypeStaticText";
            xpathToGetElements = ".//XCUIElementTypeCell";
        }
        return verticalToFindElementByName(xpathToGetRow, xpathToGetName,xpathToGetElements,ColumnItemTable);
    }
}
