package com.genericUtility;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverUtility {
	WebDriver driver = null;
	public WebDriver launchBrowserAndInvokeURL(String browser,String url,int timeout) {
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
		return driver;
	}
}
