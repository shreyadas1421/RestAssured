package stepDefinations;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.testng.Assert;

import Utilities.AppConfig;
import Utilities.ReusableMethod;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getbatchid extends ReusableMethod {
	//RequestSpecification request; 
	Response geta,getb,getc;
	Utilities.token t = new Utilities.token();
	/*@Before
	public void specify() {
		request=given().baseUri("https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms");
		
	}*/
@Given("GET BatchId Authorized with bearer Token")
public void get_batch_id_authorized_with_bearer_token() throws IOException {
	 if(AppConfig.TOKEN== null) {
			t.login();
		    }
}

@When("Sends HTTP GET batch request with BatchId valid endpoints")
public void sends_http_get_batch_request_with_batch_id_valid_endpoints() throws IOException {
	geta=given()
			 .header("Authorization","Bearer "+AppConfig.TOKEN)
			 //.spec(reusableSpecBuilder())
			 //.get("/batches/batchId/"+AppConfig.BatchID)
			 .get("https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/batches/batchId/8563")
			 .then()
			 .extract()
			 .response();
	System.out.println(geta.asPrettyString());
}

@Then("Gets {int} status code for get batchID with response body")
public void gets_status_code_for_get_batch_id_with_response_body(Integer code) {
int statusCode = geta.getStatusCode();
	
	System.out.println("Expected status code returned::::: "+statusCode);
	Assert.assertEquals(statusCode, code , "Expected status code returned");
	String statusLine = geta.getStatusLine(); 
	System.out.println(statusLine);
	Assert.assertEquals(statusLine, "HTTP/1.1 200 ", "Correct status code is not returned");
	Assert.assertEquals(geta.contentType(),"application/json");
   
	Assert.assertTrue(geta.body().asString().contains("batchId"));
	//Assert.assertTrue(geta.body().asString().contains("SDET"));
	geta.then().assertThat().body("batchStatus",equalTo("Active")).
	body("batchNoOfClasses",equalTo(4))
	.body("batchId",equalTo(AppConfig.BatchID));
	
	geta.then().assertThat().body(matchesJsonSchemaInClasspath("id.json"));
}

@Given("Get batchId token is invalid")
public void get_batch_id_token_is_invalid() {
    
    
}


@When("Sends HTTP GET batch requests  with BatchId valid endpoints")
public void sends_http_get_batch_requests_with_batch_id_valid_endpoints() throws IOException {
	getb=given()
			 .header("Authorization","Bearer 12"+AppConfig.TOKEN)
			 //.spec(reusableSpecBuilder())
			 .get("/batches/batchId/"+AppConfig.BatchID)
			 .then().extract()
			 .response(); 
	System.out.println(getb.asPrettyString());
}


@Then("Gets {int} status code for get batchID with unauthorised message")
public void gets_status_code_for_get_batch_id_with_unauthorised_message(Integer code) {
	int statusCode = getb.getStatusCode();
	System.out.println("Expected status code returned::::: "+statusCode);
	Assert.assertEquals(statusCode, code , "Expected status code returned");
	Assert.assertEquals(getb.contentType(),"application/json");
   
	Assert.assertTrue(getb.body().asString().contains("Unauthorized"));
    
}

@When("Sends HTTP GET batch request with BatchId invalid endpoints")
public void sends_http_get_batch_request_with_batch_id_invalid_endpoints() throws IOException {
    
	getc= given()
			 .header("Authorization","Bearer "+AppConfig.TOKEN)
			 //.spec(reusableSpecBuilder())
			// .get("/batches/batchId/")
			 .get("https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/batchesbatchId/8563")
			 .then().extract()
			 .response(); 
	System.out.println(getc.asPrettyString());
}


@Then("Gets {int} status for get batchID with error message")
public void gets_status_for_get_batch_id_with_error_message(Integer code) {
	int statusCode = getc.getStatusCode();
	System.out.println("Expected status code returned::::: "+statusCode);
	Assert.assertEquals(statusCode, code , "Expected status code returned");
	
	Assert.assertEquals(getc.contentType(),"application/json");
   if(code==405) {
	
	Assert.assertTrue(getc.body().asString().contains("Method Not Allowed"));
   }
   else {
	   Assert.assertTrue(getc.body().asString().contains("Batch not found with Id : 2345"));  
   }
}

@When("Sends HTTP GET batch request with invalid BatchId and valid endpoints")
public void sends_http_get_batch_request_with_invalid_batch_id_and_valid_endpoints() throws IOException {
    
	getc= given()
			 .header("Authorization","Bearer "+AppConfig.TOKEN)
			 //.spec(reusableSpecBuilder())
			 //.get("/batches/batchId/2345")
			 .get("https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/batches/batchId/5552222")
			 .then().extract()
			 .response();   
	System.out.println(getc.asPrettyString());
}

@When("Sends HTTP GET batch request with BatchId parameter and value")
public void sends_http_get_batch_request_with_batch_id_parameter_and_value() throws IOException {
	geta=given()
			 .header("Authorization","Bearer "+AppConfig.TOKEN)
			 //.spec(reusableSpecBuilder())
			 //.get("/batches/batchId/"+AppConfig.BatchID+"?batches=6909")
			 .get("https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/batches/batchId/8563?batches=6909")
			 .then().extract()
			 .response(); 
	System.out.println(geta.asPrettyString());
}

@Then("Gets {int} status for get batchID with response body")
public void gets_status_for_get_batch_id_with_response_body(Integer code) throws IOException {
int statusCode = geta.getStatusCode();
	
	System.out.println("Expected status code returned::::: "+statusCode);
	Assert.assertEquals(statusCode, code , "Expected status code returned");
	String statusLine = geta.getStatusLine(); 
	System.out.println(statusLine);
	Assert.assertEquals(statusLine, "HTTP/1.1 200 ", "Correct status code is not returned");
	Assert.assertEquals(geta.contentType(),"application/json");
   
	Assert.assertTrue(geta.body().asString().contains("batchId"));
	//Assert.assertTrue(geta.body().asString().contains("SDET"));
	geta.then().assertThat().body("batchStatus",equalTo("Active")).
	body("batchNoOfClasses",equalTo(4))
	.body("batchId",equalTo(AppConfig.BatchID));  
	
    t.logout();
}



}
