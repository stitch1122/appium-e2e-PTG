package android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;


public class PartisanSettingsPage extends BasePage {

    public PartisanSettingsPage(AppiumDriver driver) { this.driver=driver; }

    @AndroidFindBy(xpath = "//android.widget.Switch[@content-desc=\"Show Version\"]")
    private static MobileElement switchShowVersion;

    @AndroidFindBy(xpath = "//android.widget.Switch[@content-desc=\"Show ID\"]")
    private static MobileElement switchShowID;

    @AndroidFindBy(xpath = "//android.widget.Switch[@content-desc=\"Avatar Disabling\"]")
    private static MobileElement switchAvatarDisabling;

    @AndroidFindBy(xpath = "//android.widget.Switch[@content-desc=\"Chat Renaming\"]")
    private static MobileElement switchChatRenaming;

    @AndroidFindBy(xpath = "//android.widget.Switch[@content-desc=\"Deleting My Messages\"]")
    private static MobileElement switchDeletingMyMessages;

    @AndroidFindBy(xpath = "//android.widget.Switch[@content-desc=\"Deleting After Read\"]")
    private static MobileElement switchDeletingAfterRead;

    @AndroidFindBy(xpath = "//android.widget.Switch[@content-desc=\"Saved Channels\"]")
    private static MobileElement switchSavedChannels;

    @AndroidFindBy(xpath = "//android.widget.Switch[@content-desc=\"React to Messages\"]")
    private static MobileElement switchReactToMessages;

    @AndroidFindBy(xpath = "//android.widget.Switch[@content-desc=\"Show Call Button\"]")
    private static MobileElement switchShowCallButton;

    @AndroidFindBy(xpath = "//android.widget.Switch[@content-desc=\"Google Play App Icons\"]")
    private static MobileElement switchGooglePlayIcons;

    @AndroidFindBy(xpath = "//android.widget.Switch[@content-desc=\"Delete messages for all by default\"]")
    private static MobileElement switchDeleteMessagesByDefault;

    @AndroidFindBy(xpath = "//android.widget.Switch[@content-desc=\"Delete all drafts on screen lock\"]")
    private static MobileElement switchDeleteDrafts;

    @AndroidFindBy(xpath = "//android.widget.Switch[@content-desc=\"Cut out text about foreign agents\"]")
    private static MobileElement switchCutOutTextAboutForeignAgents;

    @AndroidFindBy(xpath = "//android.widget.Switch[@content-desc=\"Additional Verified Badges\"]")
    private static MobileElement switchAdditionalVerifiedBadges;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Reset']")
    private static MobileElement resetAvatarBtn;

    public void deactivateShowVersion() throws InterruptedException {
        if (switchShowVersion.getAttribute("checked").equals("true")) {
            switchShowVersion.click();
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }
    public void activateShowVersion(){
        if (!switchShowVersion.getAttribute("checked").equals("true")) {
            switchShowVersion.click();
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }

    public void deactivateShowId() throws InterruptedException {
        if (switchShowID.getAttribute("checked").equals("true")) {
            switchShowID.click();
            System.out.println("Переключатель включен, отключаем");
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }

    public void activateShowId() throws InterruptedException{
        if (!switchShowID.getAttribute("checked").equals("true")) {
            switchShowID.click();
            System.out.println("Переключатель отключен, включаем");
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }

//    public void deactivateShowAvatar() throws InterruptedException {
//        if (switchAvatarDisabling.getAttribute("checked").equals("true")) {
//            switchAvatarDisabling.click();
//            System.out.println("Переключатель включен, отключаем");
//            resetAvatarBtn.click();
//           // Utils.tapItem(driver);
//        }
//        HeaderSection header = new HeaderSection(driver);
//        header.goBack();
//    }
    public void deactivateShowAvatar() {
        try {
            if (switchAvatarDisabling.getAttribute("checked").equals("true")) {
                switchAvatarDisabling.click();
                System.out.println("Переключатель включен, отключаем");
                WebDriverWait wait = new WebDriverWait(driver, 15);
                MobileElement resetAvatar = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Reset' and @index = '2']"))); //"//android.widget.TextView[@text='Reset']"
//                resetAvatar.click();
                int x = resetAvatar.getCenter().getX();
                int y = resetAvatar.getCenter().getY();
                Thread.sleep(2000);
                TouchAction action = new TouchAction(driver);
                action.tap(PointOption.point(x,y)).perform();
                Thread.sleep(2000);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Элемент 'Reset' не найден: " + e.getMessage());
        } catch (WebDriverException e) {
            System.out.println("Ошибка при сбросе аватара: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Восстанавливаем статус прерывания
            System.out.println("Поток был прерван: " + e.getMessage());
        } finally {
            HeaderSection header = new HeaderSection(driver);
            header.goBack();
        }
    }
    public void activateShowAvatar() throws InterruptedException{
        if (!switchAvatarDisabling.getAttribute("checked").equals("true")) {
            switchAvatarDisabling.click();
            System.out.println("Переключатель отключен, включаем");
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }

    public void deactivateChatRenaming() throws InterruptedException {
        try {
            if (switchChatRenaming.getAttribute("checked").equals("true")) {
                switchChatRenaming.click();
                System.out.println("Переключатель включен, отключаем");
                Thread.sleep(2000);

                WebDriverWait wait = new WebDriverWait(driver, 10);
                MobileElement reset = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Reset']")));
                //reset.click();
                MobileElement el = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Reset\")"));
                el.click();

            }

        } catch (NoSuchElementException e) {
            System.out.println("Элемент 'Reset' не найден: " + e.getMessage());
        } catch (WebDriverException e) {
            System.out.println("Ошибка при сбросе названия: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Восстанавливаем статус прерывания
            System.out.println("Поток был прерван: " + e.getMessage());
        } finally {
            HeaderSection header = new HeaderSection(driver);
            header.goBack();
        }
    }

    public void activateChatRenaming() throws InterruptedException{
        if (!switchChatRenaming.getAttribute("checked").equals("true")) {
            switchChatRenaming.click();
            System.out.println("Переключатель отключен, включаем");
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }

    public void deactivateDeletingMyMessages() throws InterruptedException {
        if (switchDeletingMyMessages.getAttribute("checked").equals("true")) {
            switchDeletingMyMessages.click();
            System.out.println("Переключатель включен, отключаем");
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }

    public void activateDeletingMyMessages() throws InterruptedException{
        if (!switchDeletingMyMessages.getAttribute("checked").equals("true")) {
            switchDeletingMyMessages.click();
            System.out.println("Переключатель отключен, включаем");
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }

    public void deactivateDeletingAfterRead() throws InterruptedException {
        if (switchDeletingAfterRead.getAttribute("checked").equals("true")) {
            switchDeletingAfterRead.click();
            System.out.println("Переключатель включен, отключаем");
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }

    public void activateDeletingAfterRead() throws InterruptedException{
        if (!switchDeletingAfterRead.getAttribute("checked").equals("true")) {
            switchDeletingAfterRead.click();
            System.out.println("Переключатель отключен, включаем");
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }

    public void deactivateSavedChannels() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean switchFound = false;

        while (!switchFound) {
            try {
                MobileElement switchElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Switch[@content-desc=\"React to Messages\"]")));
                switchFound = true;
                if (switchSavedChannels.getAttribute("checked").equals("true")) {
                    switchSavedChannels.click();
                    System.out.println("Переключатель включен, отключаем");
                }
            } catch (Exception e) {
                Utils.scroll(driver);
            }
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }

    public void activateSavedChannels() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean switchFound = false;

        while (!switchFound) {
            try {
                MobileElement switchElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Switch[@content-desc=\"React to Messages\"]")));
                switchFound = true;
                if (!switchSavedChannels.getAttribute("checked").equals("true")) {
                    switchSavedChannels.click();
                    System.out.println("Переключатель отключен, включаем");
                }
            } catch (Exception e) {
                Utils.scroll(driver);
            }
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }

    public void deactivateReactToMessages() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean switchFound = false;

        while (!switchFound) {
            try {
                MobileElement switchElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Switch[@content-desc=\"React to Messages\"]")));
                switchFound = true;
                if (switchReactToMessages.getAttribute("checked").equals("true")) {
                    switchReactToMessages.click();
                    System.out.println("Переключатель включен, отключаем");
                    }
            } catch (Exception e) {
                Utils.scroll(driver);
            }
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }
    public void activateReactToMessages() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean switchFound = false;

        while (!switchFound) {
            try {
                MobileElement switchElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Switch[@content-desc=\"React to Messages\"]")));
                switchFound = true;
                if (!switchReactToMessages.getAttribute("checked").equals("true")) {
                    switchReactToMessages.click();
                    System.out.println("Переключатель отключен, включаем");
                    }
            } catch (Exception e) {
                Utils.scroll(driver);
            }
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }

    public void deactivateShowCallBtn() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean switchFound = false;

        while (!switchFound) {
            try {
                MobileElement switchElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Switch[@content-desc=\"Show Call Button\"]")));
                switchFound = true;
                if (switchShowCallButton.getAttribute("checked").equals("true")) {
                    switchShowCallButton.click();
                    System.out.println("Переключатель включен, отключаем");
                }
            } catch (Exception e) {
                Utils.scroll(driver);
            }
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }
    public void activateShowCallBtn() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean switchFound = false;

        while (!switchFound) {
            try {
                MobileElement switchElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Switch[@content-desc=\"Show Call Button\"]")));
                switchFound = true;
                if (!switchShowCallButton.getAttribute("checked").equals("true")) {
                    switchShowCallButton.click();
                    System.out.println("Переключатель отключен, включаем");
                }
            } catch (Exception e) {
                Utils.scroll(driver);
            }
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }

    public void activateDeleteDrafts() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean switchFound = false;

        while (!switchFound) {
            try {
                MobileElement switchElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Switch[@content-desc=\"Delete all drafts on screen lock\"]")));
                switchFound = true;
                if (!switchDeleteDrafts.getAttribute("checked").equals("true")) {
                    switchDeleteDrafts.click();
                    System.out.println("Переключатель отключен, включаем");
                }
            } catch (Exception e) {
                Utils.scroll(driver);
            }
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }
    public void deactivateDeleteDrafts() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean switchFound = false;

        while (!switchFound) {
            try {
                MobileElement switchElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Switch[@content-desc=\"Delete all drafts on screen lock\"]")));
                switchFound = true;
                if (switchDeleteDrafts.getAttribute("checked").equals("true")) {
                    switchDeleteDrafts.click();
                    System.out.println("Переключатель включен, отключаем");
                }
            } catch (Exception e) {
                Utils.scroll(driver);
            }
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }

    public void activateDeleteMessagesByDefault() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean switchFound = false;

        while (!switchFound) {
            try {
                MobileElement switchElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Switch[@content-desc=\"Delete all drafts on screen lock\"]")));
                switchFound = true;
                if (!switchDeleteMessagesByDefault.getAttribute("checked").equals("true")) {
                    switchDeleteMessagesByDefault.click();
                    System.out.println("Переключатель отключен, включаем");
                }
            } catch (Exception e) {
                Utils.scroll(driver);
            }
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }
    public void deactivateDeleteMessagesByDefault() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean switchFound = false;

        while (!switchFound) {
            try {
                MobileElement switchElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Switch[@content-desc=\"Delete all drafts on screen lock\"]")));
                switchFound = true;
                if (switchDeleteMessagesByDefault.getAttribute("checked").equals("true")) {
                    switchDeleteMessagesByDefault.click();
                    System.out.println("Переключатель включен, отключаем");
                }
            } catch (Exception e) {
                Utils.scroll(driver);
            }
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }

    public void selectHideAndClearCacheActionOnScreenLock() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean elFound = false;

        while (!elFound) {
            try {
                MobileElement actionOnScreenLock = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text = 'Action On Screen Lock' and @index = '0']")));
                elFound = true;
                actionOnScreenLock.click();
                MobileElement hide = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.RadioButton[@index = '1']")));
                MobileElement ok = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text = 'OK']")));
                if (!hide.getAttribute("checked").equals("true")) {
                    hide.click();
                    System.out.println("Выбираем: Свернуть и очистить кэш");
                    ok.click();
                } else {
                    System.out.println("Выбрано: Свернуть и очистить кэш");
                    ok.click();
                }
            } catch (Exception e) {
                Utils.scroll(driver);
            }
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }

    public void selectCloseAndClearCacheActionOnScreenLock() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean elFound = false;

        while (!elFound) {
            try {
                MobileElement actionOnScreenLock = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text = 'Action On Screen Lock' and @index = '0']")));
                elFound = true;
                actionOnScreenLock.click();
                MobileElement hide = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.RadioButton[@index = '2']")));
                MobileElement ok = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text = 'OK']")));
                if (!hide.getAttribute("checked").equals("true")) {
                    hide.click();
                    System.out.println("Выбираем: Закрыть и очистить кэш");
                    ok.click();
                } else {
                    System.out.println("Выбрано: Закрыть и очистить кэш");
                    ok.click();
                }
            } catch (Exception e) {
                Utils.scroll(driver);
            }
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }

    public void selectDoNothingActionOnScreenLock() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean elFound = false;

        while (!elFound) {
            try {
                MobileElement actionOnScreenLock = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text = 'Action On Screen Lock' and @index = '0']")));
                elFound = true;
                actionOnScreenLock.click();
                MobileElement hide = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.RadioButton[@index = '0']")));
                MobileElement ok = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text = 'OK']")));
                if (!hide.getAttribute("checked").equals("true")) {
                    hide.click();
                    System.out.println("Выбираем: Ничего");
                    ok.click();
                } else {
                    System.out.println("Выбрано: Ничего");
                    ok.click();
                }
            } catch (Exception e) {
                Utils.scroll(driver);
            }
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }

    public void activateGooglePlayAppIcons() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean switchFound = false;

        while (!switchFound) {
            try {
                MobileElement switchElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Switch[@content-desc=\"Google Play App Icons\"]")));
                switchFound = true;
                if (!switchGooglePlayIcons.getAttribute("checked").equals("true")) {
                    switchGooglePlayIcons.click();
                    System.out.println("Переключатель отключен, включаем");
                }
            } catch (Exception e) {
                Utils.scroll(driver);
            }
        }
        Thread.sleep(2000);
//        HeaderSection header = new HeaderSection(driver);
//        header.goBack();
    }
    public void deactivateGooglePlayAppIcons() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean switchFound = false;

        while (!switchFound) {
            try {
                MobileElement switchElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Switch[@content-desc=\"Google Play App Icons\"]")));
                switchFound = true;
                if (switchGooglePlayIcons.getAttribute("checked").equals("true")) {
                    switchGooglePlayIcons.click();
                    System.out.println("Переключатель включен, отключаем");
                }
            } catch (Exception e) {
                Utils.scroll(driver);
            }
        }
        Thread.sleep(2000);
//        HeaderSection header = new HeaderSection(driver);
//        header.goBack();
    }


}