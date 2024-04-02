package Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import POJO.LoginPojo;
import POJO.UserPUT_updateUserLoginStatus;
import POJO.UserPUT_updateUserRoleID;
import POJO.UserPUT_updateUserRoleProgramBatchStatus;
import POJO.UserPUT_updateUserRoleStatus;
import POJO.UserPostPojo;
import POJO.UserPost_userLoginPojo;
import POJO.UserPost_userRoleMaps;
import POJO.UserPutPojo;
import POJO.userLoginPojo;
import POJO.userRoleMaps;
import POJO.userRoleProgramBatches;


public class datareader {
	
	testdata td= new testdata();
	Map<String, String> dataMap;
	

	public LoginPojo login() throws IOException {
		
		Map<String, String> map = ExcelReader.getTestData("Log", 1);
		
		
		
		//ArrayList data=td.getdata("userLoginEmailId");
		//ArrayList data1=td.getdata("password");
		LoginPojo lp= new LoginPojo();
		
		lp.setUserLoginEmailId(map.get("userLoginEmailId"));
		lp.setPassword(map.get("password"));
	return lp;
	}
	
//POST request	
	public UserPostPojo userCreationexcel(String sheetname, int rownumber)
	{
   
		dataMap = ExcelReaderUser.getTestData(sheetname,rownumber);
		System.out.println("DATA_MAP " + dataMap);

		UserPostPojo usr= new UserPostPojo();
		
		usr.setUserComments(dataMap.get("userComments"));
		usr.setUserEduPg(dataMap.get("userEduPg"));
		usr.setUserEduUg(dataMap.get("userEduUg"));
		usr.setUserFirstName(dataMap.get("userFirstName"));
		usr.setUserId("");
		usr.setUserLastName(dataMap.get("userLastName"));
		usr.setUserLinkedinUrl(dataMap.get("userLinkedinUrl"));
		usr.setUserLocation("");
		
		
		UserPost_userLoginPojo usrlog= new UserPost_userLoginPojo();
		
		usrlog.setLoginStatus("");
		usrlog.setPassword(dataMap.get("password"));
		List<String> mylist= new ArrayList<String>();
		mylist.add("");
		usrlog.setRoleIds(mylist);
		usrlog.setStatus("");
		usrlog.setUserLoginEmail(dataMap.get("userLoginEmail"));
		
		usr.setUserLogin(usrlog);
		
		usr.setUserMiddleName(dataMap.get("userMiddleName"));
		//usr.setUserPhoneNumber(Integer.valueOf(dataMap.get("userPhoneNumber")));
		usr.setUserPhoneNumber(dataMap.get("userPhoneNumber"));
		UserPost_userRoleMaps usrrolmp= new UserPost_userRoleMaps();
		List<UserPost_userRoleMaps> mylist1= new ArrayList<UserPost_userRoleMaps>();
		
			
		usrrolmp.setRoleId(dataMap.get("roleId"));
		usrrolmp.setUserRoleStatus(dataMap.get("userRoleStatus"));
		
		mylist1.add(usrrolmp);
		
		usr.setUserRoleMaps(mylist1);
		usr.setUserTimeZone(dataMap.get("userTimeZone"));
		usr.setUserVisaStatus(dataMap.get("userVisaStatus"));
		
		return usr;
		
	}
	
	public UserPostPojo userCreationFeature(String userComments, String userEduPg, String userEduUg, String userFirstName, String userLastName, String userLinkedinUrl, String password, String userLoginEmail, String userMiddleName, String userPhoneNumber, String roleId, String userRoleStatus, String userTimeZone, String userVisaStatus)
	{
   
		
		UserPostPojo usr= new UserPostPojo();
		
		usr.setUserComments(userComments);
		usr.setUserEduPg(userEduPg);
		usr.setUserEduUg(userEduUg);
		usr.setUserFirstName(userFirstName);
		usr.setUserId("");
		usr.setUserLastName(userLastName);
		usr.setUserLinkedinUrl(userLinkedinUrl);
		usr.setUserLocation("");
		
		
		UserPost_userLoginPojo usrlog= new UserPost_userLoginPojo();
		
		usrlog.setLoginStatus("");
		usrlog.setPassword(password);
		List<String> mylist= new ArrayList<String>();
		mylist.add("");
		usrlog.setRoleIds(mylist);
		usrlog.setStatus("");
		usrlog.setUserLoginEmail(userLoginEmail);
		
		usr.setUserLogin(usrlog);
		
		usr.setUserMiddleName(userMiddleName);
		usr.setUserPhoneNumber(userPhoneNumber);
		
		UserPost_userRoleMaps usrrolmp= new UserPost_userRoleMaps();
		List<UserPost_userRoleMaps> mylist1= new ArrayList<UserPost_userRoleMaps>();
		
			
		usrrolmp.setRoleId(roleId);
		usrrolmp.setUserRoleStatus(userRoleStatus);
		
		mylist1.add(usrrolmp);
		
		usr.setUserRoleMaps(mylist1);
		usr.setUserTimeZone(userTimeZone);
		usr.setUserVisaStatus(userVisaStatus);
		
		return usr;
		
	}

//POST Request	
	public UserPutPojo userUpdate(String userComments, String userEduPg, String userEduUg, String userFirstName, String userLastName, String userLinkedinUrl, String userMiddleName, String userPhoneNumber, String userTimeZone, String userVisaStatus, String userLocation)
	{
   
		
		UserPutPojo usrUpdate= new UserPutPojo();
		
		usrUpdate.setUserComments(userComments);
		usrUpdate.setUserEduPg(userEduPg);
		usrUpdate.setUserEduUg(userEduUg);
		usrUpdate.setUserFirstName(userFirstName);
		usrUpdate.setUserLastName(userLastName);
		usrUpdate.setUserMiddleName(userMiddleName);
		usrUpdate.setUserLinkedinUrl(userLinkedinUrl);
		usrUpdate.setUserLocation(userLocation);
		usrUpdate.setUserPhoneNumber(userPhoneNumber);
		usrUpdate.setUserTimeZone(userTimeZone);
		usrUpdate.setUserVisaStatus(userVisaStatus);
	
		
		return usrUpdate;
		
	}
	


	
public UserPUT_updateUserRoleStatus userRoleStatusUpdate(String roleId, String userRoleStatus) {
		
		UserPUT_updateUserRoleStatus usrStatusUpdate= new UserPUT_updateUserRoleStatus();
		
		usrStatusUpdate.setRoleId(roleId);
		usrStatusUpdate.setUserRoleStatus(userRoleStatus);
		
		return usrStatusUpdate;
	}

public UserPUT_updateUserRoleID userRoleIdUpdate(String roleID) {
	
	UserPUT_updateUserRoleID usrRoleIdUpdate = new UserPUT_updateUserRoleID();
	
	List<String> roleid= new ArrayList<String>();
	roleid.add(roleID);
	usrRoleIdUpdate.setUserRoleList(roleid);

	return usrRoleIdUpdate;
//	
}

public UserPUT_updateUserLoginStatus updateUserLoginStatus(String loginStatus, String password, String roleIds, String status, String userLoginEmail) {
	
	UserPUT_updateUserLoginStatus loginStat= new UserPUT_updateUserLoginStatus();
	
	loginStat.setLoginStatus(loginStatus);
	loginStat.setPassword(password);
	
	List<String> rid= new ArrayList<String>();
	rid.add(roleIds);
	loginStat.setRoleIds(rid);
	loginStat.setStatus(status);
	loginStat.setUserLoginEmail(userLoginEmail);
	
	return loginStat;
}

public UserPUT_updateUserRoleProgramBatchStatus updateUserRoleProgramBatchStatus() {
	
	
	UserPUT_updateUserRoleProgramBatchStatus userRoleProgramBatch= new UserPUT_updateUserRoleProgramBatchStatus();
	
	userRoleProgramBatch.setProgramId(16323);//AppConfig.PROGRAM_ID);
	userRoleProgramBatch.setRoleId("R01");
	
	userRoleProgramBatches us= new userRoleProgramBatches();
	us.setBatchId(8520);//AppConfig.BatchID);
	us.setUserRoleProgramBatchStatus("Active");
	
	List<userRoleProgramBatches> mylist2= new ArrayList<userRoleProgramBatches>();
	
	mylist2.add(us);
	
	userRoleProgramBatch.setUserRoleProgramBatches(mylist2);
	
	return userRoleProgramBatch;
}

	
}	


	
	
	
	
	
	
	
	
	
	
	
	
	
	

