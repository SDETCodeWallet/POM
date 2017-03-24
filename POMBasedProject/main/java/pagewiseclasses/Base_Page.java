package pagewiseclasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import utilityclasses.UI_GenericMethods;

public class Base_Page extends UI_GenericMethods{
	
/*	public static LoginPage fn_validLogin() throws IOException{
			
		FileInputStream fileInput = new FileInputStream(new File("src\\main\\resources\\config.properties"));  
	    Properties prop = new Properties();
		prop.load(fileInput);
		
		fn_LaunchBrowser("FF");
		fn_OpenURL(prop.getProperty("url"));
		DriverObject.manage().window().maximize();
		DriverObject.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		LoginPage loginObj = PageFactory.initElements(DriverObject, LoginPage.class);
		return loginObj;
	
	}*/
	
	
	
	
	

}
