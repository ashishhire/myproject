package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingListingPage {

	WebDriver driver;
	public BookingListingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='branding']")
	WebElement contenttitle;
	public WebElement getContenttitle() {
		return contenttitle;
	}



}
