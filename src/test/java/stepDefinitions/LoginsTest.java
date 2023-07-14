package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectrepository.BookingListingPage;
import objectrepository.LoginPage;
import resources.Base;

public class LoginsTest extends Base {

	 public WebDriver driver;
	 LoginPage lp;

	 
	 @Given("^open any browser$")
	 public void open_browser() throws IOException
	 {
		 driver=initializeDriver();
	 }

	 @And("^Navigate to Login page$")
	 public void I_navigate_to_URL()
	 {
		 driver.get(prop.getProperty("url"));
	 }
     @When("^user enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	 public void I_entered_username_and_password(String uname, String pwd)
	 {
		 lp=new LoginPage(driver);
		 lp.getUsername().sendKeys(uname);
		 lp.getPassword().sendKeys(pwd);
	 }
     @And("^User clicks on submit button$")
	 public void I_clicked_on_login_button()
	 {
		 lp.getLoginbtn().click();
	 }
     @Then("^Verify user is able to login successfully$")
     public void I_should_be_able_to_login()
     {
    	 BookingListingPage blp=new BookingListingPage(driver);
    	 AssertJUnit.assertTrue(blp.getContenttitle().isDisplayed());
     }
     @After
	public void teartDown()
     {
    	 driver.quit();
     }

}
