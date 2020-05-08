package com.syntax.class05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.syntax.utils.BaseClass;

public class DropDownDemo2 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		setUp();//In properties file, uncomment demoqa.com URL (code written for demoqa.com).

		WebElement continents = driver.findElement(By.id("continents"));

		Select select = new Select(continents);

		List<WebElement> options = select.getOptions();// It will return list of all options in the DD

		for (WebElement option : options) {// loop on above options list

			String text = option.getText();
			System.out.println(text);

			if (text.equals("Africa")) {
				option.click();
				
				String ddText = option.getText();

				if (ddText.equals("Africa")) {
					System.out.println("Africa is selected:: " + option.isSelected());
				} else {
					System.err.println("Africa is NOT selected");
				}
			}
			
			
			// select.selectByVisibleText("Antarctica");//You can select by Visible test.

		}

		boolean isMultiple = select.isMultiple();//isMultiple(); shows if the DD is multi select or not.
		
		System.out.println("The Continent DD is Multiple:: " + isMultiple);

		tearDown();

	}

}
