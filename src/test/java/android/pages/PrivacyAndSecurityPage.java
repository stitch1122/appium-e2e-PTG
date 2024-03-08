package android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PrivacyAndSecurityPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Passcode Lock']")
    private static MobileElement itemPasscodeLock;

    public PrivacyAndSecurityPage(AppiumDriver driver) {
        this.driver=driver;
    }

    public void switchOnPasscode() throws InterruptedException {
        SettingsPage settings = new SettingsPage(driver);
        EnterPasscodeSection passcodeSection = new EnterPasscodeSection(driver);

        settings.openPrivacyAndSecurity();
        itemPasscodeLock.click();
        passcodeSection.enablePasscode();
        Thread.sleep(2000);
        passcodeSection.putPasscode("1");
        passcodeSection.putPasscode("1");
        //Thread.sleep(8000);
        //String pageSource = driver.getPageSource();
        //System.out.println(pageSource);
    }

    public void openPartisanSettings() throws InterruptedException {
        MenuSection menu = new MenuSection(driver);
        SettingsPage settings = new SettingsPage(driver);
        EnterPasscodeSection passcodeSection = new EnterPasscodeSection(driver);
        PasscodeLockPage passcodePage = new PasscodeLockPage(driver);

        menu.openSettings();
        settings.openPrivacyAndSecurity();
        itemPasscodeLock.click();
        Thread.sleep(2000);
        passcodeSection.putPasscode("1");
        Utils.scroll(driver);
        passcodePage.openPS();
    }
}