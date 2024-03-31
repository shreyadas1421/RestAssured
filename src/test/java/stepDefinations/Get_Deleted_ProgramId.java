package stepDefinations;

import static io.restassured.RestAssured.given;

import Utilities.AppConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Deleted_ProgramId {
	
	RequestSpecification request;
	Response response;
	
	@Given("Admin creates GET Request with  deleted program id")
	public void admin_creates_get_request_with_deleted_program_id() {
	   
		
RestAssured.baseURI= "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/batches/program/16306"; //AppConfig.PROGRAM_ID_1;
	    
		
		request = given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer " + AppConfig.TOKEN); 
	}

	@When("Admin sends HTTPS Request with endpoint and deleted programId")
	public void admin_sends_https_request_with_endpoint_and_deleted_program_id() {
	   
	    
		response = request.get();
	}

	@Then("Admin receives {int}  Not Found Status with message and boolean success details")
	public void admin_receives_not_found_status_with_message_and_boolean_success_details(Integer statusCode) {
	   
		response.then().log().all().assertThat().contentType(ContentType.JSON).statusCode(statusCode);
	}




}
