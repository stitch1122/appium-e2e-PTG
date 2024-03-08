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
}