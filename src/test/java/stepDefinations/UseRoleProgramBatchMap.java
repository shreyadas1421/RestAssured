package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import Utilities.AppConfig;
import Utilities.EndPoints;
import Utilities.ReusableMethod;
import Utilities.datareader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UseRoleProgramBatchMap extends ReusableMethod{
	
	static RequestSpecification resUserRole;
	RequestSpecification resdelete;
	Response responseUserRole;
	static Response resbodyUsrRole;
	

	

@Given("UserRoleProgramBatchMap creates get request with Authorization")
public void user_role_program_batch_map_creates_get_request_with_authorization() throws IOException {
	resUserRole=given().log().all().spec(reusableSpecBuilder()).header("Authorization","Bearer "+ AppConfig.TOKEN);
	
}

@When("UserRoleProgramBatchMap sends {string} with {string} Request with endpoint")
public void user_role_program_batch_map_sends_with_request_with_endpoint(String resources2, String method2) {
	
	EndPoints endPoint=EndPoints.valueOf(resources2);
	System.out.println(endPoint.getResources());
	
	if(method2.equalsIgnoreCase("Get")) {
		 
	 	 if(resources2.equalsIgnoreCase("LMSgetUserProgramBatch")) 
	 	 		{
	 			responseUserRole=resUserRole.when().get(endPoint.getResources()+ "/" + AppConfig.userID);
	 			}else if(resources2.equalsIgnoreCase("LMSgetUserProgramBatchInvalid")) 
	 			{
	 			  responseUserRole=resUserRole.when().get(endPoint.getResources()+ "/" + "U0");
		 			} else
		 			{
		 				responseUserRole=resUserRole.when().get(endPoint.getResources());
		 			}
		}else if (method2.equalsIgnoreCase("Delete")) {
			if(resources2.equalsIgnoreCase("LMSDeleteProgramBatche"))
			{
				responseUserRole=resUserRole.when().delete(endPoint.getResources()+ "/" + AppConfig.userID);
			}
			else if(resources2.equalsIgnoreCase("LMSDeleteProgramBatcheInvalid"))
			{
				responseUserRole=resUserRole.when().delete(endPoint.getResources()+ "/" + "U0");
			}
			}
}

@Then("UserRoleProgramBatchMap receives {int} Created Status with response body")
public void user_role_program_batch_map_receives_created_status_with_response_body(Integer int1) {
   
	resbodyUsrRole=responseUserRole.then().log().all().extract().response();
	
	if (responseUserRole.getStatusCode()==200) {
		assertEquals(responseUserRole.getStatusCode(),200);
	}
	else if (responseUserRole.getStatusCode()==404) {
		System.out.println(getJsonPath(resbodyUsrRole,"message"));
		System.out.println(getJsonPath(resbodyUsrRole,"success"));
		assertEquals(resbodyUsrRole.getStatusCode(),404);
		}
}

@Given("UserRoleProgramBatchMap creates delete request with Authorization")
public void user_role_program_batch_map_creates_delete_request_with_authorization() throws IOException {
	resdelete=given().log().all().spec(reusableSpecBuilder()).header("Authorization","Bearer "+ AppConfig.TOKEN);
}
	}

