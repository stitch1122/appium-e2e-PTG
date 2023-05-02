package configs;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class CommonActions {

    public static final AppProperties appProperties = new AppProperties();
    public static AppiumDriver<WebElement> driver;

    public static AppiumDriver<MobileElement> androidLaunchApp() throws MalformedURLException {

        String androidApp = appProperties.getProperty("androidApp");
        String fileName = "app.apk";
        File appDir = new File("src/main/java/resources");
        File androidApplication = new File(appDir, fileName);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, androidApplication.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);
        capabilities.setCapability(MobileCapabilityType.UDID, appProperties.getProperty("deviceUDID"));
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.telegram.messenger.web");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.telegram.ui.LaunchActivity");
        try {
            return new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver iOSLaunchApp()  {
        return null;
    }
}