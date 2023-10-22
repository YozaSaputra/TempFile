Feature: Logout From Dashboard Swag Labs
  @Regression @Positif
  Scenario: Success Logout
    Given User already Login the Swag Labs site
    When User click menu in corner
    And User click Logout
    Then Halaman Login Swag Labs
