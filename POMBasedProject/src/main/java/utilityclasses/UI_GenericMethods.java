package utilityclasses;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import jxl.read.biff.BiffException;

import pagewiseclasses.Login_Page;

public class UI_GenericMethods {
		public static  WebDriver DriverObject=null;;
		public static String FileName="Test_Data_Sheet.xls";
		public static String SheetName="CustomerDetails";
		public static String FirstCollVal="";
		public static String SecondCollVal="";
		
		public static int lastRowNum=0;
		protected static int j=1;
		static int x=1;
		
	public  static Login_Page fn_LaunchBrowser(String BrowserName){
		if(BrowserName.equalsIgnoreCase("FF")==true){
			DriverObject= new FirefoxDriver();
		}else if(BrowserName.equalsIgnoreCase("CH")==true){
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
			DriverObject= new ChromeDriver();	
		}else if(BrowserName.equalsIgnoreCase("IE")==true){
			System.setProperty("webdriver.ie.driver", "Browsers_Drivers/IEDriverServer.exe");
			DriverObject= new InternetExplorerDriver();
		}
		DriverObject.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		DriverObject.manage().deleteAllCookies();
		Login_Page loginObject = PageFactory.initElements(DriverObject, Login_Page.class);
		return loginObject;
	}
	
	public  static WebElement fn_GetObject(String locatorValue){
		
		WebElement we=null;
		if(locatorValue.contains("//")==true){
			
			we=DriverObject.findElement(By.xpath(locatorValue.trim()));
			
		}else if(locatorValue.contains("name=")==true){
			String locator=locatorValue.replaceAll("name=","").trim();
			we=DriverObject.findElement(By.name(locator));	
		}else if(locatorValue.contains("id=")==true){
			
			String locator=locatorValue.replaceAll("id=","").trim();
			we=DriverObject.findElement(By.id(locator));
		}
		return we;
	}
	
	
	
	public  static void fn_OpenURL(String URL){
	DriverObject.get(URL);
	}
	public  static void fn_mouseOver(WebElement ElementToMouseOver){
		   new Actions(DriverObject).moveToElement(ElementToMouseOver).build().perform();
		}
	public  static void fn_Click(WebElement ElementToClick){
		ElementToClick.click();
		}
	public  static void fn_ClickJS(WebElement ElementToClick){
		JavascriptExecutor executor = (JavascriptExecutor)DriverObject;
		executor.executeScript("arguments[0].click();", ElementToClick);
		}
	
	public  static void fn_Input(WebElement ElementInput, String InputValue){
		ElementInput.clear();
		ElementInput.sendKeys(InputValue);
		}
	

	
	public  static void fn_LaunchApp(String BrowserName, String URL){
		fn_LaunchBrowser(BrowserName);
		fn_OpenURL(URL);
//		Elance elanceObj= PageFactory.initElements(DriverObject, Elance.class);
//		
//		return elanceObj;
		}
	public  String fn_getAttribute(WebElement FoundElement, String AttrName){
		
		String attrvalue=FoundElement.getAttribute(AttrName);
	    return attrvalue;
    }	
	
	public  boolean fn_checkVisibility(WebElement ele) throws  IOException{
		boolean presence=true;
		try{
			new WebDriverWait(DriverObject, 30).until((ExpectedConditions.visibilityOf(ele)));	
		}catch(Exception e){
			presence=false;
		}
		return presence;
    }
	
	public static  String fn_GetTimeStamp(){
		  Date DTE=new Date();
			 DateFormat DF=DateFormat.getDateTimeInstance();
		String DateVal=DF.format(DTE);
		DateVal=DateVal.replaceAll(":", "_");
		DateVal=DateVal.replaceAll("/", "-");
		return DateVal;
	}
	public  String fn_GetTimeStampWithoutFormatting(){
		  Date DTE=new Date();
			 DateFormat DF=DateFormat.getDateTimeInstance();
		String DateVal=DF.format(DTE);
		
		return DateVal;
	}
	
	public  String fn_CaptureScreenshot(String ResultFolderPath, String ProductName) throws IOException{
		String ImageFolderPath="";
	    if(new File(ImageFolderPath).exists()==false){
	    	ImageFolderPath=ResultFolderPath+"/Images/Images_"+fn_GetTimeStamp();
	    	new File(ImageFolderPath).mkdir();
	    }
	    	String ImageName_Path=ImageFolderPath+"/"+ProductName+".jpeg";
			 			
		TakesScreenshot SnapDhotObj=((TakesScreenshot)DriverObject);
		File mysnapfileObj=SnapDhotObj.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(ImageName_Path+".jpeg");
		FileUtils.copyFile(mysnapfileObj, DestFile);	
		String FullPath=DestFile.getAbsolutePath();
		return FullPath;
		}
	
	public  String fn_getText(WebElement FoundElement){
		
		String text=FoundElement.getText();
	    return text;
}
	
	public static void acceptAlert(){
			try{
				Alert alert = DriverObject.switchTo().alert();
				alert.accept();
			    }catch(Exception e){
	
	            }

	}
	public static void clickElementByAction(WebDriver driver, WebElement element) {
	
		Actions action = new Actions(driver);
		action.click(element).build().perform();
	}
	
	public  static void fn_SelectWithText(WebElement FoundElement, String SelectionValue){
		List<WebElement> ListItemColl=FoundElement.findElements(By.xpath("//option"));
		for(int i=0; i<=ListItemColl.size()-1; i++){
			String  ItemText=ListItemColl.get(i).getText();
			if(ItemText.trim().equalsIgnoreCase(SelectionValue.trim())){
				new Select(FoundElement).selectByIndex(i);
				break;
			}
			}
	}

public  static void verifyText(WebElement WebObj,String ExpColumnName, int rowNumber){
    String ActualText=WebObj.getText();
    String ExpectedText=fn_GetExcelData(ExpColumnName, rowNumber);
    if(ActualText.equals(ExpectedText)){
        System.out.println("Passed. Expected Text="+ExpectedText+" Actual Text-"+ActualText);
    }else{
 	System.out.println("Failed. Expected Text="+ExpectedText+" Actual Text-"+ActualText);
 	 
	}
}


public  static void verifyText(WebElement WebObj,String ExpectedText){
	
    	String ActualText=WebObj.getText();
        
        if(ActualText.equals(ExpectedText)){
            System.out.println("Passed. Expected Text="+ExpectedText+" Actual Text-"+ActualText);
           }else{
        	System.out.println("Failed. Expected Text="+ExpectedText+" Actual Text-"+ActualText);
        	 
       	}
	
}

public static void verifyPageTitle(String expectedPageTitle,String actualPageTitle){
	
//	actualPageTitle = DriverObject.getTitle();
	
	if(expectedPageTitle.contains(actualPageTitle)){
		System.out.println("Passed. Expected Text="+expectedPageTitle+" Actual Text-"+actualPageTitle);
	}else{
    	System.out.println("Failed. Expected Text="+expectedPageTitle+" Actual Text-"+actualPageTitle);
   	 
   	}
	
}

public  static void verifyTextBoxValue(WebElement WebObj,String ExpColumnName, int rowNumber){
	   String ActualTextboxValue=WebObj.getAttribute("value").trim();
	    String ExpectedValue=fn_GetExcelData(ExpColumnName, rowNumber);
	    if(ActualTextboxValue.equals(ExpectedValue)){
	    	  System.out.println("Passed. Expected Text="+ExpectedValue+" Actual Text="+ActualTextboxValue);
	    }else{
	  	  System.out.println("Failed. Expected Textbox Value="+ExpectedValue+" Actual Textbox Value="+ActualTextboxValue);
	    }
	}

	
public  static void verifyTextBoxValue(WebElement WebObj, String ExpectedValue){
	   String ActualTextboxValue=WebObj.getAttribute("value").trim();
	    
	    if(ActualTextboxValue.equals(ExpectedValue)){
	  	  System.out.println("Passed. Expected Textbox Value="+ExpectedValue+" Actual Textbox Value="+ActualTextboxValue);
	    }else{
	  	  System.out.println("Failed. Expected Textbox Value="+ExpectedValue+" Actual Textbox Value="+ActualTextboxValue);
	    }
	}

public  static void verifyVisible(WebElement WebObj, int timeOut){

	WebDriverWait wt=new WebDriverWait(UI_GenericMethods.DriverObject, timeOut);
	wt.until(ExpectedConditions.visibilityOf(WebObj));

	}

 public  static void verifyAllItems_Listbox(WebElement WebObj,String Delimeter, String ExpColumnName, int rowNumber){
	   List<WebElement> OptionsCOll=new Select(WebObj).getOptions();
	   String ExpectedValues=fn_GetExcelData(ExpColumnName, rowNumber);
	  String[] ArrExpectedItems= ExpectedValues.split(Delimeter);
	   for(int i=0; i<=OptionsCOll.size()-1;i++){
		   if(OptionsCOll.get(i).getText().trim().equalsIgnoreCase(ArrExpectedItems[i].trim())==true){
			   System.out.println("Passed");
		   }else{
			   System.out.println("Failed");
		   }
			   
	   }
 
}
   
public static String fn_GetExcelData(String ColumnName, int rowNumber){
  return null;
    
}

public  static void fn_verifygetAttribute(WebElement WebObj,String ExpColumnName, int rowNumber){
          String  getAttribute=  WebObj.getAttribute("type").trim();
          String ExpectedValue=fn_GetExcelData(ExpColumnName, rowNumber);
          if(getAttribute.equals(ExpectedValue)){
          System.out.println("Passed");
        }else{
          System.out.println("Failed");
           }
     }


public static void windowVerificationOpenInSameandNewTab(String expecetdTitle,String actualTitle,String xPath) throws InterruptedException {

    List<WebElement> allLinks = DriverObject.findElements(By.xpath(xPath));//

    int allLinkscnt = allLinks.size();
    System.out.println("Total home page links are: " + allLinkscnt);
    Actions actObj = new Actions(DriverObject);


    for (int i = 0; i < allLinkscnt - 1; i++) {

    	allLinks = DriverObject.findElements(By.xpath(xPath)); //for updating list
        Thread.sleep(30);

        WebElement allLinks_WE = allLinks.get(i);
        actObj.moveToElement(allLinks_WE).build().perform();
        String str = allLinks_WE.getText();
        System.out.println("Home Link No: " + i + "-" + str);
        String parentWindow = DriverObject.getWindowHandle();

        allLinks_WE.click();

//            sleepForNSeconds(30)
        //               allFooterLinks_WE.click();
        Thread.sleep(3);

        Set<String> handles = DriverObject.getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parentWindow)) {
                DriverObject.switchTo().window(windowHandle);
                actualTitle = DriverObject.getTitle();

                if (actualTitle.equalsIgnoreCase(expecetdTitle)) {

                    System.out.println("Expected:" + expecetdTitle + " :window opened");

                Thread.sleep(5);
                DriverObject.close(); //closing child window
                DriverObject.switchTo().window(parentWindow); //cntrl to parent window
                //driver.close();

            } else {
                actualTitle = DriverObject.getTitle();

                DriverObject.navigate().back();
                if (actualTitle.equalsIgnoreCase(expecetdTitle)) {

                    System.out.println("Expected:" + expecetdTitle + " :window opened");
                }

                Thread.sleep(5);

            }
        }
    }

  }
 }

public static void windowVerificationOpenInSameTab(WebElement elementToBeClick, String parentWindowTitile, String childWindowTitle) throws InterruptedException {


    String parentWindow = DriverObject.getWindowHandle();

    elementToBeClick.click();
    String childWindow = DriverObject.getWindowHandle();

    Thread.sleep(2000);
    // childWindowTitle = driver.getTitle()


    if (parentWindow.equalsIgnoreCase(childWindow)) {

        DriverObject.switchTo().window(childWindow);
        childWindowTitle = DriverObject.getTitle();
        System.out.println("Expected window ' " + childWindowTitle + " 'opened");
        Thread.sleep(5);
        DriverObject.switchTo().window(parentWindow);

    }

}

public static void sendingMail(){
	
	
	
}

public static void getDataFromXL(String SheetName,int rowNum) throws Exception {
	
		String excelFileName=System.getProperty("user.dir")+"\\src\\test\\resources\\";
	  	FileInputStream fis=new FileInputStream(excelFileName+FileName);
	    Workbook wBookObj=WorkbookFactory.create(fis);
	    Sheet sheetObj=wBookObj.getSheet(SheetName);
	    int lastRow=sheetObj.getLastRowNum();
	    lastRowNum= lastRow+1;
	    if(lastRowNum>rowNum){
		
			Row ValRow=sheetObj.getRow(rowNum);
	    	Cell cellObj=ValRow.getCell(0);
	    	Cell cellObj1=ValRow.getCell(1);
	    	FirstCollVal=cellObj.getStringCellValue();
	    	SecondCollVal=cellObj1.getStringCellValue();
	    	System.out.println(FirstCollVal+" "+SecondCollVal);
			
		}else{
	    	System.out.println("Data is not found or finished");
	    }
	}


public static void raedExcelData() throws BiffException, IOException{
	
	String excelFileName=System.getProperty("user.dir")+"/src/test/resources/";
  	File fis=new File(excelFileName+FileName);
  	jxl.Workbook wb = jxl.Workbook.getWorkbook(fis);
  	
  	jxl.Sheet sh = wb.getSheet(SheetName);
  	jxl.Cell c1 = sh.getCell(1,1);
  	String str = c1.getContents();
  	System.out.println(str);
  	
  	
	}

}


               