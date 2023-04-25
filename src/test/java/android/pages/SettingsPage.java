package android.pages;

import configs.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class SettingsPage extends BasePage {

    public SettingsPage(AppiumDriver driver) { super(driver); }

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

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Go back\"]")
    private static MobileElement goBackEng;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Перайсці назад\"]")
    private static MobileElement goBackBlr;

    public void chooseLanguageBelarusian() throws InterruptedException {
        Utils.scroll(driver);
        itemLanguageEng.click();
        langBelarusian.click();
        Thread.sleep(2000);
        goBackEng.click();
    }


    public void chooseLanguageEnglish() throws InterruptedException {
        Utils.scroll(driver);
        itemLanguageBlr.click();
        langEnglish.click();
        Thread.sleep(2000);
        goBackBlr.click();
    }

    public boolean isBelarusianLanguage() {return itemNotificationBlr.isDisplayed();}

    public boolean isEnglishLanguage() {return itemNotificationEng.isDisplayed();}


}