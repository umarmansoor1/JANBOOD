package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class OrangeHRM_homePage extends BaseClass {
	
	@FindBy(id="menu_pim_viewPimModule")
	public WebElement clickPIM;
	
	@FindBy(id="menu_core_viewDefinedPredefinedReports")
	public WebElement clickReport;
	
	public OrangeHRM_homePage() {
		PageFactory.initElements(driver, this);
	}
	
}
