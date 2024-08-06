package android.pages;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Account extends BasePage {

    public Account (AppiumDriver driver) { this.driver=driver; }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Profile']")
    private static MobileElement myProfileBtn;

    public void openMyProfile() throws InterruptedException {
        Thread.sleep(2000);
        HeaderSection header = new HeaderSection(driver);
        header.openMenu();
        myProfileBtn.click();
    }

    public void checkIdDisappearMyAccount() throws InterruptedException {
        Thread.sleep(2000);
        List<MobileElement> elements = driver.findElements(By.xpath("//*[contains(@text,'User ID')]"));
        Assert.assertTrue(elements.isEmpty());
        System.out.println("Мой Id не отображается");
        Thread.sleep(2000);
    }

    public void checkIdAppearMyAccount() throws InterruptedException {
        Thread.sleep(2000);
        boolean isElementMyId = driver.findElements(By.xpath("//*[contains(@text,'User ID')]")).size() > 0;
        Assert.assertTrue(isElementMyId);
        System.out.println("Мой Id отображается");
        Thread.sleep(2000);
    }
}
