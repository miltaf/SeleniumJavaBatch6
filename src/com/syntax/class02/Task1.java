package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("http://newtours.demoaut.com/");
		
		driver.findElement(By.linkText("Register here")).click();
		
		driver.findElement(By.name("firstName")).sendKeys("Sarmed");
		
		driver.findElement(By.name("lastName")).sendKeys("Halabi");
		
		driver.findElement(By.name("phone")).sendKeys("34534543");
		
		driver.findElement(By.id("userName")).sendKeys("sohil@gmail.com");
		
		driver.findElement(By.name("address1")).sendKeys("2345 Gleb Road");
		
		driver.findElement(By.name("postalCode")).sendKeys("65322");
			
	}

}
