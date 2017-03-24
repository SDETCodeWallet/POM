package testscripts;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pagewiseclasses.Login_Page;
import utilityclasses.UI_GenericMethods;

public class LoginPage_Test extends UI_GenericMethods {

	public static String loginTitle = "Gmail";
	
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
   public static void verifyLoginPage() throws IOException, InterruptedException{
	 
	 Login_Page loginObject = new Login_Page();
	 
	 String loginPageTitle = DriverObject.getTitle();
	 System.out.println(loginPageTitle);
//	 assert loginPageTitle.equalsIgnoreCase(loginTitle);
	   
   }
   @Test

   public static void fn_GetTimeStamps(){
		SimpleDateFormat SDF=new SimpleDateFormat("E dd MMM yyyy");
		String TS=SDF.format(new Date());
		System.out.println(TS);

	}
	
	
}
