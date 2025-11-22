@regression
Feature: create a Buzz Post as an Employee

  Scenario: employee creates a Buzz post with text and optional media
    Given the employee is logged in with valid credentials
    When the employee navigates to the Buzz from the main menu
    And enters a text message with attaches an image
    Then the post displays the correct text content
    And the employee name and timestamp are displayed
    And if the employee attempts to post without text or media, a validation message is shown