@batch
Feature: GET BatchName Request Program Batch module

Background: Bearer Token 

Scenario: Get Batches with BatchName
Given GET BatchName Authorized with bearer Token 
When Sends HTTP GET batch request with BatchName valid endpoints  
Then Gets 200 status code for get BatchName with response body

Scenario: Get Batches with BatchName as Unauthorized
Given Get BatchName token is invalid
When Sends HTTP GET batch requests  with BatchName valid endpoints
Then Gets 401 status code for get BatchName with unauthorised message

Scenario: Get Batches with BatchName with invalid enpoints
Given GET BatchName Authorized with bearer Token
When Sends HTTP GET batch request with BatchName invalid endpoints
Then Gets 405 status for get BatchName with error message  

Scenario: Get Batches with Invalid BatchName 
Given GET BatchName Authorized with bearer Token
When Sends HTTP GET batch request with invalid BatchName and valid endpoints
Then Gets 404 status for get BatchName with error message 

Scenario: Get Batches with BatchName with BatchId value as a parameter
Given GET BatchName Authorized with bearer Token
When Sends HTTP GET batch request with BatchName parameter and value
Then Gets 200 status for get BatchName with response body

