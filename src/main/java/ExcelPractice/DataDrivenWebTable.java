package ExcelPractice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.ExcelReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenWebTable {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_population");
		String path = ".\\ExcelData\\webtable.xlsx";
		ExcelReader excelReader = new ExcelReader(path);
		// write headers
		excelReader.setCellData("data", 0, 0, "Country");
		excelReader.setCellData("data", 0, 1, "Population");
		excelReader.setCellData("data", 0, 2, "% of world");
		excelReader.setCellData("data", 0, 3, "date");
		excelReader.setCellData("data", 0, 4, "source");

		int rows = driver.findElements(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']//tr")).size()
				- 1;
		for (int i = 1; i <= rows; i++) {
			String Country = driver
					.findElement(
							By.xpath("//table[@class='wikitable sortable jquery-tablesorter']//tr[" + i + "]//td[1]"))
					.getText();
			String Population = driver
					.findElement(
							By.xpath("//table[@class='wikitable sortable jquery-tablesorter']//tr[" + i + "]//td[2]"))
					.getText();
			String PercentageOfWorld = driver
					.findElement(
							By.xpath("//table[@class='wikitable sortable jquery-tablesorter']//tr[" + i + "]//td[3]"))
					.getText();

			String date = driver
					.findElement(
							By.xpath("//table[@class='wikitable sortable jquery-tablesorter']//tr[" + i + "]//td[4]"))
					.getText();

			String source = driver
					.findElement(
							By.xpath("//table[@class='wikitable sortable jquery-tablesorter']//tr[" + i + "]//td[5]"))
					.getText();
			excelReader.setCellData("data", i, 0, Country);
			excelReader.setCellData("data", i, 1, Population);
			excelReader.setCellData("data", i, 2, PercentageOfWorld);
			excelReader.setCellData("data", i, 3, date);
			excelReader.setCellData("data", i, 4, source);

		}
		driver.close();

	}

}
