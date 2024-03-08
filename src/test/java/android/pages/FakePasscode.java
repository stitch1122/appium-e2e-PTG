package android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FakePasscode extends BasePage  {
    public FakePasscode(AppiumDriver driver) {
        this.driver=driver;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Fake Passcode']")
    private static MobileElement textFakePasscode1;

    public boolean isFakePasscode1Displayed() {
        return textFakePasscode1.isDisplayed();
    }
}
