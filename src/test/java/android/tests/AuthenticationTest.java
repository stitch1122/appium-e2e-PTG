package android.tests;

import android.pages.HeaderSection;
import android.pages.StartPage;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;

public class AuthenticationTest extends BaseTest {
    @BeforeMethod
    public void clearAppCache() {
        String command = "adb shell pm clear org.telegram.messenger.web";
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Set authentication code")
    public void shouldSignInAccount() throws InterruptedException {
        StartPage startPage = new StartPage((AndroidDriver) driver);
        startPage.putPhoneNumber();

        Thread.sleep(8000);
        //put your code

        HeaderSection header = new HeaderSection((AndroidDriver) driver);
        Assert.assertTrue(header.isButtonOpenMenuDisplayed(), "Chat list doesn't display");
    }
}