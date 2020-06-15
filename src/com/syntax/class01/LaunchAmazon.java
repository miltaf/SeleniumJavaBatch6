package com.syntax.class01;

import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LaunchAmazon {

	// TC 1: Amazon Page Title Verification: 
	//Open chrome browser
	//Go to “https://www.amazon.com/”
	//Verify Title “Amazon.com: Online Shopping for Electronics, 
	//Apparel, Computers, Books, DVDs & more” is displayed

	public static void main (String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mahbub\\eclipse-workspace\\SeleniumJavaBatch6\\drivers\\chromedriver.exe");
	
		WebDriver amazon=new ChromeDriver();
		amazon.get("https://www.amazon.com");
	}		
	
}
