Feature: Online Hotel Booking Feature

Scenario: User can book hotel online

Given User is on login page
Then User validates the login page heading
Then user validates the negative login scenario
When User enters login credentials
|username|password|
|admin|admin|
Then User is on Hotel Booking page
Then User validates first name field and enters value
Then User validates last name field and enters value
Then User validates email field and enteres value
Then User validates mobile number field and enters value
Then User validates Address field and enters value
Then User validates City field and selects value
Then User validates State field and selects value
Then User validates Guest Number field and enters value
Then User validates Card Holder Name field and enters value
Then user validates Debit Card Number field and enters value
Then User validates CVV field and enters value
Then User validates Expiration month field and enters value
Then User validates Expiration year field and enters value
When User clicks on Confirm booking
Then successful message displayed
Then User closes the browser