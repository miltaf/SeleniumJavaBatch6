package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		String url="https://jqueryui.com/droppable/";
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		//elements are inside frame, so switch to frame
		driver.switchTo().frame(0);
		
		//locate both elements to drag and drop.
		WebElement drag=driver.findElement(By.id("draggable"));
		WebElement drop=driver.findElement(By.id("droppable"));
		
		//Create of object of action class and pass the webdriver in the constructor
		Actions action=new Actions(driver);
		//drag a file and drop it in the source. Longer way
		//action.clickAndHold(drag).moveToElement(drop).release().perform();

		//use dragAndDrop() method to drag and drop elemet.
		action.dragAndDrop(drag, drop).perform();
		
		
		Thread.sleep(5000);
		driver.quit();

	}

}
