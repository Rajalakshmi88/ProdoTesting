package lCCTesting;

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

public class LCCNews extends BaseClass {
	public  WebDriver driver;
	@BeforeClass
	public  void setUp() throws Exception{
		String browserName = FileReaderManager.getInstance().getCRInstance().getData("BrowserName");
		driver = BaseClass.getBrowser(browserName);
	}
	
	@Test
 
	  public void LCCNews() throws Exception {
		  PageObjectManager pag = new PageObjectManager(driver);
		  driver.get(FileReaderManager.getInstance().getCRInstance().getData("LCCURL"));
		  ClickElement(pag.getLancashirecricketPage().getCricketarrowbutton());
		  List <WebElement> Cislementss=	pag.getLancashirecricketPage().getNewsbutton();
	  	for(WebElement ele:Cislementss) {
		    		if(ele.getAttribute("href").equalsIgnoreCase("https://cricket.lancashirecricket.co.uk/news/")) {
		    			String  t20News =ele.getText();
		    			MoveToElement(ele);
		    			Assert.assertEquals(t20News, "News");
		    		}
	  								}
	  				try {
	  					if(!pag.getLancashirecricketPage().getMaincenterNews().getAttribute("href").equalsIgnoreCase("https://cricket.lancashirecricket.co.uk/news/2021-news/lancashire-set-for-vitality-womens-county-t20/")){
	  						ClickElement(pag.getLancashirecricketPage().getMaincenterNews());
	  					}

	  				}
	    
	  				catch(Exception e) {
	  					e.printStackTrace();
	  				}
	  		    	
						
	     
	  	}
	  
		  
	  
  

@AfterClass
public void afterClass() {
	  driver.quit();
}
}
