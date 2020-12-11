package TestRunner;



import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"},
		
		 monochrome = true,	
		 features = "src/test/java/Features",
		 glue = "stepDefinitions"
		 		
		 )

public class TestRunner {
	@AfterClass
	public static void setup()
	{
	Reporter.loadXMLConfig(new File("src/test/java/resources/extent-config.xml"));
	Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
		Reporter.setSystemInfo("Application Name", "SaleSForce ");
	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	Reporter.setSystemInfo("Environment", "Testing");
	Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	}
}
