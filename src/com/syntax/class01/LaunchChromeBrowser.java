package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChromeBrowser {

	public static void main(String[] args) throws InterruptedException {
		//for Windows users. driver\\chromedriver.exe
		// Or \\Users\\miltaf\\eclipse-workspace\\SeleniumBatch6\\drivers\\chromedriver.exe
		
		//for Mac users driver/ chromedriver
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		//opening the browser by calling the constructor of ChromeDriver class and upcasting.
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com");
		String verifyTitle="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";// ensures that I am in the right page
		String verify=chorme.getTitle();
		if (verify.equalsIgnoreCase(verifyTitle)) {
			System.out.println(verifyTitle);
		}else {
			System.out.println("verification failed");
		}
		
		Thread.sleep(2000);
		driver.close(); // it will close to current browser
		//driver.quit(); // it closes all the browser that opened by Selenium
		

	}

}
