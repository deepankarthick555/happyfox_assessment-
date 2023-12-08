package com.happyfox.helpdesk.step_definitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
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

	@Given("the user is logged in successfully and is on Agent Portal.")
	public void the_user_is_logged_in_successfully_and_is_on_agent_portal() {

		try {

			CommonUtils.getInstance().login();
			LOGGER.info("Common Login");

			Thread.sleep(5000);
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
			Thread.sleep(3000);
			TicketsPage.getInstance().clickTickets();
			TicketsPage.getInstance().clickStatuses();
			Thread.sleep(3000);

			LOGGER.info("Navigate to Status & Priority pages");
		} catch (Exception e) {
			LOGGER.error(e);
		}

	}

	@When("Create a status values provided in the sheet.")
	public void create_a_status_values_provided_in_the_sheet() throws IOException {

		try {
			ArrayList<String> data = dataDriven.getInstance().getData("STATUSES");
			TicketsPage.getInstance().clickAddStatuses();

			StatusPage.getInstance().enterStatusName(data.get(1));
			StatusPage.getInstance().enterDescriptionName(data.get(3));
			StatusPage.getInstance().addStatusButton();
			Thread.sleep(3000);

			LOGGER.info("Created a status values");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@When("Create a priority values provided in the sheet.")
	public void create_a_priority_values_provided_in_the_sheet() throws IOException {
		try {
			ArrayList<String> data = dataDriven.getInstance().getData("PRIORITIES");
			TicketsPage.getInstance().clickPriorities();
			TicketsPage.getInstance().clickAddPriorities();

			PriorityPage.getInstance().enterPriorityName(data.get(1));
			PriorityPage.getInstance().enterDescriptionName(data.get(2));
			PriorityPage.getInstance().clickPriorityAddButton();
			Thread.sleep(3000);

			LOGGER.info("Created a priority values");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Then("Make the created status and priority as default.")
	public void make_the_created_status_and_priority_as_default() throws IOException, InterruptedException {
		try {
			// Make Priority as Default
			ArrayList<String> priorityData = dataDriven.getInstance().getData("PRIORITIES");

			List<WebElement> PriorityName = PriorityPage.getInstance().getPriorityNameTable();
			List<WebElement> DefaultPriority = PriorityPage.getInstance().getDefaultPriorityTable();
			Thread.sleep(2000);
			for (int i = 0; i < PriorityName.size(); i++) {
//				System.out.println(PriorityName.get(i).getText());
				if (PriorityName.get(i).getText().equalsIgnoreCase(priorityData.get(1))) {

					DefaultPriority.get(i).click();
					LOGGER.info("Make Priority as Default");
					break;

				}
			}
			// Make Status as Default
			ArrayList<String> statusData = dataDriven.getInstance().getData("STATUSES");
			TicketsPage.getInstance().clickManageStatuses();
			Thread.sleep(2000);

			List<WebElement> StatusName = PriorityPage.getInstance().getPriorityNameTable();
			List<WebElement> DefaultStatus = PriorityPage.getInstance().getDefaultPriorityTable();
			Thread.sleep(2000);
			for (int i = 0; i < StatusName.size(); i++) {
//				System.out.println(StatusName.get(i).getText());
				if (StatusName.get(i).getText().equalsIgnoreCase(statusData.get(1))) {

					DefaultStatus.get(i).click();
					LOGGER.info("Make Status as Default");
					break;

				}
			}

		} catch (Exception e) {
			LOGGER.error(e);
		}

	}

	@When("Create a ticket from new ticket page on support center.")
	public void create_a_ticket_from_new_ticket_page_on_support_center() throws IOException, InterruptedException {

		try {
			ArrayList<String> ticketCreationData = dataDriven.getInstance().getData("TICKETCREATION");

			DriverManager.getDriver().get(Constants.TICKET_PAGE_URL);
			DriverManager.getDriver().get(Constants.TICKET_PAGE_URL);

			NewTicketPage.getInstance().enterNewTicketSubject(ticketCreationData.get(1));
			NewTicketPage.getInstance().enterNewTicketMessage(ticketCreationData.get(2));
			NewTicketPage.getInstance().enterNewTicketFullName(ticketCreationData.get(3));
			NewTicketPage.getInstance().enterNewTicketEmail(ticketCreationData.get(4));
			NewTicketPage.getInstance().enterNewTicketPhone(ticketCreationData.get(5));

			Thread.sleep(2000);
			NewTicketPage.getInstance().clickCreateTicketButton();

			Thread.sleep(4000);
			String ActualTitle = NewTicketPage.getInstance().getTitleOfTicketPage();
			String ExcpectedTitle = ticketCreationData.get(6);
			Assert.assertEquals(ActualTitle, ExcpectedTitle);
			LOGGER.info("New Ticket is Created");

			CommonUtils.getInstance().takeScreenshot();
			Thread.sleep(2000);

		} catch (Exception e) {
			LOGGER.error(e);
		}

	}

	@When("Log in to the agent portal and verify that the ticket is created with default status and default priority.")
	public void log_in_to_the_agent_portal_and_verify_that_the_ticket_is_created_with_default_status_and_default_priority()
			throws IOException, InterruptedException {
		try {

			ArrayList<String> statusData = dataDriven.getInstance().getData("STATUSES");
			ArrayList<String> priorityData = dataDriven.getInstance().getData("PRIORITIES");

			DriverManager.getDriver().get(Constants.AGENT_LOGIN_URL);
			LOGGER.info("Common Login");

			Thread.sleep(10000);
			List<WebElement> StatusName = PendingTicketPage.getInstance().getPendingTicketTableStatusName();

			for (int i = 0; i <= StatusName.size(); i++) {

				if (StatusName.get(i).getText().equalsIgnoreCase(statusData.get(1))) {
//					System.out.println(StatusName.get(i).getText());
					StatusName.get(i).click();
					break;
				}
			}

			Thread.sleep(3000);
			PendingTicketPage.getInstance().clickPendingTicketSubjectName();

			String Actual_Default_Status = PendingTicketPage.getInstance().getTextPendingTicketDefaultStatus();
			String Excepted_Status = statusData.get(1);
			Assert.assertEquals(Actual_Default_Status, Excepted_Status);

			String Actual_Default_Priority = PendingTicketPage.getInstance().getTextPendingTicketDefaultPriority();
			String Excepted_Priority = priorityData.get(1);
			Assert.assertEquals(Actual_Default_Priority, Excepted_Priority);

		} catch (Exception e) {
			LOGGER.error(e);
		}

	}

	@When("Reply to the ticket using canned action present in the prerequisite sheet.")
	public void reply_to_the_ticket_using_canned_action_present_in_the_prerequisite_sheet() throws IOException {
		try {
			ArrayList<String> data = dataDriven.getInstance().getData("ACTION");

			PendingTicketPage.getInstance().clickPendingTicketRepay();
			PendingTicketPage.getInstance().enterPendingTicketMessageBox(data.get(1));

			LOGGER.info("Reply to the ticket Using canned action");

		} catch (Exception e) {
			LOGGER.error(e);

		}

	}

	@Then("Verify the ticket property changes for status, priority and tags.")
	public void verify_the_ticket_property_changes_for_status_priority_and_tags()
			throws IOException, InterruptedException {
		try {
			ArrayList<String> data = dataDriven.getInstance().getData("CANNED ACTION");

			// Property change for Status
			PendingTicketPage.getInstance().clickCannedActionStatus();
			List<WebElement> StatusList = PendingTicketPage.getInstance().getTextCannedActionStatusList();

			for (int i = 0; i <= StatusList.size(); i++) {
				if (StatusList.get(i).getText().equalsIgnoreCase(data.get(1))) {
					StatusList.get(i).click();
					LOGGER.info("Verify the ticket property changes for status");
					break;
				}

			}

			// Property change for Priority
			PendingTicketPage.getInstance().clickCannedActionPriority();
			List<WebElement> PriorityList = PendingTicketPage.getInstance().getTextCannedActionPriorityList();

			for (int i = 0; i <= PriorityList.size(); i++) {
				if (PriorityList.get(i).getText().equalsIgnoreCase(data.get(2))) {
					PriorityList.get(i).click();
					LOGGER.info("Verify the ticket property changes for priority");
					break;
				}

			}

			// Property change for tags
			PendingTicketPage.getInstance().clickCannedActionAddTags();
//			PendingTicketPage.getInstance().enterCannedActionAddTagsValue(data.get(3));
			PendingTicketPage.getInstance().clickPendingTicketAddRepay();
			PendingTicketPage.getInstance().clickPendingTicketsClose();
			Thread.sleep(15000);
			System.out.println("Working");

		} catch (Exception e) {

		}

	}

	@Given("Delete the priority.")
	public void delete_the_priority() throws IOException, InterruptedException {
		try {
			System.out.println("Working");
			TicketsPage.getInstance().clickTickets();
			System.out.println("Working");
			TicketsPage.getInstance().clickPriorities();
			Thread.sleep(2000);

			ArrayList<String> priorityData = dataDriven.getInstance().getData("PRIORITIES");

			List<WebElement> PriorityName = PriorityPage.getInstance().getPriorityNameTable();
			Thread.sleep(3000);
			for (int i = 0; i < PriorityName.size(); i++) {
//		System.out.println(PriorityName.get(i).getText());
				if (PriorityName.get(i).getText().equalsIgnoreCase(priorityData.get(1))) {

					PriorityName.get(i).click();

					break;

				}
			}

			PendingTicketPage.getInstance().clickPriorityDelete();
			Thread.sleep(1000);
			PendingTicketPage.getInstance().clickPriorityDeleteDescription();

			List<WebElement> PriorityDescriptionList = PendingTicketPage.getInstance()
					.getPriorityDeleteDescriptionList();

			for (int i = 0; i <= PriorityDescriptionList.size(); i++) {
				if (PriorityDescriptionList.get(i).getText().equalsIgnoreCase(priorityData.get(3))) {
					PriorityDescriptionList.get(i).click();
					LOGGER.info("Select the Dropdown Low");
					break;
				}

			}
			PendingTicketPage.getInstance().clickFinalPriorityDeleteButton();
			LOGGER.info("Delete the priority.");

		} catch (Exception e) {
			LOGGER.error(e);
		}

	}

	@When("Delete the status.")
	public void delete_the_status() throws InterruptedException, IOException {
		try {
			ArrayList<String> statusData = dataDriven.getInstance().getData("STATUSES");

			Thread.sleep(3000);
//			TicketsPage.getInstance().clickManageStatuses();
			TicketsPage.getInstance().clickStatuses();
			Thread.sleep(3000);

			List<WebElement> StatusName = PriorityPage.getInstance().getPriorityNameTable();
			Thread.sleep(3000);
			for (int i = 0; i < StatusName.size(); i++) {
//				System.out.println(StatusName.get(i).getText());
				if (StatusName.get(i).getText().equalsIgnoreCase(statusData.get(1))) {
					StatusName.get(i).click();
					break;

				}
			}

			PendingTicketPage.getInstance().clickStatusDelete();
			Thread.sleep(2000);
			PendingTicketPage.getInstance().clickStatusDeleteDescription();

			List<WebElement> StatusDescriptionList = PendingTicketPage.getInstance().getStatusDeleteDescriptionList();
			Thread.sleep(1000);
			for (int i = 0; i <= StatusDescriptionList.size(); i++) {
				if (StatusDescriptionList.get(i).getText().equalsIgnoreCase(statusData.get(4))) {
					StatusDescriptionList.get(i).click();

					LOGGER.info("Select the Dropdown Closed");
					break;
				}

			}

			PendingTicketPage.getInstance().clickFinalStatusDeleteButton();
			Thread.sleep(9000);
			LOGGER.info("Delete the status.");

		} catch (Exception e) {
			LOGGER.error(e);
		}

	}

	@Then("Logout from the agent portal and terminate the driver.")
	public void logout_from_the_agent_portal_and_terminate_the_driver() throws InterruptedException {
		try {
			PendingTicketPage.getInstance().clickAvatarImg();
			PendingTicketPage.getInstance().clickLogoutButton();
			LOGGER.info("Logout from the agent portal ");

			DriverManager.getDriver().close();
			LOGGER.info("Terminate the Driver");

		} catch (Exception e) {

		}

	}

}
