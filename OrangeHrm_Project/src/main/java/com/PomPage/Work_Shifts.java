package com.PomPage;

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

public class Work_Shifts {

	private WebDriver driver;
	private String action="create" ; 
	private int index=0;
	private WebDriverWait wait;
	private File_Utils fi=new File_Utils();
	private JavascriptExecutor js;
	
	public Work_Shifts(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));  
        this.js = (JavascriptExecutor) driver;  
		PageFactory.initElements(driver,this);
		
	}
	
	
	@FindBy(xpath="//span[text()='Admin']")
	private WebElement adminbutton;
	
	@FindBy(xpath="//span[text()='Job ']")
	private WebElement jobbutton;
	
	@FindBy(xpath="//a[text()='Work Shifts']")
	private WebElement workshiftbutton;
	
	@FindBy(xpath="//h6[text()='Work Shifts']")
	private WebElement pageverify;
	
	@FindBy(xpath="//div[@role='cell' and @style='flex: 1 1 0%;']")
	private List<WebElement> shiftslistfetch;
	//(//div[@role='cell' and @style='flex: 2 1 0%;'])[2]
	
	
	@FindBy(xpath="//i[@class='oxd-icon bi-trash']")
	private List<WebElement> deletebuttonlist;
	
	@FindBy(xpath="//button[text()=' Yes, Delete ']")
	private WebElement deletebutton;
	
	@FindBy(xpath="//p[text()='Successfully Deleted']")
	private WebElement deleteverify;
	
	
	@FindBy(xpath="//button[text()=' Add ']")
	private WebElement addbutton;
	
	@FindBy(xpath="(//form//div//input[@class='oxd-input oxd-input--active'])[1]")
	private WebElement addname;
	//here i am using parent information to avoid index
	
	
	@FindBy(xpath="(//i[@class='oxd-icon bi-clock oxd-time-input--clock'])[1]")
	private WebElement clock1;
	
	@FindBy(xpath="(//i[@class='oxd-icon bi-clock oxd-time-input--clock'])[2]")
	private WebElement clock2;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-chevron-down oxd-icon-button__icon oxd-time-hour-input-down']")
	private WebElement hours;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-chevron-down oxd-icon-button__icon oxd-time-minute-input-down']")
	private WebElement minutes;
	
	@FindBy(xpath="//input[@type='radio' and @value='AM']")
	private WebElement am;
	
	@FindBy(xpath="//input[@type='radio' and @value='PM']")
	private WebElement pm;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement savebutton;
	
	@FindBy(xpath="//p[text()='Success']")
	private WebElement verifysave;
	
	@FindBy(xpath="")
	private WebElement button;
	
	public String navigatetoworkshifts()
	{
		
		wait.until(ExpectedConditions.visibilityOf(adminbutton)).click();
		wait.until(ExpectedConditions.visibilityOf(jobbutton)).click();
		wait.until(ExpectedConditions.visibilityOf(workshiftbutton)).click();
		String verify=wait.until(ExpectedConditions.visibilityOf(pageverify)).getText();
		return verify;
	}
	
	public void listfetch() throws IOException
	{
		
		String title=fi.getdata("Shift_Name");
		
		for(WebElement list : shiftslistfetch)
		{
			index=index+1;
			String verify=list.getText();
			if(verify.contains(title))
			{	
				action="delete";
				break;
			}
			
		}
		
		System.out.println("fetched the shift list succesfully");
		if(index>1&&index<7)
		{
			index=index-5;
		}
		if(index>6&&index<12)
		{
			index=index-10;
		}
		if(index>10&&index<16)
		{
			index=index-15;
		}
		if(index>14&&index<20)
		{
			index=index-20;
		}
		if(index>18&&index<24)
		{
			index=index-25;
		}
		
	}
	
	public void deleteshift()
	{
		if(action.equals("delete"))
		{
			int deletelistindex=0;
			for(WebElement delete : deletebuttonlist)
			{
				deletelistindex=deletelistindex+1;
				if(deletelistindex==index)
				{
					wait.until(ExpectedConditions.visibilityOf(delete)).click();
					wait.until(ExpectedConditions.visibilityOf(deletebutton)).click();
					String verify=wait.until(ExpectedConditions.visibilityOf(deleteverify)).getText();
					System.out.println("deleting of job title"+verify);
					
				}
			}
		}
		else
		{
			System.out.println("no duplicate found");
		}
		action="create";
	}
	
	public void addshift() throws IOException, InterruptedException
	{
		if(action.equals("create"))
		{
			String name=fi.getdata("Shift_Name");
			wait.until(ExpectedConditions.visibilityOf(addbutton)).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
			wait.until(ExpectedConditions.visibilityOf(addname)).sendKeys(name);
			wait.until(ExpectedConditions.visibilityOf(clock1)).click();
			
			wait.until(ExpectedConditions.visibilityOf(hours)).click();
			wait.until(ExpectedConditions.visibilityOf(minutes)).click();
			
			wait.until(ExpectedConditions.visibilityOf(clock2)).click();
			
			wait.until(ExpectedConditions.visibilityOf(hours)).click();
			wait.until(ExpectedConditions.visibilityOf(minutes)).click();
			
			wait.until(ExpectedConditions.visibilityOf(savebutton)).click();
			String verify=wait.until(ExpectedConditions.visibilityOf(verifysave)).getText();
			System.out.println("creating Work Shift Status "+verify);
		}
	}
	
	public boolean verify() throws IOException
	{
		boolean v=false;
		wait.until(ExpectedConditions.visibilityOf(adminbutton)).click();
		wait.until(ExpectedConditions.visibilityOf(jobbutton)).click();
		wait.until(ExpectedConditions.visibilityOf(workshiftbutton)).click();
		
		String title=fi.getdata("Shift_Name");
		
		for(WebElement list : shiftslistfetch)
		{
			index=index+1;
			String verify=list.getText();
			if(verify.contains(title))
			{	
				v=true;
				break;
			}
			
		}
		
		return v;
	}
}
