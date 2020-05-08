package com.syntax.hw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {
	
	public static void main(String[] args) throws InterruptedException{

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.netflix.com/browse");
		
		driver.findElement(By.id("id_userLoginId")).sendKeys("iltaf.mahboob@gmail.com");
		driver.findElement(By.id("id_password")).sendKeys("Haajar@007");
		driver.findElement(By.xpath("//button[@class='btn login-button btn-submit btn-small']")).submit();
		driver.findElement(By.xpath("//a[@class='profile-link'][@data-uia='action-select-profile+primary']")).click();
		driver.findElement(By.xpath("//a[@href='/watch/60022645?tctx=33%2C0%2C%2C%2C']")).click();
				
		
}
}