@regression
Feature: Add new employee with profile picture

  @addEmployee
  Scenario: admin adds a new employee successfully
    Given admin logs in with valid credentials
    When  navigates to PIM add employee page
    And  enters first name and last name
    And  uploads profile picture
    And  enables login details with username and password
    Then employee personal page is displayed
    And employee profile picture should be visible
    And employee who added appears in employee list
