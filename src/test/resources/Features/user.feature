@tag
Feature: User Module

Background: Admin sets authorization to bearer token

  @tag1
  Scenario: Check if admin is able to create a new Admin with valid endpoint and request body with mandatory fields
    Given Admin creates POST request with all mandatory fields
    When Admin sends "LMScreateUser" with "Post" Request with endpoint
    Then Admin receives 201 Created Status with response body.
