package com.syntax.class09;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.syntax.utils.BaseClass;

public class DeltaCalenarDemo extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		setUp();//https://www.delta.com

		// click on the depart/to calendar
		driver.findElement(By.xpath("//span[@id='calDepartLabelCont']")).click();

		//grab the month of return date and check if it equals to August
		String dMonth = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']")).getText();

		while (!dMonth.equals("August")) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			Thread.sleep(2000);
			dMonth = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']")).getText();
		}

		
		List<WebElement> departCells = driver.findElements(By.xpath("//tbody[@class='dl-datepicker-tbody-0']/tr/td"));
		// loop through td of depart calendar and grab the text and validate
		for (WebElement departCell : departCells) {
			String departText=departCell.getText();
			if(departText.equals("15")) {
				departCell.click();
				break;
			}
		}
		
		//grab the month of return date and check if it equals to October
		String returnMonth = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-1']")).getText();

		while(!returnMonth.equals("March")) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			Thread.sleep(2000);
			returnMonth=driver.findElement(By.xpath("//span[@class='dl-datepicker-month-1']")).getText();
		}
		
		List<WebElement> returnCells=driver.findElements(By.xpath("//tbody[@class='dl-datepicker-tbody-1']/tr/td"));
		//grab the text of return month and check if it equals to 9
		for (WebElement returnCell : returnCells) {
			String returnText=returnCell.getText();
			if(returnText.equals("9")) {
				returnCell.click();
				break;
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@value='done']")).click();
		Thread.sleep(5000);
		tearDown();
		
		
	}

}
