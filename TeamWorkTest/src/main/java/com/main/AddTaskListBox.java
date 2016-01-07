package com.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddTaskListBox extends AbstractPageObject{

	WebElement box;
	
	By list_name_text_box = By.id("newTaskListName");
	By add_this_task_to_list_btn = By.id("btnCreateTaskList");
// id of submit btn	btnCreateTaskList
	
	public AddTaskListBox(WebDriver driver, WebElement findElement) {
		super(driver);
		this.box = findElement;
	}
	public void typeListNameToTextBox(String list_name){
		box.findElement(list_name_text_box).sendKeys(list_name);
	}
	
	public TasksPage clickAddThisTaskListBtnGetTasksPage() {
		box.findElement(add_this_task_to_list_btn).click();
		return new TasksPage(driver);
	}

}
