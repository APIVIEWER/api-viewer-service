package org.apiviewer.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author hitesh.bargujar
 *
 */
@RunWith(value = Cucumber.class)
@CucumberOptions(format = {"pretty", "json:build/testReports"},
        features = {"src/test/resources"})
public class ApiViewerCucumberRunner {

}
