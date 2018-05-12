package demo;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

public class Enrollment {

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
	
	@Test
	public void enrollment()
	{
		oBrowser.findElement(By.linkText("Enroll")).click();
		
		oBrowser.findElement(By.id("js-customer-first-name")).clear();
		oBrowser.findElement(By.id("js-customer-first-name")).sendKeys("Kumar");
		
		oBrowser.findElement(By.id("js-customer-last-name")).clear();
		oBrowser.findElement(By.id("js-customer-last-name")).sendKeys("H2K");
	}
	
	//@AfterMethod
	public void closeApp()
	{
		oBrowser.quit();
	}
	

	
}