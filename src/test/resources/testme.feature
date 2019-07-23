Feature: Testme Registration
@registration
  Scenario: registration
    Given the user is in the registration page of the browser application
    When username "Iornman0" ,firstname "tony" ,lastname "stark" ,password "password123" ,confirm password "password123" ,email "tonystark@gmail.com" ,mobilenumber "1234567890" ,DOB "07/22/1995" ,Address "5 NewYork USA" ,SecurityQuestion "Black" 
    Then user must be redirected to the login page
    
@login_outline
Scenario Outline: login 
Given User must be in the Login Page
When User must provide registered username credentials "<username>" and "<password>" and click Login
Then Login is done successfully and user is directed to the Home page
Examples:
|username||password|
|Lalitha||Password123|

@search
Scenario: Search
Given User must be in the Home Page
When User searches for a product in search engine
Then  the user should be in the search result page

@cart
Scenario: Cart
Given User must be in the search page
When try to proceed to payment without adding any item 
Then Testme app doesn't show the cart icon



    