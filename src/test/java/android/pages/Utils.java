package android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Utils {
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
    public static void getPageObject(AppiumDriver driver) {
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
    }

    public static void scrollUpOneItem(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int width = size.width;
        int height = size.height;
        int startXCoordinate = (int) (width /2);
        int startYCoordinate = (int) (height /2);
       // int endXCoordinate = (int) (height * .6);
        int endYCoordinate = (int) (height * .6);
        action.press(PointOption.point(startXCoordinate, startYCoordinate))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(startXCoordinate, endYCoordinate)).release().perform();
        Thread.sleep(100);
    }

    public static void tapItem(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        TouchAction action = new TouchAction(driver);
        action.tap(PointOption.point(1100,1650)).perform();
        Thread.sleep(100);
    }

    public static void longTap(AppiumDriver driver, WebElement element) throws InterruptedException {
        Thread.sleep(1000);
        AndroidTouchAction touch = new AndroidTouchAction (driver);
        touch.longPress(LongPressOptions.longPressOptions()
                .withElement (ElementOption.element (element)))
                .perform ();
    }
}
