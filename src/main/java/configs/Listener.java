package configs;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.net.MalformedURLException;

public class Listener implements ITestListener {

    private AppProperties appProperties = new AppProperties();

    @Override
    public void onTestStart(ITestResult result) {
        AppiumServer.startServer();
        if ("Android".equalsIgnoreCase(appProperties.getProperty("platform"))){
            try {
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
    public void onTestSuccess(ITestResult result) {
        try {
            tearDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            tearDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getName();

        try {
            tearDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        String failedTest = result.getName();


    }
    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    public void tearDown() throws InterruptedException {
        AppDriver.getDriver().quit();
        AppiumServer.stopServer();
    }
}