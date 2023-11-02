package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ConfigReader {

	private Properties prop;
	public Properties init_Properties() {
		prop = new Properties();
		try {
			FileInputStream fi = new FileInputStream("D:\\MyStoreProject\\src\\test\\resources\\Configuaration\\Config.properties");
			prop.load(fi);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;

	}
}
