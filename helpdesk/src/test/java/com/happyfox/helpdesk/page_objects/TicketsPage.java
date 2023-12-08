package com.happyfox.helpdesk.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TicketsPage {
	
	
	private static TicketsPage ticketsPageInstance=null;
	
	private TicketsPage() {}
	
	public static TicketsPage getInstance() {
		
		if(ticketsPageInstance==null) {
			ticketsPageInstance = new TicketsPage();
		}
			return ticketsPageInstance;
	}
	
	@FindBy(xpath="//div[@data-test-id='module-switcher_trigger']/span")
	private WebElement TICKETS;
	
	
	@FindBy(xpath="//a[contains(@href,'/staff/manage/statuses')]")
	private WebElement STATUSES;
	
	@FindBy(xpath="//a[contains(text(),'Priorities')]")
	private WebElement PRIORITIES;
	
	
	@FindBy(xpath="//button[@class='hf-mod-create']")
	private WebElement ADD_STATUSES;
	
	
	@FindBy(xpath="//button[@class='hf-mod-create']")
	private WebElement ADD_PRIORITIES;
	
	
	@FindBy(xpath="//a[contains(text(),'Statuses')]")
	private WebElement MANAGE_STATUSES;
	
	public void clickManageStatuses() {
		MANAGE_STATUSES.click();
	}
	
	public void clickPriorities() {
		PRIORITIES.click();
	}
	
	public void clickAddPriorities() {
		ADD_PRIORITIES.click();
	}
	
	public void clickTickets() {
		TICKETS.click();
	}
	
	public void clickStatuses() {
		STATUSES.click();
	}
	
	public void clickAddStatuses() {
		ADD_STATUSES.click();
	}
//	public WebElement getMANAGE_STATUSES() {
//		return MANAGE_STATUSES;
//	}
//
//	public WebElement getADDSTATUSES() {
//		return ADD_STATUSES;
//	}
//
//	public WebElement getADDPRIORITIES() {
//		return ADD_PRIORITIES;
//	}
//
//	public WebElement getSTATUSES() {
//		return STATUSES;
//	}
//
//	public WebElement getPRIORITIES() {
//		return PRIORITIES;
//	}
//
//	public WebElement getTICKETS() {
//		return TICKETS;
//	}

	
	
}
