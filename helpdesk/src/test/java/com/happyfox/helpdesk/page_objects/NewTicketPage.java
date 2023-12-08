package com.happyfox.helpdesk.page_objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.happyfox.helpdesk.webdriver_manager.DriverManager;

public final class NewTicketPage {

	private static NewTicketPage NewTicketPageInstance = null;

	private NewTicketPage() {
	}

	public static NewTicketPage getInstance() {

		if (NewTicketPageInstance == null) {
			NewTicketPageInstance = new NewTicketPage();
		}
		return NewTicketPageInstance;

	}

	@FindBy(name = "subject")
	private WebElement NEW_TICKET_SUBJECT;

	@FindBy(xpath = "//div[@role='textbox']")
	private WebElement NEW_TICKET_MESSAGE;

	@FindBy(id = "id_name")
	private WebElement NEW_TICKET_FULL_NAME;

	@FindBy(id = "id_email")
	private WebElement NEW_TICKET_EMAIL;

	@FindBy(id = "id_phone")
	private WebElement NEW_TICKET_PHONE;

	@FindBy(xpath = "//button[contains(text(),'Create Ticket')]")
	private WebElement CREATE_TICKET_SUBMIT;
	
	@FindBy(xpath = "//*[@class='hf-welcome-banner_content']")
	private WebElement TITLE_OF_TICKET_PAGE;
	
	
	public String getTitleOfTicketPage() {
		return TITLE_OF_TICKET_PAGE.getText();
	}
	
	public void enterNewTicketMessage(String message) {
		NEW_TICKET_MESSAGE.sendKeys(message);
	}

	public void enterNewTicketSubject(String subject) {
		NEW_TICKET_SUBJECT.sendKeys(subject);
	}
	
	public void enterNewTicketFullName(String fullName) {
		NEW_TICKET_FULL_NAME.sendKeys(fullName);
	}
	
	public void enterNewTicketEmail(String email) {
		NEW_TICKET_EMAIL.sendKeys(email);
	}
	
	public void enterNewTicketPhone(String phone) {
		NEW_TICKET_PHONE.sendKeys(phone);
	}
	
	public void clickCreateTicketButton() {
		
//		CREATE_TICKET_SUBMIT.click();
		Actions at = new Actions(DriverManager.getDriver());
		at.moveToElement(CREATE_TICKET_SUBMIT).click().build().perform();
		
//		JavascriptExecutor je =(JavascriptExecutor)DriverManager.getDriver();
//		je.executeScript("window.scrollTo(0,"CREATE_TICKET.getLocation().x+")");
//		CREATE_TICKET.click();
	
		
	}
	
//	public WebElement getCREATE_TICKET() {
//		return CREATE_TICKET;
//	}
//
//	public WebElement getNEW_TICKET_SUBJECT() {
//		return NEW_TICKET_SUBJECT;
//	}
//
//	public WebElement getNEW_TICKET_MESSAGE() {
//		return NEW_TICKET_MESSAGE;
//	}
//
//	public WebElement getNEW_TICKET_FULL_NAME() {
//		return NEW_TICKET_FULL_NAME;
//	}
//
//	public WebElement getNEW_TICKET_EMAIL() {
//		return NEW_TICKET_EMAIL;
//	}
//
//	public WebElement getNEW_TICKET_PHONE() {
//		return NEW_TICKET_PHONE;
//	}

}
