package basicSeleniumTasks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basic_Task_on_AutoSuggestion {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.flipkart.com/");
		// In the search box, type puma, collect all the auto-suggestions, and print them one by one in the console.
		
		
		driver.findElement(By.xpath("(//input[@name='q'])[1]")).sendKeys("puma");
		Thread.sleep(3000);
		List<WebElement> elements =null;
		int attempt=0;
		while (elements==null) {
			elements = driver.findElements(By.xpath("//div[@class=\"VDtK0l _1psv1ze2u _1psv1ze53 _1psv1ze9x _1psv1ze7o\"]"));
		System.out.println("Attempt : "+(++attempt));
		}
		for (WebElement element : elements) {
			System.out.println(element.getText());
		}
		driver.quit();
	}
}
