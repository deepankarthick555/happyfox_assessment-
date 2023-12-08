package com.happyfox.helpdesk.page_objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 */
public class PendingTicketPage {

	private static PendingTicketPage PendingTicketPageInstance = null;

	private PendingTicketPage() {
	}

	public static PendingTicketPage getInstance() {

		if (PendingTicketPageInstance == null) {
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

	@FindBy(xpath = "//button[contains(text(),'Add Reply')]")
	private WebElement PENDING_TICKET_ADD_REPLAY;

	@FindBy(xpath = "//div[@data-test-id='add-update-ticket-action_change-status_trigger']")
	private WebElement CANNED_ACTION_STATUS;

	@FindBy(xpath = "//div[@class='hf-ticket-attribute_option']")
	private List<WebElement> CANNED_ACTION_STATUS_LIST;

	@FindBy(xpath = "//*[@class='ember-view']/div/div/div[@data-test-id='ticket-box_priority']")
	private WebElement CANNED_ACTION_PRIORITY;

	@FindBy(xpath = "//div[@class='hf-ticket-attribute_option']")
	private List<WebElement> CANNED_ACTION_PRIORITY_LIST;

	@FindBy(xpath = "//div[contains(text(),'Add Tags')]")
	private WebElement CANNED_ACTION_ADD_TAGS;

	@FindBy(xpath = "//ul[@class='ember-power-select-options']/li")
	private WebElement CANNED_ACTION_ADD_TAGS_VALUE;

	@FindBy(xpath = "//a[@data-test-id='details-close']")
	private WebElement PENDING_TICKETS_CLOSE;

	@FindBy(xpath = "//a[contains(text(),'Delete')]")
	private WebElement STATUS_DELETE;

	@FindBy(xpath = "//span[contains(text(),'Choose Status')]")
	private WebElement STATUS_DELETE_DESCRIPTION;

	@FindBy(xpath = "//li[@class='ember-power-select-option']")
	private List<WebElement> STATUS_DELETE_DESCRIPTION_LIST;

	@FindBy(xpath = "//button[@data-test-id='delete-dependants-primary-action']")
	private WebElement FINAL_STATUS_DELETE_BUTTON;

	@FindBy(xpath = "//a[contains(text(),'Delete')]")
	private WebElement PRIORITY_DELETE;

	@FindBy(xpath = "//span[contains(text(),'Choose Priority')]")
	private WebElement PRIORITY_DELETE_DESCRIPTION;

	@FindBy(xpath = "	//li[@class='ember-power-select-option']")
	private List<WebElement> PRIORITY_DELETE_DESCRIPTION_LIST;

	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	private WebElement FINAL_PRIORITY_DELETE_BUTTON;

	@FindBy(xpath = "//img[@class='hf-avatar-image hf-avatar-image_show']")
	private WebElement AVATAR_IMG;

	@FindBy(xpath = "//li[@data-test-id='staff-menu_logout']/a")
	private WebElement LOGOUT_BUTTON;

	public void clickLogoutButton() {
		LOGOUT_BUTTON.click();
	}

	public void clickAvatarImg() {
		AVATAR_IMG.click();
	}

	public void clickFinalPriorityDeleteButton() {
		FINAL_PRIORITY_DELETE_BUTTON.click();
	}

	public List<WebElement> getPriorityDeleteDescriptionList() {
		return STATUS_DELETE_DESCRIPTION_LIST;
	}

	public void clickPriorityDeleteDescription() {
		PRIORITY_DELETE_DESCRIPTION.click();
	}

	public void clickPriorityDelete() {
		PRIORITY_DELETE.click();
	}

	public void clickFinalStatusDeleteButton() {
		FINAL_STATUS_DELETE_BUTTON.click();
	}

	public List<WebElement> getStatusDeleteDescriptionList() {
		return STATUS_DELETE_DESCRIPTION_LIST;
	}

	public void clickStatusDeleteDescription() {
		STATUS_DELETE_DESCRIPTION.click();
	}

	public void clickStatusDelete() {
		STATUS_DELETE.click();
	}

	public void clickPendingTicketsClose() {
		PENDING_TICKETS_CLOSE.click();
	}

	public void enterCannedActionAddTagsValue(String tagsValue) {
		CANNED_ACTION_ADD_TAGS_VALUE.sendKeys(tagsValue);
	}

	public void clickCannedActionAddTags() {
		CANNED_ACTION_ADD_TAGS.click();
	}

	public void clickCannedActionPriority() {
		CANNED_ACTION_PRIORITY.click();
	}

	public List<WebElement> getTextCannedActionStatusList() {
		return CANNED_ACTION_STATUS_LIST;
	}

	public void clickCannedActionStatus() {
		CANNED_ACTION_STATUS.click();

	}

	public List<WebElement> getPendingTicketTableStatusName() {
		return PENDING_TICKET_TABLE_STATUS_NAME;
	}

	public void clickPendingTicketSubjectName() {
		PENDING_TICKET_SUBJECT_NAME.click();

	}

	public String getTextPendingTicketDefaultStatus() {
		return PENDING_TICKET_DEFAULT_STATUS.getText();
	}

	public void clickPendingTicketAddRepay() {
		PENDING_TICKET_ADD_REPLAY.click();
	}

	public void clickPendingTicketRepay() {
		PENDING_TICKET_REPLAY.click();
	}

	public void enterPendingTicketMessageBox(String messageBox) {
		PENDING_TICKET_MESSAGE_BOX.sendKeys(messageBox);
	}

	public String getTextPendingTicketDefaultPriority() {

		return PENDING_TICKET_DEFAULT_PRIORITY.getText();
	}

	public List<WebElement> getTextCannedActionPriorityList() {
		return CANNED_ACTION_PRIORITY_LIST;
	}

//	public WebElement getPENDING_TICKET_ADD_REPLAY() {
//	return PENDING_TICKET_ADD_REPLAY;
//}

//	public WebElement getPENDING_TICKET_SUBJECT_NAME() {
//		return PENDING_TICKET_SUBJECT_NAME;
//	}

//	public WebElement getPENDING_TICKET_DEFAULT_STATUS() {
//		return PENDING_TICKET_DEFAULT_STATUS;
//	}

//	public WebElement getPENDING_TICKET_DEFAULT_PRIORITY() {
//		return PENDING_TICKET_DEFAULT_PRIORITY;
//	}

//	public List<WebElement> getPENDING_TICKET_TABLE_STATUS_NAME() {
//		return PENDING_TICKET_TABLE_STATUS_NAME;
//	}

//	public WebElement getPENDING_TICKET_REPLAY() {
//	return PENDING_TICKET_REPLAY;
//}

//public WebElement getPENDING_TICKET_MESSAGE_BOX() {
//	return PENDING_TICKET_MESSAGE_BOX;
//}

}
