package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.AppConfig;
import Utilities.Batchdatareader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class Batch{
	

	login log = new login();
	Batchdatareader b=new Batchdatareader();
 RequestSpecification request;  
		@BeforeSuite
		public void specify() {
			request=given().baseUri("https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms");
			
		}
	
	@BeforeTest
	@Given("Authorized with bearer Token")
	public void authorized_with_bearer_token() throws IOException {
	    
		log.userable_to_log_in();
	   
	}
    @Test(priority=1)
	@When("Send HTTP Post request with endpoints and Read data from external file")
	public void send_http_post_request_with_endpoints_and_read_data_from_external_file() throws IOException {
	
		Object response=given()
				.header("Authorization","Bearer "+AppConfig.TOKEN)
				.header("Content-Type", "application/json")
				.spec(request)
	            .body(b.batch())
				.when().post("/batches")
				.then()
				.assertThat().statusCode(201).extract().response().asString();
		
		JsonPath js= new JsonPath((String) response);
		AppConfig.BatchID=js.getInt("batchId");
		AppConfig.BatchName=js.getString("batchName");
	
	}


		
	

}
