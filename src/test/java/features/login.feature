Feature: Login to Application

Scenario: Login with valid credentials

Given open any browser

And Navigate to Login page

When user enters username as "ashish23_sept@yahoo.com" and password as "Ashish@123" into the fields

And User clicks on submit button

Then Verify user is able to login successfully