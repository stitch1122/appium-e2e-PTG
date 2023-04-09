package android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HeaderSection extends BasePage{
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Open navigation menu\"]")
    private static MobileElement menuButtonEng;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Открыть меню навигации\"]")
    private static MobileElement menuButtonRus;

    public HeaderSection(AppiumDriver driver) { super(driver); }

    public boolean isButtonOpenMenuDisplayed() {
        return menuButtonEng.isDisplayed();
    }

    public void openMenu(){
        menuButtonEng.click();
    }
}
