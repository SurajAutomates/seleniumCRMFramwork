package dataDrivenTesting;

import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Working_with_property_files {
	
	public static void main(String[] args) throws Exception {
		// working on property file 
		
		InputStream fis = Working_with_property_files.class.getClassLoader()
                .getResourceAsStream("commonData.properties");

		Properties pobj = new Properties();
		pobj.load(fis);
		
		String browser = pobj.getProperty("browser");
		String url = pobj.getProperty("url");
		String firstname = pobj.getProperty("firstname");
		String lastname = pobj.getProperty("lastname");
		String email = pobj.getProperty("email");
		
		// selenium task
		WebDriver driver = null;
		
		switch(browser) {
		case "chrome" : driver = new ChromeDriver(); break;
		case "safari" : driver = new SafariDriver(); break;
		default : driver = new ChromeDriver(); break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		
		driver.findElement(By.id("firstName")).sendKeys(firstname);
		driver.findElement(By.id("lastName")).sendKeys(lastname);
		driver.findElement(By.id("userEmail")).sendKeys(email);
		
		Thread.sleep(2000);
		driver.quit();
		
		
	}
}
