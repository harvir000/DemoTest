package utilsPckg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	public XMLReader xml;
	
	public Excel()
	{
		xml = new XMLReader("config.xml");
	}
	
	public FileInputStream getExcelPath(String path) throws FileNotFoundException, IOException, Exception
	{
		try
		{
			FileInputStream ExcelFileToRead = new FileInputStream(new File(path));
			return ExcelFileToRead;
		}
		catch(FileNotFoundException fnf)
		{
			throw new FileNotFoundException("File not available.");
		}
		catch(IOException io)
		{
			throw new IOException("Unable to read file.", io);
		}
		catch(Exception e)
		{
			throw new Exception("There is some thing wrong while reading the file.", e);
		}
		
	}
	
	public int getRowCount(String path, int sheetNo) throws Exception
	{
		int totRowCount = 0;
		try{
			if((FilenameUtils.getExtension(path)).equalsIgnoreCase("xlsx"))
			{
					FileInputStream file1 = new FileInputStream(new File(path));
					XSSFWorkbook ExcelWBook = new XSSFWorkbook(file1);
					totRowCount = ExcelWBook.getSheetAt(sheetNo).getLastRowNum();
			}
		}
		catch(Exception e)
		{
			throw new Exception("Unable to get row count");
		}
		return totRowCount;
	}
	
//	public String getSheetValue(String path, String sheet, String row, String columnname) throws IOException
//	{
//		int sheetNo=-1;
//		String Flag = "";
//		 try{
//			 sheetNo= Integer.parseInt(sheet)-1;
//			 
//		 }catch(Exception e){
//		 }
//			 try{
//			if((FilenameUtils.getExtension(path)).equalsIgnoreCase("xlsx"))
//			{
//				try
//				{
//					FileInputStream file1 = new FileInputStream(new File(path));
//					XSSFWorkbook ExcelWBook = new XSSFWorkbook(file1);
//					XSSFSheet ExcelWSheet;
//					
//	//				int rowCount = ExcelWSheet.getLastRowNum()-ExcelWSheet.getFirstRowNum();
//					if(sheetNo>-1)
//						ExcelWSheet = ExcelWBook.getSheet(ExcelWBook.getSheetAt(sheetNo).getSheetName());
//					else
//						ExcelWSheet = ExcelWBook.getSheet(sheet);
//					
//					 Row firstRow = ExcelWSheet.getRow(0);
//				      for(Cell cell:firstRow)
//				      {
//			        	 if (cell.getStringCellValue().equals(columnname))
//			             {
//			        		 int row1 = (int)Float.parseFloat(row);
//			            	 Row vrow = ExcelWSheet.getRow(row1);
//			            	 cell = vrow.getCell(cell.getColumnIndex());
//			            	 if(cell.getCellType()==0)
//			            	 {
//			            		 return Double.toString(cell.getNumericCellValue());
//			            	 }
//			            	 else if(cell.getCellType()==1)
//			            	 {
//			            		 return cell.getStringCellValue();
//			            	 }
//			            	 else if (cell.getCellType()==3)
//			            	 {
//			            		 return "";
//			            	 }
//			            	 Flag = "True";
//			             }
//				      }
//			      if(Flag.equalsIgnoreCase("False"))
//			      {
//			    	  return "";
//			      }
//				}
//				catch(Exception e1)
//				{
//					System.out.println("exception while readin excel"+e1.getMessage());
//				}
//			}
//			else if((FilenameUtils.getExtension(path)).equalsIgnoreCase("xls"))
//			{
//				FileInputStream file1 = new FileInputStream(new File(path));
//				HSSFWorkbook ExcelWBook = new HSSFWorkbook(file1);
//				HSSFSheet ExcelWSheet = ExcelWBook.getSheet(sheet);
//	//			int rowCount = ExcelWSheet.getLastRowNum()-ExcelWSheet.getFirstRowNum();
//				if(sheetNo>-1)
//					ExcelWSheet = ExcelWBook.getSheet(ExcelWBook.getSheetAt(sheetNo).getSheetName());
//				else
//					ExcelWSheet = ExcelWBook.getSheet(sheet);
//				
//				Row firstRow = ExcelWSheet.getRow(0);
//			      for(Cell cell:firstRow)
//			      {
//		        	 if (cell.getStringCellValue().equals(columnname))
//		             {
//		        		 int row1 = (int)Float.parseFloat(row);
//		            	 Row vrow = ExcelWSheet.getRow(row1);
//		            	 cell = vrow.getCell(cell.getColumnIndex());
//		            	 if(cell.getCellType()==0)
//		            	 {
//		            		 return Double.toString(cell.getNumericCellValue());
//		            	 }
//		            	 else if(cell.getCellType()==1)
//		            	 {
//		            		 return cell.getStringCellValue();
//		            	 }
//		            	 else if (cell.getCellType()==3)
//		            	 {
//		            		 return "";
//		            	 }
//		            	 Flag = "True";
//		             }
//		           }
//			      if(Flag.equalsIgnoreCase("False"))
//			      {
//	//		    	  Libs.addToReport("Error ID 17 : Could not read column name : "+ colName, Libs.FAIL);
//			    	  return "";
//			      }
//			}
//			return Flag;
//		 }
//		 catch(IOException ie)
//		 {
//			 throw new IOException("Some problem in reading data from excel.");
//		 }
//	}

	public String getSheetValue(String path, String sheet, String row, String columnname) throws IOException
	{
		int sheetNo=-1;
		String Flag = "";
		 try{
			 sheetNo= Integer.parseInt(sheet)-1;
			 
		 }catch(Exception e){
		 }
			 try{
			if((FilenameUtils.getExtension(path)).equalsIgnoreCase("xlsx"))
			{
				try
				{
					XSSFSheet ExcelWSheet = getXSSFSheetObject(getXSSFWorkbookObject(path), sheet);
					
					 Row firstRow = ExcelWSheet.getRow(0);
				      for(Cell cell:firstRow)
				      {
			        	 if (cell.getStringCellValue().equals(columnname))
			             {
			        		 int row1 = (int)Float.parseFloat(row);
			            	 Row vrow = ExcelWSheet.getRow(row1);
			            	 cell = vrow.getCell(cell.getColumnIndex());
			            	 if(cell.getCellType()==0)
			            	 {
			            		 return Double.toString(cell.getNumericCellValue());
			            	 }
			            	 else if(cell.getCellType()==1)
			            	 {
			            		 return cell.getStringCellValue();
			            	 }
			            	 else if (cell.getCellType()==3)
			            	 {
			            		 return "";
			            	 }
			            	 Flag = "True";
			             }
				      }
			      if(Flag.equalsIgnoreCase("False"))
			      {
			    	  return "";
			      }
				}
				catch(Exception e1)
				{
					System.out.println("exception while readin excel"+e1.getMessage());
				}
			}
			else if((FilenameUtils.getExtension(path)).equalsIgnoreCase("xls"))
			{
				FileInputStream file1 = new FileInputStream(new File(path));
				HSSFWorkbook ExcelWBook = new HSSFWorkbook(file1);
				HSSFSheet ExcelWSheet = ExcelWBook.getSheet(sheet);
	//			int rowCount = ExcelWSheet.getLastRowNum()-ExcelWSheet.getFirstRowNum();
				if(sheetNo>-1)
					ExcelWSheet = ExcelWBook.getSheet(ExcelWBook.getSheetAt(sheetNo).getSheetName());
				else
					ExcelWSheet = ExcelWBook.getSheet(sheet);
				
				Row firstRow = ExcelWSheet.getRow(0);
			      for(Cell cell:firstRow)
			      {
		        	 if (cell.getStringCellValue().equals(columnname))
		             {
		        		 int row1 = (int)Float.parseFloat(row);
		            	 Row vrow = ExcelWSheet.getRow(row1);
		            	 cell = vrow.getCell(cell.getColumnIndex());
		            	 if(cell.getCellType()==0)
		            	 {
		            		 return Double.toString(cell.getNumericCellValue());
		            	 }
		            	 else if(cell.getCellType()==1)
		            	 {
		            		 return cell.getStringCellValue();
		            	 }
		            	 else if (cell.getCellType()==3)
		            	 {
		            		 return "";
		            	 }
		            	 Flag = "True";
		             }
		           }
			      if(Flag.equalsIgnoreCase("False"))
			      {
	//		    	  Libs.addToReport("Error ID 17 : Could not read column name : "+ colName, Libs.FAIL);
			    	  return "";
			      }
			}
			return Flag;
		 }
		 catch(IOException ie)
		 {
			 throw new IOException("Some problem in reading data from excel.");
		 }
	}
	
	public LinkedHashMap<String, ArrayList<String>> getMasterSheetData()// Can pass config.xml var name and it will fecth testdata values as well
	{
		LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();
		if((FilenameUtils.getExtension(xml.readTagVal("MASTEREXCELPATH"))).equalsIgnoreCase("xlsx"))
		{
			try
			{
				// Create object for sheet
//				XSSFSheet MasterSheet = new XSSFWorkbook(new FileInputStream(new File(xml.readTagVal("MASTEREXCELPATH")))).getSheetAt(0);
				XSSFSheet MasterSheet = getXSSFSheetObject(getXSSFWorkbookObject(xml.readTagVal("MASTEREXCELPATH")), "1");
				Row row;
				Cell cell = null;
				
				//will get number of columns
				int numOfColumns = MasterSheet.getRow(0).getLastCellNum();
				
				//loop will perform on rows
				// we are starting rom 1 as 0 is headers of row.
				for(int counter =1; counter<=MasterSheet.getLastRowNum(); counter ++)
				{
					ArrayList<String> mapData = new ArrayList<String>();
					row = MasterSheet.getRow(counter);
					String val ="";
					//loop will perform on columns
					for(int colCounter = 1 ; colCounter<numOfColumns; colCounter++)
					{
						cell = row.getCell(colCounter);
						 if(cell.getCellType()==0)
		            	 {
							 val=Double.toString(cell.getNumericCellValue());
		            	 }
		            	 else if(cell.getCellType()==1)
		            	 {
		            		 val=cell.getStringCellValue();
		            	 }
		            	 else if (cell.getCellType()==3)
		            	 {
		            		 val="";
		            	 }
						 mapData.add(val);
					}
					map.put(row.getCell(0).getStringCellValue(), mapData);
				}
//				System.out.println(map);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		return map;
		
	}
	
	
	
	public XSSFWorkbook getXSSFWorkbookObject(String path)
	{
		try
		{
			FileInputStream file1 = getExcelPath(path);
			XSSFWorkbook ExcelWBook = new XSSFWorkbook(file1);
			return ExcelWBook;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	public HSSFWorkbook getHSSFWorkbookObject(String path)
	{
		try
		{
			FileInputStream file1 = new FileInputStream(new File(path));
			HSSFWorkbook ExcelWBook = new HSSFWorkbook(file1);
			return ExcelWBook;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	public XSSFSheet getXSSFSheetObject(XSSFWorkbook ExcelWBook, String sheet)
	{
		// if sheet variable is number then it will consider this and if it is String then it will also consider
		// Make sure sheet number should NOT be ZERO.
		int sheetNo=-1;
		 try{
			 sheetNo= Integer.parseInt(sheet)-1;
		 	}catch(Exception e){}
		try{
			XSSFSheet ExcelWSheet;
			if(sheetNo>-1)
				ExcelWSheet = ExcelWBook.getSheet(ExcelWBook.getSheetAt(sheetNo).getSheetName());
			else
				ExcelWSheet = ExcelWBook.getSheet(sheet);
			
			return ExcelWSheet;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	public HSSFSheet getHSSFSheetObject(HSSFWorkbook ExcelWBook, String sheet)
	{
		
		// if sheet variable is number then it will consider this and if it is String then it will also consider
		int sheetNo=-1;
		 try{
			 sheetNo= Integer.parseInt(sheet)-1;
		 }catch(Exception e){
		 }
		try{
			HSSFSheet ExcelWSheet;
			if(sheetNo>-1)
				ExcelWSheet = ExcelWBook.getSheet(ExcelWBook.getSheetAt(sheetNo).getSheetName());
			else
				ExcelWSheet = ExcelWBook.getSheet(sheet);
			
			return ExcelWSheet;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	public ArrayList<String> getTestData(String fileName, String SheetName, String testID)
	{
		ArrayList<String> mapData = new ArrayList<String>();
		if((FilenameUtils.getExtension(fileName)).equalsIgnoreCase("xlsx"))
		{
			try
			{
				// Create object for sheet
//				XSSFSheet MasterSheet = new XSSFWorkbook(new FileInputStream(new File(xml.readTagVal("MASTEREXCELPATH")))).getSheetAt(0);
				XSSFSheet MasterSheet = getXSSFSheetObject(getXSSFWorkbookObject(fileName), SheetName);
				
				if(MasterSheet !=null)
				{
					Row row;
					Cell cell = null;
					
					//will get number of columns
					int numOfColumns = MasterSheet.getRow(0).getLastCellNum();
					
					//loop will perform on rows
					// we are starting rom 1 as 0 is headers of row.
					for(int counter =1; counter<=MasterSheet.getLastRowNum(); counter ++)
					{
						row = MasterSheet.getRow(counter);
						if(row.getCell(0).getStringCellValue().equalsIgnoreCase(testID))
						{
							String val ="";
							//loop will perform on columns
							for(int colCounter = 1 ; colCounter<numOfColumns; colCounter++)
							{
								cell = row.getCell(colCounter);
								if(cell.getCellType()==0)
								{
									val=Double.toString(cell.getNumericCellValue());
								}
								else if(cell.getCellType()==1)
								{
									val=cell.getStringCellValue();
								}
								else if (cell.getCellType()==3)
								{
									val="";
								}
								mapData.add(val);
							}
//						map.put(row.getCell(0).getStringCellValue(), mapData);
						}
					}
				}  //End if
//				System.out.println(map);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		return mapData;
	}
	
//	public ArrayList<String> getSheetNames(String path)
//	{
//		ArrayList<String> sheetnames = new ArrayList<String>();
//		Object workbookObj;
//		if((FilenameUtils.getExtension(path)).equalsIgnoreCase("xlsx"))
//		{
//			XSSFWorkbook WRKOBJ = getXSSFWorkbookObject(path);
//			WRKOBJ.getSheet("abc");
//		}
//		else if((FilenameUtils.getExtension(path)).equalsIgnoreCase("xls"))
//		{
//			HSSFWorkbook WRKOBJ = getHSSFWorkbookObject(path);
//			WRKOBJ.getSheet(arg0)
//		}
//		for(int counter =0; counter<=getNumberOfSheets(path); counter++)
//		{
//			sheetnames = WRKOBJ.
//		}
//		
//		return null;
//		
//	}
	
	public int getNumberOfSheets(String path)
	{
		int numOfSheets = 0;
		if((FilenameUtils.getExtension(path)).equalsIgnoreCase("xlsx"))
		{
			XSSFWorkbook WRKOBJ = getXSSFWorkbookObject(path);
			numOfSheets = WRKOBJ.getNumberOfSheets();

		}
		else if((FilenameUtils.getExtension(path)).equalsIgnoreCase("xls"))
		{
			HSSFWorkbook WRKOBJ = getHSSFWorkbookObject(path);
			numOfSheets = WRKOBJ.getNumberOfSheets();
		}
		return numOfSheets;
	}
	
	public void readTestData()
	{
		
	}

	/***
	 *@description getCellValue Function to get Cell value from the specified Excel
	 * 
	 * @author Nitish Aggarwal
	 * 
	 * @param rowValue - double
	 * @param columnValue - String
	 * @return cellValue - String
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public String getCellValue(String rowValue,String columnValue) throws Exception{
		int rowNumber, colNumber;

        InputStream input 		= new FileInputStream(System.getProperty("user.dir") + "\\VTBDATA.xlsx");         //Input Stream

        XSSFWorkbook workbook 	= new XSSFWorkbook(input);				 	//Opening workbook
        XSSFSheet sheet 		= workbook.getSheetAt(0);				 	//Opening worksheet
        
        rowNumber 				= getRowNumber(sheet, rowValue);			//getting Row Number
        colNumber 				= getColumnNumber(sheet, columnValue);		//getting Column Number 
        
        if (rowNumber == 0 || colNumber == 0) {
			throw new Exception("Either Test Data Id: " + rowValue + " or Test Data: " + columnValue + " is not present in the Test Data sheet");
		}
        
        String cellValue 		= output(sheet, rowNumber, colNumber);		//getting Cell value
        
        workbook.close();												 	//Closing workbook
        return cellValue;
    }
	
	/***
	 *@description output Function to return Cell value according to specified Row and Column
	 * 
	 * @author Nitish Aggarwal
	 * 
	 * @param sheet	- XSSFSheet
	 * @param rowNumber - int
	 * @param colNumber - int
	 * @return variableValue - String
	 */
	private String output(XSSFSheet sheet, int rowNumber, int colNumber) {
		DataFormatter df 	 	= 	new DataFormatter();
		XSSFRow row 		 	= 	sheet.getRow(rowNumber);
        XSSFCell cell 		 	= 	row.getCell(colNumber);
        String variableValue 	= 	df.formatCellValue(cell);
        
        return variableValue;
    }
	
	/***
	 *@description getRowNumber Function to find Row number according to the Search value specified
	 * 
	 * @author Nitish Aggarwal
	 * 
	 * @param sheet	- XSSFSheet
	 * @param searchValue - double
	 * @return row.getRowNum() - int
	 */
	@SuppressWarnings("deprecation")
	private int getRowNumber(XSSFSheet sheet, String searchValue) {
		/***
		 * Function to find Row number according to the Search value specified
		 */		
		
		for (Row row : sheet) {
	        for (Cell cell : row) {
	            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
	                if (cell.getRichStringCellValue().getString().trim().equalsIgnoreCase(searchValue)) {
	                	return row.getRowNum();
	                }
				}
	            /*if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					if (cell.getNumericCellValue() == searchValue) {
						return row.getRowNum();
					}
				}*/
	        }
	    }
		return 0;
	}

	/***
	 *@description getColumnNumber Function to find Column number according to the Search value specified
	 * 
	 * @author Nitish Aggarwal
	 * 
	 * @param sheet	- XSSFSheet
	 * @param searchValue - String
	 * @return cell.getColumnIndex() - int
	 */
	@SuppressWarnings("deprecation")
	private int getColumnNumber(XSSFSheet sheet, String searchValue) {
		for (Row row : sheet) {
	        for (Cell cell : row) {
	            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
	                if (cell.getRichStringCellValue().getString().trim().equalsIgnoreCase(searchValue)) {
	                    return cell.getColumnIndex();
	                }
	            }
	        }
	    }
		return 0;
	}
	
	/***
	 *@description getTestCaseData Function to get Test Data of the specified row
	 * 
	 * @author Nitish Aggarwal
	 * 
	 * @param rowValue	- double
	 * @return excelData - LinkedHashMap<String, String>
	 * @throws Exception
	 */
	public LinkedHashMap<String, String> getTestCaseData(String rowValue) throws Exception{
		int rowNumber;
		String cellValue 	= 	null;
		
		LinkedHashMap <String,String> excelData	=	new LinkedHashMap<String,String>();
		
        InputStream input 	= 	new FileInputStream(System.getProperty("user.dir") + "\\TestData\\TESTDATA.xlsx");

        @SuppressWarnings("resource")
		XSSFWorkbook workbook 	= 	new XSSFWorkbook(input);				 	//Opening workbook
        XSSFSheet sheet 		= 	workbook.getSheetAt(0);				 		//Opening worksheet
        
        rowNumber 				= 	getRowNumber(sheet, rowValue);				//getting Row Number
        int noOfColumns 		= 	sheet.getRow(0).getPhysicalNumberOfCells();	//getting Column Count

        if (rowNumber == 0) {
			throw new Exception("Test Data Id: " + rowValue + " is not present in the Test Data sheet");
		}

	/*Getting Test Data along with Column Name in a LinkedHashMap*/
		for (int i = 0; i < noOfColumns; i++) {
			String columnName  	= output(sheet, 0, i);				//getting Header
			cellValue  			= output(sheet, rowNumber, i);		//getting Cell value
			excelData.put(columnName, cellValue);
		}
		
		return excelData;
	}
	
}
