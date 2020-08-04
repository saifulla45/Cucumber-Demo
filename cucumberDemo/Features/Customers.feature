Feature: Customer

Background: Below are the common steps for all the scenarios

Given User Launch Chrome Browser
When User Opens Url "http://admin-demo.nopcommerce.com"
And user enters email as "admin@yourstore.com" and password as "admin"
And user clicks on login button
Then user is able to see the dashboard

@sanity
Scenario: Adding new customer
When user clicks on Customer menu
And user clicks on customer menu item
And user clicks on Add new customer
Then user can view the add new customer page
When user enters customer details
And clicks on save button
Then User view a conformation message "The new customer has been added successfully."
And user close the browser

@regression
Scenario: Search customer by E-mail ID
When user clicks on Customer menu
And user clicks on customer menu item
And user enters email Id
When user clicks on search button
Then user should found email in the search table
And user close the browser

@regression
Scenario: Search customer by name
When user clicks on Customer menu
And user clicks on customer menu item
And user enters first Name
And user enters last name
When user clicks on search button
Then user should found name in the search table
And user close the browser

