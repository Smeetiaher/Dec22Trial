package com.nopc.Base;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.nopc.Util.Utility;


public class BaseClass
{
	 protected static WebDriver driver;
	public  static void BrowserLaunch() throws InterruptedException, EncryptedDocumentException, IOException{
	     String key = "webdriver.chrome.driver";
	   
	    
		 String value = (System.getProperty("user.dir")+ "\\Software-1\\chromedriver_win32 (1)\\chromedriver.exe");
//String URL = "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F";
		 System.setProperty(key,value);
		 
		  driver=new ChromeDriver();
		//driver.get(URL);
		  //upcasting
		  driver.manage().window().maximize();;
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//SYNCHRONISATION:Adding wait in programm
	
	 	   // get url:
		driver.get(Utility.readPropertyFile("URL"));     //PWD&usename de sakte hai
		  
}
}