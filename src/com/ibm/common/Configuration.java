package com.ibm.common;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Configuration {
	public static String DRIVER_DIR=System.getProperty("user.dir")
			+File.separator
			+"drivers"
			+File.separator;
	
	public static String GECKO_DRIVER_PATH= DRIVER_DIR+"geckodriver";
	public static String CHROME_DRIVER_PATH= DRIVER_DIR+"chromedriver";
	
	public static String URL="https://alchemy.hguy.co/lms/";
	
	
	
	private static String modifyIfWindows(String inpath)
	{
		if (System.getProperty("os.name").toLowerCase().contains("windows"))
		{
			return inpath+".exe";
		}
		else {
			return inpath;
		}
	}
	
	

	public static WebDriver createChromeDriver(ChromeOptions options)
	{
		System.setProperty("webdriver.chrome.driver", modifyIfWindows(CHROME_DRIVER_PATH));
		return new ChromeDriver(options);
	}
	public static WebDriver createFireFoxDriver()
	{
		System.setProperty("webdriver.gecko.driver", modifyIfWindows(GECKO_DRIVER_PATH));
		return new FirefoxDriver();
	}
	
	
	public static WebDriver createChromeDriver() { 
		  return createChromeDriver(new ChromeOptions()); 
		  }
	 

}
