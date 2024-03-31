@batch_update
Feature: Put Request for ProgramBatch Module
 Background: Admin sets Authorization to bearer token


  @batch_update_01
  Scenario Outline: Check if admin able to update a Batch with valid batchID and mandatory fields in request body
    Given Admin creates PUT Request with the valid BatchId anddata "<sheetname>" and <rownumber>
     When Admin sends HTTPS Request  with endpoints
     Then Admin receives <statuscode> and  Status messeage with updated value in response body.                                                          
    
    Examples: 
      | sheetname  | rownumber | statuscode  |statusmessage|
      | Batch      |     1      | 200       |Created      |
      
    @batch_update_02
  Scenario Outline: Check if admin able to update a Batch with "<scenario>"
    Given Admin creates PUT Request with request body "<batchDescription_n>",<batchNoOfclasses_n>,"<batchStatus_n>","<batchName_n>" and "<programName_n>"
     When Admin sends HTTPS Request  with endpoint with negative scenarios
     Then Admin receives <statuscode> Status with  the message and boolean success details 
      
                                                             
    
     Examples: 
      | batchDescription_n  | batchNoOfclasses_n |     batchStatus_n  | batchName_n  |programName_n| scenario |statuscode|
      |                |           3     |     active   |twosedet137    | automation  | valid batchID and missing batchDescription field |200|
     | description |       4       |                   |twosedet137    | automation  | valid batchID and missing batchStatus field |500|
        | description |           1  |     active        |               | automation  | valid batchID and missing batchName field |500|
         | description |           2 |     active         |twosedet137   |            | valid batchID and missing programName field |500|
          |  @734384bb |           3 |     active        |twosedet137    | automation  | with invalid data of description |500|
        | description |  5   | active  | threesedet137 | 1232@44 |  with invalid data of programName |500|
        | description |  5   | active  |@@222@@@ | string |  with invalid data of batchName |500|
         | description |  5   | @@2  |threesedet137 | string |  with invalid data of batchStatus |500|
         |  null    |   4  |  active | threesedet137 | string | with description Null | 200 |
         | description |              |       active      |twosedet137    | automation  | valid batchID and missing batchNoOfclasses field | 500 |
          | description |  hksjfh   | active  | threesedet137 | string |  with invalid data of batchNoOfclasses | 500 |
      
       @batch_update_03
  Scenario Outline: Check if admin able to update a Batch with "<scenario>"
    Given Admin creates PUT Request with  invalid batchid and request body  "<batchDescription>", <batchNoOfclasses>,"<batchStatus>","<batchName>" and "<programName>"
     When Admin sends HTTPS Request  with endpoints 
     Then Admin receives <statuscode> Status with message  
     
     Examples:  
      | batchDescription  | batchNoOfclasses |     batchStatus  | batchName  |programName| scenario |statuscode|
      | description |  2 |active | onesdet137 | automation       |  invalid batchID and mandatory fields in request body|500|
      
      
      @batch_update_04
  Scenario Outline: Check if admin able to update a Batch with "<scenario>"
    Given Admin creates PUT Request with request body and invalid endpoint "<sheetname>" and <rownumber>
     When Admin sends HTTPS Request  with invalid endpoints
     Then Admin receives <statuscode> Status with message and boolean success details 
      
      
      Examples:
      | sheetname  | rownumber | statuscode  |statusmessage|
      | Batch      |     1      | 400       | Badrequest       |
      
      
       @batch_update_05
  Scenario Outline: Check if admin able to update  Batch with valid batchID and mandatory fields in request body without authorization
    Given Admin creates PUT Request with  the valid BatchId and Data "<sheetname>" and <rownumber>
     When Admin sends HTTPS Request  with endpoint and invalid Auth
     Then Admin receives  the <statuscode> and "<statusmessage>" unauthorized 
     
     Examples: 
      | sheetname  | rownumber | statuscode  |statusmessage|
      | Batch      |     1      | 401        |Unauthorized  |
                                             