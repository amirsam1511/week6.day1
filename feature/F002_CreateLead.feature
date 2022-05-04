Feature: Create Lead functionality in Leaftaps application

Background: 
Given Launch the chrome browser
And Load the application url
Given Enter the username as 'DemoSalesManager'
And Enter the password as 'crmsfa'
When I click Login button
Then I should be navigated to homepage without any issues

Scenario: TC_003 CreateLead functionality with single data set
When I click CRMSFA link
Then I should navigate to leaftaps application main page
Given I click Create Lead under Shortcuts
And I should see Create Lead inputs page
And I enter the mandatory fields in create lead
When I click Create Lead button
Then I should navigate to View Lead page without any issues
And I close the browser

Scenario Outline: TC_004 CreateLead functionality with multiple data set
When I click CRMSFA link
Then I should navigate to leaftaps application main page
Given I click Create Lead under Shortcuts
And I should see Create Lead inputs page
And I enter the mandatory fields in create lead as follows '<companyName>','<firstName>'and'<lastName>'
When I click Create Lead button
Then I should navigate to View Lead page without any issues
And I close the browser
Examples: 
|companyName|firstName|lastName|
|QEagle|Haja|J|
|TestLeaf|Hari|R|
|TestLeaf|Babu|Manickam|