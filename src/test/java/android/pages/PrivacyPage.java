package android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PrivacyPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy and Security']")
    private static MobileElement itemPrivacyAndSecurity;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Passcode Lock']")
    private static MobileElement itemPasscodeLock;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enable Passcode']")
    private static MobileElement buttonEnablePasscode;

    @AndroidFindBy(xpath = "//android.widget.EditText[1]")
    private static MobileElement firstSymbol;

    @AndroidFindBy(xpath = "//android.widget.EditText[2]")
    private static MobileElement secondSymbol;

    @AndroidFindBy(xpath = "//android.widget.EditText[3]")
    private static MobileElement thirdSymbol;

    @AndroidFindBy(xpath = "//android.widget.EditText[4]")
    private static MobileElement fourthSymbol;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Partisan Settings']")
    private static MobileElement itemPartisanSettings;

    public PrivacyPage(AppiumDriver driver) {
        this.driver=driver;
    }

    public void switchOnPasscode() throws InterruptedException {
        itemPrivacyAndSecurity.click();
        itemPasscodeLock.click();
        buttonEnablePasscode.click();
        Thread.sleep(2000);
        firstSymbol.sendKeys("1");
        secondSymbol.sendKeys("1");
        thirdSymbol.sendKeys("1");
        fourthSymbol.sendKeys("1");

        firstSymbol.sendKeys("1");
        secondSymbol.sendKeys("1");
        thirdSymbol.sendKeys("1");
        fourthSymbol.sendKeys("1");
    }

    public void openPartisanSettings() throws InterruptedException {
        StartPage startPage = new StartPage(driver);
        MenuSection menu = new MenuSection(driver);
        startPage.putPinCode();
        menu.openSettings();
        itemPrivacyAndSecurity.click();
        itemPasscodeLock.click();
        Thread.sleep(2000);
        firstSymbol.sendKeys("1");
        secondSymbol.sendKeys("1");
        thirdSymbol.sendKeys("1");
        fourthSymbol.sendKeys("1");
        Utils.scroll(driver);
        itemPartisanSettings.click();
    }
}
