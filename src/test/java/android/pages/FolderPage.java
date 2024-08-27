package android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;
public class FolderPage extends BasePage{
    public FolderPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void openChatFolders() throws InterruptedException {
        MenuSection menuSection = new MenuSection(driver);
        menuSection.openSettings();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        while (true) {
            try {
                MobileElement chatFolders = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text = 'Chat Folders']"));
                chatFolders.click();
                break;
            } catch (NoSuchElementException e) {
                // Прокрутка вниз
                driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).flingForward()"));
            }
        }
    }
    public void createFolderForUser(String nameUser, String nameFolder) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        MobileElement folderNew = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Create New Folder']")));
        folderNew.click();
        MobileElement folderName = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@text = 'Folder name']")));
        folderName.setValue(nameFolder);
        MobileElement addChats = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text = 'Add Chats']")));
        addChats.click();
        MobileElement searchChats = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@text = 'Search for users and groups...']")));
        searchChats.setValue(nameUser);
        MobileElement chat = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='" + nameUser + "']")));
        chat.click();
        MobileElement next = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Next\"]")));
        next.click();
        MobileElement save = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"SAVE\"]/android.widget.TextView")));
        save.click();
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        Thread.sleep(5000);
    }

    public void deleteFolderForUser(String nameFolder) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        MobileElement folder = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc='" + nameFolder + "']")));
        Utils.longTap(driver,folder);
        MobileElement deleteBtn = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text = 'Delete folder']")));
        deleteBtn.click();
        MobileElement deleteConf = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text = 'Delete']")));

        int x = deleteConf.getCenter().getX();
        int y = deleteConf.getCenter().getY();
        Thread.sleep(2000);
        TouchAction action = new TouchAction(driver);
        action.tap(PointOption.point(x,y)).perform();
    }
    public void findAndSelectFolderForUser(String nameFolder) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        MobileElement folder = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc='" + nameFolder + "']")));
        folder.click();
    }

    public void selectFirstChatAndTapDel() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        MobileElement chat = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@index = '0']")));
        Utils.longTap(driver,chat);
        MobileElement el = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//androidx.recyclerview.widget.RecyclerView[@index = '0']")));
        int x = el.getCenter().getX();
        int x1 = x/3 * 2 + x;
        MobileElement el2 = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Go back\"]")));
        int y = el2.getCenter().getY();

        TouchAction action = new TouchAction(driver);
        action.tap(PointOption.point(x1,y)).perform(); //x=1240, y =289
        Thread.sleep(2000);

    }
    public void checkDeletingChatAllChecked() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
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

    public void selectFirstChatAndTapMoreMenu() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        MobileElement chat = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@index = '0']")));
        Utils.longTap(driver,chat);
        MobileElement el = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//androidx.recyclerview.widget.RecyclerView[@index = '0']")));
        int x = el.getCenter().getX();
        int x1 = x/4 * 3 + x;
        MobileElement el2 = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Go back\"]")));
        int y = el2.getCenter().getY();

        TouchAction action = new TouchAction(driver);
        action.tap(PointOption.point(x1,y)).perform(); //x=1240, y =289
        Thread.sleep(2000);
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
