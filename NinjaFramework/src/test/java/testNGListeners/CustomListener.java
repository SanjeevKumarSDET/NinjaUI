package testNGListeners;

import java.util.Objects;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentTest;

import core.framework.web.WebBase;


public class CustomListener extends ScreenshotBase implements ITestListener{
	
	//static ExtentReports extent = ExtentManager.getInstance();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " started!");
//		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),
//				result.getMethod().getDescription());
//		test.set(extentTest);
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " Passed!"));
		//test.get().log(Status.PASS, result.getMethod().getMethodName() + " Passed!");
	}

	public void onTestFailure(ITestResult result) {
		failed(result.getMethod().getMethodName());
		System.out.println((result.getMethod().getMethodName() + " failed!"));
		
//		WebDriver driver = WebBase.driver;
//		String base64Screenshot = "data:image/png;base64,"
//				+ ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
//
//		System.out.println((result.getMethod().getMethodName() + " failed!"));
//		test.get().log(Status.FAIL, result.getMethod().getMethodName() + " failed!");
//		test.get().fail(result.getThrowable());
//		test.get().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0);
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		System.out.println("Extent Report started!");
	}

	public void onFinish(ITestContext context) {
		System.out.println(("Extent Report ends!"));
		//extent.flush();
	}
	
}
