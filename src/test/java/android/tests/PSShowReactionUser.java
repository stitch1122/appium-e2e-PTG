package android.tests;

import android.pages.*;
import configs.AppDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import org.testng.annotations.Test;

public class PSShowReactionUser extends BaseTest{
    String appPackage = Constants.APP_PACKAGE;
    String chatUrl = Constants.CHAT_USER_URL; // введите url группы в которой вы состоите и есть сообщения
    String messageReaction = "reaction";

    @Test(groups = "partisan_settings", description = "Show Chat Reaction is disabled")
    public void userReactionIsNotShown() throws InterruptedException {
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
        messages.enterMessageAndSend(messageReaction);
        messages.findMessageAndTap(messageReaction);
        messages.checkReactionMenuDisappear();
        start.enterPin("withFakePinCode");
        searchPage.findAndOpenChat(chatUrl); //введите url
        messages.findMessageAndTap(messageReaction);
        messages.checkReactionMenuAppear();
        messages.findMessageAndDelete(messageReaction);
    }

    @Test(groups = "partisan_settings", description = "Show Chat Reaction is enabled")
    public void userReactionIsShown() throws InterruptedException {
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
        messages.enterMessageAndSend(messageReaction);
        messages.findMessageAndTap(messageReaction);
        messages.checkReactionMenuAppear();
        start.enterPin("withFakePinCode");
        searchPage.findAndOpenChat(chatUrl); //введите url
        messages.findMessageAndTap(messageReaction);
        messages.checkReactionMenuAppear();
        messages.findMessageAndDelete(messageReaction);
    }
}
