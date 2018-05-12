package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstSWDTest {

	@Test
	public void example() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "/Users/amulyavallamkonda/Documents/Selenium/chromedriver");
		ChromeDriver oBrowser = new ChromeDriver();
		oBrowser.get("https://www.ebay.com");
		
		//3	Enter "Laptop" in search text box
		oBrowser.findElement(By.id("gh-ac")).clear();
		oBrowser.findElement(By.id("gh-ac")).sendKeys("laptop");
				
		//4	Click on Search button
		oBrowser.findElement(By.xpath("//input[@value='Search']")).click();

	}
	
}
