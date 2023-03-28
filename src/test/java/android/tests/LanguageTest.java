package android.tests;

import android.pages.MenuSection;
import android.pages.SettingsPage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class LanguageTest extends BaseTest {

    @Test(description = "Change language")
    public void shouldChangeLanguageSuccessfully() throws InterruptedException {
        MenuSection menu = new MenuSection((AndroidDriver) driver);
        menu.openSettings();

        SettingsPage settings = new SettingsPage((AndroidDriver) driver);
        settings.chooseLanguageBelarusian();
        Assertions.assertDoesNotThrow(settings::validateBelarusianLanguage);

        settings.chooseLanguageEnglish();
        Assertions.assertDoesNotThrow(settings::validateEnglishLanguage);
    }
}