@batch
Feature: Post Request for ProgramBatch Module
 Background: Admin sets Authorization

  @batch_01
  Scenario Outline: Check if admin able to create a Batch with valid endpoint and request body (non existing values)
    Given Admin creates POST Request  with valid data in request body "<sheetname>" and <rownumber>
     When Admin sends HTTPS Request with endpoint 
     Then Admin receives <statuscode> and  "<statusmessage>" Status with response body.                                                          
    
    Examples: 
      | sheetname  | rownumber | statuscode  |statusmessage|
      | Batch      |     1      | 201        |Created      |