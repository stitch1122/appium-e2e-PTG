package android.tests;

import android.pages.HeaderSection;
import android.pages.StartPage;
import org.aspectj.lang.annotation.Before;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;

public class AuthenticationTest extends BaseTest {
    /*@BeforeMethod
    public void clearAppCache() {
        String command = "adb shell pm clear org.telegram.messenger.web";
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //driver.resetApp();
    }*/

    @Test(groups = "smoke", description = "Set authentication code")
    public void shouldSignInAccount() throws InterruptedException {
        StartPage startPage = new StartPage(driver);
        startPage.putPhoneNumber();

        HeaderSection header = new HeaderSection(driver);
        Assert.assertTrue(header.isButtonOpenMenuDisplayed(), "Chat list doesn't display");
    }
}