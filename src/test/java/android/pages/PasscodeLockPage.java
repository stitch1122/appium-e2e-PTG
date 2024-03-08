package android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class PasscodeLockPage extends BasePage {
    public PasscodeLockPage(AppiumDriver driver) {
        this.driver=driver;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Partisan Settings']")
    private static MobileElement itemPartisanSettings;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Fake Passcode']")
    private static MobileElement itemAddFakePasscode;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Auto-lock']")
    private static MobileElement itemAutoLock;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='in 1 second']")
    private static MobileElement listIn1Second;

    public void openPS (){ itemPartisanSettings.click();}

    public void setAutoLock() {
        itemAutoLock.click();
        Utils.getPageObject(driver);
        MobileElement recyclerView = (MobileElement) driver.findElement(By.className("androidx.recyclerview.widget.RecyclerView"));
        int itemCount = recyclerView.findElements(By.className("android.widget.LinearLayout")).size();
        recyclerView.findElementByLinkText("in 1 second").click();
        listIn1Second.click();
    }

    public void putFakePasscode() throws InterruptedException {
        itemAddFakePasscode.click();
        EnterPasscodeSection passcodeSection = new EnterPasscodeSection(driver);
        passcodeSection.putPasscode("2");
        passcodeSection.putPasscode("2");
    }
}