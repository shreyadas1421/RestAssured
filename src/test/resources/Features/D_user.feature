@tag
Feature: User Module

  Background: Admin sets authorization to bearer token
  
#--POST Request--

	#~~Positive scenarios~~
	
				@create_user
				  Scenario Outline: Check if user is able to create a new Admin,Staff & Student with valid endpoint and request body with mandatory fields
				  Given User creates POST Request for the LMS with request body "<sheetname>" and <rownumber>
				  When User sends "LMScreateUser" with "Post" Request with endpoint
				  Then User receives 201 Created Status with response body
				
				Examples:
						|sheetname|rownumber|
						|USER|1|
						|USER|2|
						|USER|3|
				
										
				
			#	@create_user
				#  Scenario Outline: Check if user is able to create a new Admin,Staff & Student with valid endpoint and request body with mandatory fields
				#   Given User creates POST request with all fields "<userComments>","<userEduPg>","<userEduUg>","<userFirstName>", "<userLastName>","<userLinkedinUrl>","<password>","<userLoginEmail>","<userMiddleName>", "<userPhoneNumber>","<roleId>","<userRoleStatus>","<userTimeZone>","<userVisaStatus>"
				#   When User sends "LMScreateUser" with "Post" Request with endpoint
				#  Then User receives 201 Created Status with response body
				
				   # Examples: 
				    #      | userComments | userEduPg| userEduUg|userFirstName|userLastName|userLinkedinUrl|password|userLoginEmail|userMiddleName|userPhoneNumber|roleId|userRoleStatus|userTimeZone|userVisaStatus|
				    #      | New User Admin | BCA      | MCA      | FirstUser   | Last       |www.linkedin.com|234350 |test72@gmail.com | M         |4455662222     |R01   | Active       |EST         | H4-EAD        |
				         # | New User Staff | BCA      | MCA      | FirstUser   | Last       |www.linkedin.com|234351 |test38@gmail.com | M         |3435457691     |R02   | Active       |EST         | H4-EAD        |
				         # |New User Student| BCA      | MCA      | FirstUser   | Last       |www.linkedin.com|234352 |test39@gmail.com | M         |3435457692     |R03   | Active       |EST         | H4-EAD        |
		
	#~~Negative scenarios~~		    
	  
				 # @Create_user_negative
				 # Scenario Outline: Check if user is able to create a new user with valid endpoint and invalid values in request body with mandatory fields
				 # Given User creates POST request with all fields "<userComments>","<userEduPg>","<userEduUg>","<userFirstName>", "<userLastName>","<userLinkedinUrl>","<password>","<userLoginEmail>","<userMiddleName>", "<userPhoneNumber>","<roleId>","<userRoleStatus>","<userTimeZone>","<userVisaStatus>"
				 # When User sends "LMScreateUser" with "Post" Request with endpoint
				 # Then User receives 400 Created Status with response body
				
				  #  Examples: 
				   #       | userComments | userEduPg| userEduUg|userFirstName|userLastName|userLinkedinUrl|password|userLoginEmail|userMiddleName|userPhoneNumber|roleId|userRoleStatus|userTimeZone|userVisaStatus|
				    #  	  | New User Admin | BCA      | MCA      | FirstUser   | Last       |linkedin|234353 |test40@gmail.com | M         |3435457693     |R01   | Active       |EST         | H4-EAD        |
      
				 #@Create_user_negative
				  #Scenario Outline: Check if Admin able to create a Admin missing mandatory fields in request body
				  	#  Given User creates POST request with all fields "<userComments>","<userEduPg>","<userEduUg>","<userFirstName>", "<userLastName>","<userLinkedinUrl>","<password>","<userLoginEmail>","<userMiddleName>", "<userPhoneNumber>","<roleId>","<userRoleStatus>","<userTimeZone>","<userVisaStatus>"
				   # 	When User sends "LMScreateUser" with "Post" Request with endpoint
				   # And User receives 400 Created Status with response body
				
				   # Examples: 
				   #       | userComments | userEduPg| userEduUg|userFirstName|userLastName|userLinkedinUrl|password|userLoginEmail|userMiddleName|userPhoneNumber|roleId|userRoleStatus|userTimeZone|userVisaStatus|
				   #       | New User Admin |   BCA    | MCA      | FirstUser   | Last       | www.linkedin.com|234353 | test41@gmail.com| M         |9887909761    |R01   | Active       |CST         | H4       |

#--GET Requests--
	
	#@Get_user
	#Scenario: Check if user is able to get all users
  #Given User creates get request with Authorization
  #When User sends "LMSgetAllUsers" with "Get" Request with endpoint
  #Then User receives 200 Created Status with response body
  
  #@Get_user
  #Scenario: Check if user is able to get all users
  #  Given User creates get request with Authorization
  # When User sends "LMSgetAllusersWithRols" with "Get" Request with endpoint
  # Then User receives 200 Created Status with response body
  	 
	@Get_user
	 Scenario: Check if user is able to get the user
   Given User creates get request with Authorization
   When  User sends "LMSgetSingleUser" with "Get" Request with endpoint
   Then User receives 200 Created Status with response body 
   And User validate the response json
  
  #@Get_user  
   #Scenario: Check if user is able to get the user
   #Given User creates get request with Authorization
   #When  User sends "LMSgetAllRoles" with "Get" Request with endpoint
   #Then User receives 200 Created Status with response body 
  
  #@Get_user 
   #Scenario: Check if user is able to get the user
   #Given User creates get request with Authorization
   #When  User sends "LMSgetRolestatus" with "Get" Request with endpoint
   #Then User receives 200 Created Status with response body 
  
  #@Get_user 
   #Scenario: Check if user is able to get the user
   #Given User creates get request with Authorization
   #When  User sends "LMSgetAllactivUsers" with "Get" Request with endpoint
   #Then User receives 200 Created Status with response body
  
  #@Get_user 
  # Scenario: Check if user is able to get the user
   #Given User creates get request with Authorization
   #When  User sends "LMSgetUsersWithRoleId" with "Get" Request with endpoint
   #Then User receives 200 Created Status with response body
   
  #@Get_user
  # Scenario: Check if user is able to get the user
  # Given User creates get request with Authorization
  # When  User sends "LMSgetUsersByRoleIdV2" with "Get" Request with endpoint
  # Then User receives 200 Created Status with response body
  
#---PUT Request---

	#--Update user--
	# @update_user
	#Scenario Outline: Check if admin is able to update role status of a Admin with valid Admin id
	# Given User creates POST request with all fields "<userComments>","<userEduPg>","<userEduUg>","<userFirstName>", "<userLastName>","<userMiddleName>","<userLinkedinUrl>", "<userLocation>","<userPhoneNumber>","<userTimeZone>","<userVisaStatus>"
	# When User sends "LMSupdateUser" with "Put" Request with endpoint
	# Then User receives 200 Created Status with response body
	 
	#Examples: 
		#	 	  | userComments | userEduPg| userEduUg|userFirstName|userLastName|userMiddleName| userLinkedinUrl|userLocation|userPhoneNumber|userTimeZone|userVisaStatus|
		#		  | User Updated | BCA      | MCA      | User Updated   | Last     | M           |www.linkedin.com|USA         |   55  | EST        | H4-EAD       |
	
	#---(Update user Role Status)---
	#@update_user_UpdateuserRoleStatus
	# Scenario Outline: Check if admin is able to update role status of a Admin with valid Admin id
	# Given User creates PUT request with all fields "<roleId>","<userRoleStatus>"
	# When User sends "LMSupdateUserStatus" with "Put" Request with endpoint
	# Then User receives 200 Created Status with response body

	 #Examples: 
	 #| roleId | userRoleStatus|
	 #|R03|Inactive|  	 

	 #---(Update user Role ID)---

	#@update_user_UpdateuserRoleID
	 #Scenario Outline: Check if admin is able to update role ID 
	 #Given User creates PUT request with all fields "<userRoleList>"
	 #When User sends "LMSupdateUserRoleId" with "Put" Request with endpoint
	 #Then User receives 200 Created Status with response body

	 #Examples: 
	 #| userRoleList | 
	 #|R01|
	
	#@update_user_updateUserLoginStatus
	# Scenario Outline: Check if admin is able to update UserLoginStatus 
	# Given User creates PUT request with all fields "<loginStatus>","<password>","<roleIds>","<status>","<userLoginEmail>"
	# When User sends "LMSupdateUserLoginStatus" with "Put" Request with endpoint
	# Then User receives 200 Created Status with response body

	 #Examples: 
	 #| loginStatus | password | roleIds|status| userLoginEmail|
	 #|     Active  |       123|     R01   | Active | Shtest65@gmail.com|
	
	@update_user_UpdateUserBatchProgram
	 Scenario Outline: Check if admin is able to update UserRoleProgramBatchStatus
	 Given User creates PUT request with all fields
	 When User sends "LMSupdateUserRoleProgramBatchStatus" with "Put" Request with endpoint
	 Then User receives 200 Created Status with response body

	 #Examples: 
	 #| userRoleList | 
	 #|R01|
	
	 
	# @delete_user
	# Scenario: Check if Admin able to delete a Staff with valid Admin Id
	# Given User creates post Request to delete Staff details
	# When User sends "LMSdeleteUser" with "Delete" Request with endpoint
	# Then User receives 200 Created Status with response body
	 
	 # @delete_user
	 #Scenario: Check if Admin able to delete a Student with valid Admin Id
	 #Given User creates post Request to delete Student details
	 #When User sends "LMSdeleteUser" with "Delete" Request with endpoint
	 #Then User receives 200 Created Status with response body
	 