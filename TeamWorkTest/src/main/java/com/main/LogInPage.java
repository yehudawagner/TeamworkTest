package com.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends AbstractPageObject {

	By usr_name_text_box = By.id("userLogin");
	By password_text_box = By.id("password");
	By login_btn = By.id("ordLoginSubmitBtn");

	public LogInPage(WebDriver driver) {
		super(driver);
	}
	
	public void clearUsrNameTextBox(){
		driver.findElement(usr_name_text_box).clear();
	}
	
	public void typeToUsrNameTextBox(String name){
		driver.findElement(usr_name_text_box).sendKeys(name);
	}
	
	public void typeToPasswordTextBox(String name){
		driver.findElement(password_text_box).sendKeys(name);
	}
	
	public OverViewPage submitLogin(){
		driver.findElement(login_btn).submit();
		return new OverViewPage(driver);
	}	
}
