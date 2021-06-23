package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {

	private WebDriver driver;

	// By elements
	By myaccountSection = By.cssSelector("div.row.addresses-lists span");

	// Constructor
	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}

	// Page actions
	
	public String getAccountPageTitle() {

		return driver.getTitle();
	}

	public int getSizeOfAccountSection() {
		return driver.findElements(myaccountSection).size();
	}

	public List<String> namesOfmenus() {

		List<String> arrayListmenu = new ArrayList<String>();
		List<WebElement> listMenus = driver.findElements(myaccountSection);

		for (WebElement name : listMenus) {
			String text = name.getText();
			System.out.println(text);
			arrayListmenu.add(text);
		}

		return arrayListmenu;
	}

}
