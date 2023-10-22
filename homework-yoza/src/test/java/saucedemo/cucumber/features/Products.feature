Feature: Product menu

  @Regression @Positif
  Scenario: Verify user is able to buy products via Homepage
    Given User already Login the Swag Labs site
    When User click add to Cart button on one of the product or more
    And User click Cart icon on the top right side
    And User check the shopping list details & click the Checkout Button
    And User fill the buyer's biodata form & click the Continue button
    And user double check the shopping list & click the Finish Button
    Then User succesfully purchased the product & directed to "Checkout: Complete!" page
    And User can back to Homepage with click the "Back Home" Button

  @Regression @Negatif
  Scenario: verify user cannot buy a product without inputting their biodata on the Homepage
    Given User already Login the Swag Labs site
    When User click add to Cart button on one of the product or more
    And User click Cart icon on the top right side
    And User check the shopping list details & click the Checkout Button
    And User click the Continue button on the Checkout page
    Then User Failed to buy product & system will display the warning message the Error: First Name is required
