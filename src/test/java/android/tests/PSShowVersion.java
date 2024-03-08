package android.tests;

import android.pages.*;
import configs.AppDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import org.testng.annotations.Test;

public class PSShowVersion extends BaseTest {
    @Test(groups = "partisan_settings", description = "Show Version is disabled")
    public void shouldVersionTGIsNotShown() throws InterruptedException {
        StartPage start = new StartPage(driver);
        SettingsPage settings = new SettingsPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.deactivateShowVersion();
        start.open("withPinCode");
        settings.checkVersionTGDisappear();
        start.open("withFakePinCode");
        settings.checkVersionTGDisappear();
    }
    @Test(groups = "partisan_settings", description = "Show Version is enabled")
    public void shouldVersionTGIsShown() throws InterruptedException {
        Activity activity = new Activity("org.telegram.messenger.web", "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        SettingsPage settings = new SettingsPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.activateShowVersion();
        start.open("withPinCode");
        settings.checkVersionTGAppear();
        start.open("withFakePinCode");
        settings.checkVersionTGDisappear();
    }
}
