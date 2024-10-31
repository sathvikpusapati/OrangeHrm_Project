package com.PomPage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Generic_Utils.File_Utils;

public class Pay_Grades {

	private WebDriver driver;
	private String action="create"; 
	private int index=0 ,i=0 ;
	private WebDriverWait wait;
	private File_Utils fi=new File_Utils();
	private JavascriptExecutor js;
	public Pay_Grades(WebDriver driver)
	{
		this.driver=driver;
		this.js=  (JavascriptExecutor) driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Admin']")
	private WebElement adminbutton;
	
	@FindBy(xpath="//span[text()='Job ']")
	private WebElement jobbutton;
	
	@FindBy(xpath="//a[text()='Pay Grades']")
	private WebElement paygradesbutton;
	
	@FindBy(xpath="//h6[text()='Pay Grades']")
	private WebElement paygradesverify;
	
	@FindBy(xpath="//div[@data-v-6c07a142]") 
	private List<WebElement> paygradelistfetch;
	  
	@FindBy(xpath="//i[@class='oxd-icon bi-trash']") 
  	private List<WebElement> paygradedeletebuttonlist;
	  
	@FindBy(xpath="//button[text()=' Yes, Delete ']")
	private WebElement paygradedelete;
	  
	@FindBy(xpath="//p[text()='Successfully Deleted']") 
	private WebElement paygradedeleteverify;
	  
	@FindBy(xpath="//button[text()=' Add ']") 
	private WebElement paygradeaddbutton;
	
	@FindBy(xpath="//form//input[@class='oxd-input oxd-input--active']")
	private WebElement paygradename;
	
	@FindBy(xpath="//button[text()=' Save ']")
	private WebElement paygradesave;
	
	@FindBy(xpath="//form//input[@class='oxd-input oxd-input--active']")
	private WebElement paygradeverify;
	 
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	private WebElement addcurrency;
	
	@FindBy(xpath="//div[@class='oxd-select-text-input']")
	private WebElement selectdropdown;
	
	@FindBy(xpath="//span[text()='INR - Indian Rupee']")
	private WebElement selectcurrency;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[3]")
	private WebElement minsalary;
	
	@FindBy(xpath="(//div//input[@data-v-1f99f73c and @class='oxd-input oxd-input--active'])[4]")
	private WebElement maxsalary;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement currencysave;
	
	@FindBy(xpath="//p[text()='Successfully Saved']")
	private WebElement currencyverify;
	
	public void navigatetopaygrades()
	{
	
		wait.until(ExpectedConditions.visibilityOf(adminbutton)).click();
		wait.until(ExpectedConditions.visibilityOf(jobbutton)).click();
		wait.until(ExpectedConditions.visibilityOf(paygradesbutton)).click();
		String verify=wait.until(ExpectedConditions.visibilityOf(paygradesverify)).getText();
		System.out.println(verify+" Loaded succesfully");
	}
	
	public void paygradeslistfetch() throws IOException
	{
		
		String title=fi.getdata("Paygrade_Name");
		
		
		for(WebElement list : paygradelistfetch)
		{
			i=i+1;
			if(i%2==1)
			{
				index=index+1;
			}
			
			String verify=list.getText();
			if(verify.contains(title))
			{
				action="delete";
				break;
			}
		
		}
		
		System.out.println("fetched the paygrade list succesfully = "+title);
		System.out.println(index);
	}
	
	public void deletepaygrade()
	{
		if(action.equals("delete"))
		{
			int deletelistindex=0;
			for(WebElement delete : paygradedeletebuttonlist)
			{
				deletelistindex=deletelistindex+1;
				if(deletelistindex==index)
				{
					wait.until(ExpectedConditions.visibilityOf(delete)).click();
					wait.until(ExpectedConditions.visibilityOf(paygradedelete)).click();
					String verify=wait.until(ExpectedConditions.visibilityOf(paygradedeleteverify)).getText();
					System.out.println("deleting of pay grade "+verify);
					driver.navigate().refresh();
					break;
				}
				
			}
			
		}
		action="create";
	}
	
	public void createpaygrade() throws IOException
	{
		System.out.println(action);
		if(action.equals("create"))
		{
			
			
			String name=fi.getdata("Paygrade_Name");
			wait.until(ExpectedConditions.visibilityOf(paygradeaddbutton));
			wait.until(ExpectedConditions.elementToBeClickable(paygradeaddbutton)).click();
		
			
			wait.until(ExpectedConditions.visibilityOf(paygradename)).sendKeys(name);
			wait.until(ExpectedConditions.elementToBeClickable(paygradesave)).click();
			
		}
	}
	
	
	  public void addcurrency() throws AWTException
	  {
		  wait.until(ExpectedConditions.visibilityOf((addcurrency))).click();
		  
		  //Note : when we got a message Element <div class=""> is 
		  //not clickable at point (543,507) because 
		  //another element <div class="oxd-form-loader"> obscures it
		  //we need to use below conditon to load it properly
		  //and use invisibility of element
		  
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));

		  //to debug a page to get hidden dropdown xpath 
		  //use debugger option in selectorshub it will pause after 5 seconds
		  //so we can click the required dropdown in this span of time
		 
		  wait.until(ExpectedConditions.visibilityOf((selectdropdown))).click();
		  
		  wait.until(ExpectedConditions.visibilityOf((selectcurrency))).click();
		  
		  wait.until(ExpectedConditions.visibilityOf((minsalary))).sendKeys("20000");
		  
		  Robot rbt=new Robot();
		  rbt.delay(1000);
		  rbt.keyPress(KeyEvent.VK_TAB);
		  rbt.keyRelease(KeyEvent.VK_TAB);
		  rbt.keyPress(KeyEvent.VK_4);
		  rbt.keyRelease(KeyEvent.VK_4);
		  
		  for(int i=0;i<5;i++)
		  {
		  rbt.keyPress(KeyEvent.VK_0);
		  rbt.keyRelease(KeyEvent.VK_0);
		  }
		 
		 
		  wait.until(ExpectedConditions.elementToBeClickable(currencysave)).click();
		  
		  String verify= wait.until(ExpectedConditions.visibilityOf(currencyverify)).getText();
		  
		  System.out.println("pay grade and currency "+verify);
	  }

		
		  public boolean verify() throws IOException {
		  
		  wait.until(ExpectedConditions.visibilityOf(jobbutton)).click();
		  wait.until(ExpectedConditions.visibilityOf(paygradesbutton)).click(); boolean
		  v=false; String title=fi.getdata("Paygrade_Name");
		  
		  for(WebElement list : paygradelistfetch) {
		  
		  String verify=list.getText(); if(verify.contains(title)) { v=true; break; }
		  
		  } return v;
		  
		  }
		 
	
	
}
