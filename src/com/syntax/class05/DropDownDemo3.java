package com.syntax.class05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.syntax.utils.BaseClass;

public class DropDownDemo3 extends BaseClass{

	public static void main(String[] args) {

		ArrayList<String> expectedList=new ArrayList<>();//store all expected values in your list
		expectedList.add("Asia");
		expectedList.add("Europe");
		expectedList.add("Africa");
		expectedList.add("Australia");
		
		
		setUp();//In properties file, uncomment demoqa.com URL (code written for demoqa.com).
		
		WebElement continents=driver.findElement(By.id("continents"));
		
		Select select=new Select(continents);
		
		select.selectByValue("AUS");//AUS is the value of Value attribute in the DOM
		
		List<WebElement> optionList=select.getOptions();//returns list of all options
		
	
		
		Iterator <WebElement> it=optionList.iterator();//Storing it in Iterator
		
		while(it.hasNext()) {//If there is next value, get the text of it
			String text=it.next().getText();
			System.out.println(text);
		}
		
		
		if(expectedList.contains(optionList)) {//compare both list
			System.out.println("The list matches");
		}else {
			System.err.println("List Did NOT match");
		}
		
		
		tearDown();
		
		
		
	}

}
