package android.pages;

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
        scroll();
        itemLanguageEng.click();
        langBelarusian.click();
        Thread.sleep(2000);
        goBackEng.click();
    }

    public void chooseLanguageEnglish() throws InterruptedException {
        scroll();
        itemLanguageBlr.click();
        langEnglish.click();
        Thread.sleep(2000);
        goBackBlr.click();
    }

    public boolean isBelarusianLanguage() {return itemNotificationBlr.isDisplayed();}

    public boolean isEnglishLanguage() {return itemNotificationEng.isDisplayed();}

    public void scroll() throws InterruptedException {
        Thread.sleep(2000);
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int width = size.width;
        int height = size.height;
        int middleOfX = width / 2;
        int startYCoordinate = (int) (height * .8);
        int endYCoordinate = (int) (height * .0);
        action.press(PointOption.point(middleOfX, startYCoordinate))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
        Thread.sleep(2000);
    }
}