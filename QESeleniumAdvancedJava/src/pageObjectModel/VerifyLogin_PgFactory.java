package pageObjectModel;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.ChooseDriver;

public class VerifyLogin_PgFactory {

	WebDriver d;
	Properties p;
	FileInputStream fi;
	Login_PageFactory Login_demo;

	@BeforeTest
	public void BeforeMethod() throws Exception {

		fi = new FileInputStream("resources/LoginPom.properties");
		p = new Properties();

		p.load(fi);

	}

	@Test
	public void ValidLogin__fact() throws Exception {
		d = ChooseDriver.Use("c");
		d.manage().window().maximize();

		d.get(p.getProperty("url"));

		Login_demo = PageFactory.initElements(d, Login_PageFactory.class);

		Login_demo.Sendkeys_input(p.getProperty("un"), p.getProperty("pwd"));

		Thread.sleep(3000);

		Assert.assertEquals(Login_demo.GetText_Demo(), p.getProperty("un"));
		System.out.println("Test is passed");

		Login_demo.exit_Close();
	}
}

/*
 * org.openqa.selenium.support.PageFactory’
 * 
 * "Factory class can be used to make using Page Objects simpler and easier".
 * 
 * We use Page Factory pattern to initialize web elements which are defined in
 * Page Objects.
 * 
 * We should initialize page objects using initElements() method from
 * PageFactory Class
 * 
 * Page Factory will initialize every WebElement variable with a reference to a
 * corresponding element on the actual web page based on “locators” defined.
 * This is done by using @FindBy annotations.
 * 
 * improve code readability.
 * 
 */
