package Selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class Windowhandles {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='selenium143']")).click();

		String parentId = driver.getWindowHandle();
		// by using for each

		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {
			// if (!parentId.equals(window)) {
			driver.switchTo().window(window);

			try {
				driver.findElement(By.xpath("(//a[contains(text(),'What is Selenium')])[1]")).click();
				String value = driver.findElement(By.xpath("//h3[@itemprop='name']")).getText();
				System.out.println(value);
				driver.findElement(By.xpath("//a[text()='Selenium Java - Live Project - Rs 999']")).click();
				Set<String> windows1 = driver.getWindowHandles();
				for (String w : windows1) {
					driver.switchTo().window(w);

					try {
						String value3 = driver.findElement(By.xpath("//span[text()='Payment Details']")).getText();
						System.out.println(value3);
					} catch (Exception e) {
						driver.close();
					}

				}

			} catch (Exception e) {
				driver.close();
			}

			// }
		}
//		Iterator<String> iterator = windows.iterator();
//		String parent = iterator.next();
//		String child1 = iterator.next();
//
//		driver.switchTo().window(child1);
//		driver.findElement(By.xpath("(//a[contains(text(),'What is Selenium')])[1]")).click();
//		String value = driver.findElement(By.xpath("//h3[@itemprop='name']")).getText();
//		driver.findElement(By.xpath("//a[text()='Selenium Java - Live Project - Rs 999']")).click();
//		
//		System.out.println(value);
//		
//
//		driver.switchTo().window(parentId);

		driver.quit();

	}

}
