package android.tests;

import android.pages.*;
import configs.AppDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import org.testng.annotations.Test;

public class PSShowSaveChatBtn extends BaseTest{
    String appPackage = Constants.APP_PACKAGE;
    String chatUrl = Constants.INFO_CHANNEL_URL;

    @Test(groups = "partisan_settings", description = "Show Save Btn is disabled")
    public void channelSaveBtnIsNotShown() throws InterruptedException {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        SearchPage searchPage = new SearchPage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.deactivateSavedChannels();
        start.enterPin("withPinCode");
        searchPage.findAndOpenChat(chatUrl); //введите url своего канала
        searchPage.openMoreMenuChat();
        searchPage.checkSaveBtnDisappear();
        start.enterPin("withFakePinCode");
        searchPage.findAndOpenChat(chatUrl); //введите url своего канала
        searchPage.openMoreMenuChat();
        searchPage.checkSaveBtnDisappear();
    }
    @Test(groups = "partisan_settings", description = "Show Save Btn is enabled")
    public void channelSaveBtnIsShown() throws InterruptedException {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        SearchPage searchPage = new SearchPage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.activateSavedChannels();
        start.enterPin("withPinCode");
        searchPage.findAndOpenChat(chatUrl); //введите url своего канала
        searchPage.openMoreMenuChat();
        searchPage.checkSaveBtnAppear();
        start.enterPin("withFakePinCode");
        searchPage.findAndOpenChat(chatUrl); //введите url своего канала
        searchPage.openMoreMenuChat();
        searchPage.checkSaveBtnDisappear();
    }
}
