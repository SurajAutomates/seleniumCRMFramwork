package com.practice;

import org.openqa.selenium.WebDriver;

import com.genericUtility.FileUtility;
import com.genericUtility.WebDriverUtility;
import com.objectRepository.Practice_Form_Page;

public class Practice_Form_Page_using_Property_Test {
	public static void main(String[] args) throws Throwable {
		FileUtility fileutility = new FileUtility();
		String browser = fileutility.getDatafromProperty("browser");
		String url = fileutility.getDatafromProperty("url");
		String firstname = fileutility.getDatafromProperty("firstname");
		String lastname = fileutility.getDatafromProperty("lastname");
		String email = fileutility.getDatafromProperty("email");
		
		WebDriver driver = null;
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		driver = webDriverUtility.launchBrowserAndInvokeURL(browser, url, 25);
		
		Practice_Form_Page practiceform = new Practice_Form_Page(driver);
		practiceform.FillFirstnameLastnameAndEmail(firstname, lastname, email);
		
		Thread.sleep(10000);
		driver.quit();
	}
}
