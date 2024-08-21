package android.pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class ChatListPage extends BasePage {
    public ChatListPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void blockAndUnlockScreen() throws Exception {
        // Блокировка экрана
        Runtime.getRuntime().exec("adb shell input keyevent 26");
        Thread.sleep(2000);
        System.out.println("Экран заблокирован");

        // Разблокировка экрана
        Runtime.getRuntime().exec("adb shell input keyevent 82");
        Thread.sleep(2000);
        System.out.println("Экран разблокирован");
    }
    public void findChatByName(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
//        MobileElement chat = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[starts-with(@text,'Wadf')]")));
//        MobileElement el = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Wadf\")"));
        while (true) {
            try {
                MobileElement chatK = (MobileElement) driver.findElement(By.xpath("*[contains(@text, 'wadf')]"));
                chatK.click();
                System.out.println("Чат 'Wadf' найден и открыт.");
                break;
            } catch (NoSuchElementException e) {
                // Прокрутка вниз
                driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).flingForward()"));
            }
        }
//        Utils.longTap(driver,chat);
//        MobileElement deleteBtn = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@content-desc=\"Delete\"]/android.widget.ImageView")));
//        deleteBtn.click();
        }

    public void checkDeleteChatCheckBoxChecked() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        MobileElement checkBox = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Also delete for']")));
            if (checkBox.isSelected()) {
                System.out.println("Чек-бокс выделен - OK");
            }
    }

}