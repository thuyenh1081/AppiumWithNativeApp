package com.qa.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class CapabilitiesManager {
    TestUtils utils = new TestUtils();

    public DesiredCapabilities getCaps() throws IOException {
        GlobalParams params = new GlobalParams();
        Properties props = new PropertyManager().getProps();

        if(!params.getPcloudy().toString().equalsIgnoreCase("true"))
        {
            try {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, params.getPlatformName());
                caps.setCapability("newCommandTimeout", 3000);
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, params.getDeviceName());
                URL url;
                url = new URL(props.getProperty("appiumURL") + "4723"); // dung neu muon parralel treen 1 server instance

                switch (params.getPlatformName()) {
                    case "Android": {
                        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));
                        String AroidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                                + File.separator + "resources" + File.separator + "app" + File.separator + props.getProperty("androidAppLocation");
//                  nếu không cần cài thì bỏ giá trị setting cho app và setting cho appPackage và appActivity
                        caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
                        caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
//				đoạn dứoi là để nếu là emulator thì mình emulatỏ sẽ được bật tự đông, ko cần manually
                        if (params.getEmulator().toString().equalsIgnoreCase("true")) {
                            //cung co the set plaform version cho android
                            caps.setCapability("avd", params.getDeviceName());
                        } else {
                            //dung cho real device
                            caps.setCapability("udid", params.getUDID());
                        }
                        caps.setCapability("systemPort", params.getSystemPort());
                        caps.setCapability("appium:chromeDriverPort", params.getChromeDriverPort());
                        caps.setCapability("avdLaunchTimeout", 120000);
//                    caps.setCapability(MobileCapabilityType.APP, AroidAppUrl);
                        break;
                    }
                    case "iOS": {
                        caps.setCapability("udid", params.getUDID());//dung cho real devide
                        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("iOSAutomationName"));
                        caps.setCapability("wdaLocalPort", params.getWdaLocalPort());
                        caps.setCapability("appium:webkitDebugProxyPort", params.getWebkitDebugProxyPort());
                        caps.setCapability("bundleId", props.getProperty("iOSBundleId"));
                        caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
                        caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
                        break;
                    }
                }
                return caps;
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        }
        else {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("pCloudy_Username", "hoangthuhuyen@phillip.com.sg");
            capabilities.setCapability("pCloudy_ApiKey", "fp3428w96x49rqrf93d5hm3w");
            switch (params.getPlatformName()) {
                case "Android": {
                    // capabilities.setCapability("pCloudy_ApiKey", "y8pghp3vpgcs5ssv3p2mcsjz");
                    capabilities.setCapability("pCloudy_DurationInMinutes", 15);
                    capabilities.setCapability("newCommandTimeout", 100000);
                    capabilities.setCapability("launchTimeout", 90000);
                    // capabilities.setCapability("pCloudy_DeviceManafacturer", deviceName);
//                     capabilities.setCapability("pCloudy_DeviceFullName",
//                     "HUAWEI_P30Pro_android_10.0.0_7b5d9");
                    // capabilities.setCapability("pCloudy_DeviceFullName",
                    // "SAMSUNG_GalaxyS21Plus_android_13.0.0_8e690");
                    // capabilities.setCapability("pCloudy_DeviceFullName",
                    // "SAMSUNG_GalaxyS23Ultra_android_13.0.0_0067b");
//                    capabilities.setCapability("pCloudy_DeviceFullName", "SAMSUNG_GalaxyNote20Ultra_android_13.0.0_c39fa");
//                     capabilities.setCapability("pCloudy_DeviceFullName",
//                     "SAMSUNG_GalaxyNote10Plus_android_11.0.0_0101c");
                    // capabilities.setCapability("pCloudy_DeviceFullName",
                    // "SAMSUNG_GalaxyTabS8_android_13.0.0_8f103");
                    // capabilities.setCapability("pCloudy_DeviceFullName",
                    // "SAMSUNG_GalaxyS23Ultra_android_13.0.0_0067b");
                    // capabilities.setCapability("pCloudy_DeviceFullName",
                    // "SAMSUNG_GalaxyNote10Plus_android_12.0.0_38a8a");
                    // capabilities.setCapability("pCloudy_DeviceFullName",
                    // "GOOGLE_Pixel6a_android_13.0.0_b38b6");
                    // capabilities.setCapability("pCloudy_DeviceFullName",
                    // "SAMSUNG_GalaxyS8_android_9.0.0_af614");
                    // capabilities.setCapability("pCloudy_DeviceFullName",
                    // "SAMSUNG_GalaxyS22_android_12.0.0_b98b4");
//                     capabilities.setCapability("pCloudy_DeviceFullName",
//                     "HUAWEI_P50Pro_android_11.0.0_b12ed");
                    capabilities.setCapability("pCloudy_DeviceFullName",
                            "SAMSUNG_GalaxyZFlip5_Android_14.0.0_33372");
                    capabilities.setCapability("platformName", "Android");
                    capabilities.setCapability("automationName", "uiautomator2");
                    capabilities.setCapability("pCloudy_ApplicationName", "AndroidPoemsP2v33814U21032024_174540.apk");
                    capabilities.setCapability("appPackage", "com.tdt.pmobile3.p2");
                    capabilities.setCapability("appActivity", "com.tdt.pmobile3.app.SplashActivity");
                    capabilities.setCapability("pCloudy_WildNet", "false");
                    capabilities.setCapability("pCloudy_EnableVideo", "true");
                    capabilities.setCapability("pCloudy_EnablePerformanceData", "true");
                    capabilities.setCapability("pCloudy_EnableDeviceLogs", "true");
                    capabilities.setCapability("appiumVersion", "1.20.2");
                    capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);

                    break;
                }
                case "iOS": {
                    // capabilities.setCapability("pCloudy_ApiKey", "y8pghp3vpgcs5ssv3p2mcsjz");
                    capabilities.setCapability("pCloudy_DurationInMinutes", 15);
                    capabilities.setCapability("newCommandTimeout", 600);
                    capabilities.setCapability("launchTimeout", 90000);
                    // capabilities.setCapability("pCloudy_DeviceFullName",
                    // "APPLE_iPhone11ProMax_ios_15.1.0_e0c45");
                    // capabilities.setCapability("pCloudy_DeviceFullName",
                    // "APPLE_iPhone12ProMax_ios_15.2.0_e580a");
                    capabilities.setCapability("pCloudy_DeviceFullName", "APPLE_iPhone11_ios_15.1.0_a3b26");
                    // capabilities.setCapability("pCloudy_DeviceFullName",
                    // "APPLE_iPhone12_ios_14.4.1_56280");
                    // capabilities.setCapability("pCloudy_DeviceFullName",
                    // "APPLE_iPhone13_ios_15.2.1_05ead");
                    // SG
                    // capabilities.setCapability("pCloudy_DeviceFullName",
                    // "APPLE_iPhone11ProMax_ios_15.3.1_46a1a");
                    // capabilities.setCapability("pCloudy_DeviceFullName",
                    // "APPLE_iPhone12ProMax_ios_14.4.2_8273e");
                    // capabilities.setCapability("pCloudy_DeviceFullName",
                    // "APPLE_iPhone14ProMax_ios_16.0.0_3f3fb");
                    // capabilities.setCapability("pCloudy_DeviceFullName",
                    // "APPLE_iPhone14_ios_16.0.0_e78f3");l
                    // capabilities.setCapability("pCloudy_DeviceFullName",
                    // "APPLE_iPhoneSE2022_ios_15.4.0_ecd57");
                    // capabilities.setCapability("pCloudy_DeviceFullName",
                    // "APPLE_iPhoneXSMax_ios_16.1.0_ac2d8");
                    capabilities.setCapability("platformVersion", "15.2.1");
                    capabilities.setCapability("platformName", "ios");
                    capabilities.setCapability("automationName", "XCUITest");
                    capabilities.setCapability("pCloudy_ApplicationName", "Pmobile3.ipa");
                    capabilities.setCapability("bundleId", "com.tdt.Pmobile3.p2");
                    capabilities.setCapability("pCloudy_WildNet", "false");
                    capabilities.setCapability("pCloudy_EnableVideo", "true");
                    capabilities.setCapability("pCloudy_EnablePerformanceData", "true");
                    capabilities.setCapability("pCloudy_EnableDeviceLogs", "true");
                    capabilities.setCapability("appiumVersion", "1.20.2");
                    capabilities.setCapability("acceptAlerts", true);
                    capabilities.setCapability("autoGrantPermissions", true);
                    capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, Boolean.TRUE);

                    break;
                }
            }
            return capabilities;
        }
    }
}
