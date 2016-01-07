package com.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory{
static public WebDriver newWebDriver(BrowserType browser)throws Exception{
	if(browser==BrowserType.FireFox){
		return new FirefoxDriver();
	}
	
	if(BrowserType.Chrom==browser){
		System.setProperty("webdriver.chrome.driver", "/home/developer/yehuda/chromdriver/chromedriver");
		
		return new ChromeDriver();
	}
	throw new Exception();
}
}
