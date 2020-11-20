package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.testBase;

public class BookingSuccessPage extends testBase{
	
	@FindBy(xpath="//h1[text()='Booking Completed!']")
	WebElement bookingsuccess;
	
	public BookingSuccessPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateSuccessfulBooking() {
		String bookingconfirmation= bookingsuccess.getText();
		return bookingconfirmation;
	}

}
