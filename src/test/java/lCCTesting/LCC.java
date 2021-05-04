package lCCTesting;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import dataProviders.FileReaderManager;
import dataProviders.PageObjectManager;

import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LCC extends BaseClass{
	public  WebDriver driver;
	
	@BeforeClass
	public  void setUp() throws Exception{
		String browserName = FileReaderManager.getInstance().getCRInstance().getData("BrowserName");
		driver = BaseClass.getBrowser(browserName);
	}

  @Test
  public void LCC() throws Exception {
	  PageObjectManager pag = new PageObjectManager(driver);
	  driver.get(FileReaderManager.getInstance().getCRInstance().getData("LCCURL"));
	  pag.getLancashirecricketPage().getCricketarrowbutton().click();
	  MoveToElement(pag.getLancashirecricketPage().getFixtuResultsbut());
	  
	  ClickElement(pag.getLancashirecricketPage().getFixtuResultfirst());
	  for(int i=1;i<=5;i++) {
  		driver.navigate().to(driver.getCurrentUrl());
  		Thread.sleep(10000);
  	}
  	String LCCPag= pag.getLancashirecricketPage().getFixtuResultsbut().getText();
  	System.out.println(LCCPag);
  	
  	Assert.assertEquals(LCCPag, "Fixtures & Results");
  }
  
  
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}