
@tag
Feature: UserRoleProgramBatchMap Module
 
 Background: Admin sets authorization to bearer token

	#--GET Requests--
  @get_UserRoleMap
  Scenario: Check if admin is able to retreive all admin with assigned program batches
  Given UserRoleProgramBatchMap creates get request with Authorization
  When UserRoleProgramBatchMap sends "LMSgetProgramBatche" with "Get" Request with endpoint
  Then UserRoleProgramBatchMap receives 200 Created Status with response body

  Scenario: Check if admin is able to retreive assigned program batches for valid AdminId
  Given UserRoleProgramBatchMap creates get request with Authorization
  When UserRoleProgramBatchMap sends "LMSgetUserProgramBatch" with "Get" Request with endpoint
  Then UserRoleProgramBatchMap receives 200 Created Status with response body
  		
  #Negative
  Scenario: Check if admin is able to retreive assigned program batches for Invalid AdminId
  Given UserRoleProgramBatchMap creates get request with Authorization
  When UserRoleProgramBatchMap sends "LMSgetUserProgramBatchInvalid" with "Get" Request with endpoint
  Then UserRoleProgramBatchMap receives 404 Created Status with response body
  
  	#--Delete Requests--
  
  Scenario: Check if admin is able to delete the program batch for a Admin
  Given UserRoleProgramBatchMap creates delete request with Authorization
  When UserRoleProgramBatchMap sends "LMSDeleteProgramBatche" with "Delete" Request with endpoint
  Then UserRoleProgramBatchMap receives 200 Created Status with response body
  		
  		#Negative
  		
  Scenario: Check if UserRoleProgramBatchMap is able to delete the program batch for invalid Admin
  Given UserRoleProgramBatchMap creates delete request with Authorization
  When UserRoleProgramBatchMap sends "LMSDeleteProgramBatcheInvalid" with "Delete" Request with endpoint
  Then UserRoleProgramBatchMap receives 404 Created Status with response body
