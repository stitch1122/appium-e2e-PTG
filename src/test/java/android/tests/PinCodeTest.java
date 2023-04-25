package android.tests;

import android.pages.MenuSection;
import android.pages.PrivacyPage;
import org.testng.annotations.Test;

public class PinCodeTest extends BaseTest {
    @Test(groups = "regression", description = "Enable Passcode")
    public void shouldPutVerificationCode() throws InterruptedException {
        MenuSection menu = new MenuSection(driver);
        menu.openSettings();

        PrivacyPage privacy = new PrivacyPage(driver);
        privacy.switchOnPasscode();
    }
}