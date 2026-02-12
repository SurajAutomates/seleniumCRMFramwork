package basicSeleniumTasks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Task_1 {
	public static void main(String[] args) throws Throwable {
		String propertyFile = "./src/test/resources/task_1.properties";
		FileInputStream fis = new FileInputStream(propertyFile);
		Properties pobj = new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String TITLE = pobj.getProperty("title");
		String NAME = pobj.getProperty("name");
		String EMAIL = pobj.getProperty("email");
		String PASSWORD = pobj.getProperty("password");
		
		WebDriver driver = null;
		
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if (BROWSER.equals("Safari")) {
			driver = new SafariDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(URL);
		
		String title = driver.getTitle();
		if (title.equals(TITLE)) {
			System.out.println("main page is visible");
		}
		else {
			System.out.println("main page is not visible ");
		}
		
		driver.findElement(By.xpath("//a[@href = '/login']")).click();
		String expectedPage2 = "Automation Exercise - Signup / Login";
		
		String title2 = driver.getTitle();
		if (title2.equals(expectedPage2)) {
			System.out.println("Sign up or login page visiible");
		} else {
			System.out.println("sign up or login page is not visible");
		}
		
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(NAME);
		driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys(EMAIL);
		driver.findElement(By.xpath("//button[text()='Signup']")).submit();
		
		driver.findElement(By.id("id_gender1")).click();
		
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		
		
		
		driver.close();
		
	}
}
