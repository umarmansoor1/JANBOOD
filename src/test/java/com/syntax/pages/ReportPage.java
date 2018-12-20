package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class ReportPage extends BaseClass {
	
	@FindBy(id = "btnAdd")
    public WebElement addButton;

    @FindBy(id = "report_report_name")
    public WebElement reportName;

    @FindBy(id = "report_criteria_list")
    public  WebElement selectCriteriadDropDown;

    @FindBy(id = "btnAddConstraint")
    public  WebElement selectCriteria_addButton;

    @FindBy(id = "report_include_comparision")
    public  WebElement includeCriteria_dropDown;

    @FindBy(id = "report_display_groups")
    public WebElement displayFieldGroups_dropDown;

    @FindBy(id = "btnAddDisplayGroup")
    public WebElement displayFieldGroup_addButton;

    @FindBy(id = "report_display_field_list")
    public WebElement displayFieldList_dropDown;

    @FindBy(id = "btnAddDisplayField")
    public WebElement displayFieldList_addButton;

    @FindBy(id = "btnSave")
    public WebElement defineReport_saveButton;
    
    @FindBy(id = "report_sub_unit")
    public WebElement subUnit_dropDown;
    
    @FindBy(id = "report_job_title")
    public WebElement jobTitle_dropDown;
    
    @FindBy(id = "employee_name_empName")
    public WebElement employeeNamet_textBox;

    @FindBy(xpath = "//table[@id='resultTable']/tbody/tr")
    public WebElement resultsTable;
    
    @FindBy(linkText = "Edit")
    public  WebElement editReportButton;

    @FindBy(id = "btnDelete")
    public WebElement deleteButton;

    @FindBy(id = "dialogDeleteBtn")
    public WebElement deleteRecordsButton;
    
    @FindBy(id="display_group_1")
    public WebElement displayGRP;
    
    @FindBy (id="age_group_comparision")
    public WebElement ageGRPcomparison;
    
    @FindBy(id="age_group_value1")
    public WebElement ageVal1;
    
    @FindBy(id="age_group_value2")
    public WebElement ageVal2;
    
    @FindBy(id="location")
    public WebElement locate;
	
	public ReportPage() {
		PageFactory.initElements(driver, this);
	}
}
