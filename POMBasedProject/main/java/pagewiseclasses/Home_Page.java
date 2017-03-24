package pagewiseclasses;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilityclasses.UI_GenericMethods;

public class Home_Page extends UI_GenericMethods {

	
	@FindBy(className="menusubnav")
	public static List<WebElement> linksCollection;
	
	@FindBy(linkText= "Manager")
	public static WebElement managerLINK;
	
	@FindBy(linkText= "New Customer")
	public static WebElement newCustomerLINK;
	
	@FindBy(linkText= "Edit Customer")
	public static WebElement editCustomerLINK;
	
	@FindBy(linkText= "Delete Customer")
	public static WebElement deleteCustomerLINK;
	
	@FindBy(linkText= "New Account")
	public static WebElement newAccountLINK;

	@FindBy(linkText= "Edit Account")
	public static WebElement editAccountLINK;
	
	@FindBy(linkText= "Delete Account")
	public static WebElement deleteAccountLINK;
	
	@FindBy(linkText= "Deposit")
	public static WebElement depositLINK;
	
	@FindBy(linkText= "Withdrawal")
	public static WebElement withdrawalLINK;
	
	@FindBy(linkText= "Fund Transfer")
	public static WebElement fundTransferLINK;
	
	@FindBy(linkText= "Change Password")
	public static WebElement changePasswordLINK;
	
	@FindBy(linkText= "Balance Enquiry")
	public static WebElement balanceEnquiryLINK;
	
	@FindBy(linkText= "Mini Statement")
	public static WebElement miniStatementLINK;
	
	@FindBy(linkText= "Customised Statement")
	public static WebElement customisedStatementLINK;
	
	@FindBy(linkText= "Log out")
	public static WebElement logOutLINK;
	
	
	public static String homeLinksXPath="//ul[@class='menusubnav']//li";
	public static String expHomePageTitle=" Guru99 Bank Manager HomePage ";
	public static String actHomePageTitle;
	public static String expectedNewCustomerPageTitle=" Guru99 Bank New Customer Entry Page ";
	public static String actualNewCustomerPageTitle;
	public static String expectedDeleteCustomerPageTitle=" Guru99 Bank Delete Customer Page ";
	public static String actualDeleteCustomerPageTitle;
	public static String expectedNewAccountPageTitle="  Guru99 bank add new account  ";
	public static String actualNewAccountPageTitle;
	public static String expectedEditAccountPageTitle="  Guru99 Edit Account Page  ";
	public static String actualEditAccountPageTitle;
	public static String expectedDeleteAccountPageTitle=" Guru99 Bank Delete Account Page  ";
	public static String actualDeleteAccountPageTitle;
	public static String expectedDepositPageTitle="  Guru99 Bank Amount Deposit Page  ";
	public static String actualDepositPageTitle;
	public static String expectedWithdrawalPageTitle=" Guru99 Bank Amount Withdrawal Page   ";
	public static String actualWithdrawalPageTitle;
	public static String expectedFundTransferPageTitle=" Guru99 Bank Fund Transfer Entry Page ";
	public static String actualFundTransferPageTitle;
	public static String expectedChangePasswordPageTitle="Guru99 Bank New Customer Entry Page";
	public static String actualChangePasswordPageTitle;
	public static String expectedBalanceEnquiryPageTitle="Guru99 Bank Balance Enquiry Page";
	public static String actualBalanceEnquiryPageTitle;
	public static String expectedMiniStatementPageTitle="Guru99 Bank Mini Statement Page ";
	public static String actualMiniStatementPageTitle;
	public static String expectedCustomisedStatementPageTitle="Guru99 Bank Statement Page  ";
	public static String actualCustomisedStatementPageTitle;
	
	
	
	
	
	public static void fn_homePageTitle(){
		
		actHomePageTitle=DriverObject.getTitle();
		verifyPageTitle(expHomePageTitle, actHomePageTitle);
		
	}
	
	
	
	
	
	
	
}
