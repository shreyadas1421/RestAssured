package Utilities;

public enum EndPointsBatch {

	getBatchbyProgramId("/batches/program"),
	updateByBatchID("/batches"),
	deleteBatchbyBatchID("/batches");
	

 private String resourcesBatch;
	
	EndPointsBatch(String resourcesBatch) {
		this.resourcesBatch= resourcesBatch;
	}
	
	public String getResources() {
		
		return resourcesBatch;
	}
}
