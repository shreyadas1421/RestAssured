package Utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import POJO.LogInPojo;
import POJO.ProgramBatchPojo;

public class Batchdatareader {

public ProgramBatchPojo batch() throws IOException {
	
	String batchNoOfClasses;
	String batchName;
	String batchDescription;
	String batchStatus;
	String programId;
	String programName;
	
	String path=".//src/test/resources/TestDataUSR.xlsx";
    XSSFWorkbook workbook=new XSSFWorkbook(path);
    XSSFSheet sheet = workbook.getSheetAt(3);
    DataFormatter dataf = new DataFormatter();
    batchDescription=dataf.formatCellValue(sheet.getRow(0).getCell(1));
    System.out.println(batchDescription);
    batchName=dataf.formatCellValue(sheet.getRow(1).getCell(1));
    System.out.println(batchName);
    batchNoOfClasses=dataf.formatCellValue(sheet.getRow(2).getCell(1));
    System.out.println(batchNoOfClasses);
    batchStatus=dataf.formatCellValue(sheet.getRow(3).getCell(1));
    System.out.println(batchStatus);
    programId=dataf.formatCellValue(sheet.getRow(4).getCell(1));
    System.out.println(programId);
    
    ProgramBatchPojo bt= new ProgramBatchPojo();
		
		//System.out.println(td.username);
		//System.out.println(td.password);
		
		bt.setBatchDescription(batchDescription);
		bt.setBatchName(batchName);
		bt.setBatchNoOfClasses(batchNoOfClasses);
		bt.setBatchStatus(batchStatus);
		bt.setProgramId(programId);
		
	return bt;
	}
}
