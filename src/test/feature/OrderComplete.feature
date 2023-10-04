Feature: Complete order
  Scenario: User finishes the order
    Given a user is on checkout overview page
    When a user clicks on Finish button
    Then a user sees an order confirmation headline
