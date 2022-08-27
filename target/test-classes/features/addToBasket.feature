Feature: Add item to basket
  Scenario: Add item to basket from best sellers
    Given User closes cookies
    When User clicks on Best Sellers at the home page
    And User clicks one of the products at the best seller page
    And User add item to the basket at the product page
    Then User should see "Sepete Eklendi" text