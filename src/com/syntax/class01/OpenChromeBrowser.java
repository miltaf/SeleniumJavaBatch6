package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenChromeBrowser {

	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver= new ChromeDriver();//go ahead and open chrome browser
		
		driver.get("https://www.facebook.com");
		
		String actualUrl=driver.getCurrentUrl();//This method will fetch the current url
		
		String expectedUrl="https://www.facebook.com/";//this is the expected url we created.
		
		
		if(actualUrl.equalsIgnoreCase(expectedUrl)) {
			String title=driver.getTitle();//Return the current title of web application
			System.out.println(title);
		}else {
			System.out.println("Wrong Url is returned");
		}
		
		
		driver.close();//Terminate the session/browser (it is is destroying the object above).
		
		
	}

}
