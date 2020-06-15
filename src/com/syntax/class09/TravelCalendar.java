package com.syntax.class09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;

import com.syntax.utils.BaseClass;

public class TravelCalendar{

	/* 
	 * TC 1: Calendar headers and rows verification Open chorme browser Go to 
	 * "https://www.aa.com/homePage.do" Enter from and To Select departure as July
	 * 14 of 2020 select arrival as November 8 of 2020 Close browser
	 */
	public static void main(String[] args) throws InterruptedException {
		
		// Open chrome browser Go to "https://www.aa.com/homePage.do"
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.aa.com/homePage.do");
		driver.manage().window().maximize();


		//click on the depart of Calendar
		
		driver.findElement(By.id("reservationFlightSearchForm.originAirport")).clear();
		driver.findElement(By.id("reservationFlightSearchForm.originAirport")).sendKeys("IAD", Keys.TAB);
		//enum - it is similar to a class, but it has only static 
		driver.findElement(By.xpath("//input[@name='destinationAirport']")).sendKeys("KBL");
		
		WebElement passengers=driver.findElement(By.id("flightSearchForm.adultOrSeniorPassengerCount"));
		Select select = new Select(passengers);
		
		List<WebElement>options=select.getOptions();
		for (int i=1; i<options.size();i++) {
			select.selectByVisibleText("6");
			Thread.sleep(1000);
			
			//driver.findElement(By.xpath("//input[@id='flightSearchForm.button.reSubmit']")).click();
			//driver.findElement(By.xpath("//button[@class='ui-datepicker-trigger']")).click();")).click();
		
			String dMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			while (!dMonth.equals("May")) {
				driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")).click();
				Thread.sleep(2000);
				dMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			}
							List<WebElement> departCells = driver.findElements(By.xpath("//table/tbody/tr/td"));
			// loop through td of depart calendar and grab the text and validate
			for (WebElement departCell : departCells) {
				String departText=departCell.getText();
				if(departText.equals("14")) {
					departCell.click();
					break;
				}
			}
			driver.findElement(By.xpath("//input[@id='aa-returningFrom']")).click();
			Thread.sleep(1000);
			String returnMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			while(!returnMonth.equals("November")) {
				driver.findElement(By.xpath("//a[@title='Next']")).click();
				Thread.sleep(1000);
				returnMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			}
			List<WebElement> retCells = driver.findElements(By.xpath("//table/tbody/tr/td"));
			// loop
			for (WebElement Cell : retCells) {
				String retText=Cell.getText();
				if(retText.equals("8")) {
					Cell.click();
					break;
				}
			}
			driver.findElement(By.xpath("//input[@id='flightSearchForm.button.reSubmit']")).click();
			Thread.sleep(5000);
			driver.close();
		}
				
	}

		
	}

