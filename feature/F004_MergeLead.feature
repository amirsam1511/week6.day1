Feature: Merge Lead functionality in leaf taps application

Background:
Given Launch the chrome browser
And Load the application url
Given Enter the username as 'DemoSalesManager'
And Enter the password as 'crmsfa'
When I click Login button
Then I should be navigated to homepage without any issues
When I click CRMSFA link
Then I should navigate to leaftaps application main page

Scenario: TC_007 MergeLead functionality with single data set
Given I click Merge Leads under shortcuts menu
When I click the image icon of From Lead
Then I should navigate to Find Leads page of From Lead
Given I enter the first name of From Lead
And I click Find Leads From Lead
When I select the first resulting Id From Lead
Then I should see the corresponding Id fetched to From Lead field
When I click the image icon of To Lead
Then I should navigate to Find Leads page
Given I enter the first name of To Lead
And I click Find Leads
When I select the first resulting Id To Lead
Then I should see the corresponding Id fetched from To Lead field
When I select Merge button
Then I should see a alert message in the page
When I dismiss the alert 
Then The screen is navigated to View Lead page
And I close the browser

Scenario Outline: TC_008 MergeLead functionality with multiple data set
Given I click Merge Leads under shortcuts menu
When I click the image icon of From Lead
Then I should navigate to Find Leads page of From Lead
Given I enter the first name of From Lead as '<fNameFromLead>'
And I click Find Leads From Lead
When I select the first resulting Id From Lead
Then I should see the corresponding Id fetched to From Lead field
When I click the image icon of To Lead
Then I should navigate to Find Leads page
Given I enter the first name of To Lead as '<fNameToLead>'
And I click Find Leads
When I select the first resulting Id To Lead
Then I should see the corresponding Id fetched from To Lead field
When I select Merge button
Then I should see a alert message in the page
When I dismiss the alert 
Then The screen is navigated to View Lead page
And I close the browser
Examples:
|fNameFromLead|fNameToLead|
|Babu|Hari|
|Hema|Haja|