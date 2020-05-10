package com.syntax.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class FacebookTest extends CommonMethods {

	public static void main(String[] args) {
		setUp();
		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		sendText(firstName, ConfigsReader.getProperty("firstName"));
		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		sendText(lastName, ConfigsReader.getProperty("lastName"));
		WebElement email= driver.findElement(By.xpath("//input[@name='reg_email__']"));
		sendText(email, ConfigsReader.getProperty("email"));
		WebElement password= driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		sendText(password, ConfigsReader.getProperty("password"));
		
		driver.findElement(By.id("u_0_b")).click();

	}

}
