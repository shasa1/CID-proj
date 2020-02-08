package com.nk.util;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class BaseTestObject  {

	protected static WebDriver uiDriver;
	/**
	 
     * This function will execute before each Test tag in testng.xml
 
     * @param browser
 
     * @throws Exception
 
     */
 
	@BeforeClass
    @Parameters({"browserType","url"})
    public void setup(String browser,String url) throws Exception{
		
		if(browser.equalsIgnoreCase("FF")){
            uiDriver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("GC")){
            System.setProperty("webdriver.chrome.driver","D://folder//ArchNKSel//NKSeleniunAutomationTest//resource//chromedriver.exe");
            uiDriver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver","C:\\IEdriver.exe");
            uiDriver = new InternetExplorerDriver();
        }
        else{
        	throw new Exception("Browser is not correct");
        }
        uiDriver.manage().deleteAllCookies();
        uiDriver.get(url);
        Thread.sleep(5000);
        uiDriver.manage().window().maximize();
        uiDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
        
}
	@AfterClass
	public void tearDown(){
		uiDriver.quit();
	}
}
