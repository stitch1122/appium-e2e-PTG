package android.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class PrivacyPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy and Security']")
    private static WebElement itemPrivacyAndSecurity;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Passcode Lock']")
    private static WebElement itemPasscodeLock;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enable Passcode']")
    private static WebElement buttonEnablePasscode;

    @AndroidFindBy(xpath = "//android.widget.EditText[1]")
    private static WebElement firstSymbol;

    @AndroidFindBy(xpath = "//android.widget.EditText[2]")
    private static WebElement secondSymbol;

    @AndroidFindBy(xpath = "//android.widget.EditText[3]")
    private static WebElement thirdSymbol;

    @AndroidFindBy(xpath = "//android.widget.EditText[4]")
    private static WebElement fourthSymbol;

    public PrivacyPage(AndroidDriver driver) {
        this.driver = driver;
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
}
