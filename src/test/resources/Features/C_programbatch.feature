@batch
Feature: Post Request Program Batch module

Background: Bearer Token 

Scenario: Create Batches with external excel data
Given Authorized with bearer Token 
When Sends HTTP Post batch request with endpoints and Read data from external file  
Then Gets 201 status code with response body

Scenario: Create Batches with invalid token
Given Token is expired and invalid
When Sends Http Post batch request with endpoints 
Then gets 401 unauthorised status code with error message

Scenario: Create batches with invalid endpoint
Given Authorized with bearer Token "Invalid endpoint" 
When Sends HTTP Post batch request  with invalid endpoint and Read data "API_hackathon_march24 " "SDETd5 " 5 "active " 16306    
Then Gets  404 with response body

Scenario Outline: create batches with different examples
Given Authorized with bearer Token "<scenario>" 
When Sends HTTP Post batch request with valid endpoints and Read data "<Batchdescription>" "<Batchname>" <Batchnoclasses> "<Batchstatus>" <programID>    
Then Gets  <statuscode> with batch response body 

Examples:
|scenario                            |Batchdescription        | Batchname  |Batchnoclasses|Batchstatus  |programID |statuscode|
| Create_batch_with_new_data         |API_hackathon_march24   |SDETProgramsss4 |4     |active     |16323    |201   |      
| Create_batch_with_existing_data    |API_hackathon_march24   |SDETProgramsss4 |4      |active     |16323   |400   |
| Post_missing_mandatory_fields      |API_hackathon_march24   |             |4      |active     |16323    |400   |
| Post_missing_additional_fields_null|null                    |SDETrestpromss4   |4      |active     |16323   |201   |
| Post_missing_additional_fields_null|                        |SDETapi     |4      |active     |16323    |400   |
| Invalid_Progam_Id                  |API_hackathon_march24   |SDET        |4      |active     |26900    |400   |
| Post_invalid_data                  |API_hackathon_march24   |SDET        |4     |active     |16323    |400   |
 
 