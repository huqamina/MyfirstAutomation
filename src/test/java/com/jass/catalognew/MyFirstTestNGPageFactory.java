package com.jass.catalognew;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyFirstTestNGPageFactory { 
	private WebDriver  driver;
	   @BeforeTest
	   public void openConnection() {
		   System.setProperty("webdriver.chrome.driver","C:\\Users\\mkhan\\Desktop\\JustAgile\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("chrome browser opened");
			driver.get("http://107.170.213.234/catalog/");
			System.out.println("Navigate to catalog");
			
		driver.manage().window().maximize();
			}
	   
	   @FindBy(linkText="log yourself in")
  	 private WebElement LOGYOURSELFINLINK;
	   
	   @FindBy(how=How.NAME, using="email_address")
	  	 private WebElement EMAILPF;
	   
	   @FindBy(how=How.NAME, using="password")
	  	 private WebElement passwordPF;
	   
		  @FindBy(how=How.XPATH,using ="//*[@id=\'tdb5\']/span[2]")
		  private WebElement SignInPF;
		   
	  
	    @FindBy(how=How.XPATH,using ="//*[@id=\"tdb4\"]/span")
	    private WebElement  LOGOFFPF;
	  
		 
  	    @FindBy(how=How.XPATH,using="//*[@id=\"tdb3\"]/span[2]")
  	    private WebElement MyACCPF;
  	 

     @Test(dataProvider="testdata")
     
     
     public void NewProdAug(String  DPemail,String DPPasswd)
    {
    	 PageFactory.initElements(driver, this);
    	 LOGYOURSELFINLINK.click();
    	 
    	PageFactory.initElements(driver, this);
    	EMAILPF.sendKeys(DPemail);
    	 
    	PageFactory.initElements(driver, this);
    	passwordPF.sendKeys(DPPasswd);
    	 
    	PageFactory.initElements(driver, this);
    	SignInPF.click();
    	 
    	PageFactory.initElements(driver, this);
    	LOGOFFPF.click();
    	
    	PageFactory.initElements(driver, this);
    	MyACCPF.click();
    	
    	PageFactory.initElements(driver, this);
    	EMAILPF.sendKeys(DPemail);
    	 
    	PageFactory.initElements(driver, this);
    	passwordPF.sendKeys(DPPasswd);
    	
    	
    	 
    	 
    //	 System.setProperty("webdriver.chrome.driver","C:\\Users\\mkhan\\Desktop\\JustAgile\\drivers\\chromedriver.exe");
			//driver = new ChromeDriver();
			//System.out.println("chrome browser opened");
			//driver.get("http://107.170.213.234/catalog/");
		//	System.out.println("Navigate to catalog");
			
		//driver.manage().window().maximize();
		//String ExpectedText="New Products For August";
		//String ActualText=driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/div/h2")).getText();
		//Assert.assertEquals(ExpectedText, ActualText);
		//System.out.println(ExpectedText+" Verified");
			}

@DataProvider(name = "testdata")
public Object[][] createData1(){
	return new Object[][] {
		{"ecalix@test.com","test123"},
		{"justagile@test.com","test123"}
	
	};
}
}