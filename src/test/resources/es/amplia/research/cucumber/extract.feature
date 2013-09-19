Feature: Extracting money from a User account
 
Scenario: Extracting money from User's account should remove money to the User's current balance
Given a User has £100 in their account
When £100 is extracted from the account
Then the balance should be empty