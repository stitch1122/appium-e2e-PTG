package android.tests;

import configs.AppDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.StartsActivity;
import org.testng.annotations.*;
import io.appium.java_client.android.Activity;

@Listeners({configs.Listener.class})
public class BaseTest {
    protected AppiumDriver driver;

    @BeforeMethod
    public void setUp() {
        driver =  AppDriver.getDriver();
    }

    @AfterMethod
    public void stopActivity() {
        System.out.println("Stop Activity from @AfterMethod BaseTest");
        Activity activity = new Activity("org.telegram.messenger.web", "org.telegram.ui.LaunchActivity");
        ((StartsActivity) driver).startActivity(activity);
    }
}