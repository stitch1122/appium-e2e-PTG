package android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EnterPasscodeSection extends BasePage  {

    public EnterPasscodeSection(AppiumDriver driver) { this.driver=driver; }

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

    public void enablePasscode () {buttonEnablePasscode.click();}
    public void putPasscode(String number) {
        firstSymbol.sendKeys(number);
        secondSymbol.sendKeys(number);
        thirdSymbol.sendKeys(number);
        fourthSymbol.sendKeys(number);
    }
}
