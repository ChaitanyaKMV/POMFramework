package com.automation.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.utility.BrowserFactory;
import com.automation.utility.ConfigDataProvider;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.Reporter;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() {
		Reporter.log("Setting up reports for test !!", true);

		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();

		ExtentSparkReporter spark = new ExtentSparkReporter(
				new File("./ExtentReports/FreeCRMReport" + Helper.getTimeMillSec() + ".html"));
		report = new ExtentReports();
		report.attachReporter(spark);
		Reporter.log("Settings done for report - Test can begin !!", true);
	}

	@BeforeClass
	public void setUp() {

		Reporter.log("Trying to start browser & Getting app ready!!",true);
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
		Reporter.log("Browser launched and App is up and running!!",true);
	}


	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		
		Reporter.log("Test is about to end!!",true);
		
		if (result.getStatus() == ITestResult.FAILURE) {

			logger.fail("Test failed !!",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {

			logger.pass("Test Passed !!",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}

		report.flush();
		
		Reporter.log("Test completed >>> Reports are generated!!",true);
	}
	
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
		
		Reporter.log("\n****************  Browser closed   ********************\n",true);
	}

}
