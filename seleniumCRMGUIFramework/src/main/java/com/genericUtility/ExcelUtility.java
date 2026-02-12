package com.genericUtility;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	InputStream fis = ExcelUtility.class.getClassLoader().getResourceAsStream("DemoData.xlsx");

	public String getStringDataFromExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}

	public double getNumericDataFromExcel(String sheet, int row, int cell)
			throws EncryptedDocumentException, IOException {
		Workbook wb = WorkbookFactory.create(fis);
		double data = wb.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
		return data;
	}

	public List<String> getAllDataOneByOne(String sheet) throws EncryptedDocumentException, IOException {
		List<String> allData = new ArrayList<String>();
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		int lastRowNum = sh.getLastRowNum();
		for(int i = 0;i<=lastRowNum;i++) {
			Row row = sh.getRow(i);
			int lastCellNum = sh.getRow(i).getLastCellNum();
			for(int j = 0;j<=lastCellNum;j++) {
				allData.add(row.getCell(j).toString());
			}
		}
		return allData;
	}

	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException {
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheet).getLastRowNum();
		;
		return rowCount;
	}

	public int getCellCount(String sheet, int row) throws EncryptedDocumentException, IOException {
		Workbook wb = WorkbookFactory.create(fis);
		short cellCount = wb.getSheet(sheet).getRow(row).getLastCellNum();
		return cellCount;
	}
}
