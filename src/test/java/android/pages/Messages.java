package android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;

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
}
