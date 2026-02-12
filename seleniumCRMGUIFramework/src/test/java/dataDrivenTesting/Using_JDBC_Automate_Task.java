package dataDrivenTesting;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Using_JDBC_Automate_Task {
	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		// fetch browser,url,timeout from json file
		InputStream fis = Using_JDBC_Automate_Task.class.getClassLoader().getResourceAsStream("commonDatausingJson.json");
		JSONParser parser_object = new JSONParser();
		Object object = parser_object.parse(new InputStreamReader(fis));
		JSONObject json_object = (JSONObject) object;
		
		String browser = json_object.get("browser").toString();
		String url = json_object.get("url").toString();
		long timeout = (long) json_object.get("timeout");
		// Lauch Driver
		WebDriver driver = null;
		switch(browser) {
		case "chrome" : 
			driver = new ChromeDriver();
			break;
		case "safari" :
			driver = new SafariDriver();
			break;
		default :
			driver = new ChromeDriver();
			break;	
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		driver.get(url);
		
		// JDBC connection 
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo","root","rootroot");
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("select * from demoQA_detail");
			
			// find all web_element using selenium 
			WebElement firstName = driver.findElement(By.id("firstName"));
			WebElement lastName = driver.findElement(By.id("lastName"));
			WebElement userEmail = driver.findElement(By.id("userEmail"));
			WebElement userNumber = driver.findElement(By.id("userNumber"));
			
			while(result.next()) {
				firstName.clear();
				lastName.clear();
				userEmail.clear();
				userNumber.clear();
				firstName.sendKeys(result.getString("firstname"));
				lastName.sendKeys(result.getString("lastname"));
				userEmail.sendKeys(result.getString("email"));
				userNumber.sendKeys(result.getString("mobile_no"));
				
				Thread.sleep(2000);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				driver.quit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
