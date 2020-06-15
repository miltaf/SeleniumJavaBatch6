package com.syntax.class08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.utils.BaseClass;

public class DynamicTableAnotherWay extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		setUp();// https://the-internet.herokuapp.com/

		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();

		String expectValue = "Bob Feather";

		//List of all rows
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));

		for (int i = 1; i < rows.size(); i++) {

			String rowText=rows.get(i-1).getText();//get text of each row excluding header.
			
			if(rowText.contains(expectValue)) {//validating expected Value
				//loop through each row by providing the index in the xpath and click on it.
				driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+i+"]/td[1]")).click();;
				break;
			}	
		}

		Thread.sleep(5000);
		driver.close();

	}

}
