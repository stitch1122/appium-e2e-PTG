package android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class MenuSection extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
    private static MobileElement itemSettings;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Profile']")
    private static MobileElement myProfileBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Calls']")
    private static MobileElement callsBtn;

    public MenuSection(AppiumDriver driver) { this.driver=driver; }

    public void openSettings() throws InterruptedException {
        Thread.sleep(2000);
        HeaderSection header = new HeaderSection(driver);
        header.openMenu();
        itemSettings.click();
    }

    public void openMyProfile() throws InterruptedException {
        Thread.sleep(2000);
        HeaderSection header = new HeaderSection(driver);
        header.openMenu();
        myProfileBtn.click();
    }

    public void openCalls() throws InterruptedException {
        Thread.sleep(2000);
        HeaderSection header = new HeaderSection(driver);
        header.openMenu();
        callsBtn.click();
    }
}
