package lCCTesting;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import dataProviders.FileReaderManager;
import dataProviders.PageObjectManager;

public class OldTafford extends BaseClass{
public  WebDriver driver;
	
	@BeforeClass
	public  void setUp() throws Exception{
		String browserName = FileReaderManager.getInstance().getCRInstance().getData("BrowserName");
		driver = BaseClass.getBrowser(browserName);
	}
	
	@Test
	public void launch_the_lancashirecricket_applicatin() throws Throwable {
		PageObjectManager pag = new PageObjectManager(driver);
		 driver.get(FileReaderManager.getInstance().getCRInstance().getData("LCCURL"));
		 ClickElement(pag.getEmirate().getEventsarrButton());
		 ClickElement(pag.getEmirate().getEventsNewButon());
   }
	
	@AfterClass
	  public void afterClass() {
		  driver.quit();
	  }
}
