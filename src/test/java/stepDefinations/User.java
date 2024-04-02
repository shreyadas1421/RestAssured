package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import POJO.UserGetPojo;
import POJO.UserGet_roles;
import Utilities.datareader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import Utilities.AppConfig;
import Utilities.EndPoints;
import Utilities.ReusableMethod;

public class User extends ReusableMethod{
	
	ResponseSpecification resspec;
	RequestSpecification res;
	RequestSpecification res1;
	RequestSpecification res2;
	RequestSpecification res3;
	RequestSpecification res4;
	RequestSpecification res5;
	static RequestSpecification res6;
	static RequestSpecification res7;
	RequestSpecification res8;
	
	// Store newly created User roles 
	static Map<String, String> ioMapRoles= new HashMap<>();
	
	static Response response;
	static Response resbody;
	static String userId;
	static String userRole;
	static String role_id;

	datareader d=new datareader();
	login l= new login();
	
		
	//POST--Create User
	
	   //Using Scenario outline
			@Given("User creates POST request with all fields {string},{string},{string},{string}, {string},{string},{string},{string},{string}, {string},{string},{string},{string},{string}")
			public void user_creates_post_request_with_all_fields(String userComments, String userEduPg, String userEduUg, String userFirstName, String userLastName, String userLinkedinUrl, String password, String userLoginEmail, String userMiddleName, String userPhoneNumber, String roleId, String userRoleStatus, String userTimeZone, String userVisaStatus) throws IOException
				   {
					      
						res=given().log().all().spec(reusableSpecBuilder()).body(d.userCreationFeature(userComments,userEduPg,userEduUg,userFirstName,userLastName,userLinkedinUrl,password,userLoginEmail,userMiddleName,userPhoneNumber,roleId,userRoleStatus,userTimeZone,userVisaStatus))
								 .header("Authorization","Bearer "+ AppConfig.TOKEN);
	 
					}
	
		//Excel DataDriven
			@Given("User creates POST Request for the LMS with request body {string} and {int}")
				public void user_creates_post_request_for_the_lms_with_request_body_and(String sheetname, int rownumber) throws IOException
					{
	    
					res=given().log().all().spec(reusableSpecBuilder()).body(d.userCreationexcel(sheetname,rownumber))
							.header("Authorization","Bearer "+ AppConfig.TOKEN);
	
					}
	//GET-- Get user
			
			@Given("User creates get request with Authorization")
			public void user_creates_get_request_with_authorization() throws IOException {
				res1=given().log().all().spec(reusableSpecBuilder()).header("Authorization","Bearer "+ AppConfig.TOKEN);
			
			}
			
	//POST-- Request	
			// Update user
				
				@Given("User creates POST request with all fields {string},{string},{string},{string}, {string},{string},{string}, {string},{string},{string},{string}")
				public void user_creates_post_request_with_all_fields(String userComments, String userEduPg, String userEduUg, String userFirstName, String userLastName, String userMiddleName, String userLinkedinUrl, String userLocation, String userPhoneNumber, String userTimeZone, String userVisaStatus) throws IOException {
					res2=given().log().all().spec(reusableSpecBuilder()).body(d.userUpdate(userComments, userEduPg, userEduUg, userFirstName, userLastName, userLinkedinUrl, userMiddleName, userPhoneNumber, userTimeZone, userVisaStatus,userLocation))
							 .header("Authorization","Bearer "+ AppConfig.TOKEN);

				}
				
			//Update user role status
				
				@Given("User creates PUT request with all fields {string},{string}")
					public void user_creates_put_request_with_all_fields(String roleId, String userRoleStatus) throws IOException {
						   
					res3=given().log().all().spec(reusableSpecBuilder()).body(d.userRoleStatusUpdate(roleId,userRoleStatus))
									 .header("Authorization","Bearer "+ AppConfig.TOKEN);
							
							
				}

				
			//update user role ID
				
				@Given("User creates PUT request with all fields {string}")
				public void user_creates_put_request_with_all_fields(String roleID) throws IOException {
					res4=given().log().all().spec(reusableSpecBuilder()).body(d.userRoleIdUpdate(roleID))
							 .header("Authorization","Bearer "+ AppConfig.TOKEN);
			
				}
				
				
		   //update user login status
				@Given("User creates PUT request with all fields {string},{string},{string},{string},{string}")
						public void user_creates_put_request_with_all_fields(String loginStatus, String password, String roleIds, String status, String userLoginEmail) throws IOException {
					res5=given().log().all().spec(reusableSpecBuilder()).body(d.updateUserLoginStatus(loginStatus,password,roleIds,status,userLoginEmail))
							 .header("Authorization","Bearer "+ AppConfig.TOKEN);
			 
						}
		//update user with program & batch id
				@Given("User creates PUT request with all fields")
				public void user_creates_put_request_with_all_fields() throws IOException {
					res8=given().log().all().spec(reusableSpecBuilder()).body(d.updateUserRoleProgramBatchStatus())
							 .header("Authorization","Bearer "+ AppConfig.TOKEN);
			 
				}
				
	//DELETE--user staff
				@Given("User creates post Request to delete Staff details")
				public void user_creates_post_request_to_delete_staff_details() throws IOException {
					res6=given().log().all().spec(reusableSpecBuilder()).header("Authorization","Bearer "+ AppConfig.TOKEN);
					
				}
				
	//DELETE--user student
				@Given("User creates post Request to delete Student details")
				public void user_creates_post_request_to_delete_student_details() throws IOException {
						res7=given().log().all().spec(reusableSpecBuilder()).header("Authorization","Bearer "+ AppConfig.TOKEN);
					
				}

			
	//Sending http request with endpoint
			
			@When("User sends {string} with {string} Request with endpoint")
			public void user_sends_with_request_with_endpoint(String resources1, String method1){
				EndPoints endPoint=EndPoints.valueOf(resources1);
				System.out.println(endPoint.getResources());
				
				 resspec=new ResponseSpecBuilder().build();
				 
				 if(method1.equalsIgnoreCase("Post")){
						 	
						 response=res.when().post(endPoint.getResources());
				 }
				 else if(method1.equalsIgnoreCase("Get")) {
					 
					 	 if(resources1.equalsIgnoreCase("LMSgetSingleUser")) 
						 {
							response=res1.when().get(endPoint.getResources()+ "/" + userId);
						 }else if(resources1.equalsIgnoreCase("LMSgetUsersWithRoleId")) {
							response=res1.when().get(endPoint.getResources()+ "/" + role_id);
						 }else {
							 response=res1.when().get(endPoint.getResources());
						 }
				 }else if (method1.equalsIgnoreCase("Put")) {
					 if(resources1.equalsIgnoreCase("LMSupdateUser"))
					 {
					
					 response=res2.when().put(endPoint.getResources()+ "/" + userId);
					 }
					 
					 else if(resources1.equalsIgnoreCase("LMSupdateUserStatus"))
					 {
						 response=res3.when().put(endPoint.getResources()+ "/" + userId);
					 }
					 
					 else if(resources1.equalsIgnoreCase("LMSupdateUserRoleId"))
					 {
						 response=res4.when().put(endPoint.getResources()+ "/" + userId);
					 }
				     else if(resources1.equalsIgnoreCase("LMSupdateUserLoginStatus"))
				    {
					 response=res5.when().put(endPoint.getResources()+ "/" + userId);
				    }else if (resources1.equalsIgnoreCase("LMSupdateUserRoleProgramBatchStatus"))
				    	{
				    	response=res8.when().put(endPoint.getResources()+ "/" + AppConfig.userID);
				    }
				 }else if(method1.equalsIgnoreCase("Delete")) {
						 response=res6.when().delete(endPoint.getResources()+ "/" + ioMapRoles.get("New User Staff"));
						 response=res7.when().delete(endPoint.getResources()+ "/" + ioMapRoles.get("New User Student"));
					
				 }
			}
			
			
		// Response body validation with status code
			
			@Then("User receives {int} Created Status with response body")
			public void user_receives_created_status_with_response_body(Integer statuscode) {
				
				System.out.println("Status code for the request is: "+response.getStatusCode());
				
				//request payload validation with JsonPath
				resbody=response.then().log().all().extract().response();
				
					
				if(response.getStatusCode()==201) {
				System.out.println(getJsonPath(resbody,"userComments")+" With user ID: "+getJsonPath(resbody,"userId")+" created");
				assertEquals(response.getStatusCode(),201);
				
				// Json response body validation
				 userId= getJsonPath(resbody,"userId");
				 userRole=getJsonPath(resbody,"userComments");
				 ioMapRoles.put(userRole, userId);
				 System.out.println(ioMapRoles);
				 if (userRole.equalsIgnoreCase("New User Admin")){
				    AppConfig.userID=userId;
				    AppConfig.userFirstName=getJsonPath(resbody,"userFirstName");
				    System.out.println("User ID sent for other Modules -->" + AppConfig.userID);
				    System.out.println("User Name ent for other Modules -->" + AppConfig.userFirstName);
				   }
				 }
				else if (response.getStatusCode()==400) {
			 
				System.out.println(getJsonPath(resbody,"message"));
				System.out.println(getJsonPath(resbody,"success"));
				 assertEquals(response.getStatusCode(),400);
				 
				}else if (response.getStatusCode()==200) {
					assertEquals(response.getStatusCode(),200);
				}
				
				
			}
			
			//validate response body after GET 
			@Then("User validate the response json")
			public void user_validate_the_response_json() {
			    
				UserGetPojo usrgetPojo=response.as(UserGetPojo.class);
				List<UserGet_roles> userRole= usrgetPojo.getRoles();
				
				for(int i=0; i<userRole.size();i++) {
					role_id=usrgetPojo.getRoles().get(i).getRoleId();
					System.out.println(role_id);
					
				}
				
				
				
			}
			
}
