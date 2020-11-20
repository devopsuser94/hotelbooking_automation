package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.testBase;

public class HotelBookingPage extends testBase {
	
	Alert alert;
	
	@FindBy(xpath="//h2[text()='Hotel Booking Form']")
	WebElement pageHeader;
	
	@FindBy(id="txtFirstName")
	WebElement firstName;
	
	@FindBy(id="txtLastName")
	WebElement lastName;
	
	@FindBy(id="txtEmail")
	WebElement emailAddress;
	
	@FindBy(id="txtPhone")
	WebElement phoneno;
	
	@FindBy(xpath="//textarea[@rows='5']")
	WebElement address;
	
	@FindBy(xpath="//Select[@name='city']")
	WebElement cityname;
	
	@FindBy(xpath="//Select[@name='state']")
	WebElement statename;
	
	@FindBy(xpath="//Select[@name='persons']")
	WebElement personsreqd;
	
	@FindBy(id="txtCardholderName")
	WebElement cardHolder;
	
	@FindBy(id="txtDebit")
	WebElement debitcardNumber;
	
	@FindBy(id="txtCvv")
	WebElement cvvNumber;
	
	@FindBy(id="txtMonth")
	WebElement expMonth;
	
	@FindBy(id="txtYear")
	WebElement expYear;
	
	@FindBy(id="btnPayment")
	WebElement confirmBooking;
	
	public HotelBookingPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public String validateField() {		
		confirmBooking.click();
		alert= driver.switchTo().alert();
//		System.out.println("Alert is: "+alert.getText());
		String alertmsg= alert.getText();
		alert.accept();
		
		return alertmsg;
	}
	
	public void enterFname(String fname) {
		firstName.clear();
		firstName.sendKeys(fname);
		
	}
	
	public void enterLname(String lname) {
		lastName.clear();
		lastName.sendKeys(lname);
	
	}
	
	public void enterEmail(String email) {
		emailAddress.clear();
		emailAddress.sendKeys(email);
	}
	
	public String validateEmail(String invalidemail) {
		emailAddress.sendKeys(invalidemail);
		confirmBooking.click();
		alert= driver.switchTo().alert();
		String alertmsg= alert.getText();
		alert.accept();
		return alertmsg;
	}
	
	public String validatePhone(String invalidphone) {
		phoneno.sendKeys(invalidphone);
		confirmBooking.click();
		alert= driver.switchTo().alert();
		String alertmsg= alert.getText();
		alert.accept();
		return alertmsg;
	}
	public void enterPhone(String phonenumber) {
		phoneno.clear();
		phoneno.sendKeys(phonenumber);
	}
	
	public void enterAddress(String addressfield) {
		address.clear();
		address.sendKeys(addressfield);
	}
	
	public void enterCity(String selectCity) {
		Select city= new Select(cityname);
		city.selectByValue(selectCity);
		
	}
	public void enterState(String selectState) {
		Select state= new Select(statename);
		state.selectByValue(selectState);
	}
	public void enterGuestNumber(String guestno) {
		Select guest= new Select(personsreqd);
		guest.selectByValue(guestno);
	}
	
	public void enterCardHolderName(String cardHolderName) {
		cardHolder.clear();
		cardHolder.sendKeys(cardHolderName);
	}
	
	public void enterCardNumber(String cardNumber) {
		debitcardNumber.clear();
		debitcardNumber.sendKeys(cardNumber);
	}
	public void enterCVV(String cvv) {
		cvvNumber.clear();
		cvvNumber.sendKeys(cvv);
	}
	
	public void enterExpMonth(String month) {
		expMonth.clear();
		expMonth.sendKeys(month);
	}
	
	public void enterExpYear(String year) {
		expYear.clear();
		expYear.sendKeys(year);
	}
	
	public void confirmBooking() {
		confirmBooking.click();
	}

}
