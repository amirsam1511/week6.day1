Feature: Duplicate Lead functionality in Leaftaps application

Background: 
Given Launch the chrome browser
And Load the application url
Given Enter the username as 'DemoSalesManager'
And Enter the password as 'crmsfa'
When I click Login button
Then I should be navigated to homepage without any issues
When I click CRMSFA link
Then I should navigate to leaftaps application main page

Scenario: TC_009 DuplicateLead functionality with single data set
Given I click Find Leads under shortcuts menu
And I navigate to Phone tab
And I enter Phone number
When I click Find Leads button
Then I should see corresponding search results based on search criteria
And I click the first resulting Id in the grid
Given I click the Duplicate Lead button
When I click Create Lead button
Then I should navigate to View Lead page without any issues
And I close the browser

Scenario Outline: TC_010 DuplicateLead functionality with single data set
Given I click Find Leads under shortcuts menu
And I navigate to Phone tab
And I enter Phone number as '<phoneNumber>'
When I click Find Leads button
Then I should see corresponding search results based on search criteria
And I click the first resulting Id in the grid
Given I click the Duplicate Lead button
When I click Create Lead button
Then I should navigate to View Lead page without any issues
And I close the browser
Examples:
|phoneNumber|
|89|
|9|