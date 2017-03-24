package testscripts;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pagewiseclasses.Login_Page;
import pagewiseclasses.NewCustomer_Page;
import utilityclasses.UI_GenericMethods;

public class NewCustomerPage_Test extends UI_GenericMethods{
	
	
	
	@BeforeMethod()
    public static void InitaiteAppl() throws InterruptedException, IOException{
	Login_Page loginObject= new Login_Page();
	loginObject.fn_loginMethod();
   }
    
   @AfterMethod()
    public static void CloseAppl(){
	DriverObject.quit();
  }
   
   @Test
   public static void verifyInputOfCustomerDetails() throws Exception{
	   
	   Login_Page loginObject = new Login_Page();
	   NewCustomer_Page customerObj = loginObject.fn_navigateToNewCustomerPage();
	   customerObj.fn_addNewCustomer();
	   
   }
   
   @Test
   public static void readExcelData() throws BiffException, IOException{
	   
	   raedExcelData();
	   
   }

}
