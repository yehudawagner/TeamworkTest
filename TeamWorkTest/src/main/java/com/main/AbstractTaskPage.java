package com.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AbstractTaskPage extends AbstractTeamWorkPage{

	public AbstractTaskPage(WebDriver driver) {
		super(driver);
	}
	public Boolean verifyExist(String list_name) {
		return !driver.findElements(By.xpath("//a[@title='vovavov']")).isEmpty();
	}

}
