package POJO;

import java.util.List;

public class UserPUT_updateUserRoleProgramBatchStatus {
	
	private int programId;
	private String roleId;
	private List<userRoleProgramBatches> userRoleProgramBatches;
	
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public List<userRoleProgramBatches> getUserRoleProgramBatches() {
		return userRoleProgramBatches;
	}
	public void setUserRoleProgramBatches(List<userRoleProgramBatches> userRoleProgramBatches) {
		this.userRoleProgramBatches = userRoleProgramBatches;
	}

	
	

}
