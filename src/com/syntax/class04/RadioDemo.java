package com.syntax.class04;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioDemo {

	public static String url = "https://demoqa.com/automation-practice-form/";

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		WebElement maleRadioB = driver.findElement(By.xpath("//input[@id='sex-0']"));

		System.out.println(maleRadioB.getAttribute("class"));

		System.out.println(maleRadioB.isDisplayed());// true
		System.out.println(maleRadioB.isEnabled());// true
		System.out.println("Radio Btn is Selected:: " + maleRadioB.isSelected());// false
		System.out.println("**********");

		// first way to click on a Radio Button
		maleRadioB.click();
		System.out.println("Radio Btn is Selected:: " + maleRadioB.isSelected());// true

		// second way to click on Radio buttons
		List<WebElement> proList = driver.findElements(By.xpath("//input[@name='profession']"));

		int listSize = proList.size();
		System.out.println("Size of CheckBoxes are:: " + listSize);

		String valueToBeSelected = "Manual Tester";
		// driver.findElement(By.xpath("//input[@id='sex-0']")).getAttribute("value");
		for (WebElement profession : proList) {

			if (profession.isEnabled()) {// Checking is the check-box is enabled

				String value = profession.getAttribute("value");// get value of value attribute and returns string object

				System.out.println(value);

				if (value.equals(valueToBeSelected)) {
					profession.click();
					break;
				}

			}
		}

	}

}
