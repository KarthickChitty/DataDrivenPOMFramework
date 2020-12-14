package com.auto.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/*import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;*/
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
/*	private XSSFRow row = null;
	private XSSFCell cell = null;
*/	
	public ExcelReader(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch(Exception ex) {
			
		}
	}

	public int getRowCount(String sheetName) {
		
		int[] rBreak = sheet.getRowBreaks();
		return rBreak.length;
	}

	public int getColumnCount(String sheetName) {
		int[] cBreak = sheet.getColumnBreaks();
		
		return cBreak.length;
	}

	public Object getCellData(String sheetName, int colNum, int rowNum) {
		return null;
	}


}
