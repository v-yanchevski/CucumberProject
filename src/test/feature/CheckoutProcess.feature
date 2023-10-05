Feature: Checkout Process

  Scenario: User fills out shipping information and proceeds to the next step
    Given the user is on the checkout step page
    When the user enters first name
    And the user enters last name
    And the user enters postal code
    And the user clicks the Continue button
    Then the user is redirected to checkout overview page