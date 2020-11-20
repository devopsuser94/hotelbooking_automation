package stepdefs;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.cucumber.listener.Reporter;

import base.testBase;
import commonUtil.Utility;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import pages.BookingSuccessPage;
import pages.HotelBookingPage;
import pages.LoginPage;

public class HotelBookingStepDefs extends testBase {
	
	@Before
	public void beforeScenario(Scenario scenario) {
	Reporter.assignAuthor("Selenium Assignment - Sayantan Paul");
	}
	
	LoginPage loginpage;
	HotelBookingPage hotelbookingpage;
	BookingSuccessPage bookingsuccesspage;
	Utility utility;
	
	@Given("^User is on login page$")
	public void user_is_on_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    testBase.initialize();
	}
	
	@Then("^User validates the login page heading$")
	public void user_validates_the_login_page_heading() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   loginpage= new LoginPage();
	   String header = loginpage.validateLoginPageHeader();
	   System.out.println("Login Page Heading is: "+ header);
	   Assert.assertEquals(header, "Hotel Booking Application");
	}

	@Then("^user validates the negative login scenario$")
	public void user_validates_the_negative_login_scenario() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    boolean usernameError = loginpage.validateusernameError();
	    Assert.assertTrue(usernameError);
	    boolean pwdError = loginpage.validatepwdError(prop.getProperty("invaliduname"));
	    Assert.assertTrue(pwdError);
	    
	}

	@When("^User enters login credentials$")
	public void user_enters_login_credentials(DataTable data) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions	
		List<Map<String, String>> cred= data.asMaps(String.class, String.class);
		loginpage.enterUsername(cred.get(0).get("username"));
		loginpage.enterPassword(cred.get(0).get("password"));
		Thread.sleep(2000);
		loginpage.login();
		String usermsg= loginpage.confirmLogin();
		System.out.println("Usermsg is: "+ usermsg);    
	}

	@Then("^User is on Hotel Booking page$")
	public void user_is_on_Hotel_Booking_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		hotelbookingpage = new HotelBookingPage();
		
		String pageTitle= hotelbookingpage.validatePageTitle();
		System.out.println("Page Title is: "+ pageTitle);
		Assert.assertEquals(pageTitle, "Hotel Booking");

	}

	@Then("^User validates first name field and enters value$")
	public void user_validates_first_name_field_and_enters_value() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String validatefirstname= hotelbookingpage.validateField();
		System.out.println("Alert is: "+ validatefirstname);
		Assert.assertEquals(validatefirstname, "Please fill the First Name");
		hotelbookingpage.enterFname(prop.getProperty("firstname"));

	}

	@Then("^User validates last name field and enters value$")
	public void user_validates_last_name_field_and_enters_value() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String validatelastname= hotelbookingpage.validateField();
		System.out.println("Alert is: "+ validatelastname);
		Assert.assertEquals(validatelastname, "Please fill the Last Name");
		hotelbookingpage.enterLname(prop.getProperty("lastname"));

	}

	@Then("^User validates email field and enteres value$")
	public void user_validates_email_field_and_enteres_value() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    String validateEmail= hotelbookingpage.validateField();
	    System.out.println("Alert is: "+ validateEmail);
		Assert.assertEquals(validateEmail, "Please fill the Email");
	
		String validateWrongEmail= hotelbookingpage.validateEmail(prop.getProperty("invalidemail"));
	    System.out.println("Alert is: "+ validateWrongEmail);
		Assert.assertEquals(validateWrongEmail, "Please enter valid Email Id.");
		hotelbookingpage.enterEmail(prop.getProperty("email"));
	    
	}

	@Then("^User validates mobile number field and enters value$")
	public void user_validates_mobile_number_field_and_enters_value() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String validateBlankPhone= hotelbookingpage.validateField();
	    System.out.println("Alert is: "+ validateBlankPhone);
		Assert.assertEquals(validateBlankPhone, "Please fill the Mobile No.");
		
		String validateWrongPhone= hotelbookingpage.validatePhone(prop.getProperty("invalidphonenumber"));
	    System.out.println("Alert is: "+ validateWrongPhone);
		Assert.assertEquals(validateWrongPhone, "Please enter valid Contact no.");
		hotelbookingpage.enterPhone(prop.getProperty("phonenumber"));
	    
	}

	@Then("^User validates Address field and enters value$")
	public void user_validates_Address_field_and_enters_value() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    hotelbookingpage.enterAddress(prop.getProperty("address"));
	}

	@Then("^User validates City field and selects value$")
	public void user_validates_City_field_and_selects_value() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    String validatecity= hotelbookingpage.validateField();
	    System.out.println("Alert is: "+ validatecity);
	    Assert.assertEquals(validatecity, "Please select city");
	    hotelbookingpage.enterCity(prop.getProperty("city"));
	}

	@Then("^User validates State field and selects value$")
	public void user_validates_State_field_and_selects_value() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    String validatestate= hotelbookingpage.validateField();
	    System.out.println("Alert is: "+ validatestate);
	    Assert.assertEquals(validatestate, "Please select state");
	    hotelbookingpage.enterState(prop.getProperty("state"));
	}

	@Then("^User validates Guest Number field and enters value$")
	public void user_validates_Guest_Number_field_and_enters_value() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    hotelbookingpage.enterGuestNumber(prop.getProperty("guestnumber"));
	}

	@Then("^User validates Card Holder Name field and enters value$")
	public void user_validates_Card_Holder_Name_field_and_enters_value() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    String validatecardholdername= hotelbookingpage.validateField();
	    System.out.println("Alert is: "+ validatecardholdername);
	    Assert.assertEquals(validatecardholdername, "Please fill the Card holder name");
	    hotelbookingpage.enterCardHolderName(prop.getProperty("cardholdername"));
	}

	@Then("^user validates Debit Card Number field and enters value$")
	public void user_validates_Debit_Card_Number_field_and_enters_value() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    String validatedebitcardnumber= hotelbookingpage.validateField();
	    System.out.println("Alert is: "+ validatedebitcardnumber);
	    Assert.assertEquals(validatedebitcardnumber, "Please fill the Debit card Number");
	    hotelbookingpage.enterCardNumber(prop.getProperty("cardnumber"));
	}

	@Then("^User validates CVV field and enters value$")
	public void user_validates_CVV_field_and_enters_value() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    String validatecvvNumber= hotelbookingpage.validateField();
	    System.out.println("Alert is: "+ validatecvvNumber);
	    Assert.assertEquals(validatecvvNumber, "Please fill the CVV");
	    hotelbookingpage.enterCVV(prop.getProperty("cvvnumber"));
	}

	@Then("^User validates Expiration month field and enters value$")
	public void user_validates_Expiration_month_field_and_enters_value() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    String validateexpMonth= hotelbookingpage.validateField();
	    System.out.println("Alert is: "+ validateexpMonth);
	    Assert.assertEquals(validateexpMonth, "Please fill expiration month");
	    hotelbookingpage.enterExpMonth(prop.getProperty("expmonth"));
	}

	@Then("^User validates Expiration year field and enters value$")
	public void user_validates_Expiration_year_field_and_enters_value() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    String validateexpYear= hotelbookingpage.validateField();
	    System.out.println("Alert is: "+ validateexpYear);
	    Assert.assertEquals(validateexpYear, "Please fill the expiration year");
	    hotelbookingpage.enterExpYear(prop.getProperty("expyear"));
	}

	@When("^User clicks on Confirm booking$")
	public void user_clicks_on_Confirm_booking() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		hotelbookingpage.confirmBooking();
		Thread.sleep(2000);
	    
	}

	@Then("^successful message displayed$")
	public void successful_message_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		bookingsuccesspage= new BookingSuccessPage();
	    String successmessage= bookingsuccesspage.validateSuccessfulBooking();
	    System.out.println("Success Message is: "+ successmessage);
	    Assert.assertEquals(successmessage, "Booking Completed!");
	}

	@Then("^User closes the browser$")
	public void user_closes_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//		driver.close();
	 
	}
	
	@After(order = 1)
	public void afterScenario(Scenario scenario) throws IOException {	
		utility= new Utility();
		Reporter.addScenarioLog("In case of failure takes screenshot");
		if(scenario.isFailed()) {
			utility.takeScreenshot(scenario);
		}

     }
	
	@After(order = 0)
	public void closebrowser() {
		driver.quit();
	}
}
