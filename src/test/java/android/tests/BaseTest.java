package android.tests;

import configs.AppDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners({configs.Listener.class})
public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver =  AppDriver.getDriver();
    }
}