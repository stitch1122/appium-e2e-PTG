package android.pages;

import android.data.User;
import configs.AppDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
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

    @AndroidFindBy(id = "//android.widget.TextView[@text=\"Decline\"]")
    private static MobileElement settingsDecline;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Phone number\"]")
    private MobileElement inputPhoneNumber;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Country code\"]")
    private MobileElement inputCountryCode;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Done\"]")
    private MobileElement buttonDone;

    @AndroidFindBy(id = Constants.APP_PACKAGE + ":id/passcode_btn_1")
    private static MobileElement passcodeBtn;

    @AndroidFindBy(id = Constants.APP_PACKAGE + ":id/passcode_btn_2")
    private static MobileElement fakePasscodeBtn;

    public void putPhoneNumber() throws InterruptedException {
        putPhoneNumber(new User());
    }

    public void open(String pinCode) throws InterruptedException {
        Activity activity = new Activity(Constants.APP_PACKAGE, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) driver).startActivity(activity);
        StartPage start = new StartPage(driver);
        if(pinCode == "1111" || pinCode == "withPinCode") {
            start.putPinCode();
        }
        else if(pinCode == "2222" || pinCode == "withFakePinCode"){
            start.putFakePinCode();
        }
        MenuSection menu = new MenuSection(driver);
        menu.openSettings();
    }

    public void enterPin(String pinCode) throws InterruptedException {
        Activity activity = new Activity(Constants.APP_PACKAGE, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) driver).startActivity(activity);
        StartPage start = new StartPage(driver);
        if(pinCode == "1111" || pinCode == "withPinCode") {
            start.putPinCode();
        }
        else if(pinCode == "2222" || pinCode == "withFakePinCode"){
            start.putFakePinCode();
        }
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
        Thread.sleep(4000);
        acceptPermission();
        Thread.sleep(4000);
        acceptPermission();
        inputCountryCode.clear();
        inputCountryCode.sendKeys(user.getCode());
        inputPhoneNumber.clear();
        inputPhoneNumber.sendKeys(user.getPhone());
        buttonDone.click();
        Thread.sleep(4000);
        acceptPermission();
        Thread.sleep(15000);
        //put your code manually
        declineStrictPrivacySettings(); //It doesn't work and I don't  know why
        decline2StepVerification();
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
        Thread.sleep(2000);
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
    public void declineStrictPrivacySettings() throws InterruptedException {
        try {
            settingsDecline.click();
        }
        catch (Exception e){
                System.out.println("Popup with privacy settings doesn't appear");
        }
    }
}
