package com.syntax.class05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.syntax.utils.BaseClass;

public class DropDownDemo extends BaseClass{

	public static void main(String[] args) throws InterruptedException {

		setUp();
		WebElement weekDD=driver.findElement(By.id("select-demo"));
		
		Select select=new Select(weekDD);
		
		/*
		 * Selenium provides three different ways to select a value from a DD.
		 * 1. byIndex();
		 */
		List<WebElement>options=select.getOptions();
		System.out.println("Number of options in the DropDown ::: "+options.size());
		select.selectByIndex(3);
		
		
		for (int i=1; i<options.size();i++) {
			select.deselectByIndex(i);
			Thread.sleep(1000);
		}
		
		select.selectByVisibleText("Friday");
		
		Thread.sleep(3000);
		tearDown();
	}

}
