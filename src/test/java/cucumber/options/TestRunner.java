package cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/Features"
						//
						//"src/test/resources/Features/A_login.feature",
		                  // "src/test/resources/Features/B_batchUpdate.feature",
							//"src/test/resources/Features/K_user.feature",
							//"src/test/resources/Features/L_UserRoleProgramBatchMap.feature"
		},
glue= {"stepDefinations"},
dryRun =false,
monochrome=true,
//tags= "@batch",
 plugin= {"pretty", "html:Report/edge.html",
		 "json:Report/report.json",
			"junit:Report/report.xml",
			 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
             "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}  )
		 //"json:target/edge.json",)

public class TestRunner {
	
	

}
