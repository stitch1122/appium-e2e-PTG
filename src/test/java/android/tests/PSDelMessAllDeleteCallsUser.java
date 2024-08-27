package android.tests;

import android.pages.*;
import configs.AppDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import org.testng.annotations.Test;

public class PSDelMessAllDeleteCallsUser extends BaseTest{
    String chatUrl = Constants.CALLS_USER_URL;
    String appPackage = Constants.APP_PACKAGE;

    @Test(groups = "partisan_settings", description = "Delete Messages For All By Default Btn is enabled")
    public void deleteMessagesByDefaultShouldBeChecked() throws Exception {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        MenuSection menuSection = new MenuSection(driver);
        CallsPage callsPage = new CallsPage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.activateDeleteMessagesByDefault();
        start.enterPin("withPinCode");
        searchPage.findAndOpenChat(chatUrl);
        searchPage.callAndEndCallUser();
        menuSection.openCalls();
        callsPage.checkDeleteCallsAllChecked();
        start.enterPin("withFakePinCode");
        menuSection.openCalls();
        callsPage.checkDeleteCallsAllUnchecked();
    }
    @Test(groups = "partisan_settings", description = "Delete Messages For All By Default Btn is enabled")
    public void deleteMessagesByDefaultShouldBeUnchecked() throws Exception {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        MenuSection menuSection = new MenuSection(driver);
        CallsPage callsPage = new CallsPage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.deactivateDeleteMessagesByDefault();
        start.enterPin("withPinCode");
        searchPage.findAndOpenChat(chatUrl);
        searchPage.callAndEndCallUser();
        menuSection.openCalls();
        callsPage.checkDeleteCallsAllUnchecked();
        start.enterPin("withFakePinCode");
        menuSection.openCalls();
        callsPage.checkDeleteCallsAllUnchecked();
    }

}
