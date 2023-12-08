package com.happyfox.helpdesk.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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
	
	@FindBy(xpath="//*[@data-test-id='form-field-behavior']")
	private WebElement STATUS_BEHAVIOUR;
	
	@FindBy(xpath="//textarea[@data-test-id='form-field-description']")
	private WebElement STATUS_DESCRIPTION;
	
	@FindBy(xpath="//button[@data-test-id='add-status']")
	private WebElement ADD_STATUS_BUTTON;

	
	
	public void enterStatusName(String statusName) {
		STATUS_NAME.sendKeys(statusName);
	}
	
	public void selectBehaviourName(String behaviourName) {
		Select select = new Select(STATUS_BEHAVIOUR);
		select.selectByVisibleText(behaviourName);
		
	}

	public void enterDescriptionName(String descriptionName) {
		STATUS_DESCRIPTION.sendKeys(descriptionName);
	}
	
	public void addStatusButton() {
		ADD_STATUS_BUTTON.click();
	}

//	public WebElement getSTATUS_NAME() {
//		return STATUS_NAME;
//	}
//
//	public WebElement getSTATUS_BEHAVIOUR() {
//		return STATUS_BEHAVIOUR;
//	}
//
//	public WebElement getSTATUS_DESCRIPTION() {
//		return STATUS_DESCRIPTION;
//	}
//
//	public WebElement getADD_STATUS_BUTTON() {
//		return ADD_STATUS_BUTTON;
//	}
	
	
}
