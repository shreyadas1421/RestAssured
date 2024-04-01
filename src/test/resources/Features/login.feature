@aaaa
Feature: AdminLogin Controller

  @tag2
  Scenario: Check if Admin able to generate token with valid credential
    Given Admin creates request with valid credentials
    When Admin calls "LMSLogIn" with "Post" http request with valid endpoint
    Then Admin Should get 200 status
    And Adimn should get auto generated token

  # @tag2
  # Scenario: Check if Admin able to generate token with invalid endpoint
  #  Given Admin creates request with valid credentials
  #  When  Admin calls "asq" with "Post" http request with valid endpoint
  #  Then Admin receives 401 unauthorized
  # @tag3
  # Scenario: Check if Admin able to generate token with invalid credentials
  #  Given Admin creates request with invalid credentials
  #  When  Admin calls "LMSLogIn" with "Post" http request with valid endpoint
  #  Then Admin receives 400 Bad request

  #  Scenario: Check if Admin able to logout
  #  Given Admin creates request
   # When Admin calls "LMSLogOut" with "Get" http request with valid endpoint
   # Then Admin receives 200 ok  and response with "Logout successful"