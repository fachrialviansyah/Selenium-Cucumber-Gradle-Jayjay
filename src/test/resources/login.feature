@login
Feature: Login
  @positive-test
  Scenario: Login with valid username and password
    Given user is on login page
    When user input username with "standard_user"
    And user input password "secret_sauce"
    And user click login button
    Then user is on homepage

  @negative-test
  Scenario: Login with invalid username and password
    Given user is on login page
    When user input username with "standard_user"
    And user input password "invalid"
    And user click login button
    Then user see error messege "Epic sadface: Username and password do not match any user in this service"


  @batas-test
  Scenario: Login with invalid username
    Given user is on login page
    When user input username with "username_salah12345789"
    And user input password "secret_sauce"
    And user click login button
    Then user see error messege "Epic sadface: Username and password do not match any user in this service"