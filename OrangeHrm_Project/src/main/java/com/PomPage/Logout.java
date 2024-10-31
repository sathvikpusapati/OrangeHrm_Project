package com.PomPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout 
{
	private WebDriver driver;

	public  Logout(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	}
	
	@FindBy(xpath="//span[@class='oxd-userdropdown-tab']")
	private WebElement userdropdown;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutbutton;
	
	@FindBy(xpath="//h5[text()='Login']")
	private WebElement loginverify;
	
	public void perfomlogout()
	{
		userdropdown.click();
		logoutbutton.click();
	}
	
	public boolean islogindisplayed()
	{
		return loginverify.isDisplayed();
	}
}



