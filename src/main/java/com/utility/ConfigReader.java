package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ConfigReader {

	private Properties prop;
	public Properties init_Properties(String  propertyName) {
		prop = new Properties();
		try {
			FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Configuaration\\"+propertyName+".properties");
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
