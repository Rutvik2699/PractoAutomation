package com.selenium.practoautomation.PractoAutomation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataInput {
	/****************   TO READ SEARCH BAR DATA   ****************/
	public static String readExcelDataForSearchValue(String sheetname,int row,int col) throws IOException {

		FileInputStream fin = new FileInputStream(
				System.getProperty("user.dir") + "\\srcTestResources\\Book1.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fin);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		String value = sheet.getRow(row).getCell(col).getStringCellValue();
		workbook.close();
		fin.close();
		return value;
	}

}
