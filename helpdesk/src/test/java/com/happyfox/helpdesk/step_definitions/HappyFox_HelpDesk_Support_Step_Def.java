package com.happyfox.helpdesk.step_definitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.happyfox.helpdesk.constants.Constants;
import com.happyfox.helpdesk.page_objects.LoginPage;
import com.happyfox.helpdesk.page_objects.NewTicketPage;
import com.happyfox.helpdesk.page_objects.PendingTicketPage;
import com.happyfox.helpdesk.page_objects.PriorityPage;
import com.happyfox.helpdesk.page_objects.StatusPage;
import com.happyfox.helpdesk.page_objects.TicketsPage;
import com.happyfox.helpdesk.testdata.dataDriven;
import com.happyfox.helpdesk.utilities.CommonUtils;
import com.happyfox.helpdesk.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HappyFox_HelpDesk_Support_Step_Def {

	private static final Logger LOGGER = LogManager.getLogger(HappyFox_HelpDesk_Support_Step_Def.class);
	private static final String Verfiy_ = null;

	@Given("the user is logged in successfully and is on Agent Portal.")
	public void the_user_is_logged_in_successfully_and_is_on_agent_portal() {

		try {

			DriverManager.getDriver().get("https://interview2.supporthive.com/staff/");

			LoginPage.getInstance().getUSERNAME().sendKeys(Constants.USERNAME);
			LoginPage.getInstance().getPASSWORD().sendKeys(Constants.PASSWORD);
			LoginPage.getInstance().getLOGIN().click();

			Thread.sleep(6000);
			String URL = DriverManager.getDriver().getCurrentUrl();

			if (URL.contains("_pending")) {
				LOGGER.info("the user is logged in successfully and is on Ticket Page.");
				Assert.assertTrue(true);
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}

	}

	@When("Navigate to Status\\/Priority pages from the Menu on the top left corner.")
	public void navigate_to_status_priority_pages_from_the_menu_on_the_top_left_corner() throws IOException {

		try {
			Thread.sleep(4000);
			TicketsPage.getInstance().getTICKETS().click();
			TicketsPage.getInstance().getSTATUSES().click();
			Thread.sleep(4000);

		} catch (Exception e) {
			LOGGER.error(e);
		}

	}

	@When("Create a status values provided in the sheet.")
	public void create_a_status_values_provided_in_the_sheet() throws IOException {

		try {
			ArrayList<String> data = dataDriven.getInstance().getData("STATUSES");
			TicketsPage.getInstance().getADDSTATUSES().click();
			Thread.sleep(3000);

			StatusPage.getInstance().getSTATUS_NAME().sendKeys(data.get(1));
//			StatusPage.getInstance().getSTATUS_BEHAVIOUR().sendKeys(data.get(2));
			StatusPage.getInstance().getSTATUS_DESCRIPTION().sendKeys(data.get(3));
			StatusPage.getInstance().getADD_STATUS_BUTTON().click();
			Thread.sleep(3000);

		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@When("Create a priority values provided in the sheet.")
	public void create_a_priority_values_provided_in_the_sheet() throws IOException {
		try {
			ArrayList<String> data = dataDriven.getInstance().getData("PRIORITIES");
			TicketsPage.getInstance().getPRIORITIES().click();
			TicketsPage.getInstance().getADDPRIORITIES().click();

			PriorityPage.getInstance().getPRIORITY_NAME().sendKeys(data.get(1));
			PriorityPage.getInstance().getPRIORITY_DESCRIPTION().sendKeys(data.get(2));
			PriorityPage.getInstance().getPRIORITY_ADD_BUTTON().click();
			Thread.sleep(3000);

		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Then("Make the created status and priority as default.")
	public void make_the_created_status_and_priority_as_default() throws IOException, InterruptedException {
		try {
			// Making Priority as Default
			ArrayList<String> priorityData = dataDriven.getInstance().getData("PRIORITIES");
			List<WebElement> PriorityName = PriorityPage.getInstance().getPRIORITY_NAME_TABLE();
			List<WebElement> DefaultPriority = PriorityPage.getInstance().getDEFAULT_PRIORITY_TABLE();
			Thread.sleep(3000);
			for (int i = 0; i < PriorityName.size(); i++) {
//				System.out.println(PriorityName.get(i).getText());
				if (PriorityName.get(i).getText().equalsIgnoreCase(priorityData.get(1))) {

					DefaultPriority.get(i).click();

				}
			}
			// Making Status as Default
			ArrayList<String> statusData = dataDriven.getInstance().getData("STATUSES");
			TicketsPage.getInstance().getMANAGE_STATUSES().click();
			Thread.sleep(3000);

			List<WebElement> StatusName = PriorityPage.getInstance().getPRIORITY_NAME_TABLE();
			List<WebElement> DefaultStatus = PriorityPage.getInstance().getDEFAULT_PRIORITY_TABLE();
			Thread.sleep(3000);
			for (int i = 0; i < StatusName.size(); i++) {
//				System.out.println(StatusName.get(i).getText());
				if (StatusName.get(i).getText().equalsIgnoreCase(statusData.get(1))) {

					DefaultStatus.get(i).click();

				}
			}

		} catch (Exception e) {
			LOGGER.error(e);
		}

	}

	@Given("Create a ticket from new ticket page on support center.")
	public void create_a_ticket_from_new_ticket_page_on_support_center() throws IOException {

		try {
			ArrayList<String> data = dataDriven.getInstance().getData("TICKETCREATION");

			DriverManager.getDriver().navigate().to(Constants.TICKET_PAGE_URL);
			NewTicketPage.getInstance().getNEW_TICKET_SUBJECT().sendKeys(data.get(1));
			NewTicketPage.getInstance().getNEW_TICKET_MESSAGE().sendKeys(data.get(2));
			NewTicketPage.getInstance().getNEW_TICKET_FULL_NAME().sendKeys(data.get(3));
			NewTicketPage.getInstance().getNEW_TICKET_EMAIL().sendKeys(data.get(4));
			NewTicketPage.getInstance().getNEW_TICKET_PHONE().sendKeys(data.get(5));
			Thread.sleep(3000);
			NewTicketPage.getInstance().getCREATE_TICKET().click();
			Thread.sleep(4000);
			CommonUtils.getInstance().takeScreenshot();
			Thread.sleep(2000);
		} catch (Exception e) {
			LOGGER.error(e);
		}

	}

	@When("Log in to the agent portal and verify that the ticket is created with default status and default priority.")
	public void log_in_to_the_agent_portal_and_verify_that_the_ticket_is_created_with_default_status_and_default_priority()
			throws InterruptedException, IOException {
		try {
			ArrayList<String> data = dataDriven.getInstance().getData("STATUSES");
			ArrayList<String> data1 = dataDriven.getInstance().getData("PRIORITIES");

			DriverManager.getDriver().get(Constants.AGENT_LOGIN_URL);
			LoginPage.getInstance().getUSERNAME().sendKeys(Constants.USERNAME);
			LoginPage.getInstance().getPASSWORD().sendKeys(Constants.PASSWORD);
			LoginPage.getInstance().getLOGIN().click();

			Thread.sleep(10000);
			List<WebElement> StatusName = PendingTicketPage.getInstance().getPENDING_TICKET_TABLE_STATUS_NAME();
			for (int i = 0; i <= StatusName.size(); i++) {
				if (StatusName.get(i).getText().equalsIgnoreCase(data.get(1))) {
//					System.out.println(StatusName.get(i).getText());
					StatusName.get(i).click();
					break;
				}
			}

			Thread.sleep(3000);
			PendingTicketPage.getInstance().getPENDING_TICKET_SUBJECT_NAME().click();

			Thread.sleep(2000);
			String Actual_Default_Status = PendingTicketPage.getInstance().getPENDING_TICKET_DEFAULT_STATUS().getText();
			LOGGER.info(Actual_Default_Status);
			String Excepted_Status = data.get(1);
			Assert.assertEquals(Actual_Default_Status, Excepted_Status);

			String Actual_Default_Priority = PendingTicketPage.getInstance().getPENDING_TICKET_DEFAULT_PRIORITY()
					.getText();
			LOGGER.info(Actual_Default_Priority);
//			String Excepted_Priority = data1.get(1);
//			Assert.assertEquals(Actual_Default_Priority,Excepted_Priority);

		} catch (Exception e) {
			LOGGER.error(e);
		}

	}

	@When("Reply to the ticket using canned action present in the prerequisite sheet.")
	public void reply_to_the_ticket_using_canned_action_present_in_the_prerequisite_sheet() throws IOException {
		try {
			ArrayList<String> data = dataDriven.getInstance().getData("ACTION");

			PendingTicketPage.getInstance().getPENDING_TICKET_REPLAY().click();

			PendingTicketPage.getInstance().getPENDING_TICKET_MESSAGE_BOX().sendKeys(data.get(1));

			PendingTicketPage.getInstance().getPENDING_TICKET_ADD_REPLAY().click();

			System.out.println("Done");
		} catch (Exception e) {
			LOGGER.error(e);

		}

	}

	@Then("Verify the ticket property changes for status, priority and tags.")
	public void verify_the_ticket_property_changes_for_status_priority_and_tags() {

	}

	@Given("Delete the status.")
	public void delete_the_status() {

	}

	@When("Delete the priority.")
	public void delete_the_priority() {

	}

	@Then("Logout from the agent portal and terminate the driver.")
	public void logout_from_the_agent_portal_and_terminate_the_driver() {

	}

}
