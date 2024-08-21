package android.tests;

import android.pages.*;
import configs.AppDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import org.testng.annotations.Test;

public class PSDeleteDraftsUser extends BaseTest{
    String chatUrl = Constants.CHAT_USER_URL;
    String appPackage = Constants.APP_PACKAGE;
    String message = "xxx";

    @Test(groups = "partisan_settings", description = "Delete Drafts Btn is enabled")
    public void draftsShouldBeDeleted() throws Exception {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        Messages messages = new Messages(driver);
        ChatListPage chatListPage = new ChatListPage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.activateDeleteDrafts();
        start.enterPin("withPinCode");
        searchPage.findAndOpenChat(chatUrl); //введите url
        messages.enterMessage(message);
        chatListPage.blockAndUnlockScreen();
        start.enterPin("withPinCode");
        searchPage.findAndOpenChat(chatUrl);
        messages.checkDraftDisappear(message);
        start.enterPin("withFakePinCode");
        searchPage.findAndOpenChat(chatUrl); //введите url
        messages.enterMessage(message);
        chatListPage.blockAndUnlockScreen();
        start.enterPin("withFakePinCode");
        searchPage.findAndOpenChat(chatUrl); //введите url
        messages.checkDraftAppear(message);
        searchPage.findAndOpenChat(chatUrl);
        messages.findMessageAndDelete(message);
    }

    @Test(groups = "partisan_settings", description = "Delete Drafts Btn is disabled")
    public void draftsShouldNotBeDeleted() throws Exception {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        Messages messages = new Messages(driver);
        ChatListPage chatListPage = new ChatListPage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.deactivateDeleteDrafts();
        start.enterPin("withPinCode");
        searchPage.findAndOpenChat(chatUrl); //введите url
        messages.enterMessage(message);
        chatListPage.blockAndUnlockScreen();
        start.enterPin("withPinCode");
        searchPage.findAndOpenChat(chatUrl);
        messages.checkDraftAppear(message);
        searchPage.findAndOpenChat(chatUrl);
        messages.findMessageAndDelete(message);
        start.enterPin("withFakePinCode");
        searchPage.findAndOpenChat(chatUrl); //введите url
        messages.enterMessage(message);
        chatListPage.blockAndUnlockScreen();
        start.enterPin("withFakePinCode");
        searchPage.findAndOpenChat(chatUrl); //введите url
        messages.checkDraftAppear(message);
        searchPage.findAndOpenChat(chatUrl);
        messages.findMessageAndDelete(message);

    }
}
