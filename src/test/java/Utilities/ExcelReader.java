package Utilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader{
	

	public static Map<String, String> getTestData(String sheetName, int rowNumber) {
		
		Map<String, String> ioMap = new HashMap<>();
		ioMap.clear();
		
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(ExcelReader.class.getResourceAsStream("/TestDataUSR.xlsx"));
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow headerRow = sheet.getRow(0);
			XSSFRow testRow = sheet.getRow(rowNumber);
			  
			for(int i=0;i<headerRow.getLastCellNum();i++) {
			
				String colHeader = headerRow.getCell(i).getStringCellValue();
				
							
				String colValue = testRow.getCell(i) != null ? testRow.getCell(i).getStringCellValue():null;
			
				ioMap.put(colHeader, colValue);
			
			}			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return ioMap;
	}
	
	
}