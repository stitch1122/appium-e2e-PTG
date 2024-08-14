package android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

public class SavedChannelsPage extends BasePage{
    public SavedChannelsPage (AppiumDriver driver) { this.driver=driver; }

    public void checkSavedChannelsBtnDisappear() throws InterruptedException {
        HeaderSection headerSection = new HeaderSection(driver);
        headerSection.openMenu();
        Thread.sleep(2000);
        List<MobileElement> elementDel = driver.findElements(By.xpath("//*[contains(@text,'Saved Channels')]"));
        Assert.assertTrue(elementDel.isEmpty());
        System.out.println("Кнопка 'Сохраненные каналы' не отображается - ОК");
        //driver.navigate().back();
    }

    public void checkSavedChannelsBtnBtnAppear() throws InterruptedException {
        HeaderSection headerSection = new HeaderSection(driver);
        headerSection.openMenu();
        Thread.sleep(2000);
        boolean elementDel = driver.findElements(By.xpath("//*[contains(@text,'Saved Channels')]")).size() > 0;
        Assert.assertTrue(elementDel);
        System.out.println("Кнопка 'Сохраненные каналы' отображается - ОК");
        //driver.navigate().back();
    }
}
