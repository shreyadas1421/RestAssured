package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class testdata {

	public ArrayList<String> getdata(String logindetails) throws IOException {
		
		ArrayList<String> a= new ArrayList();
		FileInputStream fis= new FileInputStream("C:\\Users\\User\\eclipse-workspaceAPI\\test\\src\\test\\resources\\TestDataUSR.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		int sheets= workbook.getNumberOfSheets();
		for (int i=0;i<sheets; i++) {
			
			if(workbook.getSheetName(i).equalsIgnoreCase("Log")) {
				XSSFSheet sheet=workbook.getSheetAt(i);  
				Iterator<Row> row=sheet.iterator();
				
				Row firstrow=row.next();
				Iterator<Cell> cell=firstrow.cellIterator();
				
				int k=0;
				int column=0;
				
				while(cell.hasNext()) {
					Cell value=cell.next();
					if(value.getStringCellValue().equalsIgnoreCase("userLoginEmailId"))
					 {
						
						column= k;
					}
					k++;
				}System.out.println(column);
				
				while(row.hasNext()) {
					Row r=row.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(logindetails))
					{
						
						Iterator<Cell> cv=r.cellIterator();
						while(cv.hasNext()) {
							a.add(cv.next().getStringCellValue());
							
						}
					}
				}
				
			}
		}
		return a;
		
	}
	
	}

