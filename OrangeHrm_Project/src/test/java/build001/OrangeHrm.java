package build001;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Generic_Utils.File_Utils;
import com.PomPage.Add_Employe;
import com.PomPage.Employement_Status;
import com.PomPage.Job_Categories;
import com.PomPage.Job_Title;
import com.PomPage.Login;
import com.PomPage.Logout;
import com.PomPage.Pay_Grades;
import com.PomPage.Work_Shifts;

public class OrangeHrm{

	WebDriver driver;
	
	@BeforeSuite
	public void SetupSuite()
	{
		
		System.out.println("setting up test suite");
	}
	
	
	@BeforeTest
	public void opens_Browser()
	{
		//opening browser
		driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		if(driver !=null)
		{
			
			System.out.println("Browser opened succesfully");
		}
		
	}
	
	
	@BeforeClass
	public void pageloading() throws IOException
	{
		//loading the page
		File_Utils fi=new File_Utils();
		
		driver.get(fi.getdata("Url"));
		
		String expected="OrangeHRM";
		
		String Actual=driver.getTitle();
		
		Assert.assertEquals(Actual, expected,"Login page not loaded succesfully");
	}
	
	@BeforeMethod
	public void login() throws IOException
	{
		File_Utils fi=new File_Utils();
		
		String username=fi.getdata("Login_Username");
		String password=fi.getdata("Login_Password");
		
		Login log=new Login(driver);
		
		log.logintopage(username, password);
		
		boolean value=log.isdashboarddisplayed();
		
		Assert.assertEquals(value, true,"Login was not succesful");
		if(value==true)
		{
			System.out.println("logged in");
		}
	}
	
	@Test(priority=1 ,invocationCount=1)
	public void jobtitle() throws InterruptedException, IOException, AWTException
	{
		
		
		Job_Title job=new Job_Title(driver);
		
		String actual=job.navigatetojobtitle();
		Assert.assertEquals(actual, "Job Titles","job title page not loaded sucessfully");
		Thread.sleep(5000);
		
		job.jobtitlelistfetch();
		job.deletejobtitle();
		job.createjobtitle();
	}
	@Test(priority=2 ,invocationCount=1)
	public void paygrades() throws IOException, AWTException
	{
		Pay_Grades paygrade=new Pay_Grades(driver);
		
		paygrade.navigatetopaygrades();
		paygrade.paygradeslistfetch();
		paygrade.deletepaygrade();
		paygrade.createpaygrade();
		paygrade.addcurrency();
		
		 Assert.assertEquals(paygrade.verify(), true,"paygrade not loaded"); 
	}
	
	@Test(priority=3 ,invocationCount=1)
	public void Employ_Status() throws IOException
	{
		Employement_Status emp=new Employement_Status(driver);
		
		emp.navigatetoemploy();
		emp.employlistfetch();
		emp.deleteemploytitle();
		emp.addemployeststus();
		 Assert.assertEquals(emp.verify(), true,"employe status not loaded"); 
	}
	
	@Test(priority=4 ,invocationCount=1)
	public void Job_Categories() throws IOException, InterruptedException
	{
		Job_Categories job=new Job_Categories(driver);
		
		job.navigatetoemploy();
		job.categorylistfetch();
		job.deletejobcategorie();
		job.addemployeststus();
		 Assert.assertEquals(job.verify(), true,"Job categorie not loaded"); 
	}
	
	@Test(priority=5 ,invocationCount=1)
	public void Add_Employee() throws IOException, InterruptedException, AWTException
	{
		Add_Employe emp=new Add_Employe(driver);
		
		emp.navigatetoaddemploye();
		emp.deleteemploye();
		emp.addemploye();
		emp.personaldetails();
		emp.contactdetails();
		emp.jobdetails();
		emp.salary();
		Assert.assertEquals(emp.verify(), true,"Job categorie not loaded"); 
		
	}
	
	@Test(priority=6 ,invocationCount=1)
	public void Work_Shift() throws IOException, InterruptedException, AWTException
	{
		Work_Shifts work=new Work_Shifts(driver);
		
		work.navigatetoworkshifts();
		work.listfetch();
		work.deleteshift();
		work.addshift();
		Assert.assertEquals(work.verify(), true,"Job categorie not loaded"); 
		
	}
	
	@AfterMethod
	public void loggingout()
	{
		Logout log=new Logout(driver);
		
		log.perfomlogout();
		
		boolean verify=log.islogindisplayed();
		
		Assert.assertEquals(verify,true,"Logout was not Succesfull");
		if(verify==true)
		{
			System.out.println("logged out");
		}
	}
	
	@AfterClass
	public void pagecleanup()
	{
		driver.manage().deleteAllCookies();
		System.out.println("All cookies deleted Succesfully");
	}
	
	@AfterTest
	public void closing_browser()
	{
		if(driver !=null)
		{
			driver.quit();
			System.out.println("Firefox Browser closed succesfully");
		}
	}
	
	@AfterSuite
	public void ClosingSuite()
	{
		System.out.println("Closing test suite");
	}
	
}
