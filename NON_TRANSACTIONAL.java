package RBX_PIPE;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestNG;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

public class NON_TRANSACTIONAL

{
    String my_dir = System.getProperty("user.dir");
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest test;
    WebDriver driver;
    JavascriptExecutor js;
    XSSFWorkbook ussd;
    XSSFWorkbook Onboarding;
    XSSFWorkbook Loginmodule;
    XSSFWorkbook Profile_Management;
    XSSFWorkbook Account_sub_module;
    XSSFWorkbook Card_module;
    XSSFSheet sheet;
    XSSFCell cell;

//***********************************************************************************************************************************			    
    @BeforeTest
    public void setUp()
    	{    			
        	String os = System.getProperty("os.name").toLowerCase();    			
        	if (os.contains("win"))
        	{    			    
    	System.out.println("You Are on Windows "); 			   
    	System.setProperty("webdriver.chrome.driver", my_dir + "\\Chrome\\chromedriver.exe");
        	driver = new ChromeDriver(getChromeOptions());
        	} 
        	else if 
        	(os.contains("nix") || os.contains("aix") || os.contains("nux")) 
        	{
        	    System.out.println("You Are on Linux ");
        	    System.setProperty("webdriver.chrome.driver", my_dir + "/chromedriver");
        	    System.out.println("Chrome Driver Path = " + my_dir + "/chromedriver");
        	    driver = new ChromeDriver(getChromeOptions());
        	} 
        	else 
        	{
        	    System.out.println("Not Detected");
        	}
    }
    // **************************************************************************************************************************************
    private ChromeOptions getChromeOptions()
    	{
        	final ChromeOptions options = new ChromeOptions();
        	options.addArguments("--headless");
        	options.addArguments("--window-size=1280,800");
        	return options;
      	}
    //***********************************************************************************************************************************		
    @AfterTest		
    public void tearDown() 
        	{
        	driver.quit();
        	}

//**********************************************************************************************************************************
    public static void main(String[] args) 
    	{
	TestNG testng = new TestNG();
	testng.setTestClasses(new Class[] { NON_TRANSACTIONAL.class });
	testng.run();
    	}
//**************************************************************************************************************************************
@Test(priority = 0)
@Epic("NON_TRANSACTIONAL")
@Features(value = { @Feature(value = "ONBOARDING") })
@Step ("ONBOARDING TESTCASES")
@Severity(SeverityLevel.TRIVIAL)
public void Running_Onboarding_TestCases() throws IOException, InterruptedException {
	//test =extent.createTest("(A) RUNNING ONBOARDING TESTCASES");
	System.out.println("NON-TRANSACTIONAL TESTS");
	System.out.println("It contains Five Number of Modules");
	System.out.println("*************************(A) RUNNING ONBOARDING TESTCASES***********************************");
	System.out.println("Total Number of Test cases = 11 ");
    }

    // **********************************************************************************************************************************

    @Test(priority = 1)   
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "ONBOARDING") })
    @Step ("Verify_whether_customer_can_click_on_register")
    @Severity(SeverityLevel.MINOR)
    public void Verify_whether_customer_can_click_on_register() throws InterruptedException {
	//test =extent.createTest(" 1 Verify_whether_customer_can_click_on_register (ONBOARDING)");
	driver.get("http://172.16.19.161:50002/iportalweb/iRetail@1");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//mat-card")).click();
	// ************************************************************************************************************************
	if (driver.getPageSource().contains("First Name")) {
	    System.out.println("TC1 Verify- Customer Can Click On Register | Pass");
	} else {
	    System.out.println("TC1 FAILED: Verify- Customer Can Click On Register ");
	}
	// *************************************************************************************************************************
	driver.findElement(By.xpath("//button[2]")).click();
    }

    // **********************************************************************************************************************************
    @Test(priority = 2)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "ONBOARDING") })
    @Severity(SeverityLevel.MINOR)
    @Step ("Verify_whether_error_is_thrown_when_mandatory_names_are_not_entered")
    public void Verify_whether_error_is_thrown_when_mandatory_names_are_not_entered() {
	//test =extent.createTest(" 2 Verify_whether_error_is_thrown_when_mandatory_names_are_not_entered (ONBOARDING)");
	driver.findElement(By.xpath("//mat-card")).click();
	// Mandatory names are not entered
	driver.findElement(By.xpath("//button[contains(.,\'Next\')]")).click();
	{
	    List<WebElement> elements = driver
		    .findElements(By.xpath("//mat-error[contains(.,\'Please enter your first name\')]"));
	    assert (elements.size() > 0);
	}
	{
	    List<WebElement> elements = driver
		    .findElements(By.xpath("//mat-error[contains(.,\'Please enter your last name\')]"));
	    assert (elements.size() > 0);
	}
	// ************************************************************************************************************************
	if (driver.getPageSource().contains("Please enter your first name")) {
	    System.out.println("TC2 Verify- Error is Thrown when mandatory names are not entered |Success: Pass");
	} else {
	    System.out.println("TC2 FAILED: Verify- Error is Thrown when mandatory names are not entered ");
	}
	// *************************************************************************************************************************
	driver.findElement(By.xpath("//button[2]")).click();
    }

    // **********************************************************************************************************************************
    @Test(priority = 3)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "ONBOARDING") })
    @Step ("Verify_whether_a_user_can_enter_first_name")
    public void Verify_whether_a_user_can_enter_first_name() throws IOException {
	//test =extent.createTest(" 3 Verify_whether_a_user_can_enter_first_name (ONBOARDING)");
	driver.findElement(By.xpath("//mat-card")).click();
	driver.findElement(By.cssSelector("h5")).click();
	// Enter first name
	// **************************************************************************
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);
	Onboarding = new XSSFWorkbook(fis);
	sheet = Onboarding.getSheetAt(0);
	for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	    cell = sheet.getRow(1).getCell(0);
	}
	driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]"))
		.sendKeys(cell.getStringCellValue());
	System.out.println("TC3 Verify- A user can enter first name | Input First Name = " + cell.getStringCellValue());
	driver.findElement(By.xpath("//button[2]")).click();
    }

    // **********************************************************************************************************************************
    @Test(priority = 4) 
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "ONBOARDING") })
    @Step ("Verify_whether_a_user_can_enter_Middle_name")
    public void Verify_whether_a_user_can_enter_Middle_name() throws IOException {
	//test =extent.createTest(" 4 Verify_whether_a_user_can_enter_Middle_name (ONBOARDING)");
	driver.findElement(By.xpath("//mat-card")).click();
	// Enter first name
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);
	Onboarding = new XSSFWorkbook(fis);
	sheet = Onboarding.getSheetAt(0);
	for (int i = 1; i <= sheet.getLastRowNum(); i++)
	    cell = sheet.getRow(1).getCell(0);
	driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]"))
		.sendKeys(cell.getStringCellValue());
	// Enter middle name
	cell = sheet.getRow(1).getCell(1);
	driver.findElement(By.xpath("//input[contains(@placeholder,'Middle Name')]")).click();
	driver.findElement(By.xpath("//input[contains(@placeholder,'Middle Name')]"))
		.sendKeys(cell.getStringCellValue());
	System.out
		.println("TC4 Verify- A user can enter Middle name | Input middle Name = " + cell.getStringCellValue());
	driver.findElement(By.xpath("//button[2]")).click();
    }

    // **********************************************************************************************************************************
    @Test(priority = 5) 
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "ONBOARDING") })
    @Step ("Verify_whether_a_user_can_enter_last_name")
    public void Verify_whether_a_user_can_enter_last_name() throws IOException {
	//test =extent.createTest(" 5 Verify_whether_a_user_can_enter_last_name (ONBOARDING)");
	driver.findElement(By.xpath("//mat-card")).click();
	// Enter first name
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);
	Onboarding = new XSSFWorkbook(fis);
	sheet = Onboarding.getSheetAt(0);
	for (int i = 1; i <= sheet.getLastRowNum(); i++)
	    cell = sheet.getRow(1).getCell(0);
	driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]")).click();
	driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]"))
		.sendKeys(cell.getStringCellValue());
	// Enter middle name
	cell = sheet.getRow(1).getCell(1);
	driver.findElement(By.xpath("//input[contains(@placeholder,'Middle Name')]")).click();
	driver.findElement(By.xpath("//input[contains(@placeholder,'Middle Name')]"))
		.sendKeys(cell.getStringCellValue());
	// Enter last name
	cell = sheet.getRow(1).getCell(2);
	driver.findElement(By.xpath("//input[contains(@placeholder,'Last Name')]")).click();
	driver.findElement(By.xpath("//input[contains(@placeholder,'Last Name')]")).sendKeys(cell.getStringCellValue());
	System.out.println("TC5 Verify- A user can enter last name | Input last Name = " + cell.getStringCellValue());
	driver.findElement(By.xpath("//button[2]")).click();
    }

    // **********************************************************************************************************************************
    @Test(priority = 6)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "ONBOARDING") })
    @Step ("Verify_whether_a_datepicker_is_functional_whens_electing_DOB")
    public void Verify_whether_a_datepicker_is_functional_whens_electing_DOB() throws IOException {
	//test =extent.createTest(" 6 Verify_whether_a_datepicker_is_functional_whens_electing_DOB (ONBOARDING)");
	driver.findElement(By.xpath("//mat-card")).click();
	// Enter first name,second name, last name
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);
	Onboarding = new XSSFWorkbook(fis);
	sheet = Onboarding.getSheetAt(0);
	for (int i = 1; i <= sheet.getLastRowNum(); i++)
	    cell = sheet.getRow(1).getCell(0);
	driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]")).click();
	driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]"))
		.sendKeys(cell.getStringCellValue());
	cell = sheet.getRow(1).getCell(1);
	driver.findElement(By.xpath("//input[contains(@placeholder,'Middle Name')]")).click();
	driver.findElement(By.xpath("//input[contains(@placeholder,'Middle Name')]"))
		.sendKeys(cell.getStringCellValue());
	cell = sheet.getRow(1).getCell(2);
	driver.findElement(By.xpath("//input[contains(@placeholder,'Last Name')]")).click();
	driver.findElement(By.xpath("//input[contains(@placeholder,'Last Name')]")).sendKeys(cell.getStringCellValue());
	driver.findElement(By.xpath("//input[contains(@placeholder,'Last Name')]")).sendKeys(Keys.ENTER);
	// select on the datepicker
	driver.findElement(By.cssSelector(".pre-mat-cam")).click();
	driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).click();
	driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).sendKeys("1");
	driver.findElement(By.cssSelector(".otp-input:nth-child(2)")).sendKeys("9");
	driver.findElement(By.cssSelector(".otp-input:nth-child(3)")).sendKeys("9");
	driver.findElement(By.cssSelector(".otp-input:nth-child(4)")).sendKeys("0");
	driver.findElement(By.cssSelector(".col-2:nth-child(3) > div")).click();
	driver.findElement(By.cssSelector(".col-sm-1:nth-child(5)")).click();
	driver.findElement(By.cssSelector(".btn")).click();
	// driver.findElement(By.cssSelector(".mobile-hide")).click();
	System.out.println("TC6 Verify- A user can user datepicker when selecting DOB| DOB Is Selected");
	driver.findElement(By.xpath("//button[2]")).click();
    }

    // **********************************************************************************************************************************
    @Test(priority = 7) 
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "ONBOARDING") })
    @Step ("Verify_whether_a_user_can_select_gender")
    public void Verify_whether_a_user_can_select_gender() throws IOException, InterruptedException {
	//test =extent.createTest(" 7 Verify_whether_a_user_can_select_gender (ONBOARDING)");
	driver.findElement(By.xpath("//mat-card")).click();
	// Enter first name,second name, last name
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);
	Onboarding = new XSSFWorkbook(fis);
	sheet = Onboarding.getSheetAt(0);
	for (int i = 1; i <= sheet.getLastRowNum(); i++)
	    cell = sheet.getRow(1).getCell(0);
	driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]")).click();
	driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]"))
		.sendKeys(cell.getStringCellValue());
	cell = sheet.getRow(1).getCell(1);
	driver.findElement(By.xpath("//input[contains(@placeholder,'Middle Name')]")).click();
	driver.findElement(By.xpath("//input[contains(@placeholder,'Middle Name')]"))
		.sendKeys(cell.getStringCellValue());
	cell = sheet.getRow(1).getCell(2);
	driver.findElement(By.xpath("//input[contains(@placeholder,'Last Name')]")).click();
	driver.findElement(By.xpath("//input[contains(@placeholder,'Last Name')]")).sendKeys(cell.getStringCellValue());
	driver.findElement(By.xpath("//input[contains(@placeholder,'Last Name')]")).sendKeys(Keys.ENTER);
	// Datepiker
	driver.findElement(By.cssSelector(".pre-mat-cam")).click();
	driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).click();
	driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).sendKeys("1");
	driver.findElement(By.cssSelector(".otp-input:nth-child(2)")).sendKeys("9");
	driver.findElement(By.cssSelector(".otp-input:nth-child(3)")).sendKeys("9");
	driver.findElement(By.cssSelector(".otp-input:nth-child(4)")).sendKeys("0");
	driver.findElement(By.cssSelector(".col-2:nth-child(10) > div")).click();
	driver.findElement(By.cssSelector(".col-sm-1:nth-child(6) > .date")).click();
	// Select on gender
	driver.findElement(By.cssSelector(".btn")).click();
	driver.findElement(By.xpath("//span[contains(.,'Gender')]")).click();
	driver.findElement(By.xpath("//mat-option[contains(.,'Male')]")).click();
	// driver.findElement(By.cssSelector(".mobile-hide")).click();
	System.out.println("TC7 Verify- A user can select Gender | Gender selected");
	driver.findElement(By.xpath("//button[2]")).click();
    }

    // **********************************************************************************************************************************
    @Test(priority = 8) 
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "ONBOARDING") })
    @Step ("Verify_whether_a_user_can_enter_mobile_number")
    public void Verify_whether_a_user_can_enter_mobile_number() throws IOException {
	//test =extent.createTest(" 8 Verify_whether_a_user_can_enter_mobile_number (ONBOARDING)");
	driver.findElement(By.xpath("//mat-card")).click();
	// Enter first name,second name, last name
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);
	Onboarding = new XSSFWorkbook(fis);
	sheet = Onboarding.getSheetAt(0);
	for (int i = 1; i <= sheet.getLastRowNum(); i++)
	    cell = sheet.getRow(1).getCell(0);
	driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]")).click();
	driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]"))
		.sendKeys(cell.getStringCellValue());
	cell = sheet.getRow(1).getCell(1);
	driver.findElement(By.xpath("//input[contains(@placeholder,'Middle Name')]")).click();
	driver.findElement(By.xpath("//input[contains(@placeholder,'Middle Name')]"))
		.sendKeys(cell.getStringCellValue());
	cell = sheet.getRow(1).getCell(2);
	driver.findElement(By.xpath("//input[contains(@placeholder,'Last Name')]")).click();
	driver.findElement(By.xpath("//input[contains(@placeholder,'Last Name')]")).sendKeys(cell.getStringCellValue());
	driver.findElement(By.xpath("//input[contains(@placeholder,'Last Name')]")).sendKeys(Keys.ENTER);
	// Datepiker
	driver.findElement(By.cssSelector(".pre-mat-cam")).click();
	driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).click();
	driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).sendKeys("1");
	driver.findElement(By.cssSelector(".otp-input:nth-child(2)")).sendKeys("9");
	driver.findElement(By.cssSelector(".otp-input:nth-child(3)")).sendKeys("9");
	driver.findElement(By.cssSelector(".otp-input:nth-child(4)")).sendKeys("0");
	driver.findElement(By.cssSelector(".col-2:nth-child(10) > div")).click();
	driver.findElement(By.cssSelector(".col-sm-1:nth-child(6) > .date")).click();
	// Select on gender
	driver.findElement(By.cssSelector(".btn")).click();
	driver.findElement(By.xpath("//span[contains(.,'Gender')]")).click();
	driver.findElement(By.xpath("//mat-option[contains(.,'Male')]")).click();
	// Enter mobile number
	cell = sheet.getRow(1).getCell(5);
	driver.findElement(By.cssSelector(".intl-tel-input > .ng-untouched")).click();
	driver.findElement(By.cssSelector(".intl-tel-input > .ng-untouched")).sendKeys(cell.getStringCellValue());
	System.out.println("TC8 Verify- A User can Enter Mobile Number | Mobile Number = " + cell.getStringCellValue());
    }

    // *********************************************************************************************************************************
    @Test(priority = 9)  
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "ONBOARDING") })
    @Step ("Verify_whether_a_user_can_enter_email_address")
    public void Verify_whether_a_user_can_enter_email_address() throws IOException {
	//test =extent.createTest(" 9 Verify_whether_a_user_can_enter_email_address (ONBOARDING)");
	driver.findElement(By.xpath("//button[2]")).click();
	driver.findElement(By.xpath("//mat-card")).click();
	// Enter first name,second name, last name
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);
	Onboarding = new XSSFWorkbook(fis);
	sheet = Onboarding.getSheetAt(0);
	for (int i = 1; i <= sheet.getLastRowNum(); i++)
	    cell = sheet.getRow(1).getCell(0);
	driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]")).click();
	driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]"))
		.sendKeys(cell.getStringCellValue());
	cell = sheet.getRow(1).getCell(1);
	driver.findElement(By.xpath("//input[contains(@placeholder,'Middle Name')]")).click();
	driver.findElement(By.xpath("//input[contains(@placeholder,'Middle Name')]"))
		.sendKeys(cell.getStringCellValue());
	cell = sheet.getRow(1).getCell(2);
	driver.findElement(By.xpath("//input[contains(@placeholder,'Last Name')]")).click();
	driver.findElement(By.xpath("//input[contains(@placeholder,'Last Name')]")).sendKeys(cell.getStringCellValue());
	driver.findElement(By.xpath("//input[contains(@placeholder,'Last Name')]")).sendKeys(Keys.ENTER);
	// Datepiker
	driver.findElement(By.cssSelector(".pre-mat-cam")).click();
	driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).click();
	driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).sendKeys("1");
	driver.findElement(By.cssSelector(".otp-input:nth-child(2)")).sendKeys("9");
	driver.findElement(By.cssSelector(".otp-input:nth-child(3)")).sendKeys("9");
	driver.findElement(By.cssSelector(".otp-input:nth-child(4)")).sendKeys("0");
	driver.findElement(By.cssSelector(".col-2:nth-child(10) > div")).click();
	driver.findElement(By.cssSelector(".col-sm-1:nth-child(6) > .date")).click();
	// Select on gender
	driver.findElement(By.cssSelector(".btn")).click();
	driver.findElement(By.xpath("//span[contains(.,'Gender')]")).click();
	driver.findElement(By.xpath("//mat-option[contains(.,'Male')]")).click();
	// Enter mobile number
	cell = sheet.getRow(1).getCell(5);
	driver.findElement(By.cssSelector(".intl-tel-input > .ng-untouched")).click();
	driver.findElement(By.cssSelector(".intl-tel-input > .ng-untouched")).sendKeys(cell.getStringCellValue());
	// Enter email address
	cell = sheet.getRow(1).getCell(3);
	driver.findElement(By.cssSelector(".ng-star-inserted:nth-child(3) > .nopadding")).click();
	driver.findElement(By.xpath("//input[contains(@formcontrolname,'EMAIL_ID')]"))
		.sendKeys(cell.getStringCellValue());
	System.out.println("TC9 Verify- A User can Enter Email Adress | Input Email-Id = " + cell.getStringCellValue());
    }

    // *******************************************************************************************************************************
    @Test(priority = 10) 
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "ONBOARDING") })
    @Step ("Verify_whether_a_user_can_select_ID_type")
    public void Verify_whether_a_user_can_select_ID_type() throws IOException {
	//test =extent.createTest(" 10 Verify_whether_a_user_can_select_ID_type (ONBOARDING)");
	driver.findElement(By.xpath("//button[contains(.,'Cancelclose')]")).click();
	driver.findElement(By.xpath("//mat-card")).click();
	// Enter first name,second name, last name
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);
	Onboarding = new XSSFWorkbook(fis);
	sheet = Onboarding.getSheetAt(0);
	for (int i = 1; i <= sheet.getLastRowNum(); i++)
	    cell = sheet.getRow(1).getCell(0);
	driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]")).click();
	driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]"))
		.sendKeys(cell.getStringCellValue());
	cell = sheet.getRow(1).getCell(1);
	driver.findElement(By.xpath("//input[contains(@placeholder,'Middle Name')]")).click();
	driver.findElement(By.xpath("//input[contains(@placeholder,'Middle Name')]"))
		.sendKeys(cell.getStringCellValue());
	cell = sheet.getRow(1).getCell(2);
	driver.findElement(By.xpath("//input[contains(@placeholder,'Last Name')]")).click();
	driver.findElement(By.xpath("//input[contains(@placeholder,'Last Name')]")).sendKeys(cell.getStringCellValue());
	driver.findElement(By.xpath("//input[contains(@placeholder,'Last Name')]")).sendKeys(Keys.ENTER);
	// Datepiker
	driver.findElement(By.cssSelector(".pre-mat-cam")).click();
	driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).click();
	driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).sendKeys("1");
	driver.findElement(By.cssSelector(".otp-input:nth-child(2)")).sendKeys("9");
	driver.findElement(By.cssSelector(".otp-input:nth-child(3)")).sendKeys("9");
	driver.findElement(By.cssSelector(".otp-input:nth-child(4)")).sendKeys("0");
	driver.findElement(By.cssSelector(".col-2:nth-child(10) > div")).click();
	driver.findElement(By.cssSelector(".col-sm-1:nth-child(6) > .date")).click();
	// Select on gender
	driver.findElement(By.cssSelector(".btn")).click();
	driver.findElement(By.xpath("//span[contains(.,'Gender')]")).click();
	driver.findElement(By.xpath("//mat-option[contains(.,'Male')]")).click();
	// Enter mobile number
	cell = sheet.getRow(1).getCell(5);
	driver.findElement(By.cssSelector(".intl-tel-input > .ng-untouched")).click();
	driver.findElement(By.cssSelector(".intl-tel-input > .ng-untouched")).sendKeys(cell.getStringCellValue());
	// Enter email address
	cell = sheet.getRow(1).getCell(3);
	driver.findElement(By.cssSelector(".ng-star-inserted:nth-child(3) > .nopadding")).click();
	driver.findElement(By.xpath("//input[contains(@formcontrolname,'EMAIL_ID')]"))
		.sendKeys(cell.getStringCellValue());
	driver.findElement(By.xpath("//input[contains(@formcontrolname,'EMAIL_ID')]")).sendKeys(Keys.ENTER);	
	driver.findElement(By.cssSelector(".mat-select-placeholder")).click();	
	System.out.println("TC10 Verify- A user Can Select On Id type Dropdown Menu | ID Type Selected");
    }

    // **********************************************************************************************************************************
    @Test(priority = 11)  
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "ONBOARDING") })
    @Step ("Verify_whether_a_user_can_enter_ID_number")
    public void Verify_whether_a_user_can_enter_ID_number() throws IOException {
	//test =extent.createTest(" 11 Verify_whether_a_user_can_enter_ID_number (ONBOARDING)");
	driver.findElement(By.xpath("//button[contains(.,'Cancelclose')]")).click();
	driver.findElement(By.xpath("//mat-card")).click();
	// Enter first name,second name, last name
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);
	Onboarding = new XSSFWorkbook(fis);
	sheet = Onboarding.getSheetAt(0);
	for (int i = 1; i <= sheet.getLastRowNum(); i++)
	    cell = sheet.getRow(1).getCell(0);
	driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]")).click();
	driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]"))
		.sendKeys(cell.getStringCellValue());
	cell = sheet.getRow(1).getCell(1);
	driver.findElement(By.xpath("//input[contains(@placeholder,'Middle Name')]")).click();
	driver.findElement(By.xpath("//input[contains(@placeholder,'Middle Name')]"))
		.sendKeys(cell.getStringCellValue());
	cell = sheet.getRow(1).getCell(2);
	driver.findElement(By.xpath("//input[contains(@placeholder,'Last Name')]")).click();
	driver.findElement(By.xpath("//input[contains(@placeholder,'Last Name')]")).sendKeys(cell.getStringCellValue());
	driver.findElement(By.xpath("//input[contains(@placeholder,'Last Name')]")).sendKeys(Keys.ENTER);
	// Datepiker
	driver.findElement(By.cssSelector(".pre-mat-cam")).click();
	driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).click();
	driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).sendKeys("1");
	driver.findElement(By.cssSelector(".otp-input:nth-child(2)")).sendKeys("9");
	driver.findElement(By.cssSelector(".otp-input:nth-child(3)")).sendKeys("9");
	driver.findElement(By.cssSelector(".otp-input:nth-child(4)")).sendKeys("0");
	driver.findElement(By.cssSelector(".col-2:nth-child(10) > div")).click();
	driver.findElement(By.cssSelector(".col-sm-1:nth-child(6) > .date")).click();
	// Select on gender
	driver.findElement(By.cssSelector(".btn")).click();
	driver.findElement(By.xpath("//span[contains(.,'Gender')]")).click();
	driver.findElement(By.xpath("//mat-option[contains(.,'Male')]")).click();
	// Enter mobile number
	cell = sheet.getRow(1).getCell(5);
	driver.findElement(By.cssSelector(".intl-tel-input > .ng-untouched")).click();
	driver.findElement(By.cssSelector(".intl-tel-input > .ng-untouched")).sendKeys(cell.getStringCellValue());
	// Enter email address
	cell = sheet.getRow(1).getCell(3);
	driver.findElement(By.cssSelector(".ng-star-inserted:nth-child(3) > .nopadding")).click();
	driver.findElement(By.xpath("//input[contains(@formcontrolname,'EMAIL_ID')]"))
		.sendKeys(cell.getStringCellValue());
	driver.findElement(By.xpath("//input[contains(@formcontrolname,'EMAIL_ID')]")).sendKeys(Keys.ENTER);	
	driver.findElement(By.xpath("//div[@class='mat-select-value'][contains(.,'ID Type')]")).click();
	driver.findElement(By.xpath("//span[@class='mat-option-text'][contains(.,'National ID')]")).click();
	// Enter id/pasport number
	cell = sheet.getRow(1).getCell(4);
	driver.findElement(By.xpath("//input[contains(@placeholder,'National ID Number')]")).click();
	driver.findElement(By.xpath("//input[contains(@placeholder,'National ID Number')]")).sendKeys(cell.getStringCellValue());
	System.out.println("TC11 Verify- A User Can Enter ID Number | Input ID Number = " + cell.getStringCellValue()+ " Sucessful");
    }

    // **********************************************************************************************************************************
    @Test(priority = 12)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "ONBOARDING") })
    @Step ("End_of_Onboarding_TestCases")
    @Severity(SeverityLevel.TRIVIAL)
    public void End_of_Onboarding_TestCases() throws IOException, InterruptedException {
	//test =extent.createTest("END OF ONBOARDING TESTCASES");
	System.out.println("*************************End Of Onboarding Testcases***********************************");
    }

    // **********************************************************************************************************************************
    // **********************************************************************************************************************************
    @Test(priority = 13) 
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "LOGIN LOGOUT") }) 
    @Step ("LOGIN LOGOUT")
    @Severity(SeverityLevel.TRIVIAL)
    public void Running_Login_logout_TestCases() throws IOException, InterruptedException {
	//test =extent.createTest("(B) RUNNING LOGIN LOGOUT TESTCASES");
	System.out.println("*************************(B) RUNNING LOGIN LOGOUT TESTCASES***********************************");
	System.out.println("Total Number of Test cases = 11 ");
    }

    // **********************************************************************************************************************************
    @Test(priority = 14)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "LOGIN LOGOUT") })
    @Step ("Verify_that_user_can_select_the_forgot_username_link_option")
    @Severity(SeverityLevel.MINOR)
    public void Verify_that_user_can_select_the_forgot_username_link_option() throws IOException {
	//test =extent.createTest(" 1 Verify_that_user_can_select_the_forgot_username_link_option (LOGIN LOGOUT)");
	driver.get("http://172.16.19.161:50002/iportalweb/iRetail@1");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 driver.findElement(By.linkText("Forgot username?")).click();
	 driver.findElement(By.cssSelector(".mat-select-placeholder")).click();
	 driver.findElement(By.cssSelector("#mat-option-0 > .mat-option-text")).click();
	 File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	 FileInputStream fis = new FileInputStream(src);
	 Loginmodule = new XSSFWorkbook(fis);
	 sheet = Loginmodule.getSheetAt(0);
	 for (int i = 1; i <= sheet.getLastRowNum(); i++)
				  cell = sheet.getRow(1).getCell(4);
	 driver.findElement(By.id("mat-input-2")).click();
	 driver.findElement(By.id("mat-input-2")).sendKeys(cell.getStringCellValue());
	 // Enter mobile number
	 driver.findElement(By.cssSelector(".intl-tel-input > .ng-untouched")).click();
	 driver.findElement(By.cssSelector(".intl-tel-input > .ng-untouched")).sendKeys(
								"0723100200");
	 driver.findElement(By.xpath("//span[contains(.,\'Next\')]")).click();
	 // use date picker
	 driver.findElement(By.xpath("//mat-icon[contains(.,\'calendar_today\')]")).click();
	 driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).click();
	 driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).sendKeys("1");
	 driver.findElement(By.cssSelector(".otp-input:nth-child(2)")).sendKeys("9");
	 driver.findElement(By.cssSelector(".otp-input:nth-child(3)")).sendKeys("9");
	 driver.findElement(By.cssSelector(".otp-input:nth-child(4)")).sendKeys("0");
	 driver.findElement(By.cssSelector(".col-2:nth-child(3) > div")).click();
	 driver.findElement(By.cssSelector(".col-sm-1:nth-child(5) > .date")).click();
	 driver.findElement(By.cssSelector(".btn")).click();
	 cell = sheet.getRow(1).getCell(3);
	 driver.findElement(By.id("mat-input-4")).click();
	 driver.findElement(By.id("mat-input-4")).sendKeys(cell.getStringCellValue());
	System.out.println("TC1 Verify- user can select the forgot username link option |Success:");
    }    

    // *****************************************************************************************************************************
    @Test(priority = 15) 
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "LOGIN LOGOUT") })
    @Step ("Verify_that_user_can_select_the_forgot_password_link_option")
    public void Verify_that_user_can_select_the_forgot_password_link_option() throws IOException {
	//test =extent.createTest(" 2 Verify_that_user_can_select_the_forgot_password_link_option (LOGIN LOGOUT)");
	driver.get("http://172.16.19.161:50002/iportalweb/iRetail@1");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	// password link
	driver.findElement(By.linkText("Forgot password?")).click();
	driver.findElement(By.cssSelector(".mat-select-placeholder")).click();
	driver.findElement(By.cssSelector("#mat-option-0 > .mat-option-text")).click();
	// enter id number
	cell = sheet.getRow(1).getCell(4);
	driver.findElement(By.id("mat-input-2")).click();
	driver.findElement(By.id("mat-input-2")).sendKeys(cell.getStringCellValue());
	// enter mobile number
	driver.findElement(By.cssSelector(".intl-tel-input > .ng-untouched")).click();
	driver.findElement(By.cssSelector(".intl-tel-input > .ng-untouched")).sendKeys("0723100200");
	driver.findElement(By.xpath("//span[contains(.,\'Next\')]")).click();
	// select on calender
	driver.findElement(By.xpath("//mat-icon[contains(.,\'calendar_today\')]")).click();
	driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).click();
	driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).sendKeys("1");
	driver.findElement(By.cssSelector(".otp-input:nth-child(2)")).sendKeys("9");
	driver.findElement(By.cssSelector(".otp-input:nth-child(3)")).sendKeys("9");
	driver.findElement(By.cssSelector(".otp-input:nth-child(4)")).sendKeys("0");
	driver.findElement(By.cssSelector(".col-2:nth-child(3) > div")).click();
	driver.findElement(By.cssSelector(".col-sm-1:nth-child(5) > .date")).click();
	driver.findElement(By.cssSelector(".btn")).click();
	// enter email adress
	cell = sheet.getRow(1).getCell(3);
	driver.findElement(By.id("mat-input-4")).click();
	driver.findElement(By.id("mat-input-4")).sendKeys(cell.getStringCellValue());
	System.out.println("TC2 Verify- user can select the forgot password link option | Success:");
    }

    // ***********************************************************************************************************************************
    @Test(priority = 16)   
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "LOGIN LOGOUT") })
    @Step ("Verify_whether_a_user_can_use_hides_or_show_password")
    public void Verify_whether_a_user_can_use_hides_or_show_password() throws IOException {
	//test =extent.createTest(" 3 Verify_whether_a_user_can_use_hides_or_show_password (LOGIN LOGOUT)");
	driver.get("http://172.16.19.161:50002/iportalweb/iRetail@1");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	
	driver.findElement(By.id("mat-input-0")).click();
	driver.findElement(By.id("mat-input-0")).sendKeys("sadetty");
	driver.findElement(By.id("mat-input-1")).sendKeys("234324234");
	driver.findElement(By.cssSelector(".pre-mat-cam")).click();
	driver.findElement(By.cssSelector(".pre-mat-cam")).click();
	// show hide button
	driver.findElement(By.cssSelector(".pre-mat-cam")).click();
	driver.findElement(By.cssSelector(".pre-mat-cam")).click();
	System.out.println("TC3 Verify- System_can_use_hides_or_show_passwod |Success: ");
    }

    // ******************************************************************************************************************************
    @Test(priority = 17)  
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "LOGIN LOGOUT") })
    @Step ("Verify_whether_error_message_is_thrown_if_user_do_not_enter_Username")
    public void Verify_whether_error_message_is_thrown_if_user_do_not_enter_Username() throws IOException {
	//test =extent.createTest(" 4 Verify_whether_error_message_is_thrown_if_user_do_not_enter_Username (LOGIN LOGOUT)");
	driver.get("http://172.16.19.161:50002/iportalweb/iRetail@1");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	
	// Enter password without username
	driver.findElement(By.id("mat-input-1")).click();
	driver.findElement(By.id("mat-input-1")).sendKeys("43444");
	driver.findElement(By.id("mat-input-1")).sendKeys(Keys.ENTER);
	// Error code
	{
	    List<WebElement> elements = driver.findElements(By.id("mat-error-1"));
	    assert (elements.size() > 0);
	}
	System.out.println("TC4 Verify- Error is Thrown  if user do not enter Username |Success:");
    }

    // ******************************************************************************************************************************
    @Test(priority = 18)  
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "LOGIN LOGOUT") })
    @Step ("Verify_whether_error_message_is_thrown_if_user_do_not_enter_Password")
    public void Verify_whether_error_message_is_thrown_if_user_do_not_enter_Password() throws IOException {
	//test =extent.createTest(" 5 Verify_whether_error_message_is_thrown_if_user_do_not_enter_Password (LOGIN LOGOUT)");
	driver.get("http://172.16.19.161:50002/iportalweb/iRetail@1");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	
	// Enter username without password
	driver.findElement(By.id("mat-input-0")).click();
	driver.findElement(By.id("mat-input-0")).sendKeys("sadetty");
	driver.findElement(By.id("mat-input-0")).sendKeys(Keys.ENTER);
	// Error code
	{
	    List<WebElement> elements = driver.findElements(By.id("mat-error-2"));
	    assert (elements.size() > 0);
	}
	System.out.println("TC5 Verify- Error is Thrown if user do not enter Password |Success:");
    }

    // ********************************************************************************************************************************
    @Test(priority = 19)  
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "LOGIN LOGOUT") })
    @Step ("Verify_whether_a_user_can_use_OTP")
    public void Verify_whether_a_user_can_use_OTP() throws IOException, InterruptedException {
	//test =extent.createTest(" 6 Verify_whether_a_user_can_use_OTP (LOGIN LOGOUT)");
	driver.get("http://172.16.19.161:50002/iportalweb/iRetail@1");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 // enter username
	 // **********************************************************************************************************************
	 File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	 FileInputStream fis = new FileInputStream(src);
	 Loginmodule = new XSSFWorkbook(fis);
	 sheet = Loginmodule.getSheet("Loginmodule");
	 for (int i = 1; i <= sheet.getLastRowNum(); i++)
				  // *****************************************************************************************************************
				  cell = sheet.getRow(1).getCell(0);
	 driver.findElement(By.id("mat-input-0")).click();
	 driver.findElement(By.id("mat-input-0")).sendKeys(cell.getStringCellValue());
	 // enter password
	 cell = sheet.getRow(1).getCell(1);
	 driver.findElement(By.id("mat-input-1")).click();
	 driver.findElement(By.id("mat-input-1")).sendKeys(cell.getStringCellValue());
	 driver.findElement(By.id("mat-input-1")).sendKeys(Keys.ENTER);
	 Thread.sleep(4000);
	 driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).sendKeys("3");
	 driver.findElement(By.cssSelector(".otp-input:nth-child(2)")).sendKeys("3");
	 driver.findElement(By.cssSelector(".otp-input:nth-child(3)")).sendKeys("3");
	 driver.findElement(By.cssSelector(".otp-input:nth-child(4)")).sendKeys("3");
	 driver.findElement(By.cssSelector(".otp-input:nth-child(5)")).sendKeys("3");
	 driver.findElement(By.cssSelector(".ng-untouched")).sendKeys("3");
	 driver.findElement(By.cssSelector(".ng-untouched")).sendKeys(Keys.ENTER);	
	System.out.println("TC6 Verify- user can use OTP |Success: ");
    }

    // ******************************************************************************************************************************
    @Test(priority = 20)  
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "LOGIN LOGOUT") })
    @Step ("Verify_whether_error_message_is_thrown_if_wrong_OTP_is_entered")
    public void Verify_whether_error_message_is_thrown_if_wrong_OTP_is_entered()
	    throws IOException, InterruptedException {
	//test =extent.createTest(" 7 Verify_whether_error_message_is_thrown_if_wrong_OTP_is_entered (LOGIN LOGOUT)");
	driver.get("http://172.16.19.161:50002/iportalweb/iRetail@1");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 // enter username
	 // **********************************************************************************************************************
	 File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	 FileInputStream fis = new FileInputStream(src);
	 Loginmodule = new XSSFWorkbook(fis);
	 sheet = Loginmodule.getSheet("Loginmodule");
	 for (int i = 1; i <= sheet.getLastRowNum(); i++)
				  // *****************************************************************************************************************
				  cell = sheet.getRow(1).getCell(0);
	 driver.findElement(By.id("mat-input-0")).click();
	 driver.findElement(By.id("mat-input-0")).sendKeys(cell.getStringCellValue());
	 // enter password
	 cell = sheet.getRow(1).getCell(1);
	 driver.findElement(By.id("mat-input-1")).click();
	 driver.findElement(By.id("mat-input-1")).sendKeys(cell.getStringCellValue());
	 driver.findElement(By.id("mat-input-1")).sendKeys(Keys.ENTER);
	 Thread.sleep(4000);
	 // Enter Wrong otp
	 driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).sendKeys("4");
	 driver.findElement(By.cssSelector(".otp-input:nth-child(2)")).sendKeys("4");
	 driver.findElement(By.cssSelector(".otp-input:nth-child(3)")).sendKeys("4");
	 driver.findElement(By.cssSelector(".otp-input:nth-child(4)")).sendKeys("3");
	 driver.findElement(By.cssSelector(".otp-input:nth-child(5)")).sendKeys("3");
	 driver.findElement(By.cssSelector(".ng-untouched")).sendKeys("3");
	 if (driver.getPageSource().contains("Pay To Paybill request Failed")) {
	 System.out.println("Pay To Paybill request Failed");
	 org.testng.Assert.fail("Pay To Paybill request Failed");
	 } else {
	 // System.out.println("Transaction Sucessful");
	 }
	 driver.findElement(By.cssSelector(".ng-untouched")).sendKeys(Keys.ENTER);

	driver.findElement(By.cssSelector(".ng-untouched")).sendKeys(Keys.ENTER);
	System.out.println("TC7 Verify- Error is Thrown if wrong OTP is Entered |Success: ");
    }

    // ***************************************************************************************************************************
    @Test(priority = 21)   
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "LOGIN LOGOUT") })
    @Step ("Verify_whether_a_user_can_logout")
    @Severity(SeverityLevel.CRITICAL)
    public void Verify_whether_a_user_can_logout() throws IOException, InterruptedException {
	//test =extent.createTest(" 8 Verify_whether_a_user_can_logout (LOGIN LOGOUT)");
	driver.get("http://172.16.19.161:50002/iportalweb/iRetail@1");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);    		
		cell = sheet.getRow(1).getCell(0);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-0")));
		driver.findElement(By.id("mat-input-0")).click();
		driver.findElement(By.id("mat-input-0")).sendKeys(cell.getStringCellValue());		
		cell = sheet.getRow(1).getCell(1);
		driver.findElement(By.id("mat-input-1")).click();
		driver.findElement(By.id("mat-input-1")).sendKeys(cell.getStringCellValue());
		driver.findElement(By.id("mat-input-1")).sendKeys(Keys.ENTER);
		WebDriverWait wait2 = new WebDriverWait(driver, 25);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".otp-input:nth-child(1)")));
		driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).sendKeys("3");
		driver.findElement(By.cssSelector(".otp-input:nth-child(2)")).sendKeys("3");
		driver.findElement(By.cssSelector(".otp-input:nth-child(3)")).sendKeys("3");
		driver.findElement(By.cssSelector(".otp-input:nth-child(4)")).sendKeys("2");
		driver.findElement(By.cssSelector(".otp-input:nth-child(5)")).sendKeys("2");
		driver.findElement(By.cssSelector(".ng-untouched")).sendKeys("2");
		driver.findElement(By.cssSelector(".ng-untouched")).sendKeys(Keys.ENTER);
	Thread.sleep(1000);
	driver.findElement(By.linkText("Logout")).click();
	Thread.sleep(1000);
	driver.findElement(By.linkText("Yes")).click();
	System.out.println("TC8 Verify- User can logout |Success: ");
    }

    // ****************************************************************************************************************************
    @Test(priority = 22)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "LOGIN LOGOUT") })
    @Step ("Verify_whether_the_OTP_can_expire_if_not_used_within_5_minutes")
    public void Verify_whether_the_OTP_can_expire_if_not_used_within_5_minutes()
	    throws InterruptedException, IOException {
	//test =extent.createTest(" 9 Verify_whether_the_OTP_can_expire_if_not_used_within_5_minutes (LOGIN LOGOUT)");
	 driver.get("http://172.16.19.161:50002/iportalweb/iRetail@1");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 // enter username
	 // **********************************************************************************************************************
	 File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	 FileInputStream fis = new FileInputStream(src);
	 Loginmodule = new XSSFWorkbook(fis);
	 sheet = Loginmodule.getSheet("Loginmodule");
	 for (int i = 1; i <= sheet.getLastRowNum(); i++)
				  // *****************************************************************************************************************
				  cell = sheet.getRow(1).getCell(0);
	 driver.findElement(By.id("mat-input-0")).click();
	 driver.findElement(By.id("mat-input-0")).sendKeys(cell.getStringCellValue());
	 // enter password
	 cell = sheet.getRow(1).getCell(1);
	 driver.findElement(By.id("mat-input-1")).click();
	 driver.findElement(By.id("mat-input-1")).sendKeys(cell.getStringCellValue());
	 driver.findElement(By.id("mat-input-1")).sendKeys(Keys.ENTER);
	 Thread.sleep(4000);
	 // Resend otp button
	 driver.findElement(By.cssSelector(".mat-button > .mat-button-wrapper")).click();
	 
	System.out.println("TC9 Verify- OTP can expire if not used within 5 minutes |Success:");
    }

    // ***************************************************************************************************************************
    @Test(priority = 23)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "LOGIN LOGOUT") })
    @Step ("verify_whether_user_can_resend_OTP")
    @Severity(SeverityLevel.CRITICAL)
    public void verify_whether_user_can_resend_OTP() throws InterruptedException, IOException {
	//test =extent.createTest(" 10 verify_whether_user_can_resend_OTP (LOGIN LOGOUT)");
	 driver.get("https://retail-onlinebanking-uat.co-opbank.co.ke/iportalweb/iRetail@1");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 //enter username
	 // **********************************************************************************************************************
	 File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	 FileInputStream fis = new FileInputStream(src);
	 Loginmodule = new XSSFWorkbook(fis);
	 sheet = Loginmodule.getSheet("Loginmodule");
	 for (int i = 1; i <= sheet.getLastRowNum(); i++)
				  // *****************************************************************************************************************
				  cell = sheet.getRow(1).getCell(0);
	 driver.findElement(By.id("mat-input-0")).click();
	 driver.findElement(By.id("mat-input-0")).sendKeys(cell.getStringCellValue());
	 // enter password
	 cell = sheet.getRow(1).getCell(1);
	 Thread.sleep(3000);
	 driver.findElement(By.id("mat-input-1")).click();
	 driver.findElement(By.id("mat-input-1")).sendKeys(cell.getStringCellValue());
	 driver.findElement(By.id("mat-input-1")).sendKeys(Keys.ENTER);
	 Thread.sleep(4000);
	 driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).sendKeys("4");
	 driver.findElement(By.cssSelector(".otp-input:nth-child(2)")).sendKeys("4");
	 driver.findElement(By.cssSelector(".otp-input:nth-child(3)")).sendKeys("4");
	 driver.findElement(By.cssSelector(".otp-input:nth-child(4)")).sendKeys("4");
	 driver.findElement(By.cssSelector(".otp-input:nth-child(5)")).sendKeys("4");
	 driver.findElement(By.cssSelector(".ng-untouched")).sendKeys("4");
	 driver.findElement(By.cssSelector(".ng-untouched")).sendKeys(Keys.ENTER);
	System.out.println("TC10 Verify- System can resend OTP |Success: ");
    }

    @Test(priority = 24)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "LOGIN LOGOUT") })
    @Step ("Verify_whether_a_user_can_login_using_correct_user_name_and_password")
    public void Verify_whether_a_user_can_login_using_correct_user_name_and_password()throws IOException, InterruptedException {
	//test =extent.createTest(" 11 Verify_whether_a_user_can_login_using_correct_user_name_and_password (LOGIN LOGOUT)");
	 File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);		
		Account_sub_module = new XSSFWorkbook(fis);
		sheet = Account_sub_module.getSheet("Loginmodule");		
		for (int i = 1; i <= sheet.getLastRowNum(); i++) 	
		 cell = sheet.getRow(1).getCell(2);	
		driver.get(cell.getStringCellValue());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
	
	Loginmodule = new XSSFWorkbook(fis);
	sheet = Loginmodule.getSheet("Loginmodule");
	for (int i = 1; i <= sheet.getLastRowNum(); i++)
	    cell = sheet.getRow(1).getCell(0);
	driver.findElement(By.id("mat-input-0")).click();
	driver.findElement(By.id("mat-input-0")).sendKeys(cell.getStringCellValue());	
	cell = sheet.getRow(1).getCell(1);
	
	driver.findElement(By.id("mat-input-1")).click();
	driver.findElement(By.id("mat-input-1")).sendKeys(cell.getStringCellValue());
	driver.findElement(By.id("mat-input-1")).sendKeys(Keys.ENTER);	
	driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).sendKeys("4");
	driver.findElement(By.cssSelector(".otp-input:nth-child(2)")).sendKeys("4");
	driver.findElement(By.cssSelector(".otp-input:nth-child(3)")).sendKeys("4");
	driver.findElement(By.cssSelector(".otp-input:nth-child(4)")).sendKeys("4");
	driver.findElement(By.cssSelector(".otp-input:nth-child(5)")).sendKeys("4");
	driver.findElement(By.cssSelector(".ng-untouched")).sendKeys("4");
	System.out.println("TC11 Verify- user can login using correct username and password |Success: ");

    }

    @Test(priority = 25)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "LOGIN LOGOUT") })
    @Step ("End_of_Login_logout_TestCases")
    @Severity(SeverityLevel.TRIVIAL)
    public void End_of_Login_logout_TestCases() throws IOException, InterruptedException {
	//test =extent.createTest(" END OF LOGIN LOGOUT TESTCASES");
	System.out.println("*************************End Of login logout Testcases***********************************");
    }

    // *********************************************************************************************************************************
        @Test(priority = 26)
        @Epic("NON_TRANSACTIONAL")
        @Features(value = { @Feature(value = "PROFILE MANAGEMENT") })
        @Step ("PROFILE MANAGEMENT")
        @Severity(SeverityLevel.TRIVIAL)
    public void Running_Profile_Management_TestCases() throws IOException, InterruptedException {
	//test =extent.createTest("(C) RUNNING PROFILE MANAGEMENT");
	System.out.println("*************************(C) RUNNING PROFILE MANAGEMENT***********************************");

	System.out.println("Total Number of Test cases = 14 ");
    }

    // test case 1
    @Test(priority = 27)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "PROFILE MANAGEMENT") })
    @Severity(SeverityLevel.MINOR)
    @Step ("Verify_whether_a_user_can_view_personal_details")
    public void Verify_whether_a_user_can_view_personal_details() throws IOException, InterruptedException {
	//test =extent.createTest(" 1 Verify_whether_a_user_can_view_personal_details (PROFILE MANAGEMENT)");
	driver.get("http://172.16.19.161:50002/iportalweb/iRetail@1");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
// enter username
// **********************************************************************************************************************
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\USSD.xlsx");
	FileInputStream fis = new FileInputStream(src);
	ussd = new XSSFWorkbook(fis);
	sheet = ussd.getSheet("ussd");
	for (int i = 1; i <= sheet.getLastRowNum(); i++)
	    // *****************************************************************************************************************
	    cell = sheet.getRow(1).getCell(0);
	System.out.println("" + cell.getStringCellValue());
	driver.findElement(By.id("mat-input-0")).click();
	driver.findElement(By.id("mat-input-0")).sendKeys(cell.getStringCellValue());
// enter password
	cell = sheet.getRow(1).getCell(1);

	driver.findElement(By.id("mat-input-1")).click();
	driver.findElement(By.id("mat-input-1")).sendKeys(cell.getStringCellValue());
	driver.findElement(By.id("mat-input-1")).sendKeys(Keys.ENTER);
	Thread.sleep(5000);
	driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).sendKeys("3");
	driver.findElement(By.cssSelector(".otp-input:nth-child(2)")).sendKeys("3");
	driver.findElement(By.cssSelector(".otp-input:nth-child(3)")).sendKeys("3");
	driver.findElement(By.cssSelector(".otp-input:nth-child(4)")).sendKeys("2");
	driver.findElement(By.cssSelector(".otp-input:nth-child(5)")).sendKeys("2");
	driver.findElement(By.cssSelector(".ng-untouched")).sendKeys("2");
	driver.findElement(By.cssSelector(".ng-untouched")).sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".ct-menu-mobile__ws-user-img > .media-object")).click();
	System.out.println("TC1 Verify-user can view personal details |Success:");
    }

    // Profile_Management
    // ********************************************************************************************************************************
    @Test(priority = 28)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "PROFILE MANAGEMENT") })
 @Step ("Verify_whether_a_user_can_view_messages")
    public void Verify_whether_a_user_can_view_messages() throws IOException, InterruptedException {
	//test =extent.createTest(" 2 Verify_whether_a_user_can_view_messages (PROFILE MANAGEMENT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.findElement(By.cssSelector(".ct-menu-mobile__ws-user-img > .media-object")).click();
	driver.findElement(By.xpath("//*[text()='Inbox']")).click();		
	System.out.println("TC2 Verify- user can view messages |Success:");
    }

    // ********************************************************************************************************************************
    @Test(priority = 29)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "PROFILE MANAGEMENT") })
    @Step ("Verify_whether_a_user_can_view_notifications")
    public void Verify_whether_a_user_can_view_notifications() throws IOException, InterruptedException {
	//test =extent.createTest(" 3 Verify_whether_a_user_can_view_notifications (PROFILE MANAGEMENT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.findElement(By.cssSelector(".ct-menu-mobile__ws-user-img > .media-object")).click();
	driver.findElement(By.cssSelector(".list-group:nth-child(1) > .list-group-item:nth-child(4)")).click();
	System.out.println("TC3 Verify-user can view notifications |Success:");
    }

    // ******************************************************************************************************************************
    @Test(priority = 30)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "PROFILE MANAGEMENT") })
    @Step ("Verify_whether_a_user_can_view_My_Account")
    public void Verify_whether_a_user_can_view_My_Account() throws IOException, InterruptedException {
	//test =extent.createTest(" 4 Verify_whether_a_user_can_view_My_Account (PROFILE MANAGEMENT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.findElement(By.cssSelector(".ct-menu-mobile__ws-user-img > .media-object")).click();
	driver.findElement(By.cssSelector("span:nth-child(1) > .profile-title")).click();
	Thread.sleep(2000);
	System.out.println("TC4 Verify- Verify whether a user can view My Account |Success:");
    }

    // ********************************************************************************************************************************
    @Test(priority = 31)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "PROFILE MANAGEMENT") })
    @Step ("Verify_Whether_Error_is_thown_when_changed_passwords_are_Not_the_same")
    public void Verify_Whether_Error_is_thown_when_changed_passwords_are_Not_the_same()throws IOException, InterruptedException {
	Thread.sleep(2000);
	//test =extent.createTest(" 5 Verify_Whether_Error_is_thown_when_changed_passwords_are_Not_the_same (PROFILE MANAGEMENT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
//	driver.findElement(By.cssSelector(".ct-menu-mobile__ws-user-img > .media-object")).click();
//	driver.findElement(By.cssSelector(".list-group:nth-child(2) > .list-group-item:nth-child(2) > .profile-title"))	.click();
//	sheet = Profile_Management.getSheet("Profile_management");
//	cell = sheet.getRow(2).getCell(0);
//	Thread.sleep(2000);
//	driver.findElement(By.id("LOGIN_PWD-CURRENT_PWD")).click();
//	driver.findElement(By.id("LOGIN_PWD-CURRENT_PWD")).sendKeys(cell.getStringCellValue());
//	cell = sheet.getRow(2).getCell(1);
//	Thread.sleep(2000);
//	driver.findElement(By.id("LOGIN_PWD-NEW_PWD")).click();
//	driver.findElement(By.id("LOGIN_PWD-NEW_PWD")).sendKeys(cell.getStringCellValue());
//	cell = sheet.getRow(2).getCell(0);
//	Thread.sleep(2000);
//	driver.findElement(By.id("LOGIN_PWD-CONFIRM_NEW_PWD")).click();
//	driver.findElement(By.id("LOGIN_PWD-CONFIRM_NEW_PWD")).sendKeys(cell.getStringCellValue());
	System.out.println("TC5 Verify-Error is thown when changed passwords are Not the same |Success:");
    }

    // *****************************************************************************************************************************
    @Test(priority = 32)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "PROFILE MANAGEMENT") })
    @Step ("Verify_whether_a_user_can_view_terms_and_condition")
    public void Verify_whether_a_user_can_view_terms_and_condition() throws IOException, InterruptedException {
	//test =extent.createTest(" 6 Verify_whether_a_user_can_view_terms_and_condition (PROFILE MANAGEMENT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 3);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ct-menu-mobile__ws-user-img > .media-object")));
	driver.findElement(By.cssSelector(".ct-menu-mobile__ws-user-img > .media-object")).click();
	System.out.println("TC6 Verify-a user can view terms and condition |Success:");
    }

    // *********************************************************************************************************************************
    @Test(priority = 33)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "PROFILE MANAGEMENT") })
    @Step ("Verify_whether_a_user_can_view_privacy_policy")
    public void Verify_whether_a_user_can_view_privacy_policy() throws InterruptedException, IOException {
	//test =extent.createTest(" 7 Verify_whether_a_user_can_view_privacy_policy (PROFILE MANAGEMENT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.findElement(By.cssSelector(".ct-menu-mobile__ws-user-img > .media-object")).click();
	driver.findElement(By.cssSelector(".list-group:nth-child(3) > .list-group-item:nth-child(3) > .profile-title")).click();	
	System.out.println("TC7 Verify- a user can view privacy policy |Success:");
    }

    // ******************************************************************************************************************************
    @Test(priority = 34)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "PROFILE MANAGEMENT") })
    @Step ("Verify_whether_a_user_can_view_use_follow_us_on_twitter")
    public void Verify_whether_a_user_can_view_use_follow_us_on_twitter() throws IOException, InterruptedException {
	//test =extent.createTest(" 8 Verify_whether_a_user_can_view_use_follow_us_on_twitter (PROFILE MANAGEMENT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.findElement(By.cssSelector(".ct-menu-mobile__ws-user-img > .media-object")).click();
	Thread.sleep(2000);
	System.out.println("TC8 Verify- user can view use follow us on twitter |Success:");
    }

    // ******************************************************************************************************************************
    @Test(priority = 35)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "PROFILE MANAGEMENT") })
    @Step ("Verify_whether_a_user_can_use_like_us_on_Facebook")
    public void Verify_whether_a_user_can_use_like_us_on_Facebook() throws IOException, InterruptedException {
	//test =extent.createTest(" 9 Verify_whether_a_user_can_use_like_us_on_Facebook (PROFILE MANAGEMENT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	{
	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ct-menu-mobile__ws-user-img:nth-child(1) > .media-object")));
	}
	driver.findElement(By.cssSelector(".ct-menu-mobile__ws-user-img:nth-child(1) > .media-object")).click();
	Thread.sleep(2000);
	System.out.println("TC9 Verify- user can use like us on Facebook |Success:");
    }

    // ********************************************************************************************************************************
    @Test(priority = 36)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "PROFILE MANAGEMENT") })
    @Step ("Verify_whether_a_user_can_show_account_from_my_account_menu")
    public void Verify_whether_a_user_can_show_account_from_my_account_menu() throws InterruptedException, IOException {
	//test =extent.createTest(" 10 Verify_whether_a_user_can_show_account_from_my_account_menu (PROFILE MANAGEMENT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();	
	driver.findElement(By.cssSelector(".ct-menu-mobile__ws-user-img > .media-object")).click();
	driver.findElement(By.xpath("//*[text()='My Accounts']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[contains(.,\'Show Account\')]")).click();
	driver.findElement(By.xpath("//*[text()='Show Account']")).click();
	driver.findElement(By.xpath("//*[text()='SHOW']")).click();
	driver.findElement(By.name("OTP_INPUT_1")).sendKeys("4");
	driver.findElement(By.name("OTP_INPUT_2")).sendKeys("3");
	driver.findElement(By.name("OTP_INPUT_3")).sendKeys("4");
	driver.findElement(By.name("OTP_INPUT_4")).sendKeys("5");
	driver.findElement(By.name("OTP_INPUT_5")).sendKeys("1");
	driver.findElement(By.name("OTP_INPUT_6")).sendKeys("5");
	driver.findElement(By.xpath("//a[contains(.,\'Submit\')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Done")).click();
	Thread.sleep(2000);
	System.out.println("TC10 Verify- user can show account from my account menu |Success:");
    }

    // ***********************************************************************************************************************************
    @Test(priority = 37)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "PROFILE MANAGEMENT") })
    @Step ("Verify_whether_user_can_hide_account_from_My_account_menu")
    public void Verify_whether_user_can_hide_account_from_My_account_menu() throws IOException, InterruptedException {
	//test =extent.createTest(" 11 Verify_whether_user_can_hide_account_from_My_account_menu (PROFILE MANAGEMENT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();

	driver.findElement(By.cssSelector(".ct-menu-mobile__ws-user-img > .media-object")).click();
	driver.findElement(By.xpath("//span[contains(.,\'My Accounts\')]")).click();
	driver.findElement(By.cssSelector(".slick-current .accButton")).click();
	WebDriverWait wait2 = new WebDriverWait(driver, 25);
	wait2.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("HIDE")));
	driver.findElement(By.linkText("HIDE")).click();
	driver.findElement(By.xpath("//*[text()='HIDE']")).click();	
	driver.findElement(By.name("OTP_INPUT_1")).sendKeys("4");
	driver.findElement(By.name("OTP_INPUT_2")).sendKeys("3");
	driver.findElement(By.name("OTP_INPUT_3")).sendKeys("4");
	driver.findElement(By.name("OTP_INPUT_4")).sendKeys("5");
	driver.findElement(By.name("OTP_INPUT_5")).sendKeys("1");
	driver.findElement(By.name("OTP_INPUT_6")).sendKeys("5");
	driver.findElement(By.xpath("//a[contains(.,\'Submit\')]")).click();	
	driver.findElement(By.linkText("Done")).click();
	Thread.sleep(2000);
	System.out.println("TC11 Verify- user can hide account from my account menu |Success:");

    }

    // **********************************************************************************************************************

    @Test(priority = 38)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "PROFILE MANAGEMENT") })
    @Step ("Verify_whether_a_user_can_upload_a_picture")
    public void Verify_whether_a_user_can_upload_a_picture() throws InterruptedException, IOException {
	//test =extent.createTest(" 12 Verify_whether_a_user_can_upload_a_picture (PROFILE MANAGEMENT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.findElement(By.xpath("//*[@alt='user_image']")).click();
	driver.findElement(By.xpath("//*[@alt='user_image']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='uploadPic']")).sendKeys(my_dir + "\\Profile_Picture\\coop.jpg");
	driver.findElement(By.xpath("//*[text()='Ok']")).click();
	System.out.println("TC12 Verify- user can upload picture |Photo Uploaded Sucessfully:");
    }
 // **********************************************************************************************************************

    @Test(priority = 39)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "PROFILE MANAGEMENT") })
    @Step ("Verify_whether_a_user_can_change_password")
    public void Verify_whether_a_user_can_change_password() throws IOException, InterruptedException {
	//test =extent.createTest(" 13 Verify_whether_a_user_can_change_password (PROFILE MANAGEMENT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".ct-menu-mobile__ws-user-img > .media-object")).click();
	driver.findElement(By.cssSelector(".list-group:nth-child(2) > .list-group-item:nth-child(2) > .profile-title"))
		.click();
// ********************************************************************************************************************************
// Profile_Management = new XSSFWorkbook(fis);
	sheet = Profile_Management.getSheet("Profile_management");
// for(int i=1; i<=sheet.getLastRowNum(); i++)
// *****************************************************************************************************************
	cell = sheet.getRow(2).getCell(0);
// System.out.println("Input Current Password = "+cell.getStringCellValue());
// ********************************************************************************************************************************
	driver.findElement(By.id("LOGIN_PWD-CURRENT_PWD")).click();
	driver.findElement(By.id("LOGIN_PWD-CURRENT_PWD")).sendKeys(cell.getStringCellValue());
// System.out.println("Input Current Password = "+cell.getStringCellValue());
	cell = sheet.getRow(2).getCell(1);
	driver.findElement(By.id("LOGIN_PWD-NEW_PWD")).click();
	driver.findElement(By.id("LOGIN_PWD-NEW_PWD")).sendKeys(cell.getStringCellValue());
	cell = sheet.getRow(2).getCell(0);
	driver.findElement(By.id("LOGIN_PWD-CONFIRM_NEW_PWD")).click();
	driver.findElement(By.id("LOGIN_PWD-CONFIRM_NEW_PWD")).sendKeys(cell.getStringCellValue());
	Thread.sleep(2000);
	System.out.println("TC13 Verify-a user can change password |Success:");

    }

    @Test(priority = 40)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "PROFILE MANAGEMENT") })
    @Severity(SeverityLevel.CRITICAL)
    @Step ("Verify_whether_a_user_can_logout_profile_management")
    public void Verify_whether_a_user_can_logout_profile_management() throws IOException, InterruptedException {
	//test =extent.createTest(" 14 Verify_whether_a_user_can_logout_profile_management (PROFILE MANAGEMENT)");
	driver.get("http://172.16.19.161:50002/iportalweb/iRetail@1");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
// enter username
// **********************************************************************************************************************
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);
	Profile_Management = new XSSFWorkbook(fis);
	sheet = Profile_Management.getSheet("Loginmodule");
	for (int i = 1; i <= sheet.getLastRowNum(); i++)
	    // *****************************************************************************************************************
	    cell = sheet.getRow(1).getCell(0);
	driver.findElement(By.id("mat-input-0")).click();
	driver.findElement(By.id("mat-input-0")).sendKeys(cell.getStringCellValue());
// enter password
	cell = sheet.getRow(1).getCell(1);
	driver.findElement(By.id("mat-input-1")).click();
	driver.findElement(By.id("mat-input-1")).sendKeys(cell.getStringCellValue());
	driver.findElement(By.id("mat-input-1")).sendKeys(Keys.ENTER);
	{
	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".otp-input:nth-child(1)")));
	}
	driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).sendKeys("3");
	driver.findElement(By.cssSelector(".otp-input:nth-child(2)")).sendKeys("3");
	driver.findElement(By.cssSelector(".otp-input:nth-child(3)")).sendKeys("3");
	driver.findElement(By.cssSelector(".otp-input:nth-child(4)")).sendKeys("2");
	driver.findElement(By.cssSelector(".otp-input:nth-child(5)")).sendKeys("2");
	driver.findElement(By.cssSelector(".ng-untouched")).sendKeys("2");
	driver.findElement(By.cssSelector(".ng-untouched")).sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".ct-menu-mobile__ws-user-img > .media-object")).click();
	driver.findElement(By.cssSelector(".logout-btn > span")).click();
	driver.findElement(By.linkText("Yes")).click();
	System.out.println("TC14 Verify- user can logout |Success:");
    }

    @Test(priority = 41)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "PROFILE MANAGEMENT") })
    @Severity(SeverityLevel.TRIVIAL)
    @Step ("End_of_Profile_Management")
    public void End_of_Profile_Management() throws IOException, InterruptedException {
	//test =extent.createTest("END OF PROFILE MANAGEMENT");
	System.out.println("*************************End of Profile Management***********************************");
    }

    @Test(priority = 42)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "ACCOUNT_MODULE MANAGEMENT") })
      @Severity(SeverityLevel.TRIVIAL)
    @Step ("ACCOUNT_MODULE MANAGEMENT")
    public void Running_Account_Module_Management() throws IOException, InterruptedException {
	//test =extent.createTest("(D) RUNNING ACCOUNT_MODULE MANAGEMENT");
	System.out.println("*************************(d) Running Account_Module Management***********************************");
	System.out.println("Total Number of Test cases = 8 ");
    }

    // ****************************************************************************************************************************
    @Test(priority = 43)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "ACCOUNT_MODULE MANAGEMENT") })
    @Severity(SeverityLevel.MINOR)
    @Step ("Verify_whether_a_user_can_select_home_menu_button_cardtab")
    public void Verify_whether_a_user_can_select_home_menu_button_cardtab() throws IOException, InterruptedException {
	//test =extent.createTest(" 1 Verify_whether_a_user_can_select_home_menu_button_cardtab (ACCOUNT_MODULE)");
	driver.get("http://172.16.19.161:50002/iportalweb/iRetail@1");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	// enter username
	// **********************************************************************************************************************
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);
	Account_sub_module = new XSSFWorkbook(fis);
	sheet = Account_sub_module.getSheetAt(1);
	for (int i = 1; i <= sheet.getLastRowNum(); i++)

		// *****************************************************************************************************************
		cell = sheet.getRow(1).getCell(0);
	driver.findElement(By.id("mat-input-0")).click();
	driver.findElement(By.id("mat-input-0")).sendKeys(cell.getStringCellValue());
	// enter password
	cell = sheet.getRow(1).getCell(1);
	driver.findElement(By.id("mat-input-1")).click();
	driver.findElement(By.id("mat-input-1")).sendKeys(cell.getStringCellValue());
	driver.findElement(By.id("mat-input-1")).sendKeys(Keys.ENTER);
	Thread.sleep(4000);
	driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).sendKeys("2");
	driver.findElement(By.cssSelector(".otp-input:nth-child(2)")).sendKeys("2");
	driver.findElement(By.cssSelector(".otp-input:nth-child(3)")).sendKeys("2");
	driver.findElement(By.cssSelector(".otp-input:nth-child(4)")).sendKeys("2");
	driver.findElement(By.cssSelector(".otp-input:nth-child(5)")).sendKeys("2");
	driver.findElement(By.cssSelector(".ng-untouched")).sendKeys("2");
	driver.findElement(By.cssSelector(".ng-untouched")).sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".ct-al__menu-is-selected")).click();
	driver.findElement(By.xpath("//span[contains(.,\'Accounts\')]")).click();
	System.out.println("TC1 Verify- a user can select home menu button cardtab |Success:");
    }

    // ************************************************************************************************************************
    @Test(priority = 44)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "ACCOUNT_MODULE MANAGEMENT") })
    @Step ("verify_whether_a_user_can_view_about_account_details")
    public void verify_whether_a_user_can_view_about_account_details() throws IOException, InterruptedException {
	//test =extent.createTest(" 2 verify_whether_a_user_can_view_about_account_details (ACCOUNT_MODULE");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".slick-current .cardnumber:nth-child(2)")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".stAbtAcc")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".stAbtAcc")).click();
	Thread.sleep(2000);
	System.out.println("TC2 Verify- a user can view about account details |Success:");

    }

    // *************************************************************************************************************************
    @Test(priority = 45)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "ACCOUNT_MODULE MANAGEMENT") })
    @Step ("verify_whether_a_user_can_view_consolidated_balance")
    public void verify_whether_a_user_can_view_consolidated_balance() throws IOException, InterruptedException {
	//test =extent.createTest(" 3 verify_whether_a_user_can_view_consolidated_balance (ACCOUNT_MODULE");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("CONSOLIDATED_FORM-SHOW_BAL")).click();

	System.out.println("TC3 Verify- a user can view consolidated balance |Success:");

    }

    // ***************************************************************************************************************************
    @Test(priority = 46)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "ACCOUNT_MODULE MANAGEMENT") })
    @Step ("verify_whether_a_user_can_view_account_services")
    public void verify_whether_a_user_can_view_account_services() throws IOException, InterruptedException {
	//test =extent.createTest(" 4 verify_whether_a_user_can_view_account_services (ACCOUNT_MODULE");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Home")).click();
	driver.findElement(By.cssSelector(".slick-current > .cards")).click();
	driver.findElement(By.cssSelector(".stAbtAcc")).click();

	System.out.println("TC4 Verify- a user can view account services|Success:");

    }

    // ************************************************************************************************************************
    @Test(priority = 47)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "ACCOUNT_MODULE MANAGEMENT") })
    @Step ("verify_whether_a_user_can_view_all_account_transaction")
    public void verify_whether_a_user_can_view_all_account_transaction() throws InterruptedException, IOException {
	//test =extent.createTest(" 5 verify_whether_a_user_can_view_all_account_transaction (ACCOUNT_MODULE");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".COOP_MULTI_RECENT_APP_tabItem .ct-tab__txtspan")).click();
	System.out.println("TC5 Verify- a user can view all account transaction |Success:");

    }

    // ***********************************************************************************************************************
    @Test(priority = 48)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "ACCOUNT_MODULE MANAGEMENT") })
    @Step ("verify_whether_a_user_can_view_my_payment_option_for_account")
    public void verify_whether_a_user_can_view_my_payment_option_for_account()
	    throws IOException, InterruptedException {
	//test =extent.createTest(" 6 verify_whether_a_user_can_view_my_payment_option_for_account (ACCOUNT_MODULE");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(
		By.cssSelector(".active > .childApp_COOP_TRAN_HIST_MULTI_APP_tabAnchorClass > .ct-tab__txtspan"))
		.click();
	System.out.println("TC6 Verify- a user can view my payment option for account | Sucess");
    }

    // ************************************************************************************************************************
    @Test(priority = 49)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "ACCOUNT_MODULE MANAGEMENT") })
    @Step ("Verify_whether_a_user_can_view_failled_pending_and_Sucess_Transactions")
    public void Verify_whether_a_user_can_view_failled_pending_and_Sucess_Transactions()
	    throws IOException, InterruptedException {
	//test =extent.createTest(" 7 Verify_whether_a_user_can_view_failled_pending_and_Sucess_Transactions (ACCOUNT_MODULE");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".COOP_MULTI_RECENT_APP_tabItem .ct-tab__txtspan")).click();
	driver.findElement(By.id("RECENT_TXN_DROPDOWN_FORM-DEBIT_ACCOUNT")).click();
	System.out.println("TC7 Verify- a user can view failled pending and Sucess Transactions |Success:");

    }

    // ************************************************************************************************************************
    @Test(priority = 50)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "ACCOUNT_MODULE MANAGEMENT") })
    @Step ("Verify_whether_a_user_can_view_balance_for_aspecific_card_number")
    public void Verify_whether_a_user_can_view_balance_for_aspecific_card_number()
	    throws IOException, InterruptedException {
	//test =extent.createTest(" 8 Verify_whether_a_user_can_view_balance_for_aspecific_card_number (ACCOUNT_MODULE");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".slick-current .accButton")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".ws-list-row:nth-child(2) .accButton")).click();
	System.out.println("TC8 Verify- a user can view balance for a specific card number |Success:");	
// ***********************************************************************************************************************
    }
    @Test(priority = 51)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "ACCOUNT_MODULE MANAGEMENT") })
    @Severity(SeverityLevel.TRIVIAL)
    @Step ("End_Card_Module_Testcases")
    public void End_Card_Module_Testcases() throws IOException, InterruptedException {
	//test =extent.createTest("END OF ACCOUNT MODULE TESTCASES");
	System.out.println("*************************End of Account Module Testcases***********************************");
    }

    // ***********************************************************************************************************************
    /*
     * @Test (priority=51) public void
     * verify_whether_a_user_can_subscribe_to_E_statement_monthly() {
     * driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
     * Thread.sleep(2000); Thread.sleep(2000);
     * driver.findElement(By.cssSelector(".slick-current .cardholdername")).click();
     * driver.findElement(By.cssSelector(".stAccSer")).click();
     * 
     * driver.findElement(By.cssSelector(".row:nth-child(5)")).click();
     * driver.findElement(By.
     * xpath("//span[contains(.,\'E-Statement Subscription\')]")).click();
     * Thread.sleep(2000); driver.findElement(By.name("SUBSCRIBE")).click();
     * Thread.sleep(2000); }
     */
    // ***********************************************************************************************************************
    /*
     * @Test (priority=52) public void
     * verify_whether_auser_can_unsubscribe_to_Estatementmonthly() {
     * driver.findElement(By.xpath("//a[contains(.,'Home')]")).click(); {
     * WebDriverWait wait = new WebDriverWait(driver, 30);
     * wait.until(ExpectedConditions.presenceOfElementLocated(By.
     * cssSelector(".slick-current .cardholdername"))); }
     * driver.findElement(By.cssSelector(".slick-current > .cards")).click();
     * driver.findElement(By.cssSelector(".stAccSer")).click(); Thread.sleep(2000);
     * driver.findElement(By.
     * xpath("//span[contains(.,\'E-Statement Subscription\')]")).click();
     * driver.findElement(By.name("UNSUBSCRIBE")).click(); Thread.sleep(2000);
     * driver.findElement(By.xpath("//a[contains(.,\'Ok\')]")).click();
     * Thread.sleep(2000); driver.findElement(By.linkText("OK")).click(); }
     */
    @Test(priority = 53)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "CARD MODULE") })
      @Severity(SeverityLevel.TRIVIAL)
    @Step ("CARD MODULE")
    public void Running_Card_Module_Testcases() throws IOException, InterruptedException {
	//test =extent.createTest("(E) RUNNING CARD MODULE TESTCASES");
	System.out.println("*************************(E) RUNNING CARD MODULE TESTCASES***********************************");

	System.out.println("Total Number of Test cases = 7");
    }

    // ***********************************************************************************************************************************
    @Test(priority = 54)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "CARD MODULE") })
    @Step ("Verify_whether_a_user_can_select_home_menu_button_card_tab")
    public void Verify_whether_a_user_can_select_home_menu_button_card_tab() throws IOException, InterruptedException {
	//test =extent.createTest(" 1 Verify_whether_a_user_can_select_home_menu_button_card_tab (CARD MODULE)");
	driver.get("http://172.16.19.161:50002/iportalweb/iRetail@1");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    // enter username
	    //**********************************************************************************************************************
	      File src=new File(my_dir+"\\Data_Driven_Excel_File\\TestData.xlsx");
	      FileInputStream fis = new FileInputStream(src);
	      Card_module = new XSSFWorkbook(fis);
	      sheet= Card_module.getSheetAt(1);	  
	      for(int i=1; i<=sheet.getLastRowNum(); i++)
	      
	   //*****************************************************************************************************************  
	      cell = sheet.getRow(1).getCell(0);
	      driver.findElement(By.id("mat-input-0")).click();
	      driver.findElement(By.id("mat-input-0")).sendKeys(cell.getStringCellValue());
	      //enter password
	      cell = sheet.getRow(1).getCell(1);
	      driver.findElement(By.id("mat-input-1")).click();
	      driver.findElement(By.id("mat-input-1")).sendKeys(cell.getStringCellValue());
	      driver.findElement(By.id("mat-input-1")).sendKeys(Keys.ENTER);
	      Thread.sleep(2000);
	    driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).sendKeys("2");
	    driver.findElement(By.cssSelector(".otp-input:nth-child(2)")).sendKeys("2");
	    driver.findElement(By.cssSelector(".otp-input:nth-child(3)")).sendKeys("2");
	    driver.findElement(By.cssSelector(".otp-input:nth-child(4)")).sendKeys("2");
	    driver.findElement(By.cssSelector(".otp-input:nth-child(5)")).sendKeys("2");
	    driver.findElement(By.cssSelector(".ng-untouched")).sendKeys("2");
	    driver.findElement(By.cssSelector(".ng-untouched")).sendKeys(Keys.ENTER);
	    Thread.sleep(4000);
	    driver.findElement(By.cssSelector(".COOP_CARDSTAB_SWS_tabItem .ct-tab__txtspan")).click();
	System.out.println("TC1 Verify- a user can select home menu button card tab |Success:");

    }

    // ***********************************************************************************************************************************
    @Test(priority = 55)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "CARD MODULE") })
    @Step ("Verify_whether_a_user_can_view_details_of_the_card")
    public void Verify_whether_a_user_can_view_details_of_the_card() throws IOException, InterruptedException {
	//test =extent.createTest(" 2 Verify_whether_a_user_can_view_details_of_the_card (CARD MODULE)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".COOP_CARDSTAB_SWS_tabItem .ct-tab__txtspan")).click();
	driver.findElement(By.cssSelector(".ct-al__menu-is-selected")).click();
	driver.findElement(By.xpath("//span[contains(.,\'Cards\')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//p[contains(.,\'DEBIT Card\')]")).click();
	System.out.println("TC2 Verify- a user can view details of the card |Success:");
    }
    // ***********************************************************************************************************************************

    @Test(priority = 56)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "CARD MODULE") })
    @Step ("Verify_whether_a_user_can_check_on_the_card_limit")
    public void Verify_whether_a_user_can_check_on_the_card_limit() throws IOException, InterruptedException {
	//test =extent.createTest("3 Verify_whether_a_user_can_check_on_the_card_limit (CARD MODULE)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".COOP_CARDSTAB_SWS_tabItem .ct-tab__txtspan")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".ct-al__menu-is-selected")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[contains(.,\'Cards\')]")).click();
	driver.findElement(By.xpath("//p[contains(.,\'DEBIT Card\')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".stAccBal")).click();
	System.out.println("TC3 Verify- a user can check on the card limit |Success:");
    }
    // ***********************************************************************************************************************************

    @Test(priority = 57)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "CARD MODULE") })
    @Step ("Verify_whether_a_user_can_activate_online_purchase")
    public void Verify_whether_a_user_can_activate_online_purchase() throws IOException, InterruptedException {
	//test =extent.createTest(" 4 Verify_whether_a_user_can_activate_online_purchase (CARD MODULE)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".COOP_CARDSTAB_SWS_tabItem .ct-tab__txtspan")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".ct-al__menu-is-selected")).click();
	driver.findElement(By.xpath("//span[contains(.,\'Cards\')]")).click();
	driver.findElement(By.xpath("//p[contains(.,\'DEBIT Card\')]")).click();
	driver.findElement(By.cssSelector(".stAccSer")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".slider")).click();
	System.out.println("TC4 Verify- a user can activate online purchase |Success:");
    }
    // ***********************************************************************************************************************************

    @Test(priority = 58)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "CARD MODULE") })
    @Step ("Verify_whether_a_user_can_block_card")
    public void Verify_whether_a_user_can_block_card() throws IOException, InterruptedException {
	//test =extent.createTest(" 5 Verify_whether_a_user_can_block_card (CARD MODULE)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000); 
	System.out.println("TC5 Verify- a user can block card |Success:");
    }

    // ***********************************************************************************************************************************

    @Test(priority = 59)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "CARD MODULE") })
    @Step ("Verify_whether_a_user_can_change_Card_PIN")
    public void Verify_whether_a_user_can_change_Card_PIN() throws IOException, InterruptedException {
	//test =extent.createTest(" 6 Verify_whether_a_user_can_change_Card_PIN (CARD MODULE)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".COOP_CARDSTAB_SWS_tabItem .ct-tab__txtspan")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".ct-al__menu-is-selected")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[contains(.,\'Cards\')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//p[contains(.,\'DEBIT Card\')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".stAccSer")).click();
	driver.findElement(By.cssSelector(".cashflow:nth-child(2) > .acc2")).click();
	System.out.println("TC6 Verify- a user can change Card PIN |Success:");
    }

    // ***********************************************************************************************************************************

    @Test(priority = 60)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "CARD MODULE") })
    @Step ("Verify_whether_a_user_can_user_Forgot_PIN_button")
    public void Verify_whether_a_user_can_user_Forgot_PIN_button() throws IOException, InterruptedException {
	//test =extent.createTest(" 7 Verify_whether_a_user_can_user_Forgot_PIN_button (CARD MODULE)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".COOP_CARDSTAB_SWS_tabItem .ct-tab__txtspan")).click();
	driver.findElement(By.cssSelector(".ct-al__menu-is-selected")).click();
	driver.findElement(By.xpath("//span[contains(.,\'Cards\')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//p[contains(.,\'DEBIT Card\')]")).click();
	driver.findElement(By.cssSelector(".stAccSer")).click();
	driver.findElement(By.cssSelector(".cashflow:nth-child(3) > .acc2")).click();
	driver.findElement(By.id("COOP_CARD_FOPIN_MFORM1-PIN_QUES")).click();
	driver.findElement(By.id("COOP_CARD_FOPIN_MFORM1-PIN_QUES")).click();
	System.out.println("TC7 Verify- a user can user Forgot PIN_button |Success:");
    }

    @Test(priority = 61)
    @Epic("NON_TRANSACTIONAL")
    @Features(value = { @Feature(value = "CARD MODULE") })
    @Severity(SeverityLevel.TRIVIAL)
    @Step ("End_Of_Card_Module_Testcases")
    public void End_Of_Card_Module_Testcases() throws IOException, InterruptedException {
	//test =extent.createTest("END OF  CARD MODULE TESTCASES");
	System.out.println("*************************End of  Card Module TestCases***********************************");
    }
}
//    @AfterMethod
//    public void getResult(ITestResult result) throws Exception
//    {
//    	if(result.getStatus() == ITestResult.FAILURE)
//    	{
//    		//MarkupHelper is used to display the output in different colors
//    		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
//    		test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
//
//    		//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
//    		//We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method. 
//
//    		//	String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
//    		String screenshotPath = TakeScreenshot(driver, result.getName());
//    		//To add it in the extent report 
//
//    		test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));
//
//
//    	}
//    	else if(result.getStatus() == ITestResult.SKIP){
//    		//logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
//    		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
//    	} 
//    	else if(result.getStatus() == ITestResult.SUCCESS)
//    	{
//    		test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
//    	}
//
//    }
//
//    public static String TakeScreenshot(WebDriver driver, String screenshotName) throws IOException {
//    	String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//    	TakesScreenshot ts = (TakesScreenshot) driver;
//    	File source = ts.getScreenshotAs(OutputType.FILE);
//    	// after execution, you could see a folder "FailedTestsScreenshots" under src folder
//    	String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
//    	File finalDestination = new File(destination);
//    	FileUtils.copyFile(source, finalDestination);
//    	return destination;
//    }
//    }
