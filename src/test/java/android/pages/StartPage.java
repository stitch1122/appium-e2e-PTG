package android.pages;

import android.data.User;
import configs.AppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StartPage extends BasePage {

    public StartPage(AndroidDriver driver) { this.driver = driver; }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Start Messaging\"]")
    private static WebElement buttonStartMessaging;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Continue\"]")
    private static WebElement popupContinue;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private static WebElement permissionAllow;

    @AndroidFindBy(id = "//android.widget.TextView[@text=\"OK\"]")
    private static WebElement mfaOk;

    @AndroidFindBy(id = "//android.widget.TextView[@text=\"DECLINE\"]")
    private static WebElement mfaDecline;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Phone number\"]")
    private WebElement inputPhoneNumber;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Country code\"]")
    private WebElement inputCountryCode;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Done\"]")
    private WebElement buttonDone;

    public void putPhoneNumber() throws InterruptedException {
        putPhoneNumber(new User());
    }

    public void putPhoneNumber(User user) throws InterruptedException {
        buttonStartMessaging.click();
        acceptPermission();
        inputCountryCode.clear();
        inputCountryCode.sendKeys(user.getCode());
        inputPhoneNumber.clear();
        inputPhoneNumber.sendKeys(user.getPhone());
        buttonDone.click();
        acceptPermission();
    }
    public void acceptPermission(){
        try {
            popupContinue.click();
        }
        catch (Exception e){
            System.out.println("Popup with \"Continue\" was not displayed");
        }
        try {
            permissionAllow.click();
        }
        catch (Exception e){
            System.out.println("Asking for ALLOW/DECLINE was not displayed");
        }
    }
    public void decline2StepVerification() throws InterruptedException {
        Thread.sleep(8000);
        try {
            mfaOk.click();
            mfaDecline.click();
        }
        catch (Exception e){
            System.out.println("Popup with 2fa doesn't appear");
        }
    }
    public void declineVersionUpdating() {
        try {
            AppDriver.getDriver().findElement(By.xpath("//android.widget.TextView[@text=\"NOT  NOW\"]")).click();
            AppDriver.getDriver().findElement(By.xpath("//android.widget.TextView[@text=\"DO NOT SHOW AGAIN\"]")).click();
        }
        catch (Exception e){
            System.out.println("Skip popup with updating version");
        }
    }
}
