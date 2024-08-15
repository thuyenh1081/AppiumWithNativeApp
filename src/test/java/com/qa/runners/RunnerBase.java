package com.qa.runners;

import com.qa.pages.BasePage;
import com.qa.pages.CommonContentPage;
import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;
import com.qa.utils.TestUtils;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.*;

public class RunnerBase {
    private static final ThreadLocal<TestNGCucumberRunner> testNGCucumberRunner = new ThreadLocal<>();

    public static TestNGCucumberRunner getRunner(){
        return testNGCucumberRunner.get();
    }

    private static void setRunner(TestNGCucumberRunner testNGCucumberRunner1){
        testNGCucumberRunner.set(testNGCucumberRunner1);
    }

    @Parameters({"platformName", "pcloudy","udid", "deviceName", "systemPort",
            "chromeDriverPort", "wdaLocalPort", "webkitDebugProxyPort","emulator"})
    @BeforeClass(alwaysRun = true)
    public void setUpClass(String platformName, String pcloudy, @Optional("Android") String udid, String deviceName, @Optional("Android") String systemPort,
                           @Optional("Android") String chromeDriverPort,
                           @Optional("iOS") String wdaLocalPort,
                           @Optional("iOS") String webkitDebugProxyPort, @Optional("emulator") String emulator) throws Exception {

        GlobalParams params = new GlobalParams();
        params.setPlatformName(platformName);
        params.setPcloudy(pcloudy);
        params.setUDID(udid);
        params.setDeviceName(deviceName);
//        TestUtils.platform = platformName;

        switch(platformName){
            case "Android":
                params.setEmulator(emulator);
                params.setSystemPort(systemPort);
                params.setChromeDriverPort(chromeDriverPort);
                break;
            case "iOS":
                params.setWdaLocalPort(wdaLocalPort);
                params.setWebkitDebugProxyPort(webkitDebugProxyPort);
                break;
        }

//        new ServerManager().startServer();
//        new DriverManager().initializeDriver();
        ///////////

        setRunner(new TestNGCucumberRunner(this.getClass()));
    }

    @BeforeMethod()
    public void beforeMethod() throws Exception {
        new DriverManager().initializeDriver();
        if (new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.IosPlatform)) {
            new CommonContentPage(true).goToPremarketPage();
        }
    }
    @AfterMethod()
    public void afterMethod() throws Exception {

//////        todo: just make action to turn on when running for the feature of check internet connection
//        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.AndroiPlatform)) {
//            new BasePage().configureWifiMode("true");
//        }

        if(new GlobalParams().getPlatformName().equalsIgnoreCase(TestUtils.IosPlatform))
        {
            new CommonContentPage().goToPremarketPage();
        }

        DriverManager driverManager = new DriverManager();
        if(driverManager.getDriver() != null){
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }
    }
    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) throws Throwable {
        getRunner().runScenario(pickle.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return getRunner().provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        //used in aftermethod
//        DriverManager driverManager = new DriverManager();
//        if(driverManager.getDriver() != null){
//            driverManager.getDriver().quit();
//            driverManager.setDriver(null);
//        }
        ServerManager serverManager = new ServerManager();
        if(serverManager.getServer() != null){
            serverManager.getServer().stop();
        }
        if(testNGCucumberRunner != null){
            getRunner().finish();
        }
    }
}