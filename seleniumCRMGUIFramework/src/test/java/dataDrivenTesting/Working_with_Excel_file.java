package dataDrivenTesting;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Working_with_Excel_file {
	public static void main(String[] args) throws Exception, IOException {
		InputStream fis = Working_with_Excel_file.class.getClassLoader().getResourceAsStream("DemoData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sheet = wb.getSheet("sheet1");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(2);
	
		System.out.println(cell.getStringCellValue());
		
		
		System.out.println("executed");
	}
}
