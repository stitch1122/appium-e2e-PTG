package android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;


public class Messages extends BasePage{
    public Messages (AppiumDriver driver) { this.driver=driver; }

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Message']")
    private static MobileElement messageField;

    public void enterMessageAndLongTap(String messsage) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        MobileElement messageSend = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='Message']")));
        messageSend.setValue(messsage);
        MobileElement send = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Send\"]")));
        Utils.longTap(driver,send);
    }

    public void enterMessageAndSend(String message) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        MobileElement messageEnter = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='Message']")));
        messageEnter.setValue(message);
        MobileElement send = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Send\"]")));
        send.click();
    }

    public void enterMessage(String message) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        MobileElement messageEnter = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='Message']")));
        messageEnter.setValue(message);
        driver.navigate().back();
    }


    public void findMessageAndTap(String message) throws InterruptedException {
<<<<<<< HEAD
        WebDriverWait wait = new WebDriverWait(driver, 15);
=======
        WebDriverWait wait = new WebDriverWait(driver, 10);
>>>>>>> origin/main
        MobileElement messageFind = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[starts-with(@text,'" + message + "')]")));
        messageFind.click();
        Thread.sleep(2000);
    }
    public void findMessageAndDelete(String message) throws InterruptedException {
<<<<<<< HEAD
        WebDriverWait wait = new WebDriverWait(driver, 15);
=======
        WebDriverWait wait = new WebDriverWait(driver, 10);
>>>>>>> origin/main
        MobileElement messageSend = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[starts-with(@text,'" + message + "')]")));
        Utils.longTap(driver,messageSend);
        MobileElement deleteBtn = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@content-desc=\"Delete\"]")));
        deleteBtn.click();
        MobileElement checkableElement = null;
        try {
            checkableElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@checkable, 'true')]")));
        } catch (TimeoutException e) {
            System.out.println("Checkable element not found, continuing...");
        }
        if (checkableElement != null) {
            if (!checkableElement.getAttribute("checked").equals("true")) {
                checkableElement.click();
            }
        }
        // код для нажатия на кнопку "Удалить" в диалоговом окне. Если какая-то строчка будет удалена, то нажатия на кнопку не произойдет
        MobileElement deleteСonfirm = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text,'Delete']")));
//        deleteСonfirm.click();
        MobileElement el = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Delete\")"));
        el.click();
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

    public void checkCallBtnDisappear() throws InterruptedException {
<<<<<<< HEAD
        List<MobileElement> element = driver.findElements(By.xpath("//android.widget.ImageButton[@content-desc=\"Call\"]"));
        Thread.sleep(2000);
        Assert.assertTrue(element.isEmpty());
=======
        List<MobileElement> elementDel = driver.findElements(By.xpath("//android.widget.ImageButton[@content-desc=\"Call\"]"));
        Thread.sleep(2000);
        Assert.assertTrue(elementDel.isEmpty());
>>>>>>> origin/main
        System.out.println("Кнопка 'Звонок' не отображается - ОК");
        driver.navigate().back();
    }
    public void checkCallBtnAppear() throws InterruptedException {
<<<<<<< HEAD
        boolean element = driver.findElements(By.xpath("//android.widget.ImageButton[@content-desc=\"Call\"]")).size() > 0;
        Thread.sleep(2000);
        Assert.assertTrue(element);
=======
        boolean elementDel = driver.findElements(By.xpath("//android.widget.ImageButton[@content-desc=\"Call\"]")).size() > 0;
        Thread.sleep(2000);
        Assert.assertTrue(elementDel);
>>>>>>> origin/main
        System.out.println("Кнопка 'Звонок' отображается - ОК");
        driver.navigate().back();
    }

    public void checkDraftDisappear(String message) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        MobileElement messageEnter = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='Message']")));
        String inputText = messageEnter.getText();
        System.out.println(inputText);
            if (inputText.equals(inputText)) {
                System.out.println("Черновика нет - Ок ");
            }
        driver.navigate().back();
    }
    public void checkDraftAppear(String message) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        MobileElement messageEnter = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='" + message + "']")));
        String inputText = messageEnter.getText();
        System.out.println(inputText);
        if (inputText.equals(inputText)) {
            System.out.println("Черновик есть - Ок ");
        }
        MobileElement send = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Send\"]")));
        send.click();
        driver.navigate().back();
    }


}

