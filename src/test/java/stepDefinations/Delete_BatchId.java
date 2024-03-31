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

public class Delete_BatchId {
	
	RequestSpecification request;
	Response response;
	String TOKEN;
	
	@Given("Admin creates DELETE Request with valid BatchId")
	public void admin_creates_delete_request_with_valid_batch_id() {
		
		RestAssured.baseURI= "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/batches/"+ AppConfig.BATCH_ID1; //AppConfig.PROGRAM_ID_1;

	    
		request = given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer " + AppConfig.TOKEN);
	    
	}

	@When("Admin sends HTTPS Request  with endpoint and batchId")
	public void admin_sends_https_request_with_endpoint_and_batch_id() {
		response = request.delete();
	    
	}

	@Then("Admin receives {int} Ok status with message")
	public void admin_receives_ok_status_with_message(Integer statusCode) {
		response.then().log().all().assertThat().statusCode(statusCode);
		

	    
	}

	@Given("Admin creates DELETE Request with valid BatchId and invalid enpoint")
	public void admin_creates_delete_request_with_valid_batch_id_and_invalid_enpoint() {
	    
RestAssured.baseURI= "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/batches/invalid";

	    
		request = given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer " + AppConfig.TOKEN);
	    
	}

	@When("Admin sends HTTPS Request  with invalid endpoint and batchId")
	public void admin_sends_https_request_with_invalid_endpoint_and_batch_id() {
	    
		response = request.delete();
	}

	@Then("Admin receives {int} not found")
	public void admin_receives_not_found(Integer statusCode) {
	    
		response.then().log().all().assertThat().statusCode(statusCode);
	}

	@Given("Admin creates DELETE Request with invalid BatchId")
	public void admin_creates_delete_request_with_invalid_batch_id() {
	    
RestAssured.baseURI= "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/batches/0000";

	    
		request = given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer " + AppConfig.TOKEN); 
	}

	@When("Admin sends HTTPS Request  with endpoint and invalid batchId")
	public void admin_sends_https_request_with_endpoint_and_invalid_batch_id() {
		response = request.delete();
	    
	}

	@Then("Admin receives {int} Not Found Status with message and boolean success details")
	public void admin_receives_not_found_status_with_message_and_boolean_success_details(Integer statusCode) {
	    
		response.then().log().all().assertThat().statusCode(statusCode);
	}

	@Given("Admin creates DELETE Request with valid BatchId and unAuth")
	public void admin_creates_delete_request_with_valid_batch_id_and_un_auth() {
	    
RestAssured.baseURI= "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/batches/16306"; //AppConfig.PROGRAM_ID_1;

	    
		
		request = given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer " + TOKEN);
		
	}

	@When("Admin sends HTTPS Request  with endpoint and without authorization")
	public void admin_sends_https_request_with_endpoint_and_without_authorization() {
		response = request.auth().none().delete();
	    
	}

	@Then("Admin receives {int} and message  {string}")
	public void admin_receives_and_message(Integer statusCode, String string) {
		response.then().log().all().assertThat().statusCode(statusCode);
	    
	}




}
