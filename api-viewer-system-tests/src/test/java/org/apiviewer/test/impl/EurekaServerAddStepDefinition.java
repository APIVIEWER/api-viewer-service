package org.apiviewer.test.impl;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author hitesh.bargujar
 *
 */
public class EurekaServerAddStepDefinition {

	@When("^I add Eureka server with NICKNAME \"(.*?)\", " + "IPADDRESS \"(.*?)\" " + "and PORT \"(.*?)\"$")
	public void iaddEurekaserverwithNICKNAMEIPADDRESSandPORT(String arg1, String arg2, String arg3) throws Throwable {

	}

	@Then("^I receive a link in location header for added Eureka Server$")
	public void ireceivealinkinlocationheaderforaddedEurekaServer() throws Throwable {

	}

	@Then("^I can retrieve the added Eureka Server$")
	public void icanretrievetheaddedEurekaServer() throws Throwable {

	}
}
