@LoginTest
Feature: Login Page 
	In order to test Login Page of Epayment Icegate Website
  As a Registered user
  I want to specify the features of login page
  
@UserloginWithValidcredentials
Scenario: User login with valid credentials 
	Given Initialize browser
	And Navigate to given url
	When user selects Document Type
	And user enters IEC or Passport number
	And user selects location
	Then enters captcha
	And clicks on submit button
	And close all browsers 
		