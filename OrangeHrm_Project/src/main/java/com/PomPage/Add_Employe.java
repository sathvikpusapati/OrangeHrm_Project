package com.PomPage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Generic_Utils.File_Utils;

public class Add_Employe {

	private WebDriver driver;
	private String action="create" ; 
	private int index=0;
	private WebDriverWait wait;
	private File_Utils fi=new File_Utils();
	private JavascriptExecutor js;
	
	public Add_Employe(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));  
        this.js = (JavascriptExecutor) driver;  
		PageFactory.initElements(driver,this);
		
	}
	
	
	@FindBy(xpath="//span[text()='PIM']")
	private WebElement PIMbutton;
	
	@FindBy(xpath="(//input[@placeholder='Type for hints...'])[1]")
	private WebElement employesearch;
	
	@FindBy(xpath="//div[@role='option']")
	private WebElement employeverify;//No Records Found
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement	searchbutton;
	
	@FindBy(xpath="(//span[@class='oxd-text oxd-text--span'])[1]")
	private WebElement employeverify2;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-trash']")
	private WebElement deletebuttonlist;
	
	@FindBy(xpath="//button[text()=' Yes, Delete ']")
	private WebElement deletebutton;
	
	@FindBy(xpath="//p[text()='Successfully Deleted']")
	private WebElement deleteverify;
	
	@FindBy(xpath="//button[text()=' Add ']")
	private WebElement addbutton;
	
	@FindBy(xpath="//input[@name='firstName']")
	private WebElement firstname;
	
	@FindBy(xpath="//input[@name='lastName']")
	private WebElement lastname;
	
	@FindBy(xpath="//button[text()=' Save ']")
	private WebElement savebutton;
	
	@FindBy(xpath="//form//button[@type='button' and @role='none']")
	private WebElement imgbutton;
	
	@FindBy(xpath="//h6[text()='Personal Details']")
	private WebElement saveverify;
	
	@FindBy(xpath="//form//input[@class='oxd-input oxd-input--active']")
	private WebElement id;
	
	@FindBy(xpath="//span[text()='PIM']")
	private WebElement PIMbuttofn;
	
	public	void navigatetoaddemploye() throws IOException, InterruptedException
	{
		
		wait.until(ExpectedConditions.visibilityOf(PIMbutton)).click();
		String name=fi.getdata("Employe_Name");
		String lastname=fi.getdata("Last_Name");
		wait.until(ExpectedConditions.visibilityOf(employesearch)).sendKeys(name+" "+lastname);
		
		wait.until(ExpectedConditions.visibilityOf(searchbutton)).click();
		 Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", employeverify2);
		wait.until(ExpectedConditions.visibilityOf(employeverify2));
		String verifyemploye=employeverify2.getText();
		System.out.println(verifyemploye);
		if(verifyemploye.equals("No Records Found"))
		{
			action="create";
		}
		else
		{
			action="delete";
		}
		
	}
	
	public void deleteemploye()
	{
		if(action.equals("delete"))
		{
			//js.executeScript("arguments[0].scrollIntoView();", searchbutton);
			//wait.until(ExpectedConditions.visibilityOf(searchbutton)).click();
			wait.until(ExpectedConditions.visibilityOf(deletebuttonlist)).click();
			wait.until(ExpectedConditions.visibilityOf(deletebutton)).click();
			String verify=wait.until(ExpectedConditions.visibilityOf(deleteverify)).getText();
			System.out.println("deleting of Employe "+verify);
			driver.navigate().refresh();
		}
		action="create";
		
	}
	
	public void addemploye() throws IOException, InterruptedException, AWTException
	{
		if(action.equals("create"))
		{
			String name1=fi.getdata("Employe_Name");
			String name2=fi.getdata("Last_Name");
			String path=fi.getdata("img");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-toast-close-container")));
			wait.until(ExpectedConditions.visibilityOf(addbutton)).click();
			wait.until(ExpectedConditions.visibilityOf(firstname)).sendKeys(name1);
			wait.until(ExpectedConditions.visibilityOf(lastname)).sendKeys(name2);
			wait.until(ExpectedConditions.visibilityOf(id)).sendKeys("5201");

			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-toast-close-container")));
			wait.until(ExpectedConditions.visibilityOf(imgbutton)).click();
			Robot rbt=new Robot();
			rbt.delay(1000);
			rbt.keyPress(KeyEvent.VK_D);
			rbt.keyRelease(KeyEvent.VK_D);
			rbt.keyPress(KeyEvent.VK_O);
			rbt.keyRelease(KeyEvent.VK_O);
			rbt.keyPress(KeyEvent.VK_W);
			rbt.keyRelease(KeyEvent.VK_W);
			rbt.keyPress(KeyEvent.VK_DOWN);
			rbt.keyRelease(KeyEvent.VK_DOWN);
			rbt.keyPress(KeyEvent.VK_ENTER);
			rbt.keyRelease(KeyEvent.VK_ENTER);
			rbt.delay(2000);
			rbt.keyPress(KeyEvent.VK_ESCAPE);
			rbt.keyRelease(KeyEvent.VK_ESCAPE);
			rbt.delay(2000);
			wait.until(ExpectedConditions.elementToBeClickable(savebutton)).click();
			wait.until(ExpectedConditions.visibilityOf(saveverify));
			
		}
	}
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[4]")
	private WebElement licensenum;
	
	@FindBy(xpath="(//i[@class='oxd-icon bi-calendar oxd-date-input-icon'])[1]")
	private WebElement licenseexpiry;
	
	@FindBy(xpath="//div[@class='oxd-date-input-link --today']")
	private WebElement licenseexpirybutton;
	
	@FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[1]")
	private WebElement nationalism;
	
	@FindBy(xpath="//span[text()='Indian']")
	private WebElement indian;
	
	@FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[2]")
	private WebElement martial;
	
	@FindBy(xpath="//span[text()='Single']")
	private WebElement single;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[6]")
	private WebElement dob;
	
	@FindBy(xpath="//div[@class='oxd-date-input-link --today']")
	private WebElement dobbutton;
	
	@FindBy(xpath="(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[1]")
	private WebElement gender;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	private WebElement save1;
	
	
	
	public void personaldetails() throws InterruptedException
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
		wait.until(ExpectedConditions.visibilityOf(licensenum)).sendKeys("2356566865");
		wait.until(ExpectedConditions.visibilityOf(licenseexpiry)).click();
		wait.until(ExpectedConditions.visibilityOf(licenseexpirybutton)).click();
		wait.until(ExpectedConditions.elementToBeClickable(nationalism)).click();
		wait.until(ExpectedConditions.elementToBeClickable(indian)).click();
		wait.until(ExpectedConditions.elementToBeClickable(martial)).click();
		wait.until(ExpectedConditions.elementToBeClickable(single)).click();
		wait.until(ExpectedConditions.visibilityOf(dob)).click();
		wait.until(ExpectedConditions.visibilityOf(dobbutton)).click();
		wait.until(ExpectedConditions.elementToBeClickable(gender)).click();
		wait.until(ExpectedConditions.elementToBeClickable(save1)).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-1000)");
		
		
	}
	//Note : i used nested indexes to fetch the xpath 
	@FindBy(xpath="//a[text()='Contact Details']")
	private WebElement navigatecontact;
	
	@FindBy(xpath="((//div[@class='oxd-form-row'])[1]//div[@data-v-957b4417]//input[@class='oxd-input oxd-input--active'])[1]")
	private WebElement street1;
	
	@FindBy(xpath="(//input[@data-v-1f99f73c and @class='oxd-input oxd-input--active'])[2]")
	private WebElement street2;
	
	@FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//div[1]//div[1]//div[3]//div[1]//div[2]//input[1]")
	private WebElement city;
	
	@FindBy(xpath="//div[4]//div[1]//div[2]//input[1]")
	private WebElement state;
	
	@FindBy(xpath="//div[5]//div[1]//div[2]//input[1]")
	private WebElement pincode;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
	private WebElement country;

	@FindBy(xpath="//span[text()='India']")
	private WebElement india;
	
	@FindBy(xpath="((//div[@class='oxd-form-row'])[2]//div[@data-v-957b4417]//input[@class='oxd-input oxd-input--active'])[1]")
	private WebElement home;
	
	@FindBy(xpath="//div[@class='orangehrm-edit-employee-content']//div[2]//div[1]//div[2]//div[1]//div[2]//input[1]")
	private WebElement mobile;
	
	@FindBy(xpath="//div[@class='orangehrm-edit-employee-content']//div[2]//div[1]//div[3]//div[1]//div[2]//input[1]")
	private WebElement work;
	
	@FindBy(xpath="((//div[@class='oxd-form-row'])[3]//div[@data-v-957b4417]//input[@class='oxd-input oxd-input--active'])[1]")
	private WebElement email;
	
	@FindBy(xpath="//div[3]//div[1]//div[2]//div[1]//div[2]//input[1]")
	private WebElement email2;
	
	
	public void contactdetails()
	{
		js.executeScript("window.scrollBy(0,-1000)");
		
		
		wait.until(ExpectedConditions.elementToBeClickable(navigatecontact)).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
		wait.until(ExpectedConditions.visibilityOf(street1)).sendKeys("20-03-12");
		wait.until(ExpectedConditions.visibilityOf(street2)).sendKeys("10th cross road");
		wait.until(ExpectedConditions.visibilityOf(city)).sendKeys("Nellore");
		wait.until(ExpectedConditions.visibilityOf(state)).sendKeys("AP");
		wait.until(ExpectedConditions.visibilityOf(pincode)).sendKeys("524002");
		
		wait.until(ExpectedConditions.elementToBeClickable(country)).click();
		wait.until(ExpectedConditions.elementToBeClickable(india)).click();
		wait.until(ExpectedConditions.visibilityOf(home)).sendKeys("6616663666");
		wait.until(ExpectedConditions.visibilityOf(mobile)).sendKeys("1651215215");
		wait.until(ExpectedConditions.visibilityOf(work)).sendKeys("451165111");
		wait.until(ExpectedConditions.visibilityOf(email)).sendKeys("AP@gmail.com");
		wait.until(ExpectedConditions.visibilityOf(email2)).sendKeys("TN@gmail.com");
		wait.until(ExpectedConditions.elementToBeClickable(save1)).click();
		
	}
	
	@FindBy(xpath="//a[text()='Job']")
	private WebElement navigatejob;
	
	@FindBy(xpath="(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")
	private WebElement jobtitle;
	
	@FindBy(xpath="//span[text()='Senior Test Lead']")
	private WebElement jobtitlebutton;
	
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[2]")
	private WebElement jobcategory;
	
	@FindBy(xpath="//span[text()='Test Workers']")
	private WebElement jobcategoriebutton;
	
	@FindBy(xpath="//div[7]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]")
	private WebElement status;
	
	@FindBy(xpath="//span[text()='Over-Time']")
	private WebElement statusbutton;
	
	public void jobdetails()
	{
		
		
		
		wait.until(ExpectedConditions.elementToBeClickable(navigatejob)).click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
		
		wait.until(ExpectedConditions.elementToBeClickable(jobtitle)).click();
		wait.until(ExpectedConditions.elementToBeClickable(jobtitlebutton)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(jobcategory)).click();
		//js.executeScript("arguments[0].scrollIntoView();", jobcategoriebutton);
		wait.until(ExpectedConditions.elementToBeClickable(jobcategoriebutton)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(status)).click();
		//js.executeScript("arguments[0].scrollIntoView();", statusbutton);
		wait.until(ExpectedConditions.elementToBeClickable(statusbutton)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(save1)).click();
	}
	
	@FindBy(xpath="//a[text()='Salary']")
	private WebElement navigatesalary;
	
	@FindBy(xpath="//div[@class='oxd-grid-3 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//input[1]")
	private WebElement salarycomponent;
	
	@FindBy(xpath="//div[5]//div[1]//div[2]//input[1]")
	private WebElement salary;
	
	@FindBy(xpath="(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")
	private WebElement paygrade;
	
	@FindBy(xpath="//span[text()='Grade 9']")
	private WebElement paygradebutton;
	
	@FindBy(xpath="(//button[@type='button'])[4]")
	private WebElement button;
	
	public void salary()
	{
		js.executeScript("arguments[0].scrollIntoView();", navigatesalary);
		
		
		wait.until(ExpectedConditions.elementToBeClickable(navigatesalary)).click();
		
		
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
		
		wait.until(ExpectedConditions.elementToBeClickable(button)).click();
		wait.until(ExpectedConditions.visibilityOf(salarycomponent)).sendKeys("BASIC");
		
		
		
		wait.until(ExpectedConditions.visibilityOf(salary)).sendKeys("25000");
		
		wait.until(ExpectedConditions.elementToBeClickable(paygrade)).click();
		wait.until(ExpectedConditions.elementToBeClickable(paygradebutton)).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
		wait.until(ExpectedConditions.elementToBeClickable(save1)).click();
		
	}
	
	public boolean verify() throws IOException, InterruptedException
	{
		boolean v;
		wait.until(ExpectedConditions.visibilityOf(PIMbutton)).click();
		String name=fi.getdata("Employe_Name");
		String lastname=fi.getdata("Last_Name");
		wait.until(ExpectedConditions.visibilityOf(employesearch)).sendKeys(name+" "+lastname);
		
		wait.until(ExpectedConditions.visibilityOf(searchbutton)).click();
		 Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", employeverify2);
		wait.until(ExpectedConditions.visibilityOf(employeverify2));
		String verifyemploye=employeverify2.getText();
		System.out.println(verifyemploye);
		if(verifyemploye.equals("No Records Found"))
		{
			v=false;
		}
		else
		{
			v=true;
		}
		return v;
	}
}
