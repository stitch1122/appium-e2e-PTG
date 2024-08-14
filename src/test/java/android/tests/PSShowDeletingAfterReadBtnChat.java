package android.tests;

import android.pages.*;
import configs.AppDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import org.testng.annotations.Test;

public class PSShowDeletingAfterReadBtnChat extends BaseTest{
    String appPackage = Constants.APP_PACKAGE;
    String chatUrl = Constants.CHAT_GROUP_URL; //введите url группы к которой вы присоединились

    @Test(groups = "partisan_settings", description = "Show Deleting After Read Btn is disabled")
    public void deletingMyMessagesBtnIsNotShown() throws InterruptedException {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        Messages messages = new Messages(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.deactivateDeletingAfterRead();
        start.enterPin("withPinCode");
        searchPage.findAndOpenChat(chatUrl);
        messages.enterMessageAndLongTap();
        messages.checkDeletingAfterReadingBtnDisappear();
        start.enterPin("withFakePinCode");
        searchPage.findAndOpenChat(chatUrl);
        messages.enterMessageAndLongTap();
        messages.checkDeletingAfterReadingBtnDisappear();
    }

    @Test(groups = "partisan_settings", description = "Show Deleting After Read Btn is enabled")
    public void deletingMyMessagesBtnIsShown() throws InterruptedException {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        Messages messages = new Messages(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.activateDeletingAfterRead();
        start.enterPin("withPinCode");
        searchPage.findAndOpenChat(chatUrl);
        messages.enterMessageAndLongTap();
        messages.checkDeletingAfterReadingBtnAppear();
        start.enterPin("withFakePinCode");
        searchPage.findAndOpenChat(chatUrl);
        messages.enterMessageAndLongTap();
        messages.checkDeletingAfterReadingBtnDisappear();
    }
}
