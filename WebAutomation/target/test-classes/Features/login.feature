@LoginTest
Feature: Login Page 
	In order to test Login Page of SaleForce Website
  As a Registered user
  I want to specify the features of login page
  
@UserloginWithValidcredentials
Scenario Outline: User  login with valid credentials 
	Given Initialize browser with chrome 
	And Navigate to given url 
	And user clicks on login icon
	When user enters "<username>" and "<password>" and clicked on login button
	Then verify if user is succesfully logged in
	And close all browsers 
	Examples: 
		| username | password | 
		|abc@gmail.com|12324423|
		|abc@gmail.com|12324423|
		