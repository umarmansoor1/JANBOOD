package com.syntax.utils;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonMethods extends BaseClass {

	public static void enterValue(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public static WebElement waiting(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void click(WebElement element) {
		WebElement elm = waiting(element);
		elm.click();
	}
	
	public static void dropDownSelect(WebElement element, String value) {
        Select obj = new Select(element);
        obj.selectByVisibleText(value);
    }
	
	 public static void handleAlerts() {
	        Alert alert = driver.switchTo().alert();
	        alert.accept();
	    }
	 
	  public static void jsClick(WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", element);
	    }
	  
	  public static void verificationDisplayed(WebElement element) {
	        boolean elm = element.isDisplayed();
	        Assert.assertTrue(elm);
	    }
	    
	    public static void verificationEquals(WebElement element, String expected) {
	        boolean elm = element.isDisplayed();
	        Assert.assertEquals(element, expected);
	    }
	    
	    public static void verificationEquals(String actual, String expected) {
	        Assert.assertEquals(actual, expected);
	    }
	    
	    public static void enter() {
			driver.findElement(By.xpath("//input[@id='employee_name_empName']")).sendKeys(Keys.ENTER);
		}
	    
	    public static String dropDownSelectVerify(WebElement element, String value) {
	        Select obj = new Select(element);
	        obj.selectByVisibleText(value);
	        String text = obj.getFirstSelectedOption().getText();
	        return text;
	    }
	    
	    public static void byLink(String value) {
	    	driver.findElement(By.linkText(value)).click();
	    }

	}
