package excelUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	static String projectpath;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	
	/*
	public static void main(String[] args) {
		ExcelDataProvider("C:\\Users\\CHANDRASEKHARJANGA\\git\\SeleniumPOC\\SeleniumMavenFrameworkWithJava\\src\\test\\java\\excelUtils\\LoginData.xlsx", "LoginData.xlsx", "sheet1");
	}
	*/
	
	public ExcelDataProvider()
	{
		String projectpath = System.getProperty("user.dir"); 
		File src = new File(projectpath+"/excelUtils/LoginData.xlsx");
		//File src = new File("C:\\Users\\CHANDRASEKHARJANGA\\git\\SeleniumPOC\\SeleniumMavenFrameworkWithJava\\src\\test\\java\\excelUtils\\LoginData.xlsx");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);			
		} catch (Exception e) {
			System.out.println("Unable to read data from excel.."+e.getMessage());
		} 
		
	}
	
	public String getStringData(String sheetName, int rownum, int colnum)
	{
		return wb.getSheet(sheetName).getRow(rownum).getCell(colnum).getStringCellValue();
		
	}
	
	public double getNumericData(String sheetName, int rownum, int colnum)
	{
		return wb.getSheet(sheetName).getRow(rownum).getCell(colnum).getNumericCellValue();
		
	}
	
	
	
	/*
	public static void ExcelDataProvider(String excelpath, String excelname, String sheetname)
	{
		projectpath = System.getProperty("user.dir");
		
		try {
			workbook = new XSSFWorkbook(excelpath);
			sheet = workbook.getSheet(sheetname);
			XSSFCell username = sheet.getRow(1).getCell(0);
			XSSFCell password = sheet.getRow(1).getCell(1);
			System.out.println("The user name and password are ..."+username+" and "+password);
			
			//String cellData = sheet.getRow(1).getCell(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	*/

}
