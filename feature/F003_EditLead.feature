Feature: Create Lead functionality in Leaftaps application

Background: 
Given Launch the chrome browser
And Load the application url
Given Enter the username as 'DemoSalesManager'
And Enter the password as 'crmsfa'
When I click Login button
Then I should be navigated to homepage without any issues
When I click CRMSFA link
Then I should navigate to leaftaps application main page

Scenario: TC_005 EditLead functionality with single data set
Given I click Find Leads under shortcuts menu
And I navigate to Phone tab
And I enter Phone number
When I click Find Leads button
Then I should see corresponding search results based on search criteria
And I click the first resulting Id in the grid
Given I click the Edit button
And I update the company Name
And I select the update button
Then I should see the company name is updated without any issues
And I close the browser

Scenario Outline: TC_006 EditLead functionality with multiple data set
Given I click Find Leads under shortcuts menu
And I navigate to Phone tab
And I enter Phone number as '<phoneNumber>'
When I click Find Leads button
Then I should see corresponding search results based on search criteria
And I click the first resulting Id in the grid
Given I click the Edit button
And I update the company Name as '<companyName>'
And I select the update button
Then I should see the company name is updated without any issues
And I close the browser
Examples:
|phoneNumber|companyName|
|89|IVTL|
|9|CTS|
