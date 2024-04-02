package cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/Features"
						
		},
glue= {"stepDefinations"},
dryRun =false,
monochrome=true,

 plugin= {"pretty", "html:Report/report.html",
		 "json:Report/report.json",
			"junit:Report/report.xml",
			 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
             "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}  )
		 //"json:target/edge.json",)

public class TestRunner {
	
	

}
