package com.PomPage;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Generic_Utils.File_Utils;

public class Employement_Status {
	private WebDriver driver;
	private WebDriverWait wait;
	private String action="create";
	private int index=0;
	private File_Utils fi=new File_Utils();

	public Employement_Status(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait= new WebDriverWait(driver,Duration.ofSeconds(15));
		
	}
	
	@FindBy(xpath="//span[text()='Admin']")
	private WebElement adminbutton;
	
	@FindBy(xpath="//span[text()='Job ']")
	private WebElement jobbutton;
	
	@FindBy(xpath="//a[text()='Employment Status']")
	private WebElement navigatetoemploy;
	
	@FindBy(xpath="//h6[text()='Employment Status']")
	private WebElement pageverify;
	
	@FindBy(xpath="//div[@role='cell' and @style='flex-basis: 80%;']")
	private List<WebElement> employlistfetch;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-trash']")
	private List<WebElement> deletebuttonlist;
	
	@FindBy(xpath="//button[text()=' Yes, Delete ']")
	private WebElement deletebutton;
	
	@FindBy(xpath="//p[text()='Successfully Deleted']")
	private WebElement deleteverify;
	
	@FindBy(xpath="//button[text()=' Add ']")
	private WebElement addbutton;
	
	
	@FindBy(xpath="//form//input[@class='oxd-input oxd-input--active']")
	private WebElement addname;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement savebutton;
	
	@FindBy(xpath="//p[text()='Success']")
	private WebElement verifysave;
	
	public void navigatetoemploy()
	{
	
		wait.until(ExpectedConditions.visibilityOf(adminbutton)).click();
		wait.until(ExpectedConditions.visibilityOf(jobbutton)).click();
		wait.until(ExpectedConditions.visibilityOf(navigatetoemploy)).click();
		String verify=wait.until(ExpectedConditions.visibilityOf(pageverify)).getText();
		System.out.println(verify+" Loaded succesfully");
	}
	
	public void employlistfetch() throws IOException
	{
		
		String title=fi.getdata("Employ_Status");
		
		for(WebElement list : employlistfetch)
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
	
	public void deleteemploytitle()
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
	
	public void addemployeststus() throws IOException
	{
		if(action.equals("create"))
		{
			String name=fi.getdata("Employ_Status");
			wait.until(ExpectedConditions.visibilityOf(addbutton)).click();
			wait.until(ExpectedConditions.visibilityOf(addname)).sendKeys(name);
			wait.until(ExpectedConditions.visibilityOf(savebutton)).click();
			String verify=wait.until(ExpectedConditions.visibilityOf(verifysave)).getText();
			System.out.println("creating Employ Status "+verify);
			
		}
	}
	

	public boolean verify() throws IOException
	{
		wait.until(ExpectedConditions.visibilityOf(jobbutton)).click();
		wait.until(ExpectedConditions.visibilityOf(navigatetoemploy)).click();
		boolean v=false;
		String title=fi.getdata("Employ_Status");
		
		for(WebElement list : employlistfetch)
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


