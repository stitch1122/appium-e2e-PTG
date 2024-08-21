package android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;

public class SettingsPage extends BasePage {

    public SettingsPage(AppiumDriver driver) { this.driver=driver; }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy and Security']")
    private static MobileElement itemPrivacyAndSecurity;

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

    public void openPrivacyAndSecurity () throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean elFound = false;

        while (!elFound) {
            try {
                MobileElement privacyAndSecurity = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Privacy and Security']")));
                elFound = true;
                privacyAndSecurity.click();
            } catch (Exception e) {
                Utils.scroll(driver);
            }
        }
    }

    public void chooseLanguageBelarusian() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean elFound = false;
        while (!elFound) {
            try {
                MobileElement langEng = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Language']")));
                elFound = true;
                itemLanguageEng.click();
                langBelarusian.click();
            } catch (Exception e) {
                Utils.scroll(driver);
            }
        }
        Thread.sleep(2000);
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }
    public void chooseLanguageEnglish() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean elFound = false;
        while (!elFound) {
            try {
                MobileElement langBel = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Мова']")));
                elFound = true;
                itemLanguageBlr.click();
                langEnglish.click();
            } catch (Exception e) {
                Utils.scroll(driver);
            }
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBackBlr();
    }

    public boolean isBelarusianLanguage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean elFound = false;
        while (!elFound) {
            try {
                MobileElement notifBlr = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Апавяшчэнні і гукі']")));
                elFound = true;

            } catch (Exception e) {
                Utils.scroll(driver);
            }
        } return itemNotificationBlr.isDisplayed();
    }

    public boolean isEnglishLanguage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean elFound = false;
        while (!elFound) {
            try {
                MobileElement notifEng = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Notifications and Sounds']")));
                elFound = true;

            } catch (Exception e) {
                Utils.scroll(driver);
            }
        }
        return itemNotificationEng.isDisplayed();
    }

    public void checkVersionTGDisappear() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean elementFound = false;
        while (!elementFound) {
            try {
                MobileElement el = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@text,'Telegram for Android')]")));
                elementFound = true;
                boolean isElementPresent = driver.findElements(By.xpath("//*[contains(@text,'Telegram for Android')]")).size() > 0;
                Assert.assertTrue(isElementPresent);
                List<MobileElement> elements = driver.findElements(By.xpath("//*[contains(@text,'PTelegram version')]"));
                Assert.assertTrue(elements.isEmpty());
            } catch (Exception e) {
                Utils.scroll(driver);
            }
        }
    }

    public void checkVersionTGAppear() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean elementFound = false;
        while (!elementFound) {
            try {
                MobileElement el = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@text,'Telegram for Android')]")));
                elementFound = true;
                boolean isElementTelegram = driver.findElements(By.xpath("//*[contains(@text,'Telegram for Android')]")).size() > 0;
                Assert.assertTrue(isElementTelegram);
                boolean isElementPTelegram = driver.findElements(By.xpath("//*[contains(@text,'PTelegram version')]")).size() > 0;
                Assert.assertTrue(isElementPTelegram);
            } catch (Exception e) {
                Utils.scroll(driver);
            }
        }
    }
}