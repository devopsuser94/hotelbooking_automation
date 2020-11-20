package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src//test//java//features//hotelbooking.feature",
		glue= {"stepdefs"},
		monochrome= true,
		dryRun= false,
		strict= false,
		plugin = { "pretty",
				"com.cucumber.listener.ExtentCucumberFormatter:target//cucumber-extent-report//ExtentReport.html"})

public class HotelBookingRunner {
	
    @AfterClass
	public static void writeExtentReport(){
		Reporter.loadXMLConfig(new File("src//test//resources//extent-config.xml"));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Application name", "Sample Test App");
		Reporter.setSystemInfo("Operating System", System.getProperty("os.name").toString());
		Reporter.setSystemInfo("Environment", "Testing Server");
	}

}
