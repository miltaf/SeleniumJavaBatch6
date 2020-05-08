package com.syntax.class02;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork {
public static void main (String[] args) throws IOException {
	String filePath="C:\\Users\\Mahbub\\eclipse-workspace\\JavaBasics\\configs\\UserAccess.properties";
	FileInputStream browserInput=new FileInputStream(filePath);
	Properties prop=new Properties();
	prop.load(browserInput);
	
	System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
	
	WebDriver driver=new ChromeDriver();
	driver.get(prop.getProperty("url"));
	driver.findElement(By.id("email")).sendKeys(prop.getProperty("userName"));
	driver.findElement(By.id("pass")).sendKeys(prop.getProperty("password"));
	driver.findElement(By.id("u_0_b")).click();
		
}
}
