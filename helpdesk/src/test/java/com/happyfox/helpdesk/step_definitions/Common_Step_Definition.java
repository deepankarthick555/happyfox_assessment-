package com.happyfox.helpdesk.step_definitions;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.happyfox.helpdesk.testdata.dataDriven;
import com.happyfox.helpdesk.utilities.CommonUtils;
import com.happyfox.helpdesk.webdriver_manager.DriverManager;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Common_Step_Definition {

	private static String scenarioName=null;
	
	
	
	public static String getScenarioName() {
		return scenarioName;
	}

	private static final Logger LOGGER= LogManager.getLogger(Common_Step_Definition.class);

	@Before
	public void beforeScenario(Scenario scenario) {
		LOGGER.info("Executed Started");
		
		try {
			scenario.getName();
			LOGGER.info("Instantiation the CommonUtils");
		
			LOGGER.info("Logging the Properties File");
			CommonUtils.getInstance().loadProperties();

			LOGGER.info("Checking Driver is NULL or NOT?");
			if (DriverManager.getDriver() == null) {
				LOGGER.info("Instantiation launchbrowser");
				DriverManager.launchbrowser();
				CommonUtils.getInstance().initWebElements();
				
				DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				
				
			}

		} catch (Exception e) {
			LOGGER.error(e);
		}
	}
}
