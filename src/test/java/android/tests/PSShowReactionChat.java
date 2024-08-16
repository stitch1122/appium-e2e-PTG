package android.tests;

import android.pages.*;
import configs.AppDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import org.testng.annotations.Test;

public class PSShowReactionChat extends BaseTest {
    String appPackage = Constants.APP_PACKAGE;
    String chatUrl = Constants.CHAT_GROUP_URL; // введите url группы в которой вы состоите и есть сообщения

    @Test(groups = "partisan_settings", description = "Show Chat Reaction is disabled")
    public void chatReactionIsNotShown() throws InterruptedException {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        Messages messages = new Messages(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.deactivateReactToMessages();
        start.enterPin("withPinCode");
        searchPage.findAndOpenChat(chatUrl); //введите url
        messages.enterMessageAndSend();
        messages.findMessageAndTap();
        messages.checkReactionMenuDisappear();
        start.enterPin("withFakePinCode");
        searchPage.findAndOpenChat(chatUrl); //введите url
        messages.findMessageAndTap();
        messages.checkReactionMenuAppear();
//        start.enterPin("withPinCode");
//        searchPage.findAndOpenChat(chatUrl);
//        messages.findMessageAndDelete();
    }

    @Test(groups = "partisan_settings", description = "Show Chat Reaction is enabled")
    public void chatReactionIsShown() throws InterruptedException {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        Messages messages = new Messages(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.activateReactToMessages();
        start.enterPin("withPinCode");
        searchPage.findAndOpenChat(chatUrl); //введите url
        messages.enterMessageAndSend();
        messages.findMessageAndTap();
        messages.checkReactionMenuAppear();
        start.enterPin("withFakePinCode");
        searchPage.findAndOpenChat(chatUrl); //введите url
        messages.findMessageAndTap();
        messages.checkReactionMenuAppear();
//        start.enterPin("withPinCode");
//        searchPage.findAndOpenChat(chatUrl);
//        messages.findMessageAndDelete();
    }

}
