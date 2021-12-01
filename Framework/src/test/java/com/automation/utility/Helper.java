package com.automation.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Helper {

	public static String captureScreenshot(WebDriver driver) {
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir")+"/Screenshots/Login_" + getTimeMillSec() + ".png";
		try {
			FileHandler.copy(src, new File(screenshotPath));
			
			Reporter.log("********** Screenshot Captured !!! **************", true);
			
		} catch (Exception e) {
			Reporter.log("Unable to capture screenshot!!" + e.getMessage());
		}
		
		return screenshotPath;

	}

	public static String getTimeMillSec() {
		DateFormat customFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}

	public void handleFrames() {

	}

	public void handleAlerts() {

	}

	public void handleWindows() {

	}

}
