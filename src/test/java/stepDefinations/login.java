package stepDefinations;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Assert;

import Utilities.AppConfig;
import Utilities.EndPoints;
import Utilities.ReusableMethod;
import Utilities.datareader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.RestAssured;

public class login extends ReusableMethod {

	ResponseSpecification resspec;
	RequestSpecification res;
	RequestSpecification res1;
	static Response response;
	static Response resbody;
    static String token_id;
	
	datareader d=new datareader();
	//Create Request for Login
		@Given("Admin creates request with valid credentials")
		public void admin_creates_request_with_valid_credentials() throws IOException {
		   
			 res=given().log().all().spec(reusableSpecBuilder()).body(d.login());
		}
		
		/*
		//Create request for Logout
		@Given("Admin creates request")
		public void admin_creates_request() throws IOException {
		
		res1=given().log().all().spec(reusableSpecBuilder()).header("Authorization","Bearer "+ token_id);
		
		System.out.println(res);
		System.out.println(token_id);
		}*/

		// validation for both login & Logout
		@When("Admin calls {string} with {string} http request with valid endpoint")
		public void admin_calls_with_http_request_with_valid_endpoint(String resources, String method) {
		  
			EndPoints endPoint=EndPoints.valueOf(resources);
			System.out.println(endPoint.getResources());
			
			 resspec=new ResponseSpecBuilder().expectStatusCode(200).build();
			 
			 if(method.equalsIgnoreCase("Post")){
				 response=res.when().post(endPoint.getResources());
			 }else if(method.equalsIgnoreCase("Get")) {
				 response=res1.when().get(endPoint.getResources());
			 }
			
		}

		@Then("Admin Should get {int} status")
		public void admin_should_get_status(Integer int1) {
		assertEquals(response.getStatusCode(),200);
		}

		@Then("Adimn should get auto generated token")
		public String adimn_should_get_auto_generated_token() {
		resbody=response.then().log().all().extract().response();

		
		//JsonPath js= new JsonPath(resbody);
		//token_id=js.getString("token");

		System.out.println(getJsonPath(resbody,"token"));
		token_id=getJsonPath(resbody,"token");
		
		return token_id;
		}
		
		

		// validation for login & logout
		@Then("Admin receives {int} ok  and response with {string}")
		public void admin_receives_ok_and_response_with(Integer int1, String string){
			
			assertEquals(response.getStatusCode(),200);
		
		}
		
		//Negative
		/*
		@Then("Admin receives {int} unauthorized")
		public void admin_receives_unauthorized(Integer int1) {
			System.out.println(response.getStatusCode());
			assertEquals(response.getStatusCode(),401);
		}

		@Given("Admin creates request with invalid credentials")
		public void admin_creates_request_with_invalid_credentials() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

		@Then("Admin receives {int} Bad request")
		public void admin_receives_bad_request(Integer int1) {
			System.out.println(response.getStatusCode());
			assertEquals(response.getStatusCode(),401);
		}*/
		
		@Given("userable to log in")
		public void userable_to_log_in() throws IOException {
			RestAssured.baseURI="https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms";
			String response=given().log().all().header("Content-Type","application/json").
					body(d.login()).when().post("/login")
					.then().log().all().assertThat().statusCode(200).extract().response().asString();
					
					System.out.println(response);
					
			JsonPath js= new JsonPath(response);
			String token_id=js.getString("token");
			
			System.out.println(token_id);
			AppConfig.TOKEN = token_id;
		}
	
		
	}
