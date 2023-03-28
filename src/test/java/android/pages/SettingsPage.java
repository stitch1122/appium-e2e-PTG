package android.pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class SettingsPage extends BasePage {
    public SettingsPage(AndroidDriver driver) { this.driver = driver; }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Language']")
    private static WebElement itemLanguageEng;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Мова']")
    private static WebElement itemLanguageBlr;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Апавяшчэнні і гукі']")
    private static WebElement itemNotificationBlr;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Notifications and Sounds']")
    private static WebElement itemNotificationEng;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Беларуская']")
    private static WebElement langBelarusian;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='English']")
    private static WebElement langEnglish;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Go back\"]")
    private static WebElement goBackEng;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Перайсці назад\"]")
    private static WebElement goBackBlr;

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

    private boolean isBelarusianLanguage() {return itemNotificationBlr.isDisplayed();}

    public void validateBelarusianLanguage() {
        if (!isBelarusianLanguage()) {
            throw new PageValidationException("'Апавяшчэнні і гукі' text is absent");
        }
    }

    private boolean isEnglishLanguage() {return itemNotificationEng.isDisplayed();}

    public void validateEnglishLanguage () {
        if (!isEnglishLanguage()) {
            throw new PageValidationException("'Notifications and Sounds' text is absent");
        }
    }

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
