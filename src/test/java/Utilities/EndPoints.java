package Utilities;

public enum EndPoints {

	LMSLogIn("/login"),
	LMSLogOut("/logoutlms"),
	LMScreateUser("/users/roleStatus");
	

 private String resources;
	
	EndPoints(String resources) {
		this.resources= resources;
	}
	
	public String getResources() {
		
		return resources;
	}
}
