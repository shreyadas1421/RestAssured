package Utilities;

import java.io.IOException;
import java.util.ArrayList;

import POJO.LogInPojo;

public class datareader {
	
	testdata td= new testdata();
	

	public LogInPojo login() throws IOException {
		
		ArrayList data=td.getdata("userLoginEmailId");
		ArrayList data1=td.getdata("password");
		LogInPojo lp= new LogInPojo();
		
		lp.setUserLoginEmailId(data.get(1).toString());
		lp.setPassword(data1.get(1).toString());
	return lp;
	}
}
