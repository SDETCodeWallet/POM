package utilityclasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class Excel_GenericMethod {
//	public static String fn_Data(String arg_FieldName){
//		//ArrayList TD_AL=Resources_Path.Temp_TestData;
//		int dataCnt=TD_AL.size();
//		String xl_FiledValue="";
//		for(int i=0; i<=dataCnt-1;i++){
//			String xl_FiledName=(String) TD_AL.get(i);
//			if(xl_FiledName.equalsIgnoreCase(arg_FieldName)){
//				xl_FiledValue=(String) TD_AL.get(i+1);
//				//xl_FiledValue= TD_AL.get(i+1).toString();
//			}
//		}
//		return xl_FiledValue; 
//	}
	public static ArrayList fn_TestCaseCount(String[][] DriverData_Arr, String TestCaseName){
		int arr_rowcnt=DriverData_Arr.length; 
		int counter=0;
		ArrayList AL_TCInfo=new ArrayList();
		
		for(int i=0; i<=arr_rowcnt-1; i++){
			String TD_TCMethodName=DriverData_Arr[i][0];
			if(TestCaseName==TD_TCMethodName){
				counter=counter+1;
				AL_TCInfo.add(i+1);
			}
		}
		return AL_TCInfo;
	}
	
	
	
	
	//////SC_EditCalendarPage_NewToDo
//	public static ArrayList fn_getTestData(int rownum) throws IOException{
//		String TestDataPath=Resources_Path.TestDataPath;
//		String DataSheet_Name=Resources_Path.TestDataSheet_Name;
//		FileInputStream FIS=new FileInputStream(TestDataPath);
//		XSSFWorkbook WbookObj=new XSSFWorkbook(FIS);
//		XSSFSheet WSheetObj=WbookObj.getSheet(DataSheet_Name);
//		ArrayList AL=new ArrayList();
//		XSSFRow RowObj=WSheetObj.getRow(rownum);
//		int cellcnt=RowObj.getLastCellNum();
//		for(int i=1; i<=cellcnt-1; i++){
//			String Cellval=RowObj.getCell(i, XSSFRow.CREATE_NULL_AS_BLANK).getStringCellValue();
//			AL.add(Cellval);
//		}
//		return AL;
//		
//	}
	
//	public static ArrayList fn_getTestData(String arg_ScriptID) throws IOException{
//	String TestDataPath=Resources_Path.TestDataPath;
//		String DataSheet_Name=Resources_Path.TestDataSheet_Name;
//		FileInputStream FIS=new FileInputStream(TestDataPath);
//		XSSFWorkbook WbookObj=new XSSFWorkbook(FIS);
//		XSSFSheet WSheetObj=WbookObj.getSheet(DataSheet_Name);
//		int rowcnt=WSheetObj.getLastRowNum();
//		int Script_ID_RowNum=0;
//		for(int i=1; i<=rowcnt; i++){
//			String ScriptID_XL=WSheetObj.getRow(i).getCell(0,XSSFRow.CREATE_NULL_AS_BLANK).getStringCellValue();
//		    if(ScriptID_XL.equalsIgnoreCase(arg_ScriptID)){
//		    	Script_ID_RowNum=i;
//		    	break;
//		    }
//		}
//		ArrayList AL=new ArrayList();
//		XSSFRow RowObj=WSheetObj.getRow(Script_ID_RowNum);
//		int cellcnt=RowObj.getLastCellNum();
//		for(int i=1; i<=cellcnt-1; i++){
//			XSSFCell CellObj=RowObj.getCell(i, XSSFRow.CREATE_NULL_AS_BLANK);
//            String Cellval="";
//			int CellType=CellObj.getCellType();
//			int StringCellType_Index=XSSFCell.CELL_TYPE_STRING;
//			int NumericCellType_Index=XSSFCell.CELL_TYPE_NUMERIC;
//			
//			if(CellType==StringCellType_Index){
//				Cellval=RowObj.getCell(i, XSSFRow.CREATE_NULL_AS_BLANK).getStringCellValue();
//			}else if(CellType==NumericCellType_Index){
//				Double DBL_Cellval=RowObj.getCell(i, XSSFRow.CREATE_NULL_AS_BLANK).getNumericCellValue();
//				Cellval=DBL_Cellval.toString();
//			}
//			AL.add(Cellval);
//		}
//	
//		
//		return AL;
//		
//	}
//	
//	public static String[][] fn_getExcelData_2DArray(String WorkbookPath, String SheetName) throws IOException{
//		
//		FileInputStream FIS=new FileInputStream(WorkbookPath);
//		XSSFWorkbook WbookObj=new XSSFWorkbook(FIS);
//		XSSFSheet WSheetObj=WbookObj.getSheet(SheetName);
//		int rowcnt=WSheetObj.getLastRowNum();
//		int colmcnt=WSheetObj.getRow(0).getLastCellNum();
//		int Script_ID_RowNum=0;
//	    	
//		String[][] Arr=new String[rowcnt][colmcnt-1];
//		String Cellval="";
//		int CellType=1;
//		for(int i=1; i<=rowcnt; i++){
//			XSSFRow Row_Obj=WSheetObj.getRow(i);
//			for(int j=1; j<=colmcnt-1; j++){
//				Cellval="";
//				try{
//				CellType=Row_Obj.getCell(j, XSSFRow.CREATE_NULL_AS_BLANK).getCellType();
//				}catch(Exception e){
//					System.out.println(j);
//				}
//				
//				int StringCellType_Index=XSSFCell.CELL_TYPE_STRING;
//				int NumericCellType_Index=XSSFCell.CELL_TYPE_NUMERIC;
//				
//				if(CellType==StringCellType_Index){
//					Cellval=Row_Obj.getCell(j, XSSFRow.CREATE_NULL_AS_BLANK).getStringCellValue();
//				}else if(CellType==NumericCellType_Index){
//					Double DBL_Cellval=Row_Obj.getCell(j, XSSFRow.CREATE_NULL_AS_BLANK).getNumericCellValue();
//					Cellval=DBL_Cellval.toString();
//				}
//				
//				Arr[i-1][j-1]=Cellval;
//			}
//		}
//		FIS.close();
//		return Arr;
//		
//	}

	
	
	
	/////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////
	public static String ResultSheetFolder="Results//XL_Results//";
	public static String ResultSheetPath="";
	public static void main(String[] args) throws IOException, InvalidFormatException {
		// TODO Auto-generated method stub
		//Excel_Handling_ExistingSheet.fn_CreateAndFormatExcel();
//		String[] Arr={"Marketing", "Leads", "CreateLead", "SC_CLead", "xyz", "xyz", "failed", "Snapshot"};
//            fn_WriteResultToExcel(Arr);
//            fn_WriteResultToExcel(Arr);
//            fn_WriteResultToExcel(Arr);
//            fn_WriteResultToExcel(Arr);
	}
	
	public static void fn_WriteResultToExcel(String[] Arr_ResultToWrite) throws IOException, InvalidFormatException{
		
		   File ResultFileObj=new File(ResultSheetPath);
		   if(ResultFileObj.exists()==false){
			   fn_CreateAndFormatExcel();
		   }
		   
		   fn_UpdateExcelResults(Arr_ResultToWrite);
	}
	public static void fn_CreateAndFormatExcel() throws IOException{
		XSSFWorkbook WbookObj=new XSSFWorkbook();
		XSSFSheet WsheetObj=WbookObj.createSheet("Result_Sheet");
		XSSFRow FstRowObj=WsheetObj.createRow(0);
		String[] ColmnArr={"ModuleName","SubModuleName", "TestCaseName","ScriptID", "ActualValue", "expectedValue", "Status", "SnapshotLink" };
		for(int i=0; i<=ColmnArr.length-1; i++){
			XSSFCell CellObj=FstRowObj.createCell(i);
			CellObj.setCellValue(ColmnArr[i]);
			short colorindex=IndexedColors.YELLOW.getIndex();
			short fontheight=16;
			CellStyle StyleObj=fn_SetCellStyle(WbookObj, colorindex,fontheight);
			CellObj.setCellStyle(StyleObj);
			WsheetObj.autoSizeColumn(i);
		}
		String ResultFileName="Execution_Results";
		  Date DTE=new Date();
		 DateFormat DF=DateFormat.getDateTimeInstance();
	String DateVal=DF.format(DTE);
	DateVal=DateVal.replaceAll(":", "_");
		String ResultPath=ResultSheetFolder+"/"+ResultFileName+DateVal+".xls";
		FileOutputStream FOS=new FileOutputStream(ResultPath);
		WbookObj.write(FOS);
		FOS.close();
		ResultSheetPath=ResultPath;
	}
	
	public static CellStyle fn_SetCellStyle(Workbook WbookObj,short cell_color_index, short FontHeight){
		
		CellStyle CellStyleObj=WbookObj.createCellStyle();
		CellStyleObj.setFillForegroundColor(cell_color_index);
		short fillPatern_index=CellStyleObj.SOLID_FOREGROUND;
		CellStyleObj.setFillPattern(fillPatern_index);
		Font FontObj=fn_SetFontStyle(WbookObj, FontHeight);
		CellStyleObj.setFont(FontObj);
		return CellStyleObj;
	}
	
	public static Font fn_SetFontStyle(Workbook WbookObj,short fontheight ){
		
		Font FontObj=WbookObj.createFont();
		FontObj.setFontHeightInPoints(fontheight);
		FontObj.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		return FontObj;
		
	}
	public static void fn_UpdateExcelResults(String[] ArrValToWrite) throws IOException, InvalidFormatException{
		FileInputStream FIS=new FileInputStream(ResultSheetPath);
		Workbook WbookObj=WorkbookFactory.create(FIS);
		Sheet WSheetObj=WbookObj.getSheet("Result_Sheet");
		int lastrownum=WSheetObj.getLastRowNum();
		int required_row=lastrownum+1;
		Row RowObj=WSheetObj.createRow(required_row);
		
		 
		for(int i=0; i<=ArrValToWrite.length-1; i++){
			Cell CellObj=RowObj.createCell(i);
				if(ArrValToWrite[6].equalsIgnoreCase("Failed")){
						CellStyle FailStyleObj=fn_SetCellStyle(WbookObj, IndexedColors.RED.getIndex(), (short)12);
					CellObj.setCellStyle(FailStyleObj);
				}
			CellObj.setCellValue(ArrValToWrite[i]);	
		}
		FileOutputStream FOS=new FileOutputStream(ResultSheetPath);
		WbookObj.write(FOS);
		FOS.close();
	}

}
