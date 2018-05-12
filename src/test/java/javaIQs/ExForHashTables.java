package javaIQs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExForHashTables {
	
	@Test
	public void groupOfUIObjs()
	{
		//1. Open Chrome Browser	
		System.setProperty("webdriver.chrome.driver", "/Users/narkandukuri/Downloads/chromedriver 2");
		ChromeDriver oBrowser = new ChromeDriver();
		
		oBrowser.manage().window().maximize();
		
		//2. Launch www.ebay.com	
		oBrowser.navigate().to("https://www.redflagdeals.com/");
		
		List<WebElement> uiAllDealsCompany = oBrowser.findElements(By.xpath("//h4[@class='block__title']/preceding-sibling::p"));
		List<WebElement> uiAllDeals = oBrowser.findElements(By.xpath("//h4[@class='block__title']/a"));
		int iTotalDeals = uiAllDeals.size();
		
		Hashtable<String,String> aHTStringIndex = new Hashtable<String, String>();
		Hashtable<String,String> aHTIntIndex = new Hashtable<String, String>();
		
		for(int iEachObj=0; iEachObj<iTotalDeals; iEachObj++)
		{
			aHTStringIndex.put(uiAllDealsCompany.get(iEachObj).getText() + iEachObj, uiAllDeals.get(iEachObj).getText());
			//System.out.println(aHTStringIndex.get(uiAllDealsCompany.get(iEachObj).getText() + iEachObj));
			
			aHTIntIndex.put(uiAllDealsCompany.get(iEachObj).getText() + iEachObj, uiAllDeals.get(iEachObj).getText());
			//System.out.println(aHTIntIndex.get(uiAllDealsCompany.get(iEachObj).getText() + iEachObj));
			
		}
		
		System.out.println(aHTStringIndex);
	}

	
}








