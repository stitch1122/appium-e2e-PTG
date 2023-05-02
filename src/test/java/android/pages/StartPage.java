package android.pages;

import android.data.User;
import configs.AppDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class StartPage extends BasePage {

    public StartPage(AppiumDriver driver) { this.driver=driver; }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Start Messaging\"]")
    private static MobileElement buttonStartMessaging;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Continue\"]")
    private static MobileElement popupContinue;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private static MobileElement permissionAllow;

    @AndroidFindBy(id = "//android.widget.TextView[@text=\"OK\"]")
    private static MobileElement mfaOk;

    @AndroidFindBy(id = "//android.widget.TextView[@text=\"DECLINE\"]")
    private static MobileElement mfaDecline;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Phone number\"]")
    private MobileElement inputPhoneNumber;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Country code\"]")
    private MobileElement inputCountryCode;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Done\"]")
    private MobileElement buttonDone;

    @AndroidFindBy(id = "org.telegram.messenger.web:id/passcode_btn_1")
    private static MobileElement passcodeBtn;

    @AndroidFindBy(id = "org.telegram.messenger.web:id/passcode_btn_2")
    private static MobileElement fakePasscodeBtn;

    public void putPhoneNumber() throws InterruptedException {
        putPhoneNumber(new User());
    }

    public void putPinCode(){
        //String pageSource = driver.getPageSource();
        //System.out.println(pageSource);
        passcodeBtn.click();
        passcodeBtn.click();
        passcodeBtn.click();
        passcodeBtn.click();
    }

    public void putFakePinCode(){
        fakePasscodeBtn.click();
        fakePasscodeBtn.click();
        fakePasscodeBtn.click();
        fakePasscodeBtn.click();
    }

    public void putPhoneNumber(User user) throws InterruptedException {
        Thread.sleep(4000);
        buttonStartMessaging.click();
        acceptPermission();
        inputCountryCode.clear();
        inputCountryCode.sendKeys(user.getCode());
        inputPhoneNumber.clear();
        inputPhoneNumber.sendKeys(user.getPhone());
        buttonDone.click();
        Thread.sleep(4000);
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
