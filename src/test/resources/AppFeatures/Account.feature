Feature: Account Page feature

  Background: 
    Given User already logged into the application
    | UserName  | Password | 
    | ajaykumar.kumar937@gmail.com | Adda@1234 |


  Scenario: Account Page title
     Given user is on account page
     When user gets the title of the page
     Then page title should be "My account - My Store"


  Scenario: MY ACCOUNT section count
    Given user is on account page
    Then user gets the account section
    |ORDER HISTORY AND DETAILS|
    |MY CREDIT SLIPS|
    |MY ADDRESSES|
    |MY PERSONAL INFORMATION|
    |MY WISHLISTS|

