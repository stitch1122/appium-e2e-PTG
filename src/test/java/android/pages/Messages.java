package android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Messages extends BasePage{
    public Messages (AppiumDriver driver) { this.driver=driver; }

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Message']")
    private static MobileElement messageField;

    public void enterMessageAndLongTap() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        MobileElement message = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='Message']")));
        message.setValue("hi");
        MobileElement send = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Send\"]")));
        Utils.longTap(driver,send);
    }
        String messageReaction = "reaction";
    public void enterMessageAndSend() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        MobileElement message = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='Message']")));
        message.setValue(messageReaction);
        MobileElement send = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Send\"]")));
        send.click();
    }

    public void findMessageAndTap() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        MobileElement message = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[starts-with(@text,'reaction')]")));
//        Point location = message.getLocation();
//        Dimension size = message.getSize();
//        int x = location.getX() + (size.getWidth() / 2); // Центр элемента по оси X
//        int y = location.getY() + (size.getHeight() / 2); // Центр элемента по оси Y
//        TouchAction action = new TouchAction(driver)
//                .tap(PointOption.point(x, y))
//                .perform();
        message.click();
        Thread.sleep(2000);
    }
    public void findMessageAndDelete() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        MobileElement message = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[starts-with(@text,'reaction')]")));
        Utils.longTap(driver,message);
        MobileElement deleteBtn = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@content-desc=\"Delete\"]")));
        deleteBtn.click();
        MobileElement deleteСonfirm = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text,'Delete']")));
        deleteСonfirm.click();
    }

    public void checkDeletingAfterReadingBtnDisappear() throws InterruptedException {
        List<MobileElement> elementDel = driver.findElements(By.xpath("//*[contains(@text,'Delete after reading')]"));
        Thread.sleep(2000);
        Assert.assertTrue(elementDel.isEmpty());
        System.out.println("Кнопка 'Удалить после прочтения' не отображается - ОК");
        driver.navigate().back();
    }

    public void checkDeletingAfterReadingBtnAppear() throws InterruptedException {
        boolean elementDel = driver.findElements(By.xpath("//*[contains(@text,'Delete after reading')]")).size() > 0;
        Thread.sleep(2000);
        Assert.assertTrue(elementDel);
        System.out.println("Кнопка 'Удалить после прочтения' отображается - ОК");
        driver.navigate().back();
    }
    public void checkReactionMenuDisappear() throws InterruptedException {
        List<MobileElement> elementDel = driver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView"));
        Thread.sleep(2000);
        Assert.assertTrue(elementDel.isEmpty());
        System.out.println("Кнопка 'Меню Реакций' не отображается - ОК");
        driver.navigate().back();
    }
    public void checkReactionMenuAppear() throws InterruptedException {
        boolean elementDel = driver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView")).size() > 0;
        Thread.sleep(2000);
        Assert.assertTrue(elementDel);
        System.out.println("Кнопка 'Меню Реакций' отображается - ОК");
        driver.navigate().back();
    }
}
//androidx.recyclerview.widget.RecyclerView
