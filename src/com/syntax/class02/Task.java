package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.linkText("Register here")).click();
		driver.findElement(By.name("firstName")).sendKeys("Mahboob");
		driver.findElement(By.name("lastName")).sendKeys("Iltaf");
		driver.findElement(By.className("phone")).sendKeys("34589230332");
		
	}

}
