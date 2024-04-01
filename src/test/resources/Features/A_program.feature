@program
Feature: POST REQUEST for Program Module

Background:
Given User is Authorized

@program_01
Scenario Outline: Check if Admin able to create a program with "<scenarioName>"
Given Admin creates "<method>" Request for the LMS with request body "<sheetname>" and <rownumber>
When Admin sends "<method>" Request and request Body with endpoint for Program
Then Admin receives <statusCode> "<statusLine>" Status with response body for Program

Examples:
|sheetname|rownumber|scenarioName|statusCode|statusLine|method|
|Program|1|with Authorization for ProgramId_1|201|Created|POST|
|Program|1|with Authorization for programId_2|201|Created|POST|
|Program|2|valid endpoint and request body without Authorization|401|Unauthorized|POST|
|Program|3|invalid endpoint|404|Not Found|POST|
|Program|4|invalid method for POST|405|Method Not Allowed|GET|
|Program|5|invalid request body|400|Bad Request|POST|
#|Program|6|missing values in the request body|400|Bad Request|POST|
#|Program|7|missing additional field|400|OK|POST|
|Program|8|with Authorization for programId|200|Ok|PUT|
|Program|9|with Authorization for programName|200|Ok|PUT|
|Program|10|valid endpoint and request body without Authorization for programId|401|Unauthorized|PUT|
|Program|11|invalid method for PUT with programId|405|Method Not Allowed|GET|
|Program|12|invalid endpoint for programId|404|Not Found|PUT|
|Program|13|invalid request body for programId|400|Bad Request|PUT|
#|Program|14|missing values in the request body for programId|400|Bad Request|PUT|
#|Program|15|missing additional field for programId|400|OK|PUT|
|Program|16|valid endpoint and request body without Authorization for programName|401|Unauthorized|PUT|
|Program|17|invalid method for PUT with programName|405|Method Not Allowed|GET|
|Program|18|invalid endpoint for programName|404|Not Found|PUT|
|Program|19|invalid request body for programName|400|Bad Request|PUT|
#|Program|20|missing values in the request body for programName|400|Bad Request|PUT|
#|Program|21|missing additional field for programName|400|OK|PUT|
|Program|22|with Authorization for all programs|200|Ok|GET|
|Program|23|with Authorization for programId|200|Ok|GET|
|Program|24|with Authorization for admins|200|Ok|GET|
|Program|25|invalid Endpoint for allprograms|404|Not Found|GET|
|Program|26|without Authorization for allprograms|401|Unauthorized|GET|
|Program|27|invalid Endpoint with ProgramId|404|Not Found|GET|
|Program|28|without Authorization with ProgramId|401|Unauthorized|GET|
|Program|29|invalid Endpoint for admins|404|Not Found|GET|
|Program|30|without Authorization for admins|401|Unauthorized|GET|
|Program|31|invalid method for GET for all programs|405|Method Not Allowed|POST|
|Program|32|invalid method for GET for program id|405|Method Not Allowed|POST|
|Program|33|invalid method for GET for program by admins|405|Method Not Allowed|POST|
|Program|34|invalid program id for GET|404|Not Found|GET|
|Program|35|delete by valid programId|200|Ok|DELETE|
|Program|36|delete by valid programName|200|Ok|DELETE|
|Program|37|delete by invalid programId|404|Not Found|DELETE|
|Program|38|delete by invalid programName|404|Not Found|DELETE|
|Program|39|delete by valid programId wihtout Authorization|401|Unauthorized|DELETE|
|Program|40|delete by valid programName wihtout Authorization|401|Unauthorized|DELETE|
|Program|41|delete by valid programId and invalid endpoint|404|Not Found|DELETE|
|Program|42|delete by valid programName and invalid endpoint|404|Not Found|DELETE|

@program_02
Scenario Outline: Check if Admin able to retrieve a program with invalid baseURI 
Given Admin creates "<method>" Request for the LMS API with programID
When Admin sends "<method>" Request with invalid BaseURI for Program "<uri>"
Then Admin receives 404 "not found" Status with response body for Program for invalid base url

Examples:
|method|uri|
|GET|https://asdf.com/programs/|
|PUT|https://asdf.com//putprogram/|


@program_03
Scenario Outline: Check if Admin able to create a program with "<scenarioName>"
Given Admin creates "<method>" Request for the LMS with request body "<sheetname>" and <rownumber>
When Admin sends "<method>" Request and request Body with endpoint for Program
Then Admin receives <statusCode> "<statusLine>" Status with response body for Program
When Admin sends "<method>" Request and request Body with endpoint for Program
Then Admin receives 400 "Bad Request" Status with response body for Program

Examples:
|sheetname|rownumber|scenarioName|statusCode|statusLine|method|
|Program|1|Repost with Authorization for ProgramId_1|201|Created|POST|