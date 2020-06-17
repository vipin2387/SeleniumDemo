package data.driven.test;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.setupDriver;

public class readExcelTestNG {
	
	File file;
	WebDriver driver;
	XSSFWorkbook wb;
	XSSFSheet sh;
	String d1, d2;
	
	@BeforeTest
	public void setup() throws InvalidFormatException, IOException {
		
		driver = setupDriver.createDriver();
		driver.get("http://demowebshop.tricentis.com");
		file = new File("resources\\\\LoginDetails.xlsx");
		wb = new XSSFWorkbook(file);
		sh = wb.getSheetAt(0);
		d1 = sh.getRow(0).getCell(0).getStringCellValue();
		d2 = sh.getRow(0).getCell(1).getStringCellValue();
		
	}
	
	@Test
	public void readExcel() {
		System.out.println(d1);
		System.out.println(d2);
	}
	
	@AfterTest
	public void tearDown() throws IOException {
		
		wb.close();
		driver.quit();
		
	}
	
}
