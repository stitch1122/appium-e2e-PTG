package android.pages;

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
import java.io.*;
import java.util.List;


public class ChatListPage extends BasePage {
    public ChatListPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void checkAppRunning() {
        try {
            // Выполнение команды adb для получения списка активных задач
            Process process = Runtime.getRuntime().exec("adb shell dumpsys activity activities");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            boolean isTelegramRunning = false;

            // Чтение вывода команды
            while ((line = reader.readLine()) != null) {
                if (line.contains(Constants.APP_PACKAGE)) { // Пакет Telegram
                    isTelegramRunning = true;
                    break;
                }
            }
            // Закрытие ресурсов
            reader.close();
            process.waitFor();
            process.destroy();
            // Вывод результата
            if (isTelegramRunning) {
                System.out.println("Telegram работает");
                Assert.assertTrue(isTelegramRunning, "Telegram должен работать");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkAppNotRunning() {
        try {
            // Выполнение команды adb для получения списка активных задач
            Process process = Runtime.getRuntime().exec("adb shell dumpsys activity activities");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            boolean isTelegramRunning = false;

            // Чтение вывода команды
            while ((line = reader.readLine()) != null) {
                if (line.contains(Constants.APP_PACKAGE)) { // Пакет Telegram
                    isTelegramRunning = true;
                    break;
                }
            }
            // Закрытие ресурсов
            reader.close();
            process.waitFor();
            process.destroy();
            // Вывод результата
            if (!isTelegramRunning) {
                System.out.println("Telegram не работает");
                Assert.assertFalse(isTelegramRunning, "Telegram не должен работать");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkAppOnScreenDisplayed() throws InterruptedException {
        boolean elDisplayed = false;
        try {
            MobileElement btn = (MobileElement) driver.findElement(By.id(Constants.APP_PACKAGE + ":id/passcode_btn_1"));
            elDisplayed = true;
            System.out.println("Приложение активно и отображается на экране.");
        } catch (NoSuchElementException e) {
            System.out.println("Кнопка не найдена, проверяем другой элемент.");
        }
        if (!elDisplayed) {
            try {
                MobileElement search = (MobileElement) driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Search\"]"));
                elDisplayed = true;
                System.out.println("Приложение активно и отображается на экране.");
            } catch (NoSuchElementException e) {
                System.out.println("Элемент поиска не найден.");
            }
        }
        Assert.assertTrue(elDisplayed, "Приложение должно отображаться на экране");
    }
    public void checkAppOnScreenNotDisplayed() throws InterruptedException {
        boolean elDisplayed = false;
        try {
            MobileElement btn = (MobileElement) driver.findElement(By.id(Constants.APP_PACKAGE + ":id/passcode_btn_1"));
            elDisplayed = true;
            System.out.println("Приложение отображается на экране - Ошибка");
        } catch (NoSuchElementException e) { }
        if (!elDisplayed) {
            try {
                MobileElement search = (MobileElement) driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Search\"]"));
                elDisplayed = true;
            } catch (NoSuchElementException e) { }
        }
        if (!elDisplayed) {
            System.out.println("Приложение активно и не отображается на экране.");
            Assert.assertFalse(elDisplayed, "Приложение не должно отображаться на экране");
        }
    }
//    public void findChatByName(){
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        MobileElement chat = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[starts-with(@text,'W')]")));
//        MobileElement el = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"W\")"));
//        while (true) {
//            try {
//                MobileElement chatK = (MobileElement) driver.findElement(By.xpath("*[contains(@text, 'W')]"));
//                chatK.click();
//                System.out.println("Чат 'W' найден и открыт.");
//
//    public void findChatByName(){
//        WebDriverWait wait = new WebDriverWait(driver, 10);
////        MobileElement chat = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[starts-with(@text,'Wadf')]")));
////        MobileElement el = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Wadf\")"));
//        while (true) {
//            try {
//                MobileElement chatK = (MobileElement) driver.findElement(By.xpath("*[contains(@text, 'wadf')]"));
//                chatK.click();
//                System.out.println("Чат 'Wadf' найден и открыт.");
//
//                break;
//            } catch (NoSuchElementException e) {
//                // Прокрутка вниз
//                driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).flingForward()"));
//            }
//        }
////        Utils.longTap(driver,chat);
////        MobileElement deleteBtn = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@content-desc=\"Delete\"]/android.widget.ImageView")));
////        deleteBtn.click();
//        }
//
//    public void checkDeleteChatCheckBoxChecked() {
//        WebDriverWait wait = new WebDriverWait(driver, 15);
//        MobileElement checkBox = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Also delete for']")));
//            if (checkBox.isSelected()) {
//                System.out.println("Чек-бокс выделен - OK");
//            }
//    }

}