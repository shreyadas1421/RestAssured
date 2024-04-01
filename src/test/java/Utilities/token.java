package Utilities;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class token extends ReusableMethod {
	datareader d=new datareader();

public void login() throws IOException {
	
	String response=given().log().all().header("Content-Type","application/json").
			spec(reusableSpecBuilder()).
			body(d.login()).when().post("/login")
			.then().log().all().assertThat().statusCode(200).extract().response().asString();
			
			System.out.println(response);
			
	JsonPath js= new JsonPath(response);
	String token_id=js.getString("token");
	
	System.out.println(token_id);
	AppConfig.TOKEN = token_id;
}

public void logout() throws IOException {
	given().log().all().spec(reusableSpecBuilder()).header("Authorization","Bearer "+  AppConfig.TOKEN)
	.get("/logoutlms");	
}
}
