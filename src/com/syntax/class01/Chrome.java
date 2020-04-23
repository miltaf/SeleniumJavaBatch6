package com.syntax.class01;

public class Chrome {

		public static class SetDriver {
		public static void chromeDriver() {
			System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
		}
		public static void fireFoxDriver() {
			System.setProperty("webdriver.gecko.driver", "Driver\\geckodriver.exe");
		}
	}

		public static String getTitle() {
			// TODO Auto-generated method stub
			return null;
		}

		public static void close() {
			// TODO Auto-generated method stub
			
		}
}
