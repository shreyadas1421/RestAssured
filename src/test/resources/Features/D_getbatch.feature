@batch
Feature: GET Request Program Batch module

Background: Bearer Token 

Scenario: Get all batches
Given GET Batches Authorized with bearer Token 
When Sends HTTP GET batch request with valid endpoints  
Then Gets 200 status code for get batch with response body

Scenario: Get all batches as Unauthorized
Given Get batch token is invalid
When Sends HTTP GET batch request with valid endpoints
Then Gets 401 status code for get batch with unauthorised message

Scenario: Get all batches with invalid enpoints
Given GET Batches Authorized with bearer Token
When Sends HTTP GET batch request with invalid endpoints
Then Gets 404 status for get batch with error message Not Found 

Scenario: Get all batches with search string
Given GET Batches Authorized with bearer Token
When Sends HTTP GET batch request with search endpoints
Then Gets 200 status for get batch with response body 

Scenario: Get all batches with search parameter with value
Given GET Batches Authorized with bearer Token
When Sends HTTP GET batch request with parameter and value
Then Gets 200 status for get batch with response body

