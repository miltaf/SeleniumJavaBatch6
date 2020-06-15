package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class FileUploadDemo {

	public static void main(String[] args) throws InterruptedException {

		//Path of the file to upload
		String filePath="/Users/Mahbub/Desktop/Untitled.png";
		
		//open browser and navigate to the-internet.herokuapp.com
		String url = "https://the-internet.herokuapp.com/";
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mahbub\\eclipse-workspace\\SeleniumJavaBatch6\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		//click on File Upload link
		driver.findElement(By.linkText("File Upload")).click();
		
		
		//We simply use sendkeys() method to upload the file.
		//locate the choose element and send() path of file to it.
		driver.findElement(By.id("file-upload")).sendKeys(filePath);
		
		//click on upload button
		driver.findElement(By.id("file-submit")).click();
		Thread.sleep(3000);
		
		driver.quit();
		
		
	}

}
