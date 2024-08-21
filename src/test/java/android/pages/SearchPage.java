package android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchPage extends BasePage {

    public SearchPage (AppiumDriver driver) { this.driver=driver; }

//    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Search\"]/android.widget.ImageView")
//    private static MobileElement searchBtn;

    public void findAndOpenInfoChat(String chatUrl) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        MobileElement searchBtn = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@content-desc=\"Search\"]/android.widget.ImageView")));
        searchBtn.click();
        MobileElement search = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='Search']")));
        search.setValue(chatUrl);
        MobileElement chat = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@index='1']")));
        chat.click();
        MobileElement chatInfo = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@index='1']")));
        chatInfo.click();
    }

    public void findAndOpenChat(String chatUrl) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        MobileElement searchBtn = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@content-desc=\"Search\"]/android.widget.ImageView")));
        searchBtn.click();
        MobileElement search = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='Search']")));
        search.setValue(chatUrl);
        MobileElement chat = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@index='1']")));
        chat.click();
    }
    public void openMoreMenuChat() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        MobileElement moreMenu = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@content-desc=\"More options\"]")));
        moreMenu.click();
    }
    public void callAndEndCallUser() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        MobileElement callBtn = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@content-desc=\"Call\"]")));
        callBtn.click();
        MobileElement callEndBtn = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='End Call']")));
        callEndBtn.click();
        MobileElement goBack = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"Go back\"]")));
        goBack.click();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
    }



    public void checkIdDisappearChannel() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@text,'Chat ID')]")));
        List<MobileElement> elementsID = driver.findElements(By.xpath("//*[contains(@text,'Chat ID')]"));
        Assert.assertTrue(elementsID.isEmpty(), "Chat ID все еще отображается");
        System.out.println("Id не отображается - ОК");
    }

    public void checkIdAppearChannel() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean elementsID = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@text,'Chat ID')]"))) != null;
//        boolean elementsID = driver.findElements(By.xpath("//*[contains(@text,'Chat ID')]")).size() > 0;
        Assert.assertTrue(elementsID, "Id не отображается");
        System.out.println("Id отображается - ОК");
    }

//    public void checkAvatarBtnDisappear() throws InterruptedException {
//        Thread.sleep(2000);
//        List<MobileElement> elementsAvatar = driver.findElements(By.xpath("//*[@text='Disable Avatar' or @ text='Enable Avatar']"));
//        Assert.assertTrue(elementsAvatar.isEmpty());
//        System.out.println("Кнопка 'Отключить аватар' не отображается - OK");
//    }
//    public void checkAvatarBtnAppear() throws InterruptedException {
//        Thread.sleep(2000);
//        boolean elementsAvatar = driver.findElements(By.xpath("//*[@text='Disable Avatar' or @ text='Enable Avatar']")).size() > 0;
//        Assert.assertTrue(elementsAvatar);
//        System.out.println("Кнопка 'Отключить аватар' отображается - OK");
//    }
    public void checkAvatarBtnDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Disable Avatar' or @ text='Enable Avatar']")));
            System.out.println("Кнопка Отключить аватар не отображается - OK");
        } catch (TimeoutException e) {
            Assert.fail("Кнопка 'Отключить аватар' все еще отображается - error");
        }
    }
    public void checkAvatarBtnAppear() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Disable Avatar' or @ text='Enable Avatar']")));
            System.out.println("Кнопка 'Отключить аватар' отображается - OK");
        } catch (TimeoutException e) {
            Assert.fail("Кнопка 'Отключить аватар' не отображается - error"); //*[contains(@text,'Disable Avatar' OR @ text, 'Enable Avatar')]
        }
    }

    public void checkChatRenamingBtnDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Edit Chat Name']")));
            System.out.println("Кнопка 'Изменить название чата' не отображается - OK");
        } catch (TimeoutException e) {
            Assert.fail("Кнопка 'Изменить название чата' все еще отображается - error");
        }
    }

    public void checkChatRenamingBtnAppear() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Edit Chat Name']")));
            System.out.println("Кнопка 'Изменить название чата' отображается - OK");
        } catch (TimeoutException e) {
            Assert.fail("Кнопка 'Изменить название чата' не отображается - error");
        }
    }

    public void checkDeletingMyMessagesBtnDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Delete My Messages']")));
            System.out.println("Кнопка 'Удалить мои сообщения' не отображается - OK");
        } catch (TimeoutException e) {
            Assert.fail("Кнопка 'Удалить мои сообщения' все еще отображается - error");
        }
    }
    public void checkDeletingMyMessagesBtnAppear() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Delete My Messages']")));
            System.out.println("Кнопка 'Удалить мои сообщения' отображается - OK");
        } catch (TimeoutException e) {
            Assert.fail("Кнопка 'Удалить мои сообщения' не отображается - error");
        }
    }

    public void checkSaveBtnDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Save']")));
            System.out.println("Кнопка 'Сохранить' не отображается - OK");
        } catch (TimeoutException e) {
            Assert.fail("Кнопка 'Сохранить' все еще отображается - error");
        }
    }
    public void checkSaveBtnAppear() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Save']")));
            System.out.println("Кнопка 'Сохранить' отображается - OK");
        } catch (TimeoutException e) {
            Assert.fail("Кнопка 'Сохранить' не отображается - error");
        }
    }
    public void checkDeletingChatAllChecked() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        MobileElement delete = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text = 'Delete chat']")));
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
    public void checkDeletingChatAllUnchecked() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        MobileElement delete = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text = 'Delete chat']")));
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

    public void checkClearHistoryAllChecked() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        MobileElement clearHistory = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text = 'Clear History']")));
        clearHistory.click();
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
    public void checkClearHistoryAllUnchecked() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        MobileElement clearHistory = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text = 'Clear History']")));
        clearHistory.click();
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
