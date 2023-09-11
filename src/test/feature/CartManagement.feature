Feature: Cart management

  Background:
    Given user is on cart page


  Scenario: Remove product from the cart
    And there are two products in the cart
    When  a user clicks Remove on the first product
    Then the product is removed from the cart


  Scenario: Proceed to Checkout
    And there are two products in the cart
    When a user clicks on Checkout button
    Then the user is navigated to information checkout page

