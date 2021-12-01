package com.automation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
	
	/**
	 * For Mac users-  Keep all drivers inside /usr/local/bin directory
	 * 		and execute command 'xattr -d com.apple.quarantine chromedriver'
	 * 		and ignore this `System.setProperty("webdriver.browser.driver", "./Drivers/browDriver");`
	 * @param driver
	 * @param browserName
	 * @param appURL
	 * @return
	 */
	
	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {
		
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			
			//System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
			driver =  new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver");
			driver = new FirefoxDriver();
			
		}else if(browserName.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		
		}else if(browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
			
		}else {
			System.out.println("Invalid Browser Name entered!!! Please provide browser name from the list given.... `Chrome or Firefox or IE or Safari`  ");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		return driver;
	}
	
	
	public static void closeBrowser(WebDriver driver) {
		driver.close();
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}

}
