package parameterizationByTestNG;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DDataFromTestNGXML {

	WebDriver oBrowser=null;
	
	@BeforeMethod
	public void launcApp() throws MalformedURLException, InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "/Users/amulyavallamkonda/Documents/Selenium/chromedriver");
		oBrowser =new ChromeDriver();
		oBrowser.get("https://www.southwest.com");
		oBrowser.manage().window().maximize();
		oBrowser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	

	//1.Define  parameters in testng.xml
	//2.Use @Parameter annotation with the parameter names
	//3. method should contain the input parameters
	//4. use above parameters in the script
	
	@Parameters({"FirstName","LastName"})
	@Test
	public void enrollment123(String sFName, String sLName)
	{
		System.out.println(sFName);
		System.out.println(sLName);
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