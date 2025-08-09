package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	FileInputStream fi;
	XSSFWorkbook wb;
	XSSFSheet ws;
	XSSFRow row;
	XSSFCell cell;
	String path;
	
	public ExcelUtils(String path)
	{
		this.path = path;
	}
	
	public int getRowCount(String sheet) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;				
	}

	public int getCellCount(String sheet, int rownum) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	
	public String getCellData(String sheet, int rownum, int colnum) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
		data= formatter.formatCellValue(cell);
		}		
		catch(Exception e)
		{
			data = " ";
		}
		wb.close();
		fi.close();
		return data;
			
	}
}
