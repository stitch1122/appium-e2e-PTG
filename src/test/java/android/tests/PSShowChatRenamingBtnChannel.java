package android.tests;

import android.pages.*;
import configs.AppDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import org.testng.annotations.Test;

public class PSShowChatRenamingBtnChannel extends BaseTest{
    String appPackage = Constants.APP_PACKAGE;
    String chatUrl = Constants.INFO_CHANNEL_URL;

    @Test(groups = "partisan_settings", description = "Show Chat Renaming Btn is disabled")
    public void channelChatRenamingBtnIsNotShown() throws InterruptedException {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        SearchPage searchPage = new SearchPage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.deactivateChatRenaming();
        start.enterPin("withPinCode");
        searchPage.findAndOpenInfoChat(chatUrl); //введите url своего канала
        searchPage.openMoreMenuChat();
        searchPage.checkChatRenamingBtnDisappear();
        start.enterPin("withFakePinCode");
        searchPage.findAndOpenInfoChat(chatUrl); //введите url своего канала
        searchPage.openMoreMenuChat();
        searchPage.checkChatRenamingBtnDisappear();
    }

    @Test(groups = "partisan_settings", description = "Show Chat Renaming Btn is enabled")
    public void channelChatRenamingBtnIsShown() throws InterruptedException {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        SearchPage searchPage = new SearchPage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.activateChatRenaming();
        start.enterPin("withPinCode");
        searchPage.findAndOpenInfoChat(chatUrl); //введите url своего канала
        searchPage.openMoreMenuChat();
        searchPage.checkChatRenamingBtnAppear();
        start.enterPin("withFakePinCode");
        searchPage.findAndOpenInfoChat(chatUrl); //введите url своего канала
        searchPage.openMoreMenuChat();
        searchPage.checkChatRenamingBtnDisappear();
    }
}
