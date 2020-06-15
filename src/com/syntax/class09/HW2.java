package com.syntax.class09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class HW2 extends BaseClass{

	/* 
	 * TC 2: Delete Employee 
	 * Open chrome browser Go to
	 * “http://166.62.36.207/humanresources/symfony/web/index.php/auth” 
	 * Login into the application 
	 * Add Employee 
	 * Verify Employee has been added 
	 * Go to Employee List 
	 * Delete added Employee Quit the browser
	 */

	public static void main(String[] args) throws InterruptedException {

		setUp();
		
		//Login to HRMS application
		driver.findElement(By.id("txtUsername")).sendKeys(ConfigsReader.getProperty("username"));
		driver.findElement(By.id("txtPassword")).sendKeys(ConfigsReader.getProperty("password"));
		driver.findElement(By.id("btnLogin")).click();
		
		//Navigate to add Employee page
		WebElement pimLink=CommonMethods.waitForClickability(driver.findElement(By.linkText("PIM")));
		pimLink.click();
		driver.findElement(By.linkText("Add Employee")).click();
		
		//Add an Employee
		String firstName="Mahbub";
		String lastName="Iltaf";
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		
		//grab the employee ID. for later use
		String empID=driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();
		
		String empDitails=driver.findElement(By.id("profile-pic")).getText();
		
		if(empDitails.equals(firstName+" "+lastName)) {
			System.out.println("Employee was successfully added");
		}else {
			System.err.println("Employee was NOT added");
		}
		
		//navigate to employee list
		driver.findElement(By.linkText("Employee List")).click();
		
		//define flag variable
		boolean found=false;
		
		while(!found) {
			List<WebElement> rows=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
			for (int i = 1; i < rows.size(); i++) {
				String rowText=rows.get(i-1).getText();
				if(rowText.contains(empID)) {
					found=true;
					//delete the employee
					driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[1]")).click();
					Thread.sleep(4000);
					driver.findElement(By.id("btnDelete")).click();
					Thread.sleep(5000);
					driver.findElement(By.id("dialogDeleteBtn")).click();
					break;
				}	
			}
			//if employee id is not found, click next button
			driver.findElement(By.xpath("//a[text()='Next']")).click();
			
		}
		Thread.sleep(5000);
		tearDown();
		
	}

}
