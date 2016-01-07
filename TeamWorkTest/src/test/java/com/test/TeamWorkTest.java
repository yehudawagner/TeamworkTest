package com.test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.main.AddTaskListBox;
import com.main.AddTaskPage;
import com.main.BrowserType;
import com.main.LogInPage;
import com.main.MilestonesPage;
import com.main.OverViewPage;
import com.main.PropertiesFactory;
import com.main.TaskListPage;
import com.main.TasksPage;
import com.main.WebDriverFactory;

public class TeamWorkTest {
	WebDriver driver;
	String path_name;
	String usr_login_name;
	String usr_name;
	String password;
	String list_name;
	String task_name;
	String task_name2;
	String topq_page;
	BrowserType browser;

	@BeforeMethod
	void prepareTest() throws Exception {

		path_name = "/home/developer/teamwork.properties";
		Properties properties = PropertiesFactory.getProperties(path_name);

		usr_login_name = properties.getProperty("usr_login_name");
		usr_name = properties.getProperty("usr_name");
		password = properties.getProperty("password");
		list_name = properties.getProperty("list_name");
		task_name = properties.getProperty("task_name");
		task_name2 = properties.getProperty("task_name2");
		topq_page = properties.getProperty("topq_page");
		browser = BrowserType.convertFromString(properties.getProperty("browser")); 
			driver = WebDriverFactory.newWebDriver(browser);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


		driver.get(topq_page);

	}

	//@AfterMethod
	void closeUp() {
		driver.close();
	}

	@Test
	public void testAddTaskToTaskList() throws InterruptedException {
		LogInPage login_page = new LogInPage(driver);
		login_page.clearUsrNameTextBox();
		login_page.typeToUsrNameTextBox(usr_login_name);
		login_page.typeToPasswordTextBox(password);
		OverViewPage home_page = login_page.submitLogin();
		Thread.sleep(4000);

		TasksPage tasks_page = home_page.clickTasksBtn();
		Thread.sleep(2000);
		AddTaskListBox add_task_list_box = tasks_page.clickAddTaskBtnGetAddTaskListBox();
		Thread.sleep(2000);
		add_task_list_box.typeListNameToTextBox(list_name);
		Thread.sleep(2000);
		tasks_page = add_task_list_box.clickAddThisTaskListBtnGetTasksPage();
		Thread.sleep(3000);

		TaskListPage task_list_page = tasks_page.clickTaskNameGetTaskListPage(list_name);
		Thread.sleep(4000);
		AddTaskPage add_task_page = task_list_page.clickAddFirstTaskGetAddTaskPage();
		Thread.sleep(4000);
		add_task_page.addAndSaveTask(task_name, usr_name);
		Thread.sleep(4000);
		add_task_page.addAndSaveTask(task_name2, usr_name);

		MilestonesPage milestones_page = add_task_page.clickMilestonesBtn();
		tasks_page = milestones_page.clickTasksBtn();
		Assert.assertTrue(tasks_page.verifyExist(list_name));

		task_list_page = tasks_page.clickTaskNameGetTaskListPage(list_name);
		Assert.assertTrue(task_list_page.verifyExist(task_name));
		Assert.assertTrue(task_list_page.verifyExist(task_name2));
	}
}
