package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		prop=new Properties();
		String proppath=System.getProperty("user.dir")+"//src//main//java//resources//data.properties";
		FileInputStream fis=new FileInputStream(proppath);
		prop.load(fis);
		String browser=prop.getProperty("browser");
		if (browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	public String takeScreenShot(String testName, WebDriver driver) throws IOException {
		File SourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination= System.getProperty("user.dir")+"//screenshots//"+testName+".png";
		FileUtils.copyFile(SourceFile, new File(destination));
		return destination;
	}

}
