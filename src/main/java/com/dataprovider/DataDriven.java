package com.dataprovider;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utility.ExcelReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDriven {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test(dataProvider = "login")

	public void loginTest(String user, String pwd, String exp) throws InterruptedException {
		driver.get("https://admin-demo.nopcommerce.com/login");
		driver.findElement(By.xpath("//input[@type='email']")).clear();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(user);
		WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
		password.clear();
		password.sendKeys(pwd);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		String exp_title = "Dashboard / nopCommerce administration";
		String act_title = driver.getTitle();
		if (exp.equals("valid")) {
			if (act_title.equals(exp_title)) {
				driver.findElement(By.xpath("//a[text()='Logout']"));
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);

			}

		} else if (exp.equals("invalid")) {
			if (act_title.equals(exp_title)) {
				driver.findElement(By.xpath("//a[text()='Logout']"));
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
			}
		}

	}

	@DataProvider(name = "login")
	public String[][] getdata() throws IOException {
//		String[][] data = { { "admin@yourstore.com", "admin", "valid" }, { "admin@yourstor.com", "admin", "invalid" },
//				{ "admin@yourstore.co", "admin", "invalid" } };
	//	return data;
		
		String path="D:\\MyStoreProject\\ExcelData\\student.xlsx";
		ExcelReader ExcelReader=new ExcelReader(path);
	int rows = ExcelReader.getRowCount("data");
	int columns=ExcelReader.getTotalCount("data", rows);
	String data[][]=new String[rows][columns];
	for(int i=1;i<=rows;i++)
	{
		for(int j=0;j<columns;j++)
		{
			data[i-1][j]=	ExcelReader.getCellData("data", i, j);
		
		}
	}
	
return data;
	}

}
