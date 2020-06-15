package com.syntax.SeleniumReview;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.syntax.utils.CommonMethods;

public class calendarHandling extends CommonMethods {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/");
		WebElement datePickerLink = driver.findElement(By.xpath("//a[text() = 'Datepicker']"));
		wait(2);
		datePickerLink.click();
		WebElement frame = driver.findElement(By.xpath("//iframe[@class = 'demo-frame']"));
		driver.switchTo().frame(frame);
		wait(2);
		WebElement calendar = driver.findElement(By.id("datepicker"));
		// click(calendar);
		calendar.click();

		String departMonth = "August 2020";

		
		
		// boolean flag = true;
		while (true) {
			WebElement nextButton = driver.findElement(By.xpath("//span[text() = 'Next']"));
			String monthText = driver.findElement(By.xpath("//div[@class = 'ui-datepicker-title']")).getText();
			if (!departMonth.equals(monthText)) {
				nextButton.click();
			} else {
				break;
			}
		}
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
		selectCalendarDate(dates, "10");
		driver.switchTo().defaultContent();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File pic = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pic, new File("screenshots/HRMS/calendar.png"));
		driver.quit();
		// to handle window based pop ups and upload files you can use RObot class or AutoIT
		
	}

}
