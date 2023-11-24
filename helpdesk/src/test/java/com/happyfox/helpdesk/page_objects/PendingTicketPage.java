package com.happyfox.helpdesk.page_objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 */
public class PendingTicketPage {
	
	private static PendingTicketPage PendingTicketPageInstance=null;
	
	private  PendingTicketPage() {}
	
	public static PendingTicketPage getInstance() {
		
		if(PendingTicketPageInstance==null) {
			PendingTicketPageInstance = new PendingTicketPage();
		}
		return PendingTicketPageInstance;
		
	}
	
	
	
	@FindBy(xpath = "//tbody[@class='lt-body']/tr/td[5]")
	private List<WebElement> PENDING_TICKET_TABLE_STATUS_NAME;
	
	@FindBy(xpath = "//section[@class='hf-ticket-preview_body hf-js-ticket-preview_body']/a")
	private WebElement PENDING_TICKET_SUBJECT_NAME;
	

	@FindBy(xpath = "//div[@class='hf-ticket-status']")
	private WebElement PENDING_TICKET_DEFAULT_STATUS;
	
	@FindBy(xpath = "//*[@data-test-id='ticket-box_priority']")
	private WebElement PENDING_TICKET_DEFAULT_PRIORITY;
	
	@FindBy(xpath = "//span[contains(text(),'Reply')]")
	private WebElement PENDING_TICKET_REPLAY;
	
	@FindBy(xpath = "//*[@id='cke_1_contents']/div")
	private WebElement PENDING_TICKET_MESSAGE_BOX;
	
	@FindBy(xpath = "	//button[contains(text(),'Add Reply')]")
	private WebElement PENDING_TICKET_ADD_REPLAY;


	public WebElement getPENDING_TICKET_ADD_REPLAY() {
		return PENDING_TICKET_ADD_REPLAY;
	}

	public WebElement getPENDING_TICKET_REPLAY() {
		return PENDING_TICKET_REPLAY;
	}

	public WebElement getPENDING_TICKET_MESSAGE_BOX() {
		return PENDING_TICKET_MESSAGE_BOX;
	}

	public WebElement getPENDING_TICKET_SUBJECT_NAME() {
		return PENDING_TICKET_SUBJECT_NAME;
	}

	public WebElement getPENDING_TICKET_DEFAULT_STATUS() {
		return PENDING_TICKET_DEFAULT_STATUS;
	}

	public WebElement getPENDING_TICKET_DEFAULT_PRIORITY() {
		return PENDING_TICKET_DEFAULT_PRIORITY;
	}

	public List<WebElement> getPENDING_TICKET_TABLE_STATUS_NAME() {
		return PENDING_TICKET_TABLE_STATUS_NAME;
	}

	
	
	

}
