package android.tests;

import android.pages.*;
import configs.AppDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import org.testng.annotations.Test;

public class PSShowDeletingMyMessagesBtnGroup extends BaseTest{
    String appPackage = Constants.APP_PACKAGE;
    String chatUrl = Constants.INFO_GROUP_URL; //введите url своей группы

    @Test(groups = "partisan_settings", description = "Show Deleting My Messages Btn is disabled")
    public void deletingMyMessagesBtnIsNotShown() throws InterruptedException {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        SearchPage searchPage = new SearchPage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.deactivateDeletingMyMessages();
        start.enterPin("withPinCode");
        searchPage.findAndOpenChat(chatUrl); //введите url своей группы
        searchPage.openMoreMenuChat();
        searchPage.checkDeletingMyMessagesBtnDisappear();
        start.enterPin("withFakePinCode");
        searchPage.findAndOpenChat(chatUrl); //введите url своей группы
        searchPage.openMoreMenuChat();
        searchPage.checkDeletingMyMessagesBtnDisappear();
    }

    @Test(groups = "partisan_settings", description = "Show Deleting My Messages Btn is enabled")
    public void deletingMyMessagesBtnIsShown() throws InterruptedException {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        SearchPage searchPage = new SearchPage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.activateDeletingMyMessages();
        start.enterPin("withPinCode");
        searchPage.findAndOpenChat(chatUrl); //введите url своей группы
        searchPage.openMoreMenuChat();
        searchPage.checkDeletingMyMessagesBtnAppear();
        start.enterPin("withFakePinCode");
        searchPage.findAndOpenChat(chatUrl); //введите url своей группы
        searchPage.openMoreMenuChat();
        searchPage.checkDeletingMyMessagesBtnDisappear();
    }
}
