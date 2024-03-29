Feature: Post Request Program Batch module

Background: Bearer Token 

Scenario: Create Batches with new data
Given Authorized with bearer Token 
When Sends HTTP Post batch request with endpoints and Read data from external file  
Then Gets 201 status code with response body

Scenario: Create Batches with invalid token
Given Token is expired and invalid
When Sends Http Post batch request with endpoints 
Then gets 401 status code with error message

