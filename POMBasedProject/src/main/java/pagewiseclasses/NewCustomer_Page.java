package pagewiseclasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;

import net.sf.saxon.functions.DynamicContextAccessor.CurrentDateTime;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilityclasses.Excel_GenericMethod;
import utilityclasses.UI_GenericMethods;

public class NewCustomer_Page extends UI_GenericMethods {
	
	@FindBy(linkText= "New Customer")
	public static WebElement newCustomerLINK;
	
	@FindBy(name="name")
	public static WebElement newCustomerName_INP;
	
	@FindBy(xpath="//input[@value='m']")
	public static WebElement genderMale_RadioBTN;
	
	@FindBy(xpath="//input[@value='f']")
	public static WebElement genderFemale_RadioBTN;
	
	@FindBy(name="dob")
	public static WebElement dateOfBirth_INP;
	
	@FindBy(name="addr")
	public static WebElement address_INP;
	
	@FindBy(name="city")
	public static WebElement city_INP;
	
	@FindBy(name="state")
	public static WebElement state_INP;
	
	@FindBy(name="state")
	public static WebElement pinNo_INP;
	
	@FindBy(name="telephoneno")
	public static WebElement telePhoneNo_INP;
	
	@FindBy(name="emailid")
	public static WebElement emailID_INP;
	
	@FindBy(name="password")
	public static WebElement password_INP;
	
	@FindBy(name="sub")
	public static WebElement submit_BTN;
	
	@FindBy(name="res")
	public static WebElement reset_BTN;
	
//	public static String excelFilePath = "src\\test\\resources\\Test_Data_Sheet.xlsx";
	public static String sheetName = "CustomerDetails";
	
	
	public static void fn_addNewCustomer() throws Exception{
		
		/*FileInputStream fileInput = new FileInputStream(new File("src\\main\\resources\\config.properties"));  
	    Properties prop = new Properties();
		prop.load(fileInput);*/
		
//		String[][] excelArr = fn_getExcelData_2DArray(excelFilePath,sheetName);
	
		newCustomerLINK.click();
		Thread.sleep(2000);
		
		getDataFromXL(sheetName, j);
		newCustomerName_INP.sendKeys(FirstCollVal);
		
		genderMale_RadioBTN.click();
		
		dateOfBirth_INP.sendKeys(SecondCollVal);
		
		
		
	}
	
	
	
	
	
	

}
