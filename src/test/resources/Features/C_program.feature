@program_01
Feature: POST REQUEST for Program Module

Background:
Given User is Authorized

@program_PPP_01_PPN_04
Scenario Outline: Check if Admin able to create a program with valid endpoint and request body with Authorization and resubmitting the request 
Given Admin creates POST Request for the LMS with request body "<sheetname>" and <rownumber>
When Admin sends POST Request and request Body with endpoint for Program
Then Admin receives <statusCode> "<statusLine>" Status with response body for Program
When Admin sends POST Request and request Body with endpoint for Program
Then Admin receives 400 "Bad Request" Status with response body for Program

Examples:
|sheetname|rownumber|statusCode|statusLine|
|Program|1|201|Created|

@program_PPN_01
Scenario Outline: Check if Admin able to create a program with "<scenarioName>"
Given Admin creates POST Request for the LMS with request body "<sheetname>" and <rownumber>
When Admin sends POST Request and request Body with endpoint for Program
Then Admin receives <statusCode> "<statusLine>" Status with response body for Program Negative

Examples:
|sheetname|rownumber|scenarioName|statusCode|statusLine|
|Program|1|with Authorization|201|Created|
|Program|2|valid endpoint and request body without Authorization|401|Unauthorized|
|Program|3|invalid endpoint|404|Not Found|
|Program|5|invalid request body|400|Bad Request|
|Program|6|missing values in the request body|500|Bad Request|
|Program|7|missing additional field|500|OK|


@program_PPN_02
Scenario Outline: Check if Admin able to create a program with "<scenarioName>"
Given Admin creates POST Request for the LMS with request body "<sheetname>" and <rownumber>
When Admin sends GET Request and request Body with endpoint and invalid method for program
Then Admin receives <statusCode> "<statusLine>" Status with response body for Program

Examples:
|sheetname|rownumber|scenarioName|statusCode|statusLine|
|Program|4|invalid method|405|Method Not Allowed|

@program_PGP_01
Scenario: Check if Admin able to retrieve all programs with valid Endpoint
Given Admin creates GET Request for the LMS API
When Admin sends GET Request with endpoint for Program
Then Admin receives 200 "OK" Status with response body for Program    

@program_PGN_01   
Scenario Outline: Check if Admin able to retrieve all programs with "<scenarioName>" 
Given Admin creates GET Request for the LMS API with "<endpoint>" and "<Authorization>"
When Admin sends GET Request with endpoint for Program
Then Admin receives <statusCode> "<statusLine>" Status with response body for Program   

Examples:
|endpoint|statusCode|statusLine|scenarioName|Authorization|                                     
|/programxx|404|not found|invalid Endpoint|Y|
|/allPrograms|401|Unauthorized|without Authorization|N|

@program_PPGN_02
Scenario Outline: Check if Admin able to retrieve all programs with invalid Method
Given Admin creates GET Request for the LMS API
When Admin sends POST Request with endpoint and invalid method for program
Then Admin receives <statusCode> "<statusLine>" Status with response body for Program

Examples:
|statusCode|statusLine|
|405|Method Not Allowed|

@program_PGP_02
Scenario: Check if Admin able to retrieve a program with valid program ID 
Given Admin creates GET Request for the LMS API with programID
When Admin sends GET Request with endpoint for Program
Then Admin receives 200 "OK" Status with response body for Program 

@program_PGN_02
Scenario Outline: Check if Admin able to retrieve a program with invalid program ID 
Given Admin creates GET Request for the LMS API with invalid "<programID>"
When Admin sends GET Request with endpoint for Program
Then Admin receives <statusCode> "<statusLine>" Status with response body for Program 

Examples:
|programID|statusCode|statusLine|
|94|404|not found|
|a23|400|bad request|

@program_PGN_03  
Scenario Outline: Check if Admin able to retrieve all programs with "<scenarioName>" 
Given Admin creates GET Request for the LMS API with "<endpoint>" and "<Authorization>" programId
When Admin sends GET Request with endpoint for Program
Then Admin receives <statusCode> "<statusLine>" Status with response body for Program   

Examples:
|endpoint|statusCode|statusLine|scenarioName|Authorization|                                     
|/programxx/|404|not found|invalid Endpoint|Y|
|/Programs/|401|Unauthorized|without Authorization|N|

@program_PGN_03
Scenario: Check if Admin able to retrieve a program with invalid baseURI 
Given Admin creates GET Request for the LMS API with programID
When Admin sends GET Request with invalid BaseURI for Program "https://asdf.com/programs/"
Then Admin receives 404 "not found" Status with response body for Program 

                                                         