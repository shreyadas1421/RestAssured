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

public class Get_Batch_ProgramId {
	
	
	RequestSpecification request;
	Response response;
	String TOKEN;
	
	@Given("Admin creates GET Request with program id and unAuth")
	public void admin_creates_get_request_with_program_id_and_unAuth() {
	  
		RestAssured.baseURI= "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/batches/program/16306"; //AppConfig.PROGRAM_ID_1;
	    
		
		request = given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer " + TOKEN);
			
			
		
	}

	@When("Admin sends HTTPS Request with endpoint and unAuth")
	public void admin_sends_https_request_with_endpoint_and_un_auth() {
	    
		response = request.auth().none().get();
	}

	@Then("Admin receives Status with {int} and statusmessage unauthorized")
	public void admin_receives_status_with_and_statusmessage_unauthorized(Integer statusCode) {
	    
		response.then().log().all().assertThat().contentType(ContentType.JSON).statusCode(statusCode);
	}

	@Given("Admin creates GET Request with valid ProgramId")
	public void admin_creates_get_request_with_valid_program_id() {
	    
		request = given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer " + AppConfig.TOKEN);
			
	    
	}

	@When("Admin sends HTTPS Request with endpoint with programId")
	public void admin_sends_https_request_with_endpoint_with_program_id() {
	    
		response = request.get();
	    
	}

	@Then("Admin receives {int} OK Status with response body.")
	public void admin_receives_ok_status_with_response_body(Integer statusCode) {
	    
		response.then().log().all().assertThat().contentType(ContentType.JSON).statusCode(statusCode);
	}

	@Given("Admin creates GET Request with invalid Program Id")
	public void admin_creates_get_request_with_invalid_program_id() {
		
		RestAssured.baseURI= "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/batches/program/0000"; //AppConfig.PROGRAM_ID_1;
	    
		request = given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer " + AppConfig.TOKEN);
	}

	@When("Admin sends HTTPS Request with endpoint with invalid programId")
	public void admin_sends_https_request_with_endpoint_with_invalid_program_id() {
	    
		response = request.get();
	}

	@Then("Admin receives {int} and Not Found Status with message and boolean success details")
	public void admin_receives_and_not_found_status_with_message_and_boolean_success_details(Integer statusCode) {
	    
		response.then().log().all().assertThat().contentType(ContentType.JSON).statusCode(statusCode);
	}

	@Given("Admin creates GET Request with invalid endpoint")
	public void admin_creates_get_request_with_invalid_endpoint() {
	    
	    
		RestAssured.baseURI= "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/batches/program/invalid"; //AppConfig.PROGRAM_ID_1;

		request = given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer " + AppConfig.TOKEN);
	}

	@When("Admin sends HTTPS Request with invalid endpoint")
	public void admin_sends_https_request_with_invalid_endpoint() {
	    
		response = request.get();
	}

	@Then("Admin receives {int}  Status with  error message Not Found.")
	public void admin_receives_status_with_error_message_not_found(Integer statusCode) {
	    
		response.then().log().all().assertThat().contentType(ContentType.JSON).statusCode(statusCode);
	}




}
