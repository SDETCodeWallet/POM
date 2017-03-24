package pagewiseclasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import utilityclasses.UI_GenericMethods;

public class Login_Page extends UI_GenericMethods {
	
	
	@FindBy(name="uid")
	public static WebElement userName;
	
	@FindBy(name="password")
	public static WebElement userPassword;
	
	@FindBy(name="btnLogin")
	public static WebElement loginBTN;
	
	@FindBy(name="btnReset")
	public static WebElement resetBTN;
	
	
	/*public LoginPage(WebDriver d) {
        PageFactory.initElements(d, this);}*/
	
   
	public static Login_Page fn_loginMethod() throws IOException, InterruptedException{
		
		FileInputStream fileInput = new FileInputStream(new File("src\\main\\resources\\config.properties"));  
	    Properties prop = new Properties();
		prop.load(fileInput);
	    
		fn_LaunchBrowser("FF");
		fn_OpenURL(prop.getProperty("url"));
		DriverObject.manage().window().maximize();
		DriverObject.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		userName.sendKeys(prop.getProperty("userName"));
		Thread.sleep(2000);
		userPassword.sendKeys(prop.getProperty("password"));

		loginBTN.click();
		
		Login_Page loginObject = PageFactory.initElements(DriverObject, Login_Page.class);
		return loginObject;
		
		
	}
	
	public static Home_Page fn_navigatetoHome(){

  		Home_Page homeObj =	 PageFactory.initElements(DriverObject, Home_Page.class);
		return homeObj;
  		
  	}
	

}
