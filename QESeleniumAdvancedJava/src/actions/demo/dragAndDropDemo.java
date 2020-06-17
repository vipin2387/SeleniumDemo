package actions.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.setupDriver;

public class dragAndDropDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = setupDriver.createDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		System.out.println(driver.getTitle());

		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));

		Actions action = new Actions(driver);
		action.clickAndHold(draggable).moveToElement(droppable).release(draggable).build().perform();
		Thread.sleep(2000);

	}

}
