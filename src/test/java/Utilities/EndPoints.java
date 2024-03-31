package Utilities;

public enum EndPoints {

	LMSLogIn("/login"),
	LMSLogOut("/logoutlms"),
	LMScreateUser("/users/roleStatus"),
	LMSgetAllUsers("/users"),
	LMSgetAllusersWithRols("users/roles"),
	LMSgetSingleUser("/users"),
	LMSgetAllRoles("/roles"),
	LMSgetRolestatus("/users/byStatus"),
	LMSgetAllactivUsers("/users/activeUsers"),
	LMSgetUsersWithRoleId("/users/roles"),
	LMSgetUsersByRoleIdV2("/v2/users"),
	LMSupdateUser("/users"),
	LMSupdateUserStatus("/users/roleStatus"),
	LMSupdateUserRoleId("/users/roleId"),
	LMSupdateUserLoginStatus("/users/userLogin");
	
	

 private String resources;
	
	EndPoints(String resources) {
		this.resources= resources;
	}
	
	public String getResources() {
		
		return resources;
	}
}
