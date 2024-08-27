package android.tests;

import android.pages.*;
import configs.AppDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import org.testng.Assert;
import org.testng.annotations.Test;
public class PSGooglePlayAppIcons extends BaseTest{
    String appPackage = Constants.APP_PACKAGE;
    String screenshot1 = "screenshot1.png";
    String screenshot2 = "screenshot2.png";
    String screenshot3 = "screenshot3.png";
    String screenshot4 = "screenshot4.png";

    @Test(groups = "partisan_settings", description = "Google Play App Icons is enabled")
    public void iconsShouldBeGooglePlayApp() throws Exception {
        if (appPackage.equals("org.telegram.messenger")) {
            Assert.fail("Тест не выполняется для: " + appPackage);
        }
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        CacheAndOthersPage cacheAndOthersPage = new CacheAndOthersPage(driver);

        start.putPinCode();
        cacheAndOthersPage.homeScreen();
        cacheAndOthersPage.takeScreenshot(screenshot1);
        start.enterPin("withPinCode");
        privacy.openPartisanSettings();
        partisanSettings.activateGooglePlayAppIcons();
        cacheAndOthersPage.homeScreen();
        cacheAndOthersPage.takeScreenshot(screenshot2);
        cacheAndOthersPage.compareScreen(screenshot1, screenshot2);
    }

    @Test(groups = "partisan_settings", description = "Google Play App Icons is disabled")
    public void iconsShouldNotBeGooglePlayApp() throws Exception {
        if (appPackage.equals("org.telegram.messenger")) {
            Assert.fail("Тест не выполняется для: " + appPackage);
        }
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        CacheAndOthersPage cacheAndOthersPage = new CacheAndOthersPage(driver);

        start.putPinCode();
        cacheAndOthersPage.homeScreen();
        cacheAndOthersPage.takeScreenshot(screenshot3);
        start.enterPin("withPinCode");
        privacy.openPartisanSettings();
        partisanSettings.deactivateGooglePlayAppIcons();
        cacheAndOthersPage.homeScreen();
        cacheAndOthersPage.takeScreenshot(screenshot4);
        cacheAndOthersPage.compareScreen(screenshot3, screenshot4);
    }

}
