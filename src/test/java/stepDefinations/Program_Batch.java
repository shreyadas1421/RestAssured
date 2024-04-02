package stepDefinations;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

import org.json.JSONObject;

import POJO.Program_BatchPojo;
import Utilities.AppConfig;
import Utilities.ExcelReader;
import Utilities.ExcelReaderBatch;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Program_Batch {
	
	
	
	RequestSpecification request;
	Response response;
	static String batch_id;
	
	Map<String, String> dataMap;
	Program_BatchPojo batch = new Program_BatchPojo();
	login log = new login();
	
	@Given("Admin creates POST Request  with valid data in request body {string} and {int}")
	public void admin_creates_post_request_with_valid_data_in_request_body_and(String sheetname, int rownumber) {
	    
		
		/*if(AppConfig.TOKEN==null) {
			login l = new login();
			try {
				l.userable_to_log_in();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		*/
		System.out.println("Token: " + AppConfig.TOKEN);
		
		dataMap = ExcelReaderBatch.getTestData(sheetname,rownumber);
		System.out.println("DATA_MAP " + dataMap);
		RestAssured.baseURI= "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/batches";//+dataMap.get("endPoint");
		
		Random ran = new Random();
		
		String batchName = dataMap.get("batchName")+ "-" + ran.nextInt();
		int programid= AppConfig.PROGRAM_ID;
		
		batch.setProgramId(programid);
		batch.setBatchName(batchName);
		batch.setBatchDescription(dataMap.get("batchDescription"));
		String batchNo= dataMap.get("batchNoOfclasses");
		System.out.println(AppConfig.BATCH_ID1);

		batch.setBatchNoOfClasses(Integer.parseInt(batchNo) );
		batch.setBatchStatus(dataMap.get("batchStatus"));
				
		request = given()
			.contentType(ContentType.JSON)
			.header("Authorization","Bearer " + AppConfig.TOKEN);
		
		request = request.body(batch);
	   
	}

	@When("Admin sends HTTPS Request with endpoint")
	public void admin_sends_https_request_with_endpoint() {
		response = request.log().all().post();
	   
	}

	@Then("Admin receives {int} and  {string} Status with response body.")
	public void admin_receives_and_status_with_response_body(int statuscode, String statusmessage) {
		response.then().log().all().assertThat().contentType(ContentType.JSON).statusCode(statuscode);
		System.out.println("responsebody"+response);
		
		/*JsonPath js= new JsonPath(response);
		batch_id=js.getString("batchId");
		System.out.println(getJsonPath(response,"batchId"));
		batch_id=getJsonPath(response,"batchId");
		
		return batch_id;*/
		
		if (statuscode == 201) {
			AppConfig.BATCH_ID1 = response.body().jsonPath().get("batchId");
			AppConfig.BATCH_NAME1 = response.body().jsonPath().getString("batchName");
			System.out.println("responsebody"+response);
			System.out.println("batchId: " + AppConfig.BATCH_ID1);
		}
		
		JSONObject responseBatch = new JSONObject(response.getBody().asString());
		
	   System.out.println("response: " +responseBatch );
	   
	  
	   
	   assertTrue(responseBatch.getString("batchName") instanceof String);
		 assertTrue(responseBatch.get("programId") instanceof Integer);
		 assertTrue(responseBatch.getString("batchName") instanceof String);
		 assertTrue(responseBatch.getString("batchDescription") instanceof String);
		 assertTrue(responseBatch.get("batchNoOfClasses") instanceof Integer);
		 assertTrue(responseBatch.getString("batchStatus") instanceof String);
		
		 
		 //assertEquals(responseBatch.getString("batchName"),batch.getBatchName() );
		 assertEquals(responseBatch.get("programId"),batch.getProgramId());
		 assertEquals(responseBatch.getString("batchDescription"),batch.getBatchDescription());
		 assertEquals(responseBatch.get("batchNoOfClasses") ,batch.getBatchNoOfClasses());
		 assertEquals(responseBatch.getString("batchStatus") ,batch.getBatchStatus());
   	
   	
	}



	

}
