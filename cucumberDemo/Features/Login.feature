Feature: Login

@sanity
Scenario: Successful login with the valid credentials

Given User Launch Chrome Browser
When User Opens Url "http://admin-demo.nopcommerce.com"
And user enters email as "admin@yourstore.com" and password as "admin"
And user clicks on login button
Then Page title should be "Dashboard / nopCommerce administration"
When user clicks on Logout 
Then Title of the page should be "Your store. Login"
And user close the browser

@regression
Scenario Outline: Successful login with the valid credentials

Given User Launch Chrome Browser
When User Opens Url "http://admin-demo.nopcommerce.com"
And user enters email as "<email>" and password as "<password>"
And user clicks on login button
Then Page title should be "Dashboard / nopCommerce administration"
When user clicks on Logout 
Then Title of the page should be "Your store. Login"
And user close the browser

Examples:
       |email              |password    |
       |admin@yourstore.com|admin       |
       |admin@yourstore.com|admin123    |
