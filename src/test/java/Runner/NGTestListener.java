package Runner;

import Base.BaseUtil;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NGTestListener implements ITestListener
{
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("On test start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        System.out.println("On test Sucess");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("On test failure");


    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("On test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("On test percentage");
    }

    @Override
    public void onStart(ITestContext iTestContext)
    {
        try {
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            System.out.println("Internet is connected");
            BaseUtil.internetCheck = true;
            BaseUtil.webDriver = new ChromeDriver();
        } catch (MalformedURLException e) {
            BaseUtil.internetCheck = false;
            System.out.println("Internet is not connected");
        } catch (IOException e) {
            BaseUtil.internetCheck = false;
            System.out.println("Internet is not connected");
        }

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("On finish");

    }
}
