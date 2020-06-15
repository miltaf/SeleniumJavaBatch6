package com.syntax.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.syntax.utils.CommonMethods;


public class GoogleTest extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		setUp();
		driver.findElement(By.name("q")).sendKeys("iPhone");
		
		driver.wait(3000);
		
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		driver.wait(2000);
		

		
		tearDown();

	}
}
