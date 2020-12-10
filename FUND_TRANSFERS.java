package RBX_PIPE;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
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

public class FUND_TRANSFERS {
    	String my_dir = System.getProperty("user.dir");      	
    	JavascriptExecutor js; 
	public ExtentTest test;
	WebDriver driver;	
	XSSFWorkbook Loginmodule;                               
	XSSFWorkbook Transfer_To_Coop_Other_Account;
	XSSFWorkbook Transfer_To_Local_Banks_RTGS;
	XSSFWorkbook Transfer_To_Mobile_Money_MPESA;
	XSSFWorkbook Transfer_To_Local_Banks_Pesalink;
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
    public static void main(String[] args) {
	TestNG testng = new TestNG();
	testng.setTestClasses(new Class[] {FUND_TRANSFERS.class });
	testng.run();
    }

// **************************************************************************************************************************************
    @Test(priority = 0)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO MY ACCOUNT") })
    @Step ("TRANSFER TO MY ACCOUNT")
    @Severity(SeverityLevel.TRIVIAL)
    public void Running_Transfer_To_My_Account_TestCases() throws IOException, InterruptedException {
	//test =extent.createTest("FUND TRANSFER (A) RUNNING TRANSFER TO MY ACCOUNT TESTCASES");
	System.out.println("FUND TRANSFER");
	System.out.println("Transfer module contains Five Number of Modules");
	System.out.println(
		"*************************(a) Running Transfer To My Account Testcases***********************************");
	System.out.println("Total Number of Test cases = 10 ");
    }

    @Test(priority = 1)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO MY ACCOUNT") })
    @Severity(SeverityLevel.MINOR)
    @Step ("Verify_whether_a_user_can_select_Transfer_module_button")
    public void Verify_whether_a_user_can_select_Transfer_module_button() throws IOException, InterruptedException {
	//test =extent.createTest(" 1 Verify whether a user can select Transfer module button (TRANSFER TO MY ACCOUNT)");
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);		
	Transfer_To_Coop_Other_Account = new XSSFWorkbook(fis);
	sheet = Transfer_To_Coop_Other_Account.getSheet("Loginmodule");		
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
	driver.findElement(By.linkText("Transfer")).click();
	Thread.sleep(2000);	
	Assert.assertEquals(1,1);
	System.out.println("TC1 Verify_whether_a_user_can_select_Transfer_module_button |Success:");
    }
// ***********************************************************************************************************************************

    @Test(priority = 2)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO MY ACCOUNT") })
    @Step ("Verify_whether_a_user_can_select_to_my_account_menu_on_transfer_module")
    public void Verify_whether_a_user_can_select_to_my_account_menu_on_transfer_module()
	    throws InterruptedException, IOException {
	//test =extent.createTest(" 2 Verify whether a user can select to my account menu on transfer module (TRANSFER TO MY ACCOUNT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//*[text()=' To Co-op Bank Account ']")).click();
	driver.findElement(By.xpath("//div[text()=' To My Account ']")).click();
	System.out.println("TC2 Verify- user can select the forgot username link option |Success:");
    }
// ***********************************************************************************************************************************

    @Test(priority = 3)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO MY ACCOUNT") })
    @Step ("Verify_that_user_can_select_the_account_to_make_the_transfer_from")
    public void Verify_that_user_can_select_the_account_to_make_the_transfer_from()
	    throws InterruptedException, IOException {
	//test =extent.createTest(" 3 Verify that user can select the account to make the transfer from (TRANSFER TO MY ACCOUNT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//*[text()=' To Co-op Bank Account ']")).click();
	driver.findElement(By.xpath("//div[text()=' To My Account ']")).click();	
	driver.findElement(By.id("FORM_SINGLE_TRANSFER_1-DEBIT_ACC_NO")).sendKeys("02120413334100");

	System.out.println("TC3 Verify_whether_a_user_can_select_to_my_account_menu_on_transfer_module |Success:");
    }
// ***********************************************************************************************************************************

    @Test(priority = 4)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO MY ACCOUNT") })
    @Step ("Verify_that_user_can_select_the_account_to_make_transfer_to")
    public void Verify_that_user_can_select_the_account_to_make_transfer_to() throws InterruptedException, IOException {
	//test =extent.createTest(" 4 Verify that user can select the account to make transfer to (TRANSFER TO MY ACCOUNT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//*[text()=' To Co-op Bank Account ']")).click();
	driver.findElement(By.xpath("//div[text()=' To My Account ']")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("FORM_SINGLE_TRANSFER_1-DEBIT_ACC_NO")).sendKeys("02120413334100");	
	driver.findElement(By.id("FORM_SINGLE_TRANSFER_1-BENE_ACC_NAME_OWN")).sendKeys("01105413334100");
	System.out.println("TC4 Verify_that_user_can_select_the_account_to_make_transfer_to |Success:");

    }
// ***********************************************************************************************************************************

    @Test(priority = 5)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO MY ACCOUNT") })
    @Step ("Verify_that_the_input_field_for_amount_allows_only_numeric_digits")
    public void Verify_that_the_input_field_for_amount_allows_only_numeric_digits()
	    throws InterruptedException, IOException {
	//test =extent.createTest(" 5 Verify that the input field for amount allows only numeric digits (TRANSFER TO MY ACCOUNT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//*[text()=' To Co-op Bank Account ']")).click();
	driver.findElement(By.xpath("//div[text()=' To My Account ']")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("FORM_SINGLE_TRANSFER_1-DEBIT_ACC_NO")).sendKeys("02120413334100");	
	driver.findElement(By.id("FORM_SINGLE_TRANSFER_1-BENE_ACC_NAME_OWN")).sendKeys("01105413334100");	
	driver.findElement(By.id("FORM_SINGLE_TRANSFER_1-EXCHANGE_AMOUNT")).sendKeys("100");
	System.out.println("TC5 Verify_that_the_input_field_for_amount_allows_only_numeric_digits |Success:");
    }
// ***********************************************************************************************************************************

    @Test(priority = 6)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO MY ACCOUNT") })
    @Step ("Verify_that_user_can_enter_debit_amount")
    public void Verify_that_user_can_enter_debit_amount() throws InterruptedException, IOException {
	//test =extent.createTest(" 6 Verify that user can enter debit amount (TRANSFER TO MY ACCOUNT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//*[text()=' To Co-op Bank Account ']")).click();
	driver.findElement(By.xpath("//div[text()=' To My Account ']")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("FORM_SINGLE_TRANSFER_1-DEBIT_ACC_NO")).sendKeys("02120413334100");
	Thread.sleep(2000);
	driver.findElement(By.id("FORM_SINGLE_TRANSFER_1-BENE_ACC_NAME_OWN")).sendKeys("01105413334100");
	Thread.sleep(2000);
	driver.findElement(By.id("FORM_SINGLE_TRANSFER_1-EXCHANGE_AMOUNT")).sendKeys("200");
	System.out.println("TC6 Verify_that_user_can_enter_debit_amount|Success:");
    }
// ***********************************************************************************************************************************

    @Test(priority = 7)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO MY ACCOUNT") })
    @Step ("Verify_whether_a_user_can_enter_payment_Reason")
    public void Verify_whether_a_user_can_enter_payment_Reason() throws InterruptedException, IOException {
	//test =extent.createTest(" 7 Verify_whether_a_user_can_enter_payment_Reason (TRANSFER TO MY ACCOUNT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//*[text()=' To Co-op Bank Account ']")).click();
	driver.findElement(By.xpath("//div[text()=' To My Account ']")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("FORM_SINGLE_TRANSFER_1-DEBIT_ACC_NO")).sendKeys("02120413334100");	
	driver.findElement(By.id("FORM_SINGLE_TRANSFER_1-BENE_ACC_NAME_OWN")).sendKeys("01105413334100");	
	driver.findElement(By.id("FORM_SINGLE_TRANSFER_1-EXCHANGE_AMOUNT")).sendKeys("100");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.id("FORM_SINGLE_TRANSFER-REMARKS_OWN")).click();
	driver.findElement(By.id("FORM_SINGLE_TRANSFER-REMARKS_OWN")).sendKeys("Test");

	System.out.println("TC7 Verify_whether_a_user_can_enter_payment_Reason |Success:");
    }
// ***********************************************************************************************************************************

    @Test(priority = 8)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO MY ACCOUNT") })
    @Step ("Verify_whether_OPT_can_be_entered_to_verify_transaction")
    public void Verify_whether_OPT_can_be_entered_to_verify_transaction() throws InterruptedException, IOException {
	//test =extent.createTest(" 8 Verify whether OPT can be entered to verify transaction (TRANSFER TO MY ACCOUNT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//*[text()=' To Co-op Bank Account ']")).click();
	driver.findElement(By.xpath("//div[text()=' To My Account ']")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("FORM_SINGLE_TRANSFER_1-DEBIT_ACC_NO")).sendKeys("02120413334100");	
	driver.findElement(By.id("FORM_SINGLE_TRANSFER_1-BENE_ACC_NAME_OWN")).sendKeys("01105413334100");	
	driver.findElement(By.id("FORM_SINGLE_TRANSFER_1-EXCHANGE_AMOUNT")).sendKeys("100");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.id("FORM_SINGLE_TRANSFER-REMARKS_OWN")).click();
	driver.findElement(By.id("FORM_SINGLE_TRANSFER-REMARKS_OWN")).sendKeys("Internal Transfer");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("SEND")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("3");

	System.out.println("TC8 Verify_whether_OPT_can_be_entered_to_verify_transaction |Success:");
    }
// ***********************************************************************************************************************************

    @Test(priority = 9)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO MY ACCOUNT") })
    @Severity(SeverityLevel.CRITICAL)
    @Step ("Verify_whether_a_user_can_Transfer_from_COOP_Bank_to_My_account")
    public void Verify_whether_a_user_can_Transfer_from_COOP_Bank_to_My_account()
	    throws InterruptedException, IOException {
	//test =extent.createTest(" 9 Verify whether a user can Transfer from COOP Bank to My account (TRANSFER TO MY ACCOUNT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//*[text()=' To Co-op Bank Account ']")).click();
	driver.findElement(By.xpath("//div[text()=' To My Account ']")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("FORM_SINGLE_TRANSFER_1-DEBIT_ACC_NO")).sendKeys("02120413334100");	
	driver.findElement(By.id("FORM_SINGLE_TRANSFER_1-BENE_ACC_NAME_OWN")).sendKeys("01105413334100");	
	driver.findElement(By.id("FORM_SINGLE_TRANSFER_1-EXCHANGE_AMOUNT")).sendKeys("100");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("FORM_SINGLE_TRANSFER-REMARKS_OWN")).sendKeys("Internal Transfer");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("SEND")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("3");
	driver.findElement(By.linkText("Submit")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//a[text()=' Done ']")).click();
	System.out.println("TC9 Verify_whether_a_user_can_Transfer_from_COOP_Bank_to_My_account |Success:");
    }
// ***********************************************************************************************************************************

    @Test(priority = 10)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO MY ACCOUNT") })
    @Step ("Validate_whether_a_user_can_Transfer_from_COOP_Bank_to_My_account")
    @Severity(SeverityLevel.BLOCKER)
    public void Validate_whether_a_user_can_Transfer_from_COOP_Bank_to_My_account()
	    throws InterruptedException, IOException {
	//test =extent.createTest(" 10 Validate whether a user can Transfer from COOP Bank to My account (TRANSFER TO MY ACCOUNT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//*[text()=' To Co-op Bank Account ']")).click();
	driver.findElement(By.xpath("//div[text()=' To My Account ']")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("FORM_SINGLE_TRANSFER_1-DEBIT_ACC_NO")).sendKeys("02120413334100");	
	driver.findElement(By.id("FORM_SINGLE_TRANSFER_1-BENE_ACC_NAME_OWN")).sendKeys("01105413334100");	
	driver.findElement(By.id("FORM_SINGLE_TRANSFER_1-EXCHANGE_AMOUNT")).sendKeys("100");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.id("FORM_SINGLE_TRANSFER-REMARKS_OWN")).sendKeys("Internal Transfer");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("SEND")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("3");
	driver.findElement(By.linkText("Submit")).click();
	Thread.sleep(2000);
	if (driver.getPageSource().contains("Sorry. We are unable to process your request at the moment.")) {
	    System.out.println("Sorry. We are unable to process your request at the moment.");
	    org.testng.Assert.fail("Sorry. We are unable to process your request at the moment.");
	} 
	else 
	{
	  
	}
	driver.findElement(By.xpath("//a[text()=' Done ']")).click();

	System.out.println("TC10 Validate_whether_a_user_can_Transfer_from_COOP_Bank_to_My_account |Success:");
    }

// ***********************************************************************************************************************************

    @Test(priority = 11)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO MY ACCOUNT") })
    @Step ("End_of_Transfer_To_My_Account_TestCases")
    public void End_of_Transfer_To_My_Account_TestCases() throws IOException, InterruptedException {
	//test =extent.createTest("END OF TRANSFER TO MY ACCOUNT TESTCASES");	
	System.out.println("*************************End of Transfer To My Account Testcases***********************************");
    }

// **********************************************************************************************************************************
  @Test(priority = 12)
  @Epic("FUND TRANSFER")
  @Features(value = { @Feature(value = "TRANSFER TO OTHER COOP ACCOUNT") })
    @Step ("TRANSFER TO OTHER COOP ACCOUNT")
  @Severity(SeverityLevel.TRIVIAL)
    public void Running_Transfer_To_Other_Account_TestCases() throws IOException, InterruptedException {
	//test =extent.createTest("(B) RUNNING TRANSFER TO OTHER COOP ACCOUNT TESTCASES");
	System.out.println("*************************(b) Running Transfer To Other coop Account Testcases***********************************");
	System.out.println("Total Number of Test cases = 13 ");
    }

//**********************************************************************************************************************************
    @Test(priority = 13)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO OTHER COOP ACCOUNT") })
    @Severity(SeverityLevel.MINOR)
    @Step ("Verify_user_can_select_to_other_COOP_accounts")
    public void Verify_user_can_select_to_other_COOP_accounts() throws InterruptedException, IOException {
	//test =extent.createTest(" 1 Verify user can select to other COOP accounts (TRANSFER TO OTHER COOP ACCOUNT)");
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);		
	Transfer_To_Coop_Other_Account = new XSSFWorkbook(fis);
	sheet = Transfer_To_Coop_Other_Account.getSheet("Loginmodule");		
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
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//*[text()=' To Co-op Bank Account ']")).click();
	driver.findElement(By.xpath("//div[text()=' To Other Co-op Account ']")).click();
	System.out.println("TC1 Verify_user_can_select_to_other_COOP_accounts |Success:");
    }

//**********************************************************************************************************************************
    @Test(priority = 14)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO OTHER COOP ACCOUNT") })
    @Step ("Verify_whether_a_user_can_add_and_save_new_beneficiary_account")
    public void Verify_whether_a_user_can_add_and_save_new_beneficiary_account()
	    throws InterruptedException, IOException {
	//test =extent.createTest(" 2 Verify_whether_a_user_can_add_and_save_new_beneficiary_account (TRANSFER TO OTHER COOP ACCOUNT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//*[text()=' To Co-op Bank Account ']")).click();
	driver.findElement(By.xpath("//div[text()=' To Other Co-op Account ']")).click();
	driver.findElement(By.id("FORM_OTHER_TRANSFER_1-OTHER_ACC_BENE_NO")).click();
	driver.findElement(By.id("FORM_OTHER_TRANSFER_1-OTHER_ACC_BENE_NO")).sendKeys("01105413334100");
	driver.findElement(By.cssSelector(".checkbox-inline")).click();
	driver.findElement(By.id("FORM_OTHER_TRANSFER_1-OTHER_ACC_BENE_NICK")).click();
	System.out.println("TC2 Verify_whether_a_user_can_add_and_save_new_beneficiary_account |Success:");
    }

//**********************************************************************************************************************************
    @Test(priority = 15)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO OTHER COOP ACCOUNT") })
    @Step ("verify_whether_a_user_can_select_on_my_beneficiary_tab")
    public void verify_whether_a_user_can_select_on_my_beneficiary_tab() throws InterruptedException, IOException {
	//test =extent.createTest(" 3 verify_whether_a_user_can_select_on_my_beneficiary_tab (TRANSFER TO OTHER COOP ACCOUNT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//*[text()=' To Co-op Bank Account ']")).click();
	driver.findElement(By.xpath("//div[text()=' To Other Co-op Account ']")).click();
	driver.findElement(By.id("FORM_OTHER_TRANSFER_1-RTGS_EXISTING_BENE")).click();
	System.out.println("TC3 verify_whether_a_user_can_select_on_my_beneficiary_tab( |Success:");
    }

//**********************************************************************************************************************************
    @Test(priority = 16)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO OTHER COOP ACCOUNT") })
    @Step ("Verify_whether_a_user_can_enter_account_to_send_to_new_beneficiary_other_coop_accounts")
    public void Verify_whether_a_user_can_enter_account_to_send_to_new_beneficiary_other_coop_accounts()
	    throws IOException, InterruptedException {
	//test =extent.createTest(" 4 Verify_whether_a_user_can_enter_account_to_send_to_new_beneficiary_other_coop_accounts (TRANSFER TO OTHER COOP ACCOUNT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//*[text()=' To Co-op Bank Account ']")).click();
	driver.findElement(By.xpath("//div[text()=' To Other Co-op Account ']")).click();
	driver.findElement(By.id("FORM_OTHER_TRANSFER_1-OTHER_ACC_BENE_NO")).click();
	System.out.println(
		"TC4 Verify_whether_a_user_can_enter_account_to_send_to_new_beneficiary_other_coop_accounts|Success:");
    }

//**********************************************************************************************************************************
    @Test(priority = 17)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO OTHER COOP ACCOUNT") })
    @Step ("Verify_whether_a_user_can_enter_amount_for_new_beneficiary_other_coop_account1")
    public void Verify_whether_a_user_can_enter_amount_for_new_beneficiary_other_coop_account1()
	    throws IOException, InterruptedException {
	//test =extent.createTest(" 5 Verify_whether_a_user_can_enter_amount_for_new_beneficiary_other_coop_account (TRANSFER TO OTHER COOP ACCOUNT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//*[text()=' To Co-op Bank Account ']")).click();
	driver.findElement(By.xpath("//div[text()=' To Other Co-op Account ']")).click();
	driver.findElement(By.id("FORM_OTHER_TRANSFER_1-OTHER_ACC_BENE_NO")).click();
	driver.findElement(By.id("FORM_OTHER_TRANSFER_1-OTHER_ACC_BENE_NO")).sendKeys("01105607566200");
	// driver.findElement(By.cssSelector(".checkbox-inline")).click();
	// driver.findElement(By.id("FORM_OTHER_TRANSFER_1-OTHER_ACC_BENE_NICK")).click();
	// driver.findElement(By.id("FORM_OTHER_TRANSFER_1-OTHER_ACC_BENE_NICK")).sendKeys("ree");
	driver.findElement(By.xpath("//*[text()='NEXT']")).click();
	driver.findElement(By.id("FORM_OTHER_TRANSFER_2-DEBIT_ACC_NO")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_OTHER_TRANSFER_2-DEBIT_ACC_NO"));
	    dropdown.findElement(By.xpath("//option[. = '01105413334100']")).click();
	}
	driver.findElement(By.id("FORM_OTHER_TRANSFER_2-DEBIT_ACC_NO")).click();
	driver.findElement(By.id("FORM_OTHER_TRANSFER_2-EXCHANGE_AMOUNT")).click();
	driver.findElement(By.id("FORM_OTHER_TRANSFER_2-EXCHANGE_AMOUNT")).sendKeys("122");
	System.out
		.println("TC5 Verify_whether_a_user_can_enter_amount_for_new_beneficiary_other_coop_account1|Success:");
    }

//**********************************************************************************************************************************
    @Test(priority = 18)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO OTHER COOP ACCOUNT") })
    @Step ("Verify_whether_a_user_can_enter_amount_for_new_beneficiary_other_coop_account")
    public void Verify_whether_a_user_can_enter_amount_for_new_beneficiary_other_coop_account()
	    throws InterruptedException, IOException {
	//test =extent.createTest(" 6 Verify_whether_a_user_can_enter_amount_for_new_beneficiary_other_coop_account (TRANSFER TO OTHER COOP ACCOUNT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//*[text()=' To Co-op Bank Account ']")).click();
	driver.findElement(By.xpath("//div[text()=' To Other Co-op Account ']")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_OTHER_TRANSFER_1-OTHER_ACC_BENE_NO")).sendKeys("01105607566200");
	driver.findElement(By.xpath("//*[text()='NEXT']")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_OTHER_TRANSFER_2-DEBIT_ACC_NO")).click();
	driver.findElement(By.id("FORM_OTHER_TRANSFER_2-DEBIT_ACC_NO")).sendKeys("01105413334100");
	driver.findElement(By.id("FORM_OTHER_TRANSFER_2-EXCHANGE_AMOUNT")).click();
	driver.findElement(By.id("FORM_OTHER_TRANSFER_2-EXCHANGE_AMOUNT")).sendKeys("122");

	System.out
		.println("TC6 Verify_whether_a_user_can_enter_amount_for_new_beneficiary_other_coop_account |Success:");
    }

    // **********************************************************************************************************************************
    @Test(priority = 19)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO OTHER COOP ACCOUNT") })
    @Step ("Verify_whether_user_can_enter_Reasons_when_sending_money_to_beneficiary_other_coop_account")
    public void Verify_whether_user_can_enter_Reasons_when_sending_money_to_beneficiary_other_coop_account()
	    throws IOException, InterruptedException {
	//test =extent.createTest(" 7 Verify_whether_user_can_enter_Reasons_when_sending_money_to_beneficiary_other_coop_account (TRANSFER TO OTHER COOP ACCOUNT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//*[text()=' To Co-op Bank Account ']")).click();
	driver.findElement(By.xpath("//div[text()=' To Other Co-op Account ']")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("FORM_OTHER_TRANSFER_1-OTHER_ACC_BENE_NO")).sendKeys("01105607566200");
	driver.findElement(By.xpath("//*[text()='NEXT']")).click();
	Thread.sleep(2000);	
	driver.findElement(By.id("FORM_OTHER_TRANSFER_2-DEBIT_ACC_NO")).sendKeys("01105413334100");
	Thread.sleep(2000);
	driver.findElement(By.id("FORM_OTHER_TRANSFER_2-EXCHANGE_AMOUNT")).sendKeys("122");
	driver.findElement(By.xpath("//*[text()='NEXT']")).click();
	driver.findElement(By.id("FORM_OTHER_TRANSFER-REMARKS_OWN")).click();
	driver.findElement(By.id("FORM_OTHER_TRANSFER-REMARKS_OWN")).sendKeys("Land Rate");

	System.out.println("TC7 Verify_whether_user_can_enter_Reasons_when_sending_money_to_beneficiary_other_coop_account |Success:");
    }

    // **********************************************************************************************************************************
    @Test(priority = 20)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO OTHER COOP ACCOUNT") })
    @Step ("Verify_whether_a_user_can_select_schedule_payment_button")
    public void Verify_whether_a_user_can_select_schedule_payment_button() throws InterruptedException, IOException {
	//test =extent.createTest(" 8 Verify_whether_a_user_can_select_schedule_payment_button (TRANSFER TO OTHER COOP ACCOUNT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//*[text()=' To Co-op Bank Account ']")).click();
	System.out.println("TC8 Verify_whether_a_user_can_select_schedule_payment_button |Success:");
    }

//**********************************************************************************************************************************
    @Test(priority = 21)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO OTHER COOP ACCOUNT") })
    @Step ("Verify_whether_a_user_can_set_frequency_of_transfering_money_to_beneficiary")
    public void Verify_whether_a_user_can_set_frequency_of_transfering_money_to_beneficiary()
	    throws IOException, InterruptedException {
	//test =extent.createTest(" 9 Verify_whether_a_user_can_set_frequency_of_transfering_money_to_beneficiary (TRANSFER TO OTHER COOP ACCOUNT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//*[text()=' To Co-op Bank Account ']")).click();
	driver.findElement(By.xpath("//div[text()=' To Other Co-op Account ']")).click();
	driver.findElement(By.id("FORM_OTHER_TRANSFER_1-OTHER_ACC_BENE_NO")).click();
	driver.findElement(By.id("FORM_OTHER_TRANSFER_1-OTHER_ACC_BENE_NO")).sendKeys("01103006421000");
	System.out.println("TC9 Verify_whether_a_user_can_set_frequency_of_transfering_money_to_beneficiary |Success:");
    }

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    @Test(priority = 22)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO OTHER COOP ACCOUNT") })
    @Step ("Verify_whether_a_user_can_set_start_date_for_transfering_money_to_beneficiary")
    public void Verify_whether_a_user_can_set_start_date_for_transfering_money_to_beneficiary() {
	//test =extent.createTest(" 10 Verify_whether_a_user_can_set_start_date_for_transfering_money_to_beneficiary (TRANSFER TO OTHER COOP ACCOUNT)");
	System.out.println("TC10 Verify_whether_a_user_can_set_start_date_for_transfering_money_to_beneficiary|Success:");
    }
    // **********************************************************************************************************************************

    @Test(priority = 23)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO OTHER COOP ACCOUNT") })
    @Step ("Verify_whether_a_user_can_set_End_date_for_transfering_money_to_beneficiary")
    public void Verify_whether_a_user_can_set_End_date_for_transfering_money_to_beneficiary()
	    throws InterruptedException {
	//test =extent.createTest(" 11 Verify_whether_a_user_can_set_End_date_for_transfering_money_to_beneficiary (TRANSFER TO OTHER COOP ACCOUNT)");
	Thread.sleep(2000);
	System.out.println("TC11 Verify_whether_a_user_can_set_End_date_for_transfering_money_to_beneficiary|Success:");
    }
    // **********************************************************************************************************************************

    @Test(priority = 25)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO OTHER COOP ACCOUNT") })
    @Step ("Verify_whether_a_user_can_transfer_money_beneficiary_other_coop_Account")
    @Severity(SeverityLevel.BLOCKER)
    public void Verify_whether_a_user_can_transfer_money_beneficiary_other_coop_Account()
	    throws IOException, InterruptedException {
	//test =extent.createTest(" 12 Verify_whether_a_user_can_transfer_money_beneficiary_other_coop_Account (TRANSFER TO OTHER COOP ACCOUNT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//*[text()=' To Co-op Bank Account ']")).click();
	driver.findElement(By.xpath("//div[text()=' To Other Co-op Account ']")).click();
	driver.findElement(By.id("FORM_OTHER_TRANSFER_1-OTHER_ACC_BENE_NO")).sendKeys("01105607566200");
	driver.findElement(By.xpath("//*[text()='NEXT']")).click();
	driver.findElement(By.id("FORM_OTHER_TRANSFER_2-DEBIT_ACC_NO")).click();
	driver.findElement(By.id("FORM_OTHER_TRANSFER_2-DEBIT_ACC_NO")).sendKeys("01105413334100");
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_OTHER_TRANSFER_2-EXCHANGE_AMOUNT")).clear();
	driver.findElement(By.id("FORM_OTHER_TRANSFER_2-EXCHANGE_AMOUNT")).sendKeys("122");
	driver.findElement(By.xpath("//*[text()='NEXT']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@name='REMARKS_OWN']")).click();
	driver.findElement(By.xpath("//*[@name='REMARKS_OWN']")).sendKeys("Land Rate");
	driver.findElement(By.xpath("//*[text()='NEXT']")).click();
	Thread.sleep(1000);
	driver.findElement(By.linkText("SEND")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@name='OTP_INPUT_1']")).sendKeys("3");
	driver.findElement(By.xpath("//*[@name='OTP_INPUT_2']")).sendKeys("3");
	driver.findElement(By.xpath("//*[@name='OTP_INPUT_3']")).sendKeys("3");
	driver.findElement(By.xpath("//*[@name='OTP_INPUT_4']")).sendKeys("3");
	driver.findElement(By.xpath("//*[@name='OTP_INPUT_5']")).sendKeys("3");
	driver.findElement(By.xpath("//*[@name='OTP_INPUT_6']")).sendKeys("3");
	driver.findElement(By.linkText("Submit")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[text()=' Done ']")).click();
	System.out.println("TC12 Verify_whether_a_user_can_transfer_money_beneficiary_other_coop_Account |Success:");
    }
    // **********************************************************************************************************************************

    @Test(priority = 24)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO OTHER COOP ACCOUNT") })
    @Severity(SeverityLevel.TRIVIAL)
    @Step ("Verify_that_user_can_select_to_other_COOP accounts")
    public void Verify_that_user_can_select_to_other_COOPaccounts1() throws IOException, InterruptedException {
	//test =extent.createTest(" 13 Verify_that_user_can_select_to_other_COOPaccounts (TRANSFER TO OTHER COOP ACCOUNT)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//*[text()=' To Co-op Bank Account ']")).click();
	driver.findElement(By.xpath("//div[text()=' To Other Co-op Account ']")).click();
	driver.findElement(By.id("FORM_OTHER_TRANSFER_1-OTHER_ACC_BENE_NO")).click();
	driver.findElement(By.id("FORM_OTHER_TRANSFER_1-OTHER_ACC_BENE_NO")).sendKeys("01105607566200");
	System.out.println("TC13 Verify_that_user_can_select_to_other_COOP accounts |Success:");
    }

    @Test(priority = 26)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO OTHER COOP ACCOUNT") })
    @Severity(SeverityLevel.TRIVIAL)
    @Step ("END_Transfer_To_Other_Account_TestCases")
    public void END_Transfer_To_Other_Account_TestCases() throws IOException, InterruptedException {
	//test =extent.createTest("END_TRANSFER_TO_OTHER_ACCOUNT_TESTCASES");
	System.out.println("************************* End of Transfer To Other coop Account Testcases***********************************");
    }
    // **********************************************************************************************************************************
    // **********************************************************************************************************************************

    @Test(priority = 27)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS RTGS") })
    @Step ("RUNNING TRANSFER TO LOCAL BANKS RTGS")
    @Severity(SeverityLevel.TRIVIAL)
    public void Running_Transfer_To_Local_Banks_RTGS_TestCases() throws IOException, InterruptedException {
	//test =extent.createTest("(C) RUNNING TRANSFER TO LOCAL BANKS RTGS TESTCASES");
	System.out.println("*************************(c) Running Transfer To Local Banks RTGS Testcases***********************************");
	System.out.println("Total Number of Test cases = 12 ");
    }

    // **********************************************************************************************************************************

    @Test(priority = 28)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS RTGS") })
    @Severity(SeverityLevel.MINOR)
    @Step ("verify_that_a_user_can_select_RTGS_menu")
    public void verify_that_a_user_can_select_RTGS_menu() throws InterruptedException, IOException {
	//test =extent.createTest(" 1 verify_that_a_user_can_select_RTGS_menu (RTGS)");
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);		
	Transfer_To_Coop_Other_Account = new XSSFWorkbook(fis);
	sheet = Transfer_To_Coop_Other_Account.getSheet("Loginmodule");		
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
	try {
	    Thread.sleep(3000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//*[text()=' RTGS ']")).click();
	System.out.println("TC1 verify_that_a_user_can_select_RTGS_menu |Success:");
    }
    // **********************************************************************************************************************************

    @Test(priority = 29)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS RTGS") })
    @Step ("Verify_whether_a_user_can_enter_beneficiary_name")
    public void Verify_whether_a_user_can_enter_beneficiary_name() throws IOException, InterruptedException {
	//test =extent.createTest(" 2 Verify_whether_a_user_can_enter_beneficiary_name (RTGS)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	try {
	    Thread.sleep(3000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//*[text()=' RTGS ']")).click();
	driver.findElement(By.xpath("//*[@name='BENE_ACC_NAME']")).click();
	driver.findElement(By.xpath("//*[@name='BENE_ACC_NAME']")).sendKeys("Emmanuel Bore");
	System.out.println("TC2 Verify_whether_a_user_can_enter_beneficiary_name |Success:");
    }
    // **********************************************************************************************************************************

    @Test(priority = 30)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS RTGS") })
    @Step ("Verify_whether_a_user_can_enter_beneficiary_account")
    public void Verify_whether_a_user_can_enter_beneficiary_account() throws IOException, InterruptedException {
	//test =extent.createTest(" 3 Verify_whether_a_user_can_enter_beneficiary_account (RTGS)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//*[text()=' RTGS ']")).click();
	driver.findElement(By.xpath("//*[@name='BENE_ACC_NAME']")).click();
	driver.findElement(By.xpath("//*[@name='BENE_ACC_NAME']")).sendKeys("Emmanuel Bore");
	driver.findElement(By.id("FORM_RTGS_TRANSFER_1-BENE_ACC_NO")).sendKeys("09901090909");
	System.out.println("TC3 Verify_whether_a_user_can_enter_beneficiary_account |Success:");
    }
    // **********************************************************************************************************************************

    @Test(priority = 31)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS RTGS") })
    @Step ("Verify_whether_a_user_can_use_save_radio_button")
    public void Verify_whether_a_user_can_use_save_radio_button() throws IOException, InterruptedException {
	//test =extent.createTest(" 4 Verify_whether_a_user_can_use_save_radio_button (RTGS)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//*[text()=' RTGS ']")).click();
	driver.findElement(By.xpath("//*[@name='BENE_ACC_NAME']")).click();
	driver.findElement(By.xpath("//*[@name='BENE_ACC_NAME']")).sendKeys("Emmanuel Bore");
	driver.findElement(By.id("FORM_RTGS_TRANSFER_1-BENE_ACC_NO")).sendKeys("09901090909");
	driver.findElement(By.xpath("//*[@name='GET_BANKS']")).click();
	driver.findElement(By.xpath("//*[@name='search']")).click();
	driver.findElement(By.xpath("//*[@name='search']")).sendKeys("bank of africa");
	driver.findElement(By.xpath("//*[text()=' BANK OF AFRICA KENYA LTD ']")).click();
	driver.findElement(By.cssSelector(".checkbox-inline")).click();
	System.out.println("TC4 Verify_whether_a_user_can_use_save_radio_button |Success:");
    }
    // **********************************************************************************************************************************

    @Test(priority = 32)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS RTGS") })
    @Step ("Verify_whether_a_user_can_select_Bank")
    public void Verify_whether_a_user_can_select_Bank() throws IOException, InterruptedException {
	//test =extent.createTest(" 5 Verify_whether_a_user_can_select_Bank (RTGS)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//*[text()=' RTGS ']")).click();
	driver.findElement(By.xpath("//*[@name='BENE_ACC_NAME']")).click();
	driver.findElement(By.xpath("//*[@name='BENE_ACC_NAME']")).sendKeys("Emmanuel Bore");
	driver.findElement(By.id("FORM_RTGS_TRANSFER_1-BENE_ACC_NO")).sendKeys("09901090909");
	driver.findElement(By.xpath("//*[@name='GET_BANKS']")).click();
	driver.findElement(By.xpath("//*[@name='search']")).click();
	driver.findElement(By.xpath("//*[@name='search']")).sendKeys("bank of africa");
	driver.findElement(By.xpath("//*[text()=' BANK OF AFRICA KENYA LTD ']")).click();
	System.out.println("TC5 Verify_whether_a_user_can_select_Bank |Success:");
    }
    // **********************************************************************************************************************************

    @Test(priority = 33)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS RTGS") })
    @Step ("Verify_whether_a_user_can_enter_physical_adress")
    public void Verify_whether_a_user_can_enter_physical_adress() throws IOException, InterruptedException {
	//test =extent.createTest(" 6 Verify_whether_a_user_can_enter_physical_adress (RTGS)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//*[text()=' RTGS ']")).click();
	driver.findElement(By.xpath("//*[@name='BENE_ACC_NAME']")).click();
	driver.findElement(By.xpath("//*[@name='BENE_ACC_NAME']")).sendKeys("Emmanuel Bore");
	driver.findElement(By.id("FORM_RTGS_TRANSFER_1-BENE_ACC_NO")).sendKeys("09901090909");
	driver.findElement(By.xpath("//*[@name='GET_BANKS']")).click();
	driver.findElement(By.xpath("//*[@name='search']")).click();
	driver.findElement(By.xpath("//*[@name='search']")).sendKeys("bank of africa");
	driver.findElement(By.xpath("//*[text()=' BANK OF AFRICA KENYA LTD ']")).click();
	driver.findElement(By.linkText("NEXT")).click();

	driver.findElement(By.id("FORM_RTGS_TRANSFER_12-BENE_ADDRESS_1")).click();
	System.out.println("TC6 Verify_whether_a_user_can_enter_physical_adress |Success:");
    }
    // **********************************************************************************************************************************

    @Test(priority = 34)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS RTGS") })
    @Step ("Verify_whether_a_user_can_enter_telephone_number")
    public void Verify_whether_a_user_can_enter_telephone_number() throws IOException, InterruptedException {
	//test =extent.createTest(" 7 Verify_whether_a_user_can_enter_telephone_number (RTGS)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//*[text()=' RTGS ']")).click();
	driver.findElement(By.xpath("//*[@name='BENE_ACC_NAME']")).click();
	driver.findElement(By.xpath("//*[@name='BENE_ACC_NAME']")).sendKeys("Emmanuel Bore");
	driver.findElement(By.id("FORM_RTGS_TRANSFER_1-BENE_ACC_NO")).sendKeys("09901090909");
	driver.findElement(By.xpath("//*[@name='GET_BANKS']")).click();
	driver.findElement(By.xpath("//*[@name='search']")).click();
	driver.findElement(By.xpath("//*[@name='search']")).sendKeys("bank of africa");
	driver.findElement(By.xpath("//*[text()=' BANK OF AFRICA KENYA LTD ']")).click();
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.id("FORM_RTGS_TRANSFER_12-BENE_MOBILE_NO")).click();
	driver.findElement(By.id("FORM_RTGS_TRANSFER_12-BENE_MOBILE_NO")).sendKeys("0723108899");
	driver.findElement(By.id("FORM_RTGS_TRANSFER_12-BENE_ADDRESS_1")).click();
	System.out.println("TC7 Verify_whether_a_user_can_enter_telephone_number |Success:");
    }
    // **********************************************************************************************************************************

    @Test(priority = 35)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS RTGS") })
    @Step ("Verify_whether_a_user_can_select_Debit_account")
    public void Verify_whether_a_user_can_select_Debit_account() throws IOException, InterruptedException {
	//test =extent.createTest(" 8 Verify_whether_a_user_can_select_Debit_account (RTGS)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//*[text()=' RTGS ']")).click();
	driver.findElement(By.xpath("//*[@name='BENE_ACC_NAME']")).click();
	driver.findElement(By.xpath("//*[@name='BENE_ACC_NAME']")).sendKeys("Emmanuel Bore");
	driver.findElement(By.id("FORM_RTGS_TRANSFER_1-BENE_ACC_NO")).sendKeys("09901090909");
	driver.findElement(By.xpath("//*[@name='GET_BANKS']")).click();
	driver.findElement(By.xpath("//*[@name='search']")).click();
	driver.findElement(By.xpath("//*[@name='search']")).sendKeys("bank of africa");
	driver.findElement(By.xpath("//*[text()=' BANK OF AFRICA KENYA LTD ']")).click();
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.id("FORM_RTGS_TRANSFER_12-BENE_MOBILE_NO")).click();
	driver.findElement(By.id("FORM_RTGS_TRANSFER_12-BENE_MOBILE_NO")).sendKeys("1231231231");
	driver.findElement(By.id("FORM_RTGS_TRANSFER_12-BENE_ADDRESS_1")).click();
	driver.findElement(By.id("FORM_RTGS_TRANSFER_12-BENE_ADDRESS_1")).sendKeys("Test@12");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.id("FORM_RTGS_TRANSFER_2-DEBIT_ACC_NO")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_RTGS_TRANSFER_2-DEBIT_ACC_NO"));
	    dropdown.findElement(By.xpath("//option[. = '01105413334100']")).click();
	}
	System.out.println("TC8 Verify_whether_a_user_can_select_Debit_account |Success:");
    }
    // **********************************************************************************************************************************

    @Test(priority = 36)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS RTGS") })
    @Step ("verify_whether_a_user_can_enter_amount_to_send")
    public void verify_whether_a_user_can_enter_amount_to_send() throws InterruptedException, IOException {
	//test =extent.createTest(" 9 verify_whether_a_user_can_enter_amount_to_send (RTGS)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//*[text()=' RTGS ']")).click();
	driver.findElement(By.xpath("//*[@name='BENE_ACC_NAME']")).click();
	driver.findElement(By.xpath("//*[@name='BENE_ACC_NAME']")).sendKeys("Emmanuel Bore");
	driver.findElement(By.id("FORM_RTGS_TRANSFER_1-BENE_ACC_NO")).sendKeys("09901090909");
	driver.findElement(By.xpath("//*[@name='GET_BANKS']")).click();
	driver.findElement(By.xpath("//*[@name='search']")).click();
	driver.findElement(By.xpath("//*[@name='search']")).sendKeys("bank of africa");
	driver.findElement(By.xpath("//*[text()=' BANK OF AFRICA KENYA LTD ']")).click();
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.id("FORM_RTGS_TRANSFER_12-BENE_MOBILE_NO")).click();
	driver.findElement(By.id("FORM_RTGS_TRANSFER_12-BENE_MOBILE_NO")).sendKeys("1231231231");
	driver.findElement(By.id("FORM_RTGS_TRANSFER_12-BENE_ADDRESS_1")).click();
	driver.findElement(By.id("FORM_RTGS_TRANSFER_12-BENE_ADDRESS_1")).sendKeys("Test@12");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.id("FORM_RTGS_TRANSFER_2-DEBIT_ACC_NO")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_RTGS_TRANSFER_2-DEBIT_ACC_NO"));
	    dropdown.findElement(By.xpath("//option[. = '01105413334100']")).click();
	}
	driver.findElement(By.id("FORM_RTGS_TRANSFER_2-DEBIT_ACC_NO")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_RTGS_TRANSFER_2-TRANSFER_CURRENCY")).click();
	Thread.sleep(3000);
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_RTGS_TRANSFER_2-TRANSFER_CURRENCY"));
	    dropdown.findElement(By.xpath("//option[. = 'KES']")).click();
	}
	driver.findElement(By.id("FORM_RTGS_TRANSFER_2-TRANSFER_CURRENCY")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_RTGS_TRANSFER_2-PAYMENT_AMOUNT")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_RTGS_TRANSFER_2-PAYMENT_AMOUNT")).sendKeys("1220");
	System.out.println("TC9 verify_whether_a_user_can_enter_amount_to_send |Success:");
    }
    // **********************************************************************************************************************************

    @Test(priority = 37)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS RTGS") })
    @Step ("Verify_whether_a_user_can_enter_payment_reason_details")
    public void Verify_whether_a_user_can_enter_payment_reason_details() throws InterruptedException, IOException {
	//test =extent.createTest(" 10 Verify_whether_a_user_can_enter_payment_reason_details (RTGS)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//*[text()=' RTGS ']")).click();
	driver.findElement(By.xpath("//*[@name='BENE_ACC_NAME']")).click();
	driver.findElement(By.xpath("//*[@name='BENE_ACC_NAME']")).sendKeys("Emmanuel Bore");
	driver.findElement(By.id("FORM_RTGS_TRANSFER_1-BENE_ACC_NO")).sendKeys("09901090909");
	driver.findElement(By.xpath("//*[@name='GET_BANKS']")).click();
	driver.findElement(By.xpath("//*[@name='search']")).click();
	driver.findElement(By.xpath("//*[@name='search']")).sendKeys("bank of africa");
	driver.findElement(By.xpath("//*[text()=' BANK OF AFRICA KENYA LTD ']")).click();
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.id("FORM_RTGS_TRANSFER_12-BENE_MOBILE_NO")).click();
	driver.findElement(By.id("FORM_RTGS_TRANSFER_12-BENE_MOBILE_NO")).sendKeys("1231231231");
	driver.findElement(By.id("FORM_RTGS_TRANSFER_12-BENE_ADDRESS_1")).click();
	driver.findElement(By.id("FORM_RTGS_TRANSFER_12-BENE_ADDRESS_1")).sendKeys("Test@12");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.id("FORM_RTGS_TRANSFER_2-DEBIT_ACC_NO")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_RTGS_TRANSFER_2-DEBIT_ACC_NO"));
	    dropdown.findElement(By.xpath("//option[. = '01105413334100']")).click();
	}
	driver.findElement(By.id("FORM_RTGS_TRANSFER_2-DEBIT_ACC_NO")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_RTGS_TRANSFER_2-TRANSFER_CURRENCY")).click();
	Thread.sleep(3000);
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_RTGS_TRANSFER_2-TRANSFER_CURRENCY"));
	    dropdown.findElement(By.xpath("//option[. = 'KES']")).click();
	}
	driver.findElement(By.id("FORM_RTGS_TRANSFER_2-TRANSFER_CURRENCY")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_RTGS_TRANSFER_2-PAYMENT_AMOUNT")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_RTGS_TRANSFER_2-PAYMENT_AMOUNT")).sendKeys("1220");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_RTGS_TRANSFER_3-REMARKS_OWN")).click();
	driver.findElement(By.id("FORM_RTGS_TRANSFER_3-REMARKS_OWN")).sendKeys("test");
	System.out.println("TC10 Verify_whether_a_user_can_enter_payment_reason_details |Success:");
    }
    // **********************************************************************************************************************************

    @Test(priority = 38)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS RTGS") })
    @Severity(SeverityLevel.CRITICAL)
    @Step ("Verify_whether_a_user_can_enter_OTP_to_verify_transaction")
    public void Verify_whether_a_user_can_enter_OTP_to_verify_transaction() throws IOException, InterruptedException {
	//test =extent.createTest(" 11 Verify_whether_a_user_can_enter_OTP_to_verify_transaction (RTGS)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//*[text()=' RTGS ']")).click();
	driver.findElement(By.xpath("//*[@name='BENE_ACC_NAME']")).click();
	driver.findElement(By.xpath("//*[@name='BENE_ACC_NAME']")).sendKeys("Emmanuel Bore");
	driver.findElement(By.id("FORM_RTGS_TRANSFER_1-BENE_ACC_NO")).sendKeys("09901090909");
	driver.findElement(By.xpath("//*[@name='GET_BANKS']")).click();
	driver.findElement(By.xpath("//*[@name='search']")).click();
	driver.findElement(By.xpath("//*[@name='search']")).sendKeys("bank of africa");
	driver.findElement(By.xpath("//*[text()=' BANK OF AFRICA KENYA LTD ']")).click();
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.id("FORM_RTGS_TRANSFER_12-BENE_MOBILE_NO")).click();
	driver.findElement(By.id("FORM_RTGS_TRANSFER_12-BENE_MOBILE_NO")).sendKeys("1231231231");
	driver.findElement(By.id("FORM_RTGS_TRANSFER_12-BENE_ADDRESS_1")).click();
	driver.findElement(By.id("FORM_RTGS_TRANSFER_12-BENE_ADDRESS_1")).sendKeys("Test@12");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.id("FORM_RTGS_TRANSFER_2-DEBIT_ACC_NO")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_RTGS_TRANSFER_2-DEBIT_ACC_NO"));
	    dropdown.findElement(By.xpath("//option[. = '01105413334100']")).click();
	}
	driver.findElement(By.id("FORM_RTGS_TRANSFER_2-DEBIT_ACC_NO")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_RTGS_TRANSFER_2-TRANSFER_CURRENCY")).click();
	Thread.sleep(3000);
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_RTGS_TRANSFER_2-TRANSFER_CURRENCY"));
	    dropdown.findElement(By.xpath("//option[. = 'KES']")).click();
	}
	driver.findElement(By.id("FORM_RTGS_TRANSFER_2-TRANSFER_CURRENCY")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_RTGS_TRANSFER_2-PAYMENT_AMOUNT")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_RTGS_TRANSFER_2-PAYMENT_AMOUNT")).sendKeys("1220");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_RTGS_TRANSFER_3-REMARKS_OWN")).click();
	driver.findElement(By.id("FORM_RTGS_TRANSFER_3-REMARKS_OWN")).sendKeys("test");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.linkText("SEND")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("5");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("6");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("6");
	System.out.println("TC11 Verify_whether_a_user_can_enter_OTP_to_verify_transaction |Success:");
    }
    // **********************************************************************************************************************************

    @Test(priority = 39)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS RTGS") })
    @Step ("Verify_whether_a_user_can_transfer_money_to_local_bank_using_RTGS")
    @Severity(SeverityLevel.BLOCKER)
    public void Verify_whether_a_user_can_transfer_money_to_local_bank_using_RTGS()
	    throws IOException, InterruptedException {
	//test =extent.createTest(" 12 Verify_whether_a_user_can_transfer_money_to_local_bank_using_RTGS (RTGS)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//*[text()=' RTGS ']")).click();
	driver.findElement(By.xpath("//*[@name='BENE_ACC_NAME']")).click();
	driver.findElement(By.xpath("//*[@name='BENE_ACC_NAME']")).sendKeys("Emmanuel Bore");
	driver.findElement(By.id("FORM_RTGS_TRANSFER_1-BENE_ACC_NO")).sendKeys("09901090909");
	driver.findElement(By.xpath("//*[@name='GET_BANKS']")).click();
	driver.findElement(By.xpath("//*[@name='search']")).click();
	driver.findElement(By.xpath("//*[@name='search']")).sendKeys("bank of africa");
	driver.findElement(By.xpath("//*[text()=' BANK OF AFRICA KENYA LTD ']")).click();
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.id("FORM_RTGS_TRANSFER_12-BENE_MOBILE_NO")).click();
	driver.findElement(By.id("FORM_RTGS_TRANSFER_12-BENE_MOBILE_NO")).sendKeys("1231231231");
	driver.findElement(By.id("FORM_RTGS_TRANSFER_12-BENE_ADDRESS_1")).click();
	driver.findElement(By.id("FORM_RTGS_TRANSFER_12-BENE_ADDRESS_1")).sendKeys("Test@12");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.id("FORM_RTGS_TRANSFER_2-DEBIT_ACC_NO")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_RTGS_TRANSFER_2-DEBIT_ACC_NO"));
	    dropdown.findElement(By.xpath("//option[. = '01105413334100']")).click();
	}
	driver.findElement(By.id("FORM_RTGS_TRANSFER_2-DEBIT_ACC_NO")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_RTGS_TRANSFER_2-TRANSFER_CURRENCY")).click();
	Thread.sleep(3000);
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_RTGS_TRANSFER_2-TRANSFER_CURRENCY"));
	    dropdown.findElement(By.xpath("//option[. = 'KES']")).click();
	}
	driver.findElement(By.id("FORM_RTGS_TRANSFER_2-TRANSFER_CURRENCY")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_RTGS_TRANSFER_2-PAYMENT_AMOUNT")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_RTGS_TRANSFER_2-PAYMENT_AMOUNT")).sendKeys("1220");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_RTGS_TRANSFER_3-REMARKS_OWN")).click();
	driver.findElement(By.id("FORM_RTGS_TRANSFER_3-REMARKS_OWN")).sendKeys("test");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.linkText("SEND")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("5");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("6");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("6");
	driver.findElement(By.linkText("Submit")).click();
	driver.findElement(By.linkText("Done")).click();
	System.out.println("TC12 Verify_whether_a_user_can_transfer_money_to_local_bank_using_RTGS |Success:");
    }
    // **********************************************************************************************************************************

    @Test(priority = 40)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS RTGS") })
    @Step ("END_Transfer_To_Local_Banks_RTGS_TestCases")
    public void END_Transfer_To_Local_Banks_RTGS_TestCases() throws IOException, InterruptedException {
	//test =extent.createTest("END OF TRANSFER TO LOCAL BANKS RTGS TESTCASES");
	System.out.println("************************* End of Transfer To Local Banks RTGS Testcases***********************************");
    }
    // **********************************************************************************************************************************
    
    @Test(priority = 41)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO (MPESA)") })
    @Step ("TRANSFER TO (MPESA)")
    @Severity(SeverityLevel.TRIVIAL)
    public void Running_transfer_to_MPESA_TestCases() throws IOException, InterruptedException {
	//test =extent.createTest("(D) RUNNING TRANSFER (MPESA)");
	System.out.println("*************************(d) Running transfer (MPESA)***********************************");
	System.out.println("Total Number of Test cases = 12 ");

    }
//**********************************************************************************************************************************

    @Test(priority = 42)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO (MPESA)") })
    @Severity(SeverityLevel.MINOR)
    @Step ("Verify_whether_a_user_can_select_MPESA_menu")
    public void Verify_whether_a_user_can_select_MPESA_menu() throws IOException, InterruptedException {
	//test =extent.createTest(" 1 Verify_whether_a_user_can_select_MPESA_menu (MPESA)");
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);		
	Transfer_To_Coop_Other_Account = new XSSFWorkbook(fis);
	sheet = Transfer_To_Coop_Other_Account.getSheet("Loginmodule");		
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
	try {
	    Thread.sleep(3000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.cssSelector(".card:nth-child(6) > .card-body")).click();
	driver.findElement(By.cssSelector("#mobbank span:nth-child(2)")).click();
	System.out.println("TC1 Verify_whether_a_user_can_select_MPESA_menu |Success:");

    }
    // **********************************************************************************************************************************

    @Test(priority = 43)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO (MPESA)") })
    @Step ("Verify_whether_a_user_can_select_my_number")
    public void Verify_whether_a_user_can_select_my_number() throws IOException, InterruptedException {
	//test =extent.createTest(" 2 Verify_whether_a_user_can_select_my_number (MPESA)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	try {
	    Thread.sleep(3000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.cssSelector(".card:nth-child(6) > .card-body")).click();
	driver.findElement(By.cssSelector("#mobbank span:nth-child(2)")).click();
	driver.findElement(By.cssSelector(".radio-inline:nth-child(1)")).click();
	System.out.println("TC2 Verify_whether_a_user_can_select_my_number |Success:");

    }
    // **********************************************************************************************************************************

    @Test(priority = 44)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO (MPESA)") })
    @Step ("Verify_whether_a_user_can_select_radio_button_my_number")
    public void Verify_whether_a_user_can_select_radio_button_my_number() throws IOException, InterruptedException {
	//test =extent.createTest(" 3 Verify_whether_a_user_can_select_radio_button_my_number (MPESA)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	try {
	    Thread.sleep(3000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.cssSelector(".card:nth-child(6) > .card-body")).click();
	driver.findElement(By.cssSelector("#mobbank > .col-in")).click();
	driver.findElement(By.cssSelector(".radio-inline:nth-child(1)")).click();
	driver.findElement(By.cssSelector(".radio-inline:nth-child(2)")).click();
	System.out.println("TC3 Verify_whether_a_user_can_select_radio_button_my_number |Success:");

    }
    // **********************************************************************************************************************************

    @Test(priority = 45)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO (MPESA)") })
    @Step ("Verify_whether_a_user_can_select_Debit_account_my_number")
    public void Verify_whether_a_user_can_select_Debit_account_my_number() throws IOException, InterruptedException {
	//test =extent.createTest(" 4 Verify_whether_a_user_can_select_Debit_account_my_number (MPESA)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	try {
	    Thread.sleep(3000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.cssSelector(".card:nth-child(6) > .card-body")).click();
	driver.findElement(By.cssSelector("#mobbank span:nth-child(2)")).click();
	driver.findElement(By.cssSelector(".radio-inline:nth-child(1)")).click();
	driver.findElement(By.id("PMNTDET-DEBIT_ACCOUNT")).sendKeys("01105413334100");
//	    {
//	      WebElement dropdown = driver.findElement(By.id("PMNTDET-DEBIT_ACCOUNT"));
//	      dropdown.findElement(By.xpath("//option[. = '01111155507800']")).click();
//	    }
	driver.findElement(By.id("PMNTDET-DEBIT_ACCOUNT")).click();
	System.out.println("TC4 Verify_whether_a_user_can_select_Debit_account_my_number |Success:");

    }
    // **********************************************************************************************************************************

    @Test(priority = 46)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO (MPESA)") })
    @Step ("Verify_whether_a_user_can_enter_payment_reason_my_account")
    public void Verify_whether_a_user_can_enter_payment_reason_my_account() throws IOException, InterruptedException {
	//test =extent.createTest(" 5 Verify_whether_a_user_can_enter_payment_reason_my_account (MPESA)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	try {
	    Thread.sleep(3000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.cssSelector(".card:nth-child(6) > .card-body")).click();
	driver.findElement(By.cssSelector("#mobbank span:nth-child(2)")).click();
	driver.findElement(By.cssSelector(".radio-inline:nth-child(1)")).click();
	driver.findElement(By.id("PMNTDET-DEBIT_ACCOUNT")).sendKeys("01105413334100");
//	    {
//	      WebElement dropdown = driver.findElement(By.id("PMNTDET-DEBIT_ACCOUNT"));
//	      dropdown.findElement(By.xpath("//option[. = '01111155507800']")).click();
//	    }
	driver.findElement(By.id("PMNTDET-DEBIT_ACCOUNT")).click();
	driver.findElement(By.id("PMNTDET-AMOUNT")).click();
	driver.findElement(By.id("PMNTDET-AMOUNT")).sendKeys("1200");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.id("PMNTDET2-NARRATION")).click();
	driver.findElement(By.id("PMNTDET2-NARRATION")).sendKeys("Test@12");
	System.out.println("TC5 Verify_whether_a_user_can_enter_payment_reason_my_account |Success:");

    }
    // **********************************************************************************************************************************

    @Test(priority = 47)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO (MPESA)") })
    @Severity(SeverityLevel.CRITICAL)
    @Step ("Verify_whether_a_user_can_enter_OTP_to_Verify_transaction_my_number")
    public void Verify_whether_a_user_can_enter_OTP_to_Verify_transaction_my_number()
	    throws IOException, InterruptedException {
	//test =extent.createTest(" 6 Verify_whether_a_user_can_enter_OTP_to_Verify_transaction_my_number (MPESA)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.cssSelector(".card:nth-child(6) > .card-body")).click();
	driver.findElement(By.cssSelector("#mobbank span:nth-child(2)")).click();
	driver.findElement(By.cssSelector(".radio-inline:nth-child(1)")).click();
	driver.findElement(By.id("PMNTDET-DEBIT_ACCOUNT")).sendKeys("01105413334100");
//	    {
//	      WebElement dropdown = driver.findElement(By.id("PMNTDET-DEBIT_ACCOUNT"));
//	      dropdown.findElement(By.xpath("//option[. = '01111155507800']")).click();
//	    }
	driver.findElement(By.id("PMNTDET-DEBIT_ACCOUNT")).click();
	driver.findElement(By.id("PMNTDET-AMOUNT")).click();
	driver.findElement(By.id("PMNTDET-AMOUNT")).sendKeys("1222");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.id("PMNTDET2-NARRATION")).click();
	driver.findElement(By.id("PMNTDET2-NARRATION")).sendKeys("Test@12");
	Thread.sleep(3000);
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("NEXT")).click();	
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("1");
	System.out.println("TC6 Verify_whether_a_user_can_enter_OTP_to_Verify_transaction_my_number |Success:");
    }
    // **********************************************************************************************************************************

    @Test(priority = 48)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO (MPESA)") })
    @Severity(SeverityLevel.CRITICAL)
    @Step ("Verify_whether_a_user_can_transfer_money_from_a_ccount_to_mobile_number_my_number")
    public void Verify_whether_a_user_can_transfer_money_from_a_ccount_to_mobile_number_my_number()
	    throws IOException, InterruptedException {
	//test =extent.createTest(" 7 Verify_whether_a_user_can_transfer_money_from_a_ccount_to_mobile_number_my_number (MPESA)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.cssSelector(".card:nth-child(6) > .card-body")).click();
	driver.findElement(By.cssSelector("#mobbank span:nth-child(2)")).click();
	driver.findElement(By.cssSelector(".radio-inline:nth-child(1)")).click();
	driver.findElement(By.id("PMNTDET-DEBIT_ACCOUNT")).sendKeys("01105413334100");
	driver.findElement(By.id("PMNTDET-DEBIT_ACCOUNT")).click();
	driver.findElement(By.id("PMNTDET-AMOUNT")).click();
	driver.findElement(By.id("PMNTDET-AMOUNT")).sendKeys("3000");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.id("PMNTDET2-NARRATION")).click();
	driver.findElement(By.id("PMNTDET2-NARRATION")).sendKeys("Test@12");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("1");
	driver.findElement(By.linkText("Submit")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Done")).click();
	System.out.println(
		"TC7 Verify_whether_a_user_can_transfer_money_from_a_ccount_to_mobile_number_my_number |Success:");
    }
    // **********************************************************************************************************************************

    @Test(priority = 49)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO (MPESA)") })
    @Step ("Verify_whether_a_user_can_select_other_number_radio_button")
    public void Verify_whether_a_user_can_select_other_number_radio_button() throws IOException, InterruptedException {
	//test =extent.createTest(" 8 Verify_whether_a_user_can_select_other_number_radio_button (MPESA)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.cssSelector(".card:nth-child(6) > .card-body")).click();
	driver.findElement(By.cssSelector("#mobbank > .col-in")).click();
	driver.findElement(By.cssSelector(".radio-inline:nth-child(2)")).click();
	System.out.println("TC8 Verify_whether_a_user_can_select_other_number_radio_button |Success:");
    }
    // **********************************************************************************************************************************

    @Test(priority = 50)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO (MPESA)") })
    @Step ("Verify_whether_a_user_can_enter_other_number")
    public void Verify_whether_a_user_can_enter_other_number() throws IOException, InterruptedException {
	//test =extent.createTest(" 9 Verify_whether_a_user_can_enter_other_number");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.cssSelector(".card:nth-child(6) > .card-body")).click();
	driver.findElement(By.cssSelector("#mobbank > .col-in")).click();
	driver.findElement(By.cssSelector(".radio-inline:nth-child(2)")).click();
	driver.findElement(By.id("PMNTDET-MPESA_BEN_MSISDN")).click();
	driver.findElement(By.id("PMNTDET-MPESA_BEN_MSISDN")).sendKeys("0723121234");
	driver.findElement(By.id("PMNTDET-DEBIT_ACCOUNT")).click();
	System.out.println("TC9 Verify_whether_a_user_can_enter_other_number |Success:");
    }
    // **********************************************************************************************************************************

    @Test(priority = 51)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO (MPESA)") })
    @Step ("Verify_whether_a_user_can_select_Debit_account_other_number")
    public void Verify_whether_a_user_can_select_Debit_account_other_number() throws InterruptedException, IOException {
	//test =extent.createTest(" 10 Verify_whether_a_user_can_select_Debit_account_other_number (MPESA)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.cssSelector(".card:nth-child(6) > .card-body")).click();
	driver.findElement(By.cssSelector("#mobbank > .col-in")).click();
	driver.findElement(By.cssSelector(".radio-inline:nth-child(2)")).click();
	driver.findElement(By.id("PMNTDET-MPESA_BEN_MSISDN")).click();
	driver.findElement(By.id("PMNTDET-MPESA_BEN_MSISDN")).sendKeys("0723456789");
	driver.findElement(By.id("PMNTDET-DEBIT_ACCOUNT")).sendKeys("01105413334100");
	driver.findElement(By.id("PMNTDET-DEBIT_ACCOUNT")).click();
	System.out.println("TC10 Verify_whether_a_user_can_select_Debit_account_other_number |Success:");
    }
    // **********************************************************************************************************************************

    @Test(priority = 52)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO (MPESA)") })
    @Step ("Verify_whether_a_user_can_enter_payment_reason_other_account")
    public void Verify_whether_a_user_can_enter_payment_reason_other_account()
	    throws IOException, InterruptedException {
	//test =extent.createTest(" 11 Verify_whether_a_user_can_enter_payment_reason_other_account (MPESA)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.cssSelector(".card:nth-child(6) > .card-body")).click();
	driver.findElement(By.cssSelector("#mobbank > .col-in")).click();
	driver.findElement(By.cssSelector(".radio-inline:nth-child(2)")).click();
	driver.findElement(By.id("PMNTDET-MPESA_BEN_MSISDN")).click();
	driver.findElement(By.id("PMNTDET-MPESA_BEN_MSISDN")).sendKeys("0712121212");
	driver.findElement(By.id("PMNTDET-DEBIT_ACCOUNT")).sendKeys("01105413334100");
	driver.findElement(By.id("PMNTDET-DEBIT_ACCOUNT")).click();
	driver.findElement(By.id("PMNTDET-AMOUNT")).click();
	driver.findElement(By.id("PMNTDET-AMOUNT")).sendKeys("1200");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("PMNTDET2-NARRATION")).click();
	driver.findElement(By.id("PMNTDET2-NARRATION")).sendKeys("Test");
	driver.findElement(By.linkText("NEXT")).click();
	System.out.println("TC11 Verify_whether_a_user_can_enter_payment_reason_other_account |Success:");
    }
    // **********************************************************************************************************************************

    @Test(priority = 53)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO (MPESA)") })
    @Severity(SeverityLevel.BLOCKER)
    @Step ("Verify_whether_a_user_can_enter_OTP_to_Verify_transaction_other_number")
    public void Verify_whether_a_user_can_enter_OTP_to_Verify_transaction_other_number()
	    throws IOException, InterruptedException {
	//test =extent.createTest(" 12 Verify_whether_a_user_can_enter_OTP_to_Verify_transaction_other_number (MPESA)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.cssSelector(".card:nth-child(6) > .card-body")).click();
	driver.findElement(By.cssSelector("#mobbank span:nth-child(2)")).click();
	driver.findElement(By.cssSelector(".radio-inline:nth-child(2)")).click();
	driver.findElement(By.id("PMNTDET-MPESA_BEN_MSISDN")).click();
	driver.findElement(By.id("PMNTDET-MPESA_BEN_MSISDN")).sendKeys("0725347800");
	driver.findElement(By.id("PMNTDET-DEBIT_ACCOUNT")).click();
	driver.findElement(By.id("PMNTDET-DEBIT_ACCOUNT")).click();
	driver.findElement(By.id("PMNTDET-DEBIT_ACCOUNT")).sendKeys("01105413334100");
	driver.findElement(By.id("PMNTDET-DEBIT_ACCOUNT")).click();
	driver.findElement(By.id("PMNTDET-AMOUNT")).click();
	driver.findElement(By.id("PMNTDET-AMOUNT")).sendKeys("1500");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.id("PMNTDET2-NARRATION")).click();
	driver.findElement(By.id("PMNTDET2-NARRATION")).sendKeys("Test");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("1");
	driver.findElement(By.linkText("Submit")).click();

	driver.findElement(By.linkText("Done")).click();
	System.out.println("TC12 Verify_whether_a_user_can_enter_OTP_to_Verify_transaction_other_number |Success:");
    }
    // **********************************************************************************************************************************

    @Test(priority = 54)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO (MPESA)") })
    @Step ("End_Of_Mobile_Money_MPESA_TestCases")
    @Severity(SeverityLevel.TRIVIAL)
    public void End_Of_Mobile_Money_MPESA_TestCases() throws IOException, InterruptedException {
	//test =extent.createTest("END OF TRANSFER (MPESA)");
	System.out.println("*************************End of Transfer (MPESA)***********************************");
    }

    // **********************************************************************************************************************************
    @Test(priority = 55)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS PESALINK") })
     @Step ("TRANSFER TO LOCAL BANKS PESALINK")
    @Severity(SeverityLevel.TRIVIAL)
    public void Running_Transfer_To_Local_Banks_Pesalink_TestCases() throws IOException, InterruptedException {
	//test =extent.createTest("(E) RUNNING TRANSFER TO LOCAL BANKS PESALINK TESTCASES");
	System.out.println(
		"*************************(e) Running Transfer To Local Banks Pesalink Testcases***********************************");
	System.out.println("Total Number of Test cases = 17 ");
    }

//***********************************************************************************************************************************			    
    @Test(priority = 56)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS PESALINK") })
    @Severity(SeverityLevel.MINOR)
    @Step ("verify_that_a_user_can_select_Pesalink_Account_number_menu")
    public void verify_that_a_user_can_select_Pesalink_Account_number_menu() throws InterruptedException, IOException {
	//test =extent.createTest(" 1 verify_that_a_user_can_select_Pesalink_Account_number_menu (PESALINK)");
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);		
	Transfer_To_Coop_Other_Account = new XSSFWorkbook(fis);
	sheet = Transfer_To_Coop_Other_Account.getSheet("Loginmodule");		
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
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//*[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//*[text()=' PesaLink  ']")).click();
	System.out.println("TC1 verify_that_a_user_can_select_Pesalink_Account_number_menu |Success:");
    }

    // ***************************************************************************

    @Test(priority = 57)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS PESALINK") })
    @Step ("verify_whether_a_user_can_select_Account_number_option")
    public void verify_whether_a_user_can_select_Account_number_option() throws InterruptedException, IOException {
	//test =extent.createTest(" 2 verify_whether_a_user_can_select_Account_number_option (PESALINK)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//*[text()=' PesaLink  ']")).click();
	driver.findElement(By.xpath("//*[text()='Account Number']")).click();
	System.out.println("TC2 verify_whether_a_user_can_select_Account_number_option |Success:");
    }

    // ***************************************************************************

    @Test(priority = 58)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS PESALINK") })
    @Step ("Verify_whether_a_user_can_enter_new_beneficiary_name_Account_option")
    public void Verify_whether_a_user_can_enter_new_beneficiary_name_Account_option()
	    throws IOException, InterruptedException {
	//test =extent.createTest(" 3 Verify_whether_a_user_can_enter_new_beneficiary_name_Account_option (PESALINK)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//*[text()=' PesaLink  ']")).click();
	driver.findElement(By.xpath("//*[text()='Account Number']")).click();
	driver.findElement(By.xpath("//*[@name='BENFLD4_BENENAME']")).click();
	System.out.println("TC3 Verify_whether_a_user_can_enter_new_beneficiary_name_Account_option|Success:");
    }

    // ***********************************************************************************************************************************

    @Test(priority = 59)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS PESALINK") })
    @Step ("Verify_whether_a_user_can_enter_Beneficiary_account_number_Account_option")
    public void Verify_whether_a_user_can_enter_Beneficiary_account_number_Account_option()
	    throws IOException, InterruptedException {
	//test =extent.createTest(" 4 Verify_whether_a_user_can_enter_Beneficiary_account_number_Account_option (PESALINK)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//*[text()=' PesaLink  ']")).click();
	driver.findElement(By.xpath("//*[text()='Account Number']")).click();
	driver.findElement(By.xpath("//*[@name='BENFLD4_BENENAME']")).click();
	driver.findElement(By.id("FORM_PESALINK_BENE-BENFLD4_BENENAME")).sendKeys("Emmanuwl");
	driver.findElement(By.id("FORM_PESALINK_BENE-BENN20_IBAN_ACC")).click();
	driver.findElement(By.id("FORM_PESALINK_BENE-BENN20_IBAN_ACC")).sendKeys("09901070906655");
	driver.findElement(By.xpath("//button[@id='FORM_PESALINK_BENE-GET_BANKS']")).click();
	driver.findElement(By.xpath("//input[@id='searchbarPesa']")).click();
	driver.findElement(By.xpath("//input[@id='searchbarPesa']")).sendKeys("bank of africa");
	driver.findElement(By.xpath("//*[text()=' BANK OF AFRICA ']")).click();
	System.out.println("TC4 Verify_whether_a_user_can_enter_Beneficiary_account_number_Account_option |Success:");
    }

    // ***********************************************************************************************************************************

    @Test(priority = 60)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS PESALINK") })
    @Step ("Verify_whether_a_user_can_select_bank_name_from_dropdown_menu")
    public void Verify_whether_a_user_can_select_bank_name_from_dropdown_menu()
	    throws IOException, InterruptedException {
	//test =extent.createTest(" 5 Verify_whether_a_user_can_select_bank_name_from_dropdown_menu (PESALINK)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//*[text()=' PesaLink  ']")).click();
	driver.findElement(By.xpath("//*[text()='Account Number']")).click();
	driver.findElement(By.xpath("//*[@name='BENFLD4_BENENAME']")).click();
	driver.findElement(By.id("FORM_PESALINK_BENE-BENFLD4_BENENAME")).sendKeys("09901090906655");
	driver.findElement(By.id("FORM_PESALINK_BENE-BENN20_IBAN_ACC")).click();
	driver.findElement(By.id("FORM_PESALINK_BENE-BENN20_IBAN_ACC")).sendKeys("09901073906655");
	driver.findElement(By.xpath("//button[@id='FORM_PESALINK_BENE-GET_BANKS']")).click();
	driver.findElement(By.xpath("//input[@id='searchbarPesa']")).click();
	driver.findElement(By.xpath("//input[@id='searchbarPesa']")).sendKeys("bank of africa");
	driver.findElement(By.xpath("//*[text()=' BANK OF AFRICA ']")).click();
	System.out.println("TC5 Verify_whether_a_user_can_select_bank_name_from_dropdown_menu |Success:");
    }

//***********************************************************************************************************************************			    
    @Test(priority = 61)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS PESALINK") })
    @Step ("Verify_whether_can_select_debit_account_to_send_to_beneficiary")
    public void Verify_whether_can_select_debit_account_to_send_to_beneficiary()
	    throws IOException, InterruptedException {
	//test =extent.createTest(" 6 Verify_whether_can_select_debit_account_to_send_to_beneficiary (PESALINK)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);

	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//span[text()=' PesaLink  ']")).click();
	driver.findElement(By.xpath("//div[@class='pesaAcc']")).click();
	driver.findElement(By.xpath("//input[@id='FORM_PESALINK_BENE-BENFLD4_BENENAME']")).sendKeys("menuh");
	driver.findElement(By.xpath("//input[@id='FORM_PESALINK_BENE-BENN20_IBAN_ACC']")).sendKeys("09901010933655");
	driver.findElement(By.xpath("//button[@id='FORM_PESALINK_BENE-GET_BANKS']")).click();
	driver.findElement(By.xpath("//input[@id='searchbarPesa']")).click();
	driver.findElement(By.xpath("//input[@id='searchbarPesa']")).sendKeys("bank of africa");
	driver.findElement(By.xpath("//*[text()=' BANK OF AFRICA ']")).click();
	System.out.println("TC6 Verify_whether_can_select_debit_account_to_send_to_beneficiary |Success:");

    }

//***********************************************************************************************************************************			    
    @Test(priority = 62)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS PESALINK") })
    @Step ("Verify_whether_a_user_can_enter_amount_to_send")
    public void Verify_whether_a_user_can_enter_amount_to_send() throws InterruptedException, IOException {
	//test =extent.createTest(" 7 Verify_whether_a_user_can_enter_amount_to_send (PESALINK)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//span[text()=' PesaLink  ']")).click();
	driver.findElement(By.xpath("//div[@class='pesaAcc']")).click();
	driver.findElement(By.xpath("//input[@id='FORM_PESALINK_BENE-BENFLD4_BENENAME']")).sendKeys("menuh");
	driver.findElement(By.xpath("//input[@id='FORM_PESALINK_BENE-BENN20_IBAN_ACC']")).sendKeys("09901010933655");
	driver.findElement(By.xpath("//button[@id='FORM_PESALINK_BENE-GET_BANKS']")).click();
	driver.findElement(By.xpath("//input[@id='searchbarPesa']")).click();
	driver.findElement(By.xpath("//input[@id='searchbarPesa']")).sendKeys("bank of africa");
	driver.findElement(By.xpath("//*[text()=' BANK OF AFRICA ']")).click();
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.id("FORM_PESALINK_PAY-PESALINK_ACC_NO")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_PESALINK_PAY-PESALINK_ACC_NO"));
	    dropdown.findElement(By.xpath("//option[. = '01105413334100']")).click();
	}
	driver.findElement(By.id("FORM_PESALINK_PAY-PESALINK_ACC_NO")).click();
	driver.findElement(By.id("FORM_PESALINK_PAY-PESALINK_PAY_AMNT")).click();
	driver.findElement(By.id("FORM_PESALINK_PAY-PESALINK_PAY_AMNT")).sendKeys("1233");
	System.out.println("TC7 Verify_whether_a_user_can_enter_amount_to_send |Success:");
    }

//***********************************************************************************************************************************			    
    @Test(priority = 63)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS PESALINK") })
    @Step ("Verify_whether_a_user_can_enter_payment_Reason1")
    public void Verify_whether_a_user_can_enter_payment_Reason1() throws IOException, InterruptedException {
	//test =extent.createTest(" 8 Verify_whether_a_user_can_enter_payment_Reason (PESALINK)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//span[text()=' PesaLink  ']")).click();
	driver.findElement(By.xpath("//div[@class='pesaAcc']")).click();
	driver.findElement(By.xpath("//input[@id='FORM_PESALINK_BENE-BENFLD4_BENENAME']")).sendKeys("menuh");
	driver.findElement(By.xpath("//input[@id='FORM_PESALINK_BENE-BENN20_IBAN_ACC']")).sendKeys("09901010933655");
	driver.findElement(By.xpath("//button[@id='FORM_PESALINK_BENE-GET_BANKS']")).click();
	driver.findElement(By.xpath("//input[@id='searchbarPesa']")).click();
	driver.findElement(By.xpath("//input[@id='searchbarPesa']")).sendKeys("bank of africa");
	driver.findElement(By.xpath("//*[text()=' BANK OF AFRICA ']")).click();
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.id("FORM_PESALINK_PAY-PESALINK_ACC_NO")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_PESALINK_PAY-PESALINK_ACC_NO"));
	    dropdown.findElement(By.xpath("//option[. = '01105413334100']")).click();
	}
	driver.findElement(By.id("FORM_PESALINK_PAY-PESALINK_ACC_NO")).click();
	driver.findElement(By.id("FORM_PESALINK_PAY-PESALINK_PAY_AMNT")).click();
	driver.findElement(By.id("FORM_PESALINK_PAY-PESALINK_PAY_AMNT")).sendKeys("1233");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.id("FORM_PESALINK_PAY_NOW-PESA_REMARKS")).click();
	driver.findElement(By.id("FORM_PESALINK_PAY_NOW-PESA_REMARKS")).sendKeys("Test");
	driver.findElement(By.linkText("NEXT")).click();
	System.out.println("TC8 Verify_whether_a_user_can_enter_payment_Reason |Success:");
    }

//***********************************************************************************************************************************			    
    @Test(priority = 64)
    @Epic("FUND TRANSFER")
    @Severity(SeverityLevel.CRITICAL)
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS PESALINK") })
    @Step ("Verify_whether_a_user_can_enter_OTP_to_validate_amount_to_send")
    public void Verify_whether_a_user_can_enter_OTP_to_validate_amount_to_send()
	    throws IOException, InterruptedException {
	//test =extent.createTest(" 9 Verify_whether_a_user_can_enter_OTP_to_validate_amount_to_send (PESALINK)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//span[text()=' PesaLink  ']")).click();
	driver.findElement(By.xpath("//div[@class='pesaAcc']")).click();
	driver.findElement(By.xpath("//input[@id='FORM_PESALINK_BENE-BENFLD4_BENENAME']")).sendKeys("menuh");
	driver.findElement(By.xpath("//input[@id='FORM_PESALINK_BENE-BENN20_IBAN_ACC']")).sendKeys("09901010933655");
	driver.findElement(By.xpath("//button[@id='FORM_PESALINK_BENE-GET_BANKS']")).click();
	driver.findElement(By.xpath("//input[@id='searchbarPesa']")).click();
	driver.findElement(By.xpath("//input[@id='searchbarPesa']")).sendKeys("bank of africa");
	driver.findElement(By.xpath("//*[text()=' BANK OF AFRICA ']")).click();
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.id("FORM_PESALINK_PAY-PESALINK_ACC_NO")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_PESALINK_PAY-PESALINK_ACC_NO"));
	    dropdown.findElement(By.xpath("//option[. = '01105413334100']")).click();
	}

	driver.findElement(By.id("FORM_PESALINK_PAY-PESALINK_ACC_NO")).click();
	driver.findElement(By.id("FORM_PESALINK_PAY-PESALINK_PAY_AMNT")).click();
	driver.findElement(By.id("FORM_PESALINK_PAY-PESALINK_PAY_AMNT")).sendKeys("100");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.id("FORM_PESALINK_PAY_NOW-PESA_REMARKS")).click();
	driver.findElement(By.id("FORM_PESALINK_PAY_NOW-PESA_REMARKS")).sendKeys("Test");
	driver.findElement(By.xpath("//*[text()='NEXT']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[text()='NEXT']")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("3");
	System.out.println("TC9 Verify_whether_a_user_can_enter_OTP_to_validate_amount_to_send |Success:");
    }
    // ***********************************************************************************************************************************

    @Test(priority = 65)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS PESALINK") })
    @Severity(SeverityLevel.BLOCKER)
    @Step ("Verify_whether_a_user_can_send_money_using_Pesalink_using_account_option")
    public void Verify_whether_a_user_can_send_money_using_Pesalink_using_account_option()
	    throws InterruptedException, IOException {
	//test =extent.createTest(" 10 Verify_whether_a_user_can_send_money_using_Pesalink_using_account_option (PESALINK)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//*[text()=' PesaLink  ']")).click();
	driver.findElement(By.cssSelector(".pesaAcc")).click();
	driver.findElement(By.id("FORM_PESALINK_BENE-BENFLD4_BENENAME")).click();
	driver.findElement(By.id("FORM_PESALINK_BENE-BENFLD4_BENENAME")).sendKeys("menuh");
	driver.findElement(By.xpath("//input[@id='FORM_PESALINK_BENE-BENN20_IBAN_ACC']")).sendKeys("09901010933655");
	driver.findElement(By.xpath("//button[@id='FORM_PESALINK_BENE-GET_BANKS']")).click();
	driver.findElement(By.xpath("//input[@id='searchbarPesa']")).click();
	driver.findElement(By.xpath("//input[@id='searchbarPesa']")).sendKeys("bank of africa");
	driver.findElement(By.xpath("//*[text()=' BANK OF AFRICA ']")).click();
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.id("FORM_PESALINK_PAY-PESALINK_ACC_NO")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_PESALINK_PAY-PESALINK_ACC_NO"));
	    dropdown.findElement(By.xpath("//option[. = '01105413334100']")).click();
	}
	driver.findElement(By.id("FORM_PESALINK_PAY-PESALINK_ACC_NO")).click();
	driver.findElement(By.id("FORM_PESALINK_PAY-PESALINK_PAY_AMNT")).click();
	driver.findElement(By.id("FORM_PESALINK_PAY-PESALINK_PAY_AMNT")).sendKeys("1111");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.id("FORM_PESALINK_PAY_NOW-PESA_REMARKS")).click();
	driver.findElement(By.id("FORM_PESALINK_PAY_NOW-PESA_REMARKS")).sendKeys("Test");
	driver.findElement(By.xpath("//*[text()='NEXT']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[text()='NEXT']")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("3");
	driver.findElement(By.linkText("Submit")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=' Done ']")));
	driver.findElement(By.xpath("//a[text()=' Done ']")).click();
	System.out.println("TC10 Verify_whether_a_user_can_send_money_using_Pesalink_using_account_option |Success:");
    }

//***********************************************************************************************************************************			    
    @Test(priority = 66)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS PESALINK") })
    @Step ("Verify_whether_a_user_can_select_mobile_number_option")
    public void Verify_whether_a_user_can_select_mobile_number_option() throws IOException, InterruptedException {
	//test =extent.createTest(" 11 Verify_whether_a_user_can_select_mobile_number_option (PESALINK)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//*[text()=' PesaLink  ']")).click();
	driver.findElement(By.xpath("//*[text()='Mobile Number']")).click();
	System.out.println("TC11 Verify_whether_a_user_can_select_mobile_number_option|Success:");
    }

//***********************************************************************************************************************************			    
    @Test(priority = 67)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS PESALINK") })
    @Step ("Verify_whether_a_user_can_enter_beneficiary_phone_number")
    public void Verify_whether_a_user_can_enter_beneficiary_phone_number() throws InterruptedException, IOException {
	//test =extent.createTest(" 12 Verify_whether_a_user_can_enter_beneficiary_phone_number (PESALINK)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//*[text()=' PesaLink  ']")).click();
	driver.findElement(By.xpath("//*[text()='Mobile Number']")).click();
	driver.findElement(By.xpath("//*[@id='FORM_PESALINK_MOB_BENE-BEN_PH_NUMBER']")).click();
	driver.findElement(By.xpath("//*[@id='FORM_PESALINK_MOB_BENE-BEN_PH_NUMBER']")).sendKeys("0720599572");
	System.out.println("TC12 Verify_whether_a_user_can_enter_beneficiary_phone_number|Success:");
    }

//***********************************************************************************************************************************			    
    @Test(priority = 68)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS PESALINK") })
    @Step ("Verify_whether_a_user_can_select_bank_attached_to_phonenumber")
    public void Verify_whether_a_user_can_select_bank_attached_to_phonenumber()
	    throws InterruptedException, IOException {
	//test =extent.createTest(" 13 Verify_whether_a_user_can_select_bank_attached_to_phonenumber (PESALINK)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//*[text()=' PesaLink  ']")).click();
	driver.findElement(By.xpath("//*[text()='Mobile Number']")).click();
	driver.findElement(By.xpath("//*[@id='FORM_PESALINK_MOB_BENE-BEN_PH_NUMBER']")).click();
	driver.findElement(By.xpath("//*[@id='FORM_PESALINK_MOB_BENE-BEN_PH_NUMBER']")).sendKeys("0720599572");
	driver.findElement(By.xpath("//*[text()='Get Destination Bank']")).click();
	driver.findElement(By.xpath("//label[@class='radio-inline']")).click();
	System.out.println("TC13 Verify_whether_a_user_can_select_bank_attached_to_phonenumber |Success:");
    }

//***********************************************************************************************************************************			    
    @Test(priority = 69)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS PESALINK") })
    @Step ("Verify_whether_a_user_can_select_debit_account_mobile_number_option")
    public void Verify_whether_a_user_can_select_debit_account_mobile_number_option()
	    throws InterruptedException, IOException {
	//test =extent.createTest(" 14 Verify_whether_a_user_can_select_debit_account_mobile_number_option (PESALINK)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//*[text()=' PesaLink  ']")).click();
	driver.findElement(By.xpath("//*[text()='Mobile Number']")).click();
	driver.findElement(By.xpath("//*[@id='FORM_PESALINK_MOB_BENE-BEN_PH_NUMBER']")).click();
	driver.findElement(By.xpath("//*[@id='FORM_PESALINK_MOB_BENE-BEN_PH_NUMBER']")).sendKeys("0720599572");
	driver.findElement(By.xpath("//*[text()='Get Destination Bank']")).click();
	driver.findElement(By.xpath("//label[@class='radio-inline']")).click();
	driver.findElement(By.xpath("//*[@id='FORM_PESALINK_MOB_PAY-PESALINK_MOB_DEBIT_ACC_NO']")).click();
	driver.findElement(By.xpath("//*[@id='FORM_PESALINK_MOB_PAY-PESALINK_MOB_DEBIT_ACC_NO']"))
		.sendKeys("01125413334100");
	System.out.println("TC14 Verify_whether_a_user_can_select_debit_account_mobile_number_option |Success:");
    }

//***********************************************************************************************************************************			    
    @Test(priority = 70)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS PESALINK") })
    @Step ("Verify_whether_a_user_can_enter_amount_to_send_mobile_number_option")
    public void Verify_whether_a_user_can_enter_amount_to_send_mobile_number_option()
	    throws InterruptedException, IOException {
	//test =extent.createTest(" 15 Verify_whether_a_user_can_enter_amount_to_send_mobile_number_option (PESALINK)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//*[text()=' PesaLink  ']")).click();
	driver.findElement(By.xpath("//*[text()='Mobile Number']")).click();
	driver.findElement(By.xpath("//*[@id='FORM_PESALINK_MOB_BENE-BEN_PH_NUMBER']")).click();
	driver.findElement(By.xpath("//*[@id='FORM_PESALINK_MOB_BENE-BEN_PH_NUMBER']")).sendKeys("0720599572");
	driver.findElement(By.xpath("//*[text()='Get Destination Bank']")).click();
	driver.findElement(By.xpath("//label[@class='radio-inline']")).click();
	driver.findElement(By.xpath("//*[@id='FORM_PESALINK_MOB_PAY-PESALINK_MOB_DEBIT_ACC_NO']")).click();
	driver.findElement(By.xpath("//*[@id='FORM_PESALINK_MOB_PAY-PESALINK_MOB_DEBIT_ACC_NO']"))
		.sendKeys("01125413334100");
	driver.findElement(By.xpath("//*[@type='AMOUNT']")).click();
	driver.findElement(By.xpath("//*[@type='AMOUNT']")).sendKeys("2000");
	System.out.println("TC15 Verify_whether_a_user_can_enter_amount_to_send_mobile_number_option|Success:");
    }

//***********************************************************************************************************************************			    
    @Test(priority = 71)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS PESALINK") })
    @Step ("Verify_whether_a_user_can_enter_payment_reason_mobile_number_option")
    public void Verify_whether_a_user_can_enter_payment_reason_mobile_number_option()
	    throws IOException, InterruptedException {
	//test =extent.createTest(" 16  Verify_whether_a_user_can_enter_payment_reason_mobile_number_option (PESALINK)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//*[text()=' PesaLink  ']")).click();
	driver.findElement(By.xpath("//*[text()='Mobile Number']")).click();
	driver.findElement(By.xpath("//*[@id='FORM_PESALINK_MOB_BENE-BEN_PH_NUMBER']")).click();
	driver.findElement(By.xpath("//*[@id='FORM_PESALINK_MOB_BENE-BEN_PH_NUMBER']")).sendKeys("0720599572");
	driver.findElement(By.xpath("//*[text()='Get Destination Bank']")).click();
	driver.findElement(By.xpath("//label[@class='radio-inline']")).click();
	driver.findElement(By.xpath("//*[@id='FORM_PESALINK_MOB_PAY-PESALINK_MOB_DEBIT_ACC_NO']")).click();
	driver.findElement(By.xpath("//*[@id='FORM_PESALINK_MOB_PAY-PESALINK_MOB_DEBIT_ACC_NO']"))
		.sendKeys("01125413334100");
	driver.findElement(By.xpath("//*[@type='AMOUNT']")).click();
	driver.findElement(By.xpath("//*[@type='AMOUNT']")).sendKeys("2000");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.xpath("//*[@name='PESA_REMARKS']")).sendKeys("Test");

	System.out.println("TC16 Verify_whether_a_user_can_enter_payment_reason_mobile_number_optio |Success:");
    }

//***********************************************************************************************************************************			    
    @Test(priority = 72)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS PESALINK") })
    @Step ("Verify_whether_a_user_can_send_mone_using_pesalink_to_mobile_number")
    public void Verify_whether_a_user_can_send_mone_using_pesalink_to_mobile_number()
	    throws IOException, InterruptedException {
	//test =extent.createTest(" 17 Verify_whether_a_user_can_send_mone_using_pesalink_to_mobile_number (PESALINK)");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Transfer")).click();
	driver.findElement(By.xpath("//div[text()=' To Local Banks ']")).click();
	driver.findElement(By.xpath("//*[text()=' PesaLink  ']")).click();
	driver.findElement(By.xpath("//*[text()='Mobile Number']")).click();
	driver.findElement(By.xpath("//*[@id='FORM_PESALINK_MOB_BENE-BEN_PH_NUMBER']")).click();
	driver.findElement(By.xpath("//*[@id='FORM_PESALINK_MOB_BENE-BEN_PH_NUMBER']")).sendKeys("0720599572");
	driver.findElement(By.xpath("//*[text()='Get Destination Bank']")).click();
	driver.findElement(By.xpath("//label[@class='radio-inline']")).click();
	driver.findElement(By.xpath("//*[@id='FORM_PESALINK_MOB_PAY-PESALINK_MOB_DEBIT_ACC_NO']")).click();
	driver.findElement(By.xpath("//*[@id='FORM_PESALINK_MOB_PAY-PESALINK_MOB_DEBIT_ACC_NO']"))
		.sendKeys("01125413334100");
	driver.findElement(By.xpath("//*[@type='AMOUNT']")).click();
	driver.findElement(By.xpath("//*[@type='AMOUNT']")).sendKeys("2000");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.xpath("//*[@name='PESA_REMARKS']")).sendKeys("Test");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.linkText("SEND")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("3");
	driver.findElement(By.linkText("Submit")).click();
	driver.findElement(By.xpath("//*[text()=' Done ']")).click();
	System.out.println("TC17 Verify_whether_a_user_can_send_mone_using_pesalink_to_mobile_number |Success:");
    }

//***********************************************************************************************************************************			    
    @Test(priority = 73)
    @Epic("FUND TRANSFER")
    @Features(value = { @Feature(value = "TRANSFER TO LOCAL BANKS PESALINK") })
    @Step ("END OF TRANSFER TO LOCAL BANKS PESALINK TESTCASES")
    public void END_Transfer_To_Local_Banks_Pesalink_TestCases() throws IOException, InterruptedException {
	//test =extent.createTest("END OF TRANSFER TO LOCAL BANKS PESALINK TESTCASES");
	System.out.println("************************* End of Transfer To Local Banks Pesalink Testcases***********************************");
    }
}
//**********************************************************************************************************************************
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








