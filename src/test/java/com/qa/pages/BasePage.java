package com.qa.pages;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.google.common.collect.ImmutableMap;
import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.PropertyManager;
import com.qa.utils.TestUtils;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;

import static io.appium.java_client.touch.offset.PointOption.point;
@Listeners(ExtentITestListenerAdapter.class) // this for generate report extent-html.htlm
public class BasePage {
//    private AppiumDriver<?> driver;
    public AppiumDriver driver;
    protected static  HashMap<String, String> strings = new HashMap<String, String>();

    public TestUtils utils = new TestUtils();

//    Properties props = new PropertyManager().getProps();
//    public final String appPackage = props.getProperty("androidAppPackage").toString();
//    public final String appPackage = "sg.com.poems.mobile3";
    public final String appPackage = "com.tdt.pmobile3.p2";
//      public final String appPackage = "com.tdt.Pmobile3.p2.internal";

    public BasePage(){
        this.driver = new DriverManager().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
//        appPackage = driver.getCapabilities().getCapability("appium:appPackage").toString();
    }

    public AppiumDriver getDriver()
    {
        return driver;
    }
    @AndroidFindBy(xpath = "//*[contains(@text,'Wi-Fi')]")
    @iOSXCUITFindBy(accessibility = "Wi-Fi")
    private WebElement wifi;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'switch') and contains(@content-desc,'Wi')]")
    @iOSXCUITFindBy( className = "XCUIElementTypeSwitch")
    private WebElement wifiToggle;

    @AndroidFindBy(xpath = "//*[contains(@id,'switch')][3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='Airplane Mode']")
    private WebElement airplaneBtn;

    public void waitForFullDisplayOFAPage()
    {
        System.out.println("goc");
    }

    public void waitForVisibilityWithImplicitWait()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.WAIT));
    }

    public void waitForVisibilityWithExplicitWait(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.LONG_WAIT));
//         wait.until(ExpectedConditions.visibilityOf(e)).isDisplayed(); // add isDisplayed >>> slow
        wait.until(ExpectedConditions.visibilityOf(e));
    }
    public void waitForInvisibleWithExplicitWait(WebElement e) {
        for (int i=0; i< 120000; i=i+2000)
        {
            System.out.println("waiting for dispapear loading icon");
            waitWithConstantTime(2000);
            if(!isExistingOfAnElement(e)) break;
        }
    }
    public void waitForClickableWithExplicitWait(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.LONG_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(e));
    }

    public void waitForVisibilityWithFluentWait(WebElement e){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(TestUtils.LONG_WAIT))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void waitWithConstantTime(long seconds){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForVisibilityWithExplicitWait(By e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.LONG_WAIT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(e));
    }

    public void tapPoint(Point point) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), point.getX(), point.getY()));
        tap.addAction(finger.createPointerDown(0));
        tap.addAction(finger.createPointerUp(0));
        driver.perform(Collections.singletonList(tap));
    }

    public void tapElement(WebElement element) {
        Rectangle rec = element.getRect();
        int centerX = rec.getX() + (rec.getWidth() / 2);
        int centerY = rec.getY() + (rec.getHeight() / 2);
        clickByCoordinator(element, centerX, centerY);
        Point elementLocation = new Point(centerX, centerY);
        tapPoint(elementLocation);
    }

    public void clear(WebElement e) {
        waitForVisibilityWithExplicitWait(e);
        e.clear();
    }

    public boolean isChecked(WebElement e)
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            return e.getAttribute("checked").equalsIgnoreCase("true");
        }
        else
        {
            return e.getAttribute("value").equalsIgnoreCase("1") ? true:false;
        }
    }

    public void checkOnCheckBox(WebElement checkBox) {
        if(checkBox != null )
        {
                if (!isChecked(checkBox))
                {
                    if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
                        clickWithExplicitWait(checkBox);
                    }
                    else
                    {
                        int x = checkBox.getLocation().x + checkBox.getSize().width;
                        int y = checkBox.getLocation().y + checkBox.getSize().height/2;
                        clickByCoordinator(checkBox,x,y);
                    }
                }
        }
    }
    public void unCheckOnCheckBox(WebElement checkBox) {
        if(checkBox != null )
        {
                if (isChecked(checkBox)) {
                    if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
                        clickWithExplicitWait(checkBox);
                    }
                    else
                    {
                        int x = checkBox.getLocation().x + checkBox.getSize().width;
                        int y = checkBox.getLocation().y + checkBox.getSize().height/2;
                        clickByCoordinator(checkBox,x,y);
                    }
                }
        }
    }

    public void click(WebElement e) {
        e.click();
    }
    public void clickWithExplicitWait(WebElement e) {
        waitForVisibilityWithExplicitWait(e);
        e.click();
    }

    public void click(By e, String msg) {
        driver.findElement(e).click();
    }
    public void clickByCoordinator(WebElement element, int X, int Y) {
        Point elementLocation = new Point(X, Y);
        tapPoint(elementLocation);
    }
    public void closeKeyBoard()
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.IosPlatform)) {

        /* ((IOSDriver) driver).hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Done"); // Done can change to whatever valid on our screen
            ((IOSDriver) driver).hideKeyboard(HideKeyboardStrategy.TAP_OUTSIDE);
            last_iOSKeyboardKey.click(); //my favourite. last_iOSKeyboardKey you can find by any way you know.
            // last 4 is tap yourself outside in any place on screen outside keyboard e.g. in center of header*/

//        ((IOSDriver) driver).hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Done");

            driver.findElement(By.xpath("//XCUIElementTypeKeyboard//XCUIElementTypeButton[@name='Return']")).click();
        }
        else {
//        click( new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.BACK));
            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
//          or  ((AndroidDriver) driver).hideKeyboard();

        }
    }

    public void sendKeys(WebElement e, String txt) {
        e.sendKeys(txt);
    }

    public void sendKeys(WebElement e, String txt, String msg) {
        sendKeys(e, txt);
    }

    public String getAttribute(WebElement e, String attribute) {
//        waitForVisibilityWithExplicitWait(e);
        return e.getAttribute(attribute);
    }

    public String getAttribute(By e, String attribute) {
//        waitForVisibilityWithExplicitWait(e);
        return driver.findElement(e).getAttribute(attribute);
    }

    public String getText(WebElement e, String msg) {
        return getText(e);
    }
    public String getText(WebElement e) {
        String txt = null;
        try {
            switch (new GlobalParams().getPlatformName()) {
                case "Android":
                    txt = getAttribute(e, "text");
                    break;
                case "iOS":
                    txt = getAttribute(e, "label");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + new GlobalParams().getPlatformName());
            }

        }
        catch (Exception ex)
        {}
        return txt;
    }
    public String getText(By e, String msg) {
        String txt;
        switch(new GlobalParams().getPlatformName()){
            case "Android":
                txt = getAttribute(e, "text");
                break;
            case "iOS":
                txt = getAttribute(e, "label");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + new GlobalParams().getPlatformName());
        }
        return txt;
    }

    public boolean isExistingOfAnElement(WebElement e)
    {

        try {
                return e.isDisplayed();
        }
        catch (Exception ex)
        {
            return false;
        }
    }

    public void VerifyTheExistingOfAnElement(WebElement e, String isExisted, String msg)
    {

       switch (isExisted)
        {
            case "true":
                Assert.assertTrue(isExistingOfAnElement(e), msg);
                break;
            case  "false":
                Assert.assertFalse(isExistingOfAnElement(e), msg);
                break;
            default: break;
        }
    }

    public  boolean scrollGestureByCoodinator(int left, int top, int width, int height, String direction, double percent) {
        boolean canScrollMore = true;
        if (new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            switch (direction) {
                case "right":
                    canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                            "left", left, "top", top,
                            "width", width - 10,
                            "height", height,
                            "speed", 1000,
                            "direction", "right",
                            "percent", percent
                    ));
                    break;
                case "down":
                    canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                            "left", left, "top", top,
                            "width", width,
                            "height", height,
                            "speed", 500,
                            "direction", "down",
                            "percent", percent
                    ));
                    break;
                default:
                    break;
            }
        }
        else
        {
            Map<String, Object> params = new HashMap<>();

            params.put("left", left);
            params.put("top", top);
            params.put("width", width);
            params.put("height", height);
            params.put("speed", 500);
            params.put("percent", percent);
            switch (direction) {
                case "right":
                    params.put("direction", "right");
                    break;
                case "down":
                    params.put("direction", "down");
                    break;
                case "left":
                    params.put("direction", "left");
                    break;
                case "up":
                    params.put("direction", "up");
                    break;
                default:
                    break;
            }
            driver.executeScript("mobile: scroll", params);
        }
        System.out.println(canScrollMore);
        return canScrollMore;
    }

    public  boolean scrollGestureByElement(WebElement element, String direction, double percent) {
        boolean canScroll = false;
        if (new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            switch (direction) {
                case "right":
                    canScroll = (boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                            "elementId", ((RemoteWebElement) element).getId(),
                            "direction", "right",
                            "speed", 500,
                            "percent", percent
                    ));
                    break;
                case "down":
                    canScroll = (boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                            "elementId", ((RemoteWebElement) element).getId(),
                            "direction", "down",
                            "speed", 500,
                            "percent", percent
                    ));
                    break;
                default:
                    break;
            }
        }
        else
        {
            Map<String, Object> params = new HashMap<>();
            params.put("element",((RemoteWebElement)element).getId());
            params.put("speed", 500);
            params.put("percent", percent);
            switch (direction) {
                case "right":
                    params.put("direction", "right");
                    break;
                case "down":
                    params.put("direction", "down");
                    break;
                case "left":
                    params.put("direction", "left");
                    break;
                case "up":
                    params.put("direction", "up");
                    break;
                default:
                    break;
            }
            driver.executeScript("mobile: scroll", params);
        }
        System.out.println("can scroll down more: " + canScroll);
        return canScroll;
    }
    public boolean scrollScreen( String  direction) {
        Dimension size = driver.manage().window().getSize();
        int left = 100;
        int top = (int) (size.width * 0.5);
        int width = 100;
        int height = (int) (size.width * 0.9);

        return scrollGestureByCoodinator(left, top, width, height, direction, 1);
    }
    public  void swipeGestureByElement(WebElement element, String direction, double percent) {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            switch (direction) {
                case "right":
                    driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                            "elementId", ((RemoteWebElement) element).getId(),
                            "direction", "right",
                            "speed", 500,
                            "percent", percent
                    ));
                    break;
                case "left":
                    driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                            "elementId", ((RemoteWebElement) element).getId(),
                            "direction", "left",
                            "speed", 500,
                            "percent", percent
                    ));
                    break;
                case "up":
                    driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                            "elementId", ((RemoteWebElement) element).getId(),
                            "direction", "up",
                            "speed", 500,
                            "percent", percent
                    ));
                    break;
                case "down":
                    driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                            "elementId", ((RemoteWebElement) element).getId(),
                            "direction", "down",
                            "speed", 500,
                            "percent", percent
                    ));
                    break;
                default:
                    break;
            }
        }
        else
        {
            Map<String, Object> params = new HashMap<>();
            params.put("element",((RemoteWebElement)element).getId());
            params.put("speed", 500);
            params.put("percent", percent);
            switch (direction)
            {
                case "right":
                    params.put("direction", "right");
                    break;
                case "left":
                    params.put("direction", "left");
                    break;
                case "up":
                    params.put("direction", "up");
                    break;
                case "down":
                    params.put("direction", "down");
                    break;
                default:
                    break;
            }
            driver.executeScript("mobile: swipe", params);
        }
        waitForVisibilityWithImplicitWait();
    }

    public  void swipeGestureByCoodinator(int x, int y, int width, int height, String direction, double percent) {
            switch (direction) {
                case "right":
                    driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                            "left", x, "top", y, "width", width, "height", height,
                            "direction", "right",
                            "speed", 500,
                            "percent", percent
                    ));
                    break;
                case "left":
                    driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                            "left", x, "top", y, "width", width, "height", height,
                            "direction", "left",
                            "speed", 500,
                            "percent", percent
                    ));
                    break;
                case "up":
                    driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                            "left", x, "top", y, "width", width, "height", height,
                            "direction", "up",
                            "speed", 500,
                            "percent", percent
                    ));
                    break;
                case "down":
                    driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                            "left", x, "top", y, "width", width, "height", height,
                            "direction", "down",
                            "speed", 500,
                            "percent", percent
                    ));
                    break;
                default:
                    break;
            }

        //IOS does not allow to swipe base on coordinator
        waitForVisibilityWithImplicitWait();
    }
    public WebElement horizontalToFindElementByName(String name, WebElement parentArea)
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform))
            return horizontalToFindElementByName(name,parentArea,".//android.widget.TextView[@text !='']");
        else
            return horizontalToFindElementByName(name,parentArea,".//XCUIElementTypeStaticText[@visible='true']");
    }
    public WebElement horizontalToFindElementByName(String name, WebElement parentArea, String criteriaToFineElement)
    {
        WebElement element = findElementByName(parentArea, name);
        System.out.println("end find group watchlist " +  utils.dateTime());

        List<WebElement> listOfElement = null;
        int left = parentArea.getLocation().x;
        int top = parentArea.getLocation().y;
        int with = parentArea.getSize().width;
        int height = parentArea.getSize().height;
        while(element == null)
        {
            listOfElement = listOfElements(parentArea, criteriaToFineElement);
            String lastName=null;
            if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
                lastName = listOfElement.get(listOfElement.size() - 1).getAttribute("text");
                swipeGestureByCoodinator(left, top, with - 50, height, "left", 1);
            }
            else
            {
                lastName = listOfElement.get(listOfElement.size()-1).getAttribute("name");
//                scrollGestureByCoodinator(left, top, with - 50, height, "left", 1);
                scrollGestureByElement(parentArea, "right", 1);
            }

            element = findElementByName(parentArea, name);
            if(element != null) break;

            listOfElement = listOfElements(parentArea, criteriaToFineElement);
            String currentlastName=null;
            if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform))
                 currentlastName = listOfElement.get(listOfElement.size()-1).getAttribute("text");
            else currentlastName = listOfElement.get(listOfElement.size()-1).getAttribute("name");
            System.out.println("lastName : " + lastName + "----" + currentlastName);
            if(lastName.equals(currentlastName)) {
                break;
            }
        }
        while((element == null))
        {
            String firstName=null;
            if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
                firstName = listOfElement.get(0).getAttribute("text");
                swipeGestureByCoodinator(left+50, top, with,height ,"right",1);
            }
            else {
                firstName = listOfElement.get(0).getAttribute("name");
                scrollGestureByElement(parentArea,"left",1);
            }

            element = findElementByName(parentArea, name);
            if(element != null) break;

            listOfElement = listOfElements(parentArea, criteriaToFineElement);
            String currentFirstName=null;
            if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform))
             currentFirstName = listOfElement.get(0).getAttribute("text");
            else currentFirstName = listOfElement.get(0).getAttribute("name");
            System.out.println("firstName : " + firstName + "----" + currentFirstName);
            if(firstName.equals(currentFirstName)) {
                break;
            }
        }
        return element;
    }
    public WebElement verticalToFindElementByName(String pathToGetRow, String pathToGetNameOfRow, String criteriaToFineElement, WebElement parentArea)
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform))
            return verticalToFindElementByName(parentArea,pathToGetRow,pathToGetNameOfRow,criteriaToFineElement);
        else
            return verticalToFindElementByName(parentArea,pathToGetRow,pathToGetNameOfRow,criteriaToFineElement);
    }
    public String getNameOfRow(WebElement row, String pathToGetNameOfRow)
    {
        try {
        if(pathToGetNameOfRow.equalsIgnoreCase("")) return row.getText();
         else return row.findElement(AppiumBy.xpath(pathToGetNameOfRow)).getText();
        }
        catch(Exception e)
        {
            System.out.println("could not get name");
        }
        return "";
    }

    /*
    parentArea: the item that we used to scroll and it contains the elements as rows
    pathToGetRow: xpath to get a specific row that we want to get
    pathToGetNameOfRow: xpath to get the name of element that considered as a name of row
    criteriaToFineListOfElements: criteria to get the list of elements that considered as rows
     */
    private WebElement verticalToFindElementByName( WebElement parentArea, String pathToGetRow, String pathToGetNameOfRow
            , String criteriaToFineListOfElements)
    {
        List<WebElement> listOfElement = null;
        WebElement row = getRow(parentArea, pathToGetRow); // get a specific row that wanted
        while((row == null))// if have no result will vertical swipe up to find
        {
            listOfElement = listOfElements(parentArea, criteriaToFineListOfElements);
            String lastName = getNameOfRow(listOfElement.get(listOfElement.size()-1), pathToGetNameOfRow);
            swipeGestureByElement(parentArea,"up",1);

            row = getRow(parentArea, pathToGetRow); //get row after swipe
            if(row != null) break; // if has result then return

            listOfElement = listOfElements(parentArea, criteriaToFineListOfElements);
            String currentlastName = getNameOfRow(listOfElement.get(listOfElement.size()-1),pathToGetNameOfRow);
            System.out.println("lastName : " + lastName + "----" + currentlastName);
            if(lastName.equals(currentlastName)) // if last row is the same after swiping, it means could not swipe, then break
            {
                break;
            }
        }
        while((row == null))// if have no result will swipe down
        {
            listOfElement = listOfElements(parentArea, criteriaToFineListOfElements);
            String firstName = getNameOfRow(listOfElement.get(0),pathToGetNameOfRow);

            swipeGestureByElement(parentArea,"down",1);

            row = getRow(parentArea, pathToGetRow);
            if(row != null) break;

            listOfElement = listOfElements(parentArea, criteriaToFineListOfElements);
            String currentFirstName = getNameOfRow(listOfElement.get(0),pathToGetNameOfRow);
            System.out.println("firstName : " + firstName + "----" + currentFirstName);
            if(firstName.equals(currentFirstName)) {
                break;
            }
        }

        return row;
    }

    public List<String> verticalToGetAllName( WebElement parentArea, String pathToGetRow, String pathToGetNameOfRow, String criteriaToFineElement)
    {
        List<WebElement> listOfElement = listOfElements(parentArea, criteriaToFineElement);
        List<String> list = new ArrayList<String>();
        int size = listOfElement.size();

        String nameOfPreviousLast = "   ";
        String nameOflast = getNameOfRow(listOfElement.get(size - 1),pathToGetNameOfRow);
        while (!nameOflast.equalsIgnoreCase(nameOfPreviousLast)) {
            String nameOfFirstOne = getNameOfRow(listOfElement.get(0),pathToGetNameOfRow);
            if(!nameOfFirstOne.equals(nameOfPreviousLast) & nameOfFirstOne != "")
            {
                list.add(nameOfFirstOne);
            }
            String pathToGetRowOfPreviousLast = pathToGetRow + ""+ nameOfPreviousLast + "']";
            HashMap<Integer, WebElement> map = getRow(listOfElement,pathToGetRowOfPreviousLast);
            if (getTheFirstWebElementOfAMap(map) == null) {
                for (int i = 1; i < size-1; i++) {
                    list.add(getNameOfRow(listOfElement.get(i),pathToGetNameOfRow));
                }
            } else {
                int indexOfLast = getKeyOfMap(map);
                for (int i = indexOfLast + 1; i < size-1; i++) {
                    list.add(getNameOfRow(listOfElement.get(i),pathToGetNameOfRow));
                }
            }
            WebElement lastRow = listOfElement.get(size - 1);
            nameOflast = getNameOfRow(lastRow,pathToGetNameOfRow);
            if(nameOflast != "")
            {
                list.add(nameOflast);
                nameOfPreviousLast = nameOflast;
            }
            else {
                nameOfPreviousLast = getNameOfRow(listOfElement.get(size-2),pathToGetNameOfRow);
            }
            scrollGestureByElement(parentArea, "down", 1);
            listOfElement = listOfElements(parentArea, criteriaToFineElement);
            size = listOfElement.size();
            nameOflast = getNameOfRow(listOfElement.get(size - 1),pathToGetNameOfRow);
        }
        return list;
    }
  public void dragByElement(WebElement element, int endX, int endY)
  {
      if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform))
      driver.executeScript("mobile: dragGesture", ImmutableMap.of(
              "elementId", ((RemoteWebElement) element).getId(),
              "endX", endX,
              "endY", endY,
              "speed", 500
      ));
      else {
          Map<String, Object> params = new HashMap<>();
          params.put("fromX", element.getLocation().x);
          params.put("fromY", element.getLocation().y);
          params.put("toX", endX);
          params.put("toY", endY);
          params.put("duration", 1);
          driver.executeScript("mobile: dragFromToForDuration", params);
      }
      waitForVisibilityWithImplicitWait();
  }
  public WebElement findElementByXpath(WebElement parent, String xpath)
  {
      try
      {
          return parent.findElement(AppiumBy.xpath("."+xpath));
      }
      catch (Exception e){return null;}
  }

    public  WebElement findElementByName(WebElement parent, String name)
    {
        try
        {
            if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
                System.out.println("start find group watchlist " +  utils.dateTime());
//                return parent.findElements
//                        (AppiumBy.androidUIAutomator("new UiSelector().text(\"" + name + "\")")).get(0);
                return findElementByXpath(parent, "//*[@text='"+name+"']");
            }
            else
                return parent.findElements
                        (AppiumBy.xpath("//XCUIElementTypeStaticText[@name='"+name+"' and @visible='true']")).get(0);
//                        (AppiumBy.iOSNsPredicateString("name =='"+name+"'"));
        }
        catch(Exception ex)
        {
            return  null;
        }
    }
    public WebElement getRow(WebElement parent, String pathToGetRow)
    {
        try
        {
            if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform))
                return parent.findElement(AppiumBy.xpath(pathToGetRow));
            else return driver.findElements(AppiumBy.xpath("//XCUIElementTypeTable")).
                    get(1).findElement(AppiumBy.xpath(pathToGetRow));
        }
        catch (Exception ignored)
        {}
        return null;
    }
    public HashMap<Integer, WebElement> getRow(List<WebElement> listOfRow, String xpath) {
        WebElement e1 = null;
        HashMap<Integer, WebElement> values = new HashMap<Integer, WebElement>();
        int size = listOfRow.size();
        for(int i= 0; i< size; i++)
        {
            try {
                e1 = listOfRow.get(i).findElement(AppiumBy.xpath(xpath));

            } catch (Exception ex) {
                e1 = null;
            }
            if(e1 != null) {
                values.put(i, e1);
                return values;
            }
        }
        return null;
    }
    public List<WebElement> listOfElements(WebElement parent, String xpath)
    {
//        return parent.findElements(AppiumBy.id(id));
        return parent.findElements(AppiumBy.xpath(xpath));
    }
    public String getNameOfElement(WebElement parent, String id)
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform))
            return parent.findElement(AppiumBy.id(id)).getText();
        else return parent.findElement(AppiumBy.id("dev can phai lam lai")).getText();
    }

  public WebElement getTheFirstWebElementOfAMap(HashMap<Integer, WebElement> map)
  {
      try {
          return (WebElement) map.values().toArray()[0];
      }
      catch ( Exception e)
      {return null;}
  }

    public int getKeyOfMap(HashMap<Integer, WebElement> map)
    {
        try {
            int index = -1;
            for (Map.Entry m : map.entrySet()) {
                index = (int) m.getKey();
            }
            return index;
        }
        catch (Exception e)
        {return -1;}
    }


    public WebElement andScrollToElementUsingUiScrollable(String childLocAttr, String childLocValue) {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
                        + "new UiSelector()."+ childLocAttr +"(\"" + childLocValue + "\"));"));
    }



    public JSONObject getDataByKey(String dataFileName) throws IOException {
        JSONObject loginUsers;
        InputStream datais = null;
        try {
            dataFileName = "data/loginUsers.json";
            datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener tokener = new JSONTokener(datais);
            loginUsers = new JSONObject(tokener);
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(datais != null) {
                datais.close();
            }
        }
        return loginUsers;
    }
    public HashMap<String, String> getDataFromXMLFile(String xmlFile){
        InputStream stringsis = null;
        stringsis = getClass().getClassLoader().getResourceAsStream(xmlFile);
        strings = utils.parseStringXML(stringsis);
        return strings;
    }

    public void verifyText(String expected, String actual)
    {
        if(actual != null) {
            Assert.assertTrue(expected.equalsIgnoreCase(actual), "expected text: " + expected
                    + "--- but actual: " + actual);
        }
        else
            Assert.fail("expected text: " + expected + "--- but actual is null");
    }
    public void verifyText(String pathOfXMLfile, String key, String actual) throws Exception {
        String expected = getDataFromXMLFile(pathOfXMLfile).get(key);
        verifyText(expected, actual);
    }
    public void verifyTextWithDataInRoboXML(String key, String actual) throws Exception {
        verifyText("data/robo.xml", key, actual);
    }
    public void verifyNumber(int expected,  int actual)
    {
        Assert.assertTrue(expected == actual, "expected number: " + expected
                + "--- but actual: "+ actual);
    }

    public void verifyAttributeOfAnElement(WebElement element, String attribute, String expected)
    {
        String actual = element.getAttribute(attribute);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(expected.equalsIgnoreCase(actual), "expected messsage: " + expected
                + "--- but actual: "+ actual);
//        Assert.assertTrue(expected.equalsIgnoreCase(actual), "expected messsage: " + expected
//                + "--- but actual: "+ actual);
    }

    public void verifyIsEditableOfAnElement(WebElement element, String expected)
    {
        sendKeys(element, expected);
        String actual = getText(element);
        verifyText(expected, actual);
    }

    public void verifyJustOnlyInputText(WebElement element)
    {
        String expect = "a";
        sendKeys(element, expect);
        verifyText(expect,getText(element));

        expect = " !@#$%^&&*()_+";
        sendKeys(element, expect);
        verifyText("",getText(element));

        expect = "01233";
        sendKeys(element, expect);
        verifyText("",getText(element));
    }

    public void verifyJustOnlyInputNumberic(WebElement element)
    {
        String expect = "9";
        sendKeys(element, expect);
        Assert.assertTrue(getText(element).equalsIgnoreCase(expect));

        expect = " !@#$%^&&*()_+";
        sendKeys(element, expect);
        verifyText("",getText(element));

        expect = "a";
        sendKeys(element, expect);
        verifyText("",getText(element));
    }

    public void verifyNumberOfDecimal(WebElement element, int expectedNoOfDigital)
    {
        String value  = getText(element);
        int actualNoOfDigital = value.length() - value.indexOf(".") + 1;
        verifyNumber(expectedNoOfDigital, actualNoOfDigital);
    }

    public void verifySeparatorInNumber(String value, char separator)
    {
        int indexOfDot = value.indexOf(".");
        boolean rightSeparator = false;
        if(indexOfDot > -1) value = value.substring(0, indexOfDot);
        for(int i = value.length(); i< 2; i=i-3)
        {
            if(value.charAt(i) != separator) break;
        }
        rightSeparator = true;
        Assert.assertTrue(rightSeparator, "Using separator wrongly!");
    }

    public void verifyFormatOfDate(String strDate, String expectedFormat)
    {
        boolean isCorrectFormat;
        /*
         * expectedFormat,
         * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
        SimpleDateFormat sdfrmt = new SimpleDateFormat(expectedFormat);
        sdfrmt.setLenient(false);
        try
        {
            Date javaDate = sdfrmt.parse(strDate);
            isCorrectFormat = true;
        }
        /* Date format is invalid */
        catch (ParseException e)
        {
            isCorrectFormat =false;
        }

        Assert.assertTrue(isCorrectFormat, "The format of data is not " + expectedFormat);
    }
    public String getAccountType(String account) throws IOException {
        JSONObject loginUsers = getDataByKey("data/loginUsers.json");
        return loginUsers.getJSONObject(account).getString("type");

    }

    private void openAnApp(String app)
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.IosPlatform)) {
            HashMap<String, Object> value = new HashMap<>();
            value.put("bundleId", app);
            driver.executeScript("mobile: launchApp", value);
            driver.executeScript("mobile: activateApp", value);
        }
        else
        {
            driver.executeScript("mobile: startActivity", ImmutableMap.of("intent", app));
        }
    }
    public void openSettingOfDevice()
    {
        String app = null;
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.IosPlatform)) app = "com.apple.Preferences";
        else app = "com.android.settings/com.android.settings.Settings";
        openAnApp(app);
    }
    public void backToApp() throws IOException {
        String app = null;
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.IosPlatform)) app =
                new PropertyManager().getProps().getProperty("iOSBundleId");
        else app = appPackage+"/com.tdt.pmobile3.app.SplashActivity";
        openAnApp(app);
    }


    public void activeApp(){
//        driver.quit(); // kill session ID >>> stop running >>> could not use
        String appID = null;
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform))
        {
            appID = (String) driver.getCapabilities().getCapability(AndroidMobileCapabilityType.APP_PACKAGE);
        }
        else
            appID = String.valueOf(driver.getCapabilities().getCapability(IOSMobileCapabilityType.BUNDLE_ID));

        ((InteractsWithApps) driver).activateApp(appID); //cung khong thay dong han app
//        ((InteractsWithApps) driver).removeApp(appID); //tuyeetj nhiene ko dung vi laf uninstall app

    }

    public void clickOutsideOfApp()
    {
        WebElement element = driver.findElements(AppiumBy.xpath("//android.view.View[contains(@resource-id, 'snapshot')]")).get(0);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),
                element.getLocation().x - 5
                , element.getLocation().y + element.getSize().getHeight()/2));
        tap.addAction(finger.createPointerDown(0));
        tap.addAction(finger.createPointerUp(0));
        driver.perform(Collections.singletonList(tap));

    }
    public void touchToAppearAppAgain()
    {
        swipeToSeeAppAsSnapShort();
        clickWithExplicitWait(driver.findElements(AppiumBy.xpath("//android.view.View[contains(@resource-id, 'snapshot')]")).get(0));
    }
    public void backgroundApp()
    {
        swipeToSeeAppAsSnapShort();
        clickOutsideOfApp();
    }
    public void swipeToSeeAppAsSnapShort()
    {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),
                driver.manage().window().getSize().getWidth() / 2, driver.manage().window().getSize().getHeight() + 70));
        tap.addAction(finger.createPointerDown(0));
        tap.addAction(finger.createPointerMove(Duration.ofSeconds(5),PointerInput.Origin.viewport(),
                driver.manage().window().getSize().getWidth() / 2,driver.manage().window().getSize().getHeight()));
        tap.addAction(finger.createPointerUp(0));
        driver.perform(Collections.singletonList(tap));
    }
    public void swipeToPullDownPage(WebElement element)
    {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),
                element.getLocation().x + element.getSize().getWidth()/2, element.getLocation().y));
        tap.addAction(finger.createPointerDown(0));
        tap.addAction(finger.createPointerMove(Duration.ofSeconds(2),PointerInput.Origin.viewport(),
                element.getSize().getWidth() / 2,500));
        tap.addAction(finger.createPointerUp(0));
        driver.perform(Collections.singletonList(tap));

        System.out.println("");
    }
    public void swipeToPullDownPage()
    {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),
                driver.manage().window().getSize().getWidth() / 2, 0));
        tap.addAction(finger.createPointerDown(0));
        tap.addAction(finger.createPointerMove(Duration.ofSeconds(5),PointerInput.Origin.viewport(),
                driver.manage().window().getSize().getWidth() / 2,driver.manage().window().getSize().getHeight()));
        tap.addAction(finger.createPointerUp(0));
        driver.perform(Collections.singletonList(tap));

    }
    public void closeScreen()
    {
        swipeToSeeAppAsSnapShort();
        WebElement element = driver.findElements(AppiumBy.xpath("//android.view.View[contains(@resource-id, 'snapshot')]")).get(0);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),
                element.getLocation().x - 5
                , element.getLocation().y + element.getSize().getHeight()/2));
        tap.addAction(finger.createPointerDown(0));
        tap.addAction(finger.createPointerUp(0));
        tap.addAction(finger.createPointerDown(0));
        tap.addAction(finger.createPointerUp(0));
        tap.addAction(finger.createPointerDown(0));
        tap.addAction(finger.createPointerUp(0));
        driver.perform(Collections.singletonList(tap));


    }

    public void terminateApp(){
//        driver.quit(); // kill session ID >>> stop running >>> could not use
        String appID = null;
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform))
        {
            appID = (String) driver.getCapabilities().getCapability(AndroidMobileCapabilityType.APP_PACKAGE);
        }
        else
            appID = String.valueOf(driver.getCapabilities().getCapability(IOSMobileCapabilityType.BUNDLE_ID));

        ((InteractsWithApps) driver).terminateApp(appID); //cung khong thay dong han app
//        ((InteractsWithApps) driver).removeApp(appID); //tuyeetj nhiene ko dung vi laf uninstall app

    }

    public void runAppInBackground(){
//        driver.quit(); // kill session ID >>> stop running >>> could not use
        String appID = null;
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform))
        {
            appID = (String) driver.getCapabilities().getCapability(AndroidMobileCapabilityType.APP_PACKAGE);
        }
        else
            appID = String.valueOf(driver.getCapabilities().getCapability(IOSMobileCapabilityType.BUNDLE_ID));

        ((InteractsWithApps) driver).runAppInBackground(Duration.ofSeconds(10)); //cung khong thay dong han app
//        ((InteractsWithApps) driver).removeApp(appID); //tuyeetj nhiene ko dung vi laf uninstall app

    }
    public void openURL(String url)
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            ((InteractsWithApps) driver).activateApp("com.android.chrome");
            waitForClickableWithExplicitWait(driver.findElement(AppiumBy.id("com.android.chrome:id/url_bar")));
            sendKeys(driver.findElement(AppiumBy.id("com.android.chrome:id/url_bar")),url);

//        click( new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.ENTER));
            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        }
        else
        {
            ((InteractsWithApps) driver).activateApp("com.apple.mobilesafari");
            waitForClickableWithExplicitWait(driver.findElement(AppiumBy.xpath("//XCUIElementTypeTextField")));
            WebElement e = driver.findElement(AppiumBy.xpath("//XCUIElementTypeTextField"));
            sendKeys(e,url);
            e.sendKeys(Keys.ENTER);
        }

    }
    public String isTurnOnWifi()
    {
        openSettingOfDevice();
        waitForVisibilityWithExplicitWait(wifi);
        wifi.click();
        waitForVisibilityWithExplicitWait(wifiToggle);

        String actualWifiStatus = null;
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform))
            actualWifiStatus = wifiToggle.getAttribute("checked");
        else
        {
            actualWifiStatus = wifiToggle.getAttribute("value").equalsIgnoreCase("1") ?
                    "true":"false";
        }
        return actualWifiStatus;
    }
    public void configureWifiModeByConfigThroughSettingOfDevice(String expectedStatus)
    {
            String actualWifiStatus = isTurnOnWifi();

            if (!actualWifiStatus.equalsIgnoreCase(expectedStatus)) {
                    wifiToggle.click();
                    System.out.println("Wifi mode is : " + expectedStatus);
            }
    }
    public void configureWifiMode(String expectedStatus)
    {
        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
            if (expectedStatus.equalsIgnoreCase("false")) {
                ((AndroidDriver) driver).toggleWifi();
                ((AndroidDriver) driver).setConnection(new ConnectionState(ConnectionState.DATA_MASK));
                ((AndroidDriver) driver).setConnection(new ConnectionStateBuilder().withWiFiDisabled().withDataDisabled().build());

            }
            if (expectedStatus.equalsIgnoreCase("true")) {
                ((AndroidDriver) driver).toggleWifi();
                ((AndroidDriver) driver).setConnection(new ConnectionState(ConnectionState.DATA_MASK));
                ((AndroidDriver) driver).setConnection(new ConnectionStateBuilder().withWiFiEnabled().withWiFiEnabled().build());
            }
        }
        else
        {
            configureWifiModeByConfigThroughSettingOfDevice(expectedStatus);
        }
        waitForVisibilityWithImplicitWait();
    }

    public void turnOnAirPlaneMode(String expectedStatus) throws Exception {
        openSettingOfDevice();

        String actualAirplaneStatus = airplaneBtn.getAttribute("checked");
        if (!actualAirplaneStatus.equalsIgnoreCase(expectedStatus)) {
                airplaneBtn.click();
                System.out.println("Airplane mode is: " + expectedStatus);
                new CommonContentPage().iCloseNotification();
        }
    }

    public WebElement getElementBaseOnAnElement(WebElement element, String criteria)
    {
        try
        {
             return element.findElement(AppiumBy.xpath(criteria));
        }
        catch(Exception e)
        {
            return null;
        }
    }
}
