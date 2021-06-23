
Feature: Login Page feature
 
  Scenario: Login Page Title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Login - My Store"
    
  Scenario: Forget password link
    Given user is on login page
    Then forget your password link should be displayed

  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username  "ajaykumar.kumar937@gmail.com"
    And user enters password  "Adda@1234"
		And user click on Login button
		Then user gets the title of the page
		And page title should be "My account - My Store"
		
	Scenario: Login with wrong credentials
	Given user is on login page
	When user enters username  "ajaykumar.k7@gmail1.com"
  And user enters password  "Adda@12341"
	And user click on Login button
	Then user gets the AuthenticationFailedMsg "Authentication failed."
