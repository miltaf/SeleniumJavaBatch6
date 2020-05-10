package com.syntax.class07;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://uitestpractice.com/Students/Contact");
		driver.manage().window().fullscreen();
		
		/*
		 * Implicit wait is kinda global wait and it will wait for each and every element 
		 * in your program.
		 * it waits on for element to be found, meaning it will work for findElement(); and 
		 * findElements(); methods only. as soon as its found, the remaining time will be ignored.
		 */
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		
		driver.findElement(By.linkText("This is a Ajax link")).click();
		
		String text=driver.findElement(By.className("ContactUs")).getText();
		System.out.println(text);

		
	}

}
