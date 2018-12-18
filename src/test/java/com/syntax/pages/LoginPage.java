package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class LoginPage extends BaseClass{

	@FindBy(xpath="//img[contains(@src, 'logo')]")
	public WebElement logo;
	
	@FindBy(id="txtUsername")
	public WebElement username;
	
	@FindBy(id="txtPassword")
	public WebElement password;
	
	@FindBy(id="btnLogin")
	public WebElement btnLogin;
	
	@FindBy(id="spanMessage")
	public WebElement errorMessage;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
}
