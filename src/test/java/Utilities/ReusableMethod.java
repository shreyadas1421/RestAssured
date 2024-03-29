package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReusableMethod {
	
	RequestSpecification req;
	RequestSpecification reqWithTocken;
	
	
	public RequestSpecification reusableSpecBuilder() throws IOException {
		
		PrintStream log= new PrintStream(new FileOutputStream("log.text"));
		
		 req=new RequestSpecBuilder().setBaseUri(GlobalProprties("baseUrl"))
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				 .addHeader("Content-Type", "application/json").build();
				
			return req;	
	}
	
	/*public RequestSpecification reusableSpecBuilder_Request() throws IOException {
		
		
		PrintStream log= new PrintStream(new FileOutputStream("logReq.text"));
		
		 req=new RequestSpecBuilder().setBaseUri(GlobalProprties("baseUrl"))
				 .addHeader("Authorization","Bearer "+   )
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				 .addHeader("Content-Type", "application/json").build();
				
			return req;	
	}*/
	
		
	

	public String GlobalProprties(String key) throws IOException {
		
		Properties prop= new Properties();
		FileInputStream fs= new FileInputStream("C:\\Users\\User\\eclipse-workspaceAPI\\Team4_APITroopers\\src\\test\\resources\\GlobalProperty.properties");
		prop.load(fs);
		
		prop.getProperty(key);
		
		return prop.getProperty(key);
		
	}
	
	public String getJsonPath(Response response, String key) {
		
		    String rs=response.asString();
		    JsonPath js= new JsonPath(rs);
		    return js.get(key).toString();
		    
		    
	}
}
