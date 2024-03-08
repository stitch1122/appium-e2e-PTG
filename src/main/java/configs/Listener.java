package configs;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.net.MalformedURLException;

public class Listener implements ITestListener {

    private AppProperties appProperties = new AppProperties();

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {}

    @Override
    public void onTestFailure(ITestResult result) {}

    @Override
    public void onTestSkipped(ITestResult result) {}

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        String failedTest = result.getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        AppiumServer.startServer();
        if ("Android".equalsIgnoreCase(appProperties.getProperty("platform"))){
            try {
                System.out.println("Create driver from Listeners onStart");
                AppDriver.createAndroidDriver();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if ("iOS".equalsIgnoreCase(appProperties.getProperty("platform"))){
            AppDriver.createIOSDriver();
        } else {
            System.out.println("Make sure your \"platform\" property filled correctly");
        }
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        if (AppDriver.getDriver() != null) {
            System.out.println("tearDown from Listeners");
            AppDriver.getDriver().quit();
        }
        System.out.println("Appium Server stop from Listeners onFinish");
        AppiumServer.stopServer();
    }
}