package com.practice;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import com.genericUtility.JsonUtility;
import com.genericUtility.WebDriverUtility;
import com.objectRepository.Practice_Form_Page;

public class Practice_Form_Page_using_Json_Test {
	 public static void main(String[] args) throws Throwable, ParseException {
		JsonUtility json_utility = new JsonUtility();
		String browser = json_utility.getDataFromJson("browser").toString();
		String url = json_utility.getDataFromJson("url").toString();
		String firstname = json_utility.getDataFromJson("firstname").toString();
		String lastname = json_utility.getDataFromJson("lastname").toString();
		String email = json_utility.getDataFromJson("email").toString();
		long timeout = (long) json_utility.getDataFromJson("timeout");
		
		WebDriver driver = null;
		WebDriverUtility webdriverutility = new WebDriverUtility();
		driver = webdriverutility.launchBrowserAndInvokeURL(browser, url, (int) timeout);
		
		Practice_Form_Page practiceformpage =  new Practice_Form_Page(driver);
		practiceformpage.FillFirstnameLastnameAndEmail(firstname, lastname, email);
		
		Thread.sleep(5000);
		driver.quit();
	}
}
