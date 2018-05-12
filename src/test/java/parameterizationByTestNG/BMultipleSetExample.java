package parameterizationByTestNG;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BMultipleSetExample {

	WebDriver oBrowser=null;

	@DataProvider(name="EnrollmentDataWithMiddleName")
	public static Object[][] dataForEnrollmentTellAbout()
	{
		return new Object[][] {{"Kumar","MName","HiHru"}, {"Daneil","MName","HiHru"}} ;
	}
	
	@BeforeMethod
	public void launcApp() throws MalformedURLException, InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "/Users/amulyavallamkonda/Documents/Selenium/chromedriver");
		oBrowser =new ChromeDriver();
		oBrowser.get("https://www.southwest.com");
		oBrowser.manage().window().maximize();
		oBrowser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	

	@Test(dataProvider="EnrollmentDataWithMiddleName")
	public void enrollment(String sFName, String sMName, String sLName)
	{
		oBrowser.findElement(By.linkText("Enroll")).click();
		
		oBrowser.findElement(By.id("js-customer-first-name")).clear();
		oBrowser.findElement(By.id("js-customer-first-name")).sendKeys(sFName);
		
		oBrowser.findElement(By.id("js-customer-middle-name")).clear();
		oBrowser.findElement(By.id("js-customer-middle-name")).sendKeys(sMName);
		
		oBrowser.findElement(By.id("js-customer-last-name")).clear();
		oBrowser.findElement(By.id("js-customer-last-name")).sendKeys(sLName);
	}
	
	//@AfterMethod
	public void closeApp()
	{
		//oBrowser.quit();
	}

}
