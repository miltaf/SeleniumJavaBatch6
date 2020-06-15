package com.syntax.SeleniumReview;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class Home {

	public static void main(String[] args) {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://166.62.36.207/syntaxpractice/table-search-filter-demo.html");

		
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id=task-table']/tbody/tr"));
		System.out.println("Number of Rows:: "+rows.size());
		
		System.out.println("----------Row Data----------");
		Iterator<WebElement> it = rows.iterator();
		
		while(it.hasNext()) {
			String rowText=it.next().getText();
			System.out.println(rowText);
		}
		
		List<WebElement>cols = driver.findElements(By.xpath("//table[@id=task-table']/tbody/tr/th"));
		System.out.println("Number of Columns:: "+cols.size());
		
		for (WebElement col : cols) {
			String rowText = col.getText();
			System.out.println(rowText);
		}
		

			}

}
