package Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import POJO.Batch_UpdatePojo;
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


public class datareaderBatch {
	
	

	public Batch_UpdatePojo batchUpdate(String batchDescription, Integer batchId, String batchName, Integer batchNoOfClasses, String batchStatus, Integer programId, String programName)
	{
   
		Batch_UpdatePojo updateBatch= new Batch_UpdatePojo();
		
		updateBatch.setBatchDescription(batchDescription);
		updateBatch.setBatchId(AppConfig.BatchID);
		updateBatch.setBatchName(batchName);
		updateBatch.setBatchNoOfClasses(batchNoOfClasses);
		updateBatch.setBatchStatus(batchStatus);
		updateBatch.setProgramId(AppConfig.PROGRAM_ID);
		
		updateBatch.setProgramName(programName);
		
		
		return updateBatch;
		
	}

	
}	


	
	
	
	
	
	
	
	
	
	
	
	
	
	

