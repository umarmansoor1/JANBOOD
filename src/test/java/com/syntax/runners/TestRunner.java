package com.syntax.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
<<<<<<< HEAD
@CucumberOptions(features= {"src/test/resources/features/Report.feature"}
=======
@CucumberOptions(features= {"src/test/resources/features"}
>>>>>>> branch 'master' of https://github.com/umarmansoor1/JANBOOD.git
				, glue= {"com/syntax/stepDefinitions"}
				, dryRun=false)

public class TestRunner {

}
