package android.pages;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

public class MyProfilePage extends BasePage {

    public MyProfilePage (AppiumDriver driver) { this.driver=driver; }

    public void openMyProfile () throws InterruptedException{
        MenuSection menuSection = new MenuSection(driver);
        menuSection.openMyProfile();
    }


    public void checkIdDisappearMyProfile() throws InterruptedException {
        Thread.sleep(2000);
        List<MobileElement> elements = driver.findElements(By.xpath("//*[contains(@text,'User ID')]"));
        Assert.assertTrue(elements.isEmpty());
        System.out.println("Мой Id не отображается");
    }

    public void checkIdAppearMyProfile() throws InterruptedException {
        Thread.sleep(1000);
        boolean isElementMyId = driver.findElements(By.xpath("//*[contains(@text,'User ID')]")).size() > 0;
        Assert.assertTrue(isElementMyId);
        System.out.println("Мой Id отображается");
    }
}
