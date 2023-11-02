package com.utility;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.MyStore.ActionDriver.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;

	public static ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();

	public WebDriver driver_init(String browser) {

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tDriver.set(new ChromeDriver());
		} else {
			System.out.println("please pass the correct driver instance");
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}

	public static WebDriver getDriver() {
		// tDriver.set(new ChromeDriver());

		System.out.println(tDriver.get());
		return tDriver.get();
	}

}
