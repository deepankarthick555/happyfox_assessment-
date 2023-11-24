package com.happyfox.helpdesk.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

	@FindBy(xpath = "//button[@id='submit']")
	private WebElement CREATE_TICKET;

	public WebElement getCREATE_TICKET() {
		return CREATE_TICKET;
	}

	public WebElement getNEW_TICKET_SUBJECT() {
		return NEW_TICKET_SUBJECT;
	}

	public WebElement getNEW_TICKET_MESSAGE() {
		return NEW_TICKET_MESSAGE;
	}

	public WebElement getNEW_TICKET_FULL_NAME() {
		return NEW_TICKET_FULL_NAME;
	}

	public WebElement getNEW_TICKET_EMAIL() {
		return NEW_TICKET_EMAIL;
	}

	public WebElement getNEW_TICKET_PHONE() {
		return NEW_TICKET_PHONE;
	}

}
