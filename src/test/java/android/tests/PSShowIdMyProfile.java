package android.tests;

import android.pages.*;
import configs.AppDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import org.testng.annotations.Test;

public class PSShowIdMyProfile extends BaseTest {
    String appPackage = Constants.APP_PACKAGE;
    @Test(groups = "partisan_settings", description = "Show ID is disabled")
    public void myProfileIdIsNotShown() throws InterruptedException {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        MyProfilePage myProfile = new MyProfilePage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.deactivateShowId();
        start.enterPin("withPinCode");
        myProfile.openMyProfile();
        myProfile.checkIdDisappearMyProfile();
        start.enterPin("withFakePinCode");
        myProfile.openMyProfile();
        myProfile.checkIdDisappearMyProfile();
    }

    @Test(groups = "partisan_settings", description = "Show ID is enabled")
    public void myProfileIdIsShown() throws InterruptedException {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        MyProfilePage myProfile = new MyProfilePage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.activateShowId();
        start.enterPin("withPinCode");
        myProfile.openMyProfile();
        myProfile.checkIdAppearMyProfile();
        start.enterPin("withFakePinCode");
        myProfile.openMyProfile();
        myProfile.checkIdDisappearMyProfile();
    }

}
