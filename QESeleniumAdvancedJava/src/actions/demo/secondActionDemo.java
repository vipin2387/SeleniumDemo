package actions.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.setupDriver;


public class secondActionDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = setupDriver.createDriver();
		driver.get("http://demowebshop.tricentis.com");
		System.out.println(driver.getTitle());
		
		WebElement search = driver.findElement(By.id("small-searchterms"));

		Actions action = new Actions(driver); 
		action.keyDown(search, Keys.SHIFT).sendKeys("computer").keyUp(Keys.SHIFT).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	
		System.out.println(driver.getTitle());
		
		if(driver.getTitle().contains("Build your own computer")) {
			System.out.println("Script passed");
		} else
			System.out.println("Script failed");
		
		driver.quit();

	}

}
