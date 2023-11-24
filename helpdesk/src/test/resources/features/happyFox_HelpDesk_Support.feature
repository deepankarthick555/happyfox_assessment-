@SanityTest
Feature: This feature is to Verifying the HappyFox Help Desk product.

Scenario: This test is to login agent portal and Create the Statuses and Priorities.
	Given the user is logged in successfully and is on Agent Portal.
	When Navigate to Status/Priority pages from the Menu on the top left corner.
	And Create a status values provided in the sheet.
	And Create a priority values provided in the sheet.
	Then Make the created status and priority as default.
		
@SanityTest
Scenario: This test is to Create a ticket and reply to the ticket
	Given Create a ticket from new ticket page on support center.
	When Log in to the agent portal and verify that the ticket is created with default status and default priority.
	And Reply to the ticket using canned action present in the prerequisite sheet.
	Then Verify the ticket property changes for status, priority and tags.
	
@SanityTest
Scenario: This test is to Delete status and priority
	Given Delete the status. 
	When  Delete the priority.
	Then Logout from the agent portal and terminate the driver.
	
	
	
	