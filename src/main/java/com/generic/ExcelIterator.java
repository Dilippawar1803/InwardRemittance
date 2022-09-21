package com.generic; 
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * @ScriptName    : ExcelIterator
 * @Description   : This class is used to iterate excel file data
 * @Author        :  SDET Developer
 */
public class ExcelIterator 
{
	private String flFile;
	private int intSheetNumber;
	private int intIndex = 0;
	private int intNoOfRow;
	private int intNoOfColumn;
	private XSSFSheet sheet;
	private XSSFWorkbook workbook;
	private FileInputStream excelFileIS;

	public ExcelIterator(String strExcelFile, int intSheetno, boolean ignoreHeaderRow)
	{
		flFile = strExcelFile;
		intSheetNumber = intSheetno;
		try
		{
			excelFileIS = new FileInputStream(flFile);
			//workbook = new XSSFWorkbook(new File(flFile));
			workbook = new XSSFWorkbook(excelFileIS);
			excelFileIS.close();
			if(intSheetno >=0){
				sheet = workbook.getSheetAt(intSheetNumber);
				intNoOfRow = sheet.getPhysicalNumberOfRows();
				if(ignoreHeaderRow)
					intIndex++;
			}
			sheet = workbook.getSheetAt(intSheetNumber);
			intNoOfRow = sheet.getPhysicalNumberOfRows();
			if(ignoreHeaderRow)
				intIndex++;
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		} 
	}

	public boolean verifySheetName(String sSheetName){
		boolean bResult = false;
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			if(workbook.getSheetName(i).trim().equalsIgnoreCase(sSheetName)){
				bResult=true;
				break;
			}
		}
		return bResult;
	}
	
	public boolean isDone() 
	{
		if(intIndex < intNoOfRow) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	public String getColumn(int clmNo)
	{
		String strCellvalue = "";
		org.apache.poi.ss.usermodel.Row row = null;
		org.apache.poi.ss.usermodel.Cell cell = null;
		row = sheet.getRow(intIndex);
		intNoOfColumn = row.getPhysicalNumberOfCells();
		try
		{
			cell = row.getCell(clmNo, Row.RETURN_BLANK_AS_NULL);
			if (cell == null)
				strCellvalue = "";
			else 
				strCellvalue = cell.toString().trim();
			strCellvalue = cell.toString();
			return strCellvalue;
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return strCellvalue;
	}

	/**method did not work if ignoreHeaderRow = true */
	public String getColumn(String columnHeader)
	{
		org.apache.poi.ss.usermodel.Row headerRow = sheet.getRow(0);
		org.apache.poi.ss.usermodel.Row testDataRow = sheet.getRow(this.getCurrentRowNumber());
		int clmNo = 0;
		String cellValue = "";
		try
		{
			do
			{
				String currentHeader = "";
				org.apache.poi.ss.usermodel.Cell headerCell = headerRow.getCell(clmNo, Row.RETURN_BLANK_AS_NULL);
				if (headerCell == null)
					currentHeader = "";
				else 
					currentHeader = headerCell.toString().trim();
				if(currentHeader.equalsIgnoreCase(columnHeader))
				{
					org.apache.poi.ss.usermodel.Cell testDataCell = testDataRow.getCell(clmNo, Row.RETURN_BLANK_AS_NULL);

					if (testDataCell == null)
						cellValue = "";
					else 
						cellValue = testDataCell.toString().trim();
				}
				clmNo++;
			}
			while(clmNo < headerRow.getLastCellNum());
		}
		catch(Exception exception)
		{
		}
		return cellValue;
	}

	public void next()
	{
		intIndex++;
	}

	public int getCurrentRowNumber()
	{
		return intIndex;
	}

	public int getNumberOfRows()
	{
		return intNoOfRow; 
	}

	public int getNumberOfColumnForCurrentRow()
	{
		return intNoOfColumn;
	}
	
	public String getCellValue(int iCol){
		
		DataFormatter objDataFormatter = new DataFormatter();
		org.apache.poi.ss.usermodel.Row testDataRow = sheet.getRow(intIndex);
		String cellValue = "";
		try {
			org.apache.poi.ss.usermodel.Cell testDataCell = testDataRow.getCell(iCol,Row.RETURN_BLANK_AS_NULL);
			if(testDataCell == null)
				cellValue="";
			else
				cellValue = objDataFormatter.formatCellValue(testDataCell);
				//	cellValue = testDataCell.toString().trim();
			
			
		} catch (Exception exception) {

		}
		return cellValue;
		
	}
	
	public int getColumnNo(String sColumnHeader){
		
		org.apache.poi.ss.usermodel.Row headerRow = sheet.getRow(0);
		int iCol=0;
		try {
			do {
				String currentHeader = "";
				org.apache.poi.ss.usermodel.Cell headerCell = headerRow.getCell(iCol,Row.RETURN_BLANK_AS_NULL);
				if(headerCell == null)
					currentHeader = "";
				else
					currentHeader = headerCell.toString().trim();
				System.out.println(currentHeader);
				if(currentHeader.equalsIgnoreCase(sColumnHeader))
					return iCol;
				iCol++;
			} while (iCol < headerRow.getLastCellNum());
			
		} catch (Exception exception) {

		}
		return -1;
	}
	
	public boolean checkValueInExcel(String sColumnName,String sCellValue){
		boolean bFound = false;
		int iCol = this.getColumnNo(sColumnName);
		do {
			String sCellVal = this.getCellValue(iCol);
			System.out.println(sCellVal);
			if(sCellVal.toLowerCase().contains(sCellValue.toLowerCase())){
				bFound = true;
				break;
			}
			this.next();
		} while (intIndex < this.getNumberOfRows());
		return bFound;
	}
	
	public String getSheetNames(){
		String Sheets = "";
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			if(i == 0){
				Sheets = workbook.getSheetName(i).trim();
			} else{
				Sheets = Sheets+"~"+workbook.getSheetName(i).trim();
			}
		}
		return Sheets;
	}
	
	public boolean verifyFooterOfExcel(String sFooter){
 
		org.apache.poi.ss.usermodel.Row headerRow = sheet.getRow(intNoOfRow-1);
		int iCol=0;
		try {
			String currentHeader = "";
			org.apache.poi.ss.usermodel.Cell headerCell = headerRow.getCell(iCol,Row.RETURN_BLANK_AS_NULL);
			if(headerCell == null)
				currentHeader = "";
			else
				currentHeader = headerCell.toString().trim();
			System.out.println(currentHeader);
				if(currentHeader.equalsIgnoreCase(sFooter))
					return true;
				else
					return false;
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		return false;
	}
	
	public boolean checkValueNotNullInExcel(String sColumnName,String sCellValue,int intTotalNoOfRecordsToVerify){
		boolean bFound = true;
		int intCounter=0;
		int iCol = this.getColumnNo(sColumnName);
		
			if(intTotalNoOfRecordsToVerify==0){
			do {
				String sCellVal = this.getCellValue(iCol);
				System.out.println(sCellVal);
				if(sCellVal.equals("")){
					bFound = false;
					break;
				}
				this.next();
			} while (intIndex < this.getNumberOfRows());
			}else {
				do {
					intCounter++;
					if(intCounter>=intTotalNoOfRecordsToVerify){
						break;
					}
					String sCellVal = this.getCellValue(iCol);
					System.out.println(sCellVal);
					if(sCellVal.equals("")){
						bFound = false;
						break;
					}
					this.next();
				} while (intIndex < this.getNumberOfRows());
			}
		return bFound;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
