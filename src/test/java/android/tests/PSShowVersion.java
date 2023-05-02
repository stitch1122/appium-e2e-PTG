package android.tests;

import android.pages.*;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import org.testng.annotations.Test;

public class PSShowVersion extends BaseTest {
    @Test(groups = "partisan_settings", description = "Show Version is disabled")
    public void shouldVersionTGIsNotShown() throws InterruptedException {
        SettingsPage settings = new SettingsPage(driver);
        PrivacyPage privacy = new PrivacyPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);

        privacy.openPartisanSettings();
        partisanSettings.deactivateShowVersion();
        settings.open("withPinCode");
        settings.checkVersionTGDisappear();
        settings.open("withFakePinCode");
        settings.checkVersionTGDisappear();
    }
    @Test(groups = "partisan_settings", description = "Show Version is enabled")
    public void shouldVersionTGIsShown() throws InterruptedException {
        SettingsPage settings = new SettingsPage(driver);
        PrivacyPage privacy = new PrivacyPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);

        privacy.openPartisanSettings();
        partisanSettings.activateShowVersion();
        settings.open("withPinCode");
        settings.checkVersionTGAppear();
        settings.open("withFakePinCode");
        settings.checkVersionTGDisappear();
    }
}
