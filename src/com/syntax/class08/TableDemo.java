package com.syntax.class08;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class TableDemo {

	public static void main(String[] args) {

		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://166.62.36.207/syntaxpractice/table-search-filter-demo.html");

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
		System.out.println("Number of Rows:: " + rows.size());

		System.out.println("--------Row Data-------");
		Iterator<WebElement> it = rows.iterator();

		while (it.hasNext()) {//Loop through rows while there is next element
			String rowText = it.next().getText();//go to the next element and get text of it.
			System.out.println(rowText);

		}

		List<WebElement> cols = driver.findElements(By.xpath("//table[@id='task-table']/thead/tr/th"));
		System.out.println("Number of Columns:: " + cols.size());

		System.out.println("--------Column Data-------");
		//retrieve the elements of cols list
		for (WebElement col : cols) {
			String colText=col.getText();//get text of each cell.
			System.out.println(colText);
		}

		driver.close();
	}

}
