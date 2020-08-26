package com.ibm.common;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

		private WebDriver driver = null;
		private WebDriverWait wait =null;	
		
		
		@BeforeMethod
		public void beforeMethod()
		{
			//for chrome driver
				//setDriver(Configuration.createChromeDriver());
			//For Firefox driver
				setDriver(Configuration.createFireFoxDriver());
				setwait(wait);
				wait= new WebDriverWait(getDriver(),60);
				Reporter.log("********************************");
				Reporter.log("!!!!!Test Execution Started!!!!");
				Reporter.log("Browser Launched");
				this.getDriver().manage().window().maximize();
				Reporter.log("Browser maximized");
				getDriver().get(Configuration.URL);
				Reporter.log("url '"+Configuration.URL+"' launched in the browser");
		}
		
		@AfterMethod
		public void afterMethod()
		{
			getDriver().close();
			Reporter.log("Browser Closed");
			Reporter.log("!!!!!Test Execution Ended!!!!");
			Reporter.log("********************************");
		}
		
		protected WebDriver getDriver()
		{
			return driver;
		}
		
		private void setDriver(WebDriver driver)
		{
			this.driver=driver;
		}
		
		protected WebDriverWait getWait()
		{
			return wait;
		}
		
		private void setwait(WebDriverWait wait)
		{
			this.wait=wait;
		}

	

}
