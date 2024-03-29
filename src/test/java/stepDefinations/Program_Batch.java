package stepDefinations;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

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

public class Program_Batch {
	
	
	
	RequestSpecification request;
	Response response;
	static String batch_id;
	
	Map<String, String> dataMap;
	
	
	@Given("Admin creates POST Request  with valid data in request body {string} and {int}")
	public void admin_creates_post_request_with_valid_data_in_request_body_and(String sheetname, int rownumber) {
	    
		
		if(AppConfig.TOKEN==null) {
			login l = new login();
			try {
				l.userable_to_log_in();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		System.out.println("Token: " + AppConfig.TOKEN);
		
		dataMap = ExcelReaderBatch.getTestData(sheetname,rownumber);
		System.out.println("DATA_MAP " + dataMap);
		RestAssured.baseURI= "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/batches";//+dataMap.get("endPoint");
		Program_BatchPojo batch = new Program_BatchPojo();
		Random ran = new Random();
		
		String batchName = dataMap.get("batchName")+ "-" + ran.nextInt();
		int programid= 16306;    //AppConfig.PROGRAM_ID_1;
		
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
		response.then().log().all().assertThat().statusCode(statuscode);
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
	   
	}



	

}
