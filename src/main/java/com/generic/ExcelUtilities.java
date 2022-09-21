package com.generic;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @ScriptName : ExcelUtilities
 * @Description : Excel Data Management
 * @Author :  SDET Developer
 *
 */
public class ExcelUtilities {

	private String testDataFilePath;
	private FileInputStream fileInputStream = null;
	private FileOutputStream fileOutputStream = null;
	private XSSFWorkbook xssfWorkbook = null;
	private XSSFSheet xssfSheet = null;
	private XSSFRow xssfRow = null;
	private XSSFCell xssfCell = null;

	public ExcelUtilities(String testDataFilePath) {

		this.testDataFilePath = testDataFilePath;
		try {
			fileInputStream = new FileInputStream(testDataFilePath);
			xssfWorkbook = new XSSFWorkbook(fileInputStream);
			xssfSheet = xssfWorkbook.getSheetAt(0);
			fileInputStream.close();
		} catch (Exception exception) {
			System.out.println("Error Exception Message ---> " + exception.getMessage());
			exception.printStackTrace();
		}
	}
	

	public int getTotalRowCount(String strSheetName) {
		try {
			int index = xssfWorkbook.getSheetIndex(strSheetName);
			if (index == -1)
				return 0;
			else {
				xssfSheet = xssfWorkbook.getSheetAt(index);
				int number = xssfSheet.getLastRowNum() + 1;
				return number;
			}
		} catch (Exception exception) {
			System.out.println("Error Exception Message ---> " + exception.getMessage());
			exception.printStackTrace();
			return 0;
		}
	}

	public String getAllCellData(String strSheetName, String strColmnName, int intRowNum) {
		try {
			if (intRowNum <= 0)
				return "";

			int index = xssfWorkbook.getSheetIndex(strSheetName);
			int col_Num = -1;
			if (index == -1)
				return "";

			xssfSheet = xssfWorkbook.getSheetAt(index);
			xssfRow = xssfSheet.getRow(0);
			for (int i = 0; i < xssfRow.getLastCellNum(); i++) {
				// System.out.println(row.getCell(i).getStringCellValue().trim());
				if (xssfRow.getCell(i).getStringCellValue().trim().equals(strColmnName.trim()))
					col_Num = i;
			}
			if (col_Num == -1)
				return "";

			xssfSheet = xssfWorkbook.getSheetAt(index);
			xssfRow = xssfSheet.getRow(intRowNum - 1);
			if (xssfRow == null)
				return "";
			xssfCell = xssfRow.getCell(col_Num);

			if (xssfCell == null)
				return "";

			if (xssfCell.getCellType() == Cell.CELL_TYPE_STRING)
				return xssfCell.getStringCellValue();
			else if (xssfCell.getCellType() == Cell.CELL_TYPE_NUMERIC
					|| xssfCell.getCellType() == Cell.CELL_TYPE_FORMULA) {

				String cellText = String.valueOf(xssfCell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(xssfCell)) {

					double d = xssfCell.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;

				}

				return cellText;
			} else if (xssfCell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(xssfCell.getBooleanCellValue());

		} catch (Exception exception) {
			System.out.println("Error Exception Message ---> " + exception.getMessage());
			exception.printStackTrace();
			return "The row " + intRowNum + " or column " + strColmnName + " does not exist in the given excel file.";
		}
	}

	public String getTotalCellData(String strSheetName, int intColmnNum, int intRowNum) {
		
		try {
			if (intRowNum <= 0)
				return "";

			int index = xssfWorkbook.getSheetIndex(strSheetName);

			if (index == -1)
				return "";

			xssfSheet = xssfWorkbook.getSheetAt(index);
			xssfRow = xssfSheet.getRow(intRowNum - 1);
			if (xssfRow == null)
				return "";
			xssfCell = xssfRow.getCell(intColmnNum);
			if (xssfCell == null)
				return "";

			if (xssfCell.getCellType() == Cell.CELL_TYPE_STRING)
				return xssfCell.getStringCellValue();
			else if (xssfCell.getCellType() == Cell.CELL_TYPE_NUMERIC
					|| xssfCell.getCellType() == Cell.CELL_TYPE_FORMULA) {

				String cellText = String.valueOf(xssfCell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(xssfCell)) {
					double d = xssfCell.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellText;

				}

				return cellText;
			} else if (xssfCell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(xssfCell.getBooleanCellValue());
		} catch (Exception exception) {
			System.out.println("Error Exception Message ---> " + exception.getMessage());
			exception.printStackTrace();
			return "The row " + intRowNum + " or column " + intColmnNum + " does not exist  in the given excel.";
		}
	}

	public boolean setCellData(String strSheetName, String strColmnName, int intGetRowNo, int intRowNumToSetData, String strSetData) {
		
		boolean blnFlag=false;
		
		try {
			fileInputStream = new FileInputStream(testDataFilePath);
			xssfWorkbook = new XSSFWorkbook(fileInputStream);

			if (intRowNumToSetData <= 0)
				return blnFlag;

			int index = xssfWorkbook.getSheetIndex(strSheetName);
			int colNum = -1;
			if (index == -1)
				return blnFlag;

			xssfSheet = xssfWorkbook.getSheetAt(index);

			xssfRow = xssfSheet.getRow(intGetRowNo);
			for (int i = 0; i < xssfRow.getLastCellNum(); i++) {
				 System.out.println("Excel Data  : "+xssfRow.getCell(i).getStringCellValue().trim());
				if (xssfRow.getCell(i).getStringCellValue().trim().equals(strColmnName))
					colNum = i;
			}
			if (colNum == -1)
				return blnFlag;

			xssfSheet.autoSizeColumn(colNum);
			xssfRow = xssfSheet.getRow(intRowNumToSetData - 1);
			if (xssfRow == null)
				xssfRow = xssfSheet.createRow(intRowNumToSetData - 1);

			xssfCell = xssfRow.getCell(colNum);
			if (xssfCell == null)
				xssfCell = xssfRow.createCell(colNum);

			xssfCell.setCellValue(strSetData);

			fileOutputStream = new FileOutputStream(testDataFilePath);

			xssfWorkbook.write(fileOutputStream);

			fileOutputStream.close();

		} catch (Exception exception) {
			System.out.println("Error Exception Message ---> " + exception.getMessage());
			exception.printStackTrace();
			return blnFlag;
		}
		return !blnFlag;
	}

	public boolean addNewColumn(String strSheetName, String strColmnName) {
		boolean blnFlag=false;
		try {
			fileInputStream = new FileInputStream(testDataFilePath);
			xssfWorkbook = new XSSFWorkbook(fileInputStream);
			int index = xssfWorkbook.getSheetIndex(strSheetName);
			if (index == -1)
				return blnFlag;

			XSSFCellStyle style = xssfWorkbook.createCellStyle();
			style.setFillForegroundColor(HSSFColor.GREY_50_PERCENT.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

			xssfSheet = xssfWorkbook.getSheetAt(index);

			xssfRow = xssfSheet.getRow(0);
			if (xssfRow == null)
				xssfRow = xssfSheet.createRow(0);

			if (xssfRow.getLastCellNum() == -1)
				xssfCell = xssfRow.createCell(0);
			else
				xssfCell = xssfRow.createCell(xssfRow.getLastCellNum());

			xssfCell.setCellValue(strColmnName);
			xssfCell.setCellStyle(style);

			fileOutputStream = new FileOutputStream(testDataFilePath);
			xssfWorkbook.write(fileOutputStream);
			fileOutputStream.close();

		} catch (Exception exception) {
			System.out.println("Error Exception Message ---> " + exception.getMessage());
			exception.printStackTrace();
			return blnFlag;
		}

		return !blnFlag;

	}

	public boolean isSheetExistInExcel(String strSheetName) {
	
		boolean blnFlag=false;
		try {
		
			int index = xssfWorkbook.getSheetIndex(strSheetName);
			if (index == -1) {
				index = xssfWorkbook.getSheetIndex(strSheetName.toUpperCase());
				if (index == -1)
					return blnFlag;
				else
					return !blnFlag;
			} else
				return !blnFlag;
			
		} catch (Exception exception) {

			System.out.println("Error Exception Message ---> " + exception.getMessage());
			exception.printStackTrace();
			return blnFlag;
		}
	}

	
	public int getTotalColumnCount(String strSheetName) {
		
		try {
			
			if (!isSheetExistInExcel(strSheetName))
				return -1;

			xssfSheet = xssfWorkbook.getSheet(strSheetName);
			xssfRow = xssfSheet.getRow(0);

			if (xssfRow == null)
				return -1;

			return xssfRow.getLastCellNum();	
			
		} catch (Exception exception) {
			System.out.println("Error Exception Message ---> " + exception.getMessage());
			exception.printStackTrace();
			return 0;
			
		}
	}
	
	  public boolean addSheet(final String sheetname) {
	        try {
	            this.xssfWorkbook.createSheet(sheetname);
	            final FileOutputStream fileOut = new FileOutputStream(this.testDataFilePath);
	            this.xssfWorkbook.write((OutputStream)fileOut);
	            fileOut.close();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	        return true;
	    }
	    
	  public List<String> getColumnHeaderNames(String strSheetName,int intRowNum) {
		  List<String> columnHeaderNames = null;
			try {
				int headerId = 2;
				columnHeaderNames = new ArrayList<>();
				int index = xssfWorkbook.getSheetIndex(strSheetName);
				if (index == -1)
					return null;

				xssfSheet = xssfWorkbook.getSheetAt(index);
				xssfRow = xssfSheet.getRow(intRowNum - 1);
				
				if (xssfSheet.getRow(headerId) != null && xssfSheet.getRow(headerId).cellIterator() != null) {
					xssfRow = xssfSheet.getRow(headerId);

					for (int intIndex = 0; intIndex <= xssfRow.getLastCellNum(); intIndex++) {
						if (xssfRow.getCell((short) intIndex) != null && xssfRow.getCell((short) intIndex).toString().length() != 0) {
							columnHeaderNames.add(xssfRow.getCell((short) intIndex).toString());
						}
					}

				}
				return columnHeaderNames;
			} catch (Exception exception) {
				System.out.println("Error Exception Message ---> " + exception.getMessage());
				exception.printStackTrace();
				return columnHeaderNames;
			}
		}
	
	
	    
	  public String getTotalCellDataBackgroundColor(String strSheetName, int intColmnNum, int intRowNum) {
			
			try {
				if (intRowNum <= 0)
					return "";

				int index = xssfWorkbook.getSheetIndex(strSheetName);

				if (index == -1)
					return "";

				xssfSheet = xssfWorkbook.getSheetAt(index);
				xssfRow = xssfSheet.getRow(intRowNum - 1);
				if (xssfRow == null)
					return "";
				xssfCell = xssfRow.getCell(intColmnNum);
				if (xssfCell == null)
					return "";

				if (xssfCell.getCellType() == Cell.CELL_TYPE_STRING)
					return xssfCell.getStringCellValue();
				else if (xssfCell.getCellType() == Cell.CELL_TYPE_NUMERIC
						|| xssfCell.getCellType() == Cell.CELL_TYPE_FORMULA) {

					String cellText = String.valueOf(xssfCell.getNumericCellValue());
					DataFormatter dataFormatter = new DataFormatter();
					String cellValue = dataFormatter.formatCellValue(xssfCell);
					System.out.println("cellValue  new : "+cellValue);
		            CellStyle cellStyle = xssfCell.getCellStyle();
		            System.out.println("Cell Background color : "+cellStyle.getFillBackgroundColor());
		            
					if (HSSFDateUtil.isCellDateFormatted(xssfCell)) {
						double d = xssfCell.getNumericCellValue();

						Calendar cal = Calendar.getInstance();
						cal.setTime(HSSFDateUtil.getJavaDate(d));
						cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
						cellText = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellText;

					}

					
					return cellText;
				} else if (xssfCell.getCellType() == Cell.CELL_TYPE_BLANK)
					return "";
				else
					return String.valueOf(xssfCell.getBooleanCellValue());
			} catch (Exception exception) {
				System.out.println("Error Exception Message ---> " + exception.getMessage());
				exception.printStackTrace();
				return "The row " + intRowNum + " or column " + intColmnNum + " does not exist  in the given excel.";
			}
		}
	
	  private XSSFCellStyle getDisabledCellStyle() {
	        final XSSFCellStyle cellStyle = this.xssfWorkbook.createCellStyle();
	        cellStyle.setAlignment((short)2);
	        final XSSFColor myColor = new XSSFColor(Color.LIGHT_GRAY);
	        cellStyle.setFillForegroundColor(myColor);
	        cellStyle.setFillPattern((short)1);
	        return cellStyle;
	    }
	    
	    private XSSFCellStyle getEnabledCellStyle() {
	        final XSSFCellStyle cellStyle = this.xssfWorkbook.createCellStyle();
	        cellStyle.setAlignment((short)2);
	        final XSSFColor myColor = new XSSFColor(Color.GREEN);
	        cellStyle.setFillForegroundColor(myColor);
	        cellStyle.setFillPattern((short)1);
	        return cellStyle;
	    }
	
	
	 /*   private XSSFCellStyle getCellStyleBackgroudColor() {
	        final XSSFCellStyle cellStyle = xssfCell.getCellStyle();
	   //     CellStyle cellStyle = cell.getCellStyle();          
            System.out.println("color = " + getColorPattern(cellStyle.getFillForegroundColor()));

	        return cellStyle;
	    }
	
	    private short[] getColorPattern(short colorIdx){        
	        short[] triplet = null;
	        HSSFColor color = palette.getColor(colorIdx);
	        triplet = color.getTriplet();       
	        System.out.println("color : " + triplet[0] +"," + triplet[1] + "," + triplet[2]);
	        return triplet;
	    }
	*/
	
}
