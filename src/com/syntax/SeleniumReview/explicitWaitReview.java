package com.syntax.SeleniumReview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class explicitWaitReview {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
		driver.manage().window().maximize();
		WebElement startDownloadButton = driver.findElement(By.cssSelector("button[id = 'downloadButton']"));
		startDownloadButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() = 'Complete!']")));
		WebElement completeStatus = driver.findElement(By.xpath("//div[text() = 'Complete!']"));
		String competeStatusText = completeStatus.getText();
		System.out.println(competeStatusText);
		WebElement closeButton = driver.findElement(By.xpath("//button[text() = 'Close']"));
		wait.until(ExpectedConditions.elementToBeClickable(closeButton));
		closeButton.click();
		
		
	}

}
