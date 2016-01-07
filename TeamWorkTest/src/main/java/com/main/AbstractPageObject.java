package com.main;

import org.openqa.selenium.WebDriver;

abstract class AbstractPageObject {
WebDriver driver;
public AbstractPageObject(WebDriver driver) {
	this.driver = driver;
}
}
