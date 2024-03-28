@program_01
Feature: POST REQUEST for Program Module

Background:
Given User is Authorized

@program_PP_01_PN_04
Scenario Outline: Check if Admin able to create a program with valid endpoint and request body with Authorization and resubmitting the request 
Given Admin creates POST Request for the LMS with request body "<sheetname>" and <rownumber>
When Admin sends POST Request and request Body with endpoint for Program
Then Admin receives <statusCode> "<statusLine>" Status with response body for Program
When Admin sends POST Request and request Body with endpoint for Program
Then Admin receives 400 "Bad Request" Status with response body for Program

Examples:
|sheetname|rownumber|statusCode|statusLine|
|Program|1|201|Created|

@program_PN_01
Scenario Outline: Check if Admin able to create a program with "<scenarioName>"
Given Admin creates POST Request for the LMS with request body "<sheetname>" and <rownumber>
When Admin sends POST Request and request Body with endpoint for Program
Then Admin receives <statusCode> "<statusLine>" Status with response body for Program

Examples:
|sheetname|rownumber|scenarioName|statusCode|statusLine|
|Program|2|valid endpoint and request body without Authorization|401|Unauthorized|
|Program|3|invalid endpoint|404|Not Found|
|Program|5|invalid request body|400|Bad Request|
|Program|6|missing values in the request body|400|Bad Request|
|Program|7|missing additional field|200|OK|


@program_PN_02
Scenario Outline: Check if Admin able to create a program with "<scenarioName>"
Given Admin creates POST Request for the LMS with request body "<sheetname>" and <rownumber>
When Admin sends POST Request and request Body with endpoint and invalid method
Then Admin receives <statusCode> "<statusLine>" Status with response body for Program

Examples:
|sheetname|rownumber|scenarioName|statusCode|statusLine|
|Program|4|invalid method|405|Method Not Allowed|

@program_PG_01
Scenario: Check if Admin able to retrieve all programs with valid Endpoint
Given Admin creates GET Request for the LMS API
When Admin sends GET Request with endpoint for Program
Then Admin receives 200 "OK" Status with response body for Program                                                       
