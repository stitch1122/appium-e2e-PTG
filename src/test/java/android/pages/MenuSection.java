package android.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class MenuSection extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
    private static WebElement itemSettings;

    public MenuSection(AndroidDriver driver) { this.driver = driver; }

    public void openSettings() throws InterruptedException {
        Thread.sleep(2000);
        HeaderSection header = new HeaderSection(driver);
        header.openMenu();
        itemSettings.click();
    }
}
