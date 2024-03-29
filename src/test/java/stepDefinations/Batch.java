package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import Utilities.datareader;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Batch{
	
<<<<<<< HEAD
	login log = new login();
	
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
=======
	datareader d=new datareader();
>>>>>>> branch 'master' of https://github.com/shreyadas1421/RestAssured.git

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
		
	}
<<<<<<< HEAD
	
=======
>>>>>>> branch 'master' of https://github.com/shreyadas1421/RestAssured.git
}
