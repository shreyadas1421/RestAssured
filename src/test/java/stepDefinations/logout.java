package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import Utilities.ReusableMethod;
import Utilities.datareader;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class logout extends ReusableMethod{
		
	RequestSpecification res1;
	static Response response;
	static Response resbody;
    static String token_id;
	
    login l= new login();

	//Create request for Logout
		@Given("Admin creates request")
		public void admin_creates_request() throws IOException {
		
		res1=given().log().all().spec(reusableSpecBuilder()).header("Authorization","Bearer "+  l.adimn_should_get_auto_generated_token());
		
	
		System.out.println(token_id);
		}
}
