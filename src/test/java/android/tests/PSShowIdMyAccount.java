package android.tests;
import android.pages.*;
import configs.AppDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import org.testng.annotations.Test;

public class PSShowIdMyAccount extends BaseTest {
    String appPackage = Constants.APP_PACKAGE;

    @Test(groups = "partisan_settings", description = "Show ID is disabled")
    public void myAccountIdIsNotShown() throws InterruptedException {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        AccountPage myAccount = new AccountPage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.deactivateShowId();
        start.open("withPinCode");
        myAccount.checkIdDisappearMyAccount();
        start.open("withFakePinCode");
        myAccount.checkIdDisappearMyAccount();
    }

    @Test(groups = "partisan_settings", description = "Show ID is enabled")
    public void myAccountIdIsShown() throws InterruptedException {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        AccountPage myAccount = new AccountPage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.activateShowId();
        start.open("withPinCode");
        myAccount.checkIdAppearMyAccount();
        start.open("withFakePinCode");
        myAccount.checkIdDisappearMyAccount();
    }
}
