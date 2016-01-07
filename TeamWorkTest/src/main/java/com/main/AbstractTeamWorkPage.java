package com.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AbstractTeamWorkPage extends AbstractPageObject {

	By tasks_btn = By.xpath("//a[text()='Tasks']");
	By mileston_btn = By.xpath("//a[text()='Milestones']");

	public AbstractTeamWorkPage(WebDriver driver) {
		super(driver);
	}

	public TasksPage clickTasksBtn() {
		driver.findElement(tasks_btn).click();
		return new TasksPage(driver);
	}

	public MilestonesPage clickMilestonesBtn() {
		driver.findElement(mileston_btn).click();
		return new MilestonesPage(driver);
	}
}
