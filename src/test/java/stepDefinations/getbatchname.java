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

public class getbatchname extends ReusableMethod {
	//RequestSpecification request; 
	Response geta;
	Utilities.token t = new Utilities.token();
	/*@Before
	public void specify() {
		request=given().baseUri("https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms");
		
	}*/
@Given("GET BatchName Authorized with bearer Token")
public void get_batch_name_authorized_with_bearer_token() throws IOException {
    if(AppConfig.TOKEN== null) {
	t.login();
    }
}

@When("Sends HTTP GET batch request with BatchName valid endpoints")
public void sends_http_get_batch_request_with_batch_name_valid_endpoints() throws IOException {
	geta=given()
			 .header("Authorization","Bearer "+AppConfig.TOKEN)
			 //.spec(reusableSpecBuilder())
			 //.get("/batches/batchName/"+AppConfig.BatchName)
			 .get("https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/batches/batchName/SDET251")
			 .then().extract()
			 .response();
	System.out.println(geta.asPrettyString()); 
    
}

@Then("Gets {int} status code for get BatchName with response body")
public void gets_status_code_for_get_batch_name_with_response_body(Integer code) {
	int statusCode = geta.getStatusCode();
	System.out.println("Expected status code returned::::: "+statusCode);
	Assert.assertEquals(statusCode, code , "Expected status code returned");
	String statusLine = geta.getStatusLine(); 
	System.out.println(statusLine);
	Assert.assertEquals(statusLine, "HTTP/1.1 200 ", "Correct status code is not returned");
	Assert.assertEquals(geta.contentType(),"application/json");
   
	Assert.assertTrue(geta.body().asString().contains("batchId"));
	Assert.assertTrue(geta.body().asString().contains("SDET"));
	//geta.then().assertThat().body(matchesJsonSchemaInClasspath("id.json"));
	//geta.then().assertThat()
	//.body("batchStatus",equalTo("active"))
	//.body("batchNoOfClasses",equalTo(4))
	//.body("batchName",equalTo(AppConfig.BatchName));
    
}

@Given("Get BatchName token is invalid")
public void get_batch_name_token_is_invalid() {
    
    
}

@When("Sends HTTP GET batch requests  with BatchName valid endpoints")
public void sends_http_get_batch_requests_with_batch_name_valid_endpoints() throws IOException {
    
	geta=given()
			 .header("Authorization","Bearer 12"+AppConfig.TOKEN)
			 .spec(reusableSpecBuilder())
			 .get("/batches/batchName/"+AppConfig.BatchName)
			 .then().extract()
			 .response(); 
	System.out.println(geta.asPrettyString());  
}

@Then("Gets {int} status code for get BatchName with unauthorised message")
public void gets_status_code_for_get_batch_name_with_unauthorised_message(Integer code) {
	int statusCode = geta.getStatusCode();
	System.out.println("Expected status code returned::::: "+statusCode);
	Assert.assertEquals(statusCode, code , "Expected status code returned");
	Assert.assertEquals(geta.contentType(),"application/json");
   
	Assert.assertTrue(geta.body().asString().contains("Unauthorized"));
    
}

@When("Sends HTTP GET batch request with BatchName invalid endpoints")
public void sends_http_get_batch_request_with_batch_name_invalid_endpoints() throws IOException {
	geta=given()
			 .header("Authorization","Bearer "+AppConfig.TOKEN)
			 //.spec(reusableSpecBuilder())
			 //.get("/batches/batchName"+AppConfig.BatchName)
			 .get("https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/batches/batchNameSDET251")
			 .then().extract()
			 .response(); 
	System.out.println(geta.asPrettyString());  
    
}

@Then("Gets {int} status for get BatchName with error message")
public void gets_status_for_get_batch_name_with_error_message(Integer code) {
	int statusCode = geta.getStatusCode();
	System.out.println("Expected status code returned::::: "+statusCode);
	Assert.assertEquals(statusCode, code , "Expected status code returned");
	
	Assert.assertEquals(geta.contentType(),"application/json");
   if(code==405) {
	
	Assert.assertTrue(geta.body().asString().contains("Method Not Allowed"));
   }
   else if(code==404)
   {
	   Assert.assertTrue(geta.body().asString().contains("not found"));  
   }  
    
}

@When("Sends HTTP GET batch request with invalid BatchName and valid endpoints")
public void sends_http_get_batch_request_with_invalid_batch_name_and_valid_endpoints() throws IOException {
    
	geta=given()
			 .header("Authorization","Bearer "+AppConfig.TOKEN)
			 //.spec(reusableSpecBuilder())
			 .get("https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/batches/batchName/qSDET251")
			 .then().extract()
			 .response(); 
	System.out.println(geta.asPrettyString());  
    
}

@When("Sends HTTP GET batch request with BatchName parameter and value")
public void sends_http_get_batch_request_with_batch_name_parameter_and_value() throws IOException {
	geta=given()
			 .header("Authorization","Bearer "+AppConfig.TOKEN)
			 //.spec(reusableSpecBuilder())
			 //.get("/batches/batchName/"+AppConfig.BatchName+"?batchId=8494")
			 .get("https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/batches/batchName/SDET251?batchId=8494")
			 .then().extract()
			 .response(); 
	System.out.println(geta.asPrettyString());  
	
}

@Then("Gets {int} status for get BatchName with response body")
public void gets_status_for_get_batch_name_with_response_body(Integer code) {
	int statusCode = geta.getStatusCode();
	System.out.println("Expected status code returned::::: "+statusCode);
	Assert.assertEquals(statusCode, code , "Expected status code returned");
	String statusLine = geta.getStatusLine(); 
	System.out.println(statusLine);
	Assert.assertEquals(statusLine, "HTTP/1.1 200 ", "Correct status code is not returned");
	Assert.assertEquals(geta.contentType(),"application/json");
   
	Assert.assertTrue(geta.body().asString().contains("batchId"));
	Assert.assertTrue(geta.body().asString().contains("SDET"));
	//geta.then().assertThat()
	//.body("batchStatus",equalTo("active"))
	//.body("batchNoOfClasses",equalTo(4))
	//.body("batchName",equalTo(AppConfig.BatchName));  
    
}



}
