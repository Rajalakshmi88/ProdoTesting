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


public class Bromford extends BaseClass{
public  static WebDriver driver;
	
	@BeforeClass
	public  void setUp() throws Exception{
		String browserName = FileReaderManager.getInstance().getCRInstance().getData("BrowserName");
		driver = BaseClass.getBrowser(browserName);
	}
	
	@Test
    public void BramfordTest() throws Throwable {
		  PageObjectManager pag = new PageObjectManager(driver);

    	driver.get(FileReaderManager.getInstance().getCRInstance().getData("BramfordURL"));
    	ClickElement(pag.getBram().getCookie());
    	ClickElement(pag.getBram().getAbtUsNav());
    	List <WebElement> Cislementss=	pag.getBram().getAbtUs();
    	for(WebElement ele:Cislementss) {
	    		if(ele.getAttribute("href").equalsIgnoreCase("https://www.bromford.co.uk/about-us/")) {
	    				ClickElement(ele);
	    				break;
	    		}
    	}
    	String AbutUsTitle=driver.getTitle();
    	Assert.assertEquals(AbutUsTitle, "We're a housing association that invests in homes and relationships so people can thrive | Bromford");
    	
    }

	@AfterClass
	  public void afterClass() {
		  driver.quit();
	  }	
    
    
	
}
