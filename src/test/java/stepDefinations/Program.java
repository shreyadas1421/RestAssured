package stepDefinations;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

import POJO.ProgramPojo;
import Utilities.AppConfig;
import Utilities.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Program{
	
	RequestSpecification request;
	Response response;
	
	Map<String, String> dataMap;
	
	@Given("User is Authorized")
	public void user_is_authorized() {
		
		if(AppConfig.TOKEN==null) {
			login l = new login();
			try {
				l.userable_to_log_in();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		System.out.println("Token: " + AppConfig.TOKEN);
	}

	
	@Given("Admin creates POST Request for the LMS with request body {string} and {int}")
	public void admin_creates_post_request_for_the_lms_with_request_body(String sname, int rno) {
		
		dataMap = ExcelReader.getTestData(sname,rno);
		System.out.println("DATA_MAP " + dataMap);
		RestAssured.basePath= dataMap.get("endPoint");
		ProgramPojo pp = new ProgramPojo();
		Random ran = new Random();
		
		String programName = dataMap.get("programName")+ "-" + ran.nextInt(100,500);
		
		pp.setProgramName(programName);
		pp.setProgramDescription(dataMap.get("programDescription"));
		pp.setProgramStatus(dataMap.get("programStatus"));
				
		request = RestAssured.given()
			.contentType(ContentType.JSON)
			.header("Authorization","Bearer " + AppConfig.TOKEN);
		
		if(dataMap.get("authorization").equalsIgnoreCase("N")) {
			request = request.auth().none();		
		}
		
		request = request.body(pp);
	}

	
	@When("Admin sends POST Request and request Body with endpoint for Program")
	public void admin_sends_https_request_and_request_body_and_with_endpoint(){
		
		response = request.log().all().post();
		
	
	}
	
	@When("Admin sends GET Request and request Body with endpoint and invalid method for program")
	public void admin_sends_https_request_and_request_body_and_with_endpoint_and_invalid_method_for_program(){
		
		response = request.log().all().get();
	
	}
	
	@When("Admin sends POST Request and request Body with endpoint and without Authorization")
	public void admin_sends_https_request_and_request_body_with_endpoint_and_without_authorization() {
		
		response = request.auth().none().log().all().post();
	}
	
	@Then("Admin receives {int} {string} Status with response body for Program")
	public void admin_receives_status_with_response_body_for_Program(Integer statusCode, String statusLine) {
		
		response.then().log().all().assertThat().statusCode(statusCode);
		
		if (statusCode == 201) {
			AppConfig.PROGRAM_ID = response.body().jsonPath().get("programId");
			AppConfig.PROGRAM_NAME = response.body().jsonPath().getString("programName");
			System.out.println("ProgramId: " + AppConfig.PROGRAM_ID);
		}
	}
	
	
	@Then("Admin receives {int} {string} Status with response body for Program Negative")
	public void admin_receives_status_with_response_body_for_Program_Negative(Integer statusCode, String statusLine) {
		
		response.then().log().all().assertThat().statusCode(statusCode);
		
		if (statusCode == 201) {
			AppConfig.PROGRAM_ID_1 = response.body().jsonPath().get("programId");
			AppConfig.PROGRAM_NAME_1 = response.body().jsonPath().getString("programName");
			System.out.println("ProgramId_1: " + AppConfig.PROGRAM_ID_1);
		}
	}
	
	@Given("Admin creates GET Request for the LMS API")
	public void admin_creates_get_request_for_the_lms_api() {
		
		RestAssured.basePath = "/allPrograms";
		request = RestAssured.given()
					.contentType(ContentType.JSON)
					.header("Authorization","Bearer " + AppConfig.TOKEN);

	}
	
	@Given("Admin creates GET Request for the LMS API with {string} and {string}")
	public void admin_creates_get_request_for_the_lms_api_with_invalid_and(String endpoint, String auth) {
		
		RestAssured.basePath = endpoint;
		request = RestAssured.given()
					.contentType(ContentType.JSON)
					.header("Authorization","Bearer " + AppConfig.TOKEN);
		if("N".equalsIgnoreCase(auth)){
			
			request = request.auth().none();
			
		}
	}
	
	@Given("Admin creates GET Request for the LMS API with programID")
	public void admin_creates_get_request_for_the_lms_api_with_programID() {
		
		RestAssured.basePath = "/programs/" + AppConfig.PROGRAM_ID;
		request = RestAssured.given()
					.contentType(ContentType.JSON)
					.header("Authorization","Bearer " + AppConfig.TOKEN);

	}
	

	@When("Admin sends GET Request with endpoint for Program")
	public void admin_sends_get_request_with_endpoint_for_program() {

		response = request.get();
	
	}
	
	@When("Admin sends GET Request with invalid BaseURI for Program {string}")
	public void admin_sends_get_request_with_invalid_BaseURI_for_program(String uri) {
		
		
		response = request.get(uri);
	
	}
	
	@When("Admin sends POST Request with endpoint and invalid method for program")
	public void admin_sends_get_request_with_endpoint_and_invalid_method_for_program() {

		response = request.post();
	
	}
	
	@Given("Admin creates GET Request for the LMS API with invalid {string}")
	public void admin_creates_get_request_for_the_lms_api_with_invalid(String programId) {
		
		RestAssured.basePath = "/programs/" + programId ;
		request = RestAssured.given()
					.contentType(ContentType.JSON)
					.header("Authorization","Bearer " + AppConfig.TOKEN);

	}
	
	@Given("Admin creates GET Request for the LMS API with {string} and {string} programId")
	public void admin_creates_get_request_for_the_lms_api_with_invalid_and_programId(String endpoint, String auth) {
		
		RestAssured.basePath = endpoint + AppConfig.PROGRAM_ID;
		request = RestAssured.given()
					.contentType(ContentType.JSON)
					.header("Authorization","Bearer " + AppConfig.TOKEN);
		if("N".equalsIgnoreCase(auth)){
			
			request = request.auth().none();
			
		}

	}
	
}
