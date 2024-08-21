package android.tests;

import android.pages.*;
import configs.AppDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import org.testng.annotations.Test;

public class PSShowCallBtn extends BaseTest{
    String chatUrl = Constants.CHAT_USER_URL;
    String appPackage = Constants.APP_PACKAGE;

    @Test(groups = "partisan_settings", description = "Show Call Btn is disabled")
    public void showCallBtnIsNotShown() throws InterruptedException {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        Messages messages = new Messages(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.deactivateShowCallBtn();
        start.enterPin("withPinCode");
        searchPage.findAndOpenChat(chatUrl); //введите url юзера
        messages.checkCallBtnDisappear();
        start.enterPin("withFakePinCode");
        searchPage.findAndOpenChat(chatUrl); //введите url юзера
        messages.checkCallBtnAppear();
    }

    @Test(groups = "partisan_settings", description = "Show Call Btn is enabled")
    public void showCallBtnIsShown() throws InterruptedException {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        Messages messages = new Messages(driver);
        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.activateShowCallBtn();
        start.enterPin("withPinCode");
        searchPage.findAndOpenChat(chatUrl); //введите url юзера
        messages.checkCallBtnAppear();
        start.enterPin("withFakePinCode");
        searchPage.findAndOpenChat(chatUrl); //введите url юзера
        messages.checkCallBtnAppear();
    }
}
