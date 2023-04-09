package android.tests;

import android.pages.MenuSection;
import android.pages.SettingsPage;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LanguageTest extends BaseTest {

    @Test(description = "Change language")
    public void shouldChangeLanguageSuccessfully() throws InterruptedException {
        MenuSection menu = new MenuSection(driver);
        menu.openSettings();

        SettingsPage settings = new SettingsPage(driver);
        settings.chooseLanguageBelarusian();
        Assert.assertTrue(settings.isBelarusianLanguage(), "Not Belarusian");

        settings.chooseLanguageEnglish();
        Assert.assertTrue(settings.isEnglishLanguage(), "Not English");
    }
}