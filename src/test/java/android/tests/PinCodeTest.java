package android.tests;

import android.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PinCodeTest extends BaseTest{
    @Test(groups = "regression", description = "Enable Passcode")
    public void shouldPutVerificationCode() throws InterruptedException {
        MenuSection menu = new MenuSection(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PasscodeLockPage passcodePage = new PasscodeLockPage(driver);
        FakePasscode fakePasscode = new FakePasscode(driver);

        menu.openSettings();
        privacy.switchOnPasscode();
        //passcodePage.setAutoLock();
        passcodePage.putFakePasscode();
        Thread.sleep(4000);
        Assert.assertTrue(fakePasscode.isFakePasscode1Displayed(), "Passcode was not created");
    }
}