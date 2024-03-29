package Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import POJO.LoginPojo;
import POJO.UserPojo;

import POJO.userLoginPojo;
import POJO.userRoleMaps;

public class datareader {
	
	testdata td= new testdata();
	

	public LoginPojo login() throws IOException {
		
		Map<String, String> map = ExcelReader.getTestData("Log", 1);
		
		
		
		//ArrayList data=td.getdata("userLoginEmailId");
		//ArrayList data1=td.getdata("password");
		LoginPojo lp= new LoginPojo();
		
		lp.setUserLoginEmailId(map.get("userLoginEmailId"));
		lp.setPassword(map.get("password"));
	return lp;
	}
	
	
	public UserPojo userCreation() {
		
		UserPojo usr= new UserPojo();
		
		usr.setUserComments("new user");
		usr.setUserEduPg("mca");
		usr.setUserEduUg("bca");
		usr.setUserFirstName("testUsr");
		usr.setUserId("");
		usr.setUserLastName("L");
		usr.setUserLinkedinUrl("www.linkedin.com");
		usr.setUserLocation("");
		
		
		userLoginPojo usrlog= new userLoginPojo();
		
		usrlog.setLoginStatus("");
		usrlog.setPassword("453423");
		List<String> mylist= new ArrayList<String>();
		mylist.add("");
		usrlog.setRoleIds(mylist);
		usrlog.setStatus("");
		usrlog.setUserLoginEmail("team4_14@gmail.com");
		
		usr.setUserLogin(usrlog);
		
		usr.setUserMiddleName("M");
		usr.setUserPhoneNumber("6754634560");
		
		userRoleMaps usrrolmp= new userRoleMaps();
		List<userRoleMaps> mylist1= new ArrayList<userRoleMaps>();
		
			
		usrrolmp.setRoleId("R01");
		usrrolmp.setUserRoleStatus("Active");
		
		mylist1.add(usrrolmp);
		
		usr.setUserRoleMaps(mylist1);
		usr.setUserTimeZone("EST");
		usr.setUserVisaStatus("H4-EAD");
		
		return usr;
		
	}
}
