package configs;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class AppDriver {

    private static AppiumDriver<MobileElement> driver;

    public static AppiumDriver<MobileElement> getDriver(){
        return driver;
    }

    private static void setDriver(AppiumDriver<MobileElement> driver){
       AppDriver.driver = driver;
    }

    public static void createAndroidDriver() throws MalformedURLException {
        setDriver(CommonActions.androidLaunchApp());
    }

    public static void createIOSDriver() {
        //setDriver(CommonActions.iOSLaunchApp());
    }

    public static void closeDriver() {
        driver.close();
    }
}