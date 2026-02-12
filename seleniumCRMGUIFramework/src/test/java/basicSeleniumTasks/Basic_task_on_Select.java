package basicSeleniumTasks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Basic_task_on_Select {
	public static void main(String[] args) throws InterruptedException  {
		
		taskOnHerokuapp();
		
		taskOnDemoqa();
	}
	public static void taskOnDemoqa() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/select-menu");
		
		WebElement colour_dropdown = driver.findElement(By.id("oldSelectMenu"));
		
		Select sel = new Select(colour_dropdown);
		// get all options
		List<WebElement> options = sel.getOptions();
		for (WebElement option : options) {
			System.out.println(option.getText());
		}
		// select black by visible text
		sel.selectByVisibleText("Black");
		System.out.println(sel.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		
		//select yellow by value
		sel.selectByValue("3");
		System.out.println(sel.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		
		//select indigi by index
		sel.selectByIndex(8);
		System.out.println(sel.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		
		driver.quit();
	}
	public static void taskOnHerokuapp() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/dropdown");
		WebElement option_dropdown = driver.findElement(By.id("dropdown"));
		Select sel = new Select(option_dropdown);
		List<WebElement> options = sel.getOptions();
		for (WebElement option : options) {
			System.out.println(option.getText());
		}
		
		
		// select by visible text
		sel.selectByVisibleText("Option 1");
		Thread.sleep(2000);
		
		// select by index 
		sel.selectByIndex(2);
		Thread.sleep(2000);
		
		// select by value
		sel.selectByValue("1");
		Thread.sleep(2000);
		
		driver.quit();
		
	}
}
