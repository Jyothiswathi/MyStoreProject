package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	private By emailId = By.xpath("//input[@id='email']");
	private By password = By.xpath("//input[@id='pass']");
	private By login=By.xpath("//button[@id='loginbutton']");
	
	
	public void facebookLogin()
	{
		driver.findElement(emailId).sendKeys("jyothitelukula5@gmail.com");;
		driver.findElement(password).sendKeys("Jyothi@123");;
		driver.findElement(login).click();
	}
}
