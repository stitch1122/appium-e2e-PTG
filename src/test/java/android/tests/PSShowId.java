package android.tests;

import android.pages.*;
import configs.AppDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import org.testng.annotations.Test;

public class PSShowId extends BaseTest {
    @Test(groups = "partisan_settings", description = "Show ID is disabled")
    public void accountIdIsNotDisplayed() throws InterruptedException {
        StartPage start = new StartPage(driver);
        SettingsPage settings = new SettingsPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        Account account = new Account(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        Thread.sleep(2000);
        partisanSettings.deactivateShowId();
        start.open("withPinCode");
        account.checkIdDisappearMyAccount();
        start.open("withFakePinCode");
        account.checkIdDisappearMyAccount();
    }

    @Test(groups = "partisan_settings", description = "Show ID is enabled")
    public void accountIdIsDisplayed() throws InterruptedException {
        Activity activity = new Activity("org.telegram.messenger.web", "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        SettingsPage settings = new SettingsPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        Account account = new Account(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.activateShowId();
        start.open("withPinCode");
        account.checkIdAppearMyAccount();
        start.open("withFakePinCode");
        account.checkIdDisappearMyAccount();
    }

}
