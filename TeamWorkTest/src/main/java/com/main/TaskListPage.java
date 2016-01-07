package com.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TaskListPage extends AbstractTaskPage{

	
	
	public TaskListPage(WebDriver driver) {
		super(driver);
	}

	public AddTaskPage clickAddFirstTaskGetAddTaskPage() {
	WebElement box;
	driver.findElement(By.xpath("//button[text()='Add the first task']")).click();;
	box = driver.findElement(By.id("TaskLists"));
	return new AddTaskPage(driver, box);
}
	public Boolean verifyExsistance(String task_name){
		return !driver.findElements(By.xpath("//a[text='" + task_name + "']")).isEmpty();
	}

}


