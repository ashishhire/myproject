package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="loginEmail")
	WebElement username;
	@FindBy(id="loginPassword")
	WebElement password;
	@FindBy(id="btnLogin")
	WebElement loginbtn;

	public WebElement getUsername()
	{
		return username;
	}

	public WebElement getPassword()
	{
		//return driver.findElement(password);
		return password;
	}

	public WebElement getLoginbtn()
	{
		return loginbtn;
	}
}
