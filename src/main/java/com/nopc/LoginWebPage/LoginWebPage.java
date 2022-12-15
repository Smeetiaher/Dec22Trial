package com.nopc.LoginWebPage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.nopc.Util.Utility;

public class LoginWebPage {
	@FindBy(xpath="//input[@type=\"checkbox\"]")private  WebElement chkBox;
	@FindBy(xpath="//input[@type=\"email\"]")private WebElement Us;
	@FindBy(xpath="//input[@type=\"password\"]")private WebElement pwd;
	@FindBy(xpath="//button[@type=\"submit\"]")private WebElement Signinbutton;
	public LoginWebPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	
	}
	 // Title Verify:
	public String Titlevalidation( ) throws EncryptedDocumentException, IOException
	{
	 //String exptitle = "Your store. Login";
		String exptitle=Utility.excelStringData("Sheet1", 2, 1);
		return exptitle;
	
	}
	 // Checkbox is selected:
	public void checkboxvalidation() throws EncryptedDocumentException, IOException
	{
	//   boolean expResult = true;
		boolean expResult=Utility.excelbooleanData("Sheet1", 2, 5);
	   chkBox.click();
	boolean actReasult = chkBox.isSelected();  //false
	Assert.assertEquals(expResult, actReasult,"Logo is alredy selected");
	}
	
	// Enter Email:
	public void enterUn() throws EncryptedDocumentException, IOException 
	{
		Us.clear();

	//	Us.sendKeys("admin@yourstore.com");
		Us.sendKeys(Utility.excelStringData("Sheet1", 2, 3));
	}	

	//enter pwd:
		public void enterpwd() throws EncryptedDocumentException, IOException 
		{
	
		pwd.clear();
//		pwd.sendKeys("admin");
		pwd.sendKeys(Utility.excelStringData("Sheet1", 2, 4));
		}
	// click on button:
		public void clicksignInbtn() 
		{
		Signinbutton.click();
		}
	}



