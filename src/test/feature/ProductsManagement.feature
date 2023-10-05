Feature: Products management

  Background:
    Given a user is on inventory page


  Scenario: Products list is visible for a user
    Then a user sees all products


  Scenario: User adds products to the cart
    When a user clicks on Add to cart button for products with indexes 0 and 2
    Then the products are added to the cart


  Scenario: User removes products from the cart
    And a user has added products to the cart
    When a user clicks on Remove button
    Then the products are removed from the cart


    Scenario: User successfully navigates to Cart page
      And a user has added products to the cart
      When a user click on cart icon
      Then the user is navigated to the Cart page