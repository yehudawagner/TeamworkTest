package com.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddTaskPage extends AbstractTaskPage {

	WebElement box;
	By task_name_tb = By.xpath("//input[@placeholder='What needs to be done?' and @class = 'tt-query']");
	By Who_should_do_this = By.name("taskAssignedToUserId");
	By save_my_changes_btn = By.xpath("//input[@value='Save my changes']");

	public AddTaskPage(WebDriver driver, WebElement box) {
		super(driver);
		this.box = box;
	}

	public void typeToWhatToBeDoneTb(String name) {
		box.findElement(task_name_tb).sendKeys(name);
	}

	public void clickChooseUsrToAcount(String usrname) {
		Select select = new Select(driver.findElement(Who_should_do_this));
		try {
			select.selectByVisibleText(usrname);

		} catch (Exception e) {
			select.selectByVisibleText(usrname + " (me)");
		}
	}
	
	public AddTaskPage save_my_changes() {
		driver.findElement(save_my_changes_btn).click();
		return this;
	}
	public AddTaskPage addAndSaveTask(String task_name, String usrname) throws InterruptedException {
		typeToWhatToBeDoneTb(task_name);
		clickChooseUsrToAcount(usrname);
		save_my_changes();
		return this;
	}

}
