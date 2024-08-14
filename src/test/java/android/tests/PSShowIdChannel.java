package android.tests;

import android.pages.*;
import configs.AppDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import org.testng.annotations.Test;

public class PSShowIdChannel extends BaseTest {
    String appPackage = Constants.APP_PACKAGE;
    String chatUrl = Constants.INFO_CHANNEL_URL;

    @Test(groups = "partisan_settings", description = "Show ID is disabled")
    public void channelIdIsNotShown() throws InterruptedException {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        SearchPage searchPage = new SearchPage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.deactivateShowId();
        start.enterPin("withPinCode");
        searchPage.findAndOpenInfoChat(chatUrl); //введите url своего канала
        searchPage.checkIdDisappearChannel();
        start.enterPin("withFakePinCode");
        searchPage.findAndOpenInfoChat(chatUrl); //введите url своего канала
        searchPage.checkIdDisappearChannel();
    }

    @Test(groups = "partisan_settings", description = "Show ID is enabled")
    public void channelIdIsShown() throws InterruptedException {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        SearchPage searchPage = new SearchPage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.activateShowId();
        start.enterPin("withPinCode");
        searchPage.findAndOpenInfoChat(chatUrl); //введите url своего канала
        searchPage.checkIdAppearChannel();
        start.enterPin("withFakePinCode");
        searchPage.findAndOpenInfoChat(chatUrl); //введите url своего канала
        searchPage.checkIdDisappearChannel();
    }
}
