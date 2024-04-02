@tag
Feature: Batch Update

  @get_batch
  Scenario: GET Batch by ProgramId
    Given User-batch creates GET Request
    When User-batch sends "getBatchbyProgramId" with "Get" Request with endpoint
    Then User-batch receives 200 Created Status with response body

  @update_batch
	Scenario Outline:  Update by Batch Id
	  Given User-batch creates Put Request with request body "<batchDescription>", <batchId>, "<batchName>",<batchNoOfClasses>,"<batchStatus>",<programId>,"<programName>"
	  When User-batch sends "updateByBatchID" with "Put" Request with endpoint
	  Then User-batch receives 201 Created Status with response body
				
   Examples:
		|batchDescription|batchId|batchName|batchNoOfClasses|batchStatus|programId|programName|
		|updatebatch      | 9984 | updatebatch | 5           | Active|17782|testProarn|
	
	 @get_batch
  Scenario: Delete Batch by ProgramId
    Given User-batch creates Delete Request
    When User-batch sends "deleteBatchbyBatchID" with "Delete" Request with endpoint
    Then User-batch receives 200 Created Status with response body
	