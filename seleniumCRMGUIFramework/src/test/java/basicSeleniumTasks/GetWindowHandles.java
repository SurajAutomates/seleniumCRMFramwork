package basicSeleniumTasks;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetWindowHandles {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demoqa.com/browser-windows");
		
		String parentWindow = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//button[text()='New Window']")).click();
		driver.findElement(By.xpath("//button[text()='New Window Message']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		for (String window : windowHandles) {
			driver.switchTo().window(window);
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(2000);
		}
		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);
		
		driver.quit();
	}
}
