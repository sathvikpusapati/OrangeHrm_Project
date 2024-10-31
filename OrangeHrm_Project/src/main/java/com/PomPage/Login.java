package com.PomPage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	
	private WebDriver driver;

	public  Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver , this);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement usn;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement psw;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement button;
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	private WebElement verify;
	
	public void logintopage(String username , String password)
	{
		usn.sendKeys(username);
		psw.sendKeys(password);
		button.click();
		
		
	}
	
	public boolean isdashboarddisplayed()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOf(verify));
		
		
		return verify.isDisplayed();
	}
}
