package data.driven.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import utils.setupDriver;

public class readExcel {

	public static void main(String[] args) throws IOException {

//		WebDriver driver = setupDriver.createDriver();
//		driver.get("http://demowebshop.tricentis.com");
//		System.out.println(driver.getTitle());
		
		FileInputStream fis = new FileInputStream("resources\\LoginDetails.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		for(Row row: sheet) {
			
			for(Cell cell : row) {
				
				System.out.print(cell.getStringCellValue()+"\t | \t");
				
			}
			System.out.println();			
		}
		
		wb.close();

	}

}
