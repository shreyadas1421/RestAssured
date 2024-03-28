package Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import POJO.LogInPojo;

public class datareader {
	
	testdata td= new testdata();
	

	public LogInPojo login() throws IOException {
		
		Map<String, String> map = ExcelReader.getTestData("Log", 1);
		
		
		
		//ArrayList data=td.getdata("userLoginEmailId");
		//ArrayList data1=td.getdata("password");
		LogInPojo lp= new LogInPojo();
		
		lp.setUserLoginEmailId(map.get("userLoginEmailId"));
		lp.setPassword(map.get("password"));
	return lp;
	}
}
