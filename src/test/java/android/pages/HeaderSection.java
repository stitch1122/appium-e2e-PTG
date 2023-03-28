package android.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HeaderSection extends BasePage{
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Open navigation menu\"]")
    private static WebElement menuButtonEng;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Открыть меню навигации\"]")
    private static WebElement menuButtonRus;

    public HeaderSection(AndroidDriver driver) { this.driver = driver; }

    public boolean isButtonOpenMenuDisplayed() {
        return menuButtonEng.isDisplayed();
    }

    public void openMenu(){
        menuButtonEng.click();
    }
}
