package android.tests;

import android.pages.MenuSection;
import android.pages.SettingsPage;
import configs.AppDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LanguageTest extends BaseTest{
    @Test(groups = "regression", description = "Change language")
    public void shouldChangeLanguageSuccessfully() throws InterruptedException {

        MenuSection menu = new MenuSection(driver);
        menu.openSettings();

        System.out.println(driver);

        SettingsPage settings = new SettingsPage(driver);
        settings.chooseLanguageBelarusian();
        Assert.assertTrue(settings.isBelarusianLanguage(), "Not Belarusian");

        settings.chooseLanguageEnglish();
        Assert.assertTrue(settings.isEnglishLanguage(), "Not English");
    }
}