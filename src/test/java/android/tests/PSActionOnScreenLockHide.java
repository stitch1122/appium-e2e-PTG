package android.tests;

import android.pages.*;
import configs.AppDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import org.testng.annotations.Test;

public class PSActionOnScreenLockHide extends BaseTest {
    String appPackage = Constants.APP_PACKAGE;

    @Test(groups = "partisan_settings", description = "Selected Hide and Clear Cache in Action On Screen Lock")
    public void appHideAndHomeScreenShow () throws Exception {

        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        ChatListPage chatListPage = new ChatListPage(driver);
        CacheAndOthersPage cacheAndOthersPage = new CacheAndOthersPage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.selectHideAndClearCacheActionOnScreenLock();
        start.enterPin("withPinCode");
        cacheAndOthersPage.blockAndUnlockScreen();
        chatListPage.checkAppRunning();
        chatListPage.checkAppOnScreenNotDisplayed();
        start.enterPin("withFakePinCode");
        cacheAndOthersPage.blockAndUnlockScreen();
        chatListPage.checkAppRunning();
        chatListPage.checkAppOnScreenDisplayed();
    }

    @Test(groups = "partisan_settings", description = "Selected Nothing in Action On Screen Lock")
    public void appNotHideAndAppScreenShow () throws Exception {

        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        ChatListPage chatListPage = new ChatListPage(driver);
        CacheAndOthersPage cacheAndOthersPage = new CacheAndOthersPage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.selectDoNothingActionOnScreenLock();
        start.enterPin("withPinCode");
        cacheAndOthersPage.blockAndUnlockScreen();
        chatListPage.checkAppRunning();
        chatListPage.checkAppOnScreenDisplayed();
        start.enterPin("withFakePinCode");
        cacheAndOthersPage.blockAndUnlockScreen();
        chatListPage.checkAppRunning();
        chatListPage.checkAppOnScreenDisplayed();
    }

}
