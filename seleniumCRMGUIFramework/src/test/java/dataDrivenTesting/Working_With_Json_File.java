package dataDrivenTesting;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Working_With_Json_File {
	private static final Object JSONParser = null;

	public static void main(String[] args) throws Exception {
		InputStream fis = Working_With_Json_File.class.getClassLoader().getResourceAsStream("commonDatausingJson.json");
		JSONParser parser = new JSONParser();
//		json_obj.parse(fis); It does not support InputStream directly. So Convert InputStream → Reader
		Object obj = parser.parse(new InputStreamReader(fis));
//		parse() returns Object, so downcasting to JSONObject is required to access values using get()
		JSONObject j_obj = (JSONObject) obj;

//		Access all the json data using get() method
		String browser = j_obj.get("browser").toString();
		String url = j_obj.get("url").toString();
		String firstname = j_obj.get("firstname").toString();
		String lastname = j_obj.get("lastname").toString();
		String email = j_obj.get("email").toString();
		long timeout = (long) j_obj.get("timeout");

//		perform selenium task
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));

		driver.get(url);

		driver.findElement(By.id("firstName")).sendKeys(firstname);
		driver.findElement(By.id("lastName")).sendKeys(lastname);
		driver.findElement(By.id("userEmail")).sendKeys(email);
		
		
		Thread.sleep(2000);
		driver.quit();
	}
}
