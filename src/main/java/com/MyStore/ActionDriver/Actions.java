package com.MyStore.ActionDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

public class Actions {
	public static Properties prop;
	
	@BeforeTest
	public void loadConfig() throws IOException
	{
		prop=new Properties();
		FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\Configuaration\\Config.properties");
		prop.load(ip);
	}
	
	
	
	
	
	
	
	

}
