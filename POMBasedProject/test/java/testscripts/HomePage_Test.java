package testscripts;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pagewiseclasses.Home_Page;
import pagewiseclasses.Login_Page;
import utilityclasses.UI_GenericMethods;

public class HomePage_Test extends UI_GenericMethods {

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
	public static void vrifyHomePage(){
		
	   Login_Page loginObj= new Login_Page();
	   Home_Page homePageObj = loginObj.fn_navigatetoHome();
	   
	   homePageObj.fn_homePageTitle();
			
	}
   
   
   @Test
   	public static void verifyLinksOnHomePage() throws InterruptedException{
   		
   		Login_Page loginObj= new Login_Page();
   		Home_Page homePageObj = loginObj.fn_navigatetoHome();
   		windowVerificationOpenInSameandNewTab(homePageObj.expectedNewCustomerPageTitle,homePageObj.actualNewCustomerPageTitle,homePageObj.homeLinksXPath);
  
   	}
   
   @Test
   public static void verifyLinksPages() throws InterruptedException{
	   
	   Login_Page loginObj= new Login_Page();
	   Home_Page homePageObj = loginObj.fn_navigatetoHome();
	   windowVerificationOpenInSameTab(homePageObj.newCustomerLINK, homePageObj.expectedNewCustomerPageTitle, homePageObj.actualNewCustomerPageTitle);
	   windowVerificationOpenInSameTab(homePageObj.editCustomerLINK, homePageObj.expHomePageTitle, homePageObj.actHomePageTitle);   
	   windowVerificationOpenInSameTab(homePageObj.deleteCustomerLINK, homePageObj.expectedDeleteCustomerPageTitle, homePageObj.actualDeleteCustomerPageTitle);
	   windowVerificationOpenInSameTab(homePageObj.newAccountLINK,homePageObj.expectedNewAccountPageTitle, homePageObj.actualNewAccountPageTitle);
	   windowVerificationOpenInSameTab(homePageObj.editAccountLINK,homePageObj.expectedEditAccountPageTitle, homePageObj.actualEditAccountPageTitle);
	   windowVerificationOpenInSameTab(homePageObj.deleteAccountLINK,homePageObj.expectedDeleteAccountPageTitle, homePageObj.actualDeleteAccountPageTitle);
	   windowVerificationOpenInSameTab(homePageObj.depositLINK, homePageObj.expectedDepositPageTitle,homePageObj.actualDepositPageTitle);
	   windowVerificationOpenInSameTab(homePageObj.withdrawalLINK,homePageObj.expectedWithdrawalPageTitle,homePageObj.actualWithdrawalPageTitle);
	   windowVerificationOpenInSameTab(homePageObj.fundTransferLINK,homePageObj.expectedFundTransferPageTitle,homePageObj.actualFundTransferPageTitle);
	   windowVerificationOpenInSameTab(homePageObj.changePasswordLINK, homePageObj.expectedChangePasswordPageTitle,homePageObj.actualChangePasswordPageTitle);
	   windowVerificationOpenInSameTab(homePageObj.balanceEnquiryLINK, homePageObj.expectedBalanceEnquiryPageTitle, homePageObj.actualBalanceEnquiryPageTitle);
	   windowVerificationOpenInSameTab(homePageObj.miniStatementLINK, homePageObj.expectedMiniStatementPageTitle, homePageObj.actualMiniStatementPageTitle);
	   windowVerificationOpenInSameTab(homePageObj.customisedStatementLINK, homePageObj.expectedCustomisedStatementPageTitle, homePageObj.actualCustomisedStatementPageTitle);
   }
   
   
   
	
	
}
