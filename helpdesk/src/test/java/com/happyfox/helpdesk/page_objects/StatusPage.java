package com.happyfox.helpdesk.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StatusPage {
	
	private static StatusPage StatusPageInstance=null;
	
	private  StatusPage(){}
	
	public static StatusPage getInstance() {
		
		if(StatusPageInstance==null) {
			StatusPageInstance= new StatusPage();
		}
			return StatusPageInstance;
	}
	


	@FindBy(xpath="//input[@data-test-id='form-field-name']")
	private WebElement STATUS_NAME;
	
	@FindBy(xpath="//div[@data-ebd-id='ember1785-trigger']")
	private WebElement STATUS_BEHAVIOUR;
	
	@FindBy(xpath="//textarea[@data-test-id='form-field-description']")
	private WebElement STATUS_DESCRIPTION;
	
	@FindBy(xpath="//button[@data-test-id='add-status']")
	private WebElement ADD_STATUS_BUTTON;

	
	public WebElement getSTATUS_NAME() {
		return STATUS_NAME;
	}

	public WebElement getSTATUS_BEHAVIOUR() {
		return STATUS_BEHAVIOUR;
	}

	public WebElement getSTATUS_DESCRIPTION() {
		return STATUS_DESCRIPTION;
	}

	public WebElement getADD_STATUS_BUTTON() {
		return ADD_STATUS_BUTTON;
	}
	
	
}
