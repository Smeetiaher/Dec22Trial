package co.nopc.Login;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nopc.Base.BaseClass;
import com.nopc.Dashboard.DashBoard;
import com.nopc.LoginWebPage.LoginWebPage;



public class LoginValiadation extends BaseClass{ 
	LoginWebPage lp;//inheritance:
	DashBoard d;
	@BeforeClass  
	public  void BrowserOpening() throws InterruptedException, EncryptedDocumentException, IOException
	{	
		BrowserLaunch();  
	     
		lp=new LoginWebPage(driver);
	     d=new DashBoard(driver);
	}
	  
		  // create obj of pom class:
	@Test(priority=2)
     public void titleveriefy() throws EncryptedDocumentException, IOException
	{      
		String actuTitle = driver.getTitle();
           String exptitle = lp.Titlevalidation();
           Assert.assertEquals(exptitle, actuTitle,"title is diffrent");

	}
	@Test(priority=1)
	public void checkboxveriefy() throws EncryptedDocumentException, IOException
	{
          lp.checkboxvalidation();
	}
	@Test(priority=3)
	public void loginveriefy() throws InterruptedException, EncryptedDocumentException, IOException
	{
		  lp.enterUn();
		  Thread.sleep(2000);
		  lp.enterpwd();
		  Thread.sleep(2000);
         lp.clicksignInbtn();
         Thread.sleep(2000);
	}   
	@Test(dependsOnMethods="loginveriefy")
	public void logoveriefy() throws EncryptedDocumentException, IOException 
	{
		  d.logovalidation(  driver);
	}	
	@AfterClass //method likha to har method k bad browser openclose hoga.
	public void BrowserClose() 
	{
		  driver.close();
	}

}
