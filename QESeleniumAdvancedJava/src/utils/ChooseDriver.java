package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ChooseDriver {

	public static WebDriver Use(String browser) {
		if (browser.equalsIgnoreCase("c")) {
			System.setProperty("webdriver.chrome.driver", "src\\Drivers\\chromedriver.exe");
			return new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "src\\Drivers\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}

		else if (browser.equalsIgnoreCase("f")) {
			// System.setProperty(key, value)
			return new FirefoxDriver();
		} else {
			System.out.println("Invalid browser");
			return null;

		}

	}

}
