package android.tests;

import android.pages.BasePage;
import configs.AppDriver;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.*;

@Listeners({configs.Listener.class})
public class BaseTest {
    protected AppiumDriver driver;
    protected BasePage page;

    @BeforeClass
    public void setUp() {
        driver =  AppDriver.getDriver();
        driver.manage().logs().get("logcat").getAll();
        page = new BasePage(driver);
    }
}