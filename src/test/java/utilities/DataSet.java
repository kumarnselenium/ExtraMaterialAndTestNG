package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataSet {
	Workbook oWorkBook = null;
	
	public void readExcel(String sDatFileWithPath, String sSheetName) throws IOException
	{
		//Workbook oWorkBook = null;
		
	    //File class to deal with xls/xlsx file
	    File oFile =  new File(sDatFileWithPath);

	    //FileInputStream class to read excel file
	    FileInputStream oFileStream = new FileInputStream(oFile);
	    
	    //Retrieve the file extension
	    String sDataFileExtension = sDatFileWithPath.substring(sDatFileWithPath.indexOf("."));

	    //Check if the file is xls or xlsx file
	    if(sDataFileExtension.equals(".xlsx"))
	    {
	    		//XSSFWorkbook class => for XLSX 
	    		oWorkBook = new XSSFWorkbook(oFileStream);
	    }
	    else if(sDataFileExtension.equals(".xls"))
	    {	
	        //HSSFWorkbook class ==> for XLS
	    		oWorkBook = new HSSFWorkbook(oFileStream);
	    }

	    //Read sheet inside the workbook by its name
	    Sheet oSheet = oWorkBook.getSheet(sSheetName);

	    //Find number of rows in excel file
	    int iTotalRowCount = oSheet.getLastRowNum() - oSheet.getFirstRowNum();

	    //Create a loop over all the rows of excel file to read it
	    for (int i = 0; i < iTotalRowCount+1; i++) 
	    {
	        Row row = oSheet.getRow(i);
	        //Create a loop to print cell values in a row
	        for (int j = 0; j < row.getLastCellNum(); j++) 
	        {
	            //Print Excel data in console
	            System.out.print(row.getCell(j).getStringCellValue()+"|| ");
	        }
	        System.out.println();
	    }
	 }

    //Main function is calling readExcel function to read data from excel file
    public static void main(String...strings) throws IOException
    {
	    //Create an object of DataSet class
	    	DataSet objExcelFile = new DataSet();

	    //Prepare the path of excel file
	    String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";

	    //Call read file method of the class to read data
	    objExcelFile.readExcel("\\src\\excelExportAndFileIO\\ExportExcel.xlsx","ExcelGuru99Demo");
    }

}
