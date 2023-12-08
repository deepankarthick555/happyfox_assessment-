package com.happyfox.helpdesk.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import com.happyfox.helpdesk.constants.Constants;
import com.happyfox.helpdesk.page_objects.LoginPage;
import com.happyfox.helpdesk.page_objects.NewTicketPage;
import com.happyfox.helpdesk.page_objects.PendingTicketPage;
import com.happyfox.helpdesk.page_objects.PriorityPage;
import com.happyfox.helpdesk.page_objects.StatusPage;
import com.happyfox.helpdesk.page_objects.TicketsPage;
import com.happyfox.helpdesk.step_definitions.Common_Step_Definition;
import com.happyfox.helpdesk.webdriver_manager.DriverManager;

public class CommonUtils {

	private static CommonUtils commonUtilsInstance = null;

	private CommonUtils() {
	}

	public static CommonUtils getInstance() {
		if (commonUtilsInstance == null) {
			commonUtilsInstance = new CommonUtils();
		}
		return commonUtilsInstance;
	}

	public void loadProperties() {

		Properties properties = new Properties();

		try {

			properties.load(getClass().getResourceAsStream("/config.properties"));

		} catch (Exception e) {
			e.printStackTrace();

		}
		Constants.TICKET_PAGE_URL = properties.getProperty("TICKET_PAGE_URL");
		Constants.AGENT_LOGIN_URL = properties.getProperty("AGENT_LOGIN_URL");
		Constants.BROWSER = properties.getProperty("Browser");
		Constants.USERNAME = properties.getProperty("UserName");
		Constants.PASSWORD = properties.getProperty("Password");
		Constants.CHROME_DRIVER_LOCATION = properties.getProperty("CHROME_DRIVER_LOCATION");
		Constants.FIREFOX_DRIVER_LOCATION = properties.getProperty("FIREFOX_DRIVER_LOCATION");
		Constants.EDGE_DRIVER_LOCATION = properties.getProperty("EDGE_DRIVER_LOCATION");
		Constants.IE_DRIVER_LOCATION = properties.getProperty("IE_DRIVER_LOCATION");
	}

	public void initWebElements() {
		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), TicketsPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), StatusPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), PriorityPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), NewTicketPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), PendingTicketPage.getInstance());
	}

	public void login() {

		DriverManager.getDriver().get(Constants.AGENT_LOGIN_URL);

		LoginPage.getInstance().enterUserName(Constants.USERNAME);
		LoginPage.getInstance().enterPassword(Constants.PASSWORD);
		LoginPage.getInstance().clickLoginButton();

	}

	public void switchToNextTab(String tab1, String tab2) {
		Set<String> tabs = DriverManager.getDriver().getWindowHandles();
		Iterator<String> it = tabs.iterator();
		tab1 = it.next();
		tab2 = it.next();
		DriverManager.getDriver().switchTo().window(tab1);
		DriverManager.getDriver().close();
		DriverManager.getDriver().switchTo().window(tab2);
	}

	

	public void takeScreenshot() {
		File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

		try {

			FileUtils.copyFile(screenshot, new File(Common_Step_Definition.getScenarioName() + ".png"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
}
