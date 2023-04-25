package configs;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.HashMap;

public class Utils {
    public static void scrollIntoView(String Text) {
        //https://developer.android.com/reference/androidx/test/uiautomator/UiSelector
        String mySelector = "new UiSelector().text(\"" + Text + "\").instance(0)";
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + mySelector + ");";
        //((AndroidDriver) AppDriver.getDriver()).findElement(AppiumBy.androidUIAutomator(command));
        ((AndroidDriver<MobileElement>) AppDriver.getDriver()).findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + Text + "\").instance(0))").click();
    }
    public static void scrollTo(String Text){
        //https://appium.io/docs/en/writing-running-appium/ios/ios-xctest-mobile-gestures/
        if(AppDriver.getDriver() instanceof AndroidDriver){
            scrollIntoView(Text);
        }else
        if(AppDriver.getDriver() instanceof IOSDriver){
            final HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("predicateString", "value == '" + Text + "'");
            scrollObject.put("toVisible", "true");
            ((IOSDriver) AppDriver.getDriver()).executeScript("mobile: scroll", scrollObject);
        }
    }
    public static void scroll(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int width = size.width;
        int height = size.height;
        int middleOfX = width / 2;
        int startYCoordinate = (int) (height * .8);
        int endYCoordinate = (int) (height * .0);
        action.press(PointOption.point(middleOfX, startYCoordinate))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
        Thread.sleep(2000);
    }
}