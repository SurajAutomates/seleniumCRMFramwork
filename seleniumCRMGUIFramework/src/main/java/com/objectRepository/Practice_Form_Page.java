package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Practice_Form_Page {
	WebDriver driver;
	@FindBy(id = "firstName")
	private WebElement firstname;

	@FindBy(id = "lastName")
	private WebElement lastname;

	@FindBy(id = "userEmail")
	private WebElement email;

	public Practice_Form_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getEmail() {
		return email;
	}

	public void FillFirstnameLastnameAndEmail(String firstName, String lastName, String eMail) {
		firstname.sendKeys(firstName);
		lastname.sendKeys(lastName);
		email.sendKeys(eMail);
	}

}
