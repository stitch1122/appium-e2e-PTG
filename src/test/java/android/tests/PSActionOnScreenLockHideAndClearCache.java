package android.tests;

import android.pages.*;
import configs.AppDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import org.testng.annotations.Test;

public class PSActionOnScreenLockHideAndClearCache extends BaseTest {
    String appPackage = Constants.APP_PACKAGE;

    @Test(groups = "partisan_settings", description = "Selected Hide and Clear Cache in Action On Screen Lock")
    public void cacheShouldBeEmpty () throws Exception {

        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        CacheAndOthersPage cacheAndOthersPage = new CacheAndOthersPage(driver);

        start.putPinCode();
        cacheAndOthersPage.executeAdbRoot();
        privacy.openPartisanSettings();
        partisanSettings.selectHideAndClearCacheActionOnScreenLock();
        start.enterPin("withPinCode");
        cacheAndOthersPage.blockAndUnlockScreen();
        cacheAndOthersPage.checkCacheInFolderNotHasFiles();
        start.enterPin("withFakePinCode");
        cacheAndOthersPage.blockAndUnlockScreen();
        cacheAndOthersPage.checkCacheInFolderHasFiles();
    }

    @Test(groups = "partisan_settings", description = "Selected Nothing in Action On Screen Lock")
    public void cacheShouldNotBeEmpty () throws Exception {

        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        CacheAndOthersPage cacheAndOthersPage = new CacheAndOthersPage(driver);

        start.putPinCode();
        cacheAndOthersPage.executeAdbRoot();
        privacy.openPartisanSettings();
        partisanSettings.selectDoNothingActionOnScreenLock();
        start.enterPin("withPinCode");
        cacheAndOthersPage.blockAndUnlockScreen();
        cacheAndOthersPage.checkCacheInFolderHasFiles();
        start.enterPin("withFakePinCode");
        cacheAndOthersPage.blockAndUnlockScreen();
        cacheAndOthersPage.checkCacheInFolderHasFiles();
    }
}
