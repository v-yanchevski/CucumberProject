Feature: Logout functionality

  Scenario: Successful log out
    Given a user is on product page
    When a user clicks on side menu
    And a user click on logout button
    Then a user is navigated to login page

