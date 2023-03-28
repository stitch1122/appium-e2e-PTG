package android.pages;

import configs.AppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected AndroidDriver driver;
    //protected WebDriverWait wait;

    public BasePage() {
        //wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }

    /*public void sendKeys(By locator, String value) {
        WebElement element = (WebElement) wait.until((Function<WebDriver, Object>) d -> d.findElement(locator));
        run(() -> element.sendKeys(value));
    }

    public void click(By locator) {
        WebElement element = (WebElement) wait.until((Function<WebDriver, Object>) d -> d.findElement(locator));
        run(element::click);
    }

    private void run(Runnable block) {
        long startTime = System.currentTimeMillis();
        while (true) {
            try {
                block.run();
                break;
            } catch (NoSuchElementException | ElementNotInteractableException e) {
                long currentTime = System.currentTimeMillis();
                Duration duration = Duration.ofMillis(currentTime - startTime);

                if (duration.compareTo(Duration.ofSeconds(20)) > 0) {
                    throw new ElementValidationException("Unable to send keys after " + duration + " seconds", e);
                } else {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        }
    }*/
}
