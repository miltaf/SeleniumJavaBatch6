package com.syntax.test;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableCase {

	public static void main (String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mahbub\\eclipse-workspace\\SeleniumJavaBatch6\\drivers\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("http://166.62.36.207/syntaxpractice/");
	driver.findElement(By.xpath("//a[text()='Table']")).click();
	driver.findElement(By.xpath("(//a[text()='Table Data Search'])[2]")).click();
	
	System.out.println("------rowData-------");
	
	List<WebElement>row = driver.findElements(By.xpath("//table[@id='task-table']//tr"));
	System.out.println("Number of rows webTable are: ("+row.size()+")");
	
	Iterator<WebElement>it=row.iterator();
	while (it.hasNext()) {
		String rowText=it.next().getText();
		System.out.println(rowText);
		System.out.println("_________________");
	}
	
	System.out.println("-------colData------");
	
	List<WebElement> col=driver.findElements(By.xpath("//table[@id='task-table']//th"));
	System.out.println("Number of columns in webTable are: ("+col.size()+")");
	
	for (WebElement columns:col) {
		String colText=columns.getText();
		System.out.print(colText+" || ");
	}
	Thread.sleep(2000);
	driver.close();
	
}
}
