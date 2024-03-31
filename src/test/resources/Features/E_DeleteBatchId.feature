@batch_delete
Feature: Get Request for ProgramBatch Module
Background: Checking user delete batch with all senarios

@batch_delete_01
  Scenario Outline: Check if admin able to delete a Batch with valid Batch ID
    Given Admin creates DELETE Request with valid BatchId
     When Admin sends HTTPS Request  with endpoint and batchId
     Then Admin receives <statuscode> Ok status with message
     
     Examples: 
      | statuscode  |
       | 200       | 
       
       @batch_delete_02
  Scenario Outline: Check if admin able to delete a Batch with invalid endpoint
    Given Admin creates DELETE Request with valid BatchId and invalid enpoint
     When Admin sends HTTPS Request  with invalid endpoint and batchId
     Then Admin receives <statuscode> not found
     
      Examples: 
      | statuscode  |
       | 400       | 
       
     
        @batch_delete_03
  Scenario Outline: Check if admin able to delete a Batch with invalid Batch ID
    Given Admin creates DELETE Request with invalid BatchId
     When Admin sends HTTPS Request  with endpoint and invalid batchId
     Then Admin receives <statuscode> Not Found Status with message and boolean success details
      Examples: 
      | statuscode  |
       | 404      | 
       
       @batch_delete_04
  Scenario Outline: Check if admin able to delete a Batch without authorization
    Given Admin creates DELETE Request with valid BatchId and unAuth
     When Admin sends HTTPS Request  with endpoint and without authorization
     Then Admin receives <statuscode> and message  "<statusmessage>" 
      Examples: 
      | statuscode  |statusmessage|
       | 401      | Unauthorized |