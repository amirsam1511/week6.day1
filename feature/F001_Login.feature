Feature: Login Functionality of Leaftaps application

Scenario: TC0001_Login Functionality with positive credentials
Given Launch the chrome browser
And Load the application url
And Enter the username as 'DemoSalesManager'
And Enter the password as 'crmsfa'
When I click Login button
Then I should be navigated to homepage without any issues
And I close the browser

Scenario: TC0002_Login Functionality with negative credentials
Given Launch the chrome browser
And Load the application url
And Enter the username as 'Demo'
And Enter the password as 'crmsfa'
When I click Login button
But I should see Error message in it
And I close the browser
