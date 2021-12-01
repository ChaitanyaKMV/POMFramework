package com.automation.testcases;

import org.testng.annotations.Test;
import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;

public class LoginTestCRM extends BaseClass {

	LoginPage loginpage;

	@Test
	public void loginApp() throws InterruptedException {
		
		logger = report.createTest("Login To CRM");

		loginpage = new LoginPage(driver);
		
		logger.info("Logging in CRM application !!");
		
		loginpage.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));

		Thread.sleep(5000);

//		System.out.println("***************   " + driver.getTitle() + "       ****************");
		
		logger.pass("Login done successfully");
		
		loginpage.verifyLoginPage(excel.getStringData("Login", 0, 2));
		
		logger.pass("Username validated successfully");
		
		loginpage.logoutFromApp();
		
		logger.pass("User Logout successfully");

	}

}