
Feature: This feature is to Verifying the HappyFox Help Desk product.

@TestRun1 @TestRun2
Scenario: This test is to login agent portal and Create the Statuses and Priorities.
	Given the user is logged in successfully and is on Agent Portal.
	When Navigate to Status/Priority pages from the Menu on the top left corner.
	And Create a status values provided in the sheet.
	And Create a priority values provided in the sheet.
	 
	
		
@TestRun2 @TestRun3
Scenario: This test is to Create a ticket and reply to the ticket
	Given Make the created status and priority as default.
	When Create a ticket from new ticket page on support center.
	And Log in to the agent portal and verify that the ticket is created with default status and default priority.
	And Reply to the ticket using canned action present in the prerequisite sheet.
	Then Verify the ticket property changes for status, priority and tags.
	
@TestRun1 @TestRun2
Scenario: This test is to Delete status and priority
	Given Delete the priority. 
	When Delete the status.
	Then Logout from the agent portal and terminate the driver.
	
	