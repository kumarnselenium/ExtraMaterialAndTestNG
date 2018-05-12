package demo;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EnrollmentWithTestNGDataProvider {

	WebDriver oBrowser=null;
	
	@DataProvider(name="EnrollmentData")
	public static Object[][] dataForEnrollment()
	{
		return new Object[][] {{"Kumar","H2K"}, {"Daneil","H2K"}} ;
	}
	
	@DataProvider(name="EnrollmentDataTellAbout")
	public static Object[][] dataForEnrollmentTellAbout()
	{
		return new Object[][] {{"Kumar","mname","H2K"}, {"Daneil","mname","H2K"}} ;
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
	
	//1.Define  parameters in DataProvider annotation
	//2.Use @Test(dataProvider="<dataProvider name>") annotation 
	//3. method should contain the input parameters
	//4. use above parameters in the script

	
	@Test(dataProvider="EnrollmentData")
	public void enrollment(String sFName, String sLName)
	{
		oBrowser.findElement(By.linkText("Enroll")).click();
		
		oBrowser.findElement(By.id("js-customer-first-name")).clear();
		oBrowser.findElement(By.id("js-customer-first-name")).sendKeys(sFName);
		
		oBrowser.findElement(By.id("js-customer-last-name")).clear();
		oBrowser.findElement(By.id("js-customer-last-name")).sendKeys(sLName);
	}
	

	@Test(dataProvider="EnrollmentDataTellAbout")
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