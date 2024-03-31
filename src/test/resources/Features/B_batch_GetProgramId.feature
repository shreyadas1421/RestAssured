@batch_get
Feature: Get Request for ProgramBatch Module
Background: Checking user get batch with all senarios

@batch_get_01
  Scenario Outline: Check if admin able to retrieve a batch without authorization
    Given Admin creates GET Request with program id and unAuth
     When Admin sends HTTPS Request with endpoint and unAuth
     Then Admin receives Status with <statuscode> and statusmessage unauthorized
     
     Examples: 
      | statuscode  |
       | 401       | 
       
       @batch_get_02
  Scenario Outline: Check if admin able to retrieve a batch with valid Program ID
    Given Admin creates GET Request with valid ProgramId
     When Admin sends HTTPS Request with endpoint with programId 
     Then Admin receives <statuscode> OK Status with response body.                                                                  
     
     Examples:
       | statuscode |
       | 200       |
       
       
        @batch_get_03
  Scenario Outline: Check if admin able to retrieve a batch with invalid Program Id
    Given Admin creates GET Request with invalid Program Id
     When Admin sends HTTPS Request with endpoint with invalid programId 
     Then Admin receives <statuscode> and Not Found Status with message and boolean success details
     
     Examples:
       | statuscode |
       | 404       |
       
       
       
        @batch_get_04
  Scenario Outline: Check if admin able to retrieve a batch with invalid endpoint
    Given Admin creates GET Request with invalid endpoint
     When Admin sends HTTPS Request with invalid endpoint  
     Then Admin receives <statuscode>  Status with  error message Not Found.
     Examples:
       | statuscode |
       | 400       |
     