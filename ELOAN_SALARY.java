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

import com.aventstack.extentreports.ExtentTest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

public class ELOAN_SALARY {
            	String my_dir = System.getProperty("user.dir");
            	public WebDriver driver;              	
        	public ExtentTest test; 
        	JavascriptExecutor js;  
        	XSSFWorkbook ELOAN_BUSINESS;
        	XSSFSheet sheet;  	
		XSSFWorkbook Loginmodule;
		XSSFWorkbook RBX_BILLS;		
		XSSFCell cell;
//**********************************************************************************************************************************
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

    public static void main(String[] args) {
    	TestNG testng = new TestNG();
    	testng.setTestClasses(new Class[] { ELOAN_SALARY.class });
    	testng.run();
    }

//**********************************************************************************************************************************
    @Test(priority = 0)    
    @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "APPLICATION AND DISBURMENT") })
    @Step ("APPLICATION AND DISBURMENT")
    @Severity(SeverityLevel.TRIVIAL)    
    public void Running_Eloans_Salary_Application_And_Disbursment() throws IOException, InterruptedException {
	//test =extent.createTest(" (1) RUNNING OF APPLICATION AND DISBURMENT TESTCASES");
	System.out.println("ELOANS TESTCASES");
	System.out.println(
		"*************************(1) Running Eloans_Salary_Application_And_Disbursment TestCases ***********************");
    }

    // **********************************************************************************************************************************
    @Test(priority = 1)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "APPLICATION AND DISBURMENT") })
    @Severity(SeverityLevel.MINOR)
    @Step ("verify_that_the_loan_tab_is_easily_accessible_on_the_landing_page_")
    public void verify_that_the_loan_tab_is_easily_accessible_on_the_landing_page_()
	    throws InterruptedException, IOException {
	//test =extent.createTest(" 1 Verify that the loan tab is easily accessible on the landing page");
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);		
	RBX_BILLS = new XSSFWorkbook(fis);
	sheet = RBX_BILLS.getSheet("Loginmodule");		
	for (int i = 1; i <= sheet.getLastRowNum(); i++) 	
	 cell = sheet.getRow(1).getCell(2);	
	driver.get(cell.getStringCellValue());
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	    		
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
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();

	System.out.println("TC1 Verify- loan_tab_is_easily_accessible_on_the_landing_page |Success:");
    }

    // **********************************************************************************************************************
    @Test(priority = 2)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "APPLICATION AND DISBURMENT") })
    @Step ("clear_loan_if_any")
    public void clear_loan_if_any() throws InterruptedException {
	 
	try 
	{	
	if (driver.findElement(By.xpath("//*[text()='Show more']")).isDisplayed())


		{
        	    driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
        	    driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).click();
        	    Thread.sleep(2000);
        	    driver.findElement(By.xpath("//a[contains(.,\'Clear Loan\')]")).click();
        	    Thread.sleep(2000);
        	    driver.findElement(By.name("CMB_DEBIT_ACCOUNT_FULL")).click();
        	    driver.findElement(By.name("CMB_DEBIT_ACCOUNT_FULL")).sendKeys("01105413334100");
        	    Thread.sleep(2000);
        	    driver.findElement(By.xpath("//button[@id='ELOANS_REPAYMENT_PAY_FORM_08-BTN_NEXT_FULL']")).click();
        	    Thread.sleep(2000);
        	    driver.findElement(By.xpath("//label[@class='checkbox-inline']")).click();
        	    Thread.sleep(2000);
        	    driver.findElement(By.xpath("//a[contains(.,\'Pay Loan\')]")).click();
        	    Thread.sleep(2000);
        	    driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("2");
        	    driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("3");
        	    driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("4");
        	    driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("5");
        	    driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("6");
        	    driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("8");
        	    Thread.sleep(2000);
        	    driver.findElement(By.xpath("//a[contains(.,\'Submit\')]")).click();
        	    Thread.sleep(2000);
        	    driver.findElement(By.xpath("//button[contains(.,\'OK\')]")).click();
        	    System.out.println("loan cleared");
		}

	}
	catch(Exception e)
	
		{
	    		System.out.println("NO outstanding loan");
		}
    	}
 
// **********************************************************************************************************************
@Test(priority = 3)
@Epic("ELOANS (SALARY)")
@Features(value = { @Feature(value = "APPLICATION AND DISBURMENT") })
@Step ("verify_that_the_Loan_period_section_captures_the_maximum_period_allowed_for_the_facility_below_it")
public void verify_that_the_Loan_period_section_captures_the_maximum_period_allowed_for_the_facility_below_it()throws InterruptedException, IOException {
        	//test =extent.createTest(" 2 Verify that the Loan period section captures the maximum period allowed for the facility below it.");
        	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
        	FileInputStream fis = new FileInputStream(src);		
        	RBX_BILLS = new XSSFWorkbook(fis);
        	sheet = RBX_BILLS.getSheet("Loginmodule");		
        	for (int i = 1; i <= sheet.getLastRowNum(); i++) 	
        	 cell = sheet.getRow(1).getCell(2);	
        	driver.get(cell.getStringCellValue());
        	driver.manage().window().maximize();
        	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	    		
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
        	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
        	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
        	
        	driver.findElement(By.xpath("//button[contains(.,\'Get Loan\')]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//button[contains(.,'Apply for a salary e-loan')]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//span[contains(.,\'Max loan period 3 month(s)\')]")).click();
        	System.out.println("TC2 Verify- Loan_period_section_captures_the_maximum_period_allowed_for_the_facility_below_it|Success:");
    		}
// **********************************************************************************************************************
 @Test(priority = 4)
  @Epic("ELOANS (SALARY)")
 @Features(value = { @Feature(value = "APPLICATION AND DISBURMENT") })
 @Step ("verify_that_the_customer_can_click_on_the_loan_tab_and_proceed_to_view_details")
 public void verify_that_the_customer_can_click_on_the_loan_tab_and_proceed_to_view_details()throws IOException, InterruptedException {
        	//test =extent.createTest(" 3 Verify that the customer can click on the loan tab and proceed to view details");
        	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
        	System.out.println("TC3 Verify- customer_can_click_on_the_loan_tab_and_proceed_to_view_details |Success:");
    		}
// **********************************************************************************************************************
@Test(priority = 5)
@Epic("ELOANS (SALARY)")
@Features(value = { @Feature(value = "APPLICATION AND DISBURMENT") })
@Step ("verify_that_the_limits_are_properly_set_The_minimum_limit_of_Personal_loan_is_Kes1000_and_the_Maximum_is_the_maximum_scorelimit_given_to_the_customer")
public void verify_that_the_limits_are_properly_set_The_minimum_limit_of_Personal_loan_is_Kes1000_and_the_Maximum_is_the_maximum_scorelimit_given_to_the_customer() throws InterruptedException, IOException {
        	//test =extent.createTest(" 4 Verify that the limits are properly set. The minimum limit of Personal loan is Kes. 1000.00 and the Maximum is the maximum score limit given to the customer");
        	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
        	driver.findElement(By.xpath("//button[contains(.,\'Get Loan\')]")).click();
        	driver.findElement(By.id("ELOANS_ELIGIBILITY_REQ_FORM_02-BTN_APPLY_PERSONAL")).click();
        	driver.findElement(By.id("ELOANS_LOAN_CREATE_REQ_FORM_03-TXT_AMOUNT")).clear();
        	driver.findElement(By.name("TXT_AMOUNT")).sendKeys("999");
        	driver.findElement(By.linkText("NEXT")).click();
        	{
        	    List<WebElement> elements = driver.findElements(By.xpath("//div[2]/div/div/div[2]/div/div[2]"));
        	    assert (elements.size() > 0);
        	}
        	driver.findElement(By.linkText("Ok")).click();        
        	System.out.println("TC4 Verify- the_limits_are_properly_set_The_minimum_limit_of_Personal_loan_is_Kes100000_and_the_Maximum_is_the_maximum_scorelimit_given_to_the_customer |Success:");
		}
// **********************************************************************************************************************
 @Test(priority = 6)
  @Epic("ELOANS (SALARY)")
 @Features(value = { @Feature(value = "APPLICATION AND DISBURMENT") })
 @Step ("verify_that_if_the_customer_enters_an_amount_below_the_minimum_amount_he_she_gets_an_error_The_amount_entered_is_below_the_allowable_loan_amount_of_KS1000")
public void verify_that_if_the_customer_enters_an_amount_below_the_minimum_amount_he_she_gets_an_error_The_amount_entered_is_below_the_allowable_loan_amount_of_KS1000()throws InterruptedException, IOException {
        	//test =extent.createTest(" 5 Verify that if the customer enters an amount above the maximum amount, he/she gets an error \"The amount entered is above the maximum allowable loan amount of KS.”");	
        	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
        	driver.findElement(By.xpath("//button[contains(.,\'Get Loan\')]")).click();
        	driver.findElement(By.xpath("//button[contains(.,'Apply for a salary e-loan')]")).click();
        	driver.findElement(By.cssSelector(".ct-formlayout-COMPOSITE_EDIT_AMOUNT .col-lg-12")).click();
        	driver.findElement(By.name("TXT_AMOUNT")).sendKeys("999");
        	driver.findElement(By.linkText("NEXT")).click();
        	{
        	    List<WebElement> elements = driver.findElements(By.xpath("//div[2]/div/div/div[2]/div/div[2]"));
        	    assert (elements.size() > 0);
        	}
        	driver.findElement(By.linkText("Ok")).click();        
        	System.out.println("TC5 Verify- if_the_customer_enters_an_amount_below_the_minimum_amount_he_she_gets_an_error_The_amount_entered_is_below_the_allowable_loan_amount_of_KS1000 |Success:");
    }
 // **********************************************************************************************************************
@Test(priority = 7)
@Epic("ELOANS (SALARY)")
@Features(value = { @Feature(value = "APPLICATION AND DISBURMENT") })
@Step ("verify_that_the_upon_clicking_on_Show_more_button_one_loan_the_customer_will_have_two_options_to_either_select_Personalor_BusinessLoan")
public void verify_that_the_upon_clicking_on_Show_more_button_one_loan_the_customer_will_have_two_options_to_either_select_Personalor_BusinessLoan()throws IOException, InterruptedException {
        	//test =extent.createTest(" 6 Verify that the upon clicking on ‘Show more’ button on existing e-loan, the customer will have two options, to either select Personal or Business Loan.");
        	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
        	driver.findElement(By.xpath("//button[contains(.,\'Get Loan\')]")).click();
        	try {
        	    Thread.sleep(2000);
        	} catch (InterruptedException e) {
        	    e.printStackTrace();
        	}
        	{
        	    List<WebElement> elements = driver.findElements(By.name("BTN_APPLY_PERSONAL"));
        	    assert (elements.size() > 0);
        	}
        	{
        	    List<WebElement> elements = driver.findElements(By.name("BTN_APPLY_BUSINESS"));
        	    assert (elements.size() > 0);
        	}       
        	System.out.println("TC6 Verify- upon_clicking_on_Show_more_button_one_loan_the_customer_will_have_two_options_to_either_select_Personalor_BusinessLoan |Success:");
    }
// **********************************************************************************************************************
 @Test(priority = 8)
  @Epic("ELOANS (SALARY)")
 @Features(value = { @Feature(value = "APPLICATION AND DISBURMENT") })
 @Step ("verify_that_the_Apply_for_personal_eLoan_button_exists_which_upon_clicking_allows_the_customer_to_proceed_with_eloan_application")
public void verify_that_the_Apply_for_personal_eLoan_button_exists_which_upon_clicking_allows_the_customer_to_proceed_with_eloan_application()
	    throws InterruptedException, IOException {
	//test =extent.createTest(" 7 Verify that the ‘Apply for personal e-Loan’ button exists-which upon clicking, allows the customer to proceed with e-loan application");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.navigate().refresh();
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Get Loan\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Apply for a salary e-loan\')]")).click();

	System.out.println(
		"TC7 Verify- the_Apply_for_personal_eLoan_button_exists_which_upon_clicking_allows_the_customer_to_proceed_with_eloan_application |Success:");
    }
// **********************************************************************************************************************
@Test(priority = 9)
@Epic("ELOANS (SALARY)")
@Features(value = { @Feature(value = "APPLICATION AND DISBURMENT") })
@Step ("verify_that_under_the_loan_amount_field_application_indicates_the_maximum_loan_limit")
public void verify_that_under_the_loan_amount_field_application_indicates_the_maximum_loan_limit() {
	 //test =extent.createTest(" 8 Verify that under the loan amount field, application indicates the maximum loan limit.");
	System.out.println("TC8  verify_that_under_the_loan_amount_field_application_indicates_the_maximum_loan_limit |Success:");
		}
// **********************************************************************************************************************
 @Test(priority = 10)
 @Epic("ELOANS (SALARY)")
 @Features(value = { @Feature(value = "APPLICATION AND DISBURMENT") })
 @Step ("verify_that_upon_clicking_on_the_See_more_section_the_Loan_improvement_tips_are_displayed")
    public void verify_that_upon_clicking_on_the_See_more_section_the_Loan_improvement_tips_are_displayed()
	    throws IOException, InterruptedException {
	 //test =extent.createTest(" 9 Verify that upon clicking on the ‘See more’ section - the Loan improvement tips are displayed.	");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.navigate().refresh();
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Get Loan\')]")).click();
	
	driver.findElement(By.linkText("See More...")).click();
	System.out.println("TC9 Verify- under_the_loan_amount_field_application_indicates_the_maximum_loan_limit |Success:");
    }
    // **********************************************************************************************************************

    @Test(priority = 11)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "APPLICATION AND DISBURMENT") })
    @Step ("verify_that_upon_clicking_on_Apply_for_Personal_eloan_the_customer_then_progresses_to_capture_the_Loan_period_months")
    public void verify_that_upon_clicking_on_Apply_for_Personal_eloan_the_customer_then_progresses_to_capture_the_Loan_period_months()
	    throws IOException, InterruptedException {
	 //test =extent.createTest(" 10 Verify that upon clicking on ‘Apply for a business e-loan’, the customer then progresses to capture the: o Loan period (months) ");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.navigate().refresh();
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.cssSelector(".loanDetails")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[contains(.,'Apply for a salary e-loan')]")).click();
	Thread.sleep(2000);

	driver.findElement(By.name("CMB_TENURE")).click();

	System.out.println(
		"TC10 Verify- upon_clicking_on_Apply_for_Personal_eloan_the_customer_then_progresses_to_capture_the_Loan_period_months |Success:");
    }
    // **********************************************************************************************************************

    @Test(priority = 12)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "APPLICATION AND DISBURMENT") })
    @Step ("verify_that_when_the_customer_clicks_on_Get_Loan_under_the_Eloan_menu_he_she_will_have_two_options_the_Personal_Loan_and_Business_Loan")
    public void verify_that_when_the_customer_clicks_on_Get_Loan_under_the_Eloan_menu_he_she_will_have_two_options_the_Personal_Loan_and_Business_Loan()
	    throws IOException, InterruptedException {
	 //test =extent.createTest(" 11 Verify that when the customer clicks on ‘Get Loan’ under the E-loan menu, he/she will have two options, the Personal Loan and Business Loan.");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.navigate().refresh();
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Get Loan\')]")).click();
	driver.findElement(By.xpath("//label[contains(.,\'E-loan\')]")).click();

	System.out.println(
		"TC11 Verify- when_the_customer_clicks_on_Get_Loan_under_the_Eloan_menu_he_she_will_have_two_options_the_Personal_Loan_and_Business_Loan|Success:");
    }
    // **********************************************************************************************************************

    @Test(priority = 13)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "APPLICATION AND DISBURMENT") })
    @Step ("Verify_that_if_the_customer_enters_an_amount_above_the_maximum_amount_he_she_gets_an_error_The_amount_entered_is_above_the_maximum_allowable_loan_amount_of_KS")
    public void Verify_that_if_the_customer_enters_an_amount_above_the_maximum_amount_he_she_gets_an_error_The_amount_entered_is_above_the_maximum_allowable_loan_amount_of_KS()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 12 Verify that if the customer enters an amount above the maximum amount, he/she gets an error \"The amount entered is above the maximum allowable loan amount of KS.”");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.navigate().refresh();
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Get Loan\')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[contains(.,'Apply for a salary e-loan')]")).click();
	driver.findElement(By.id("div_0")).click();
	driver.findElement(By.name("TXT_AMOUNT")).clear();
	driver.findElement(By.name("TXT_AMOUNT")).sendKeys("200001");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.xpath("//div[@class='panel-body ct-model__panel-body ct-app__content']")).isDisplayed();
	driver.findElement(By.xpath("//a[@class='btn  ct_btn_neg ct-right-btn dialogBtnOk']")).click();

	System.out.println("TC12 Verify- that_if_the_customer_enters_an_amount_above_the_maximum_amount_he_she_gets_an_error_The_amount_entered_is_above_the_maximum_allowable_loan_amount_of_KS |Success:");

    }
    // **********************************************************************************************************************

    @Test(priority = 14)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "APPLICATION AND DISBURMENT") })
    @Step ("verify_that_the_Disbursement_account_field_has_a_dropdown_arrow_from_which_to_select_from_and_shows_the_account_balance_below_the_field")
    public void verify_that_the_Disbursement_account_field_has_a_dropdown_arrow_from_which_to_select_from_and_shows_the_account_balance_below_the_field()
	    throws InterruptedException, IOException {
	 //test =extent.createTest("13 Verify that the \"Disbursement account\" field has a drop down arrow from which to select from and shows the account balance below the field.	");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.navigate().refresh();
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Get Loan\')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[contains(.,'Apply for a salary e-loan')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[@name=\'LBL_AVAILABLE_BALANCE\']")).click();

	System.out.println(
		"TC13 Verify- the_Disbursement_account_field_has_a_dropdown_arrow_from_which_to_select_from_and_shows_the_account_balance_below_the_field |Success:");
    }
    // **********************************************************************************************************************

    @Test(priority = 15)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "APPLICATION AND DISBURMENT") })
    @Step ("Verify_that_under_Repayment_Schedule_the_details_of_the_repayment_schedule_as_per_the_period_selected_are_captured_to_show_the_instalments")
    public void Verify_that_under_Repayment_Schedule_the_details_of_the_repayment_schedule_as_per_the_period_selected_are_captured_to_show_the_instalments()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 14 Verify that under Repayment Schedule the details of the repayment schedule as per the period selected are captured to show the instalments.");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.navigate().refresh();
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Get Loan\')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[contains(.,'Apply for a salary e-loan')]")).click();
	driver.findElement(By.xpath("//label[contains(.,\'Repayment Schedule (KES)\')]")).click();

	System.out.println(
		"TC14 Verify- under_Repayment_Schedule_the_details_of_the_repayment_schedule_as_per_the_period_selected_are_captured_to_show_the_instalments |Success:");
    }
    // **********************************************************************************************************************

    @Test(priority = 16)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "APPLICATION AND DISBURMENT") })
    @Step ("verify_that_the_loan_details_under_the_summary_page_will_contain_Amount_being_borrowed_commission_charged_insurance_Excise_duty_period_in_months")
    public void verify_that_the_loan_details_under_the_summary_page_will_contain_Amount_being_borrowed_commission_charged_insurance_Excise_duty_period_in_months()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 15 Verify that the loan details under the summary page will contain; Amount being borrowed, commission charged, insurance, Excise duty & period in months	");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.navigate().refresh();
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Get Loan\')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[contains(.,'Apply for a salary e-loan')]")).click();
	driver.findElement(By.name("TXT_AMOUNT")).clear();
	driver.findElement(By.name("TXT_AMOUNT")).sendKeys("1000");
	driver.findElement(By.xpath("//a[contains(.,\'NEXT\')]")).click();
	driver.findElement(By.xpath("//span[@name=\'LBL_COMMISSION\']")).click();
	driver.findElement(By.xpath("//span[contains(.,\'Insurance:\')]")).click();
	driver.findElement(By.xpath("//span[@name=\'LBL_EXCISE_DUTY\']")).click();
	driver.findElement(By.xpath("//span[@name=\'LBL_PERIOD\']")).click();

	System.out.println(
		"TC15 Verify- the_loan_details_under_the_summary_page_will_contain_Amount_being_borrowed_commission_charged_insurance_Excise_duty_period_in_months |Success:");
    }
    // **********************************************************************************************************************

    @Test(priority = 17)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "APPLICATION AND DISBURMENT") })
    @Step ("verify_that_the_Repayment_details_under_the_summary_page_will_contain_Total_amount_Number_of_installment_Next_Repayment_date")
    public void verify_that_the_Repayment_details_under_the_summary_page_will_contain_Total_amount_Number_of_installment_Next_Repayment_date()
	    throws InterruptedException, IOException {
	 //test =extent.createTest("16Verify that the Repayment details under the summary page will contain; Total amount, Number of instalments & Next Repayment date");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.navigate().refresh();
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Get Loan\')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[contains(.,'Apply for a salary e-loan')]")).click();
	driver.findElement(By.name("TXT_AMOUNT")).clear();
	driver.findElement(By.name("TXT_AMOUNT")).sendKeys("1000");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.xpath("//span[@name=\'LBL_PAY_AMOUNT\']")).click();
	driver.findElement(By.xpath("//span[@name=\'LBL_INSTALLMENTS\']")).click();
	driver.findElement(By.xpath("//span[@name=\'LBL_NEXT_REPAY_DATE\']")).click();

	System.out.println(
		"TC16 Verify- Repayment_details_under_the_summary_page_will_contain_Total_amount_Number_of_installment_Next_Repayment_date |Success:");
    }
    // **********************************************************************************************************************

    @Test(priority = 18)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "APPLICATION AND DISBURMENT") })
    @Step ("verify_that_Upon_ticking_the_check_box_of_Terms_Conditions_the_customer_is_able_to_click_on_the_next_button_to_proceed_to_Get_loan_page")
    public void verify_that_Upon_ticking_the_check_box_of_Terms_Conditions_the_customer_is_able_to_click_on_the_next_button_to_proceed_to_Get_loan_page()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 17 Verify that Upon ticking the checkbox of Terms & Conditions, the customer is able to click on the next button to proceed to ‘Get loan’ page");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.navigate().refresh();
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Get Loan\')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[contains(.,'Apply for a salary e-loan')]")).click();
	driver.findElement(By.name("TXT_AMOUNT")).clear();
	driver.findElement(By.id("ELOANS_LOAN_CREATE_REQ_FORM_03-TXT_AMOUNT")).sendKeys("1000");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.xpath("//label[contains(.,\'I accept\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Get Loan\')]")).click();

	System.out.println(
		"TC17 Verify- Upon_ticking_the_check_box_of_Terms_Conditions_the_customer_is_able_to_click_on_the_next_button_to_proceed_to_Get_loan_page |Success:");
    }
    // **********************************************************************************************************************

    @Test(priority = 19)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "APPLICATION AND DISBURMENT") })
    @Step ("verify_that_when_the_customer_clicks_on_the_get_loan_button_the_loan_application_is_then_committed_for_processing_He_she_proceeds_to_verify_transaction_by_Entering_an_OTP")
    public void verify_that_when_the_customer_clicks_on_the_get_loan_button_the_loan_application_is_then_committed_for_processing_He_she_proceeds_to_verify_transaction_by_Entering_an_OTP()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 18 Verify that when the customer clicks on the ‘get loan’ button, the loan application is then committed for processing. He/she proceeds to verify transaction by receiving an OTP  ");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.navigate().refresh();
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Get Loan\')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[contains(.,'Apply for a salary e-loan')]")).click();
	driver.findElement(By.name("TXT_AMOUNT")).clear();
	driver.findElement(By.name("TXT_AMOUNT")).sendKeys("1000");
	driver.findElement(By.xpath("//a[contains(.,\'NEXT\')]")).click();
	driver.findElement(By.xpath("//label[contains(.,\'I accept\')]")).click();
	driver.findElement(By.linkText("Get Loan")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("5");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("7");

	System.out.println(
		"TC18 Verify- when_the_customer_clicks_on_the_get_loan_button_the_loan_application_is_then_committed_for_processing_He_she_proceeds_to_verify_transaction_by_Entering_an_OTP |Success:");
    }
    // **********************************************************************************************************************

    @Test(priority = 20)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "APPLICATION AND DISBURMENT") })
    @Step ("verify_that_the_RESEND_OTP_link_is_functional")
    public void verify_that_the_RESEND_OTP_link_is_functional() throws InterruptedException, IOException {
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	 //test =extent.createTest(" 19 Verify that the RE-SEND OTP link is functional");
	driver.navigate().refresh();
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Get Loan\')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[contains(.,'Apply for a salary e-loan')]")).click();

	driver.findElement(By.name("TXT_AMOUNT")).clear();
	driver.findElement(By.name("TXT_AMOUNT")).sendKeys("1000");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.cssSelector(".checkbox-inline")).click();
	driver.findElement(By.linkText("Get Loan")).click();
	driver.findElement(By.id("OTP_FORM-RESEND_OTP")).click();

	System.out.println("TC19 Verify- RESEND_OTP_link_is_functional |Success:");
    }
    // **********************************************************************************************************************

    @Test(priority = 21)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "APPLICATION AND DISBURMENT") })
    @Severity(SeverityLevel.CRITICAL)
    @Step ("verify_that_The_customer_gets_a_Do_more_screen_with_the_option_of_send_money_and_pay_bill")
    public void verify_that_The_customer_gets_a_Do_more_screen_with_the_option_of_send_money_and_pay_bill()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 20 Verify that The customer gets a ‘Do more’ screen with the option of send money and pay bill");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.navigate().refresh();
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Get Loan\')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[contains(.,'Apply for a salary e-loan')]")).click();

	driver.findElement(By.name("TXT_AMOUNT")).clear();
	driver.findElement(By.name("TXT_AMOUNT")).sendKeys("10000");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.xpath("//label[contains(.,\'I accept\')]")).click();
	driver.findElement(By.linkText("Get Loan")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("5");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("6");
	driver.findElement(By.xpath("//a[contains(.,\'Submit\')]")).click();
	driver.findElement(By.name("BTN_DONE")).click();
	driver.findElement(By.xpath("//h3[contains(.,\'Do More\')]")).click();
	System.out.println("TC21 Verify- customer_gets_a_Do_more_screen_with_the_option_of_send_money_and_pay_bill |Success:");
    }
    // **********************************************************************************************************************

    @Test(priority = 22)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "APPLICATION AND DISBURMENT") })
    @Step ("verify_that_where_a_customer_has_an_existing_eloan_the_Eloan_menu_will_instead_display_Your_Next_Instalment_of_Kesxxxxxx_is_due_on_day_month_year")
    public void verify_that_where_a_customer_has_an_existing_eloan_the_Eloan_menu_will_instead_display_Your_Next_Instalment_of_Kesxxxxxx_is_due_on_day_month_year()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 21 Verify that where a customer has an existing e-loan, the E-loan menu will instead display; “Your Next Instalment of Kes. xxxxxx is due on day/month/year”");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.navigate().refresh();
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	System.out.println("TC22 Verify- that_where_a_customer_has_an_existing_eloan_the_Eloan_menu_will_instead_display_Your_Next_Instalment_of_Kesxxxxxx_is_due_on_day_month_year |Success:");
    }
    // **********************************************************************************************************************************
    @Test(priority = 23)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "APPLICATION AND DISBURMENT") })
    @Step ("End_of_Eloans_Salary_Application_And_Disbursment")
    public void End_of_Eloans_Salary_Application_And_Disbursment() throws IOException, InterruptedException {
	 //test =extent.createTest("END OF ELOANS SALARY APPLICATION AND DISBURSEMENT TESTCASE");
	System.out.println("*************************End Of Eloans_Salary_Application_And_Disbursment TestCases ***********************");
    }
    // **********************************************************************************************************************************
    @Test(priority = 24)
    @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT PARTIAL") })   
    @Step ("REPAYMENT PARTIAL")
    @Severity(SeverityLevel.MINOR)
    public void Running_REPAYMENT_PARTIALTestCases() throws IOException, InterruptedException {
	 //test =extent.createTest(" (2) RUNNING ELOANS SALARY PARTIAL PAYMENT ");
	System.out.println("*************************(2) Running Eloans_Salary_Repayment_Partial Testcases***********************************");
    }
    // **********************************************************************************************************************************
    @Test(priority = 25)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT PARTIAL") }) 
    @Severity(SeverityLevel.MINOR)
    @Step ("verify_that_the_loan_tab_is_easily_accessible_on_the_landing_page")
    public void verify_that_the_loan_tab_is_easily_accessible_on_the_landing_page()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 1 Verify that the loan tab is easily accessible on the landing page");
	 File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);		
		RBX_BILLS = new XSSFWorkbook(fis);
		sheet = RBX_BILLS.getSheet("Loginmodule");		
		for (int i = 1; i <= sheet.getLastRowNum(); i++) 	
		 cell = sheet.getRow(1).getCell(2);	
		driver.get(cell.getStringCellValue());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	    		
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
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	System.out.println("TC1 verify_that_the_loan_tab_is_easily_accessible_on_the_landing_page |Success:");
    }
    // ***********************************************************************************************************************************
    @Test(priority = 26)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT PARTIAL") }) 
    @Step ("verify_that_the_customer_can_click_on_the_loan_tab_and_proceed_to_view_details1")
    public void verify_that_the_customer_can_click_on_the_loan_tab_and_proceed_to_view_details1()
	    throws IOException, InterruptedException {
        	 //test =extent.createTest("2 Verify that the customer can click on the loan tab and proceed to view details");
        	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
        	System.out.println("TC2 verify_that_the_customer_can_click_on_the_loan_tab_and_proceed_to_view_details1 |Success:");
    	}
    // ***********************************************************************************************************************************
    @Test(priority = 27)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT PARTIAL") }) 
    @Step ("verify_that_the_Eloan_menu_has_a_button_labeled_Show_more")
    public void verify_that_the_Eloan_menu_has_a_button_labeled_Show_more() throws IOException, InterruptedException {
        	//test =extent.createTest(" 3 verify that the Eloan menu has a button labeled Show more");
        	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
        	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();        
        	System.out.println("TC3 verify_that_the_Eloan_menu_has_a_button_labeled_Show_more |Success:");
    }
    // ***********************************************************************************************************************************

    @Test(priority = 28)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT PARTIAL") }) 
    @Step ("verify_that_the_ELoan_menu_feature_contains_the_following_description_Your_Next_Instalment_of_Kesxxxxxx_is_due_on_day_month_Year")
    public void verify_that_the_ELoan_menu_feature_contains_the_following_description_Your_Next_Instalment_of_Kesxxxxxx_is_due_on_day_month_Year()
	    throws InterruptedException, IOException {
        	//test =extent.createTest(" 4 Verify that the E-Loan menu feature contains the following description; “Your Next Instalment of Kes. xxxxxx is due on -day/month/Year”");
        	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
        	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
        	driver.findElement(By.xpath("//label[contains(.,\'Next repayment\')]")).click();        
        	System.out.println("TC4 verify_that_the_ELoan_menu_feature_contains_the_following_description_Your_Next_Instalment_of_Kesxxxxxx_is_due_on_day_month_Year |Success:");
    }
    // ***********************************************************************************************************************************
@Test(priority = 29)
@Epic("ELOANS (SALARY)")
@Features(value = { @Feature(value = "REPAYMENT PARTIAL") }) 
@Step ("verify_that_the_Repay_Loan_Button_is_active")
    public void verify_that_the_Repay_Loan_Button_is_active() throws InterruptedException, IOException {
        	//test =extent.createTest(" 5 verify that the Repay Loan Button is active ");
        	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
        	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
        	driver.findElement(By.name("BTN_REPAY")).isEnabled();
        	System.out.println("TC5 verify_that_the_Repay_Loan_Button_is_active |Success:");
    }
    // ***********************************************************************************************************************************

    @Test(priority = 30)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT PARTIAL") }) 
    @Step ("verify_that_upon_clicking_on_Show_More_button_the_customer_will_either_view_Personal_Eloan_page_or_Business_ELoan_page_depending_on_the_existingeloan")
    public void verify_that_upon_clicking_on_Show_More_button_the_customer_will_either_view_Personal_Eloan_page_or_Business_ELoan_page_depending_on_the_existingeloan()
	    throws InterruptedException, IOException {
        	//test =extent.createTest("6 verify_that_upon_clicking_on_Show_More_button_the_customer_will_either_view_Personal_Eloan_page_or_Business_ELoan_page_depending_on_the_existingeloan");
        	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
        	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
        	System.out.println("TC6 verify_that_upon_clicking_on_Show_More_button_the_customer_will_either_view_Personal_Eloan_page_or_Business_ELoan_page_depending_on_the_existingeloan |Success:");
    }
    // ***********************************************************************************************************************************

    @Test(priority = 31)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT PARTIAL") }) 
    @Step ("verify_that_on_the_web_the_Next_Repayment_table_contains_the_next_installment_details_Date_Principalamount_Interest_Amount_and_total_scheduled_amount")
    public void verify_that_on_the_web_the_Next_Repayment_table_contains_the_next_installment_details_Date_Principalamount_Interest_Amount_and_total_scheduled_amount()
	    throws InterruptedException, IOException {
        	//test =extent.createTest(" 7 verify_that_on_the_web_the_Next_Repayment_table_contains_the_next_installment_details_Date_Principalamount_Interest_Amount_and_total_scheduled_amount");
        	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
        	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
        	driver.findElement(By.xpath("//label[contains(.,\'Next repayment\')]")).click();
        	driver.findElement(By.xpath("//span[contains(.,\'Due Date\')]")).click();
        	driver.findElement(By.xpath("//span[contains(.,\'Principal Amount\')]")).click();
        	driver.findElement(By.xpath("//span[contains(.,\'Interest Amount\')]")).click();
        	driver.findElement(By.xpath("//span[contains(.,\'Total Amount\')]")).click();        
        	System.out.println("TC7 verify_that_on_the_web_the_Next_Repayment_table_contains_the_next_installment_details_Date_Principalamount_Interest_Amount_and_total_scheduled_amount |Success:");
    }
    // ***********************************************************************************************************************************

    @Test(priority = 32)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT PARTIAL") }) 
    @Step ("verify_that_upon_selecting_Repay_Loan_Button_the_customer_goes_to_the_Repay_Eloan_page_that_displays_a_you_are_about_to_repay_the_below_loan_B_Repayment_Method")
    public void verify_that_upon_selecting_Repay_Loan_Button_the_customer_goes_to_the_Repay_Eloan_page_that_displays_a_you_are_about_to_repay_the_below_loan_B_Repayment_Method()
	    throws InterruptedException, IOException {
        	//test =extent.createTest(" 8 verify_that_upon_selecting_Repay_Loan_Button_the_customer_goes_to_the_Repay_Eloan_page_that_displays_a_you_are_about_to_repay_the_below_loan_B_Repayment_Method");
        	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
        	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
        	driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).click();
        	driver.findElement(By.xpath("//label[contains(.,\'You are about to repay the below loan:\')]")).click();
        	driver.findElement(By.xpath("//span[contains(.,\'Loan Account:\')]")).click();
        	driver.findElement(By.xpath("//span[contains(.,\'Loan Type:\')]")).click();
        	driver.findElement(By.xpath("//span[contains(.,\'Outstanding Loan:\')]")).click();
        	driver.findElement(By.xpath("//span[contains(.,\'Monthly Installment:\')]")).click();        
        	System.out.println("TC8 verify_that_upon_selecting_Repay_Loan_Button_the_customer_goes_to_the_Repay_Eloan_page_that_displays_a_you_are_about_to_repay_the_below_loan_B_Repayment_Method |Success:");
    }
    // ***********************************************************************************************************************************

    @Test(priority = 33)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT PARTIAL") }) 
    @Step ("Verify_that_you_are_about_to_repay_the_below_loan_section_under_Repay_Loan_Includes_Loan_ac_number_Loan_type_outstanding_balance_and_Monthly_instalment_Amount")
    public void Verify_that_you_are_about_to_repay_the_below_loan_section_under_Repay_Loan_Includes_Loan_ac_number_Loan_type_outstanding_balance_and_Monthly_instalment_Amount()
	    throws InterruptedException, IOException {
        	//test =extent.createTest(" 9 Verify_that_you_are_about_to_repay_the_below_loan_section_under_Repay_Loan_Includes_Loan_ac_number_Loan_type_outstanding_balance_and_Monthly_instalment_Amount");
        	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
        	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
        	driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).click();
        	driver.findElement(By.xpath("//label[contains(.,\'You are about to repay the below loan:\')]")).click();
        	driver.findElement(By.xpath("//span[contains(.,\'Loan Account:\')]")).click();
        	driver.findElement(By.xpath("//span[contains(.,\'Loan Type:\')]")).click();
        	driver.findElement(By.xpath("//span[contains(.,\'Outstanding Loan:\')]")).click();
        	driver.findElement(By.xpath("//span[contains(.,\'Monthly Installment:\')]")).click();        
        	System.out.println("TC9 Verify_that_you_are_about_to_repay_the_below_loan_section_under_Repay_Loan_Includes_Loan_ac_number_Loan_type_outstanding_balance_and_Monthly_instalment_Amount |Success:");
    }
    // ***********************************************************************************************************************************

    @Test(priority = 34)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT PARTIAL") }) 
    @Step ("verify_that_repayment_Method_under_Repay_loan_has_two_options_a_Partial_payment_b_Clear_Loan")
    public void verify_that_repayment_Method_under_Repay_loan_has_two_options_a_Partial_payment_b_Clear_Loan()
	    throws InterruptedException, IOException {
        	//test =extent.createTest(" 10 verify_that_repayment_Method_under_Repay_loan_has_two_options_a_Partial_payment_b_Clear_Loan");
        	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
        	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
        	driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).click();
        	driver.findElement(By.xpath("//span[contains(.,\'Partial Payment\')]")).click();
        	driver.findElement(By.xpath("//span[contains(.,\'Clear Loan\')]")).click();        
        	System.out.println("TC10 verify_that_repayment_Method_under_Repay_loan_has_two_options_a_Partial_payment_b_Clear_Loan |Success:");
    }
    // ***********************************************************************************************************************************

    @Test(priority = 35)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT PARTIAL") }) 
    @Step ("verify_that_the_Debit_Account_has_a_window_with_a_drop_down_arrow_On_clicking_on_the_drop_down_arrow_the_customer_gets_a_list_of_transactional_accounts")
    public void verify_that_the_Debit_Account_has_a_window_with_a_drop_down_arrow_On_clicking_on_the_drop_down_arrow_the_customer_gets_a_list_of_transactional_accounts()
	    throws InterruptedException, IOException {
        	//test =extent.createTest(" 11 verify_that_the_Debit_Account_has_a_window_with_a_drop_down_arrow_On_clicking_on_the_drop_down_arrow_the_customer_gets_a_list_of_transactional_accounts");
        	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
        	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
        	driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).click();
        	driver.findElement(By.xpath("//a[contains(.,\'Partial Payment\')]")).click();
        	driver.findElement(By.name("CMB_DEBIT_ACCOUNT")).click();
        	System.out.println("TC11 verify_that_repayment_Method_under_Repay_loan_has_two_options_a_Partial_payment_b_Clear_Loan |Success:");
    }
    // ***********************************************************************************************************************************

    @Test(priority = 36)  
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT PARTIAL") }) 
    @Step (" verify_that_upon_selecting_the_transactional_ac_the_available_balance_is_displayed_below_the_selected_ac")
    public void verify_that_upon_selecting_the_transactional_ac_the_available_balance_is_displayed_below_the_selected_ac()
	    throws InterruptedException, IOException {
        	//test =extent.createTest(" 12 verify_that_upon_selecting_the_transactional_ac_the_available_balance_is_displayed_below_the_selected_ac");
        	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
        	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
        	driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).click();
        	driver.findElement(By.xpath("//a[contains(.,\'Partial Payment\')]")).click();
        	driver.findElement(By.name("CMB_DEBIT_ACCOUNT")).click();
        	{
        	    WebElement dropdown = driver.findElement(By.id("ELOANS_REPAYMENT_PAY_FORM_08-CMB_DEBIT_ACCOUNT"));
        	    dropdown.findElement(By.xpath("//option[. = '01105413334100']")).click();
        	}
        	driver.findElement(By.name("CMB_DEBIT_ACCOUNT")).click();
        	driver.findElement(By.cssSelector(".LBL_BALANCE-bs .ct-form__label-val")).click();
        	System.out.println("TC12 verify_that_upon_selecting_the_transactional_ac_the_available_balance_is_displayed_below_the_selected_ac |Success:");

    }
    // ***********************************************************************************************************************************

    @Test(priority = 37)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT PARTIAL") }) 
    @Step ("verify_that_the_user_cannot_proceed_without_entering_the_amount_to_pay_he_she_will_get_an_error_Please_enter_an_amount_to_proceed")
    public void verify_that_the_user_cannot_proceed_without_entering_the_amount_to_pay_he_she_will_get_an_error_Please_enter_an_amount_to_proceed()
	    throws InterruptedException, IOException {
        	//test =extent.createTest("13 verify_that_the_user_cannot_proceed_without_entering_the_amount_to_pay_he_she_will_get_an_error_Please_enter_an_amount_to_proceed");
        	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
        	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
        	driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).click();
        	driver.findElement(By.linkText("Partial Payment")).click();
        	driver.findElement(By.id("ELOANS_REPAYMENT_PAY_FORM_08-CMB_DEBIT_ACCOUNT")).click();
        	{
        	    WebElement dropdown = driver.findElement(By.id("ELOANS_REPAYMENT_PAY_FORM_08-CMB_DEBIT_ACCOUNT"));
        	    dropdown.findElement(By.xpath("//option[. = '01105413334100']")).click();
        	}
        	driver.findElement(By.name("CMB_DEBIT_ACCOUNT")).click();
        	driver.findElement(By.xpath("//button[contains(.,\'Next\')]")).click();
        	driver.findElement(By.cssSelector(".error_msg_bottom > .ct-form__err")).isDisplayed();
        	System.out.println("TC13 Verify- a user can select home menu button card tab verify_that_the_user_cannot_proceed_without_entering_the_amount_to_pay_he_she_will_get_an_error_Please_enter_an_amount_to_proceed|Success:");
    }
    // ***********************************************************************************************************************************

    @Test(priority = 38)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT PARTIAL") }) 
    @Step ("verify_that_the_user_cannot_proceed_without_selecting_an_account_to_debit_he_she_will_get_an_error_Please_select_an_account_to_proceed")
    public void verify_that_the_user_cannot_proceed_without_selecting_an_account_to_debit_he_she_will_get_an_error_Please_select_an_account_to_proceed()
	    throws InterruptedException, IOException {
        	//test =extent.createTest("14 verify_that_the_user_cannot_proceed_without_selecting_an_account_to_debit_he_she_will_get_an_error_Please_select_an_account_to_proceed");
        	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
        	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
        	driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).click();
        	driver.findElement(By.xpath("//a[contains(.,\'Partial Payment\')]")).click();
        	driver.findElement(By.name("TXT_AMOUNT")).click();
        	driver.findElement(By.name("TXT_AMOUNT")).sendKeys("100");
        	driver.findElement(By.xpath("//button[contains(.,\'Next\')]")).click();
        	driver.findElement(By.cssSelector(".error_msg_bottom > .ct-form__err")).click();
        	System.out.println("TC14 verify_that_the_user_cannot_proceed_without_selecting_an_account_to_debit_he_she_will_get_an_error_Please_select_an_account_to_proceed|Success:");
    }
    // ***********************************************************************************************************************************

    @Test(priority = 39)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT PARTIAL") }) 
    @Step ("verify_that_when_the_customer_clicks_on_Pay_loan_Button_he_proceeds_to_Verify_Transaction_page_OTP_page")
    public void verify_that_when_the_customer_clicks_on_Pay_loan_Button_he_proceeds_to_Verify_Transaction_page_OTP_page()
	    throws InterruptedException, IOException {
	 //test =extent.createTest("15 verify_that_when_the_customer_clicks_on_Pay_loan_Button_he_proceeds_to_Verify_Transaction_page_OTP_page");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Partial Payment\')]")).click();
	driver.findElement(By.name("CMB_DEBIT_ACCOUNT")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("ELOANS_REPAYMENT_PAY_FORM_08-CMB_DEBIT_ACCOUNT"));
	    dropdown.findElement(By.xpath("//option[. = '01105413334100']")).click();
	}
	driver.findElement(By.name("CMB_DEBIT_ACCOUNT")).click();
	driver.findElement(By.name("TXT_AMOUNT")).click();
	driver.findElement(By.name("TXT_AMOUNT")).sendKeys("100");
	driver.findElement(By.xpath("//button[contains(.,\'Next\')]")).click();
	driver.findElement(By.xpath("//label[contains(.,\'I accept\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Pay Loan\')]")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).click();
	System.out.println("TC15 verify_that_when_the_customer_clicks_on_Pay_loan_Button_he_proceeds_to_Verify_Transaction_page_OTP_page |Success:");

    }
    // ***********************************************************************************************************************************

    @Test(priority = 40)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT PARTIAL") }) 
    @Step ("Verify_that_the_customer_can_then_submit_the_payment_for_processing_after_validating_OTP")
    public void Verify_that_the_customer_can_then_submit_the_payment_for_processing_after_validating_OTP()
	    throws InterruptedException, IOException {
	 //test =extent.createTest("16 Verify_that_the_customer_can_then_submit_the_payment_for_processing_after_validating_OTP");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Partial Payment\')]")).click();
	driver.findElement(By.name("CMB_DEBIT_ACCOUNT")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("ELOANS_REPAYMENT_PAY_FORM_08-CMB_DEBIT_ACCOUNT"));
	    dropdown.findElement(By.xpath("//option[. = '01105413334100']")).click();
	}
	driver.findElement(By.name("CMB_DEBIT_ACCOUNT")).click();
	driver.findElement(By.name("TXT_AMOUNT")).click();
	driver.findElement(By.name("TXT_AMOUNT")).sendKeys("100");
	driver.findElement(By.xpath("//button[contains(.,\'Next\')]")).click();
	driver.findElement(By.xpath("//label[contains(.,\'I accept\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Pay Loan\')]")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("4");
	driver.findElement(By.xpath("//a[contains(.,\'Submit\')]")).click();
	System.out.println("TC16 Verify_that_the_customer_can_then_submit_the_payment_for_processing_after_validating_OTP |Success:");

    }
    // ***********************************************************************************************************************************

    @Test(priority = 41)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT PARTIAL") }) 
    @Severity(SeverityLevel.CRITICAL)
    @Step ("Verify_that_the_Pop_up_Notification_has_an_Ok_button")
    public void Verify_that_the_Pop_up_Notification_has_an_Ok_button() throws InterruptedException, IOException {
	 //test =extent.createTest("17 Verify_that_the_Pop_up_Notification_has_an_Ok_button");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Partial Payment\')]")).click();
	driver.findElement(By.name("CMB_DEBIT_ACCOUNT")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("ELOANS_REPAYMENT_PAY_FORM_08-CMB_DEBIT_ACCOUNT"));
	    dropdown.findElement(By.xpath("//option[. = '01105413334100']")).click();
	}
	driver.findElement(By.name("CMB_DEBIT_ACCOUNT")).click();
	driver.findElement(By.name("TXT_AMOUNT")).click();
	driver.findElement(By.name("TXT_AMOUNT")).sendKeys("100");
	driver.findElement(By.xpath("//button[contains(.,\'Next\')]")).click();
	driver.findElement(By.xpath("//label[contains(.,\'I accept\')]")).click();
	;
	driver.findElement(By.xpath("//a[contains(.,\'Pay Loan\')]")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("4");
	driver.findElement(By.xpath("//a[contains(.,\'Submit\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'OK\')]")).click();

	System.out.println("TC17 Verify_that_the_Pop_up_Notification_has_an_Ok_butto |Success:");
    }
    // ***********************************************************************************************************************************

    @Test(priority = 42)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT PARTIAL") }) 
    @Step ("Verify_that_upon_Clicking_the_Ok_button_the_customer_goes_back_to_the_page_that_displays_the_current_status_of_the_loan")
    public void Verify_that_upon_Clicking_the_Ok_button_the_customer_goes_back_to_the_page_that_displays_the_current_status_of_the_loan()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 18 Verify_that_upon_Clicking_the_Ok_button_the_customer_goes_back_to_the_page_that_displays_the_current_status_of_the_loan");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Partial Payment\')]")).click();
	driver.findElement(By.name("CMB_DEBIT_ACCOUNT")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("ELOANS_REPAYMENT_PAY_FORM_08-CMB_DEBIT_ACCOUNT"));
	    dropdown.findElement(By.xpath("//option[. = '01105413334100']")).click();
	}
	driver.findElement(By.name("CMB_DEBIT_ACCOUNT")).click();
	driver.findElement(By.name("TXT_AMOUNT")).click();
	driver.findElement(By.name("TXT_AMOUNT")).sendKeys("4000");
	driver.findElement(By.xpath("//button[contains(.,\'Next\')]")).click();
	driver.findElement(By.xpath("//label[contains(.,\'I accept\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Pay Loan\')]")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("4");
	driver.findElement(By.xpath("//a[contains(.,\'Submit\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'OK\')]")).click();

	System.out.println(
		"TC18 Verify_that_upon_Clicking_the_Ok_button_the_customer_goes_back_to_the_page_that_displays_the_current_status_of_the_loan|Success:");

    }

//*****************************************************************************************************************  
    @Test(priority = 43)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT PARTIAL") }) 
    @Severity(SeverityLevel.MINOR)
    @Step ("End Of Eloans_Salary_Repayment_Partial Testcases")
    public void End_of_REPAYMENT_PARTIALTestCases() throws IOException, InterruptedException {
	 //test =extent.createTest("End Of Eloans_Salary_Repayment_Partial Testcases ");
	System.out.println("*************************End Of Eloans_Salary_Repayment_Partial Testcases***********************************");
    }
//*****************************************************************************************************************  

    @Test(priority = 44)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "SALARY REFINANCE") }) 
    @Severity(SeverityLevel.MINOR)
    @Step ("SALARY REFINANCE")
    public void running_Salary_Refinance_TestCases() throws IOException, InterruptedException {
	 //test =extent.createTest("(3) Running salary refinance Testcases");
	System.out.println("*************************(3) Running salary refinance Testcases***********************************");
    }

    // **********************************************************************************************************************************
    @Test(priority = 45)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "SALARY REFINANCE") }) 
    @Severity(SeverityLevel.MINOR)
    @Step ("verify_that_the_loan_tab_is_easily_accessible_on_the_landing_page3")
    public void verify_that_the_loan_tab_is_easily_accessible_on_the_landing_page3()
	    throws InterruptedException, IOException {
	 //test =extent.createTest("1 verify_that_the_loan_tab_is_easily_accessible_on_the_landing_page3");
	 File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);		
		RBX_BILLS = new XSSFWorkbook(fis);
		sheet = RBX_BILLS.getSheet("Loginmodule");		
		for (int i = 1; i <= sheet.getLastRowNum(); i++) 	
		 cell = sheet.getRow(1).getCell(2);	
		driver.get(cell.getStringCellValue());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	    		
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
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	System.out.println("TC18 verify_that_the_loan_tab_is_easily_accessible_on_the_landing_page3 |Success:");
    }
    // ***********************************************************************************************************************************

    @Test(priority = 46)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "SALARY REFINANCE") }) 
    @Step ("verify_that_the_customer_can_click_on_the_loan_tab_and_proceed_to_view_details2")
    public void verify_that_the_customer_can_click_on_the_loan_tab_and_proceed_to_view_details2()
	    throws IOException, InterruptedException {
	 //test =extent.createTest(" 2 verify_that_the_customer_can_click_on_the_loan_tab_and_proceed_to_view_details2");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	System.out.println(
		"TC18 verify_that_the_customer_can_click_on_the_loan_tab_and_proceed_to_view_details2 |Success:");
    }
    // ***********************************************************************************************************************************

    @Test(priority = 47)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "SALARY REFINANCE") }) 
    @Step ("verify_that_the_Salary_Eloan_menu_has_a_button_labeled_Show_more")
    public void verify_that_the_Salary_Eloan_menu_has_a_button_labeled_Show_more()
	    throws IOException, InterruptedException {
	 //test =extent.createTest(" 3 verify_that_the_Salary_Eloan_menu_has_a_button_labeled_Show_more");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	System.out.println("TC18 verify_that_the_Salary_Eloan_menu_has_a_button_labeled_Show_mor |Success:");
    }
    // ***********************************************************************************************************************************

    @Test(priority = 48)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "SALARY REFINANCE") }) 
    @Step ("Verify_that_a_customer_that_has_paid_partially_installment_cannot_successfully_apply_for_a_refinance_loan")
    public void Verify_that_a_customer_that_has_paid_partially_installment_cannot_successfully_apply_for_a_refinance_loan()
	    throws IOException, InterruptedException {
	 //test =extent.createTest(" 4 Verify_that_a_customer_that_has_paid_partially_installment_cannot_successfully_apply_for_a_refinance_loan");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);

	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Refinance\')]")).click();
	System.out.println(
		"TC18 Verify_that_a_customer_that_has_paid_partially_installment_cannot_successfully_apply_for_a_refinance_loan |Success:");
    }
    // ***********************************************************************************************************************************

    @Test(priority = 49)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "SALARY REFINANCE") }) 
    @Step ("Verify_that_a_customer_can_access_refinance_button")
    public void Verify_that_a_customer_can_access_refinance_button() throws IOException, InterruptedException {
	 //test =extent.createTest(" 5 Verify_that_a_customer_can_access_refinance_button");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);

	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Refinance\')]")).click();
	Thread.sleep(2000);
	System.out.println("TC18 Verify_that_a_customer_can_access_refinance_button |Success:");
    }
    // ***********************************************************************************************************************************

    @Test(priority = 50)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "SALARY REFINANCE") }) 
    @Step ("Verify_that_user_can_apply_for_a_loan_Refinance")
    public void Verify_that_user_can_apply_for_a_loan_Refinance() throws IOException, InterruptedException {
	 //test =extent.createTest(" 6 Verify_that_user_can_apply_for_a_loan_Refinance");
	 Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Refinance\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'NEXT\')]")).click();
	driver.findElement(By.xpath("//label[contains(.,\'I accept\')]")).click();
	driver.findElement(By.linkText("Get Loan")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("2");
	driver.findElement(By.xpath("//a[contains(.,\'Submit\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'OK\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Skip\')]")).click();
	System.out.println("TC18 Verify_that_user_can_apply_for_a_loan_Refinance |Success:");
    }

    // *****************************************************************************************************************
    @Test(priority = 51)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "SALARY REFINANCE") }) 
    @Step ("End_Of_Eloans_Salary_Refinance_TestCases")
    public void End_Of_Eloans_Salary_Refinance_TestCases() throws IOException, InterruptedException {
	 //test =extent.createTest("End of Eloans Salary Refinance");
	System.out.println("*************************End of Eloans Salary Refinance***********************************");
    }
    // **********************************************************************************************************************************

    @Test(priority = 52)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT CLEAR LOAN") }) 
    @Step ("REPAYMENT CLEAR LOAN")
    @Severity(SeverityLevel.MINOR)
    public void Running_REPAYMENT_CLEAR_LOAN_TestCases() throws IOException, InterruptedException {
	 //test =extent.createTest("(4) Running_REPAYMENT CLEAR LOAN_TestCases");
	System.out.println("*************************(4) Running Eloans Salary Repayment Clear***********************************");
    }

    // **********************************************************************************************************************************
    @Test(priority = 53)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT CLEAR LOAN") }) 
    @Severity(SeverityLevel.MINOR)
    @Step ("verify_that_the_customer_can_view_Loan_tab_on_home_page")
    public void verify_that_the_customer_can_view_Loan_tab_on_home_page() throws InterruptedException, IOException {
	 //test =extent.createTest(" 1 verify_that_the_customer_can_view_Loan_tab_on_home_page");
	 File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);		
		RBX_BILLS = new XSSFWorkbook(fis);
		sheet = RBX_BILLS.getSheet("Loginmodule");		
		for (int i = 1; i <= sheet.getLastRowNum(); i++) 	
		 cell = sheet.getRow(1).getCell(2);	
		driver.get(cell.getStringCellValue());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	    		
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
	{
	    WebDriverWait wait1 = new WebDriverWait(driver, 30);
	    wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(.,'Loans')]")));
	}
	driver.findElement(By.xpath("//span[contains(.,'Loans')]")).click();
	System.out.println("TC1 verify_that_the_customer_can_view_Loan_tab_on_home_page |Success:");
    }

    // *****************************************************************************************************************
    @Test(priority = 54)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT CLEAR LOAN") }) 
    @Step ("Verify_that_the_customer_chooses_the_Loan_tab_on_home_page_which_then_displays_the_Eloan_menu")
    public void Verify_that_the_customer_chooses_the_Loan_tab_on_home_page_which_then_displays_the_Eloan_menu()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 2 Verify_that_the_customer_chooses_the_Loan_tab_on_home_page_which_then_displays_the_Eloan_menu");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.cssSelector(".LoanAccount")).click();
	System.out.println("TC2 Verify_that_the_customer_chooses_the_Loan_tab_on_home_page_which_then_displays_the_Eloan_menu |Success:");
    }

    // *****************************************************************************************************************
    @Test(priority = 55)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT CLEAR LOAN") }) 
    @Step ("Verify_that_the_ELoan_menu_feature_contains_the_following_description_Your_Next_Instalment_of_Kesxxxxxx_is_due_on_day_month_Year")
    public void Verify_that_the_ELoan_menu_feature_contains_the_following_description_Your_Next_Instalment_of_Kesxxxxxx_is_due_on_day_month_Year()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 3 Verify_that_the_ELoan_menu_feature_contains_the_following_description_Your_Next_Instalment_of_Kesxxxxxx_is_due_on_day_month_Year");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.cssSelector(".LoanAccount")).click();
	System.out.println("TC3 Verify_that_the_ELoan_menu_feature_contains_the_following_description_Your_Next_Instalment_of_Kesxxxxxx_is_due_on_day_month_Year |Success:");
    }

    // *****************************************************************************************************************
    @Test(priority = 56)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT CLEAR LOAN") }) 
    @Step ("Verify_that_the_Eloan_menu_has_a_button_labeled_Show_more")
    public void Verify_that_the_Eloan_menu_has_a_button_labeled_Show_more() throws IOException, InterruptedException {
	 //test =extent.createTest(" 4 Verify_that_the_Eloan_menu_has_a_button_labeled_Show_more");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	System.out.println("TC4 Verify_that_the_Eloan_menu_has_a_button_labeled_Show_more |Success:");
    }

    // *****************************************************************************************************************
    @Test(priority = 57)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT CLEAR LOAN") }) 
    @Step ("Verify_that_upon_clicking_on_Show_More_button_the_customer_can_either_view_Personal_Eloan_or_Business_eLoan_page_depending_on_the_existing_eloan")
    public void Verify_that_upon_clicking_on_Show_More_button_the_customer_can_either_view_Personal_Eloan_or_Business_eLoan_page_depending_on_the_existing_eloan()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 5 Verify_that_upon_clicking_on_Show_More_button_the_customer_can_either_view_Personal_Eloan_or_Business_eLoan_page_depending_on_the_existing_eloan");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	System.out.println(
		"TC5 Verify_that_upon_clicking_on_Show_More_button_the_customer_can_either_view_Personal_Eloan_or_Business_eLoan_page_depending_on_the_existing_eloan |Success:");
    }

    // *****************************************************************************************************************
    @Test(priority = 58)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT CLEAR LOAN") }) 
    @Step ("Verify_that_the_Repay_Loan_Button_is_active")
    public void Verify_that_the_Repay_Loan_Button_is_active() throws IOException, InterruptedException {
	 //test =extent.createTest(" 6 Verify_that_the_Repay_Loan_Button_is_active");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).isEnabled();
	System.out.println("TC6 Verify_that_the_Repay_Loan_Button_is_active |Success:");
    }

    // *****************************************************************************************************************
    @Test(priority = 59)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT CLEAR LOAN") }) 
    @Step ("Verify_that_on_the_web_the_Loan_payment_table_shows_previous_installments_paid_by_the_customer_Date_Principal_amount_Interest_Amount_and_total_scheduled_amount")
    public void Verify_that_on_the_web_the_Loan_payment_table_shows_previous_installments_paid_by_the_customer_Date_Principal_amount_Interest_Amount_and_total_scheduled_amount()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 7 Verify_that_on_the_web_the_Loan_payment_table_shows_previous_installments_paid_by_the_customer_Date_Principal_amount_Interest_Amount_and_total_scheduled_amount");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	driver.findElement(By.xpath("//span[contains(.,\'Due Date\')]")).isDisplayed();
	driver.findElement(By.xpath("//span[contains(.,\'Principal Amount\')]")).isDisplayed();
	driver.findElement(By.xpath("//span[contains(.,\'Interest Amount\')]")).isDisplayed();
	System.out.println(
		"TC7 Verify_that_on_the_web_the_Loan_payment_table_shows_previous_installments_paid_by_the_customer_Date_Principal_amount_Interest_Amount_and_total_scheduled_amount|Success:");
    }

    // *****************************************************************************************************************
    @Test(priority = 60)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT CLEAR LOAN") }) 
    @Step ("Verify_that_upon_selecting_Repay_Loan_Button_the_customer_goes_to_the_Repay_Eloan_page_that_displays_a_you_are_about_to_repay_the_below_loan_b_Repayment_Method")
    public void Verify_that_upon_selecting_Repay_Loan_Button_the_customer_goes_to_the_Repay_Eloan_page_that_displays_a_you_are_about_to_repay_the_below_loan_b_Repayment_Method()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 8 Verify_that_upon_selecting_Repay_Loan_Button_the_customer_goes_to_the_Repay_Eloan_page_that_displays_a_you_are_about_to_repay_the_below_loan_b_Repayment_Method");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).click();
	driver.findElement(By.xpath("//label[contains(.,\'You are about to repay the below loan:\')]")).click();
	driver.findElement(By.xpath("//span[contains(.,\'Loan Account:\')]")).click();
	driver.findElement(By.xpath("//span[contains(.,\'Loan Type:\')]")).click();
	driver.findElement(By.xpath("//span[contains(.,\'Outstanding Loan:\')]")).click();
	driver.findElement(By.xpath("//span[contains(.,\'Monthly Installment:\')]")).click();
	driver.findElement(By.xpath("//label[contains(.,\'Repayment Method:\')]")).click();
	System.out.println(
		"TC8 Verify_that_upon_selecting_Repay_Loan_Button_the_customer_goes_to_the_Repay_Eloan_page_that_displays_a_you_are_about_to_repay_the_below_loan_b_Repayment_Metho |Success:");
    }

    // *****************************************************************************************************************
    @Test(priority = 61)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT CLEAR LOAN") }) 
    @Step ("Verify_that_you_are_about_to_repay_the_below_loan_section_under_Repay_Loan_Includes_Loan_ac_number_Loan_type_outstanding_balance_and_Monthly_installment_Amount")
    public void Verify_that_you_are_about_to_repay_the_below_loan_section_under_Repay_Loan_Includes_Loan_ac_number_Loan_type_outstanding_balance_and_Monthly_installment_Amount()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 9 Verify_that_you_are_about_to_repay_the_below_loan_section_under_Repay_Loan_Includes_Loan_ac_number_Loan_type_outstanding_balance_and_Monthly_installment_Amount");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).click();
	driver.findElement(By.xpath("//span[contains(.,\'Loan Account:\')]")).click();
	driver.findElement(By.xpath("//span[contains(.,\'Loan Type:\')]")).click();
	driver.findElement(By.xpath("//span[contains(.,\'Outstanding Loan:\')]")).click();
	driver.findElement(By.xpath("//span[contains(.,\'Monthly Installment:\')]")).click();
	System.out.println(
		"TC9 Verify_that_you_are_about_to_repay_the_below_loan_section_under_Repay_Loan_Includes_Loan_ac_number_Loan_type_outstanding_balance_and_Monthly_installment_Amount |Success:");
    }

    // *****************************************************************************************************************
    @Test(priority = 62)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT CLEAR LOAN") }) 
    @Step ("Verify_that_repayment_Method_under_Repay_loan_has_two_options_a_Partial_payment_b_Clear_Loan")
    public void Verify_that_repayment_Method_under_Repay_loan_has_two_options_a_Partial_payment_b_Clear_Loan()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 10 Verify_that_repayment_Method_under_Repay_loan_has_two_options_a_Partial_payment_b_Clear_Loan");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).click();
	driver.findElement(By.xpath("//span[contains(.,\'Partial Payment\')]")).isDisplayed();
	driver.findElement(By.xpath("//span[contains(.,\'Clear Loan\')]")).isDisplayed();
	System.out.println(
		"TC10 Verify_that_repayment_Method_under_Repay_loan_has_two_options_a_Partial_payment_b_Clear_Loan |Success:");
    }

    // *****************************************************************************************************************
    @Test(priority = 63)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT CLEAR LOAN") }) 
    @Step ("Verify_that_the_Debit_Account_has_a_window_with_a_drop_down_arrow_On_clicking_on_the_drop_down_arrow_the_customer_gets_a_list_of_transactional_accounts")
    public void Verify_that_the_Debit_Account_has_a_window_with_a_drop_down_arrow_On_clicking_on_the_drop_down_arrow_the_customer_gets_a_list_of_transactional_accounts()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 11 Verify_that_the_Debit_Account_has_a_window_with_a_drop_down_arrow_On_clicking_on_the_drop_down_arrow_the_customer_gets_a_list_of_transactional_accounts");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Partial Payment\')]")).click();
	driver.findElement(By.name("CMB_DEBIT_ACCOUNT")).click();
	System.out.println(
		"TC11 Verify_that_the_Debit_Account_has_a_window_with_a_drop_down_arrow_On_clicking_on_the_drop_down_arrow_the_customer_gets_a_list_of_transactional_accounts |Success:");
    }

    // *****************************************************************************************************************
    @Test(priority = 64)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT CLEAR LOAN") }) 
    @Step ("Verify_that_upon_selecting_the_transaction_AC_the_available_balance_is_displayed_below_the_selected_AC")
    public void Verify_that_upon_selecting_the_transaction_AC_the_available_balance_is_displayed_below_the_selected_AC()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 12 Verify_that_upon_selecting_the_transaction_AC_the_available_balance_is_displayed_below_the_selected_AC");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Clear Loan\')]")).click();
	driver.findElement(By.name("CMB_DEBIT_ACCOUNT_FULL")).click();
	driver.findElement(By.name("CMB_DEBIT_ACCOUNT_FULL")).sendKeys("01105413334100");
	driver.findElement(By.xpath("//span[@name=\'LBL_BALANCE_FULL\']")).click();
	System.out.println(
		"TC12 Verify_that_upon_selecting_the_transaction_AC_the_available_balance_is_displayed_below_the_selected_AC |Success:");
    }

    // *****************************************************************************************************************
    @Test(priority = 65)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT CLEAR LOAN") }) 
    @Step ("Verify_that_the_customer_can_click_on_Next_button_to_proceed_to_the_Repay_Eloan_Summary_page")
    public void Verify_that_the_customer_can_click_on_Next_button_to_proceed_to_the_Repay_Eloan_Summary_page()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 13 Verify_that_the_customer_can_click_on_Next_button_to_proceed_to_the_Repay_Eloan_Summary_page");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Clear Loan\')]")).click();
	driver.findElement(By.name("CMB_DEBIT_ACCOUNT_FULL")).click();
	driver.findElement(By.name("CMB_DEBIT_ACCOUNT_FULL")).sendKeys("01105413334100");
	driver.findElement(By.name("BTN_NEXT_FULL")).click();
	System.out.println(
		"TC13 Verify_that_the_customer_can_click_on_Next_button_to_proceed_to_the_Repay_Eloan_Summary_page|Success:");
    }

    // ****************************************************************************************************************
    @Test(priority = 66)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT CLEAR LOAN") }) 
    @Step ("Verify_that_the_Repay_Eloan_Summary_page_has_the_below_detail_A_Repayment_Details_B_Debit_Details_C_A_note_on_next_instalments_D_Terms_condition_TC_box_E_Cancel_Button_F_Pay_Loan_Button")
    public void Verify_that_the_Repay_Eloan_Summary_page_has_the_below_detail_A_Repayment_Details_B_Debit_Details_C_A_note_on_next_instalments_D_Terms_condition_TC_box_E_Cancel_Button_F_Pay_Loan_Button()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 14 Verify_that_the_Repay_Eloan_Summary_page_has_the_below_detail_A_Repayment_Details_B_Debit_Details_C_A_note_on_next_instalments_D_Terms_condition_TC_box_E_Cancel_Button_F_Pay_Loan_Button");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Clear Loan\')]")).click();
	driver.findElement(By.name("CMB_DEBIT_ACCOUNT_FULL")).sendKeys("01105413334100");
	driver.findElement(By.name("BTN_NEXT_FULL")).click();
	driver.findElement(By.xpath("//label[contains(.,\'Repayment Details\')]")).click();
	driver.findElement(By.xpath("//label[contains(.,\'Debit Details\')]")).click();
	driver.findElement(By.xpath("//label[contains(.,\'Loan Details\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Cancel\')]")).click();
	System.out.println(
		"TC14 Verify_that_the_Repay_Eloan_Summary_page_has_the_below_detail_A_Repayment_Details_B_Debit_Details_C_A_note_on_next_instalments_D_Terms_condition_TC_box_E_Cancel_Button_F_Pay_Loan_Button|Success:");
    }

    // *****************************************************************************************************************
    @Test(priority = 67)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT CLEAR LOAN") }) 
    @Step ("Verify_that_the_Repayment_Details_will_display_Amount_Loan_Account_and_New_Balance")
    public void Verify_that_the_Repayment_Details_will_display_Amount_Loan_Account_and_New_Balance()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 15 Verify_that_the_Repayment_Details_will_display_Amount_Loan_Account_and_New_Balance");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Clear Loan\')]")).click();
	driver.findElement(By.name("CMB_DEBIT_ACCOUNT_FULL")).click();
	driver.findElement(By.name("CMB_DEBIT_ACCOUNT_FULL")).sendKeys("01105413334100");
	driver.findElement(By.name("BTN_NEXT_FULL")).click();
	driver.findElement(By.xpath("//span[contains(.,\'Amount:\')]")).click();
	driver.findElement(By.xpath("//span[@name=\'LBL_LOAN_ACCOUNT_SUMM\']")).click();
	driver.findElement(By.xpath("//span[@name=\'LBL_NEW_LOAN_BALANCE\']")).click();
	System.out.println(
		"TC15 Verify_that_the_Repayment_Details_will_display_Amount_Loan_Account_and_New_Balance |Success:");
    }

    // *****************************************************************************************************************
    @Test(priority = 68)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT CLEAR LOAN") }) 
    @Step ("Verify_that_Pay_Loan_Button_is_only_active_after_the_customer_accepts_the_TCs_by_ticking_the_box")
    public void Verify_that_Pay_Loan_Button_is_only_active_after_the_customer_accepts_the_TCs_by_ticking_the_box()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 16 Verify_that_Pay_Loan_Button_is_only_active_after_the_customer_accepts_the_TCs_by_ticking_the_box");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Clear Loan\')]")).click();
	driver.findElement(By.name("CMB_DEBIT_ACCOUNT_FULL")).click();
	driver.findElement(By.name("CMB_DEBIT_ACCOUNT_FULL")).sendKeys("01105413334100");
	driver.findElement(By.name("BTN_NEXT_FULL")).click();
	driver.findElement(By.xpath("//label[contains(.,\'I accept\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Pay Loan\')]")).isDisplayed();
	driver.findElement(By.xpath("//label[contains(.,\'I accept\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Pay Loan\')]")).isEnabled();
	System.out.println(
		"TC16 Verify_that_Pay_Loan_Button_is_only_active_after_the_customer_accepts_the_TCs_by_ticking_the_box |Success:");
    }

    // *****************************************************************************************************************
    @Test(priority = 69)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT CLEAR LOAN") }) 
    @Step ("Verify_that_when_the_customer_clicks_on_Pay_loan_Button_he_proceeds_to_Verify_Transaction_page_OTP_page")
    public void Verify_that_when_the_customer_clicks_on_Pay_loan_Button_he_proceeds_to_Verify_Transaction_page_OTP_page()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 17 Verify_that_when_the_customer_clicks_on_Pay_loan_Button_he_proceeds_to_Verify_Transaction_page_OTP_page");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Clear Loan\')]")).click();
	driver.findElement(By.name("CMB_DEBIT_ACCOUNT_FULL")).click();
	driver.findElement(By.name("CMB_DEBIT_ACCOUNT_FULL")).sendKeys("01105413334100");
	driver.findElement(By.name("BTN_NEXT_FULL")).click();
	driver.findElement(By.xpath("//label[contains(.,\'I accept\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Pay Loan\')]")).click();
	System.out.println(
		"TC17 Verify_that_when_the_customer_clicks_on_Pay_loan_Button_he_proceeds_to_Verify_Transaction_page_OTP_page |Success:");
    }

    // *****************************************************************************************************************
    @Test(priority = 70)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT CLEAR LOAN") }) 
    @Step ("Verify_that_in_case_the_customer_does_not_get_an_OTP_he_can_request_for_it_to_be_resent_from_the_OTP_screen")
    public void Verify_that_in_case_the_customer_does_not_get_an_OTP_he_can_request_for_it_to_be_resent_from_the_OTP_screen()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 18 Verify_that_in_case_the_customer_does_not_get_an_OTP_he_can_request_for_it_to_be_resent_from_the_OTP_screen");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Clear Loan\')]")).click();
	driver.findElement(By.name("CMB_DEBIT_ACCOUNT_FULL")).click();
	driver.findElement(By.name("CMB_DEBIT_ACCOUNT_FULL")).sendKeys("01105413334100");
	driver.findElement(By.name("BTN_NEXT_FULL")).click();
	driver.findElement(By.xpath("//label[contains(.,\'I accept\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Pay Loan\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Didnt receive OTP?\')]")).click();
	System.out.println(
		"TC18 Verify_that_in_case_the_customer_does_not_get_an_OTP_he_can_request_for_it_to_be_resent_from_the_OTP_screen |Success:");
    }

    // *****************************************************************************************************************
    @Test(priority = 71)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT CLEAR LOAN") }) 
    @Severity(SeverityLevel.BLOCKER)
    @Step ("Verify_that_when_the_customer_enters_the_OTP_the_transaction_should_be_processed_after_clicking_the_Confirm_button")
    public void Verify_that_when_the_customer_enters_the_OTP_the_transaction_should_be_processed_after_clicking_the_Confirm_button()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 19 Verify_that_when_the_customer_enters_the_OTP_the_transaction_should_be_processed_after_clicking_the_Confirm_button");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Clear Loan\')]")).click();
	driver.findElement(By.name("CMB_DEBIT_ACCOUNT_FULL")).click();
	driver.findElement(By.name("CMB_DEBIT_ACCOUNT_FULL")).sendKeys("01105413334100");
	driver.findElement(By.name("BTN_NEXT_FULL")).click();
	driver.findElement(By.xpath("//label[contains(.,\'I accept\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Pay Loan\')]")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("5");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("6");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("8");
	driver.findElement(By.xpath("//a[contains(.,\'Submit\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'OK\')]")).click();
	System.out.println(
		"TC19 Verify_that_when_the_customer_enters_the_OTP_the_transaction_should_be_processed_after_clicking_the_Confirm_button |Success:");
    }

    // *****************************************************************************************************************
    @Test(priority = 72)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "REPAYMENT CLEAR LOAN") }) 
    @Step ("End of Eloans Salary Repayment Clear")
    public void End_Of_REPAYMENT_CLEAR_LOAN_TestCases() throws IOException, InterruptedException {
	 //test =extent.createTest("End of Eloans Salary Repayment Clear ");
	System.out.println("*************************End of Eloans Salary Repayment Clear***********************************");
    }
    // **********************************************************************************************************************************
    // ***********************************************************************************************************************************

    @Test(priority = 73)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "ELOANS SALARY GET TOP UP") })  
    @Severity(SeverityLevel.MINOR)
    @Step ("ELOANS SALARY GET TOP UP")
    public void Running_Of_Eloans_Salary_Get_top_up_TestCases() throws IOException, InterruptedException {
	 //test =extent.createTest("(5) Running of Eloans Salary Get Top Up");
	System.out.println("*************************(5) Running of Eloans Salary Get Top Up***********************************");
    }

    // *****************************************************************************************************************
    @Test(priority = 74)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "ELOANS SALARY GET TOP UP") })
    @Severity(SeverityLevel.MINOR)
    @Step ("verify_that_the_loan_tab_is_easily_accessible_on_the_landing_page4")
    public void verify_that_the_loan_tab_is_easily_accessible_on_the_landing_page4()
	    throws InterruptedException, IOException {
	 //test =extent.createTest(" 1 verify_that_the_loan_tab_is_easily_accessible_on_the_landing_page4");
	 File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);		
		RBX_BILLS = new XSSFWorkbook(fis);
		sheet = RBX_BILLS.getSheet("Loginmodule");		
		for (int i = 1; i <= sheet.getLastRowNum(); i++) 	
		 cell = sheet.getRow(1).getCell(2);	
		driver.get(cell.getStringCellValue());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	    		
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
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	System.out.println("TC1 verify_that_the_loan_tab_is_easily_accessible_on_the_landing_page |Success:");

    }

    // ***********************************************************************************************************************************
    @Test(priority = 75)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "ELOANS SALARY GET TOP UP") })
    @Step ("Verify_that_user_can_apply_for_one_month_loan")
    public void Verify_that_user_can_apply_for_one_month_loan() throws InterruptedException {
	 //test =extent.createTest(" 2 Verify_that_user_can_apply_for_one_month_loan ");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Get Loan\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Apply for a salary e-loan\')]")).click();
	driver.findElement(By.name("CMB_TENURE")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("ELOANS_LOAN_CREATE_REQ_FORM_03-CMB_TENURE"));
	    dropdown.findElement(By.xpath("//option[. = '1 month']")).click();
	}
	driver.findElement(By.name("CMB_TENURE")).click();
	driver.findElement(By.name("TXT_AMOUNT")).click();
	driver.findElement(By.name("TXT_AMOUNT")).sendKeys("4000");
	driver.findElement(By.xpath("//a[contains(.,\'NEXT\')]")).click();
	driver.findElement(By.name("CHK_TERMS_N_CONDITIONS")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Get Loan\')]")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("5");
	driver.findElement(By.xpath("//a[contains(.,\'Submit\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'OK\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Skip\')]")).click();
	System.out.println("TC1 verify_that_the_loan_tab_is_easily_accessible_on_the_landing_page |Success:");
    }

    // *****************************************************************************************************************
    @Test(priority = 76)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "ELOANS SALARY GET TOP UP") })
    @Step ("Verify_that_user_can_Top up_menu")
    public void Verify_that_user_can_Topup_menu() throws InterruptedException {
	 //test =extent.createTest(" 3 Verify_that_user_can_Topup_menu");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Get a top Up\')]")).click();
	System.out.println("TC1 verify_that_the_loan_tab_is_easily_accessible_on_the_landing_page |Success:");

    }

    // *****************************************************************************************************************
    @Test(priority = 77)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "ELOANS SALARY GET TOP UP") })
    @Step ("Verify_that_user_can_apply_for_topup")
    @Severity(SeverityLevel.BLOCKER)
    public void Verify_that_user_can_apply_for_topup() throws InterruptedException {
	 //test =extent.createTest(" 4 Verify_that_user_can_apply_for_top up");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
	driver.findElement(By.xpath("//button[contains(.,\'Get a top Up\')]")).click();
	driver.findElement(By.xpath("//a[contains(.,\'NEXT\')]")).click();
	driver.findElement(By.name("CHK_TERMS_N_CONDITIONS")).click();
	driver.findElement(By.xpath("//a[contains(.,\'Get Loan\')]")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("2");
	driver.findElement(By.xpath("//a[contains(.,\'Submit\')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[contains(.,\'OK\')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[contains(.,\'Skip\')]")).click();
	System.out.println("TC1 verify_that_the_loan_tab_is_easily_accessible_on_the_landing_page |Success:");
    }
    // ***********************************************************************************************************************************

    @Test(priority = 78)
     @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "ELOANS SALARY GET TOP UP") })
    @Step ("End of Eloans Salary Get Top Up")
    public void End_Of_Eloans_Salary_Get_top_up_TestCases() throws IOException, InterruptedException {
	 //test =extent.createTest("END OF ELOAND SALARY GET TOP UP");
	System.out.println("*************************End of Eloans Salary Get Top Up***********************************");
    }
    @Test (priority =79)
    @Epic("ELOANS (SALARY)")
    @Features(value = { @Feature(value = "GET TOP UP") })
    @Step ("CLEAR_LOAN")
    public void CLEAR_LOAN()throws InterruptedException, IOException {
	driver.get("http://172.16.19.161:50002/iportalweb/iRetail@1");
  	  driver.manage().window().maximize();
  	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  	//enter username
  	 //**********************************************************************************************************************
  	   File src=new File(my_dir+"\\Data_Driven_Excel_File\\TestData.xlsx");
  	   FileInputStream fis = new FileInputStream(src);
  	 ELOAN_BUSINESS = new XSSFWorkbook(fis);
  	   sheet= ELOAN_BUSINESS.getSheet("Loginmodule");	  
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
  	   Thread.sleep(4000);
  	  driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).sendKeys("3");
  	  driver.findElement(By.cssSelector(".otp-input:nth-child(2)")).sendKeys("3");
  	  driver.findElement(By.cssSelector(".otp-input:nth-child(3)")).sendKeys("3");
  	  driver.findElement(By.cssSelector(".otp-input:nth-child(4)")).sendKeys("2");
  	  driver.findElement(By.cssSelector(".otp-input:nth-child(5)")).sendKeys("2");
  	  driver.findElement(By.cssSelector(".ng-untouched")).sendKeys("2");
  	  driver.findElement(By.cssSelector(".ng-untouched")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("//span[contains(.,\'Loans\')]")).click();
    driver.findElement(By.xpath("//button[contains(.,\'Show more\')]")).click();
    driver.findElement(By.xpath("//button[contains(.,\'Repay Loan\')]")).click();
    driver.findElement(By.xpath("//a[contains(.,\'Clear Loan\')]")).click();
    driver.findElement(By.name("CMB_DEBIT_ACCOUNT_FULL")).click();
    driver.findElement(By.name("CMB_DEBIT_ACCOUNT_FULL")).sendKeys("01105413334100");
    driver.findElement(By.name("BTN_NEXT_FULL")).click();
    driver.findElement(By.xpath("//label[contains(.,\'I accept\')]")).click();
    driver.findElement(By.xpath("//a[contains(.,\'Pay Loan\')]")).click();
    driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("2");
    driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("3");
    driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("4");
    driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("5");
    driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("6");
    driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("8");
    driver.findElement(By.xpath("//a[contains(.,\'Submit\')]")).click();
    driver.findElement(By.xpath("//button[contains(.,\'OK\')]")).click();
    }
    // ***********************************************************************************************************************************
	
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
    }
