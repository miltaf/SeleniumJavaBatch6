package com.syntax.test;

import com.syntax.pages.LoginPage;
import com.syntax.pages.LoginPageElements;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class Task extends CommonMethods{

	public static void main(String[] args) {
		
		LoginPageElements page=new LoginPageElements();
		setUp();
		if (page.logo.isDisplayed()) {
			System.out.println("Syntax logo is displayed");
		}else {
			System.out.println("Syntax Logo is not displayed");
		}
		
		sendText(page.username, ConfigsReader.getProperty("username"));
		sendText(page.password, ConfigsReader.getProperty("password"));
		click(page.loginBtn);
		
	
		wait(3);
		tearDown();
	}

}
