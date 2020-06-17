package pageObjectModel;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ListenerWithReports implements ITestListener {

	protected static WebDriver driver;
	protected static ExtentReports reports;
	protected static ExtentTest test;
	protected static File srcFile;
	// protected hence need to extend in other class
	// Download and add Jar files com.relevantcodes.extentreports

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("-------------------------");
		System.out.println("Test " + result.getTestClass() + result.getName() + " has started");

		test = reports.startTest(result.getMethod().getMethodName());

		test.log(LogStatus.INFO, result.getMethod().getMethodName() + " Test has started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("-------------------------");
		System.out.println("Test " + result.getTestClass() + result.getName() + " is sucessful ");

		test.log(LogStatus.PASS, result.getMethod().getMethodName() + " Test is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("-------------------------");
		System.out.println("Test " + result.getTestClass() + result.getName() + " has Failed");

		System.out.println("Error message is  " + result.getThrowable());

		test.log(LogStatus.FAIL,
				result.getMethod().getMethodName() + " Test is Failed because of error " + result.getThrowable());

		srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(srcFile, new File("C:\\temp\\Demo_"
		// +AddTime()+"_screenshot1.png"));

		try {

			FileUtils.copyFile(srcFile,
					new File("Screenshots/test_" + result.getClass().getName() + AddTime() + "_screenshot.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("-------------------------");
		System.out.println("Test " + result.getTestClass() + result.getTestName() + " was skipped");
		System.out.println("Error message is  " + result.getThrowable());
		test.log(LogStatus.SKIP,
				result.getMethod().getMethodName() + " Test is Skipped because of error" + result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("-------------------------");
		System.out.println("on start");

		System.setProperty("webdriver.chrome.driver", "src\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		reports = new ExtentReports("ExtentReports/test_" + AddTime() + "reports.html");

		// TODO Auto-generated method stub
		// new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date())
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		driver.close();
		reports.endTest(test);
		reports.flush();
	}

	public static String AddTime() {
		return new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());

	}

}

/*
 * 
 * 
 * 
 * When running TestNG tests, one could want to perform some common actions –
 * after each test has finished successfully, after each failed test, after each
 * skipped test, or after all the tests have finished running, no matter their
 * result. To apply such a common behavior to a group of tests, a custom
 * listener can be created, that implements TestNG’s ITestListener interface.
 *
 *
 * 
 */
