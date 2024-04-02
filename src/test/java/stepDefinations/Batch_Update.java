

package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

import org.json.JSONObject;

import POJO.Batch_UpdatePojo;
import POJO.Program_BatchPojo;
import Utilities.AppConfig;
import Utilities.ExcelReader;
import Utilities.ExcelReaderBatch;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/*
public class Batch_Update {
	
	

	RequestSpecification request;
	Response response;
	int batchid_dummy=8530;
	int programid= AppConfig.PROGRAM_ID;
	
	Batch_UpdatePojo batch_update = new Batch_UpdatePojo();
	
	Map<String, String> dataMap;
	
	login log = new login();

@Given("Admin creates PUT Request with the valid BatchId anddata {string} and {int}")
public void admin_creates_put_request_with_the_valid_batch_id_anddata_and(String sheetname, Integer rownumber) {
    
	if(AppConfig.TOKEN==null) {
		UserMap l = new UserMap();
		try {
			l.userable_to_log_in();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	System.out.println("Token: " + AppConfig.TOKEN);
	
	dataMap = ExcelReaderBatch.getTestData(sheetname,rownumber);
	System.out.println("DATA_MAP " + dataMap);
	RestAssured.baseURI= "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/batches/"+AppConfig.BATCH_ID1;//+dataMap.get("endPoint");+batchid_dummy;
	
	Random ran = new Random();
	
	String batchName = dataMap.get("batchName")+ "-" + ran.nextInt();
	String programName = dataMap.get("programName")+ "-" + ran.nextInt();
	
	int batchId= AppConfig.BATCH_ID1;//8530;
	
	//AppConfig.PROGRAM_ID1;
	
	
	batch_update.setProgramId(programid);
	batch_update.setBatchId(batchId);
	batch_update.setBatchName(batchName);
	batch_update.setProgramName(programName);
	batch_update.setBatchDescription(dataMap.get("batchDescription"));
	String batchNo= dataMap.get("batchNoOfclasses");
	

	batch_update.setBatchNoOfClasses(Integer.parseInt(batchNo) );
	batch_update.setBatchStatus(dataMap.get("batchStatus"));
	
	request = given()
			.contentType(ContentType.JSON)
			.header("Authorization","Bearer " + AppConfig.TOKEN);
		
		request = request.body(batch_update);
	
	
	
	
}

@When("Admin sends HTTPS Request  with endpoints")
public void admin_sends_https_request_with_endpoints() {
	response = request.log().all().put();
   
}

@Then("Admin receives {int} and  Status messeage with updated value in response body.")
public void admin_receives_and_status_messeage_with_updated_value_in_response_body(Integer statuscode) {
    
	response.then().log().all().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("batchUpdate.json")).contentType(ContentType.JSON).statusCode(statuscode);
	
	JSONObject responseBatch = new JSONObject(response.getBody().asString());
	
	   System.out.println("response: " +responseBatch );
	   
	   //assertTrue(responseBatch.getString("batchName") instanceof String);
	   assertTrue(responseBatch.getString("programName")instanceof String );
		 assertTrue(responseBatch.get("programId") instanceof Integer);
		 assertTrue(responseBatch.get("batchId") instanceof Integer);
		// assertTrue(responseBatch.getString("batchName") instanceof String);
		 assertTrue(responseBatch.getString("batchDescription") instanceof String);
		 assertTrue(responseBatch.get("batchNoOfClasses") instanceof Integer);
		 assertTrue(responseBatch.getString("batchStatus") instanceof String);
		
		 
		 //assertEquals(responseBatch.getString("batchName"),batch_update.getBatchName() );
		 //assertEquals(responseBatch.getString("programName"),batch_update.getProgramName() );
		 assertEquals(responseBatch.get("programId"),batch_update.getProgramId());
		 assertEquals(responseBatch.get("batchId"),batch_update.getBatchId());
		 assertEquals(responseBatch.getString("batchDescription"),batch_update.getBatchDescription());
		 assertEquals(responseBatch.get("batchNoOfClasses") ,batch_update.getBatchNoOfClasses());
		 assertEquals(responseBatch.getString("batchStatus") ,batch_update.getBatchStatus());
	
}

@Given("Admin creates PUT Request with request body {string},{int},{string},{string} and {string}")
public void admin_creates_put_request_with_request_body_and(String batchDescription_n,Integer batchNoOfclasses_n, String batchStatus, String batchName_n, String programName_n) {
	//int programid= 16306; //AppConfig.PROGRAM_ID_1;
	
	
	batch_update.setProgramId(programid);
	batch_update.setBatchId(AppConfig.BATCH_ID1);
	batch_update.setBatchName(batchName_n);
	batch_update.setProgramName(programName_n);
	batch_update.setBatchDescription(batchDescription_n);
	
	batch_update.setBatchNoOfClasses(batchNoOfclasses_n);
	batch_update.setBatchStatus(batchStatus);
	//batch_update.setBatchNoOfClasses(Integer.parseInt(batchNo) );
	//batch_update.setBatchStatus(dataMap.get("batchStatus"));
	
	request = given()
			.contentType(ContentType.JSON)
			.header("Authorization","Bearer " + AppConfig.TOKEN);
		
		request= request.body(batch_update);
	
   
}

@When("Admin sends HTTPS Request  with endpoint with negative scenarios")
public void admin_sends_https_request_with_endpoint_with_negative_scenarios() {
	response = request.log().all().put();
}

@Then("Admin receives {int} Status with  the message and boolean success details")
public void admin_receives_statuscode_status_with_the_message_and_boolean_success_details(Integer statuscode) {
    
	response.then().log().all().assertThat().contentType(ContentType.JSON).statusCode(statuscode);
}


@Given("Admin creates PUT Request with request body of {string},<batchNoOfclasses_n1> ,{string},{string} and {string}")
public void admin_creates_put_request_with_request_body_of_batch_no_Ofclasses_n1_and(String batchDescription_n,Integer batchNoOfclasses_n1, String batchStatus, String batchName_n, String programName_n) {
	
	
	
	batch_update.setProgramId(programid);
	batch_update.setBatchId(AppConfig.BATCH_ID1);
	batch_update.setBatchName(batchName_n);
	batch_update.setProgramName(programName_n);
	batch_update.setBatchDescription(batchDescription_n);
	
	batch_update.setBatchNoOfClasses(batchNoOfclasses_n1);
	batch_update.setBatchStatus(batchStatus);
	//batch_update.setBatchNoOfClasses(Integer.parseInt(batchNo) );
	//batch_update.setBatchStatus(dataMap.get("batchStatus"));
	
	request = given()
			.contentType(ContentType.JSON)
			.header("Authorization","Bearer " + AppConfig.TOKEN);
		
		request= request.body(batch_update);
	
	
}
@Given("Admin creates PUT Request with request body  {string}, <batchNoOfclasses_n2>,{string},{string} and {string}")
public void admin_creates_put_request_with_request_body(String batchDescription_n,Integer batchNoOfclasses_n2, String batchStatus, String batchName_n, String programName_n) {
	
	batch_update.setProgramId(programid);
	batch_update.setBatchId(AppConfig.BATCH_ID1);
	batch_update.setBatchName(batchName_n);
	batch_update.setProgramName(programName_n);
	batch_update.setBatchDescription(batchDescription_n);
	
	//batch_update.setBatchNoOfClasses(batchNoOfclasses_n);
	batch_update.setBatchStatus(batchStatus);
	//batch_update.setBatchNoOfClasses(Integer.parseInt(batchNo) );
	//batch_update.setBatchStatus(dataMap.get("batchStatus"));
	
	request = given()
			.contentType(ContentType.JSON)
			.header("Authorization","Bearer " + AppConfig.TOKEN);
		
		request= request.body(batch_update);
	
	
	
}

@Given("Admin creates PUT Request with  invalid batchid and request body  {string}, {int},{string},{string} and {string}")
public void admin_creates_put_request_with_invalid_batchid_and_request_body_and(String batchDescription_n, Integer batchNoOfclasses_n, String batchStatus_n, String batchName_n, String programName_n) {
   
	RestAssured.baseURI= "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/batches/0000";
int programid= 16306; //AppConfig.PROGRAM_ID_1;
int BATCH_ID1= 0000;
	batch_update.setProgramId(programid);
	batch_update.setBatchId(BATCH_ID1);
	batch_update.setBatchName(batchName_n);
	batch_update.setProgramName(programName_n);
	batch_update.setBatchDescription(batchDescription_n);
	//String batchNo= dataMap.get("batchNoOfclasses");
	batch_update.setBatchNoOfClasses(batchNoOfclasses_n);

	//batch_update.setBatchNoOfClasses(Integer.parseInt(batchNo) );
	//batch_update.setBatchStatus(dataMap.get("batchStatus"));
	
	request = given()
			.contentType(ContentType.JSON)
			.header("Authorization","Bearer " + AppConfig.TOKEN);
		
		request = request.body(batch_update);
	
	
}

@Then("Admin receives {int} Status with message")
public void admin_receives_statuscode_status_with_message(Integer statuscode) {
    
	response.then().log().all().assertThat().contentType(ContentType.JSON).statusCode(statuscode);
	
	
}

@Given("Admin creates PUT Request with request body and invalid endpoint {string} and {int}")
public void admin_creates_put_request_with_request_body_and_invalid_endpoint_and(String string, Integer int1) {
    
RestAssured.baseURI= "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/invalid/invalid";
	
	request = given()
			.contentType(ContentType.JSON)
			.header("Authorization","Bearer " + AppConfig.TOKEN);
		
		request = request.body(batch_update);
   
}

@When("Admin sends HTTPS Request  with invalid endpoints")
public void admin_sends_https_request_with_invalid_endpoints() {
	response = request.log().all().put();
   
}

@Then("Admin receives {int} Status with message and boolean success details")
public void admin_receives_status_with_message_and_boolean_success_details(Integer statuscode) {
	response.then().log().all().assertThat().contentType(ContentType.JSON).statusCode(statuscode);
   
}

@Given("Admin creates PUT Request with  the valid BatchId and Data {string} and {int}")
public void admin_creates_put_request_with_the_valid_batch_id_and_data_and(String string, Integer int1) {
    
	request = given()
			.contentType(ContentType.JSON)
			.header("Authorization","Bearer " + AppConfig.TOKEN);
		
		request = request.body(batch_update);
   
}

@When("Admin sends HTTPS Request  with endpoint and invalid Auth")
public void admin_sends_https_request_with_endpoint_and_invalid_auth() {
	
	response = request.auth().none().log().all().put();
	
}

@Then("Admin receives  the {int} and {string} unauthorized")
public void admin_receives_the_and_unauthorized(Integer statuscode, String string) {
    
	response.then().log().all().assertThat().contentType(ContentType.JSON).statusCode(statuscode);
	   
}
	
		
	
}*/
