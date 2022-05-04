Feature: Delete Lead functionality in Leaftaps application

Background: 
Given Launch the chrome browser
And Load the application url
Given Enter the username as 'DemoSalesManager'
And Enter the password as 'crmsfa'
When I click Login button
Then I should be navigated to homepage without any issues
When I click CRMSFA link
Then I should navigate to leaftaps application main page

Scenario: TC_011 DeleteLead functionality with single data set
Given I click Find Leads under shortcuts menu
And I navigate to Phone tab
And I enter Phone number
When I click Find Leads button and store the first resulting Id
And I click the first resulting Id
Then The screen is navigated to View Lead page
When I click the Delete button
Then I should navigated to My Leads page 
And I verify the if the record is deleted without any issues
And I close the browser

Scenario Outline: TC_012 DeleteLead functionality with single data set
Given I click Find Leads under shortcuts menu
And I navigate to Phone tab
And I enter Phone number as '<phoneNumber>'
When I click Find Leads button and store the first resulting Id
And I click the first resulting Id
Then The screen is navigated to View Lead page
When I click the Delete button
Then I should navigated to My Leads page 
And I verify the if the record is deleted without any issues
And I close the browser
Examples:
|phoneNumber|
|89|
|9|