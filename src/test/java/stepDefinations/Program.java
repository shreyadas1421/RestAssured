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
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Program {

	RequestSpecification request;
	Response response;

	Map<String, String> dataMap;
	
	//login log = new login();

	@Given("User is Authorized")
	public void user_is_authorized() {

		/*if (AppConfig.TOKEN == null) {
			login l = new login();
			try {
				l.userable_to_log_in();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}*/
		System.out.println("Token: " + AppConfig.TOKEN);
	}

	@Given("Admin creates {string} Request for the LMS with request body {string} and {int}")
	public void admin_creates_post_request_for_the_lms_with_request_body(String method, String sname, int rno) {

		dataMap = ExcelReader.getTestData(sname, rno);
		System.out.println("DATA_MAP " + dataMap);

		ProgramPojo pp = new ProgramPojo();
		
		RestAssured.baseURI= "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms";
		String ep = dataMap.get("endPoint");

		ep = ep.replaceAll("\\{programId\\}", AppConfig.PROGRAM_ID_1 + "");
		ep = ep.replaceAll("\\{programName\\}", AppConfig.PROGRAM_NAME_1);

		RestAssured.basePath = ep;

		Random ran = new Random();

		String programName = dataMap.get("programName") + "-" + ran.nextInt(100, 500);

		pp.setProgramName(programName);
		pp.setProgramDescription(dataMap.get("programDescription"));
		pp.setProgramStatus(dataMap.get("programStatus"));

		request = RestAssured.given().contentType(ContentType.JSON).header("Authorization",
				"Bearer " + AppConfig.TOKEN);

		if (dataMap.get("authorization").equalsIgnoreCase("N")) {
			request = request.auth().none();
		}

		if ("post".equalsIgnoreCase(method) || "PUT".equalsIgnoreCase(method)) {
			request = request.body(pp);
		}
	}

	@Given("Admin creates {string} Request for the LMS API with programID")
	public void admin_creates_get_request_for_the_lms_api_with_programID(String method) {

		RestAssured.basePath = "/programs/" + AppConfig.PROGRAM_ID;
		request = RestAssured.given().contentType(ContentType.JSON).header("Authorization",
				"Bearer " + AppConfig.TOKEN);

	}

	@When("Admin sends {string} Request with invalid BaseURI for Program {string}")
	public void admin_sends_get_request_with_invalid_BaseURI_for_program(String method, String uri) {

		if ("get".equalsIgnoreCase(method)) {
			response = request.get(uri);
		}
		if ("put".equalsIgnoreCase(method)) {
			response = request.get(uri);
		}

	}

	@When("Admin sends {string} Request and request Body with endpoint for Program")
	public void admin_sends_https_request_and_request_body_and_with_endpoint(String method) {

		if ("post".equalsIgnoreCase(method)) {
			response = request.log().all().post();
		} else if ("put".equalsIgnoreCase(method)) {
			response = request.log().all().put();
		} else if ("get".equalsIgnoreCase(method)) {
			response = request.log().all().get();
		} else if ("delete".equalsIgnoreCase(method)) {
			response = request.log().all().delete();
		}

	}

	@Then("Admin receives {int} {string} Status with response body for Program")
	public void admin_receives_status_with_response_body_for_Program(Integer statusCode, String statusLine) {

		response.then().log().all().assertThat().statusCode(statusCode);

		if (statusCode == 201) {
			
			response.then().assertThat().contentType(ContentType.JSON).body(JsonSchemaValidator.matchesJsonSchemaInClasspath("program.json"));
			
			if (AppConfig.PROGRAM_ID == 0 || AppConfig.PROGRAM_NAME == null) {

				AppConfig.PROGRAM_ID = response.body().jsonPath().get("programId");
				AppConfig.PROGRAM_NAME = response.body().jsonPath().getString("programName");
				System.out.println("ProgramId: " + AppConfig.PROGRAM_ID);

			} else {

				AppConfig.PROGRAM_ID_1 = response.body().jsonPath().get("programId");
				AppConfig.PROGRAM_NAME_1 = response.body().jsonPath().getString("programName");
				System.out.println("ProgramId_1: " + AppConfig.PROGRAM_ID_1);

			}

		}

		if ("PUT".equalsIgnoreCase(dataMap.get("method"))) {

			if (statusCode == 200) {
				
				response.then().assertThat().contentType(ContentType.JSON).body(JsonSchemaValidator.matchesJsonSchemaInClasspath("program.json"));

				AppConfig.PROGRAM_NAME_1 = response.body().jsonPath().getString("programName");

			}
		}

	}

	@Then("Admin receives {int} {string} Status with response body for Program for invalid base url")
	public void admin_receives_status_with_response_body_for_Program_for_invalid_base_url(Integer statusCode,
			String statusLine) {

		response.then().log().all().assertThat().statusCode(statusCode);
	}
}