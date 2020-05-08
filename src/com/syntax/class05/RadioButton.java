package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.syntax.utils.BaseClass;

public class RadioButton extends BaseClass {

	public static void main(String[] args) {

		setUp();

		WebElement month = driver.findElement(By.id("month"));
		Select mnt = new Select(month);
		mnt.selectByVisibleText("Jan");

		WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		Select dd = new Select(day);
		dd.selectByIndex(1);

		WebElement year = driver.findElement(By.id("year"));
		Select yr = new Select(year);
		yr.selectByValue("1980");

		System.out.println(mnt.isMultiple());
		
		driver.findElement(By.id("email")).sendKeys("miltaf2020@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("somah007");
		driver.findElement(By.id("u_0_b")).click();

	}
}
