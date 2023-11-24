package com.happyfox.helpdesk.page_objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PriorityPage {

	private static PriorityPage PriorityPageInstance = null;

	private PriorityPage() {
	}

	public static PriorityPage getInstance() {

		if (PriorityPageInstance == null) {
			PriorityPageInstance = new PriorityPage();
		}
		return PriorityPageInstance;
	}

	@FindBy(xpath = "//input[@data-test-id='form-field-name']")
	private WebElement PRIORITY_NAME;

	@FindBy(xpath = "//textarea[@data-test-id='form-field-description']")
	private WebElement PRIORITY_DESCRIPTION;

	@FindBy(xpath = "//button[@data-test-id='add-priority']")
	private WebElement PRIORITY_ADD_BUTTON;

	@FindBy(xpath = "//tbody[@class='lt-body']/tr/td[2]")
	private List<WebElement> PRIORITY_NAME_TABLE;

	@FindBy(xpath = "//tbody[@class='lt-body']/tr/td[5]")
	private List<WebElement> DEFAULT_PRIORITY_TABLE;

	public List<WebElement> getPRIORITY_NAME_TABLE() {
		return PRIORITY_NAME_TABLE;
	}

	public List<WebElement> getDEFAULT_PRIORITY_TABLE() {
		return DEFAULT_PRIORITY_TABLE;
	}

	public WebElement getPRIORITY_ADD_BUTTON() {
		return PRIORITY_ADD_BUTTON;
	}

	public WebElement getPRIORITY_NAME() {
		return PRIORITY_NAME;
	}

	public WebElement getPRIORITY_DESCRIPTION() {
		return PRIORITY_DESCRIPTION;
	}

}
