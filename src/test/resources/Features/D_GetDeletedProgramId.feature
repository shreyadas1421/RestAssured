@batch_get_deletedId
Feature: Get Request for ProgramBatch Module
Background: Checking user get batch with all senarios

@batch_get_01
  Scenario Outline: Check if admin able to retrive a batch after the programID is deleted
    Given Admin creates GET Request with  deleted program id
     When Admin sends HTTPS Request with endpoint and deleted programId
     Then Admin receives <statuscode>  Not Found Status with message and boolean success details
     
     Examples: 
      | statuscode  |
       | 404       | 
       