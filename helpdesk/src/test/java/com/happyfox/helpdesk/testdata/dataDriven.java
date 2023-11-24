package com.happyfox.helpdesk.testdata;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.happyfox.helpdesk.page_objects.LoginPage;



public class dataDriven {
	
	private static dataDriven dataDrivenInstance=null;

	private dataDriven() {
	}

	public static dataDriven getInstance() {

		if (dataDrivenInstance == null) {

			dataDrivenInstance = new dataDriven();
		}

		return dataDrivenInstance;

	}
	
	public ArrayList<String> getData(String testCaseName) throws IOException {
		ArrayList<String> a = new ArrayList<String>();
		
//		FileInputStream  fis=new FileInputStream("./TestData.Xlsx");
		FileInputStream  fis=new FileInputStream("D:\\Driven\\TestData.Xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("Data")) {

				XSSFSheet sheet = workbook.getSheetAt(i);

				//sheet is collection of rows
				Iterator<Row> rows = sheet.iterator(); 
				Row	firstRow= rows.next();
				
				//Row is Collection of Cell
				Iterator<Cell> ce= firstRow.cellIterator();
				int k=0;
				int column=0;
				 while(ce.hasNext()) {
					 Cell value = ce.next();
					 
					 if(value.getStringCellValue().equalsIgnoreCase("TestCase")){
						 
						 column=k;
					 }
					 
					 	 k++;
				 }
//				 System.out.println(column);
				while(rows.hasNext()) {
					
					Row r = rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						
						
					Iterator<Cell> cv =	r.cellIterator();
				
					while(cv.hasNext()) {
//						a.add(cv.next().getStringCellValue());
						Cell c = cv.next();
						
						if(c.getCellType()==CellType.STRING) {
							a.add(c.getStringCellValue());
						}
						else {
						a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							
						}
					}
					}
					
					
				}
				
			}
		}
		
		return a;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		


	}

}
