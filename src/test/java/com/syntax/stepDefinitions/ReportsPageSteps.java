package com.syntax.stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.syntax.pages.LoginPage;
import com.syntax.pages.OrangeHRM_homePage;
import com.syntax.pages.ReportPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.Constants;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReportsPageSteps extends BaseClass {

	LoginPage login;
	ReportPage report;
	OrangeHRM_homePage page;

	@Given("^I logged into OrangeHRM$")
	public void i_logged_into_OrangeHRM() throws Exception {
		Thread.sleep(500);
		login = new LoginPage();
		BaseClass.initProperties(Constants.filePath);
		String uName = BaseClass.prop.getProperty("username");
		String pwd = BaseClass.prop.getProperty("password");
		CommonMethods.enterValue(login.username, uName);
		CommonMethods.enterValue(login.password, pwd);
		CommonMethods.click(login.btnLogin);
	}

	@When("^I click on PIM also I click on Reports$")
	public void i_click_on_PIM_also_I_click_on_Reports() {
		page = new OrangeHRM_homePage();
		CommonMethods.click(page.clickPIM);
		CommonMethods.click(page.clickReport);
	}

	@When("^I click add$")
	public void i_click_add() {
		report = new ReportPage();
		CommonMethods.click(report.addButton);
	}

	@When("^I enter Report Name \"([^\"]*)\"$")
	public void i_enter_Report_Name(String reportName) {
		report = new ReportPage();
		CommonMethods.enterValue(report.reportName, reportName);
	}

	@When("^Select Selection Criteria to Sub Unit and Add Sub Unit$")
	public void select_Selection_Criteria_to_Sub_Unit_and_Add_Sub_Unit() throws Exception {
		report = new ReportPage();
		CommonMethods.dropDownSelect(report.selectCriteriadDropDown, "Sub Unit");
		Thread.sleep(500);
		CommonMethods.click(report.selectCriteria_addButton);
	}

	@When("^Select on SubUnit that matches one of the default employees \"([^\"]*)\"$")
	public void select_on_SubUnit_that_matches_one_of_the_default_employees(String subUnit) throws Exception {
		report = new ReportPage();
		Thread.sleep(500);
		CommonMethods.dropDownSelect(report.subUnit_dropDown, subUnit);
	}

	@When("^Select Selection Criteria to Job Title and Add Job Title$")
	public void select_Selection_Criteria_to_Job_Title_and_Add_Job_Title() throws InterruptedException {
		report = new ReportPage();
		CommonMethods.dropDownSelect(report.selectCriteriadDropDown, "Job Title");
		Thread.sleep(500);
		CommonMethods.click(report.selectCriteria_addButton);
	}

	@When("^Select the Job Title that matches the default employee \"([^\"]*)\"$")
	public void select_the_Job_Title_that_matches_the_default_employee(String jobTitle) throws Exception {
		report = new ReportPage();
		Thread.sleep(500);
		CommonMethods.dropDownSelect(report.jobTitle_dropDown, jobTitle);
	}

	@When("^Select Selection Criteria to Employee Name and Add Employee Name$")
	public void select_Selection_Criteria_to_Employee_Name_and_Add_Employee_Name() throws InterruptedException {
		report = new ReportPage();
		CommonMethods.dropDownSelect(report.selectCriteriadDropDown, "Employee Name");
		Thread.sleep(500);
		CommonMethods.click(report.selectCriteria_addButton);
	}

	@When("^Enter Employee Name that matches the default employee \"([^\"]*)\"$")
	public void enter_Employee_Name_that_matches_the_default_employee(String employeeName) throws Exception {
		report = new ReportPage();
		Thread.sleep(1000);
		CommonMethods.enterValue(report.employeeNamet_textBox, employeeName);
		CommonMethods.enter();
	}

	@Then("^Verify Display Field Groups Personal is selected$")
	public void verify_Display_Field_Groups_Personal_is_selected() throws Exception {
		Thread.sleep(1000);
		report = new ReportPage();
		CommonMethods.dropDownSelect(report.displayFieldGroups_dropDown, "Personal");
		String expectedText = "Personal ";
		CommonMethods.verificationEquals(
				CommonMethods.dropDownSelectVerify(report.displayFieldGroups_dropDown, "Personal"), expectedText);
	}

	@Then("^Select Display Fields to Employee Id and Add Employee Id$")
	public void select_Display_Fields_to_Employee_Id_and_Add_Employee_Id() {
		report = new ReportPage();
		CommonMethods.dropDownSelect(report.displayFieldList_dropDown, "Employee Id");
		CommonMethods.click(report.displayFieldList_addButton);
	}

	@Then("^Check the box for Display Fields$")
	public void check_the_box_for_Display_Fields() {
		report = new ReportPage();
		CommonMethods.click(report.displayGRP);
	}

	@Then("^Click Save$")
	public void click_Save() {
		report = new ReportPage();
		CommonMethods.click(report.defineReport_saveButton);
	}

	@Then("^Validate Report Name appears$")
	public void validate_Report_Name_appears() {
		report = new ReportPage();
		List<WebElement> rows = report.resultsTable;

		for (int i = 1; i < rows.size(); i++) {
			WebElement row = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]"));
			String data = row.getText();
			System.out.println("Data from row " + i + " : " + data);
			if (data.contains("Syntax")) {
				System.out.println("Report Validated");
			}
		}
	}

	@When("^I click Edit on existing Report from the previous entry$")
	public void i_click_Edit_on_existing_Report_from_the_previous_entry() throws Throwable {
		report = new ReportPage();
        List<WebElement> rows = report.resultsTable;
        for (int i = 1; i <= rows.size(); i++) {
            WebElement row = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]"));
            String data = row.getText();
            Thread.sleep(1000);
            if (data.contains("Syntax")) {
                Thread.sleep(1000);
                //WebElement edit = BaseClass.driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[4]"));
                WebElement edit = BaseClass.driver.findElement(By.xpath("//td[text()='Syntax']//following-sibling::td//following-sibling::td//child::a"));
                Actions act = new Actions(driver);
                act.moveToElement(edit).doubleClick().perform();
			}
		}
	}

	@When("^Select Selection Criteria to Age Group and add Age Group$")
	public void select_Selection_Criteria_to_Age_Group_and_add_Age_Group() throws Exception {
		report = new ReportPage();
		Thread.sleep(1000);
		CommonMethods.click(report.selectCriteriadDropDown);
		Thread.sleep(1000);
		CommonMethods.dropDownSelect(report.selectCriteriadDropDown, "Age Group");
		Thread.sleep(1000);
		CommonMethods.click(report.selectCriteria_addButton);
	}
	
	@When("^then specify the Age Group \"([^\"]*)\" and age \"([^\"]*)\"$")
	public void then_specify_the_Age_Group_and_age(String ageGroup, String age) throws Throwable {
		Thread.sleep(1000);
		CommonMethods.dropDownSelect(report.ageGRPcomparison, ageGroup);
		Thread.sleep(1000);
		CommonMethods.enterValue(report.ageVal1, age);
	}

	@When("^Select Selection Criteria to Location and add Location$")
	public void select_Selection_Criteria_to_Location_and_add_Location() throws Exception {
		report = new ReportPage();
		Thread.sleep(1000);
		CommonMethods.dropDownSelect(report.selectCriteriadDropDown, "Location");
		CommonMethods.click(report.selectCriteria_addButton);
	}

	@When("^Select the location from the default menu$")
	public void select_the_location_from_the_default_menu() throws Exception {
		report = new ReportPage();
        WebElement locate=driver.findElement(By.xpath("//select[@id='location']//following-sibling::option[8]"));
        locate.click();
	}

	@When("^Select the Check Box for the edited Report Name from$")
	public void select_the_Check_Box_for_the_edited_Report_Name_from() throws Throwable {
		report = new ReportPage();
		List<WebElement> rows = report.resultsTable;

		for (int i = 1; i <=rows.size(); i++) {
			WebElement row = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]"));
			String data = row.getText();
			System.out.println("Data from row " + i + " : " + data);
			if (data.contains("Syntax")) {
				BaseClass.driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[1]")).click();
			}
		}
	}

	@Then("^Click Delete$")
	public void click_Delete() throws Throwable {
		report = new ReportPage();
		Thread.sleep(500);
		CommonMethods.click(report.deleteButton);
	}

	@Then("^click Ok$")
	public void click_Ok() {
		report = new ReportPage();
		CommonMethods.click(report.deleteRecordsButton);
	}

	@Then("^Verify Report Name does not Exist$")
	public void verify_Report_Name_does_not_Exist() {
		report = new ReportPage();
		List<WebElement> rows = report.resultsTable;

		for (int i = 1; i < rows.size(); i++) {
			WebElement row = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]"));
			String data = row.getText();
			System.out.println("Data from row " + i + " : " + data);
			if (data.contains("Syntax")) {
				System.out.println("Report was not deleted");
			} else {
				System.out.println("Report was successfully delted.");
			}
		}
	}
}
