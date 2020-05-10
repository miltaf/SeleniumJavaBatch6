package com.syntax.class07;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleWindowHandle {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/signup");
		
		String singUpTitle=driver.getTitle();
		System.out.println("Main Page Title is:: "+singUpTitle);
		
		driver.findElement(By.linkText("Help")).click();
		
		/*
		 * How to get window handle?
		 * In Selenium we have two method to get the hand of window.
		 * getWindowHandle();
		 * getWindowHandles();
		 */
		
		Set<String> allWindowHandles=driver.getWindowHandles();
		//Returns set of string IDs of all windows currently opened by the current instance.
		
		System.out.println("Number of windows opened are:: "+allWindowHandles.size());//get size of set.
		
		Iterator<String> it = allWindowHandles.iterator();
		
		String mainWindowHandle = it.next();//Returns the id of Mine Window
		System.out.println("Id of Main window:: "+mainWindowHandle);
		
		String childWindowHandle=it.next();//Returns the id of Child Window
		System.out.println("Id of Child window:: "+childWindowHandle);
		
		//Using switchTo method we switch to another window by passing the handle/ID of window.
		driver.switchTo().window(childWindowHandle);
		String childWindowTitle=driver.getTitle();
		System.out.println("Child Page Title is:: "+childWindowTitle);
		driver.close();

	}

}
