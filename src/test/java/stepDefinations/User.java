package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import Utilities.datareader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import Utilities.EndPoints;
import Utilities.ReusableMethod;

public class User extends ReusableMethod{
	
	ResponseSpecification resspec;
	RequestSpecification res;
	RequestSpecification res1;
	static Response response;
	static Response resbody;
 

	datareader d=new datareader();
	login l= new login();
	
		
	//Creation of User	
		@Given("Admin creates POST request with all mandatory fields")
		public void admin_creates_post_request_with_all_mandatory_fields() throws IOException {
			 res=given().log().all().spec(reusableSpecBuilder()).body(d.userCreation())
					 .header("Authorization","Bearer "+ l.adimn_should_get_auto_generated_token());
		}
	
	// Sending  Post/Get/Put request
		@When("Admin sends {string} with {string} Request with endpoint")
		public void admin_sends_with_request_with_endpoint(String resources1, String method1){

			EndPoints endPoint=EndPoints.valueOf(resources1);
			System.out.println(endPoint.getResources());
			
			 resspec=new ResponseSpecBuilder().build();
			 
			 if(method1.equalsIgnoreCase("Post")){
				 response=res.when().post(endPoint.getResources());
			 }else if(method1.equalsIgnoreCase("Get")) {
				 response=res1.when().get(endPoint.getResources());
			 }
			
		}
	
	//Validate response body & status code
		@Then("Admin receives {int} Created Status with response body.")
		public void admin_receives_created_status_with_response_body(Integer int1) {
			assertEquals(response.getStatusCode(),201);
			
			resbody=response.then().log().all().extract().response();
			System.out.println("User ID created :"+ getJsonPath(resbody,"userId"));
			System.out.println("User First Name as :"+ getJsonPath(resbody,"userFirstName"));
			
}

}
