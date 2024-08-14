package android.tests;

import android.pages.*;
import configs.AppDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import org.testng.annotations.Test;

public class PSShowSavedChannelsBtn extends BaseTest{
    String appPackage = Constants.APP_PACKAGE;

    @Test(groups = "partisan_settings", description = "Show Deleting After Read Btn is disabled")
    public void savedChannelBtnIsNotShown() throws InterruptedException {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        SavedChannelsPage savedChannelsPage = new SavedChannelsPage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.deactivateSavedChannels();
        start.enterPin("withPinCode");
        savedChannelsPage.checkSavedChannelsBtnDisappear();
        start.enterPin("withFakePinCode");
        savedChannelsPage.checkSavedChannelsBtnDisappear();
    }

    @Test(groups = "partisan_settings", description = "Show Deleting After Read Btn is enabled")
    public void savedChannelBtnIsShown() throws InterruptedException {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        SavedChannelsPage savedChannelsPage = new SavedChannelsPage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.activateSavedChannels();
        start.enterPin("withPinCode");
        savedChannelsPage.checkSavedChannelsBtnBtnAppear();
        start.enterPin("withFakePinCode");
        savedChannelsPage.checkSavedChannelsBtnDisappear();
    }
}
