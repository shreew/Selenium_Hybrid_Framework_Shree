package testdata1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility1.ConfigDataProvider;
import utility1.ExelDataProvider2;
import utility1.Helper1;

public class Basecls1 {

	public static WebDriver driver;
	public ExelDataProvider2 excelDataProvider;
	public static ConfigDataProvider configDataProvider;

	public ExtentReports extent;
	public ExtentTest logger;
	
	@BeforeSuite
	public void initilialize() {
		configDataProvider = new ConfigDataProvider();
		excelDataProvider = new ExelDataProvider2();
		String path=System.getProperty("user.dir");
		ExtentHtmlReporter reporter = new ExtentHtmlReporter
				(new File(path+"//Reports//Freecrm_"+Helper1.getcurrentDataTime()+".html"));
		extent=new ExtentReports();
		extent.attachReporter(reporter);
	}

	public static void browserStartUp(String browserName, String url) {
		if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"E:\\libaries\\geckodriver-v0.24.0-win64 (1)\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\libaries\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else {
			System.out.println("driver not able to found....");
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void tearDown(ITestResult results) throws IOException {
		Reporter.log("Test is about to end", true);
		
		if (results.getStatus() == ITestResult.FAILURE) {
			
			//Helper1.capturescreenshorts(driver);
			
			logger.fail("Falied test case", MediaEntityBuilder.createScreenCaptureFromPath(Helper1.capturescreenshorts(driver)).build());
		} else if (results.getStatus() == ITestResult.SUCCESS) {
		} else if (results.getStatus() == ITestResult.SKIP) {
		}

		extent.flush();
	}
}
