package com.happyfox.helpdesk.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:/features",
		glue= "com.happyfox.helpdesk.step_definitions",
		dryRun = false,
		monochrome= true,
		tags ="@TestRun2",
		plugin ={"pretty", "html:target/cucumber.html", "json:target/cucumber.json"}
		)
public class TestRunner {

}

