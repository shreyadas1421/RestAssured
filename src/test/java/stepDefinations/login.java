package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.AppConfig;
import Utilities.datareader;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class login{
	
	datareader d=new datareader();

	@Given("userable to log in")
	public void userable_to_log_in() throws IOException {
		RestAssured.baseURI="https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms";
		String response=given().log().all().header("Content-Type","application/json").
				body(d.login()).when().post("/login")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
				
				//System.out.println(response);
				
		JsonPath js= new JsonPath(response);
		String token_id=js.getString("token");
		
		//System.out.println(token_id);
		AppConfig.TOKEN = token_id;
	}
}
