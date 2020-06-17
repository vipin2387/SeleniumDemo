package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login_PageFactory {

	WebDriver driver;

	@FindBy(how = How.ID, using = "Email")
	WebElement UName;

	@FindBy(how = How.ID, using = "Password")
	WebElement Password;

	@FindBy(how = How.CSS, using = "input[value='Log in']")
	WebElement Login_btn;

	@FindBy(how = How.CSS, using = "a.account")
	WebElement Get_name;

	@FindBy(how = How.LINK_TEXT, using = "Log out")
	WebElement LogOut;

	public void Sendkeys_input(String un, String pwd) throws Exception {

		UName.sendKeys(un);
		Password.sendKeys(pwd);
		Login_btn.click();
	}

	public String GetText_Demo() {
		String name = Get_name.getText();
		return name;
	}

	public void exit_Close() {
		LogOut.click();
		driver.close();
	}

	public Login_PageFactory(WebDriver driver) {
		this.driver = driver;
	}

}
