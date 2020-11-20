package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.testBase;

public class LoginPage extends testBase {
	
	Alert alert;
	
	@FindBy(name="userName")
	WebElement userName;
	
	@FindBy(name="userPwd")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//h1[text()=' Hotel Booking Application ']")
	WebElement pageHeading;
	
	@FindBy(id="userErrMsg")
	WebElement usernameError;
	
	@FindBy(id="pwdErrMsg")
	WebElement pwdError;
	
	@FindBy(xpath="//h2[text()='Hotel Booking Form']")
	WebElement homepageText;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String validateLoginPageHeader() {
		String loginpageHeading= pageHeading.getText();
		return loginpageHeading;
	}
	
	public boolean validateusernameError() {
		loginBtn.click();
		boolean usernameErr= usernameError.isDisplayed();
		return usernameErr;
	}
	
	public void enterUsername(String username) {
		userName.clear();
		userName.sendKeys(username);
	}
	public boolean validatepwdError(String uname) {
		userName.sendKeys(uname);
		loginBtn.click();
		boolean pwdErrormsg= pwdError.isDisplayed();
		return pwdErrormsg;
	}
	public void enterPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void login() {
		loginBtn.click();
	}
	
	public String confirmLogin() {
		String usermsg = "";
		try {
		if(driver.getTitle().equalsIgnoreCase("Hotel Booking")) {
		usermsg= homepageText.getText();
		System.out.println("Message is: "+ usermsg);
		}
		
		else{
		alert= driver.switchTo().alert();
		System.out.println("Alert is: "+alert.getText());
		usermsg= alert.getText();
		System.out.println("Message is: "+ usermsg);
		alert.accept();
		}
		

		
		
		
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return usermsg;
	}

}
