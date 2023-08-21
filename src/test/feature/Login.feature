Feature: Login functionality

  Scenario: Login with valid credentials
    Given a user opens a browser
    And a user navigates to login page
    When a user enters valid credentials
    And a user clicks on login button
    Then a user is navigated to the product page