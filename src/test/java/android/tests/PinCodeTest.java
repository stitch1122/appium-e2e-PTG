package android.tests;

import android.pages.*;
import configs.AppDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PinCodeTest extends BaseTest{
    String appPackage = Constants.APP_PACKAGE;
    @Test(groups = "regression", description = "Enable Passcode")
    public void shouldPutVerificationCode() throws InterruptedException {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        MenuSection menu = new MenuSection(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PasscodeLockPage passcodePage = new PasscodeLockPage(driver);
        FakePasscode fakePasscode = new FakePasscode(driver);

        menu.openSettings();
        privacy.switchOnPasscode();
        //passcodePage.setAutoLock();
        passcodePage.setAutoLockOneSec();
        Thread.sleep(2000);
        passcodePage.enableShowContent();
        Thread.sleep(4000);
        passcodePage.putFakePasscode();
        Thread.sleep(4000);
        Assert.assertTrue(fakePasscode.isFakePasscode1Displayed(), "Passcode was not created");
    }
}