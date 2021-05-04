package lCCTesting;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import dataProviders.FileReaderManager;
import dataProviders.PageObjectManager;


public class BramfordNews extends BaseClass{
public  static WebDriver driver;
	
	@BeforeClass
	public  void setUp() throws Exception{
		String browserName = FileReaderManager.getInstance().getCRInstance().getData("BrowserName");
		driver = BaseClass.getBrowser(browserName);
	}
	
	@Test
    public void BramfordNewsTest() throws Throwable {
		PageObjectManager pag = new PageObjectManager(driver);
	    	driver.get(FileReaderManager.getInstance().getCRInstance().getData("BramfordURL"));
	    	ClickElement(pag.getBram().getCookie());
	    	ClickElement(pag.getBram().getNewsNav());
	    	List <WebElement> New=	pag.getBram().getNewsoption();
	    	for(WebElement elemt:New) {
	    	
		    		if(elemt.getAttribute("href").equalsIgnoreCase("https://www.bromford.co.uk/news/")) {
		    			ClickElement(elemt);
		    			break;
		    		}
		    		
	    	}
	    	String NewsTitle=driver.getTitle();
	    	Assert.assertEquals(NewsTitle, "News | Bromford");

	    	
	    	
	    }
	@AfterClass
	  public void afterClass() {
		  driver.quit();
	  }
	
}
