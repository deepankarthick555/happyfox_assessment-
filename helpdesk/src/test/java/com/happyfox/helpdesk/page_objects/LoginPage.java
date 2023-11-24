package com.happyfox.helpdesk.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	private static LoginPage LoginInstance=null;

	private LoginPage() {
	}

	public static LoginPage getInstance() {

		if (LoginInstance == null) {

			LoginInstance = new LoginPage();
		}

		return LoginInstance;

	}

	@FindBy(name = "username")
	private WebElement USERNAME;

	@FindBy(name = "password")
	private WebElement PASSWORD;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement LOGIN;

	public WebElement getUSERNAME() {
		return USERNAME;
	}

	public WebElement getPASSWORD() {
		return PASSWORD;
	}

	public WebElement getLOGIN() {
		return LOGIN;
	}

}
