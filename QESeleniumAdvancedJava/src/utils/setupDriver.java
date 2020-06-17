package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class setupDriver {

	public static WebDriver driver;
	
	public static WebDriver createDriver() {

		System.setProperty("webdriver.chrome.driver", "src\\Drivers\\chromedriver.exe");
		setupDriver.driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

}
