package actions.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.setupDriver;

public class firstDemo {

	public static void main(String[] args) {

		WebDriver driver = setupDriver.createDriver();
		driver.get("https://lkmdemoaut.accenture.com/TestMeApp/login.htm");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("userName")).sendKeys("Lalitha");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.name("Login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='AboutUs']"))));

		Actions action = new Actions(driver); 
		action.moveToElement(driver.findElement(By.xpath("//span[text()='AboutUs']")));
		action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Our')]")));
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Chennai']"))).click().build().perform();
	
		driver.quit();
	}

}
