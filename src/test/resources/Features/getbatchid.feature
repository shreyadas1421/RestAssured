@batch
Feature: GET BatchId Request Program Batch module

Background: Bearer Token 

Scenario: Get Batches with BatchId
Given GET BatchId Authorized with bearer Token 
When Sends HTTP GET batch request with BatchId valid endpoints  
Then Gets 200 status code for get batchID with response body

Scenario: Get Batches with BatchId as Unauthorized
Given Get batchId token is invalid
When Sends HTTP GET batch requests  with BatchId valid endpoints
Then Gets 401 status code for get batchID with unauthorised message

Scenario: Get Batches with BatchId with invalid enpoints
Given GET BatchId Authorized with bearer Token
When Sends HTTP GET batch request with BatchId invalid endpoints
Then Gets 405 status for get batchID with error message  

Scenario: Get Batches with Invalid BatchId 
Given GET BatchId Authorized with bearer Token
When Sends HTTP GET batch request with invalid BatchId and valid endpoints
Then Gets 404 status for get batchID with error message 

Scenario: Get Batches with BatchId with search parameter with value
Given GET BatchId Authorized with bearer Token
When Sends HTTP GET batch request with BatchId parameter and value
Then Gets 200 status for get batchID with response body

