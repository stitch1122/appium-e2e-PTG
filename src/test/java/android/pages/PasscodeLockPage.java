package android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.*;

public class PasscodeLockPage extends BasePage {
    public PasscodeLockPage(AppiumDriver driver) {
        this.driver=driver;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Partisan Settings']")
    private static MobileElement itemPartisanSettings;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Fake Passcode']")
    private static MobileElement itemAddFakePasscode;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Auto-lock']")
    private static MobileElement itemAutoLock;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='in 1 second']")
    private static MobileElement listIn1Second;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Done']")
    private static MobileElement autoLockDoneBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Show Content']")
    private static MobileElement showContentBtn;

    public void openPS (){ itemPartisanSettings.click();}

    public void setAutoLock() throws InterruptedException {
        itemAutoLock.click();
        Utils.getPageObject(driver);
        MobileElement recyclerView = (MobileElement) driver.findElement(By.className("android.recyclerview.widget.RecyclerView"));
        int itemCount = recyclerView.findElements(By.className(/*"android.widget.SeekBar"*/"android.widget.LinearLayout")).size();
        recyclerView.findElementByLinkText("in 1 second").click();
        listIn1Second.click();
        autoLockDoneBtn.click();
    }

    public void putFakePasscode() throws InterruptedException {
        itemAddFakePasscode.click();
        EnterPasscodeSection passcodeSection = new EnterPasscodeSection(driver);
        passcodeSection.putPasscode("2");
        passcodeSection.putPasscode("2");
    }

    public void setAutoLockOneSec() throws InterruptedException {
        itemAutoLock.click();
        boolean isElementVisible = false;
        Thread.sleep(1000);
        while (!isElementVisible) {
            try {
                // Попытка найти элемент с текстом "1 секунда"
                MobileElement element = (MobileElement) driver.findElement(By.xpath("//android.widget.SeekBar[@text='in 1 second']"));
                // Проверяем, виден ли элемент
                isElementVisible = element.isDisplayed();
                System.out.println("Элемент '1 секунда' найден. Устанавливаем значение");
                if (isElementVisible) {
                    // Если элемент найден, нажимаем на кнопку "ОК"
                    autoLockDoneBtn.click();
                }
            } catch (WebDriverException e) {
                // Если элемент не найден, прокручиваем страницу
                Utils.scrollUpOneItem(driver);
                System.out.println("Элемент '1 секунда' еще не найден. Продолжаем скроллить...");
            }
        }
    }

    public void showContentenable() {
        showContentBtn.click();
    }
    private boolean isSwitchEnabled(MobileElement switchElement) {
        // Проверяем состояние переключателя (checked/unchecked)
        return switchElement.getAttribute("checked").equals("true");
    }

    public void enableShowContent() {
        try {
            // Находим переключатель "Show Content"
            MobileElement showContentSwitch = (MobileElement) driver.findElement(By.xpath("//android.widget.Switch[@content-desc=\"Show Content\"]"));
            // Проверяем, включен ли переключатель
            if (isSwitchEnabled(showContentSwitch)) {
                System.out.println("Переключатель 'Show Content' уже включен.");
            } else {
                System.out.println("Переключатель 'Show Content' выключен. Включаем его.");
                showContentSwitch.click(); //кликаем по нему
            }
        } catch (WebDriverException e) {
            System.out.println("Ошибка при поиске переключателя 'Show Content': " + e.getMessage());
        }
    }
}
