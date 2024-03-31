package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.apache.http.StatusLine;
import org.testng.Assert;

import Utilities.AppConfig;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getBatch {

	Response geta,getb,getc,getv;
	 String token;
	RequestSpecification request;  
	@Before
	public void specify() {
		request=given().baseUri("https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms");
		
	}

@Given("GET Batches Authorized with bearer Token")
public void get_batches_authorized_with_bearer_token() {
	
   
}

@When("Sends HTTP GET batch request with valid endpoints")
public void sends_http_get_batch_request_with_valid_endpoints() {
	geta=given()
			 .header("Authorization","Bearer "+AppConfig.TOKEN)
			 .spec(request)
			 .get("/batches")
			 .then().extract()
			 .response();
   
}

@Then("Gets {int} status code for get batch with response body")
public void gets_status_code_for_get_batch_with_response_body(Integer code) {
	int statusCode = geta.getStatusCode();
	
	System.out.println("Expected status code returned::::: "+statusCode);
	Assert.assertEquals(statusCode, code , "Expected status code returned");
	String statusLine = geta.getStatusLine(); 
	System.out.println(statusLine);
	Assert.assertEquals(statusLine, "HTTP/1.1 200 ", "Correct status code is not returned");
	Assert.assertEquals(geta.contentType(),"application/json");
   
	Assert.assertTrue(geta.body().asString().contains("batchId"));
   
}

@Given("Get batch token is invalid")
public void get_batch_token_is_invalid() {
  
   token="yJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJudW1weW5pbmphQGdtYWlsLmNvbSIsImlhdCI6MTcx";
   getb=given()
		     .header("Authorization","Bearer "+token)
			 .spec(request)
			 .get("/batches")
			 .then().extract()
			 .response();
}

@Then("Gets {int} status code for get batch with unauthorised message")
public void gets_status_code_for_get_batch_with_unauthorised_message(Integer code) {
	int statusCode = getb.getStatusCode();
	System.out.println("Expected status code returned::::: "+statusCode);
	Assert.assertEquals(statusCode, code , "Expected status code returned");
	Assert.assertEquals(getb.contentType(),"application/json");
   
	Assert.assertTrue(getb.body().asString().contains("Unauthorized"));
}


@When("Sends HTTP GET batch request with invalid endpoints")
public void sends_http_get_batch_request_with_invalid_endpoints() {
	getb=given()
		     .header("Authorization","Bearer "+AppConfig.TOKEN)
			 .spec(request)
			 .get("/batch")
			 .then().extract()
			 .response();
   
}

@Then("Gets {int} status for get batch with error message Not Found")
public void gets_status_for_get_batch_with_error_message_not_found(Integer code) {
  
	int statusCode = getb.getStatusCode();
	System.out.println("Expected status code returned::::: "+statusCode);
	Assert.assertEquals(statusCode, code , "Expected status code returned");
	
	Assert.assertEquals(getb.contentType(),"application/json");
   
	Assert.assertTrue(getb.body().asString().contains("Not Found"));
}

@When("Sends HTTP GET batch request with search endpoints")
public void sends_http_get_batch_request_with_search_endpoints() {
	getc=given()
		     .header("Authorization","Bearer "+AppConfig.TOKEN)
			 .spec(request)
			 .get("/batches?search")
			 .then().extract()
			 .response();
   
}

@Then("Gets {int} status for get batch with response body")
public void gets_status_for_get_batch_with_response_body(Integer code) {
	int statusCode = getc.getStatusCode();
	System.out.println("Expected status code returned::::: "+statusCode);
	Assert.assertEquals(statusCode, code , "Expected status code returned");
	String statusLine = getc.getStatusLine(); 
	System.out.println(statusLine);
	Assert.assertEquals(statusLine, "HTTP/1.1 200 ", "Correct status code is not returned");
	Assert.assertEquals(getc.contentType(),"application/json");
   
	Assert.assertTrue(getc.body().asString().contains("batchId"));
   
}

@When("Sends HTTP GET batch request with parameter and value")
public void sends_http_get_batch_request_with_parameter_and_value() {
	getc=given()
		     .header("Authorization","Bearer "+AppConfig.TOKEN)
			 .spec(request)
			 .get("/batches?batches=400")
			 .then().extract()
			 .response();
	
}



}
