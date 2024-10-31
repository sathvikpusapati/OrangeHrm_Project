/*
 * package com.PomPage;
 * 
 * import java.time.Duration;
 * 
 * import org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement;
 * import org.openqa.selenium.support.FindBy; import
 * org.openqa.selenium.support.PageFactory; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait;
 * 
 * public class Login {
 * 
 * private WebDriver driver;
 * 
 * public Login(WebDriver driver) { this.driver=driver;
 * PageFactory.initElements(driver , this);
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); }
 * 
 * @FindBy(xpath="//input[@name='username']") private WebElement usn;
 * 
 * @FindBy(xpath="//input[@name='password']") private WebElement psw;
 * 
 * @FindBy(xpath="//button[@type='submit']") private WebElement button;
 * 
 * @FindBy(xpath="//h6[text()='Dashboard']") private WebElement verify;
 * 
 * public void logintopage(String username , String password) {
 * usn.sendKeys(username); psw.sendKeys(password); button.click();
 * 
 * 
 * }
 * 
 * public boolean isdashboarddisplayed() { WebDriverWait wait=new
 * WebDriverWait(driver,Duration.ofSeconds(10));
 * 
 * wait.until(ExpectedConditions.visibilityOf(verify));
 * 
 * 
 * return verify.isDisplayed(); } } package com.PomPage;
 * 
 * import java.time.Duration;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.WebElement; import org.openqa.selenium.support.FindBy;
 * import org.openqa.selenium.support.PageFactory;
 * 
 * public class Logout { private WebDriver driver;
 * 
 * public Logout(WebDriver driver) { this.driver=driver;
 * 
 * PageFactory.initElements(driver,this);
 * 
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 * 
 * }
 * 
 * @FindBy(xpath="//span[@class='oxd-userdropdown-tab']") private WebElement
 * userdropdown;
 * 
 * @FindBy(xpath="//a[text()='Logout']") private WebElement logoutbutton;
 * 
 * @FindBy(xpath="//h5[text()='Login']") private WebElement loginverify;
 * 
 * public void perfomlogout() { userdropdown.click(); logoutbutton.click(); }
 * 
 * public boolean islogindisplayed() { return loginverify.isDisplayed(); } }
 * 
 * 
 * 
 * package com.PomPage;
 * 
 * import java.awt.AWTException; import java.awt.Robot; import
 * java.awt.event.KeyEvent; import java.io.IOException; import
 * java.time.Duration; import java.util.List;
 * 
 * import org.openqa.selenium.JavascriptExecutor; import
 * org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement; import
 * org.openqa.selenium.support.FindBy; import
 * org.openqa.selenium.support.PageFactory; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait;
 * 
 * import com.Generic_Utils.File_Utils;
 * 
 * public class Job_Title { private WebDriver driver; private String
 * action="create" ; private int index=0; private WebDriverWait wait; private
 * File_Utils fi=new File_Utils(); private JavascriptExecutor js;
 * 
 * public Job_Title(WebDriver driver) { this.driver=driver; this.wait = new
 * WebDriverWait(driver, Duration.ofSeconds(10)); this.js = (JavascriptExecutor)
 * driver; PageFactory.initElements(driver,this);
 * 
 * }
 * 
 * 
 * @FindBy(xpath="//span[text()='Admin']") private WebElement adminbutton;
 * 
 * @FindBy(xpath="//span[text()='Job ']") private WebElement jobbutton;
 * 
 * @FindBy(xpath="//a[text()='Job Titles']") private WebElement jobtitlebutton;
 * 
 * @FindBy(xpath="//h6[text()='Job Titles']") private WebElement
 * jobtitlepageverify;
 * 
 * @FindBy(xpath="//div[@role='cell' and @style='flex: 2 1 0%;']") private
 * List<WebElement> joblistfetch; //(//div[@role='cell' and @style='flex: 2 1
 * 0%;'])[2]
 * 
 * 
 * @FindBy(xpath="//i[@class='oxd-icon bi-trash']") private List<WebElement>
 * deletebuttonlist;
 * 
 * @FindBy(xpath="//button[text()=' Yes, Delete ']") private WebElement
 * deletebutton;
 * 
 * @FindBy(xpath="//p[text()='Successfully Deleted']") private WebElement
 * deleteverify;
 * 
 * 
 * @FindBy(xpath="//button[text()=' Add ']") private WebElement addbutton;
 * 
 * @FindBy(xpath="//form//div//input[@class='oxd-input oxd-input--active']")
 * private WebElement jobtitleinput; //here i am using parent information to
 * avoid index
 * 
 * 
 * @FindBy(xpath="//textarea[@placeholder='Type description here']") private
 * WebElement jobdescription;
 * 
 * @FindBy(xpath="//div[@class='oxd-file-div oxd-file-div--active']") private
 * WebElement fileupload;
 * 
 * @FindBy(xpath="//textarea[@placeholder='Add note']") private WebElement
 * addnote;
 * 
 * @FindBy(xpath="//button[@type='submit']") private WebElement savebutton;
 * 
 * @FindBy(xpath="//p[text()='Success']") private WebElement verifysave;
 * 
 * @FindBy(xpath="") private WebElement button;
 * 
 * public String navigatetojobtitle() {
 * 
 * wait.until(ExpectedConditions.visibilityOf(adminbutton)).click();
 * wait.until(ExpectedConditions.visibilityOf(jobbutton)).click();
 * wait.until(ExpectedConditions.visibilityOf(jobtitlebutton)).click(); String
 * verify=wait.until(ExpectedConditions.visibilityOf(jobtitlepageverify)).
 * getText(); return verify; }
 * 
 * public void jobtitlelistfetch() throws IOException {
 * 
 * String title=fi.getdata("Job_Title");
 * 
 * for(WebElement list : joblistfetch) { index=index+1; String
 * verify=list.getText(); if(verify.contains(title)) { action="delete"; break; }
 * 
 * }
 * 
 * System.out.println("fetched the job title list succesfully"); }
 * 
 * public void deletejobtitle() { if(action.equals("delete")) { int
 * deletelistindex=0; for(WebElement delete : deletebuttonlist) {
 * deletelistindex=deletelistindex+1; if(deletelistindex==index) {
 * wait.until(ExpectedConditions.visibilityOf(delete)).click();
 * wait.until(ExpectedConditions.visibilityOf(deletebutton)).click(); String
 * verify=wait.until(ExpectedConditions.visibilityOf(deleteverify)).getText();
 * System.out.println("deleting of job title"+verify);
 * 
 * } } } else { System.out.println("no duplicate found"); } action="create"; }
 * 
 * 
 * 
 * public void createjobtitle() throws IOException, AWTException {
 * if(action.equals("create")) {
 * wait.until(ExpectedConditions.visibilityOf(addbutton)).click();
 * 
 * String path = fi.getdata("File_Path"); // Ensure this is correctly set in
 * your properties String title = fi.getdata("Job_Title"); String description =
 * fi.getdata("Job_Description"); String note = fi.getdata("Add_Note");
 * 
 * wait.until(ExpectedConditions.visibilityOf(jobtitleinput)).sendKeys(title);
 * wait.until(ExpectedConditions.visibilityOf(jobdescription)).sendKeys(
 * description); js.executeScript("arguments[0].scrollIntoView();", fileupload);
 * wait.until(ExpectedConditions.visibilityOf(fileupload)).click(); //Note : by
 * using rbt.delay(2000) it will wait for the dailouge box Robot rbt=new
 * Robot(); rbt.delay(1000); rbt.keyPress(KeyEvent.VK_D);
 * rbt.keyRelease(KeyEvent.VK_D); rbt.keyPress(KeyEvent.VK_U);
 * rbt.keyRelease(KeyEvent.VK_U); rbt.keyPress(KeyEvent.VK_DOWN);
 * rbt.keyRelease(KeyEvent.VK_DOWN); rbt.keyPress(KeyEvent.VK_ENTER);
 * rbt.keyRelease(KeyEvent.VK_ENTER); rbt.delay(3000);
 * rbt.keyPress(KeyEvent.VK_ESCAPE); rbt.keyRelease(KeyEvent.VK_ESCAPE);
 * rbt.delay(3000);
 * 
 * //wait.until(ExpectedConditions.visibilityOf(fileupload)).sendKeys(path);
 * js.executeScript("arguments[0].scrollIntoView();",addnote);
 * wait.until(ExpectedConditions.visibilityOf(addnote)).sendKeys(note);
 * wait.until(ExpectedConditions.visibilityOf(savebutton)).click(); String
 * verify=wait.until(ExpectedConditions.visibilityOf(verifysave)).getText();
 * System.out.println("creating job title"+verify);
 * 
 * }
 * 
 * }
 * 
 * //---------------------------------------------------------------------------
 * --------------------------
 * 
 * 
 * 
 * } package com.PomPage;
 * 
 * import java.awt.AWTException; import java.awt.Robot; import
 * java.awt.event.KeyEvent; import java.io.IOException; import
 * java.time.Duration; import java.util.List;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.JavascriptExecutor;
 * import org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement;
 * import org.openqa.selenium.support.FindBy; import
 * org.openqa.selenium.support.PageFactory; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait;
 * 
 * import com.Generic_Utils.File_Utils;
 * 
 * public class Pay_Grades {
 * 
 * private WebDriver driver; private String action="create"; private int index=0
 * ,i=0 ; private WebDriverWait wait; private File_Utils fi=new File_Utils();
 * private JavascriptExecutor js; public Pay_Grades(WebDriver driver) {
 * this.driver=driver; this.js= (JavascriptExecutor) driver; this.wait=new
 * WebDriverWait(driver,Duration.ofSeconds(10));
 * PageFactory.initElements(driver, this); }
 * 
 * @FindBy(xpath="//span[text()='Admin']") private WebElement adminbutton;
 * 
 * @FindBy(xpath="//span[text()='Job ']") private WebElement jobbutton;
 * 
 * @FindBy(xpath="//a[text()='Pay Grades']") private WebElement paygradesbutton;
 * 
 * @FindBy(xpath="//h6[text()='Pay Grades']") private WebElement
 * paygradesverify;
 * 
 * @FindBy(xpath="//div[@data-v-6c07a142]") private List<WebElement>
 * paygradelistfetch;
 * 
 * @FindBy(xpath="//i[@class='oxd-icon bi-trash']") private List<WebElement>
 * paygradedeletebuttonlist;
 * 
 * @FindBy(xpath="//button[text()=' Yes, Delete ']") private WebElement
 * paygradedelete;
 * 
 * @FindBy(xpath="//p[text()='Successfully Deleted']") private WebElement
 * paygradedeleteverify;
 * 
 * @FindBy(xpath="//button[text()=' Add ']") private WebElement
 * paygradeaddbutton;
 * 
 * @FindBy(xpath="//form//input[@class='oxd-input oxd-input--active']") private
 * WebElement paygradename;
 * 
 * @FindBy(xpath="//button[text()=' Save ']") private WebElement paygradesave;
 * 
 * @FindBy(xpath="//form//input[@class='oxd-input oxd-input--active']") private
 * WebElement paygradeverify;
 * 
 * @FindBy(
 * xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']"
 * ) private WebElement addcurrency;
 * 
 * @FindBy(xpath="//div[@class='oxd-select-text-input']") private WebElement
 * selectdropdown;
 * 
 * @FindBy(xpath="//span[text()='INR - Indian Rupee']") private WebElement
 * selectcurrency;
 * 
 * @FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[3]") private
 * WebElement minsalary;
 * 
 * @FindBy(
 * xpath="(//div//input[@data-v-1f99f73c and @class='oxd-input oxd-input--active'])[4]"
 * ) private WebElement maxsalary;
 * 
 * @FindBy(xpath="(//button[@type='submit'])[2]") private WebElement
 * currencysave;
 * 
 * @FindBy(xpath="//p[text()='Successfully Saved']") private WebElement
 * currencyverify;
 * 
 * public void navigatetopaygrades() {
 * 
 * wait.until(ExpectedConditions.visibilityOf(adminbutton)).click();
 * wait.until(ExpectedConditions.visibilityOf(jobbutton)).click();
 * wait.until(ExpectedConditions.visibilityOf(paygradesbutton)).click(); String
 * verify=wait.until(ExpectedConditions.visibilityOf(paygradesverify)).getText()
 * ; System.out.println(verify+" Loaded succesfully"); }
 * 
 * public void paygradeslistfetch() throws IOException {
 * 
 * String title=fi.getdata("Paygrade_Name");
 * 
 * 
 * for(WebElement list : paygradelistfetch) { i=i+1; if(i%2==1) { index=index+1;
 * }
 * 
 * String verify=list.getText(); if(verify.contains(title)) { action="delete";
 * break; }
 * 
 * }
 * 
 * System.out.println("fetched the paygrade list succesfully = "+title);
 * System.out.println(index); }
 * 
 * public void deletepaygrade() { if(action.equals("delete")) { int
 * deletelistindex=0; for(WebElement delete : paygradedeletebuttonlist) {
 * deletelistindex=deletelistindex+1; if(deletelistindex==index) {
 * wait.until(ExpectedConditions.visibilityOf(delete)).click();
 * wait.until(ExpectedConditions.visibilityOf(paygradedelete)).click(); String
 * verify=wait.until(ExpectedConditions.visibilityOf(paygradedeleteverify)).
 * getText(); System.out.println("deleting of pay grade "+verify);
 * driver.navigate().refresh(); break; }
 * 
 * }
 * 
 * } action="create"; }
 * 
 * public void createpaygrade() throws IOException { System.out.println(action);
 * if(action.equals("create")) {
 * 
 * 
 * String name=fi.getdata("Paygrade_Name");
 * wait.until(ExpectedConditions.visibilityOf(paygradeaddbutton));
 * wait.until(ExpectedConditions.elementToBeClickable(paygradeaddbutton)).click(
 * );
 * 
 * 
 * wait.until(ExpectedConditions.visibilityOf(paygradename)).sendKeys(name);
 * wait.until(ExpectedConditions.elementToBeClickable(paygradesave)).click();
 * 
 * } }
 * 
 * 
 * public void addcurrency() throws AWTException {
 * wait.until(ExpectedConditions.visibilityOf((addcurrency))).click();
 * 
 * //Note : when we got a message Element <div class=""> is //not clickable at
 * point (543,507) because //another element <div class="oxd-form-loader">
 * obscures it //we need to use below conditon to load it properly //and use
 * invisibility of element
 * 
 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(
 * "oxd-form-loader")));
 * 
 * //to debug a page to get hidden dropdown xpath //use debugger option in
 * selectorshub it will pause after 5 seconds //so we can click the required
 * dropdown in this span of time
 * 
 * wait.until(ExpectedConditions.visibilityOf((selectdropdown))).click();
 * 
 * wait.until(ExpectedConditions.visibilityOf((selectcurrency))).click();
 * 
 * wait.until(ExpectedConditions.visibilityOf((minsalary))).sendKeys("20000");
 * 
 * Robot rbt=new Robot(); rbt.delay(1000); rbt.keyPress(KeyEvent.VK_TAB);
 * rbt.keyRelease(KeyEvent.VK_TAB); rbt.keyPress(KeyEvent.VK_4);
 * rbt.keyRelease(KeyEvent.VK_4);
 * 
 * for(int i=0;i<5;i++) { rbt.keyPress(KeyEvent.VK_0);
 * rbt.keyRelease(KeyEvent.VK_0); }
 * 
 * 
 * wait.until(ExpectedConditions.elementToBeClickable(currencysave)).click();
 * 
 * String verify=
 * wait.until(ExpectedConditions.visibilityOf(currencyverify)).getText();
 * 
 * System.out.println("pay grade and currency "+verify); }
 * 
 * 
 * public boolean verify() throws IOException {
 * 
 * wait.until(ExpectedConditions.visibilityOf(jobbutton)).click();
 * wait.until(ExpectedConditions.visibilityOf(paygradesbutton)).click(); boolean
 * v=false; String title=fi.getdata("Paygrade_Name");
 * 
 * for(WebElement list : paygradelistfetch) {
 * 
 * String verify=list.getText(); if(verify.contains(title)) { v=true; break; }
 * 
 * } return v;
 * 
 * }
 * 
 * 
 * 
 * } package com.PomPage;
 * 
 * import java.io.IOException; import java.time.Duration; import java.util.List;
 * 
 * import org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement;
 * import org.openqa.selenium.support.FindBy; import
 * org.openqa.selenium.support.PageFactory; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait;
 * 
 * import com.Generic_Utils.File_Utils;
 * 
 * public class Job_Categories {
 * 
 * private WebDriver driver; private WebDriverWait wait; private String
 * action="create"; private int index=0; private File_Utils fi=new File_Utils();
 * 
 * public Job_Categories(WebDriver driver) { this.driver=driver;
 * PageFactory.initElements(driver, this); this.wait= new
 * WebDriverWait(driver,Duration.ofSeconds(10));
 * 
 * }
 * 
 * @FindBy(xpath="//span[text()='Admin']") private WebElement adminbutton;
 * 
 * @FindBy(xpath="//span[text()='Job ']") private WebElement jobbutton;
 * 
 * @FindBy(xpath="//a[text()='Job Categories']") private WebElement
 * navigatetocategorie;
 * 
 * @FindBy(xpath="//h6[text()='Job Categories']") private WebElement pageverify;
 * 
 * @FindBy(xpath="//div[@role='cell' and @style='flex-basis: 80%;']") private
 * List<WebElement> categorielistfetch;
 * 
 * @FindBy(xpath="//i[@class='oxd-icon bi-trash']") private List<WebElement>
 * deletebuttonlist;
 * 
 * @FindBy(xpath="//button[text()=' Yes, Delete ']") private WebElement
 * deletebutton;
 * 
 * @FindBy(xpath="//p[text()='Successfully Deleted']") private WebElement
 * deleteverify;
 * 
 * @FindBy(xpath="//button[text()=' Add ']") private WebElement addbutton;
 * 
 * 
 * @FindBy(xpath="//form//input[@class='oxd-input oxd-input--active']") private
 * WebElement addname;
 * 
 * @FindBy(xpath="//button[@type='submit']") private WebElement savebutton;
 * 
 * @FindBy(xpath="//p[text()='Success']") private WebElement verifysave;
 * 
 * public void navigatetoemploy() {
 * 
 * wait.until(ExpectedConditions.visibilityOf(adminbutton)).click();
 * wait.until(ExpectedConditions.visibilityOf(jobbutton)).click();
 * wait.until(ExpectedConditions.visibilityOf(navigatetocategorie)).click();
 * String
 * verify=wait.until(ExpectedConditions.visibilityOf(pageverify)).getText();
 * System.out.println(verify+" Loaded succesfully"); }
 * 
 * public void categorylistfetch() throws IOException {
 * 
 * String title=fi.getdata("Job_Categorie");
 * 
 * for(WebElement list : categorielistfetch) { index=index+1; String
 * verify=list.getText(); if(verify.contains(title)) { action="delete"; break; }
 * 
 * }
 * 
 * System.out.println("fetched the job title list succesfully"); }
 * 
 * public void deletejobcategorie() { if(action.equals("delete")) { int
 * deletelistindex=0; for(WebElement delete : deletebuttonlist) {
 * deletelistindex=deletelistindex+1; if(deletelistindex==index) {
 * wait.until(ExpectedConditions.visibilityOf(delete)).click();
 * wait.until(ExpectedConditions.visibilityOf(deletebutton)).click(); String
 * verify=wait.until(ExpectedConditions.visibilityOf(deleteverify)).getText();
 * System.out.println("deleting of job title"+verify);
 * 
 * } } } else { System.out.println("no duplicate found"); } action="create"; }
 * 
 * public void addemployeststus() throws IOException {
 * if(action.equals("create")) { String name=fi.getdata("Job_Categorie");
 * wait.until(ExpectedConditions.visibilityOf(addbutton)).click();
 * wait.until(ExpectedConditions.visibilityOf(addname)).sendKeys(name);
 * wait.until(ExpectedConditions.visibilityOf(savebutton)).click(); String
 * verify=wait.until(ExpectedConditions.visibilityOf(verifysave)).getText();
 * System.out.println("creating Job Categorie Status "+verify);
 * 
 * } }
 * 
 * public boolean verify() throws IOException {
 * wait.until(ExpectedConditions.visibilityOf(jobbutton)).click();
 * wait.until(ExpectedConditions.visibilityOf(navigatetocategorie)).click();
 * boolean v=false; String title=fi.getdata("Job_Categorie");
 * 
 * for(WebElement list : categorielistfetch) { index=index+1; String
 * verify=list.getText(); if(verify.contains(title)) { v=true; break; }
 * 
 * }
 * 
 * return v; }
 * 
 * } package com.PomPage;
 * 
 * import java.io.IOException; import java.time.Duration; import java.util.List;
 * 
 * import org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement;
 * import org.openqa.selenium.support.FindBy; import
 * org.openqa.selenium.support.PageFactory; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait;
 * 
 * import com.Generic_Utils.File_Utils;
 * 
 * public class Employement_Status { private WebDriver driver; private
 * WebDriverWait wait; private String action="create"; private int index=0;
 * private File_Utils fi=new File_Utils();
 * 
 * public Employement_Status(WebDriver driver) { this.driver=driver;
 * PageFactory.initElements(driver, this); this.wait= new
 * WebDriverWait(driver,Duration.ofSeconds(10));
 * 
 * }
 * 
 * @FindBy(xpath="//span[text()='Admin']") private WebElement adminbutton;
 * 
 * @FindBy(xpath="//span[text()='Job ']") private WebElement jobbutton;
 * 
 * @FindBy(xpath="//a[text()='Employment Status']") private WebElement
 * navigatetoemploy;
 * 
 * @FindBy(xpath="//h6[text()='Employment Status']") private WebElement
 * pageverify;
 * 
 * @FindBy(xpath="//div[@role='cell' and @style='flex-basis: 80%;']") private
 * List<WebElement> employlistfetch;
 * 
 * @FindBy(xpath="//i[@class='oxd-icon bi-trash']") private List<WebElement>
 * deletebuttonlist;
 * 
 * @FindBy(xpath="//button[text()=' Yes, Delete ']") private WebElement
 * deletebutton;
 * 
 * @FindBy(xpath="//p[text()='Successfully Deleted']") private WebElement
 * deleteverify;
 * 
 * @FindBy(xpath="//button[text()=' Add ']") private WebElement addbutton;
 * 
 * 
 * @FindBy(xpath="//form//input[@class='oxd-input oxd-input--active']") private
 * WebElement addname;
 * 
 * @FindBy(xpath="//button[@type='submit']") private WebElement savebutton;
 * 
 * @FindBy(xpath="//p[text()='Success']") private WebElement verifysave;
 * 
 * public void navigatetoemploy() {
 * 
 * wait.until(ExpectedConditions.visibilityOf(adminbutton)).click();
 * wait.until(ExpectedConditions.visibilityOf(jobbutton)).click();
 * wait.until(ExpectedConditions.visibilityOf(navigatetoemploy)).click(); String
 * verify=wait.until(ExpectedConditions.visibilityOf(pageverify)).getText();
 * System.out.println(verify+" Loaded succesfully"); }
 * 
 * public void employlistfetch() throws IOException {
 * 
 * String title=fi.getdata("Employ_Status");
 * 
 * for(WebElement list : employlistfetch) { index=index+1; String
 * verify=list.getText(); if(verify.contains(title)) { action="delete"; break; }
 * 
 * }
 * 
 * System.out.println("fetched the job title list succesfully"); }
 * 
 * public void deleteemploytitle() { if(action.equals("delete")) { int
 * deletelistindex=0; for(WebElement delete : deletebuttonlist) {
 * deletelistindex=deletelistindex+1; if(deletelistindex==index) {
 * wait.until(ExpectedConditions.visibilityOf(delete)).click();
 * wait.until(ExpectedConditions.visibilityOf(deletebutton)).click(); String
 * verify=wait.until(ExpectedConditions.visibilityOf(deleteverify)).getText();
 * System.out.println("deleting of job title"+verify);
 * 
 * } } } else { System.out.println("no duplicate found"); } action="create"; }
 * 
 * public void addemployeststus() throws IOException {
 * if(action.equals("create")) { String name=fi.getdata("Employ_Status");
 * wait.until(ExpectedConditions.visibilityOf(addbutton)).click();
 * wait.until(ExpectedConditions.visibilityOf(addname)).sendKeys(name);
 * wait.until(ExpectedConditions.visibilityOf(savebutton)).click(); String
 * verify=wait.until(ExpectedConditions.visibilityOf(verifysave)).getText();
 * System.out.println("creating Employ Status "+verify);
 * 
 * } }
 * 
 * 
 * public boolean verify() throws IOException {
 * wait.until(ExpectedConditions.visibilityOf(jobbutton)).click();
 * wait.until(ExpectedConditions.visibilityOf(navigatetoemploy)).click();
 * boolean v=false; String title=fi.getdata("Employ_Status");
 * 
 * for(WebElement list : employlistfetch) { index=index+1; String
 * verify=list.getText(); if(verify.contains(title)) { v=true; break; }
 * 
 * }
 * 
 * return v; } }
 * 
 * 
 * package com.PomPage;
 * 
 * import java.awt.AWTException; import java.awt.Robot; import
 * java.awt.event.KeyEvent; import java.io.IOException; import
 * java.time.Duration;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.JavascriptExecutor;
 * import org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement;
 * import org.openqa.selenium.support.FindBy; import
 * org.openqa.selenium.support.PageFactory; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait;
 * 
 * import com.Generic_Utils.File_Utils;
 * 
 * public class Add_Employe {
 * 
 * private WebDriver driver; private String action="create" ; private int
 * index=0; private WebDriverWait wait; private File_Utils fi=new File_Utils();
 * private JavascriptExecutor js;
 * 
 * public Add_Employe(WebDriver driver) { this.driver=driver; this.wait = new
 * WebDriverWait(driver, Duration.ofSeconds(10)); this.js = (JavascriptExecutor)
 * driver; PageFactory.initElements(driver,this);
 * 
 * }
 * 
 * 
 * @FindBy(xpath="//span[text()='PIM']") private WebElement PIMbutton;
 * 
 * @FindBy(xpath="(//input[@placeholder='Type for hints...'])[1]") private
 * WebElement employesearch;
 * 
 * @FindBy(xpath="//div[@role='option']") private WebElement employeverify;//No
 * Records Found
 * 
 * @FindBy(xpath="//button[@type='submit']") private WebElement searchbutton;
 * 
 * @FindBy(xpath="(//span[@class='oxd-text oxd-text--span'])[1]") private
 * WebElement employeverify2;
 * 
 * @FindBy(xpath="//i[@class='oxd-icon bi-trash']") private WebElement
 * deletebuttonlist;
 * 
 * @FindBy(xpath="//button[text()=' Yes, Delete ']") private WebElement
 * deletebutton;
 * 
 * @FindBy(xpath="//p[text()='Successfully Deleted']") private WebElement
 * deleteverify;
 * 
 * @FindBy(xpath="//button[text()=' Add ']") private WebElement addbutton;
 * 
 * @FindBy(xpath="//input[@name='firstName']") private WebElement firstname;
 * 
 * @FindBy(xpath="//input[@name='lastName']") private WebElement lastname;
 * 
 * @FindBy(xpath="//button[text()=' Save ']") private WebElement savebutton;
 * 
 * @FindBy(xpath="//form//button[@type='button' and @role='none']") private
 * WebElement imgbutton;
 * 
 * @FindBy(xpath="//h6[text()='Personal Details']") private WebElement
 * saveverify;
 * 
 * @FindBy(xpath="//form//input[@class='oxd-input oxd-input--active']") private
 * WebElement id;
 * 
 * @FindBy(xpath="//span[text()='PIM']") private WebElement PIMbuttofn;
 * 
 * public void navigatetoaddemploye() throws IOException, InterruptedException {
 * 
 * wait.until(ExpectedConditions.visibilityOf(PIMbutton)).click(); String
 * name=fi.getdata("Employe_Name"); String lastname=fi.getdata("Last_Name");
 * wait.until(ExpectedConditions.visibilityOf(employesearch)).sendKeys(name+" "
 * +lastname);
 * 
 * wait.until(ExpectedConditions.visibilityOf(searchbutton)).click();
 * Thread.sleep(2000); js.executeScript("arguments[0].scrollIntoView();",
 * employeverify2); wait.until(ExpectedConditions.visibilityOf(employeverify2));
 * String verifyemploye=employeverify2.getText();
 * System.out.println(verifyemploye);
 * if(verifyemploye.equals("No Records Found")) { action="create"; } else {
 * action="delete"; }
 * 
 * }
 * 
 * public void deleteemploye() { if(action.equals("delete")) {
 * //js.executeScript("arguments[0].scrollIntoView();", searchbutton);
 * //wait.until(ExpectedConditions.visibilityOf(searchbutton)).click();
 * wait.until(ExpectedConditions.visibilityOf(deletebuttonlist)).click();
 * wait.until(ExpectedConditions.visibilityOf(deletebutton)).click(); String
 * verify=wait.until(ExpectedConditions.visibilityOf(deleteverify)).getText();
 * System.out.println("deleting of Employe "+verify);
 * driver.navigate().refresh(); } action="create";
 * 
 * }
 * 
 * public void addemploye() throws IOException, InterruptedException,
 * AWTException { if(action.equals("create")) { String
 * name1=fi.getdata("Employe_Name"); String name2=fi.getdata("Last_Name");
 * String path=fi.getdata("img");
 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(
 * "oxd-toast-close-container")));
 * wait.until(ExpectedConditions.visibilityOf(addbutton)).click();
 * wait.until(ExpectedConditions.visibilityOf(firstname)).sendKeys(name1);
 * wait.until(ExpectedConditions.visibilityOf(lastname)).sendKeys(name2);
 * wait.until(ExpectedConditions.visibilityOf(id)).sendKeys("5201");
 * 
 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(
 * "oxd-form-loader")));
 * //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(
 * "oxd-toast-close-container")));
 * wait.until(ExpectedConditions.visibilityOf(imgbutton)).click(); Robot rbt=new
 * Robot(); rbt.delay(1000); rbt.keyPress(KeyEvent.VK_D);
 * rbt.keyRelease(KeyEvent.VK_D); rbt.keyPress(KeyEvent.VK_O);
 * rbt.keyRelease(KeyEvent.VK_O); rbt.keyPress(KeyEvent.VK_W);
 * rbt.keyRelease(KeyEvent.VK_W); rbt.keyPress(KeyEvent.VK_DOWN);
 * rbt.keyRelease(KeyEvent.VK_DOWN); rbt.keyPress(KeyEvent.VK_ENTER);
 * rbt.keyRelease(KeyEvent.VK_ENTER); rbt.delay(2000);
 * rbt.keyPress(KeyEvent.VK_ESCAPE); rbt.keyRelease(KeyEvent.VK_ESCAPE);
 * rbt.delay(2000);
 * wait.until(ExpectedConditions.elementToBeClickable(savebutton)).click();
 * wait.until(ExpectedConditions.visibilityOf(saveverify));
 * 
 * } }
 * 
 * @FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[4]") private
 * WebElement licensenum;
 * 
 * @FindBy(xpath="(//input[@placeholder='yyyy-dd-mm'])[1]") private WebElement
 * licenseexpiry;
 * 
 * @FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[1]")
 * private WebElement nationalism;
 * 
 * @FindBy(xpath="//span[text()='Indian']") private WebElement indian;
 * 
 * @FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[2]")
 * private WebElement martial;
 * 
 * @FindBy(xpath="//span[text()='Single']") private WebElement single;
 * 
 * @FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[6]") private
 * WebElement dob;
 * 
 * @FindBy(
 * xpath="(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[1]"
 * ) private WebElement gender;
 * 
 * @FindBy(xpath="(//button[@type='submit'])[1]") private WebElement save1;
 * 
 * 
 * 
 * public void personaldetails() throws InterruptedException {
 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(
 * "oxd-form-loader")));
 * wait.until(ExpectedConditions.visibilityOf(licensenum)).sendKeys("2356566865"
 * ); wait.until(ExpectedConditions.visibilityOf(licenseexpiry)).sendKeys(
 * "2000-03-12");
 * wait.until(ExpectedConditions.elementToBeClickable(nationalism)).click();
 * wait.until(ExpectedConditions.elementToBeClickable(indian)).click();
 * wait.until(ExpectedConditions.elementToBeClickable(martial)).click();
 * wait.until(ExpectedConditions.elementToBeClickable(single)).click();
 * wait.until(ExpectedConditions.visibilityOf(dob)).sendKeys("2000-03-12");
 * wait.until(ExpectedConditions.elementToBeClickable(gender)).click();
 * wait.until(ExpectedConditions.elementToBeClickable(save1)).click();
 * Thread.sleep(3000); js.executeScript("window.scrollBy(0,-1000)");
 * 
 * 
 * } //Note : i used nested indexes to fetch the xpath
 * 
 * @FindBy(xpath="//a[text()='Contact Details']") private WebElement
 * navigatecontact;
 * 
 * @FindBy(
 * xpath="((//div[@class='oxd-form-row'])[1]//div[@data-v-957b4417]//input[@class='oxd-input oxd-input--active'])[1]"
 * ) private WebElement street1;
 * 
 * @FindBy(
 * xpath="(//input[@data-v-1f99f73c and @class='oxd-input oxd-input--active'])[2]"
 * ) private WebElement street2;
 * 
 * @FindBy(
 * xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//div[1]//div[1]//div[3]//div[1]//div[2]//input[1]"
 * ) private WebElement city;
 * 
 * @FindBy(xpath="//div[4]//div[1]//div[2]//input[1]") private WebElement state;
 * 
 * @FindBy(xpath="//div[5]//div[1]//div[2]//input[1]") private WebElement
 * pincode;
 * 
 * @FindBy(
 * xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
 * private WebElement country;
 * 
 * @FindBy(xpath="//span[text()='India']") private WebElement india;
 * 
 * @FindBy(
 * xpath="((//div[@class='oxd-form-row'])[2]//div[@data-v-957b4417]//input[@class='oxd-input oxd-input--active'])[1]"
 * ) private WebElement home;
 * 
 * @FindBy(xpath=
 * "//div[@class='orangehrm-edit-employee-content']//div[2]//div[1]//div[2]//div[1]//div[2]//input[1]")
 * private WebElement mobile;
 * 
 * @FindBy(xpath=
 * "//div[@class='orangehrm-edit-employee-content']//div[2]//div[1]//div[3]//div[1]//div[2]//input[1]")
 * private WebElement work;
 * 
 * @FindBy(
 * xpath="((//div[@class='oxd-form-row'])[3]//div[@data-v-957b4417]//input[@class='oxd-input oxd-input--active'])[1]"
 * ) private WebElement email;
 * 
 * @FindBy(xpath="//div[3]//div[1]//div[2]//div[1]//div[2]//input[1]") private
 * WebElement email2;
 * 
 * 
 * public void contactdetails() { js.executeScript("window.scrollBy(0,-1000)");
 * 
 * 
 * wait.until(ExpectedConditions.elementToBeClickable(navigatecontact)).click();
 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(
 * "oxd-form-loader")));
 * wait.until(ExpectedConditions.visibilityOf(street1)).sendKeys("20-03-12");
 * wait.until(ExpectedConditions.visibilityOf(street2)).
 * sendKeys("10th cross road");
 * wait.until(ExpectedConditions.visibilityOf(city)).sendKeys("Nellore");
 * wait.until(ExpectedConditions.visibilityOf(state)).sendKeys("AP");
 * wait.until(ExpectedConditions.visibilityOf(pincode)).sendKeys("524002");
 * 
 * wait.until(ExpectedConditions.elementToBeClickable(country)).click();
 * wait.until(ExpectedConditions.elementToBeClickable(india)).click();
 * wait.until(ExpectedConditions.visibilityOf(home)).sendKeys("6616663666");
 * wait.until(ExpectedConditions.visibilityOf(mobile)).sendKeys("1651215215");
 * wait.until(ExpectedConditions.visibilityOf(work)).sendKeys("451165111");
 * wait.until(ExpectedConditions.visibilityOf(email)).sendKeys("AP@gmail.com");
 * wait.until(ExpectedConditions.visibilityOf(email2)).sendKeys("TN@gmail.com");
 * wait.until(ExpectedConditions.elementToBeClickable(save1)).click();
 * 
 * }
 * 
 * @FindBy(xpath="//a[text()='Job']") private WebElement navigatejob;
 * 
 * @FindBy(
 * xpath="(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]"
 * ) private WebElement jobtitle;
 * 
 * @FindBy(xpath="//span[text()='Senior Test Lead']") private WebElement
 * jobtitlebutton;
 * 
 * @FindBy(xpath=
 * "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[2]")
 * private WebElement jobcategory;
 * 
 * @FindBy(xpath="//span[text()='Test Workers']") private WebElement
 * jobcategoriebutton;
 * 
 * @FindBy(xpath="//div[7]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]")
 * private WebElement status;
 * 
 * @FindBy(xpath="//span[text()='Over-Time']") private WebElement statusbutton;
 * 
 * public void jobdetails() {
 * //js.executeScript("arguments[0].scrollIntoView();", navigatejob);
 * 
 * 
 * wait.until(ExpectedConditions.elementToBeClickable(navigatejob)).click();
 * 
 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(
 * "oxd-form-loader")));
 * 
 * wait.until(ExpectedConditions.elementToBeClickable(jobtitle)).click();
 * wait.until(ExpectedConditions.elementToBeClickable(jobtitlebutton)).click();
 * 
 * wait.until(ExpectedConditions.elementToBeClickable(jobcategory)).click();
 * wait.until(ExpectedConditions.elementToBeClickable(jobcategoriebutton)).click
 * ();
 * 
 * wait.until(ExpectedConditions.elementToBeClickable(status)).click();
 * wait.until(ExpectedConditions.elementToBeClickable(statusbutton)).click();
 * 
 * wait.until(ExpectedConditions.elementToBeClickable(save1)).click(); }
 * 
 * @FindBy(xpath="//a[text()='Salary']") private WebElement navigatesalary;
 * 
 * @FindBy(
 * xpath="//div[@class='oxd-grid-3 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//input[1]"
 * ) private WebElement salarycomponent;
 * 
 * @FindBy(xpath="//div[5]//div[1]//div[2]//input[1]") private WebElement
 * salary;
 * 
 * @FindBy(
 * xpath="(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]"
 * ) private WebElement paygrade;
 * 
 * @FindBy(xpath="//span[text()='Grade 9']") private WebElement paygradebutton;
 * 
 * @FindBy(xpath="(//button[@type='button'])[4]") private WebElement button;
 * 
 * public void salary() { js.executeScript("arguments[0].scrollIntoView();",
 * navigatesalary);
 * 
 * 
 * wait.until(ExpectedConditions.elementToBeClickable(navigatesalary)).click();
 * 
 * 
 * 
 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(
 * "oxd-form-loader")));
 * 
 * wait.until(ExpectedConditions.elementToBeClickable(button)).click();
 * wait.until(ExpectedConditions.visibilityOf(salarycomponent)).sendKeys("BASIC"
 * );
 * 
 * 
 * 
 * wait.until(ExpectedConditions.visibilityOf(salary)).sendKeys("25000");
 * 
 * wait.until(ExpectedConditions.elementToBeClickable(paygrade)).click();
 * wait.until(ExpectedConditions.elementToBeClickable(paygradebutton)).click();
 * wait.until(ExpectedConditions.elementToBeClickable(save1)).click();
 * 
 * }
 * 
 * public boolean verify() throws IOException, InterruptedException { boolean v;
 * wait.until(ExpectedConditions.visibilityOf(PIMbutton)).click(); String
 * name=fi.getdata("Employe_Name"); String lastname=fi.getdata("Last_Name");
 * wait.until(ExpectedConditions.visibilityOf(employesearch)).sendKeys(name+" "
 * +lastname);
 * 
 * wait.until(ExpectedConditions.visibilityOf(searchbutton)).click();
 * Thread.sleep(2000); js.executeScript("arguments[0].scrollIntoView();",
 * employeverify2); wait.until(ExpectedConditions.visibilityOf(employeverify2));
 * String verifyemploye=employeverify2.getText();
 * System.out.println(verifyemploye);
 * if(verifyemploye.equals("No Records Found")) { v=false; } else { v=true; }
 * return v; } } package com.PomPage;
 * 
 * import java.io.IOException; import java.time.Duration; import java.util.List;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.JavascriptExecutor;
 * import org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement;
 * import org.openqa.selenium.support.FindBy; import
 * org.openqa.selenium.support.PageFactory; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait;
 * 
 * import com.Generic_Utils.File_Utils;
 * 
 * public class Work_Shifts {
 * 
 * private WebDriver driver; private String action="create" ; private int
 * index=0; private WebDriverWait wait; private File_Utils fi=new File_Utils();
 * private JavascriptExecutor js;
 * 
 * public Work_Shifts(WebDriver driver) { this.driver=driver; this.wait = new
 * WebDriverWait(driver, Duration.ofSeconds(10)); this.js = (JavascriptExecutor)
 * driver; PageFactory.initElements(driver,this);
 * 
 * }
 * 
 * 
 * @FindBy(xpath="//span[text()='Admin']") private WebElement adminbutton;
 * 
 * @FindBy(xpath="//span[text()='Job ']") private WebElement jobbutton;
 * 
 * @FindBy(xpath="//a[text()='Work Shifts']") private WebElement
 * workshiftbutton;
 * 
 * @FindBy(xpath="//h6[text()='Work Shifts']") private WebElement pageverify;
 * 
 * @FindBy(xpath="//div[@role='cell' and @style='flex: 1 1 0%;']") private
 * List<WebElement> shiftslistfetch; //(//div[@role='cell' and @style='flex: 2 1
 * 0%;'])[2]
 * 
 * 
 * @FindBy(xpath="//i[@class='oxd-icon bi-trash']") private List<WebElement>
 * deletebuttonlist;
 * 
 * @FindBy(xpath="//button[text()=' Yes, Delete ']") private WebElement
 * deletebutton;
 * 
 * @FindBy(xpath="//p[text()='Successfully Deleted']") private WebElement
 * deleteverify;
 * 
 * 
 * @FindBy(xpath="//button[text()=' Add ']") private WebElement addbutton;
 * 
 * @FindBy(xpath="(//form//div//input[@class='oxd-input oxd-input--active'])[1]"
 * ) private WebElement addname; //here i am using parent information to avoid
 * index
 * 
 * 
 * @FindBy(xpath="(//i[@class='oxd-icon bi-clock oxd-time-input--clock'])[1]")
 * private WebElement clock1;
 * 
 * @FindBy(xpath="(//i[@class='oxd-icon bi-clock oxd-time-input--clock'])[2]")
 * private WebElement clock2;
 * 
 * @FindBy(
 * xpath="//i[@class='oxd-icon bi-chevron-down oxd-icon-button__icon oxd-time-hour-input-down']"
 * ) private WebElement hours;
 * 
 * @FindBy(
 * xpath="//i[@class='oxd-icon bi-chevron-down oxd-icon-button__icon oxd-time-minute-input-down']"
 * ) private WebElement minutes;
 * 
 * @FindBy(xpath="//input[@type='radio' and @value='AM']") private WebElement
 * am;
 * 
 * @FindBy(xpath="//input[@type='radio' and @value='PM']") private WebElement
 * pm;
 * 
 * @FindBy(xpath="//button[@type='submit']") private WebElement savebutton;
 * 
 * @FindBy(xpath="//p[text()='Success']") private WebElement verifysave;
 * 
 * @FindBy(xpath="") private WebElement button;
 * 
 * public String navigatetoworkshifts() {
 * 
 * wait.until(ExpectedConditions.visibilityOf(adminbutton)).click();
 * wait.until(ExpectedConditions.visibilityOf(jobbutton)).click();
 * wait.until(ExpectedConditions.visibilityOf(workshiftbutton)).click(); String
 * verify=wait.until(ExpectedConditions.visibilityOf(pageverify)).getText();
 * return verify; }
 * 
 * public void listfetch() throws IOException {
 * 
 * String title=fi.getdata("Shift_Name");
 * 
 * for(WebElement list : shiftslistfetch) { index=index+1; String
 * verify=list.getText(); if(verify.contains(title)) { action="delete"; break; }
 * 
 * }
 * 
 * System.out.println("fetched the shift list succesfully");
 * //System.out.println(index); //index=index/5; }
 * 
 * public void deleteshift() { if(action.equals("delete")) { int
 * deletelistindex=0; for(WebElement delete : deletebuttonlist) {
 * deletelistindex=deletelistindex+1; if(deletelistindex==index) {
 * wait.until(ExpectedConditions.visibilityOf(delete)).click();
 * wait.until(ExpectedConditions.visibilityOf(deletebutton)).click(); String
 * verify=wait.until(ExpectedConditions.visibilityOf(deleteverify)).getText();
 * System.out.println("deleting of job title"+verify);
 * 
 * } } } else { System.out.println("no duplicate found"); } action="create"; }
 * 
 * public void addshift() throws IOException, InterruptedException {
 * if(action.equals("create")) { String name=fi.getdata("Shift_Name");
 * wait.until(ExpectedConditions.visibilityOf(addbutton)).click();
 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(
 * "oxd-form-loader")));
 * wait.until(ExpectedConditions.visibilityOf(addname)).sendKeys(name);
 * wait.until(ExpectedConditions.visibilityOf(clock1)).click();
 * 
 * wait.until(ExpectedConditions.visibilityOf(hours)).click();
 * wait.until(ExpectedConditions.visibilityOf(minutes)).click();
 * 
 * wait.until(ExpectedConditions.visibilityOf(clock2)).click();
 * 
 * wait.until(ExpectedConditions.visibilityOf(hours)).click();
 * wait.until(ExpectedConditions.visibilityOf(minutes)).click();
 * 
 * wait.until(ExpectedConditions.visibilityOf(savebutton)).click(); String
 * verify=wait.until(ExpectedConditions.visibilityOf(verifysave)).getText();
 * System.out.println("creating Work Shift Status "+verify); } }
 * 
 * public boolean verify() throws IOException { boolean v=false;
 * wait.until(ExpectedConditions.visibilityOf(adminbutton)).click();
 * wait.until(ExpectedConditions.visibilityOf(jobbutton)).click();
 * wait.until(ExpectedConditions.visibilityOf(workshiftbutton)).click();
 * 
 * String title=fi.getdata("Shift_Name");
 * 
 * for(WebElement list : shiftslistfetch) { index=index+1; String
 * verify=list.getText(); if(verify.contains(title)) { v=true; break; }
 * 
 * }
 * 
 * return v; } } package build001;
 * 
 * import java.awt.AWTException; import java.io.IOException;
 * 
 * import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.firefox.FirefoxDriver; import org.testng.Assert; import
 * org.testng.annotations.AfterClass; import org.testng.annotations.AfterMethod;
 * import org.testng.annotations.AfterSuite; import
 * org.testng.annotations.AfterTest; import org.testng.annotations.BeforeClass;
 * import org.testng.annotations.BeforeMethod; import
 * org.testng.annotations.BeforeSuite; import org.testng.annotations.BeforeTest;
 * import org.testng.annotations.Test;
 * 
 * import com.Generic_Utils.File_Utils; import com.PomPage.Add_Employe; import
 * com.PomPage.Employement_Status; import com.PomPage.Job_Categories; import
 * com.PomPage.Job_Title; import com.PomPage.Login; import com.PomPage.Logout;
 * import com.PomPage.Pay_Grades; import com.PomPage.Work_Shifts;
 * 
 * public class OrangeHrmm{
 * 
 * WebDriver driver;
 * 
 * @BeforeSuite public void SetupSuite() {
 * 
 * System.out.println("setting up test suite"); }
 * 
 * 
 * @BeforeTest public void opens_Browser() { //opening browser driver=new
 * FirefoxDriver();
 * 
 * driver.manage().window().maximize(); if(driver !=null) {
 * 
 * System.out.println("Browser opened succesfully"); }
 * 
 * }
 * 
 * 
 * @BeforeClass public void pageloading() throws IOException { //loading the
 * page File_Utils fi=new File_Utils();
 * 
 * driver.get(fi.getdata("Url"));
 * 
 * String expected="OrangeHRM";
 * 
 * String Actual=driver.getTitle();
 * 
 * Assert.assertEquals(Actual, expected,"Login page not loaded succesfully"); }
 * 
 * @BeforeMethod public void login() throws IOException { File_Utils fi=new
 * File_Utils();
 * 
 * String username=fi.getdata("Login_Username"); String
 * password=fi.getdata("Login_Password");
 * 
 * Login log=new Login(driver);
 * 
 * log.logintopage(username, password);
 * 
 * boolean value=log.isdashboarddisplayed();
 * 
 * Assert.assertEquals(value, true,"Login was not succesful"); if(value==true) {
 * System.out.println("logged in"); } }
 * 
 * @Test(priority=1 ,invocationCount=0) public void jobtitle() throws
 * InterruptedException, IOException, AWTException {
 * 
 * 
 * Job_Title job=new Job_Title(driver);
 * 
 * String actual=job.navigatetojobtitle(); Assert.assertEquals(actual,
 * "Job Titles","job title page not loaded sucessfully"); Thread.sleep(5000);
 * 
 * job.jobtitlelistfetch(); job.deletejobtitle(); job.createjobtitle(); }
 * 
 * @Test(priority=2 ,invocationCount=0) public void paygrades() throws
 * IOException, AWTException { Pay_Grades paygrade=new Pay_Grades(driver);
 * 
 * paygrade.navigatetopaygrades(); paygrade.paygradeslistfetch();
 * paygrade.deletepaygrade(); paygrade.createpaygrade(); paygrade.addcurrency();
 * 
 * Assert.assertEquals(paygrade.verify(), true,"paygrade not loaded"); }
 * 
 * @Test(priority=3 ,invocationCount=0) public void Employ_Status() throws
 * IOException { Employement_Status emp=new Employement_Status(driver);
 * 
 * emp.navigatetoemploy(); emp.employlistfetch(); emp.deleteemploytitle();
 * emp.addemployeststus(); Assert.assertEquals(emp.verify(),
 * true,"employe status not loaded"); }
 * 
 * @Test(priority=4 ,invocationCount=0) public void Job_Categories() throws
 * IOException { Job_Categories job=new Job_Categories(driver);
 * 
 * job.navigatetoemploy(); job.categorylistfetch(); job.deletejobcategorie();
 * job.addemployeststus(); Assert.assertEquals(job.verify(),
 * true,"Job categorie not loaded"); }
 * 
 * @Test(priority=5 ,invocationCount=1) public void Add_Employee() throws
 * IOException, InterruptedException, AWTException { Add_Employe emp=new
 * Add_Employe(driver);
 * 
 * emp.navigatetoaddemploye(); emp.deleteemploye(); emp.addemploye();
 * emp.personaldetails(); emp.contactdetails(); emp.jobdetails(); emp.salary();
 * Assert.assertEquals(emp.verify(), true,"Job categorie not loaded");
 * 
 * }
 * 
 * @Test(priority=6 ,invocationCount=1) public void Work_Shift() throws
 * IOException, InterruptedException, AWTException { Work_Shifts work=new
 * Work_Shifts(driver);
 * 
 * work.navigatetoworkshifts(); work.listfetch(); work.deleteshift();
 * work.addshift(); Assert.assertEquals(work.verify(),
 * true,"Job categorie not loaded");
 * 
 * }
 * 
 * @AfterMethod public void loggingout() { Logout log=new Logout(driver);
 * 
 * log.perfomlogout();
 * 
 * boolean verify=log.islogindisplayed();
 * 
 * Assert.assertEquals(verify,true,"Logout was not Succesfull");
 * if(verify==true) { System.out.println("logged out"); } }
 * 
 * @AfterClass public void pagecleanup() { driver.manage().deleteAllCookies();
 * System.out.println("All cookies deleted Succesfully"); }
 * 
 * @AfterTest public void closing_browser() { if(driver !=null) { driver.quit();
 * System.out.println("Firefox Browser closed succesfully"); } }
 * 
 * @AfterSuite public void ClosingSuite() {
 * System.out.println("Closing test suite"); }
 * 
 * }
 */