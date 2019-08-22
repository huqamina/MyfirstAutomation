package com.jass.catalognew;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class config {
	public static void main(String[] args) {
		 readpropertiesFile();  
	}
	public static void readpropertiesFile() {
		Properties prop = new Properties();
		
		try {
			
			
			InputStream input = new FileInputStream("C:\\Users\\mkhan\\eclipse-workspace\\catalognew\\src\\test\\java\\com\\jass\\catalognew\\config.properties");
			prop.load(input);
			System.out.println(prop.getProperty("sBrowserType"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
