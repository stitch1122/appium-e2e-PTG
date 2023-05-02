package android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import java.util.List;

public class SettingsPage extends BasePage {

    public SettingsPage(AppiumDriver driver) { this.driver=driver; }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Language']")
    private static MobileElement itemLanguageEng;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Мова']")
    private static MobileElement itemLanguageBlr;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Апавяшчэнні і гукі']")
    private static MobileElement itemNotificationBlr;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Notifications and Sounds']")
    private static MobileElement itemNotificationEng;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Беларуская']")
    private static MobileElement langBelarusian;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='English']")
    private static MobileElement langEnglish;

    public void chooseLanguageBelarusian() throws InterruptedException {
        Utils.scroll(driver);
        itemLanguageEng.click();
        langBelarusian.click();
        Thread.sleep(2000);
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }
    public void chooseLanguageEnglish() throws InterruptedException {
        Utils.scroll(driver);
        itemLanguageBlr.click();
        langEnglish.click();
        HeaderSection header = new HeaderSection(driver);
        header.goBackBlr();
    }

    public boolean isBelarusianLanguage() {return itemNotificationBlr.isDisplayed();}

    public boolean isEnglishLanguage() {return itemNotificationEng.isDisplayed();}

    public void open(String pinCode) throws InterruptedException {
        Activity activity = new Activity("org.telegram.messenger.web", "org.telegram.ui.LaunchActivity");
        ((StartsActivity) driver).startActivity(activity);
        StartPage start = new StartPage(driver);
        if(pinCode == "1111" || pinCode == "withPinCode") {
            start.putPinCode();
        }
        else if(pinCode == "2222" || pinCode == "withFakePinCode"){
            start.putFakePinCode();
        }
        MenuSection menu = new MenuSection(driver);
        menu.openSettings();
    }

    public void checkVersionTGDisappear() throws InterruptedException {
        Utils.scroll(driver);
        List<MobileElement> elements = driver.findElements(By.xpath("//*[contains(@text,'PTelegram version')]"));
        Assert.assertTrue(elements.isEmpty());

        boolean isElementPresent = driver.findElements(By.xpath("//*[contains(@text,'Telegram for Android')]")).size() > 0;
        Assert.assertTrue(isElementPresent);
    }

    public void checkVersionTGAppear() throws InterruptedException {
        Utils.scroll(driver);
        boolean isElementPTelegram = driver.findElements(By.xpath("//*[contains(@text,'PTelegram version')]")).size() > 0;
        Assert.assertTrue(isElementPTelegram);

        boolean isElementTelegram = driver.findElements(By.xpath("//*[contains(@text,'Telegram for Android')]")).size() > 0;
        Assert.assertTrue(isElementTelegram);
    }
}