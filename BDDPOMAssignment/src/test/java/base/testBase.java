package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import commonUtil.TestUtil;


public class testBase {
	
	public static Properties prop;
	public static WebDriver driver;
	
	public testBase() {
		
		prop = new Properties();
		FileInputStream fin;
		try {
			fin= new FileInputStream(System.getProperty("user.dir")+"//src//test//java//config//config.properties");
			prop.load(fin);
		}catch(FileNotFoundException e1) {
			e1.printStackTrace();	
		} 
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialize() {
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options;
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver_win32\\chromedriver.exe");
	        options = new ChromeOptions();
	        options.addArguments("start-maximized");
	        options.addArguments("disable-infobars");
	        options.addArguments("--disable-extensions");
		    
		    options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		    DesiredCapabilities caps = DesiredCapabilities.chrome();
		    caps.setCapability(ChromeOptions.CAPABILITY, options);
		    
			driver= new ChromeDriver(caps);
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options;
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\geckodriver\\geckodriver.exe");
	        options = new FirefoxOptions();
	        options.addArguments("start-maximized");
	        options.addArguments("--disable-extensions");
			driver= new ChromeDriver(options);
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

        }
	



}
