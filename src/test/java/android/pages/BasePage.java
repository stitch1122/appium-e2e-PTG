package android.pages;

import configs.AppDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }

    /*protected void click(MobileElement element) {
        element.click();
    }

    protected void sendKeys(MobileElement element, String text) {
        element.sendKeys(text);
    }*/
}
