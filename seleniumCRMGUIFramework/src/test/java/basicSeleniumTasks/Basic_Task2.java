package basicSeleniumTasks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Basic_Task2 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demoqa.com/automation-practice-form");
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Xyz");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Xyz");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("xyz@gmail.com");
		driver.findElement(By.xpath("//label[text()='Male']")).click();
//		getting exception
//		driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();
//		WebElement allMonths = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
//		Select months = new Select(allMonths);
//		System.out.println(months);
		driver.close();
	}
}
