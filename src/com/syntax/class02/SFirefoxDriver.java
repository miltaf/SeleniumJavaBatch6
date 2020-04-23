package com.syntax.class02;

public class SFirefoxDriver implements SWebDriver{
	
	public SFirefoxDriver() {

		System.err.println("Opening Firefox browser...");
	}

	@Override
	public void get(String url) {
		System.out.println("Lunching url ::"+url);
		
	}

	@Override
	public void getCurrentUrl() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getTitle() {
		// TODO Auto-generated method stub
		
	}

}
