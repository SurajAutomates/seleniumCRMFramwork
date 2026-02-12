package dataDrivenTesting;

import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

/*
 * Create a Selenium automation script that performs the following actions:
Read the browser name and application URL from a properties file.
Launch the specified browser based on the value provided in the properties file.
Navigate to the application URL.
Read First Name, Last Name, and Email ID from an Excel file.
Locate the respective input fields on the web page.
Enter the First Name, Last Name, and Email ID retrieved from the Excel file into the corresponding fields.
Close the browser after execution.
 */
public class Basic_Task_On_Property_And_Excel_File {
	public static void main(String[] args) throws Throwable {
		// Read the browser name and application URL from a properties file.
		InputStream fis_propert = Basic_Task_On_Property_And_Excel_File.class.getClassLoader()
				.getResourceAsStream("commonData.properties");

		Properties pobj = new Properties();
		pobj.load(fis_propert);

		String browser = pobj.getProperty("browser");
		String url = pobj.getProperty("url");
//		Launch the specified browser based on the value provided in the properties file. Navigate to the application URL.
		WebDriver driver = null;

		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			driver = new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
//		find firstname,lastname and email text field
		WebElement firstName_textfield = driver.findElement(By.id("firstName"));
		WebElement lastName_textfiel = driver.findElement(By.id("lastName"));
		WebElement email_textfiel = driver.findElement(By.id("userEmail"));

//		Read First Name, Last Name, and Email ID from an Excel file.
		InputStream fis_excel = Basic_Task_On_Property_And_Excel_File.class.getClassLoader()
				.getResourceAsStream("DemoData.xlsx");

		Workbook wb = WorkbookFactory.create(fis_excel);
		Sheet sh = wb.getSheet("sheet1");
		int lastRowNum = sh.getLastRowNum();
		for (int i = 1; i <= lastRowNum; i++) {
			String firstname = sh.getRow(i).getCell(0).getStringCellValue();
			String lastname = sh.getRow(i).getCell(1).getStringCellValue();
			String email = sh.getRow(i).getCell(2).getStringCellValue();

			firstName_textfield.clear();
			lastName_textfiel.clear();
			email_textfiel.clear();
			
			firstName_textfield.sendKeys(firstname);
			lastName_textfiel.sendKeys(lastname);
			email_textfiel.sendKeys(email);
			Thread.sleep(2000);
		}

		driver.quit();
	}
}
