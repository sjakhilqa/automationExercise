package utilities;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager implements ITestListener {

    private static ExtentReports extent;
    private static ExtentTest test;

    public void onStart(ITestContext context) {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportName = "Test-Report-" + timeStamp + ".html";

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./reports/" + reportName);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Functional Test Results");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester", "YourName");
    }

    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Failed: " + result.getThrowable());

        // Optional: capture screenshot
        Object testClass = result.getInstance();
        WebDriver driver = getDriverFromTestClass(testClass);
        if (driver != null) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());
            test.addScreenCaptureFromPath(screenshotPath);
        }
    }

    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped: " + result.getThrowable());
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }

    // Helper method to extract WebDriver instance
    private WebDriver getDriverFromTestClass(Object testClass) {
        try {
            return (WebDriver) testClass.getClass().getDeclaredField("driver").get(testClass);
        } catch (Exception e) {
            return null;
        }
    }
}
