package android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

public class AccountPage extends BasePage {
    public AccountPage (AppiumDriver driver) { this.driver=driver; }

    public void checkIdDisappearMyAccount() throws InterruptedException {
        Thread.sleep(2000);
        List<MobileElement> elements = driver.findElements(By.xpath("//*[contains(@text,'User ID')]"));
        Assert.assertTrue(elements.isEmpty());
        System.out.println("Мой Id не отображается");
    }

    public void checkIdAppearMyAccount() throws InterruptedException {
        Thread.sleep(1000);
        boolean isElementMyId = driver.findElements(By.xpath("//*[contains(@text,'User ID')]")).size() > 0;
        Assert.assertTrue(isElementMyId);
        System.out.println("Мой Id отображается");
    }
}
