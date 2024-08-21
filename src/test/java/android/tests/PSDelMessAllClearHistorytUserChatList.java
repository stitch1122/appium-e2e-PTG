package android.tests;

import android.pages.*;
import configs.AppDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import org.testng.annotations.Test;

public class PSDelMessAllClearHistorytUserChatList extends BaseTest{
    String chatUrl = Constants.CHAT_USER_URL;
    String appPackage = Constants.APP_PACKAGE;
    String nameUser = Constants.NAME_USER;
    String nameFolder = "Xxx";

    @Test(groups = "partisan_settings", description = "Delete Messages For All By Default Btn is enabled")
    public void deleteMessagesByDefaultShouldBeChecked() throws Exception {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        Messages messages = new Messages(driver);
        ChatListPage chatListPage = new ChatListPage(driver);
        FolderPage folderPage = new FolderPage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.activateDeleteMessagesByDefault();
        start.enterPin("withPinCode");
        folderPage.openChatFolders();
        folderPage.createFolderForUser(nameUser,nameFolder);
        folderPage.findAndSelectFolderForUser(nameFolder);
        folderPage.selectFirstChatAndTapMoreMenu();
        folderPage.checkClearHistoryAllChecked();
        start.enterPin("withFakePinCode");
        folderPage.findAndSelectFolderForUser(nameFolder);
        folderPage.selectFirstChatAndTapMoreMenu();
        folderPage.checkClearHistoryAllUnchecked();
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        folderPage.deleteFolderForUser(nameFolder);
    }
    @Test(groups = "partisan_settings", description = "Delete Messages For All By Default Btn is disabled")
    public void deleteMessagesByDefaultShouldBeUnchecked() throws Exception {
        Activity activity = new Activity(appPackage, "org.telegram.ui.LaunchActivity");
        ((StartsActivity) AppDriver.getDriver()).startActivity(activity);

        StartPage start = new StartPage(driver);
        PrivacyAndSecurityPage privacy = new PrivacyAndSecurityPage(driver);
        PartisanSettingsPage partisanSettings = new PartisanSettingsPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        Messages messages = new Messages(driver);
        ChatListPage chatListPage = new ChatListPage(driver);
        FolderPage folderPage = new FolderPage(driver);

        start.putPinCode();
        privacy.openPartisanSettings();
        partisanSettings.deactivateDeleteMessagesByDefault();
        start.enterPin("withPinCode");
        folderPage.openChatFolders();
        folderPage.createFolderForUser(nameUser,nameFolder);
        folderPage.findAndSelectFolderForUser(nameFolder);
        folderPage.selectFirstChatAndTapMoreMenu();
        folderPage.checkClearHistoryAllUnchecked();
        start.enterPin("withFakePinCode");
        folderPage.findAndSelectFolderForUser(nameFolder);
        folderPage.selectFirstChatAndTapMoreMenu();
        folderPage.checkClearHistoryAllUnchecked();
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        folderPage.deleteFolderForUser(nameFolder);
    }

}
