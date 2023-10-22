Feature: Sort Product

  @Regression @Positif
  Scenario: Sort Product
    Given User already Login the Swag Labs site
    When User sort product by "Price (low to high)" as sortBy
    Then User select cheapest Product to the cart