package com.fourstay;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//This line will ensure that our test runs as Cucumber. 
//Without it, it will not see features file.
@RunWith(Cucumber.class)

//Here we use options to customize our test. By using tags, 
//we have control which tests to run. We use pretty to make our report look good. 
//And we provide path to the report file: target\html
@CucumberOptions(plugin={"pretty","html:target/html", "json:target/cucumber.json"}, tags={"@Test2, @Test1, @Test3"},			
				dryRun=false)

//tags={"@Regression","~@Test1"},

public class Runner {
	
}
