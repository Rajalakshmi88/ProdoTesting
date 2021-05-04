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


public class BramFordCustomerArea extends BaseClass{
public  static WebDriver driver;
	
	@BeforeClass
	public  void setUp() throws Exception{
		String browserName = FileReaderManager.getInstance().getCRInstance().getData("BrowserName");
		driver = BaseClass.getBrowser(browserName);
	}
	
	@Test
	    public void  BramFordCustomerAreaTest() throws Throwable {
		PageObjectManager pag = new PageObjectManager(driver);
	    	driver.get(FileReaderManager.getInstance().getCRInstance().getData("BramfordURL"));
	    	ClickElement(pag.getBram().getCookie());
	    	ClickElement(pag.getBram().getCustomerarea());
	    	
    		List <WebElement> Cus=	pag.getBram().getCustareaoption();
    		for(WebElement elem:Cus) {
    	
	    		if(elem.getAttribute("href").equalsIgnoreCase("https://www.bromford.co.uk/customer-area/")) {
	    			ClickElement(elem);
	    			break;
	    		}
    		}
    		String CustomerAreaT=driver.getTitle();
    		Assert.assertEquals(CustomerAreaT, "Welcome to the Bromford customer area | Bromford");
	    }
	@AfterClass
	  public void afterClass() {
		  driver.quit();
	  }
	
}
