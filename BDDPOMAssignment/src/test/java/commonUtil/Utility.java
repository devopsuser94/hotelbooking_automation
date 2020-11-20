package commonUtil;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;

import base.testBase;
import cucumber.api.Scenario;

public class Utility extends testBase {
	
	public void takeScreenshot(Scenario scenario) throws IOException {
		String screenshotname= scenario.getName().replaceAll("", "_");
		File srcPath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destPath= new File(System.getProperty("user.dir")+"//target//cucumber-extent-report//Screenshot//"+screenshotname+".png");
		FileUtils.copyFile(srcPath, destPath);
		Reporter.addScreenCaptureFromPath(destPath.toString());
	}

}
