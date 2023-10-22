Feature: Login Page Swag Labs

  @Regression @Positif
  Scenario: Success Login
    Given Buka Halaman Login Swag Labs
    When Input username
    And Input Password
    And Click login button
    Then User in on dashboard page
  @Regression @Negatif
  Scenario:Failed Login
    Given Buka Halaman Login Swag Labs
    When Input username
    And Input invalid Password
    And Click login button
    Then User get Error Message
