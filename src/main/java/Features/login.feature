Feature: Free CRM Login Feature

Scenario Outline: Free CRM Login Test Scenario
 
Given user is on login page
When title of login page is Free CRM
Then user enters "<username>" and "<password>"
Then user clicks on Login button
Then user is on Home Page
Then close the browser
    
Examples: 
    | username  | password |
    | priyankak | test@123 |
   