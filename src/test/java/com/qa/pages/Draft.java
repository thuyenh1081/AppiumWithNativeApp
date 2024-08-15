package com.qa.pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import io.appium.java_client.touch.ActionOptions;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.appium.java_client.touch.ActionOptions;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class Draft {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

//        ////////////////////////////////////------CreateDriverSession
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("platformName", "iOS");
//        caps.setCapability("deviceName", "iPhone7cuaHuyen");
//        caps.setCapability("automationName", "XCUITest");
//        caps.setCapability("udid", "01c312e1dfc2ab0d92bb0669d444244239a7a551");
//        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
//                + File.separator + "resources" + File.separator + "iOSPoemsP2v33808U02012024_105040.ipa";
//        caps.setCapability("xcodeOrgId","HF66MZL8V9");
//        caps.setCapability("xcodeSigningId","iPhone Developer");
//        caps.setCapability("app", appUrl);
////        caps.setCapability("bundleId","com.example.apple-samplecode.UICatalog");
////        caps.setCapability("bundleId",appPackage+"");
//        URL url = new URL("http://0.0.0.0:4723/");
//        AppiumDriver driver = new IOSDriver(url, caps);

       DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
//        caps.setCapability("deviceName", "Pixel_4");
        caps.setCapability("automationName", "UiAutomator2");
//        caps.setCapability("appPackage", "io.appium.android.apis");
//        caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
        caps.setCapability("udid", "R58M87W2G6T");
//        caps.setCapability("appPackage", "com.swaglabsmobileapp");
//        caps.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
//        caps.setCapability("udid", "emulator-5554");
        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                + File.separator + "resources" + File.separator + "app" + File.separator
                + "AndroidPoemsP2v33815U05042024_150537.apk";
//        + "Android.SauceLabs.Mobile.Sample.app.2.2.1.apk";
//                + "ApiDemos-debug.apk";
//        caps.setCapability("app", appUrl);

        URL url = new URL("http://0.0.0.0:4723");

        AppiumDriver driver = new AndroidDriver(url, caps);


        ////////////////////////////////////-------CreateDriverSessionUsingOptions

//        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
//                + File.separator + "resources" + File.separator + "UIKitCatalog-iphonesimulator.app";
//        XCUITestOptions options = new XCUITestOptions().
//                setDeviceName("iPhone 13 Pro Max").
//                setAutomationName("XCUITest").
//                setUdid("FDDAF4BC-2C59-4E30-BC16-B05C16E3D29D").
//                setApp(appUrl);
//
//        URL url = new URL("http://0.0.0.0:4723");
//
//        AppiumDriver driver = new IOSDriver(url, options);
///*        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
//                + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
//        UiAutomator2Options options = new UiAutomator2Options().
//                setDeviceName("Pixel_5").
//                setAutomationName("UiAutomator2").
//                setApp(appUrl);
//
//        URL url = new URL("http://0.0.0.0:4723");
//
//        AppiumDriver driver = new AndroidDriver(url, options);*/

//        scrollGestureByBoundery(driver, 100, 100, 600, 600, "down", 0.75);
//        swipeGesture(driver);

//            scrollGestureByElement(driver, "down", 1);
//            swipeGesture(driver);
//        swipeIOS(driver);
//        scrollIos(driver);

    }
    public static void swipeIOS(AppiumDriver driver)
    {
//        Map<String, Object> params = new HashMap<>();
//        params.put("direction", "up");
//        driver.executeScript("mobile: swipe", params);

        WebElement element = driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeTable'"));
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "up");
        params.put("element",((RemoteWebElement)element).getId());
        driver.executeScript("mobile: swipe", params);

    }
    public static void scrollIos(AppiumDriver driver) {

//        Map<String, Object> params = new HashMap<>();
//        params.put("direction", "down");
//        driver.executeScript("mobile: scroll", params);

//        WebElement element = driver.findElement(AppiumBy.
//                iOSNsPredicateString("type == 'XCUIElementTypeTable'"));
//        Map<String, Object> params = new HashMap<>();
//        params.put("direction", "down");
//        params.put("element",((RemoteWebElement)element).getId());
//        driver.executeScript("mobile: scroll", params);

//        WebElement parentElement = driver.findElement(AppiumBy.
//                iOSNsPredicateString("type == 'XCUIElementTypeTable'"));
//        Map<String, Object> params = new HashMap<>();
//        params.put("elementId", ((RemoteWebElement) parentElement).getId());
//        params.put("name", "Web View");
//        driver.executeScript("mobile: scroll", params);

//        WebElement parentElement = driver.findElement(AppiumBy.
//                iOSNsPredicateString("type == 'XCUIElementTypeTable'"));
//        Map<String, Object> params = new HashMap<>();
//        params.put("elementId", ((RemoteWebElement) parentElement).getId());
//        params.put("predicateString", "label == 'Web View'");
//        driver.executeScript("mobile: scroll", params);

//        WebElement childElement = driver.findElement(AppiumBy.
//                accessibilityId("Web View"));
//        Map<String, Object> params = new HashMap<>();
//        params.put("elementId", ((RemoteWebElement) childElement).getId());
//        params.put("toVisible", true);
//        driver.executeScript("mobile: scroll", params);


        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        driver.executeScript("mobile: scroll", params);

        WebElement childElement = driver.findElement(AppiumBy.
                accessibilityId("Activity Indicators"));
        params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) childElement).getId());
        params.put("toVisible", true);
        driver.executeScript("mobile: scroll", params);
    }
    public static void scrollGestureByElement(AppiumDriver driver, String direction, double percent) throws InterruptedException {

//        driver.findElement(AppiumBy.accessibilityId("Views")).click();
//               WebElement elementParent = driver.findElement(AppiumBy.id("android:id/list"));
//
//
//        boolean canScrollMore = false;
//        int count = 0;
//        while (count < 4) {
//            List<WebElement> elements = driver.findElement(AppiumBy.id("android:id/list"))
//                    .findElements(AppiumBy.className("android.widget.TextView"));
//
//            WebElement element = elements.get(0);
//            WebElement last = elements.get(elements.size()-2);
//            System.out.println(element.getLocation().x);
//            System.out.println(element.getLocation().y);
//            System.out.println(element.getSize().getWidth());
//            System.out.println(element.getSize().getHeight());
//            System.out.println(last.getLocation().x);
//            System.out.println(last.getLocation().y);
//            System.out.println(last.getLocation().y- element.getLocation().y);
//            canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
//                    "left", element.getLocation().x, "top", element.getLocation().y,
//                    "width", last.getLocation().x - element.getLocation().x,
//                    "height", last.getLocation().y - element.getLocation().y, "speed", 1000,
////                    "elementId", ((RemoteWebElement) elementParent).getId(),
//                    "direction", direction,
//                    "percent", percent
//            ));
//            System.out.println("can scroll down more: " + canScrollMore);
//            count = count + 1;
//        }
//            return canScrollMore;

        // nếu muốn 1 phát scroll tận cuối con nào thì cứ cho element to và srcoll bằng chính nó

//        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
//                "left", next.getLocation().x, "top", next.getLocation().y,
//                "width" , next.getSize().getWidth(),
//                "height", next.getSize().getHeight(),
//                "direction", direction,
//                "percent", 1
//        ));
//        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) elementParent).getId(),
//                    "direction", direction,
//                    "percent", 1
//            ));
//        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
//                "left", element.getLocation().x, "top", element.getLocation().y,
//                "width" , element.getSize().getWidth(),
//                "height", element.getSize().getHeight(),
//                "direction", direction,
//                "percent", 1
//        ));
//        System.out.println(canScrollMore);
//        while (canScrollMore) {
//            WebElement element = driver.findElement(AppiumBy.id("android:id/list"))
//                    .findElements(AppiumBy.className("android.widget.TextView")).get(0);
//            driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
//                    "left", element.getLocation().x, "top", element.getLocation().y, "width"
//                    , element.getSize().getWidth(), "height", element.getSize().getHeight(),
//                    "direction", direction,
//                    "percent", 1
//            ));
//            canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
//                    "left", 0, "top", 0, "width"
//                    , elementParent.getSize().getWidth(), "height", elementParent.getSize().getHeight(),
//                    "elementId", ((RemoteWebElement) elementParent).getId(),
//                    "direction", direction,
//                    "percent", 0
//            ));
//            System.out.println(canScrollMore);
//        }

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        Thread.sleep(5000);
        List<WebElement> elements = driver.findElement(AppiumBy.id("android:id/list"))
                .findElements(AppiumBy.className("android.widget.TextView"));
        WebElement element = elements.get(0);
        WebElement last = elements.get(elements.size()-1);
        System.out.println(element.getLocation().x);
        System.out.println(element.getLocation().y);
        System.out.println(element.getSize().width);
        System.out.println(last.getLocation().y- element.getLocation().y);
        System.out.println(elements.get(elements.size()-2).getLocation().y);
        System.out.println(element.getAttribute("text"));
        System.out.println(last.getAttribute("text"));
        int left = element.getLocation().x+50;
        int top = element.getLocation().y;
        int width = element.getSize().width;
        int height = last.getLocation().y- element.getLocation().y;

        boolean canScrollMore = true;
        while (canScrollMore) {

            canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", left, "top", top,
                    "width", width,
                    "height", height,
                    "direction", direction,
                    "speed", 1000,
                    "percent", percent
            ));

            System.out.println(canScrollMore);
        }


//        driver.findElement(AppiumBy.accessibilityId("Views")).click();
////               WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
//        WebElement element = driver.findElement(AppiumBy.id("android:id/list"))
//                .findElements(AppiumBy.className("android.widget.TextView")).get(0);
//        boolean canScrollMore = true;
//        while (canScrollMore) {
//            canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
//                    "elementId", ((RemoteWebElement) element).getId(),
//                    "direction", direction,
//                    "percent", percent
//            ));
//            System.out.println(canScrollMore);
//        }
    }
    public static void scrollGestureByBoundery(AppiumDriver driver,
    int left, int top, int with, int height, String direction, double percent){

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        //       WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Animation"));

        boolean canScrollMore = true;
        while(canScrollMore){
            canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", left, "top", top, "width", with, "height", height,
//                "elementId", ((RemoteWebElement) element).getId(),
                    "direction", direction,
                    "percent", percent
            ));
            System.out.println(canScrollMore);
        }

//        driver.findElement(AppiumBy.accessibilityId("Views")).click();
//        //       WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
//        WebElement element = driver.findElement(AppiumBy.accessibilityId("Animation"));
//        Boolean   canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
////                "left", 100, "top", 100, "width", 200, "height", 200,
//                "elementId", ((RemoteWebElement) element).getId(),
//                "direction", "down",
//                "percent", 1
//        ));
    }

    public static void swipeGesture(AppiumDriver driver) throws InterruptedException {

//        driver.findElement(AppiumBy.accessibilityId("Views")).click();
//        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
//        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
//        WebElement element = driver.findElement(AppiumBy.
//                xpath("//*[@resource-id='io.appium.android.apis:id/gallery']/android.widget.ImageView[1]"));
////                "left", 100, "top", 100, "width", 600, "height", 600,
//        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
////                "left", 100, "top", 100, "width", 600, "height", 600,
//                "elementId", ((RemoteWebElement) element).getId(),
//                "direction", "left",
//                "percent", 0.75
//        ));

//

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        Thread.sleep(5000);
        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 600, "height", 600,
//                            "elementId", ((RemoteWebElement) element).getId(),
                            "direction", "up",
                            "speed", 1000,
                            "percent", 0.50
                    ));

//        driver.findElement(AppiumBy.accessibilityId("Views")).click();
//        List<WebElement> elements = driver.findElement(AppiumBy.id("android:id/list"))
//                .findElements(AppiumBy.className("android.widget.TextView"));
//        WebElement first = elements.get(0);
//        WebElement last = elements.get(elements.size()-1);
//        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
//                "left", first.getLocation().x +10, "top", first.getLocation().y +10,
//                "width", first.getLocation().x + first.getSize().getWidth(),
//                "height", first.getLocation().y +first.getSize().getHeight(),
////                "elementId", ((RemoteWebElement) first).getId(),
//                "direction", "up",
//                "percent", 1
//        ));
//
//        int edgeBorder = 10; // better avoid edges
//        PointOption pointOptionStart, pointOptionEnd;
//
//        // init screen variables
//        Dimension dims = first.getSize();
//
//        // init start point = center of screen
//        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
//
//        String dir = "UP";
//        switch (dir) {
//            case "DOWN": // center of footer
//                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
//                break;
//            case "UP": // center of header
//                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
//                break;
//            case "LEFT": // center of left side
//                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
//                break;
//            case "RIGHT": // center of right side
//                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
//                break;
//            default:
//                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
//        }
//        // execute swipe using TouchAction
//        try {
////            AppiumDriver driver = (AppiumDriver) new WebDriverTestBase().getDriver().getUnderLayingDriver();
//            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//            Sequence swipeDown = new Sequence(finger, 1);
//            swipeDown
//                    .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.fromElement(last), first.getSize().getWidth()/2,first.getSize().getHeight()/2));
////                    .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
////                    .addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), deviceWidth/2,deviceHeight/2+deviceHeight/3))
////                    .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//            driver.perform(List.of(swipeDown));

//            TouchAction t = new TouchAction((PerformsTouchActions) driver);
//                    t.press(pointOptionStart)
//                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//                    .moveTo(pointOptionEnd)
//                    .release().perform();

//            PlatformTouchAction(driver)
//                    .press(pointOptionStart)
//                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//                    .moveTo(pointOptionEnd)
//                    .release().perform();
//        } catch (Exception e) {
//            System.err.println("swipeScreen(): TouchAction FAILED" + e.getMessage());
//            return;
//        }
    }

    public static void pinchOpenGesture(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='SKIP']")).click();
        Thread.sleep(5000);

// Java
        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left", 200,
                "top", 470,
                "width", 600,
                "height", 600,
                "percent", 0.75
        ));
    }

    public static void dragGesture(AppiumDriver driver){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 649,
                "endY", 662
        ));

    }
    public static void dragAndDropIOS(AppiumDriver driver){
        Map<String, Object> params = new HashMap<>();
        params.put("fromX", 60);
        params.put("fromY", 300);
        params.put("toX", 60);
        params.put("toY", 0);
        params.put("duration", 1);
        driver.executeScript("mobile: dragFromToForDuration", params);
    }
    public static void clickGesture(AppiumDriver driver){
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Views"));

        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }

    public static void longClickGesture(AppiumDriver driver){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) element).getId(),
                "x", 217 ,
                "y", 659,
                "duration", 1000
        ));

    }
}