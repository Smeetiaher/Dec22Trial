package com.nopc.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
	static Workbook wbf;
	static FileInputStream file;
public static String excelStringData(String sheetName,int rowNumber,int cellNumber ) throws EncryptedDocumentException, IOException  
{       String filepath = System.getProperty("user.dir")+"\\TestData\\TestData3.xlsx";
	 file=new FileInputStream(filepath);
	  Workbook wbf = WorkbookFactory.create(file);
	 String data = wbf.getSheet(sheetName).getRow(rowNumber-1).getCell(cellNumber-1).getStringCellValue();
     return data;
}
public static boolean excelbooleanData(String sheetName,int rowNumber,int cellNumber) throws EncryptedDocumentException, IOException 
{ 
	String filepath = System.getProperty("user.dir")+"\\TestData\\TestData3.xlsx";
	 file=new FileInputStream(filepath);
	  Workbook wbf = WorkbookFactory.create(file);
	 boolean booleanData = wbf.getSheet(sheetName).getRow(rowNumber-1).getCell(cellNumber-1).getBooleanCellValue();
	   return booleanData;
}
public static double excelnumericData(String sheetName,int rowNumber,int cellNumber) throws EncryptedDocumentException, IOException 
{ 
       String filepath = "D:\\eclipse-workspace\\Selenium_august2022\\TestData\\TestData3.xlsx";
	 file=new FileInputStream(filepath);
	  Workbook wbf = WorkbookFactory.create(file);
	 double numericData = wbf.getSheet(sheetName).getRow(rowNumber-1).getCell(cellNumber-1).getNumericCellValue();
	   return numericData;
}
public static void screenshot( WebDriver driver) throws IOException
{
	TakesScreenshot st = (TakesScreenshot)driver; //typecast driver into interface stored in 1 variable     
    File source = st.getScreenshotAs(OutputType.FILE);
    
    Date d=new Date();
	String timeStamp = d.toString().replace(":", "_").replace(" ", "_");
	System.out.println(timeStamp );
  // move that file screenshot location as per your choice
//File destination=new File("D:\\eclipse-workspace\\Selenium_august2022\\src\\Screenshort\\FB1.jpg");
File desti=new File(System.getProperty("user.dir")+"\\Screenshot4\\"+timeStamp+".jpg");
FileHandler.copy(source, desti);
}
public static String readPropertyFile(String key) throws IOException
{      
	Properties prop=new Properties();
	  String filepath = System.getProperty("user.dir")+"\\pomFile.properties\\";
		FileInputStream propertyFile = new FileInputStream(filepath);
		prop.load(propertyFile);
		 String value = prop.getProperty(key);
		return value;
}


	

}

