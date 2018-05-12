package parameterizationByTestNG;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;


import utilities.DataTableUsingAPOI;

public class EUsingAPOI {

	WebDriver oBrowser=null;
	
/*	@DataProvider(name="EnrollmentDataSingleSet")
	public static Object[][] dataForEnrollmentSingleSet()
	{
		return new Object[][] {{"Welcome","SingleSet"}} ;
	}
	*/
	@Before
	public void launcApp() throws MalformedURLException, InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "/Users/amulyavallamkonda/Documents/Selenium/chromedriver");
		oBrowser =new ChromeDriver();
		oBrowser.get("https://www.southwest.com");
		oBrowser.manage().window().maximize();
		oBrowser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test	//(dataProvider="EnrollmentDataSingleSet")
	public void enrollmentSingleSet()
	{
		DataTableUsingAPOI oDT = new DataTableUsingAPOI("/Users/narkandukuri/Documents/Personal/Sel/P3C1/ParaXLSX.xlsx","Data");
		oBrowser.findElement(By.linkText("Enroll")).click();
		
		oBrowser.findElement(By.id("js-customer-first-name")).clear();
		oBrowser.findElement(By.id("js-customer-first-name")).sendKeys(oDT.getCellData("Fname", 1));
		
		oBrowser.findElement(By.id("js-customer-last-name")).clear();
		oBrowser.findElement(By.id("js-customer-last-name")).sendKeys(oDT.getCellData("Lname", 1));
	}
	
	//@AfterMethod
	public void closeApp()
	{
		//oBrowser.quit();
	}

}
