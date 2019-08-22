package com.jass.catalognew;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGassignment {
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
	   
	   

     @Test
     public void NewProdAug()
    {
		  // System.setProperty("webdriver.chrome.driver","C:\\Users\\mkhan\\Desktop\\JustAgile\\drivers\\chromedriver.exe");
			//driver = new ChromeDriver();
			//System.out.println("chrome browser opened");
			//driver.get("http://107.170.213.234/catalog/");
		//	System.out.println("Navigate to catalog");
			
		//driver.manage().window().maximize();
		String ExpectedText="New Products For August";
		String ActualText=driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/div/h2")).getText();
		Assert.assertEquals(ExpectedText, ActualText);
		System.out.println(ExpectedText+" Verified");
			}




@Test
public void privacy()
{
	   System.setProperty("webdriver.chrome.driver","C:\\Users\\mkhan\\Desktop\\JustAgile\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("chrome browser opened");
		driver.get("http://107.170.213.234/catalog/");
		System.out.println("Navigate to catalog");
		
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("//*[@id=\"columnLeft\"]/div[5]/div[2]/a[2]")).click();
	System.out.println("Privacy Notice");
	
	String ExpectedText="Put here your Privacy Notice information.";
	String ActualText=driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/div/div[1]")).getText();
	Assert.assertEquals(ExpectedText, ActualText);
	System.out.println(ExpectedText+" Verified");
}
}