package com.jass.catalognew;

		import java.io.File;

		import java.io.FileInputStream;

		import java.io.IOException;

		import org.apache.poi.hssf.usermodel.HSSFWorkbook;

		import org.apache.poi.ss.usermodel.Row;

		import org.apache.poi.ss.usermodel.Sheet;

		import org.apache.poi.ss.usermodel.Workbook;

		import org.apache.poi.xssf.usermodel.XSSFWorkbook;
		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

		public class readXLFILe  {

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
		  	 
		  	    
		  	 //   @Test()
		  	 // public void NewProdAug(String  DPemail,String DPPasswd)
		     // {
		      //	 PageFactory.initElements(driver, this);
		      //	 LOGYOURSELFINLINK.click();
		      	 
		      //	PageFactory.initElements(driver, this);
		      //	EMAILPF.sendKeys(DPemail);
		      	 
		      //	PageFactory.initElements(driver, this);
		      //	passwordPF.sendKeys(DPPasswd);
		      	 
		      //	PageFactory.initElements(driver, this);
		      //	SignInPF.click();
		      	 
		      //	PageFactory.initElements(driver, this);
		      //	LOGOFFPF.click();
		      	
		      //	PageFactory.initElements(driver, this);
		      //	MyACCPF.click();
		      	
		      //	PageFactory.initElements(driver, this);
		     // 	EMAILPF.sendKeys(DPemail);
		      	 
		      //	PageFactory.initElements(driver, this);
		      //	passwordPF.sendKeys(DPPasswd);
		      	
		     // }	      	
		      	

		    public void readExcel(String filePath,String fileName,String sheetName) throws IOException{

		    //Create an object of File class to open xlsx file

		    File file =    new File(filePath+"\\"+fileName);

		    //Create an object of FileInputStream class to read excel file

		    FileInputStream inputStream = new FileInputStream(file);

		    Workbook XLFILeWorkbook = null;

		    //Find the file extension by splitting file name in substring  and getting only extension name

		    String fileExtensionName = fileName.substring(fileName.indexOf("."));

		    //Check condition if the file is xlsx file

		    if(fileExtensionName.equals(".xlsx")){

		    //If it is xlsx file then create object of XSSFWorkbook class

		    XLFILeWorkbook = new XSSFWorkbook(inputStream);

		    }

		    //Check condition if the file is xls file

		    else if(fileExtensionName.equals(".xls")){

		        //If it is xls file then create object of HSSFWorkbook class

		        XLFILeWorkbook = new HSSFWorkbook(inputStream);

		    }

		    //Read sheet inside the workbook by its name

		    Sheet XLFILeSheet = XLFILeWorkbook.getSheet(sheetName);

		    //Find number of rows in excel file

		    int rowCount =  XLFILeSheet.getLastRowNum()- XLFILeSheet.getFirstRowNum();

		    //Create a loop over all the rows of excel file to read it

		    for (int i = 0; i < rowCount+1; i++) {

		        Row row =  XLFILeSheet.getRow(i);

		        //Create a loop to print cell values in a row

		        for (int j = 0; j < row.getLastCellNum(); j++) {

		            //Print Excel data in console

		            System.out.print(row.getCell(j).getStringCellValue()+"|| ");

		        }

		        System.out.println();
		    } 

		    }  

		    //Main function is calling readExcel function to read data from excel file

		    public static void main(String...strings) throws IOException{

		    //Create an object of readXLFILe class

		    	readXLFILe objExcelFile = new readXLFILe();

		    //Prepare the path of excel file

		    String filePath = System.getProperty("user.dir")+"C:\\Users\\mkhan\\Desktop";

		    //Call read file method of the class to read data

		    objExcelFile.readExcel(filePath,"data.xlsx","readXLfileDemo");

		    }

}
		
		