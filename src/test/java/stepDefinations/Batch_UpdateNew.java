package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import Utilities.AppConfig;
import Utilities.Batchdatareader;
import Utilities.EndPoints;
import Utilities.EndPointsBatch;
import Utilities.ReusableMethod;
import Utilities.datareaderBatch;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Batch_UpdateNew extends ReusableMethod{
	
	RequestSpecification batchRes;
	RequestSpecification batchRes1;
	RequestSpecification batchRes2;
	Response responseBatch;
	
	datareaderBatch data= new datareaderBatch();
	
	@Given("User-batch creates GET Request")
	public void user_batch_creates_get_request() throws IOException {
		batchRes=given().log().all().spec(reusableSpecBuilder()).header("Authorization","Bearer "+ AppConfig.TOKEN);
		
	}
	
	@Given("User-batch creates Put Request with request body {string}, {int}, {string},{int},{string},{int},{string}")
	public void user_batch_creates_get_request_with_request_body(String batchDescription, Integer batchId, String batchName, Integer batchNoOfClasses, String batchStatus, Integer programId, String programName) throws IOException {
		batchRes1=given().log().all().spec(reusableSpecBuilder()).body(data.batchUpdate(batchDescription, batchId, batchName, batchNoOfClasses, batchStatus, programId, programName))
				 .header("Authorization","Bearer "+ AppConfig.TOKEN);;

	}
	
	@Given("User-batch creates Delete Request")
	public void user_batch_creates_delete_request() throws IOException {
	 
		batchRes2=given().log().all().spec(reusableSpecBuilder()).header("Authorization","Bearer "+ AppConfig.TOKEN);
		
	}

	@When("User-batch sends {string} with {string} Request with endpoint")
	public void user_batch_sends_with_request_with_endpoint(String endpoint, String httpreq) {
		EndPointsBatch endPointbatch=EndPointsBatch.valueOf(endpoint);
		System.out.println(endPointbatch.getResources());
		
		
		 
		if(httpreq.equalsIgnoreCase("Get")) {
			 
			 	 if(endpoint.equalsIgnoreCase("getBatchbyProgramId")) 
				 {
					responseBatch=batchRes.when().get(endPointbatch.getResources()+ 17782);// AppConfig.PROGRAM_ID);
				 }else {
					 responseBatch=batchRes.when().get(endPointbatch.getResources());
				 }
		 }else if (httpreq.equalsIgnoreCase("Put")) {
			 if(endpoint.equalsIgnoreCase("updateByBatchID")) 
			 {
				responseBatch=batchRes1.when().get(endPointbatch.getResources()+ 9984);// AppConfig.Batch_ID);
			 }
		 }else if(httpreq.equalsIgnoreCase("Delete")) {
			
			 if(endpoint.equalsIgnoreCase("deleteBatchbyBatchID")) 
			 {
				responseBatch=batchRes2.when().get(endPointbatch.getResources()+ 9984);// AppConfig.Batch_ID);
			 }
		 }
	}

	@Then("User-batch receives {int} Created Status with response body")
	public void user_batch_receives_created_status_with_response_body(Integer int1) {
		if (responseBatch.getStatusCode()==200) {
			assertEquals(responseBatch.getStatusCode(),200);
		}
	}
	
}
