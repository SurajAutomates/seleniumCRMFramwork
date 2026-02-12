package basicSeleniumTasks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Easy_Task_iframes {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demoqa.com/frames");
		driver.switchTo().frame(2);
		String text = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(text);
		
		driver.quit();
	}
}
