package demo;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondSWDTest {

	@Test
	public void example() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "/Users/narkandukuri/Downloads/chromedriver");
		ChromeDriver oCD = new ChromeDriver();
		oCD.get("https://www.yahoo.com");
		
		
		Thread.sleep(10000);
		
		System.out.println("Title of the browser: " + oCD.getTitle());
		
		oCD.quit();
	}
	
}
