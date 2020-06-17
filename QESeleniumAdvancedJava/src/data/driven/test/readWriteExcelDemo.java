package data.driven.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.setupDriver;

public class readWriteExcelDemo {

	WebDriver driver;

	FileInputStream FRead;
	FileOutputStream FWrite;

	XSSFWorkbook wb;
	XSSFSheet sh;

	String d1, d2;

	String login;
	String pwd;
	String wbmsg;
	String xlmsg;
	String pass = "Test is Passed";
	String fail = "Test is Failed";

	@BeforeTest
	public void beforeTest() throws Exception, Exception {

		driver = setupDriver.createDriver();

		/* File */ FRead = new FileInputStream("resources\\LoginDetails.xlsx");

		/* XSSFWorkbook */ wb = new XSSFWorkbook(FRead);

		/* XSSFSheet */ sh = wb.getSheetAt(0);
		// XSSFSheet sh= wb.getSheet("Login");

		/* String */ d1 = sh.getRow(0).getCell(0).getStringCellValue();
		/* String */ d2 = sh.getRow(0).getCell(1).getStringCellValue();

	}

	@BeforeMethod
	public void beforeMethod() {
		login = sh.getRow(1).getCell(0).getStringCellValue();
		pwd = sh.getRow(1).getCell(1).getStringCellValue();
		xlmsg = sh.getRow(1).getCell(2).getStringCellValue();
	}

	@Test
	public void ReadWrite() throws InterruptedException {
		/*
		 * driver.get("http://professional.demo.orangehrmlive.com/");
		 * 
		 * driver.findElement(By.id("txtUsername")).sendKeys(login);
		 * driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		 * driver.findElement(By.id("btnLogin")).click(); Thread.sleep(2000);
		 * wbmsg=driver.findElement(By.id("welcome")).getText();
		 */
		driver.get("http://demowebshop.tricentis.com");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(500);
		driver.findElement(By.id("Email")).sendKeys(login);
		driver.findElement(By.id("Password")).sendKeys(pwd);
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		Thread.sleep(1000);
		wbmsg = driver.findElement(By.cssSelector("a.account")).getText();
		System.out.println(wbmsg);

		System.out.println(" ");
		System.out.println(" ");

		System.out.println("Login id used is " + login);
		System.out.println("Password used is " + pwd);
		System.out.println("The user name is " + wbmsg);

	}

	@AfterMethod
	public void afterMethod() throws Exception {
		/*
		 * driver.findElement(By.id("welcome")).click(); Thread.sleep(200);
		 * driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/ul/li[2]/a")).
		 * click();
		 */
		driver.findElement(By.linkText("Log out")).click();
		Thread.sleep(1000);
		// FileOutputStream FWrite;

		FWrite = new FileOutputStream("resources\\LoginDetails.xlsx");
		sh.getRow(1).createCell(3).setCellValue(wbmsg);

		// Assert.assertEquals(xlmsg, wbmsg);
		if (wbmsg.equals(xlmsg)) {
			System.out.println(pass);
			sh.getRow(1).createCell(4).setCellValue(pass);
		} else {
			System.out.println(fail);
			sh.getRow(1).createCell(4).setCellValue(fail);
		}
		wb.write(FWrite);
	}

	@AfterTest
	public void afterTest() throws Exception {
		Thread.sleep(2000);
		driver.close();
		wb.close();

	}

}
