package android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HeaderSection extends BasePage{
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Open navigation menu\"]")
    private static MobileElement menuButtonEng;
    //android.widget.ImageView[@content-desc="Open navigation menu"]
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Открыть меню навигации\"]")
    private static MobileElement menuButtonRus;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Go back\"]")
    private static MobileElement goBackEng;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Перайсці назад\"]")
    private static MobileElement goBackBlr;

    public HeaderSection(AppiumDriver driver) { this.driver=driver; }

    public boolean isButtonOpenMenuDisplayed() {
        return menuButtonEng.isDisplayed();
    }

    public void openMenu(){
        menuButtonEng.click();
    }

    public void goBack() {goBackEng.click();}

    public void goBackBlr() {goBackBlr.click();}
}
