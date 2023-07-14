package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectrepository.BookingListingPage;
import objectrepository.LoginPage;
import resources.Base;
import resources.ExcelReader;

public class LoginTest extends Base {

	public WebDriver driver;

	@BeforeMethod
	public void openApplication() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test(dataProvider = "getLoginData")
	public void login(String uname, String Password, String expecetd)
	{

		LoginPage loginpage=new LoginPage(driver);
		loginpage.getUsername().sendKeys(uname);
		loginpage.getPassword().sendKeys(Password);
		loginpage.getLoginbtn().click();

		BookingListingPage bookinglisting=new BookingListingPage(driver);
		String actual=null;
		System.out.println(bookinglisting.getContenttitle().getText());
		try {
		if(bookinglisting.getContenttitle().isDisplayed())
		{
			actual="success";
		}
		}
		catch (Exception e) {
			actual="failure";
		}
		AssertJUnit.assertEquals(actual, expecetd);

	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	@DataProvider
	public Object[][] getLoginData() throws IOException
	{
		ExcelReader excel=new ExcelReader();
		Object[][] exceldata=excel.excelRead();
		return exceldata;
	}
}
