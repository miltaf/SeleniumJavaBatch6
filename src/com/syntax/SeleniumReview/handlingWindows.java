package com.syntax.SeleniumReview;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handlingWindows {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.seleniumframework.com/Practiceform/");
		WebElement newBrowserTabButton = driver.findElement(By.xpath("//button[text() = 'New Browser Tab']"));
		newBrowserTabButton.click();
		String parentWindow = driver.getWindowHandle(); // --> getting parent window ID 
		System.out.println(parentWindow);
		Thread.sleep(2000);
		driver.close();
		//getting all the window handles
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> it = allWindows.iterator(); //--> iterating through the windows
		
		while(it.hasNext()) { // --> checking if there is any other window handle coming up
			String childWindow = it.next();
			if(!parentWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
			}
		}
		WebElement header = driver.findElement(By.xpath("//strong[contains(text(), 'Agile Testing')]"));
		String headerText = header.getText();
		System.out.println(headerText);
		
	}

}
