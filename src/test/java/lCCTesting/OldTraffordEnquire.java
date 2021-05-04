package lCCTesting;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;

import dataProviders.FileReaderManager;
import dataProviders.PageObjectManager;

public class OldTraffordEnquire extends BaseClass{
public  static WebDriver driver;
	
	@BeforeClass
	public  void setUp() throws Exception{
		String browserName = FileReaderManager.getInstance().getCRInstance().getData("BrowserName");
		driver = BaseClass.getBrowser(browserName);
	}
	
	@Test
    public void launch_the_lancashirecc_applicatin() throws Throwable {	 
		PageObjectManager pag = new PageObjectManager(driver);
		 driver.get(FileReaderManager.getInstance().getCRInstance().getData("LCCURL"));
		 ClickElement(pag.getEmirate().getEventsarrButton());
    	 ClickElement(pag.getEmirate().getEventsEnqButon());

    	 String EnqTitle= driver.getTitle();
     	Assert.assertEquals(EnqTitle, "Booking a venue in Manchester | Lancashire County Cricket Club");
		 
		 
    }

	@AfterClass
	  public void afterClass() {
		  driver.quit();
	  }
	
	
	
}
