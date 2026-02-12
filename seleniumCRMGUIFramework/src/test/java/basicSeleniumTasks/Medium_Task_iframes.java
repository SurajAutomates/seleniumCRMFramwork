package basicSeleniumTasks;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Medium_Task_iframes {
	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://jqueryui.com/droppable");
		driver.switchTo().frame(0);
		
		Actions action = new Actions(driver);
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		action.dragAndDrop(draggable, droppable).build().perform();
		
		System.out.println(droppable.getText());
		
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Resizable")).click();
		
		
		driver.switchTo().frame(0);
		
		WebElement resize_handler = driver.findElement(By.xpath("(//div[contains(@class,'ui-resizable-handle')])[3]"));
		action.clickAndHold(resize_handler).moveByOffset(148, 146).release().build().perform();
		
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.linkText("Checkboxradio")).click();
		
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//label[@for='radio-2']")).click();
		driver.findElement(By.xpath("//label[@for='checkbox-4']")).click();
		driver.findElement(By.xpath("//label[@for='checkbox-nested-2']")).click();
		
		
		driver.quit();
		
		
	}
}
