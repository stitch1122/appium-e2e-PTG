package android.tests;

import android.pages.*;
import configs.AppDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import org.testng.annotations.Test;

public class PSShowAvatarBtnGroup extends BaseTest{
    String appPackage = Constants.APP_PACKAGE;
    String chatUrl = Constants.INFO_GROUP_URL;

    @Test(groups = "partisan_settings", description = "Show Avatar is disabled")
    public void groupAvatarBtnIsNotShown() throws InterruptedException {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        SearchPage searchPage = new SearchPage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.deactivateShowAvatar();
        start.enterPin("withPinCode");
        searchPage.findAndOpenInfoChat(chatUrl); //введите url группы с аватаркой
        searchPage.openMoreMenuChat();
        searchPage.checkAvatarBtnDisappear();
        start.enterPin("withFakePinCode");
        searchPage.findAndOpenInfoChat(chatUrl); //введите url группы с аватаркой
        searchPage.openMoreMenuChat();
        searchPage.checkAvatarBtnDisappear();
    }

    @Test(groups = "partisan_settings", description = "Show Avatar is enabled")
    public void groupAvatarBtnIsShown() throws InterruptedException {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        SearchPage searchPage = new SearchPage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.activateShowAvatar();
        start.enterPin("withPinCode");
        searchPage.findAndOpenInfoChat(chatUrl); //введите url группы с аватаркой
        searchPage.openMoreMenuChat();
        searchPage.checkAvatarBtnAppear();
        start.enterPin("withFakePinCode");
        searchPage.findAndOpenInfoChat(chatUrl); //введите url группы с аватаркой
        searchPage.openMoreMenuChat();
        searchPage.checkAvatarBtnDisappear();
    }
}
