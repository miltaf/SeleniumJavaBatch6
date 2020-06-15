package com.syntax.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class HomeWork extends CommonMethods {

	public static void main(String[] args) {
		
		setUp();

		WebElement username=driver.findElement(By.id("ctl00_MainContent_username"));
		sendText(username, ConfigsReader.getProperty("username"));
		
		WebElement password=driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
		sendText(password, ConfigsReader.getProperty("password"));
		
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
		String customerVerify="Susan McLaren";
		
		List<WebElement>rows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
		
		for (int info=0; info<rows.size(); info++) {
			String rowInfo=rows.get(info+1).getText();
	
			if(rowInfo.contains(customerVerify)) {
				driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[1]")).get(info).click();
				System.out.println("Susan McLaren details exist in the table " + customerVerify);
				break;
			}
		
	}

}
}
