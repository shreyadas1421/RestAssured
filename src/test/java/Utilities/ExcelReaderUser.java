package Utilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderUser {


	public static Map<String, String> getTestData(String sheetName, int rowNumber) {
		
		Map<String, String> ioMap1 = new HashMap<>();
		ioMap1.clear();
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(ExcelReader.class.getResourceAsStream("/TestDataUSR.xlsx"));
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow headerRow = sheet.getRow(0);
			XSSFRow testRow = sheet.getRow(rowNumber);
			DataFormatter formatter = new DataFormatter();  
			//for (int j=1;j<=sheet.getLastRowNum();j++){
				//testRow = sheet.getRow(j);
			for(int i=0;i<headerRow.getLastCellNum();i++) {
			
				String colHeader = headerRow.getCell(i).getStringCellValue();
				
				String colValue = testRow.getCell(i) != null ? formatter.formatCellValue(testRow.getCell(i)):null;
			
				//String colValue = testRow.getCell(i) != null ? testRow.getCell(i).getStringCellValue():null;
			
				ioMap1.put(colHeader, colValue);
			
			  }
			//}
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return ioMap1;
	}
}
