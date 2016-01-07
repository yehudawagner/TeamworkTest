package com.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TasksPage extends AbstractTaskPage{

	By add_task_list_btn = By.xpath("//*[text()='Add task list']/../button");
	By add_task_listbox = By.id("box1");
	
	
	public TasksPage(WebDriver driver) {
		super(driver);
	}
	
	public AddTaskListBox clickAddTaskBtnGetAddTaskListBox() {
		driver.findElement(add_task_list_btn).click();
		return new AddTaskListBox(driver, driver.findElement(add_task_listbox));
	}
	
	public TaskListPage clickTaskNameGetTaskListPage(String task_name) {
		driver.findElement(By.xpath("//a[text()='"+task_name+"']")).click();
		return new TaskListPage(driver);	
	}

}
