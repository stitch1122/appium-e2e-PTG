package android.pages;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CallsPage extends BasePage {
    public CallsPage(AppiumDriver driver) { this.driver=driver; }

    public void checkDeleteCallsAllChecked() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        MobileElement call = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@index = '0']")));
        Utils.longTap(driver,call);
        MobileElement delete = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc=\"Delete\"]")));
        delete.click();
        MobileElement checkableElement = null;
        try {
            checkableElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@checkable, 'true')]")));
        } catch (TimeoutException e) {
            System.out.println("Checkable element not found");
        }
        if (checkableElement != null) {
            if (checkableElement.getAttribute("checked").equals("true")) {
                System.out.println("Чек-бокс выделен - ОК");
            }
        }
        Thread.sleep(1000);
    }
    public void checkDeleteCallsAllUnchecked() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        MobileElement call = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@index = '0']")));
        Utils.longTap(driver,call);
        MobileElement delete = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc=\"Delete\"]")));
        delete.click();
        MobileElement checkableElement = null;
        try {
            checkableElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@checkable, 'true')]")));
        } catch (TimeoutException e) {
            System.out.println("Checkable element not found");
        }
        if (checkableElement != null) {
            if (!checkableElement.getAttribute("checked").equals("true")) {
                System.out.println("Чек-бокс не выделен - ОК");
            }
        }
        Thread.sleep(1000);
    }

}
