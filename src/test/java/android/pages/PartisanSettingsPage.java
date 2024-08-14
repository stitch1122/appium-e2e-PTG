package android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
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

    public void deactivateShowAvatar() throws InterruptedException {
        if (switchAvatarDisabling.getAttribute("checked").equals("true")) {
            switchAvatarDisabling.click();
            System.out.println("Переключатель включен, отключаем");
            resetAvatarBtn.click();
           // Utils.tapItem(driver);
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
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
        if (switchChatRenaming.getAttribute("checked").equals("true")) {
            switchChatRenaming.click();
            System.out.println("Переключатель включен, отключаем");
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
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
        if (switchSavedChannels.getAttribute("checked").equals("true")) {
            switchSavedChannels.click();
            System.out.println("Переключатель включен, отключаем");
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }

    public void activateSavedChannels() throws InterruptedException{
        if (!switchSavedChannels.getAttribute("checked").equals("true")) {
            switchSavedChannels.click();
            System.out.println("Переключатель отключен, включаем");
        }
        HeaderSection header = new HeaderSection(driver);
        header.goBack();
    }

}