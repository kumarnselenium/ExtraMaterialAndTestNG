package parameterizationByTestNG;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ASingleSetExample {

	WebDriver oBrowser=null;
	
	@DataProvider(name="EnrollmentDataSingleSet")
	public static Object[][] dataForEnrollmentSingleSet()
	{
		return new Object[][] {{"Welcome","SingleSet"}} ;
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
	
	@Test(dataProvider="EnrollmentDataSingleSet")
	public void enrollmentSingleSet(String sFName, String sLName)
	{
		oBrowser.findElement(By.linkText("Enroll")).click();
		
		oBrowser.findElement(By.id("js-customer-first-name")).clear();
		oBrowser.findElement(By.id("js-customer-first-name")).sendKeys(sFName);
		
		oBrowser.findElement(By.id("js-customer-last-name")).clear();
		oBrowser.findElement(By.id("js-customer-last-name")).sendKeys(sLName);
	}
	
	//@AfterMethod
	public void closeApp()
	{
		//oBrowser.quit();
	}

}
