package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import Utilities.AppConfig;
import Utilities.Batchdatareader;
import Utilities.ReusableMethod;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Batch extends ReusableMethod{
	
	Response response,re, res;

	String postresponse;
	
	login log = new login();
	Batchdatareader b=new Batchdatareader();
	String Token ;
	Utilities.token t = new Utilities.token();
 /*RequestSpecification request;  
		@Before
		public void specify() {
			request=given().baseUri("https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms");
			
		}*/

	@Given("Authorized with bearer Token")
	public void authorized_with_bearer_token() throws IOException {
		 if(AppConfig.TOKEN== null) {
				t.login();
			    }
	}
   
@Test
    @When("Sends HTTP Post batch request with endpoints and Read data from external file")
    public void sends_http_post_batch_request_with_endpoints_and_read_data_from_external_file() throws IOException {
    	postresponse=given()
		.header("Authorization","Bearer "+AppConfig.TOKEN)
		.header("Content-Type", "application/json")
		.spec(reusableSpecBuilder())
        .body(b.batch()).log().all()
		.when().post("/batches")
		.then()
		.assertThat().statusCode(201).extract().response().asPrettyString();
System.out.println(postresponse);
JsonPath js= new JsonPath(postresponse);
AppConfig.BatchID=js.getInt("batchId");
AppConfig.BatchName=js.getString("batchName");
       
    }

    @Then("Gets {int} status code with response body")
    public void gets_status_code_with_response_body(Integer int1) {
        
       
    }

    @Given("Token is expired and invalid")
    public void token_is_expired_and_invalid() {
    	Token ="dffgdfgfghgfhgfh";
       
    }
@Test
    @When("Sends Http Post batch request with endpoints")
    public void sends_http_post_batch_request_with_endpoints() throws IOException {
    	System.out.println("********** Unauthorized ADMIN *********"); 
    	 re=given()
				.header("Authorization","Bearer "+Token)
				.header("Content-Type", "application/json")
				.spec(reusableSpecBuilder())
	            .body(b.batch()).log().all()
				.when().post("/batches")
				.then()
				.assertThat().statusCode(401).extract().response();
		//System.out.println(response);
    	 
}

    @Then("gets {int} unauthorised status code with error message")
    public void gets_unauthorised_status_code_with_error_message(Integer code) {
    	int statusCode = re.getStatusCode();
    	System.out.println("Expected status code returned::::: "+statusCode);
    	Assert.assertEquals(statusCode, code , "Expected status code returned");
    	
    	
    	Assert.assertEquals(re.contentType(),"application/json");
       
    	Assert.assertTrue(re.body().asString().contains("Unauthorized"));
    }
  
    @Given("Authorized with bearer Token {string}")
    public void authorized_with_bearer_token(String scenario) {   
    	System.out.println("**********"+scenario+"*********"); 	
    	
    }
    @When("Sends HTTP Post batch request  with invalid endpoint and Read data {string} {string} {int} {string} {int}")
    public void sends_http_post_batch_request_with_invalid_endpoint_and_read_data( String Bd, String Bn, Integer Bnc, String Bs, Integer PI) throws IOException {

         JSONObject req= new JSONObject();
    	 req.put("batchDescription",Bd);
    	 req.put("batchName",Bn);
    	 req.put("batchNoOfClasses",Bnc);
    	 req.put("batchStatus",Bs);
    	 req.put("programId",PI);
    	 System.out.println(req.toJSONString());
    	
	response=given()
			.header("Authorization","Bearer "+AppConfig.TOKEN)
			.header("Content-Type", "application/json")
			.spec(reusableSpecBuilder())
            .body(req.toJSONString()).log().all()
			.when().post("\batch")
			.then()
			.assertThat().extract().response();
	System.out.println(response);
	System.out.println(response.asPrettyString());
	//Assert.assertEquals(statusCode, code , "Correct status code returned");
}
@Test
@Then("Gets  {int} with response body")
public void gets_with_response_body(Integer code) throws IOException {
  
	
	int statusCode = response.getStatusCode();
	System.out.println(" status code returned::::: "+statusCode);
	Assert.assertEquals(statusCode, code , "Expected status code returned");
	Assert.assertEquals(response.contentType(),"application/json");
	Assert.assertTrue(response.body().asString().contains("Not Found"));
	
}

@When("Sends HTTP Post batch request with valid endpoints and Read data {string} {string} {int} {string} {int}")
public void sends_http_post_batch_request_with_valid_endpoints_and_read_data(String Bd, String Bn, Integer Bnc, String Bs, Integer PI) throws IOException {
   
	 JSONObject req= new JSONObject();
	 req.put("batchDescription",Bd);
	 req.put("batchName",Bn);
	 req.put("batchNoOfClasses",Bnc);
	 req.put("batchStatus",Bs);
	 req.put("programId",PI);
	 System.out.println(req.toJSONString());
	
res=given()
.header("Authorization","Bearer "+AppConfig.TOKEN)
.header("Content-Type", "application/json")
.spec(reusableSpecBuilder())
.body(req.toJSONString()).log().all()
.when().post("/batches")
.then()
.assertThat().extract().response();
System.out.println(res);
System.out.println(res.asPrettyString());
}


@Then("Gets  {int} with batch response body")
public void gets_with_batch_response_body(Integer code) throws IOException {
	int statusCode = res.getStatusCode();
	System.out.println(" status code returned::::: "+statusCode);
	Assert.assertEquals(statusCode, code , " Expected status code returned");	
	Assert.assertEquals(res.contentType(),"application/json");
	if(code==201) {
	Assert.assertTrue(res.body().asString().contains("SDET"));
	res.then().assertThat().body("batchStatus",equalTo("active")).
	body("batchNoOfClasses",equalTo(4));
	}
	else if(code==404) {
		Assert.assertTrue(res.body().asString().contains("not found"));
	}
	else {
		Assert.assertTrue(res.body().asString().contains("message"));
			
	}
	t.logout();
}
}
	


