package com.nopc.Dashboard;

import java.io.IOException;
import org.openqa.selenium.By;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.nopc.Util.Utility;

public class DashBoard {
	 @FindBy(xpath="(//img[@alt='logo.png'])[2]")private WebElement logo;
	 public DashBoard(WebDriver driver)
	 {
			PageFactory.initElements(driver, this); 
	}

	
	 	// logo verify:
                          
	 public void logovalidation( WebDriver driver) throws EncryptedDocumentException, IOException
 {

	 	//   boolean expResult1 = true;
	 	  boolean expResult1=Utility.excelbooleanData("Sheet1", 2, 5);
	 			boolean actResult1 = logo.isDisplayed();
	 			System.out.println(actResult1);
	 		
       Assert.assertEquals(actResult1, expResult1,"Logo is not displayed");
	 		 			Utility.screenshot(driver);
	 }

	 	
}
