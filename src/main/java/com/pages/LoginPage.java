package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// Object repository [By locators]
	private By emailID = By.id("email");
	private By password = By.id("passwd");
	private By signButton = By.id("SubmitLogin");
	private By forgotPasswordLink = By.linkText("Forgot your password?");
	private By authenticationFailed = By.cssSelector("div.alert.alert-danger>ol>li");
	
	
	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// page action in form features methods

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean getForgotPasswordLink() {
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}

	public void enterUserName(String un) {
		driver.findElement(emailID).clear();
		driver.findElement(emailID).sendKeys(un);
	}

	public void enterpassWord(String pw) {

		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pw);

	}

	public void clickOnSignIn() {
		driver.findElement(signButton).click();
	}

	public AccountPage doLogin(String UN, String Password) {

		driver.findElement(emailID).clear();
		driver.findElement(emailID).sendKeys(UN);
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(Password);

		driver.findElement(signButton).click();

		return new AccountPage(driver);
	}

	public String verifyInvalidLogin() {
		String errorMsg =  driver.findElement(authenticationFailed).getText();
		//System.out.println(errorMsg);
		return errorMsg;
	}
	
	
	
}
