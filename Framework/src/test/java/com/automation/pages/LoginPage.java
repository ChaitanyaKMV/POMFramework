package com.automation.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	WebDriver driver;
	
	public LoginPage(WebDriver lDriver) {
		this.driver=lDriver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[contains(text(),'Log In')]") WebElement selectLogin;
	@FindBy(name="email") WebElement uname;
	@FindBy(name="password") WebElement pass;
	@FindBy(xpath="//div[contains(text(),'Login')]") WebElement loginButton;
	@FindBy(xpath = "//span[contains(text(),'Automation Guy')]") WebElement userNameDisplay;
	@FindBy(xpath = "//div[@role='listbox']") WebElement settingsIcon;
	@FindBy(xpath = "//span[contains(text(),'Log Out')]") WebElement logoutBtn;
	
	
	public void loginToCRM(String usernameApp, String passwordApp) throws InterruptedException {
		
		selectLogin.click();
		Thread.sleep(5000);
		uname.sendKeys(usernameApp);
		pass.sendKeys(passwordApp);
		loginButton.click();
		
	}
	
	public void verifyLoginPage(String userNameExpected) {
		assertEquals(userNameExpected, userNameDisplay.getText());
	}
	
	public void logoutFromApp() throws InterruptedException {
		
		settingsIcon.click();
		Thread.sleep(2000);
		logoutBtn.click();
		Thread.sleep(4000);
		
	}
	
}
