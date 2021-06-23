package com.qaFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	/**
	 * Basically done for threadLocal for parallel execution
	 * it have methods like set and get and it will add in HashmapThread local internally
	 * 
	 **/
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();

	public WebDriver init_driver(String browser) {
		System.out.println("The Name of Browser: " + browser);
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());

		} else if (browser.equals("forefox")) {
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());

		} else
			System.out.println("pass the correct value of the browser : " + browser);

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}

	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}

}
