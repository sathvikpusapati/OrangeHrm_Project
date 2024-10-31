package com.PomPage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Generic_Utils.File_Utils;

public class Job_Title 
{
	private WebDriver driver;
	private String action="create" ; 
	private int index=0;
	private WebDriverWait wait;
	private File_Utils fi=new File_Utils();
	private JavascriptExecutor js;
	
	public Job_Title(WebDriver driver)
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
	
	@FindBy(xpath="//a[text()='Job Titles']")
	private WebElement jobtitlebutton;
	
	@FindBy(xpath="//h6[text()='Job Titles']")
	private WebElement jobtitlepageverify;
	
	@FindBy(xpath="//div[@role='cell' and @style='flex: 2 1 0%;']")
	private List<WebElement> joblistfetch;
	//(//div[@role='cell' and @style='flex: 2 1 0%;'])[2]
	
	
	@FindBy(xpath="//i[@class='oxd-icon bi-trash']")
	private List<WebElement> deletebuttonlist;
	
	@FindBy(xpath="//button[text()=' Yes, Delete ']")
	private WebElement deletebutton;
	
	@FindBy(xpath="//p[text()='Successfully Deleted']")
	private WebElement deleteverify;
	
	
	@FindBy(xpath="//button[text()=' Add ']")
	private WebElement addbutton;
	
	@FindBy(xpath="//form//div//input[@class='oxd-input oxd-input--active']")
	private WebElement jobtitleinput;
	//here i am using parent information to avoid index
	
	
	@FindBy(xpath="//textarea[@placeholder='Type description here']")
	private WebElement jobdescription;
	
	@FindBy(xpath="//div[@class='oxd-file-div oxd-file-div--active']")
	private WebElement fileupload;
	
	@FindBy(xpath="//textarea[@placeholder='Add note']")
	private WebElement addnote;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement savebutton;
	
	@FindBy(xpath="//p[text()='Success']")
	private WebElement verifysave;
	
	@FindBy(xpath="")
	private WebElement button;
	
	public String navigatetojobtitle()
	{
		
		wait.until(ExpectedConditions.visibilityOf(adminbutton)).click();
		wait.until(ExpectedConditions.visibilityOf(jobbutton)).click();
		wait.until(ExpectedConditions.visibilityOf(jobtitlebutton)).click();
		String verify=wait.until(ExpectedConditions.visibilityOf(jobtitlepageverify)).getText();
		return verify;
	}
	
	public void jobtitlelistfetch() throws IOException
	{
		
		String title=fi.getdata("Job_Title");
		
		for(WebElement list : joblistfetch)
		{
			index=index+1;
			String verify=list.getText();
			if(verify.contains(title))
			{
				action="delete";
				break;
			}
		
		}
		
		System.out.println("fetched the job title list succesfully");
	}
	
	public void deletejobtitle()
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
	
	
	
	public void createjobtitle() throws IOException, AWTException
	{
		if(action.equals("create"))
		{
			wait.until(ExpectedConditions.visibilityOf(addbutton)).click();
			
			 String path = fi.getdata("File_Path"); // Ensure this is correctly set in your properties
	            String title = fi.getdata("Job_Title");
	            String description = fi.getdata("Job_Description");
	            String note = fi.getdata("Add_Note");
			
			wait.until(ExpectedConditions.visibilityOf(jobtitleinput)).sendKeys(title);
			wait.until(ExpectedConditions.visibilityOf(jobdescription)).sendKeys(description);
			js.executeScript("arguments[0].scrollIntoView();", fileupload);
			wait.until(ExpectedConditions.visibilityOf(fileupload)).click();
			//Note : by using rbt.delay(2000) it will wait for the dailouge box
			Robot rbt=new Robot();
			rbt.delay(1000);
			rbt.keyPress(KeyEvent.VK_D);
			rbt.keyRelease(KeyEvent.VK_D);
			rbt.keyPress(KeyEvent.VK_U);
			rbt.keyRelease(KeyEvent.VK_U);
			rbt.keyPress(KeyEvent.VK_DOWN);
			rbt.keyRelease(KeyEvent.VK_DOWN);
			rbt.keyPress(KeyEvent.VK_ENTER);
			rbt.keyRelease(KeyEvent.VK_ENTER);
			rbt.delay(3000);
			rbt.keyPress(KeyEvent.VK_ESCAPE);
			rbt.keyRelease(KeyEvent.VK_ESCAPE);
			rbt.delay(3000);
			
			//wait.until(ExpectedConditions.visibilityOf(fileupload)).sendKeys(path);
			js.executeScript("arguments[0].scrollIntoView();",addnote);
			wait.until(ExpectedConditions.visibilityOf(addnote)).sendKeys(note);
			wait.until(ExpectedConditions.visibilityOf(savebutton)).click();
			String verify=wait.until(ExpectedConditions.visibilityOf(verifysave)).getText();
			System.out.println("creating job title"+verify);
			
		}
		
	}
	
//-----------------------------------------------------------------------------------------------------
	
	
	
}
