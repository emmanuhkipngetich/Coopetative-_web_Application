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
import org.openqa.selenium.interactions.Actions;
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
// **********************************************************************************************************************************
public class BILLS_PAYMENTS 
	{
        public WebDriver driver;
        public ExtentHtmlReporter htmlReporter;
        public ExtentReports extent;
        public ExtentTest test;
        String my_dir = System.getProperty("user.dir");
        JavascriptExecutor js;
        XSSFWorkbook Pay_TV_Startime;
        XSSFWorkbook Electricity_KPLC_Prepaid;
        XSSFWorkbook Electricity_KPLC_Postpaid;
        XSSFWorkbook Buy_Airtime_And_Data_Bundles;
        XSSFWorkbook Startimes;
        XSSFWorkbook Pay_TV_GOTV;
        XSSFWorkbook Buy_Goods_MPESA_Till;
        XSSFWorkbook DSTV;
        XSSFWorkbook Buy_Goods_Pay_Bill;
        XSSFWorkbook School_Fees;
        XSSFWorkbook Rent_Payment;
        XSSFWorkbook Loginmodule;
        XSSFWorkbook RBX_BILLS;
        XSSFSheet sheet;
    	 XSSFCell cell;  
// **********************************************************************************************************************************
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
	testng.setTestClasses(new Class[] { BILLS_PAYMENTS.class });
	testng.run();
}
//**********************************************************************************************************************************
@Test(priority = 0)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "ELECTRICITY KPLC PREPAID") })
@Step ("ELECTRICITY_KPLC_PREPAID")
@Severity(SeverityLevel.TRIVIAL)
public void Running_Electricity_KPLC_prepaid_TestCases() throws IOException, InterruptedException {
    	////test =extent.createTest(" (1) RUNNING OF BILL PAYMENT FOR KPLC PREPAID");
	System.out.println("ELECTRICITY");
	System.out.println("It contains Twelve Number of Modules");
	System.out.println("*************************(1) Running Bill Payment(KPLC prepaid)***********************************");
	
}
//**********************************************************************************************************************************
@Test(priority=1)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "Electricity KPLC prepaid") })
@Step ("Verify_whether_a_user_can_select_KPLC_Token_Prepaid_menu")
@Severity(SeverityLevel.MINOR)
public void Verify_whether_a_user_can_select_KPLC_Token_Prepaid_menu() throws InterruptedException, IOException {
    		//test =extent.createTest(" 1 Verify whether a user can select KPLC Token Prepaid menu");
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
		WebDriverWait wait1 = new WebDriverWait(driver, 15);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
		driver.findElement(By.linkText("Bill Payment")).click();
		WebDriverWait wait3 = new WebDriverWait(driver, 15);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Electricity ']")));
		driver.findElement(By.xpath("//div[text()=' Electricity ']")).click();
		driver.findElement(By.xpath("//div[text()=' KPLC Token - Pre Paid ']")).click();		
		
		
	    }
// **********************************************************************************************************************************
@Test(priority = 2)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "Electricity KPLC prepaid") })
@Step ("Verify_whether_a_user_can_enter_meter_number")
public void Verify_whether_a_user_can_enter_meter_number() throws InterruptedException 
		{
    		//test =extent.createTest(" 2 Verify whether a user can enter meter number");	
		driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
		driver.navigate().refresh();
		driver.findElement(By.linkText("Bill Payment")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 15);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Electricity ']")));
		driver.findElement(By.xpath("//div[text()=' Electricity ']")).click();
		driver.findElement(By.xpath("//div[text()=' KPLC Token - Pre Paid ']")).click();
		driver.findElement(By.xpath("//input[@id='FORM_PAY_PAYTOKEN_BILLER-METER_NO']")).sendKeys("04216519951");
		System.out.println("TC2 Verify_whether_a_user_can_enter_meter_number |Success:");
		
		}
//**********************************************************************************************************************************
@Test(priority = 3)@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "Electricity KPLC prepaid") })
@Step ("Verify_whether_a_user_can_fetch_bill_details")
@Severity(SeverityLevel.MINOR)
public void Verify_whether_a_user_can_fetch_bill_details1() throws InterruptedException {
            	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
        	driver.navigate().refresh();
        	driver.findElement(By.linkText("Bill Payment")).click();
        	WebDriverWait wait1 = new WebDriverWait(driver, 15);
        	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Electricity ']")));
        	driver.findElement(By.xpath("//div[text()=' Electricity ']")).click();
        	driver.findElement(By.xpath("//div[text()=' KPLC Token - Pre Paid ']")).click();
        	driver.findElement(By.xpath("//input[@id='FORM_PAY_PAYTOKEN_BILLER-METER_NO']")).sendKeys("04216519951");
        	driver.findElement(By.xpath("//button[@id='FORM_PAY_PAYTOKEN_BILLER-FETCH']")).click();
        	System.out.println("TC3 Verify_whether_a_user_can_fetch_bill_details |Success:");
        	}
//**********************************************************************************************************************************
@Test(priority = 4)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "Electricity KPLC prepaid") })
@Step ("Verify_whether_a_user_can_select_debit_account")
public void Verify_whether_a_user_can_select_debit_account() throws InterruptedException {
            	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
        	driver.navigate().refresh();
        	driver.findElement(By.linkText("Bill Payment")).click();
        	WebDriverWait wait1 = new WebDriverWait(driver, 15);
        	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Electricity ']")));
        	driver.findElement(By.xpath("//div[text()=' Electricity ']")).click();
        	driver.findElement(By.xpath("//div[text()=' KPLC Token - Pre Paid ']")).click();
        	driver.findElement(By.xpath("//input[@id='FORM_PAY_PAYTOKEN_BILLER-METER_NO']")).sendKeys("04216519951");
        	driver.findElement(By.xpath("//button[@id='FORM_PAY_PAYTOKEN_BILLER-FETCH']")).click();
        	Thread.sleep(5000);
        	driver.findElement(By.linkText("Next")).click();
        	driver.findElement(By.xpath("//*[@name='DEBIT_ACC_NO']")).sendKeys("01105413334100");
        	System.out.println("TC4 Verify_whether_a_user_can_select_debit_account |Success:");
	

}

//**********************************************************************************************************************************
@Test(priority = 5)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "Electricity KPLC prepaid") })
@Step ("Verify_whether_a_user_can_enter_amount_to_pay_prepaid_bill")
public void Verify_whether_a_user_can_enter_amount_to_pay_prepaid_bill() throws InterruptedException {
    	//test =extent.createTest(" 5 Verify whether a user can enter amount to pay prepaid bill");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.navigate().refresh();
	driver.findElement(By.linkText("Bill Payment")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[text()=' Electricity ']")).click();
	driver.findElement(By.xpath("//div[text()=' KPLC Token - Pre Paid ']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='FORM_PAY_PAYTOKEN_BILLER-METER_NO']")).sendKeys("04216519951");
	driver.findElement(By.xpath("//button[@id='FORM_PAY_PAYTOKEN_BILLER-FETCH']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//a[text()='Next']")).click();
	driver.findElement(By.xpath("//*[@name='DEBIT_ACC_NO']")).sendKeys("01105413334100");
	driver.findElement(By.xpath("//input[@id='FORM_PAY_PAYTOKEN_BILLER_2-PAYMENT_AMOUNT']")).sendKeys("200");
	System.out.println("TC5 Verify_whether_a_user_can_enter_amount_to_pay_prepaid_bill |Success:");
	
}
//**********************************************************************************************************************************
@Test(priority = 6)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "Electricity KPLC prepaid") })
@Step ("Verify_whether_a_user_can_enter_OTP_to_verify_Prepaid_bill")
public void Verify_whether_a_user_can_enter_OTP_to_verify_Prepaid_bill() throws InterruptedException {
	//test =extent.createTest(" 6 Verify whether a user can enter OTP to verify transaction for Prepaid_bill");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.navigate().refresh();
	driver.findElement(By.linkText("Bill Payment")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[text()=' Electricity ']")).click();
	driver.findElement(By.xpath("//div[text()=' KPLC Token - Pre Paid ']")).click();
	driver.findElement(By.xpath("//input[@id='FORM_PAY_PAYTOKEN_BILLER-METER_NO']")).sendKeys("04216519951");
	driver.findElement(By.xpath("//button[@id='FORM_PAY_PAYTOKEN_BILLER-FETCH']")).click();
	Thread.sleep(5000);
	driver.findElement(By.linkText("Next")).click();
	driver.findElement(By.xpath("//*[@name='DEBIT_ACC_NO']")).sendKeys("01105413334100");
	driver.findElement(By.xpath("//input[@id='FORM_PAY_PAYTOKEN_BILLER_2-PAYMENT_AMOUNT']")).sendKeys("200");
	driver.findElement(By.linkText("Next")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Next")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("5");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("6");
	System.out.println("TC6 Verify_whether_a_user_can_enter_OTP_to_verify_Prepaid_bill |Success:");

}
//**********************************************************************************************************************************
@Test(priority = 7)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "Electricity KPLC prepaid") })
@Step ("Verify_whether_a_user_can_pay_for_prepaid_token")
@Severity(SeverityLevel.CRITICAL)
public void Verify_whether_a_user_can_pay_for_prepaid_token() throws InterruptedException {
    	//test =extent.createTest(" 7 Verify whether a user can pay for prepaid token");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.navigate().refresh();
	driver.findElement(By.linkText("Bill Payment")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[text()=' Electricity ']")).click();
	driver.findElement(By.xpath("//div[text()=' KPLC Token - Pre Paid ']")).click();
	driver.findElement(By.xpath("//input[@id='FORM_PAY_PAYTOKEN_BILLER-METER_NO']")).sendKeys("04216519951");
	driver.findElement(By.xpath("//button[@id='FORM_PAY_PAYTOKEN_BILLER-FETCH']")).click();
	Thread.sleep(5000);
	driver.findElement(By.linkText("Next")).click();
	driver.findElement(By.xpath("//*[@name='DEBIT_ACC_NO']")).sendKeys("01105413334100");
	driver.findElement(By.xpath("//input[@id='FORM_PAY_PAYTOKEN_BILLER_2-PAYMENT_AMOUNT']")).sendKeys("200");
	driver.findElement(By.linkText("Next")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@class=' ct-btnCont NEXT_innerCont']")).click();
	WebDriverWait wait = new WebDriverWait(driver, 25);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("OTP_FORM-OTP_INPUT_1")));
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("5");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("6");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[text()='Submit']")).click();
	WebDriverWait wait4 = new WebDriverWait(driver, 25);
	wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' Ok ']")));
	driver.findElement(By.xpath("//*[text()=' Ok ']")).click();
	System.out.println("TC7 Verify_whether_a_user_can_pay_for_prepaid_token |Success:");
	
}
//**********************************************************************************************************************************
@Test(priority = 8)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "Electricity KPLC prepaid") })
@Step ("VALIDATE_whether_a_user_can_pay_for_prepaid_token")
@Severity(SeverityLevel.BLOCKER)
public void VALIDATE_whether_a_user_can_pay_for_prepaid_token() throws InterruptedException {
    	//test =extent.createTest(" 8 VALIDATE whether a transaction to pay for prepaid token is successfull");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.navigate().refresh();
	driver.findElement(By.linkText("Bill Payment")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[text()=' Electricity ']")).click();
	driver.findElement(By.xpath("//div[text()=' KPLC Token - Pre Paid ']")).click();
	driver.findElement(By.xpath("//input[@id='FORM_PAY_PAYTOKEN_BILLER-METER_NO']")).sendKeys("04216519951");
	driver.findElement(By.xpath("//button[@id='FORM_PAY_PAYTOKEN_BILLER-FETCH']")).click();
	Thread.sleep(5000);
	driver.findElement(By.linkText("Next")).click();
	driver.findElement(By.xpath("//*[@name='DEBIT_ACC_NO']")).sendKeys("01105413334100");
	driver.findElement(By.xpath("//input[@id='FORM_PAY_PAYTOKEN_BILLER_2-PAYMENT_AMOUNT']")).sendKeys("200");
	driver.findElement(By.linkText("Next")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@class=' ct-btnCont NEXT_innerCont']")).click();
	WebDriverWait wait = new WebDriverWait(driver, 25);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("OTP_FORM-OTP_INPUT_1")));
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("5");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("6");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[text()='Submit']")).click();
	Thread.sleep(2000);
	if (driver.getPageSource().contains("Unable to process")) {
	    System.out.println("Unable to process");
	    org.testng.Assert.fail("Unable to process");

	} else {
	}
	WebDriverWait wait4 = new WebDriverWait(driver, 25);
	wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' Ok ']")));
	driver.findElement(By.xpath("//*[text()=' Ok ']")).click();
	System.out.println("TC8 VALIDATE_whether_a_user_can_pay_for_prepaid_token |Success:");
	
}
//**********************************************************************************************************************************
@Test(priority = 9)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "ELECTRICITY KPLC PREPAID") })
@Step ("END OF BILL PAYMENT FOR KPLC PREPAID")
@Severity(SeverityLevel.TRIVIAL)
public void End_Of_Electricity_KPLC_prepaid_TestCases() throws IOException, InterruptedException {
    	//test =extent.createTest("END OF BILL PAYMENT FOR KPLC PREPAID");
	System.out.println("*************************End of Bill Payment(KPLC prepaid)***********************************");
	
}
//**********************************************************************************************************************************
@Test(priority = 10)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "Electricity KPLC POSTPAID") })
@Step ("ELECTRICITY KPLC POSTPAID")
@Severity(SeverityLevel.TRIVIAL)
public void Running_Electricity_KPLC_postpaid_TestCases() throws IOException, InterruptedException {
    	//test =extent.createTest("(2) RUNNING BILL PAYMENT FOR KPLC POSTPAID TESTCASES");
	System.out.println("*************************(2) Running Bill Payment(KPLC postpaid)***********************************");	
}
//**********************************************************************************************************************************
@Test(priority = 11)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "Electricity KPLC POSTPAID") })
@Step ("Verify_whether_a_user_can_select_KPLC_post_paidmenu")
@Severity(SeverityLevel.MINOR)
public void Verify_whether_a_user_can_select_KPLC_post_paidmenu() throws InterruptedException, IOException {
    	//test =extent.createTest(" 1 Verify whether a user can select KPLC post paid menu");
	driver.get("http://172.16.19.161:50002/iportalweb/iRetail@1");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);
	Electricity_KPLC_Postpaid = new XSSFWorkbook(fis);
	sheet = Electricity_KPLC_Postpaid.getSheetAt(1);
	for (int i = 1; i <= sheet.getLastRowNum(); i++)	  
	cell = sheet.getRow(1).getCell(0);
	Thread.sleep(5000);
	driver.findElement(By.id("mat-input-0")).click();
	driver.findElement(By.id("mat-input-0")).sendKeys(cell.getStringCellValue());	
	cell = sheet.getRow(1).getCell(1);
	driver.findElement(By.id("mat-input-1")).click();
	driver.findElement(By.id("mat-input-1")).sendKeys(cell.getStringCellValue());
	driver.findElement(By.id("mat-input-1")).sendKeys(Keys.ENTER);
	Thread.sleep(4000);
	driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).sendKeys("3");
	driver.findElement(By.cssSelector(".otp-input:nth-child(2)")).sendKeys("3");
	driver.findElement(By.cssSelector(".otp-input:nth-child(3)")).sendKeys("2");
	driver.findElement(By.cssSelector(".otp-input:nth-child(4)")).sendKeys("2");
	driver.findElement(By.cssSelector(".otp-input:nth-child(5)")).sendKeys("1");
	driver.findElement(By.cssSelector(".ng-untouched")).sendKeys("1");
	driver.findElement(By.cssSelector(".ng-untouched")).sendKeys(Keys.ENTER);
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Electricity ']")));
	driver.findElement(By.xpath("//div[text()=' Electricity ']")).click();
	driver.findElement(By.xpath("//div[text()=' KPLC Post Paid ']")).click();
	System.out.println("TC1 Verify_whether_a_user_can_select_KPLC_post_paid menu |Success:");
	
}
//**********************************************************************************************************************************
@Test(priority = 12)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "Electricity KPLC POSTPAID") })
@Step ("Verify_whether_a_user_can_enter_meter_number_for_postpaid_kplc")
@Severity(SeverityLevel.MINOR)
public void Verify_whether_a_user_can_enter_meter_number_for_postpaid_kplc() throws InterruptedException {
    	//test =extent.createTest(" 2 Verify whether a user can enter meter number for postpaid kplc");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.navigate().refresh();
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Electricity ']")));
	driver.findElement(By.xpath("//div[text()=' Electricity ']")).click();
	driver.findElement(By.xpath("//div[text()=' KPLC Post Paid ']")).click();
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER-METER_NO")).sendKeys("15067697");
	System.out.println("TC2 Verify_whether_a_user_can_enter_meter_number_for_postpaid_kplc |Success:");
	
}
//**********************************************************************************************************************************
@Test(priority = 13)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "Electricity KPLC POSTPAID") })
@Step ("Verify_whether_a_user_can_fetch_bill_details_for_postpaid_kplc")
@Severity(SeverityLevel.MINOR)
public void Verify_whether_a_user_can_fetch_bill_details_for_postpaid_kplc() throws InterruptedException {
    	//test =extent.createTest(" 3 Verify whether a user can fetch bill details for postpaid kplc");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Electricity ']")));
	driver.findElement(By.xpath("//div[text()=' Electricity ']")).click();
	driver.findElement(By.xpath("//div[text()=' KPLC Post Paid ']")).click();
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER-METER_NO")).sendKeys("15067697");
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER-FETCH")).click();
	Thread.sleep(3000);
	driver.findElement(By.cssSelector(".checkbox-inline")).click();
	System.out.println("TC3 Verify_whether_a_user_can_fetch_bill_details_for_postpaid_kplc|Success:");
	
}
//**********************************************************************************************************************************
@Test(priority = 14)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "Electricity KPLC POSTPAID") })
@Step ("verify_whether_a_user_can_save_a_bill_for_postpaidkplc")
public void verify_whether_a_user_can_save_a_bill_for_postpaidkplc() throws InterruptedException {
    	//test =extent.createTest(" 4 verify whether a user can save a bill for postpaid customer");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Electricity ']")));
	driver.findElement(By.xpath("//div[text()=' Electricity ']")).click();
	driver.findElement(By.xpath("//div[text()=' KPLC Post Paid ']")).click();
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER-METER_NO")).sendKeys("15067697");
	driver.findElement(By.xpath("//button[@id='FORM_PAY_KPLC_BILLER-FETCH']")).click();	
	System.out.println("TC4 verify_whether_a_user_can_save_a_bill_for_postpaidkplc |Success:");
	

}
//**********************************************************************************************************************************
@Test(priority = 15)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "Electricity KPLC POSTPAID") })
@Step ("Verify_whether_a_user_can_select_debit_account_for_postpaid_kplc")
public void Verify_whether_a_user_can_select_debit_account_for_postpaid_kplc() throws InterruptedException {
    	//test =extent.createTest(" 5 Verify whether a user can select debit account for postpaid kplc");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Electricity ']")));
	driver.findElement(By.xpath("//div[text()=' Electricity ']")).click();
	driver.findElement(By.xpath("//div[text()=' KPLC Post Paid ']")).click();
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER-METER_NO")).sendKeys("15067697");
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER-FETCH")).click();
	Thread.sleep(1000);
	driver.findElement(By.cssSelector(".checkbox-inline")).click();
	driver.findElement(By.linkText("Next")).click();
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER_2-DEBIT_ACC_NO")).sendKeys("0112541334100");
	System.out.println("TC5 Verify_whether_a_user_can_select_debit_account_for_postpaid_kplc |Success:");
	

}
//**********************************************************************************************************************************
@Test(priority = 16)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "Electricity KPLC POSTPAID") })
@Step ("Verify_whether_a_user_can_enter_amount_to_pay_postpaid_kplc")
public void Verify_whether_a_user_can_enter_amount_to_pay_postpaid_kplc() throws InterruptedException {
    	//test =extent.createTest(" 6 Verify whether a user can enter amount to pay for kplc postpaid");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Electricity ']")));
	driver.findElement(By.xpath("//div[text()=' Electricity ']")).click();
	driver.findElement(By.xpath("//div[text()=' KPLC Post Paid ']")).click();
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER-METER_NO")).sendKeys("15067697");
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER-FETCH")).click();
	Thread.sleep(1000);
	driver.findElement(By.cssSelector(".checkbox-inline")).click();//
	driver.findElement(By.linkText("Next")).click();
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER_2-DEBIT_ACC_NO")).sendKeys("0112541334100");//	
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER_2-DEBIT_ACC_NO")).click();
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER_2-PAYMENT_AMOUNT")).clear();
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER_2-PAYMENT_AMOUNT")).sendKeys("200");
	System.out.println("TC6 Verify_whether_a_user_can_enter_amount_to_pay_postpaid_kplc |Success:");
	
}
//**********************************************************************************************************************************
@Test(priority = 17)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "Electricity KPLC POSTPAID") })
@Step ("Verify_whether_a_user_can_enter_OTP_to_verify_postpaid_payments_kplc")
public void Verify_whether_a_user_can_enter_OTP_to_verify_postpaid_payments_kplc() throws InterruptedException {
    	//test =extent.createTest(" 7 Verify whether a user can enter OTP to verify transaction for kplc postpaid payments");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Electricity ']")));
	driver.findElement(By.xpath("//div[text()=' Electricity ']")).click();
	driver.findElement(By.xpath("//div[text()=' KPLC Post Paid ']")).click();
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER-METER_NO")).sendKeys("15067697");
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER-FETCH")).click();
	Thread.sleep(1000);
	driver.findElement(By.cssSelector(".checkbox-inline")).click();
	driver.findElement(By.linkText("Next")).click();
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER_2-DEBIT_ACC_NO")).sendKeys("0112541334100");
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER_2-DEBIT_ACC_NO")).click();
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER_2-PAYMENT_AMOUNT")).clear();
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER_2-PAYMENT_AMOUNT")).sendKeys("200");
	driver.findElement(By.linkText("Next")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Next")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("1");
	System.out.println("TC7 Verify_whether_a_user_can_enter_OTP_to_verify_postpaid_payments_kplc |Success:");
	
}
//**********************************************************************************************************************************
@Test(priority = 18)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "Electricity KPLC POSTPAID") })
@Step ("Verify_whether_a_user_can_pay_for_postpaidbill")
@Severity(SeverityLevel.CRITICAL)
public void Verify_whether_a_user_can_pay_for_postpaidbill() throws InterruptedException {
    	//test =extent.createTest(" 8 Verify whether a user can pay for kplc postpaid account after entering OTP");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Electricity ']")));
	driver.findElement(By.xpath("//div[text()=' Electricity ']")).click();
	driver.findElement(By.xpath("//div[text()=' KPLC Post Paid ']")).click();
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER-METER_NO")).sendKeys("15067697");
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER-FETCH")).click();
	Thread.sleep(1000);
	driver.findElement(By.cssSelector(".checkbox-inline")).click();	
	driver.findElement(By.linkText("Next")).click();
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER_2-DEBIT_ACC_NO")).sendKeys("0112541334100");	
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER_2-DEBIT_ACC_NO")).click();
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER_2-PAYMENT_AMOUNT")).clear();
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER_2-PAYMENT_AMOUNT")).sendKeys("200");
	driver.findElement(By.linkText("Next")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Next")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("1");
	driver.findElement(By.linkText("Submit")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//a[text()=' Ok ']")).click();
	System.out.println("TC8 Verify_whether_a_user_can_pay_for_postpaidbill |Success:");
	
}
//**********************************************************************************************************************************
@Test(priority = 19)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "Electricity KPLC POSTPAID") })
@Step ("VALIDATE_whether_a_user_can_pay_for_postpaidbill")
@Severity(SeverityLevel.BLOCKER)
public void VALIDATE_whether_a_user_can_pay_for_postpaidbill() throws InterruptedException {
    	//test =extent.createTest(" 9 VALIDATE_whether the transaction to pay for kplc postpaid is sucessful");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Electricity ']")));
	driver.findElement(By.xpath("//div[text()=' Electricity ']")).click();
	driver.findElement(By.xpath("//div[text()=' KPLC Post Paid ']")).click();
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER-METER_NO")).sendKeys("15067697");
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER-FETCH")).click();
	Thread.sleep(1000);
	driver.findElement(By.cssSelector(".checkbox-inline")).click();
	driver.findElement(By.linkText("Next")).click();
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER_2-DEBIT_ACC_NO")).sendKeys("0112541334100");
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER_2-DEBIT_ACC_NO")).click();
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER_2-PAYMENT_AMOUNT")).clear();
	driver.findElement(By.id("FORM_PAY_KPLC_BILLER_2-PAYMENT_AMOUNT")).sendKeys("200");
	driver.findElement(By.linkText("Next")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Next")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("1");
	driver.findElement(By.linkText("Submit")).click();
	Thread.sleep(4000);
	if (driver.getPageSource().contains("Unable to process")) 
	{
	System.out.println("Unable to process");
	org.testng.Assert.fail("Unable to process");
	} 
	else
	{ 
	driver.findElement(By.xpath("//a[text()=' Ok ']")).click();
	System.out.println("TC9 VALIDATE_whether_a_user_can_pay_for_postpaidbill |Success:");
	
	}
}
//**********************************************************************************************************************************


@Test(priority = 20)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "Electricity KPLC POSTPAID") })
@Step ("END OF BILL PAYMENT FOR KPLC postpaid")
@Severity(SeverityLevel.TRIVIAL)
public void End_Of_Electricity_KPLC_postpaid_TestCases() throws IOException, InterruptedException {
    	//test =extent.createTest("END OF BILL PAYMENT FOR KPLC postpaid");
	System.out.println("*************************End of Bill Payment(KPLC postpaid)***********************************");
	
	}
// **********************************************************************************************************************************
@Test(priority = 21)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "DSTV PAYMENT") })
@Step ("DSTV PAYMENT")
@Severity(SeverityLevel.TRIVIAL)
public void Running_Bill_payment_DSTV_TestCases() throws IOException, InterruptedException {
    	//test =extent.createTest("(1) RUNNING BILLS PAYMENT FOR DSTV TESTCASES");
	System.out.println("PAYTV");
	System.out.println("*************************(1) Running Bill payment DSTV***********************************");
	
}
// ***********************************************************************************************************************************
@Test(priority = 22)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "DSTV PAYMENT") })
@Step ("Verify_whether_a_user_can_select_DSTV_menu")
@Severity(SeverityLevel.MINOR)
public void Verify_whether_a_user_can_select_DSTV_menu() throws InterruptedException, IOException {
    	//test =extent.createTest(" 1 Verify whether a user can acess DSTV menu after selecting pay tv menu");
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
	WebDriverWait wait3 = new WebDriverWait(driver, 15);
	wait3.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' PAYTV ']")));
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' DSTV ']")).click();
	System.out.println("TC1 Verify_whether_a_user_can_select_DSTV_menu |Success:");
	
}
// ***********************************************************************************************************************************
@Test(priority = 23)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "DSTV PAYMENT") })
@Step ("Verify_whether_a_user_can_enter_smart_card_number")
@Severity(SeverityLevel.MINOR)
public void Verify_whether_a_user_can_enter_smart_card_number1() throws InterruptedException {
    	//test =extent.createTest(" 2 Verify whether a user can enter smart card number for dstv payments");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' PAYTV ']")));
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' DSTV ']")).click();
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER-METER_NO")).sendKeys("4122276313");
	System.out.println("TC2 Verify_whether_a_user_can_enter_smart_card_number |Success:");
	
}
// ***********************************************************************************************************************************
@Test(priority = 24)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "DSTV PAYMENT") })
@Step ("Verify_whether_a_user_can_fetch_bill_details")
public void Verify_whether_a_user_can_fetch_bill_details() throws InterruptedException {
    	//test =extent.createTest(" 3 Verify whether a user can fetch bill details after entering a dstv number");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' PAYTV ']")));
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' DSTV ']")).click();
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER-METER_NO")).sendKeys("4122276313");
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER-FETCH")).click();
	System.out.println("TC3 Verify_whether_a_user_can_fetch_bill_details |Success:");
	
}
// ***********************************************************************************************************************************
@Test(priority = 25)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "DSTV PAYMENT") })
@Step ("verify_whether_a_user_can_save_a_bill")
public void verify_whether_a_user_can_save_a_bill() throws InterruptedException, IOException {
    	//test =extent.createTest(" 4 verify whether a user can save a bill for dstv payments");
	driver.get("http://172.16.19.161:50002/iportalweb/iRetail@1");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);
	DSTV = new XSSFWorkbook(fis);
	sheet = DSTV.getSheet("Loginmodule");
	for (int i = 1; i <= sheet.getLastRowNum(); i++)
	cell = sheet.getRow(1).getCell(0);
	driver.findElement(By.id("mat-input-0")).click();
	driver.findElement(By.id("mat-input-0")).sendKeys(cell.getStringCellValue());
	cell = sheet.getRow(1).getCell(1);
	driver.findElement(By.id("mat-input-1")).click();
	driver.findElement(By.id("mat-input-1")).sendKeys(cell.getStringCellValue());
	driver.findElement(By.id("mat-input-1")).sendKeys(Keys.ENTER);
	driver.findElement(By.cssSelector(".otp-input:nth-child(1)")).sendKeys("3");
	driver.findElement(By.cssSelector(".otp-input:nth-child(2)")).sendKeys("3");
	driver.findElement(By.cssSelector(".otp-input:nth-child(3)")).sendKeys("3");
	driver.findElement(By.cssSelector(".otp-input:nth-child(4)")).sendKeys("2");
	driver.findElement(By.cssSelector(".otp-input:nth-child(5)")).sendKeys("2");
	driver.findElement(By.cssSelector(".ng-untouched")).sendKeys("2");
	driver.findElement(By.cssSelector(".ng-untouched")).sendKeys(Keys.ENTER);
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' PAYTV ']")));
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' DSTV ']")).click();
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER-METER_NO")).sendKeys("10172650771");
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER-FETCH")).click();
	Thread.sleep(3000);
	driver.findElement(By.cssSelector(".checkbox-inline")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER-BILL_BENE_NICK")).click();
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER-BILL_BENE_NICK")).sendKeys("nick");
	System.out.println("TC4 verify_whether_a_user_can_save_a_bill |Success:");
	
}
// ***********************************************************************************************************************************
@Test(priority = 26)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "DSTV PAYMENT") })
@Step ("Verify_whether_a_user_can_select_Debit_Account")
public void Verify_whether_a_user_can_select_Debit_Account() throws InterruptedException {
    	//test =extent.createTest(" 5 Verify whether a user can select Debit Account when paying for dstv account");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' PAYTV ']")));
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' DSTV ']")).click();
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER-METER_NO")).sendKeys("4122276313");
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER-FETCH")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Next")).click();
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER_2-DEBIT_ACC_NO")).sendKeys("01105413334100");
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER_2-DEBIT_ACC_NO")).click();
	System.out.println("TC5 Verify_whether_a_user_can_select_Debit_Account |Success:");
	
}
// ***********************************************************************************************************************************
@Test(priority = 27)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "DSTV PAYMENT") })
@Step ("Verify_whether_a_user_can_enter_Amount_to_pay_for_DSTV")
public void Verify_whether_a_user_can_enter_Amount_to_pay_for_DSTV() throws InterruptedException {
    	//test =extent.createTest(" 6 Verify whether a user can enter Amount to pay for DSTV payment");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' PAYTV ']")));
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' DSTV ']")).click();
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER-METER_NO")).sendKeys("4122276313");
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER-FETCH")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Next")).click();
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER_2-DEBIT_ACC_NO")).sendKeys("01105413334100");
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER_2-DEBIT_ACC_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER_2-PAYMENT_AMOUNT")).sendKeys("100");
	System.out.println("TC6 Verify_whether_a_user_can_enter_Amount_to_pay_for_DSTV|Success:");
	
}
// ***********************************************************************************************************************************
@Test(priority = 28)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "DSTV PAYMENT") })
@Step ("Validate_whether_a_user_can_pay_for_DSTV")
public void Verify_whether_a_user_can_enter_OTP_to_verify_Transaction_for_DST_payment()throws InterruptedException
	{
    	//test =extent.createTest(" 7 Verify whether a user can enter OTP to verify Transaction is sucessful for DST payment");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' PAYTV ']")));
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' DSTV ']")).click();
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER-METER_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER-METER_NO")).sendKeys("10172650771");
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER-FETCH")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Next")).click();
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER_2-DEBIT_ACC_NO")).sendKeys("01105413334100");
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER_2-DEBIT_ACC_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER_2-PAYMENT_AMOUNT")).click();
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER_2-PAYMENT_AMOUNT")).sendKeys("0");
	driver.findElement(By.linkText("Next")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Next")).click();
	WebDriverWait wait11 = new WebDriverWait(driver, 15);
	wait11.until(ExpectedConditions.visibilityOfElementLocated(By.id("OTP_FORM-OTP_INPUT_1")));
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("1");
	System.out.println("TC7 Verify_whether_a_user_can_enter_OTP_to_verify_Transaction_for_DST_payment |Success:");
	
}
// ***********************************************************************************************************************************
@Test(priority = 29)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "DSTV PAYMENT") })
@Step ("Validate_whether_a_user_can_pay_for_DSTV")
@Severity(SeverityLevel.CRITICAL)
public void Verify_whether_a_user_can_pay_for_DSTV() throws InterruptedException {
    	//test =extent.createTest(" 8 Verify whether a user can pay for DSTV after entering OTP");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' PAYTV ']")));
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' DSTV ']")).click();
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER-METER_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER-METER_NO")).sendKeys("10172650771");
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER-FETCH")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Next")).click();
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER_2-DEBIT_ACC_NO")).sendKeys("01105413334100");
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER_2-DEBIT_ACC_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER_2-PAYMENT_AMOUNT")).click();
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER_2-PAYMENT_AMOUNT")).sendKeys("0");
	driver.findElement(By.linkText("Next")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Next")).click();
	WebDriverWait wait11 = new WebDriverWait(driver, 15);
	wait11.until(ExpectedConditions.visibilityOfElementLocated(By.id("OTP_FORM-OTP_INPUT_1")));
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("1");
	driver.findElement(By.linkText("Submit")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[text()=' Ok ']")).click();
	System.out.println("TC8 Verify_whether_a_user_can_pay_for_DSTV |Success:");
	
}
// ***********************************************************************************************************************************
@Test(priority = 30)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "DSTV PAYMENT") })
@Step ("Validate_whether_a_user_can_pay_for_DSTV")
@Severity(SeverityLevel.BLOCKER)
public void Validate_whether_a_user_can_pay_for_DSTV() throws InterruptedException {
    	//test =extent.createTest(" 9 Validate whether a transaction to pay for dstv is sucessful");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' PAYTV ']")));
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' DSTV ']")).click();
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER-METER_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER-METER_NO")).sendKeys("10172650771");
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER-FETCH")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Next")).click();
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER_2-DEBIT_ACC_NO")).sendKeys("01105413334100");
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER_2-DEBIT_ACC_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER_2-PAYMENT_AMOUNT")).click();
	driver.findElement(By.id("FORM_PAY_PAYDSTV_BILLER_2-PAYMENT_AMOUNT")).sendKeys("0");
	driver.findElement(By.linkText("Next")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Next")).click();
	WebDriverWait wait11 = new WebDriverWait(driver, 15);
	wait11.until(ExpectedConditions.visibilityOfElementLocated(By.id("OTP_FORM-OTP_INPUT_1")));
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("1");
	driver.findElement(By.linkText("Submit")).click();
	Thread.sleep(3000);
	if (driver.getPageSource().contains("Sorry. We are unable to process your request at the moment")) 
	{
	System.out.println("Sorry. We are unable to process your request at the moment");
	org.testng.Assert.fail("Sorry. We are unable to process your request at the moment");
	} 
	else 
	{
	}
	WebDriverWait wait2 = new WebDriverWait(driver, 15);
	wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=' Ok ']")));
	driver.findElement(By.xpath("//a[text()=' Ok ']")).click();
	System.out.println("TC8 Verify_whether_a_user_can_pay_for_DSTV |Success:");
	
	}
// ***********************************************************************************************************************************
@Test(priority = 31)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "DSTV PAYMENT") })
@Step ("END OF BILL PAYMENT FOR DSTV")
@Severity(SeverityLevel.TRIVIAL)
public void End_of_Bill_payment_DSTV() throws IOException, InterruptedException {
    	//test =extent.createTest("END OF BILL PAYMENT FOR DSTV");
	System.out.println("*************************End of Bill payment DSTV***********************************");
	
}

// **************************************************************************************************************************************
@Test(priority = 32)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "GOTV PAYMENT") })
@Step ("GOTV PAYMENT")
@Severity(SeverityLevel.TRIVIAL)
public void Running_Bill_payment_GOTV_TestCases() throws IOException, InterruptedException {
    	//test =extent.createTest("(2) RUNNING BILL PAYMENT FOR DSTV");
	System.out.println("*************************(2) Running Bill payment GOTV***********************************");
	
}

// **********************************************************************************************************************************
@Test(priority = 33)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "GOTV PAYMENT") })
@Step ("Verify_whether_a_user_can_select_GOTV_menu")
@Severity(SeverityLevel.MINOR)
public void Verify_whether_a_user_can_select_GOTV_menu() throws InterruptedException, IOException {
    	//test =extent.createTest(" 1 Verify whether a user can select on GOTV menu");
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
	WebDriverWait wait3 = new WebDriverWait(driver, 15);
	wait3.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' GOTV ']")).click();
	System.out.println("TC1 Verify_whether_a_user_can_select_GOTV_menu |Success:");
	
}

// **********************************************************************************************************************************
@Test(priority = 34)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "GOTV PAYMENT") })
@Step ("Verify_whether_a_user_can_enter_smart_card_number_for_GOTV")
@Severity(SeverityLevel.MINOR)
public void Verify_whether_a_user_can_enter_smart_card_number_for_GOTV() throws InterruptedException {
    	//test =extent.createTest(" 2 Verify whether a user can enter smart card number for_GOTV");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' PAYTV ']")));
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' GOTV ']")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-METER_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-METER_NO")).sendKeys("2003629311");
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-FETCH")).click();
	System.out.println("TC2 Verify_whether_a_user_can_enter_smart_card_number_for_GOTV |Success:");
	
}

// **********************************************************************************************************************************
@Test(priority = 35)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "GOTV PAYMENT") })
@Step ("Verify_whether_a_user_can_fetch_bill_details_for_GOTV")
public void Verify_whether_a_user_can_fetch_bill_details_for_GOTV() throws InterruptedException {
    	//test =extent.createTest(" 3 Verify_whether_a_user_can_fetch_bill_details for GOTV");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' PAYTV ']")));
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' GOTV ']")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-METER_NO")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-METER_NO")).sendKeys("2003629311");
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-FETCH")).click();
	System.out.println("TC3 Verify_whether_a_user_can_fetch_bill_details_for_GOTV |Success:");
	
}

// **********************************************************************************************************************************
@Test(priority = 36)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "GOTV PAYMENT") })
@Step ("verify_whether_a_user_can_save_a_bill_for_GOTV")
public void verify_whether_a_user_can_save_a_bill_for_GOTV() throws InterruptedException {
    	//test =extent.createTest(" 4 verify whether a user can save a bill for GOTV");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' PAYTV ']")));
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' GOTV ']")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-METER_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-METER_NO")).sendKeys("2003629311");
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-FETCH")).click();
	driver.findElement(By.cssSelector(".checkbox-inline")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-BILL_BENE_NICK")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-BILL_BENE_NICK")).sendKeys("benna");
	driver.findElement(By.cssSelector(".row:nth-child(9) > .col-lg-6")).click();
	System.out.println("TC4 verify_whether_a_user_can_save_a_bill_for_GOTV |Success:");
	
}

// **********************************************************************************************************************************
@Test(priority = 37)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "GOTV PAYMENT") })
@Step ("Verify_whether_a_user_can_select_debit_account__for_GOTV")
public void Verify_whether_a_user_can_select_debit_account__for_GOTV() throws InterruptedException {
    	//test =extent.createTest(" 5 Verify whether a user can select debit account when paying for GOTV account");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' PAYTV ']")));
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' GOTV ']")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-METER_NO")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-METER_NO")).sendKeys("2003629311");
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-FETCH")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Next")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER_2-DEBIT_ACC_NO")).sendKeys("01105413334100");
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER_2-DEBIT_ACC_NO")).click();
	System.out.println("TC5 Verify_whether_a_user_can_select_debit_account__for_GOTV |Success:");
	
}

// **********************************************************************************************************************************
@Test(priority = 38)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "GOTV PAYMENT") })
@Step ("Verify_whether_a_user_can_enter_amount_to_pay__for_GOTV")
public void Verify_whether_a_user_can_enter_amount_to_pay__for_GOTV() throws InterruptedException {
    	//test =extent.createTest(" 6 Verify whether a user can enter amount to pay whe paying for GOTV");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' PAYTV ']")));
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' GOTV ']")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-METER_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-METER_NO")).sendKeys("2003629311");
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-FETCH")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Next")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER_2-DEBIT_ACC_NO")).sendKeys("01105413334100");
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER_2-DEBIT_ACC_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER_2-PAYMENT_AMOUNT")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER_2-PAYMENT_AMOUNT")).sendKeys("300");
	driver.findElement(By.cssSelector(".row:nth-child(5) > .col-lg-6:nth-child(2)")).click();
	System.out.println("TC6 Verify_whether_a_user_can_enter_amount_to_pay__for_GOTV |Success:");
	
}

// **********************************************************************************************************************************
@Test(priority = 39)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "GOTV PAYMENT") })
@Step (" Verify_whether_a_user_can_enter_OTP_to_verify_GOTV_payments")
public void Verify_whether_a_user_can_enter_OTP_to_verify_GOTV_payments() throws InterruptedException {
	//test =extent.createTest(" 7 Verify whether a user can enter OTP to verify GOTV payments");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' PAYTV ']")));
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' GOTV ']")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-METER_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-METER_NO")).sendKeys("2003629311");
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-FETCH")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Next")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER_2-DEBIT_ACC_NO")).sendKeys("01105413334100");
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER_2-DEBIT_ACC_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER_2-PAYMENT_AMOUNT")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER_2-PAYMENT_AMOUNT")).sendKeys("");
	driver.findElement(By.cssSelector(".row:nth-child(5)")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Next")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Next")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("2");
	System.out.println("TC7 Verify_whether_a_user_can_enter_OTP_to_verify_GOTV_payments|Success:");

}

// **********************************************************************************************************************************
@Test(priority = 40)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "GOTV PAYMENT") })
@Step ("Verify_whether_a_user_can_pay_for_GOTV")
@Severity(SeverityLevel.CRITICAL)
public void Verify_whether_a_user_can_pay_for_GOTV() throws InterruptedException {
	//test =extent.createTest(" 8 Verify whether a user can pay for GOTV after entering OTP ");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' PAYTV ']")));
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' GOTV ']")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-METER_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-METER_NO")).sendKeys("2003629311");
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-FETCH")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Next")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER_2-DEBIT_ACC_NO")).sendKeys("01105413334100");
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER_2-DEBIT_ACC_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER_2-PAYMENT_AMOUNT")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER_2-PAYMENT_AMOUNT")).sendKeys("");
	driver.findElement(By.cssSelector(".row:nth-child(5)")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Next")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Next")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("2");
	Thread.sleep(3000);
	driver.findElement(By.linkText("Submit")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[text()=' Ok ']")).click();
	System.out.println("TC8 Verify_whether_a_user_can_pay_for_GOTVu |Success:");

}

// **********************************************************************************************************************************
@Test(priority = 41)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "GOTV PAYMENT") })
@Step ("Verify_whether_a_user_can_pay_for_GOTV")
@Severity(SeverityLevel.BLOCKER)
public void VALIDATE_whether_a_user_can_pay_for_GOTV() throws InterruptedException {
	//test =extent.createTest(" 9 VALIDATE whether a Transaction is sucessful whe paying for GOTV");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' PAYTV ']")));
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' GOTV ']")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-METER_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-METER_NO")).sendKeys("2003629311");
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER-FETCH")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Next")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER_2-DEBIT_ACC_NO")).sendKeys("01105413334100");
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER_2-DEBIT_ACC_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER_2-PAYMENT_AMOUNT")).click();
	driver.findElement(By.id("FORM_PAY_PAYGOTV_BILLER_2-PAYMENT_AMOUNT")).sendKeys("");
	driver.findElement(By.cssSelector(".row:nth-child(5)")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Next")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Next")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("2");
	Thread.sleep(3000);
	driver.findElement(By.linkText("Submit")).click();
	Thread.sleep(3000);
	if (driver.getPageSource().contains("Sorry. We are unable to process your request at the moment.")) {
	    System.out.println("Sorry. We are unable to process your request at the moment.");
	    org.testng.Assert.fail("Sorry. We are unable to process your request at the moment.");
	} else {
	    // System.out.println("Transaction Sucessful");
	}
	driver.findElement(By.xpath("//a[text()=' Ok ']")).click();
	System.out.println("TC9 VALIDATE_whether_a_user_can_pay_for_GOTV|Success:");


}

// ***********************************************************************************************************************************
@Test(priority = 42)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "GOTV PAYMENT") })
@Step ("END OF BILL PAYMENT FOR GOTV")
@Severity(SeverityLevel.TRIVIAL)
public void End_of_Bill_payment_GOTV() throws IOException, InterruptedException {
	//test =extent.createTest("END OF BILL PAYMENT FOR GOTV");
	System.out.println("*************************End of Bill payment GOTV***********************************");

}
// **********************************************************************************************************************************
@Test(priority = 43)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "STARTIMES PAYMENT") })
@Step ("STARTIMES PAYMENT")
@Severity(SeverityLevel.TRIVIAL)
public void Pay_Startime_Testcases() {
	//test =extent.createTest("(3) RUNNING PAY FOR STARTIMES TESTCASES");
	System.out.println("*************************(3) Running Pay Startime Testcases***********************************");

}
// **********************************************************************************************************************************
@Test(priority = 44)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "STARTIMES PAYMENT") })
@Step ("Verify_whether_a_user_can_select_STARTIMES_menu")
@Severity(SeverityLevel.MINOR)
public void Verify_whether_a_user_can_select_STARTIMES_menu() throws InterruptedException, IOException {
	//test =extent.createTest(" 1 Verify whether a user can select STARTIMES menu");
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
	WebDriverWait wait4 = new WebDriverWait(driver, 15);
	wait4.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' PAYTV ']")));
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' STARTIMES ']")).click();
	System.out.println("TC1 Verify_whether_a_user_can_select_STARTIMES_menu |Success:");


}
// **********************************************************************************************************************************
@Test(priority = 45)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "STARTIMES PAYMENT") })
@Step ("Verify_whether_a_user_can_enter_smart_card_number")
@Severity(SeverityLevel.MINOR)
public void Verify_whether_a_user_can_enter_smart_card_number() throws InterruptedException, IOException {
	//test =extent.createTest(" 2 Verify whether a user can enter smart card number for startimes");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' PAYTV ']")));
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' STARTIMES ']")).click();
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);
	Startimes = new XSSFWorkbook(fis);
	sheet = Startimes.getSheet("Startimes");
	for (int i = 1; i <= sheet.getLastRowNum(); i++)
	    cell = sheet.getRow(1).getCell(0);
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-METER_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-METER_NO")).sendKeys(cell.getStringCellValue());
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-FETCH")).click();
	System.out.println("TC2 Verify_whether_a_user_can_enter_smart_card_number|Success:");

}
// **********************************************************************************************************************************
@Test(priority = 46)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "STARTIMES PAYMENT") })
@Step ("Verify_whether_a_user_can_fetch_bill_details_startimes")
public void Verify_whether_a_user_can_fetch_bill_details_startimes() throws InterruptedException, IOException {
	//test =extent.createTest(" 3 Verify whether a user can fetch bill details for startimes after entering startimes number");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Bill Payment")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' STARTIMES ']")).click();
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);
	Startimes = new XSSFWorkbook(fis);
	sheet = Startimes.getSheet("Startimes");
	for (int i = 1; i <= sheet.getLastRowNum(); i++)
	    cell = sheet.getRow(1).getCell(0);
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-METER_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-METER_NO")).sendKeys(cell.getStringCellValue());
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-FETCH")).click();
	System.out.println("TC3 Verify_whether_a_user_can_fetch_bill_details_startime |Success:");

}
// **********************************************************************************************************************************
@Test(priority = 47)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "STARTIMES PAYMENT") })
@Step ("verify_whether_a_user_can_use_save_button_a_bill_startimes")
public void verify_whether_a_user_can_use_save_button_a_bill_startimes() throws InterruptedException, IOException {
	//test =extent.createTest(" 4 verify whether a user can use save button a bill for startimes account");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' PAYTV ']")));
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' STARTIMES ']")).click();
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);
	Startimes = new XSSFWorkbook(fis);
	sheet = Startimes.getSheet("Startimes");
	for (int i = 1; i <= sheet.getLastRowNum(); i++)
	    cell = sheet.getRow(1).getCell(0);
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-METER_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-METER_NO")).sendKeys(cell.getStringCellValue());
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-FETCH")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-PAYMENT_AMOUNT1")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-PAYMENT_AMOUNT1")).sendKeys("100");
	driver.findElement(By.cssSelector(".checkbox-inline")).click();
	System.out.println("TC4 verify_whether_a_user_can_use_save_button_a_bill_startimes |Success:");

}
// **********************************************************************************************************************************
@Test(priority = 48)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "STARTIMES PAYMENT") })
@Step ("verify_whether_a_user_can_Enter_Nick_Name")
public void verify_whether_a_user_can_Enter_Nick_Name() throws InterruptedException, IOException {
	//test =extent.createTest(" 5 verify whether a user can Enter Nick Name when saving for startimes account");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' PAYTV ']")));
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' STARTIMES ']")).click();
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);
	Startimes = new XSSFWorkbook(fis);
	sheet = Startimes.getSheet("Startimes");
	for (int i = 1; i <= sheet.getLastRowNum(); i++)
	    cell = sheet.getRow(1).getCell(0);
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-METER_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-METER_NO")).sendKeys(cell.getStringCellValue());
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-FETCH")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-PAYMENT_AMOUNT1")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-PAYMENT_AMOUNT1")).clear();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-PAYMENT_AMOUNT1")).sendKeys("100");	
	System.out.println("TC5 verify_whether_a_user_can_Enter_Nick_Name |Success:");

}
// **********************************************************************************************************************************
@Test(priority = 49)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "STARTIMES PAYMENT") })
@Step ("Verify_whether_a_user_can_select_debit_account_Dropdown_Menu_startimes")
public void Verify_whether_a_user_can_select_debit_account_Dropdown_Menu_startimes()
	    throws InterruptedException, IOException {
	//test =extent.createTest(" 6 Verify whether a user can select debit account Dropdown Menu when payimng for startimes");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' PAYTV ']")));
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' STARTIMES ']")).click();
	Thread.sleep(3000);
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);
	Startimes = new XSSFWorkbook(fis);
	sheet = Startimes.getSheet("Startimes");
	for (int i = 1; i <= sheet.getLastRowNum(); i++)
	    cell = sheet.getRow(1).getCell(0);
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-METER_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-METER_NO")).sendKeys(cell.getStringCellValue());
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-FETCH")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-PAYMENT_AMOUNT1")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-PAYMENT_AMOUNT1")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-PAYMENT_AMOUNT1")).sendKeys("100");
	driver.findElement(By.linkText("Next")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER_2-DEBIT_ACC_NO")).sendKeys("01105413334100");
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER_2-DEBIT_ACC_NO")).click();
	System.out.println("TC6 Verify_whether_a_user_can_select_debit_account_startimes |Success:");

}
// **********************************************************************************************************************************
@Test(priority = 50)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "STARTIMES PAYMENT") })
@Step ("Verify_whether_a_user_can_enter_amount_to_pay_for_startimes")
public void Verify_whether_a_user_can_enter_amount_to_pay_for_startimes() throws InterruptedException, IOException {
	//test =extent.createTest(" 7 Verify whether a user can enter amount to pay when paying for startimes");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' PAYTV ']")));
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' STARTIMES ']")).click();
	Thread.sleep(3000);
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);
	Startimes = new XSSFWorkbook(fis);
	sheet = Startimes.getSheet("Startimes");
	for (int i = 1; i <= sheet.getLastRowNum(); i++)
	    cell = sheet.getRow(1).getCell(0);
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-METER_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-METER_NO")).sendKeys(cell.getStringCellValue());
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-FETCH")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-PAYMENT_AMOUNT1")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-PAYMENT_AMOUNT1")).clear();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-PAYMENT_AMOUNT1")).sendKeys("100");
	driver.findElement(By.linkText("Next")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER_2-DEBIT_ACC_NO")).sendKeys("01105413334100");
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER_2-DEBIT_ACC_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER_2-PAYMENT_AMOUNT")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER_2-PAYMENT_AMOUNT")).clear();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER_2-PAYMENT_AMOUNT")).sendKeys("150");
	System.out.println("TC7 Verify_whether_a_user_can_enter_amount_to_pay_for_startimes |Success:");

}
// **********************************************************************************************************************************
@Test(priority = 51)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "STARTIMES PAYMENT") })
@Step ("Verify_whether_a_user_can_OTP_for_Transactions")
@Severity(SeverityLevel.CRITICAL)
public void Verify_whether_a_user_can_OTP_for_Transactions() throws InterruptedException, IOException {
	//test =extent.createTest(" 8 Verify whether a user can enter OTP when paying for startimes");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' PAYTV ']")));
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' STARTIMES ']")).click();
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);
	Startimes = new XSSFWorkbook(fis);
	sheet = Startimes.getSheet("Startimes");
	for (int i = 1; i <= sheet.getLastRowNum(); i++)
	cell = sheet.getRow(1).getCell(0);
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-METER_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-METER_NO")).sendKeys(cell.getStringCellValue());
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-FETCH")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-PAYMENT_AMOUNT1")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-PAYMENT_AMOUNT1")).clear();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-PAYMENT_AMOUNT1")).sendKeys("100");
	Thread.sleep(2000);
	driver.findElement(By.linkText("Next")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER_2-DEBIT_ACC_NO")).sendKeys("01105413334100");
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER_2-DEBIT_ACC_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER_2-PAYMENT_AMOUNT")).click();
	driver.findElement(By.linkText("Next")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Pay")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("4");

	System.out.println("TC8 Verify_whether_a_user_can_OTP_for_Transactions |Success:");

}
// **********************************************************************************************************************************
@Test(priority = 52)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "STARTIMES PAYMENT") })
@Step ("Verify_whether_a_user_can_pay_for_STARTIMES")
@Severity(SeverityLevel.BLOCKER)
public void Verify_whether_a_user_can_pay_for_STARTIMES() throws InterruptedException, IOException {
	//test =extent.createTest(" 9 Verify whether a user can pay for STARTIMES after entering OTP");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' PAYTV ']")));
	driver.findElement(By.xpath("//*[text()=' PAYTV ']")).click();
	driver.findElement(By.xpath("//div[text()=' STARTIMES ']")).click();
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);
	Startimes = new XSSFWorkbook(fis);
	sheet = Startimes.getSheet("Startimes");
	for (int i = 1; i <= sheet.getLastRowNum(); i++)
	    cell = sheet.getRow(1).getCell(0);
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-METER_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-METER_NO")).sendKeys(cell.getStringCellValue());
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-FETCH")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-PAYMENT_AMOUNT1")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-PAYMENT_AMOUNT1")).clear();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER-PAYMENT_AMOUNT1")).sendKeys("100");
	driver.findElement(By.linkText("Next")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER_2-DEBIT_ACC_NO")).sendKeys("01105413334100");
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER_2-DEBIT_ACC_NO")).click();
	driver.findElement(By.id("FORM_PAY_PAYSTARTIMES_BILLER_2-PAYMENT_AMOUNT")).click();
	driver.findElement(By.linkText("Next")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Pay")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("4");
	driver.findElement(By.xpath("//a[contains(.,\'Submit\')]")).click();
	if (driver.getPageSource().contains("Unable to process"))
	{
	System.out.println("Unable to process");
	org.testng.Assert.fail("Unable to process");
	}
	driver.findElement(By.xpath("//a[contains(.,\'Ok\')]")).click();
	System.out.println("TC9 Validate whether a user can pay for STARTIMES |Success:");

}
// **********************************************************************************************************************************
@Test(priority = 53)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "STARTIMES PAYMENT") })
@Step ("END OF PAYTV STARTIMES")
@Severity(SeverityLevel.TRIVIAL)
public void End_of_Pay_Startime_testcases()
	{
	//test =extent.createTest("END OF PAYTV STARTIMES ");
	System.out.println("*************************End of  Pay Startime ***********************************");

	}
// **********************************************************************************************************************************
@Test(priority = 54)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "AIRTIME AND DATA BUNDLES") })
@Step ("AIRTIME AND DATA BUNDLES")
@Severity(SeverityLevel.TRIVIAL)
public void Starting_Buy_Airtime_and_Data_Test_cases() 
	{
	//test =extent.createTest("(1) RUNNING AIRTIME AND DATA BUNDLES TESTCASES");
	System.out.println("AIRTIME AND DATA BUNDLES");
	System.out.println("*************************(1) Running Airtime And Data Bundles Testcases***********************************");

	}
// **********************************************************************************************************************************
@Test(priority = 55)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "AIRTIME AND DATA BUNDLES") })
@Step ("Verify_whether_a_user_can_Access_paybill_menu_on_landing_page")
@Severity(SeverityLevel.MINOR)
public void Verify_whether_a_user_can_Access_paybill_menu_on_landing_page()throws InterruptedException, IOException {
	//test =extent.createTest(" 1 Verify whether a user can Access paybill menu on landing page for buy airtimes and data bundles");
	File src = new File(my_dir + "\\Data_Driven_Excel_File\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(src);		
	RBX_BILLS = new XSSFWorkbook(fis);
	sheet = RBX_BILLS.getSheet("Loginmodule");		
	for (int i = 1; i <= sheet.getLastRowNum(); i++) 	
	 cell = sheet.getRow(1).getCell(2);
	System.out.println("this"+ cell.getStringCellValue());
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
	driver.findElement(By.linkText("Bill Payment")).click();
	System.out.println("TC1 Verify_whether_a_user_can_Access_paybill_menu_on_landing_page |Success:");

}
// **********************************************************************************************************************************
@Test(priority = 56)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "AIRTIME AND DATA BUNDLES") })
@Step ("Verify_whether_a_user_can_select_Airtime_purchase_menu")
@Severity(SeverityLevel.MINOR)
public void Verify_whether_a_user_can_select_Airtime_purchase_menu() throws InterruptedException, IOException {
	//test =extent.createTest(" 2 Verify whether a user can select Airtime purchase menu");
    	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Bill Payment")).click();
	driver.findElement(By.cssSelector(".airtime-purchase > .bill-body")).click();
	System.out.println("TC2 Verify- whether_a_user_can_select_Airtime_purchase_menu |Success:");

}
// **********************************************************************************************************************************
@Test(priority = 57)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "AIRTIME AND DATA BUNDLES") })
@Step ("verify_whether_a_user_can_select_prepaid_or_post_paid_option_radio_buttons")
public void verify_whether_a_user_can_select_prepaid_or_post_paid_option_radio_buttons()throws InterruptedException, IOException {
	//test =extent.createTest(" 3 Verify whether a user can select Airtime purchase menu");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Bill Payment")).click();
	driver.findElement(By.cssSelector(".airtime-purchase > .bill-body")).click();
	driver.findElement(By.cssSelector(".POST_PRE_RADIO-bs .radio-inline:nth-child(1)")).click();
	System.out.println("TC3 Verify- whether_a_user_can_select_prepaid_or_post_paid_option_radio_buttons |Success:");

}

// **********************************************************************************************************************************
@Test(priority = 58)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "AIRTIME AND DATA BUNDLES") })
@Step ("Verify_whether_a_user_can_select_my_number_as_recipient")
public void Verify_whether_a_user_can_select_my_number_as_recipient() throws InterruptedException, IOException {
	//test =extent.createTest(" 4 Verify whether a user can select my number as recipient for airtime purchase ");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Bill Payment")).click();
	driver.findElement(By.cssSelector(".airtime-purchase > .bill-body")).click();
	driver.findElement(By.cssSelector(".POST_PRE_RADIO-bs .radio-inline:nth-child(1)")).click();
	driver.findElement(By.cssSelector(".MOBILE_RADIO-bs .radio-inline:nth-child(1)")).click();
	System.out.println("TC4 Verify_whether_a_user_can_select_my_number_as_recipien|Success:");

}

// **********************************************************************************************************************************
@Test(priority = 59)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "AIRTIME AND DATA BUNDLES") })
@Step ("verify_whether_a_user_can_enter_number_if_other_number_is_selected")
public void verify_whether_a_user_can_enter_number_if_other_number_is_selected()
	    throws InterruptedException, IOException {
	//test =extent.createTest(" 5 verify whether a user can enter number if other number for airtime purcase is selected");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Bill Payment")).click();
	driver.findElement(By.cssSelector(".airtime-purchase > .bill-body")).click();
	driver.findElement(By.cssSelector(".POST_PRE_RADIO-bs .radio-inline:nth-child(1)")).click();
	driver.findElement(By.cssSelector(".MOBILE_RADIO-bs .radio-inline:nth-child(2)")).click();
	driver.findElement(By.id("AIRTIME_FORM_01-AIRTIME_BEN_MSISDN")).click();
	driver.findElement(By.id("AIRTIME_FORM_01-AIRTIME_BEN_MSISDN")).sendKeys("0723109988");
	driver.findElement(By.id("AIRTIME_FORM_01-DEBIT_ACCOUNT")).click();
	System.out.println("TC5 verify_whether_a_user_can_enter_number_if_other_number_is_selected |Success:");

}
// **********************************************************************************************************************************
@Test(priority = 60)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "AIRTIME AND DATA BUNDLES") })
@Step ("verify_whether_a_user_can_select_debit_account")
public void verify_whether_a_user_can_select_debit_account() throws InterruptedException, IOException {
	//test =extent.createTest(" 6 verify whether a user can select debit account when buying airtime");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Bill Payment")).click();
	driver.findElement(By.cssSelector(".airtime-purchase > .bill-body")).click();
	driver.findElement(By.cssSelector(".POST_PRE_RADIO-bs .radio-inline:nth-child(1)")).click();
	driver.findElement(By.cssSelector(".MOBILE_RADIO-bs .radio-inline:nth-child(1)")).click();
	driver.findElement(By.id("AIRTIME_FORM_01-DEBIT_ACCOUNT")).sendKeys("01105413334100");	    	  			  
	driver.findElement(By.id("AIRTIME_FORM_01-DEBIT_ACCOUNT")).click();
	System.out.println("TC6 Verify- whether_a_user_can_select_debit_account |Success:");

}
// **********************************************************************************************************************************
@Test(priority = 61)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "AIRTIME AND DATA BUNDLES") })
@Step ("Verify_whether_a_user_can_enter_Amount")
public void Verify_whether_a_user_can_enter_Amount() throws InterruptedException, IOException {
	//test =extent.createTest(" 8 Verify whether a user can enter Amount when buying airtime ");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	 Thread.sleep(3000);
	driver.findElement(By.linkText("Bill Payment")).click();
	driver.findElement(By.cssSelector(".airtime-purchase > .bill-body")).click();
	driver.findElement(By.cssSelector(".POST_PRE_RADIO-bs .radio-inline:nth-child(1)")).click();
	driver.findElement(By.cssSelector(".MOBILE_RADIO-bs .radio-inline:nth-child(1)")).click();
	driver.findElement(By.id("AIRTIME_FORM_01-DEBIT_ACCOUNT")).sendKeys("01105413334100");
	driver.findElement(By.id("AIRTIME_FORM_01-DEBIT_ACCOUNT")).click();
	driver.findElement(By.id("AIRTIME_FORM_01-AMOUNT")).click();
	driver.findElement(By.id("AIRTIME_FORM_01-AMOUNT")).sendKeys("1500");
	driver.findElement(By.id("AIRTIME_FORM_01-AMOUNT")).sendKeys(Keys.ENTER);
	System.out.println("TC7 Verify- a_user_can_enter_Amount to buy |Success:");

}
// *****************************************************************************************************************
@Test(priority = 62)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "AIRTIME AND DATA BUNDLES") })
@Step ("Verify_whether_a_user_can_Enter_OTP__for_verifications")
public void Verify_whether_a_user_can_Enter_OTP__for_verifications() throws InterruptedException, IOException {
	//test =extent.createTest(" 8 Verify whether a user can Enter OTP for verifications when buying airtime ");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Bill Payment")).click();
	driver.findElement(By.cssSelector(".airtime-purchase > .bill-body")).click();
	driver.findElement(By.cssSelector(".POST_PRE_RADIO-bs .radio-inline:nth-child(1)")).click();
	driver.findElement(By.cssSelector(".MOBILE_RADIO-bs .radio-inline:nth-child(1)")).click();
	driver.findElement(By.id("AIRTIME_FORM_01-DEBIT_ACCOUNT")).sendKeys("01105413334100");
	driver.findElement(By.id("AIRTIME_FORM_01-DEBIT_ACCOUNT")).click();
	driver.findElement(By.id("AIRTIME_FORM_01-AMOUNT")).click();
	driver.findElement(By.id("AIRTIME_FORM_01-AMOUNT")).sendKeys("455");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("BUY")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("4");
	System.out.println("TC8  Verify_whether_a_user_can_Enter_OTP__for_verifications |Success:");

}
// **********************************************************************************************************************************
@Test(priority = 63)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "AIRTIME AND DATA BUNDLES") })
@Step ("Verify_whether_a_user_can_buy_Airtime")
@Severity(SeverityLevel.CRITICAL)
public void Verify_whether_a_user_can_buy_Airtime() throws InterruptedException, IOException {
	//test =extent.createTest(" 9 Verify whether a user can buy Airtime after entering OTP ");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	 Thread.sleep(3000);
	driver.findElement(By.linkText("Bill Payment")).click();
	driver.findElement(By.cssSelector(".airtime-purchase > .bill-body")).click();
	driver.findElement(By.cssSelector(".POST_PRE_RADIO-bs .radio-inline:nth-child(1)")).click();
	driver.findElement(By.cssSelector(".MOBILE_RADIO-bs .radio-inline:nth-child(1)")).click();
	driver.findElement(By.id("AIRTIME_FORM_01-DEBIT_ACCOUNT")).sendKeys("01105413334100");
	driver.findElement(By.id("AIRTIME_FORM_01-DEBIT_ACCOUNT")).click();
	driver.findElement(By.id("AIRTIME_FORM_01-AMOUNT")).click();
	driver.findElement(By.id("AIRTIME_FORM_01-AMOUNT")).sendKeys("455");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("BUY")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("4");
	driver.findElement(By.linkText("Submit")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[text()=' Done ']")).click();
	System.out.println("TC9 Verify- user _can_buy_Airtime |Success:");

}
// **********************************************************************************************************************************
@Test(priority = 64)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "AIRTIME AND DATA BUNDLES") })
@Step ("Validate_whether_a_user_can_buy_Airtime")
@Severity(SeverityLevel.BLOCKER)
public void Validate_whether_a_user_can_buy_Airtime() throws InterruptedException, IOException {
	//test =extent.createTest(" 10 Validate whether a transaction for Airtime purchase is sucessful");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Bill Payment")).click();
	driver.findElement(By.cssSelector(".airtime-purchase > .bill-body")).click();
	driver.findElement(By.cssSelector(".POST_PRE_RADIO-bs .radio-inline:nth-child(1)")).click();
	driver.findElement(By.cssSelector(".MOBILE_RADIO-bs .radio-inline:nth-child(1)")).click();
	driver.findElement(By.id("AIRTIME_FORM_01-DEBIT_ACCOUNT")).sendKeys("01105413334100");
	driver.findElement(By.id("AIRTIME_FORM_01-DEBIT_ACCOUNT")).click();
	driver.findElement(By.id("AIRTIME_FORM_01-AMOUNT")).click();
	driver.findElement(By.id("AIRTIME_FORM_01-AMOUNT")).sendKeys("455");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("BUY")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("4");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("4");
	driver.findElement(By.linkText("Submit")).click();
	Thread.sleep(3000);
	if (driver.getPageSource().contains("Airtime Purchase Failed")) 
	{
	System.out.println("Airtime Purchase Failed");
	org.testng.Assert.fail("Airtime Purchase Failed");
	} 
	else 
	{
	System.out.println("Transaction Sucessful");
	}
	driver.findElement(By.xpath("//a[text()=' Done ']")).click();
	System.out.println("TC10 Validate Whether a user can buy Airtime |Success:");

}
// *****************************************************************************************************************
@Test(priority = 65)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "AIRTIME AND DATA BUNDLES") })
@Step ("END OF BUY AIRTIME AND DATA TESTCASES")
@Severity(SeverityLevel.TRIVIAL)
public void End_of_Buy_Airtime_and_Data() {
	//test =extent.createTest("END OF BUY AIRTIME AND DATA TESTCASES");
	System.out.println("*************************End of  Buy Airtime and Data***********************************");

}

@Test(priority = 66)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "BUY GOODS USING MPESA") })
@Step ("BUY GOODS USING MPESA")
@Severity(SeverityLevel.TRIVIAL)
public void Buy_Goods_Using_MPESA_Test_cases() {
	//test =extent.createTest("(1)RUNNING BUY GOODS USING MPESA TESTCASES");
	System.out.println("BUY GOODS AND SERVICES");	
	System.out.println("*************************(1)Running Buy Goods Using MPESA Testcases***********************************");

}
// ***********************************************************************************************************************************
@Test(priority = 67)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "BUY GOODS USING MPESA") })
@Step ("Verify_whether_a_user_can_select_MPESA_till_menu")
@Severity(SeverityLevel.MINOR)
public void Verify_whether_a_user_can_select_MPESA_till_menu() throws InterruptedException, IOException {
	//test =extent.createTest(" 1 Verify whether a user can select MPESA till menu  when  buying for goods using till number");
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
	Thread.sleep(3000);
	driver.findElement(By.linkText("Bill Payment")).click();
	driver.findElement(By.cssSelector(".card:nth-child(10) > .bill-body")).click();
	driver.findElement(By.cssSelector("#cobank3 > .col-in:nth-child(1)")).click();
	System.out.println("TC1 Verify_whether_a_user_can_select_MPESA_till_menu |Success:");


}

// ***********************************************************************************************************************************
@Test(priority = 68)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "BUY GOODS USING MPESA") })
@Step ("Verify_whether_debit_account_can_be_selected")
@Severity(SeverityLevel.MINOR)
public void Verify_whether_debit_account_can_be_selected() throws InterruptedException, IOException {
	//test =extent.createTest(" 2 Verify whether debit account can be selected from the dropdown wen buying for goods using till number");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Bill Payment")).click();
	driver.findElement(By.cssSelector(".card:nth-child(10) > .bill-body")).click();
	driver.findElement(By.cssSelector("#cobank3 > .col-in:nth-child(1)")).click();
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_DEBIT_ACCOUNT")).sendKeys("01105413334100");
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_DEBIT_ACCOUNT")).click();
	System.out.println("TC2 Verify_whether_debit_account_can_be_selected |Success:");


}

// ***********************************************************************************************************************************
@Test(priority = 69)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "BUY GOODS USING MPESA") })
@Step ("Verify_whether_user_can_enter_till_number")
public void Verify_whether_user_can_enter_till_number() throws InterruptedException, IOException {
	//test =extent.createTest(" 3 Verify whether user can enter till number when buying goods using till number");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Bill Payment")).click();
	driver.findElement(By.cssSelector(".card:nth-child(10) > .bill-body")).click();
	driver.findElement(By.cssSelector("#cobank3 > .col-in:nth-child(1)")).click();
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_DEBIT_ACCOUNT")).sendKeys("01105413334100");
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_DEBIT_ACCOUNT")).click();
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_NO")).click();
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_NO")).sendKeys("342233");
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_NO")).sendKeys(Keys.ENTER);
	System.out.println("TC3 Verify_whether_user_can_enter_till_number |Success:");

}

// ***********************************************************************************************************************************
@Test(priority = 70)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "BUY GOODS USING MPESA") })
@Step ("Verify_whether_till_number_can_be_validated")
public void Verify_whether_till_number_can_be_validated() throws InterruptedException, IOException {
	//test =extent.createTest(" 4 Verify whether till number can be validated");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Bill Payment")).click();
	driver.findElement(By.cssSelector(".card:nth-child(10) > .bill-body")).click();
	driver.findElement(By.cssSelector("#cobank3 > .col-in:nth-child(1)")).click();
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_DEBIT_ACCOUNT")).sendKeys("01105413334100");
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_DEBIT_ACCOUNT")).click();
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_NO")).click();
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_NO")).sendKeys("222222333333");
	driver.findElement(By.id("MPESA_TILL_FORM_01-AMOUNT")).click();
	System.out.println("TC4 Verify_whether_till_number_can_be_validated |Success:");

}

// ***********************************************************************************************************************************
@Test(priority = 71)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "BUY GOODS USING MPESA") })
@Step ("Verify_whether_a_user_can_enter_amount_in_KES")
public void Verify_whether_a_user_can_enter_amount_in_KES() throws InterruptedException, IOException {
	//test =extent.createTest(" 5 Verify whether a user can enter amount in KES when buying goods using till number");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Bill Payment")).click();
	driver.findElement(By.cssSelector(".card:nth-child(10) > .bill-body")).click();
	driver.findElement(By.cssSelector("#cobank3 > .col-in:nth-child(1)")).click();
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_DEBIT_ACCOUNT")).sendKeys("01105413334100");
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_DEBIT_ACCOUNT")).click();
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_NO")).click();
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_NO")).sendKeys("50605071");
	driver.findElement(By.id("MPESA_TILL_FORM_01-AMOUNT")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("MPESA_TILL_FORM_01-AMOUNT")).sendKeys("1000");
	Thread.sleep(3000);
	System.out.println("TC5 Verify_whether_a_user_can_enter_amount_in_KES |Success:");

}
// ***********************************************************************************************************************************
@Test(priority = 72)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "BUY GOODS USING MPESA") })
@Step ("Verify_whether_a_user_can_enter_OTP")
public void Verify_whether_a_user_can_enter_OTP() throws InterruptedException, IOException {
	//test =extent.createTest(" 6 Verify whether a user can enter OTP when buying for goods using till number");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Bill Payment")).click();
	Thread.sleep(3000);
	driver.findElement(By.cssSelector(".card:nth-child(10) > .bill-body")).click();
	driver.findElement(By.cssSelector("#cobank3 > .col-in:nth-child(1)")).click();
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_DEBIT_ACCOUNT")).sendKeys("01125413334100");
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_DEBIT_ACCOUNT")).click();
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_NO")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_NO")).sendKeys("50605071");
	Thread.sleep(3000);
	driver.findElement(By.id("MPESA_TILL_FORM_01-AMOUNT")).click();
	driver.findElement(By.id("MPESA_TILL_FORM_01-AMOUNT")).sendKeys("1233");
	Thread.sleep(3000);
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("2");
	Thread.sleep(3000);
	System.out.println("TC6 Verify_whether_a_user_can_enter_OTP |Success:");

}

// ***********************************************************************************************************************************
@Test(priority = 73)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "BUY GOODS USING MPESA") })
@Step ("Verify_whether_a_user_can_pay_using_till_number")
@Severity(SeverityLevel.CRITICAL)
public void Verify_whether_a_user_can_pay_using_till_number() throws InterruptedException, IOException {
	//test =extent.createTest(" 7 Verify whether a user can pay for goods using till number");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Bill Payment")).click();
	System.out.println("Click on Bill payment");
	Thread.sleep(3000);
	driver.findElement(By.cssSelector(".card:nth-child(10) > .bill-body")).click();
	driver.findElement(By.cssSelector("#cobank3 > .col-in:nth-child(1)")).click();
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_DEBIT_ACCOUNT")).sendKeys("01125413334100");
	System.out.println("Select: Account");
	Thread.sleep(3000);
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_DEBIT_ACCOUNT")).click();
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_NO")).click();
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_NO")).sendKeys("50605071");
	Thread.sleep(3000);
	System.out.println("TC7 Verify_whether_a_user_can_pay_using_till_number |Success:After");
	driver.findElement(By.id("MPESA_TILL_FORM_01-AMOUNT")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("MPESA_TILL_FORM_01-AMOUNT")).sendKeys("1233");
	System.out.println("TC7 Verify_whether_a_user_can_pay_using_till_number |Success:Amount");
	Thread.sleep(3000);
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("OTP_FORM-OTP_INPUT_1")));
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("2");
	Thread.sleep(3000);
	driver.findElement(By.linkText("Submit")).click();
	System.out.println("Click on Submit");
	Thread.sleep(3000);
	driver.findElement(By.linkText("Done")).click();
	System.out.println("TC7 Verify_whether_a_user_can_pay_using_till_number |Success:");

}

// ***********************************************************************************************************************************
@Test(priority = 74)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "BUY GOODS USING MPESA") })
@Step ("VALIDATE_whether_a_user_can_pay_using_till_number")
@Severity(SeverityLevel.BLOCKER)
public void VALIDATE_whether_a_user_can_pay_using_till_number() throws InterruptedException, IOException {
	//test =extent.createTest(" 8 VALIDATE whether a transaction to pay for goods using till number is sucessful");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Bill Payment")).click();
	Thread.sleep(3000);
	driver.findElement(By.cssSelector(".card:nth-child(10) > .bill-body")).click();
	driver.findElement(By.cssSelector("#cobank3 > .col-in:nth-child(1)")).click();
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_DEBIT_ACCOUNT")).sendKeys("01125413334100");
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_DEBIT_ACCOUNT")).click();
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_NO")).click();
	driver.findElement(By.id("MPESA_TILL_FORM_01-TILL_NO")).sendKeys("50605071");
	Thread.sleep(3000);
	driver.findElement(By.id("MPESA_TILL_FORM_01-AMOUNT")).click();
	driver.findElement(By.id("MPESA_TILL_FORM_01-AMOUNT")).sendKeys("1233");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("OTP_FORM-OTP_INPUT_1")));
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("2");
	driver.findElement(By.linkText("Submit")).click();
	if (driver.getPageSource().contains("Unable to process")) {
	    System.out.println("Unable to process");
	    org.testng.Assert.fail("Unable to process");
	}
	driver.findElement(By.linkText("Done")).click();
	System.out.println("TC8 VALIDATE_whether_a_user_can_pay_using_till_number |Success:");

}

@Test(priority = 75)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "BUY GOODS USING MPESA") })
@Step ("END OF BUY GOODS USING MPESA TILL TESTCASES")
@Severity(SeverityLevel.TRIVIAL)
public void End_Buy_Goods_Using_MPESA_Test_cases() {
	//test =extent.createTest("END OF BUY GOODS USING MPESA TILL TESTCASES");
	System.out.println("*************************End of buy Goods Using Mpesa Test cases***********************************");

}
//********************************************************************************************************************************
@Test(priority = 76)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "BUY GOODS USING PAYBILL") })
@Severity(SeverityLevel.TRIVIAL)
@Step ("BUY GOODS USING PAYBILL")
public void Buy_Buy_Goods_Pay_Bills_Test_cases() {
	//test =extent.createTest("(2) RUNNING BUY GOODS USING PAYBILL NUMBER");
	System.out.println("*************************(2)Running Buy Goods Pay Bill Testcases***********************************");

}
//***********************************************************************************************************************************	
@Test(priority = 77)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "BUY GOODS USING PAYBILL") })
@Severity(SeverityLevel.MINOR)
@Step ("Verify_whether_a_user_can_select_mpesa_paybill_number_menu")
public void Verify_whether_a_user_can_select_mpesa_paybill_number_menu() throws InterruptedException, IOException {
	//test =extent.createTest(" 1 Verify whether a user can select mpesa paybill number menu");
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
	Thread.sleep(1000);
	driver.findElement(By.linkText("Bill Payment")).click();
	driver.findElement(By.cssSelector(".card:nth-child(10) > .bill-body")).click();
	System.out.println("TC1Verify_whether_a_user_can_select MPESA_menu on landing page |Success:");

}

// ***********************************************************************************************************************************
@Test(priority = 78)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "BUY GOODS USING PAYBILL") })
@Step ("Verify_whether_a_user_can_select_mpesa_paybill_numbermenu")
@Severity(SeverityLevel.MINOR)
public void Verify_whether_a_user_can_select_mpesa_paybill_numbermenu() throws InterruptedException, IOException {
	//test =extent.createTest(" 2 Verify whether a user can select mpesa paybill number menu");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.findElement(By.linkText("Bill Payment")).click();
	driver.findElement(By.cssSelector(".card:nth-child(10) > .bill-body")).click();
	driver.findElement(By.cssSelector("#cobank3 > .col-in:nth-child(2)")).click();
	System.out.println("TC2 Verify_whether_a_user_can_select_MPESA_till_menu |Success:");

}

//***********************************************************************************************************************************
@Test(priority = 79)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "BUY GOODS USING PAYBILL") })
@Step ("Verify_whether_a_user_can_enter_valid_business_number")
public void Verify_whether_a_user_can_enter_valid_business_number() throws InterruptedException, IOException {
	//test =extent.createTest(" 3 Verify whether a user can enter valid business number when paying for buying for goods using paybiill number ");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.findElement(By.linkText("Bill Payment")).click();
	driver.findElement(By.cssSelector(".card:nth-child(10) > .bill-body")).click();
	driver.findElement(By.cssSelector("#cobank3 > .col-in:nth-child(2)")).click();
	driver.findElement(By.id("MPESA_B2B_FORM_01-DEBIT_ACCOUNT")).sendKeys("01105413334100");
	driver.findElement(By.id("MPESA_B2B_FORM_01-DEBIT_ACCOUNT")).click();
	driver.findElement(By.id("MPESA_B2B_FORM_01-BUSINESS_NO")).click();
	driver.findElement(By.id("MPESA_B2B_FORM_01-BUSINESS_NO")).sendKeys("107051");
	System.out.println("TC3 Verify_whether_a_user_can_enter AND validate_business_number|Success:");
}
//***********************************************************************************************************************************
@Test(priority = 80)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "BUY GOODS USING PAYBILL") })
@Step ("Verify_whether_a_user_can_enter_account_number")
public void Verify_whether_a_user_can_enter_account_number() throws InterruptedException, IOException {
	//test =extent.createTest(" 4 Verify whether a user can enter account number when buying using till numer");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.findElement(By.linkText("Bill Payment")).click();
	driver.findElement(By.cssSelector(".card:nth-child(10) > .bill-body")).click();
	driver.findElement(By.cssSelector("#cobank3 > .col-in:nth-child(2)")).click();
	driver.findElement(By.id("MPESA_B2B_FORM_01-DEBIT_ACCOUNT")).sendKeys("01105413334100");//
	System.out.println("TC4 Verify_whether_a_user_can_enter_account_number |Success:");

}
// ***********************************************************************************************************************************
@Test(priority = 81)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "BUY GOODS USING PAYBILL") })
@Step ("Verify_whether_a_user_can_enter_amount_to_pay")
public void Verify_whether_a_user_can_enter_amount_to_pay() throws InterruptedException, IOException {
	//test =extent.createTest(" 5 Verify whether a user can enter amount to pay when buying using paybill number");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.findElement(By.linkText("Bill Payment")).click();
	driver.findElement(By.cssSelector(".card:nth-child(10) > .bill-body")).click();
	driver.findElement(By.cssSelector("#cobank3 > .col-in:nth-child(2)")).click();
	driver.findElement(By.id("MPESA_B2B_FORM_01-DEBIT_ACCOUNT")).sendKeys("01105413334100");
	driver.findElement(By.id("MPESA_B2B_FORM_01-DEBIT_ACCOUNT")).click();
	driver.findElement(By.id("MPESA_B2B_FORM_01-BUSINESS_NO")).click();
	driver.findElement(By.id("MPESA_B2B_FORM_01-BUSINESS_NO")).sendKeys("107051");
	// driver.findElement(By.cssSelector(".DEST_ACC_NO-bs")).click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.findElement(By.id("MPESA_B2B_FORM_01-DEST_ACC_NO")).sendKeys("0990889778");
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	driver.findElement(By.id("MPESA_B2B_FORM_01-AMOUNT")).click();
	driver.findElement(By.id("MPESA_B2B_FORM_01-AMOUNT")).sendKeys("1200");
	System.out.println("TC5 Verify_whether_a_user_can_enter_amount_to_pay |Success:");

}

// ***********************************************************************************************************************************
@Test(priority = 82)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "BUY GOODS USING PAYBILL") })
@Step ("Verify_whether_a_user_can_enter_OTP_to_verify_transaction")
public void Verify_whether_a_user_can_enter_OTP_to_verify_transaction() throws InterruptedException, IOException {
	//test =extent.createTest(" 6 Verify whether a user can enter OTP to verify transaction when buying using paybill number");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.findElement(By.linkText("Bill Payment")).click();
	driver.findElement(By.cssSelector(".card:nth-child(10) > .bill-body")).click();
	driver.findElement(By.cssSelector("#cobank3 > .col-in:nth-child(2)")).click();
	driver.findElement(By.id("MPESA_B2B_FORM_01-DEBIT_ACCOUNT")).sendKeys("01105413334100");
	driver.findElement(By.id("MPESA_B2B_FORM_01-DEBIT_ACCOUNT")).click();
	driver.findElement(By.id("MPESA_B2B_FORM_01-BUSINESS_NO")).click();
	driver.findElement(By.id("MPESA_B2B_FORM_01-BUSINESS_NO")).sendKeys("107051");
	driver.findElement(By.id("//span[@id='lbl_BUSINESS_NO']")).click();	
	driver.findElement(By.id("MPESA_B2B_FORM_01-DEST_ACC_NO")).sendKeys("0990889778");
	driver.findElement(By.id("MPESA_B2B_FORM_01-AMOUNT")).click();
	driver.findElement(By.id("MPESA_B2B_FORM_01-AMOUNT")).sendKeys("1200");
	Thread.sleep(4000);
	driver.findElement(By.xpath("//a[contains(.,\'NEXT\')]")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//a[contains(.,\'NEXT\')]")).click();
	Thread.sleep(4000);
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("1");
	System.out.println("TC6 Verify_whether_a_user_can_enter_OTP_to_verify_transactio |Success:");


}
// ***********************************************************************************************************************************
@Test(priority = 83)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "BUY GOODS USING PAYBILL") })
@Severity(SeverityLevel.CRITICAL)
@Step ("Verify_whether_a_user_can_buy_goods_and_services_using_pay_bill_option")
public void Verify_whether_a_user_can_buy_goods_and_services_using_pay_bill_option()throws InterruptedException, IOException {
	//test =extent.createTest(" 7 Verify whether a user ca _buy for goods and services using pay bill option");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.findElement(By.linkText("Bill Payment")).click();
	driver.findElement(By.cssSelector(".card:nth-child(10) > .bill-body")).click();
	driver.findElement(By.cssSelector("#cobank3 > .col-in:nth-child(2)")).click();
	driver.findElement(By.id("MPESA_B2B_FORM_01-DEBIT_ACCOUNT")).sendKeys("01105413334100");
	driver.findElement(By.id("MPESA_B2B_FORM_01-DEBIT_ACCOUNT")).click();
	driver.findElement(By.id("MPESA_B2B_FORM_01-BUSINESS_NO")).click();
	driver.findElement(By.id("MPESA_B2B_FORM_01-BUSINESS_NO")).sendKeys("107051");
	driver.findElement(By.id("MPESA_B2B_FORM_01-DEST_ACC_NO")).sendKeys("0990889778");
	driver.findElement(By.id("MPESA_B2B_FORM_01-AMOUNT")).click();
	driver.findElement(By.id("MPESA_B2B_FORM_01-AMOUNT")).sendKeys("1200");
	Thread.sleep(4000);
	driver.findElement(By.xpath("//a[contains(.,\'NEXT\')]")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//a[contains(.,\'NEXT\')]")).click();
	Thread.sleep(4000);
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("1");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[contains(.,\'Submit\')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[text()=' Done ']")).click();
	System.out.println("TC7 Verify_whether_a_user_can_buy_goods_and_services_using_pay_bill_option |Success:");

}
// ***********************************************************************************************************************************
@Test(priority = 84)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "BUY GOODS USING PAYBILL") })
@Step ("VALIDATE_whether_a_user_can_buy_goods_and_services_using_pay_bill_option")
@Severity(SeverityLevel.BLOCKER)
public void VALIDATE_whether_a_user_can_buy_goods_and_services_using_pay_bill_option() throws InterruptedException, IOException {
	//test =extent.createTest("  8 VALIDATE whether a transaction is sucessfil when buying for goods and services using pay bill option");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	driver.findElement(By.linkText("Bill Payment")).click();
	driver.findElement(By.cssSelector(".card:nth-child(10) > .bill-body")).click();
	driver.findElement(By.cssSelector("#cobank3 > .col-in:nth-child(2)")).click();
	driver.findElement(By.id("MPESA_B2B_FORM_01-DEBIT_ACCOUNT")).sendKeys("01105413334100");
	driver.findElement(By.id("MPESA_B2B_FORM_01-DEBIT_ACCOUNT")).click();
	driver.findElement(By.id("MPESA_B2B_FORM_01-BUSINESS_NO")).click();
	driver.findElement(By.id("MPESA_B2B_FORM_01-BUSINESS_NO")).sendKeys("107051");
	// driver.findElement(By.cssSelector(".DEST_ACC_NO-bs")).click();
	driver.findElement(By.id("MPESA_B2B_FORM_01-DEST_ACC_NO")).sendKeys("0990889778");
	driver.findElement(By.id("MPESA_B2B_FORM_01-AMOUNT")).click();
	driver.findElement(By.id("MPESA_B2B_FORM_01-AMOUNT")).sendKeys("1200");
	Thread.sleep(4000);
	driver.findElement(By.xpath("//a[contains(.,\'NEXT\')]")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//a[contains(.,\'NEXT\')]")).click();
	Thread.sleep(4000);
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("1");
	driver.findElement(By.xpath("//a[contains(.,\'Submit\')]")).click();
	Thread.sleep(1000);
	if (driver.getPageSource().contains("Sorry. We are unable to process your request at the moment.")) {
	    System.out.println("Sorry. We are unable to process your request at the moment.");
	    org.testng.Assert.fail("Sorry. We are unable to process your request at the moment.");
	} else {
	    // System.out.println("Transaction Sucessful");
	}
	driver.findElement(By.xpath("//a[text()=' Done ']")).click();
	System.out.println("TC8 VALIDATE_whether_a_user_can_buy_goods_and_services_using_pay_bill_option |Success:");


}

//***********************************************************************************************************************************
@Test(priority = 85)
@Epic("BILLS PAYMENT")
@Severity(SeverityLevel.TRIVIAL)
@Features(value = { @Feature(value = "BUY GOODS USING PAYBILL") })
@Step ("END OF BUY FOR GOODS AND SERVICES USING PABILL OPTION")
public void End_Buy_Goods_Pay_Bills_Test_cases() {
	//test =extent.createTest("END OF BUY FOR GOODS AND SERVICES USING PABILL OPTION");
	System.out.println("*************************End Buy Goods Pay Bills Testcases***********************************");

}
//********************************************************************************************************************************
@Test(priority = 86)
@Epic("BILLS PAYMENT")
@Severity(SeverityLevel.TRIVIAL)
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("RUNNING SCHOOL FEES TESTCASES")
public void Bills_School_Fees_Test_cases() {
	//test =extent.createTest("RUNNING SCHOOL FEES TESTCASES");
	System.out.println("INSTITUTIONAL PAYMENTS");
	System.out.println("*************************Running Bills School feees Testcases***********************************");

}
//***********************************************************************************************************************************
@Test(priority = 87)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify_that_user_is_able_to_view_the_school_fee_menu_under_bill_payments")
@Severity(SeverityLevel.MINOR)
public void Verify_that_user_is_able_to_view_the_school_fee_menu_under_bill_payments() throws IOException {
	//test =extent.createTest(" 1 Verify that user is able to view the school fee menu under bill payments");
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
	WebDriverWait wait3 = new WebDriverWait(driver, 15);
	wait3.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	System.out.println("TC1 Verify_that_user_is_able_to_view_the_school_fee_menu_under_bill_payments |Success:");

}

//***********************************************************************************************************************************
@Test(priority = 88)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify_that_the_user_can_click_on_the_school_fees_menu")
@Severity(SeverityLevel.MINOR)
public void Verify_that_the_user_can_click_on_the_school_fees_menu() {
	//test =extent.createTest(" 2 Verify that the user can click on the school fees menu");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	System.out.println("TC2 Verify_that_the_user_can_click_on_the_school_fees_menu |Success:");


}

//***********************************************************************************************************************************
@Test(priority = 89)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify_that_user_is_able_to_click_on_new_payment_and_menu")
public void Verify_that_user_is_able_to_click_on_new_payment_and_menu() {
	//test =extent.createTest("3 Verify that user is able to click on new payment and menu");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_NEW_PAYMENT")).click();
	System.out.println("TC3 Verify_that_user_is_able_to_click_on_new_payment_and_menu |Success:");

}

//***********************************************************************************************************************************
@Test(priority = 90)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify_that_the_new_payment_menu_is_highlighted_when_active")
public void Verify_that_the_new_payment_menu_is_highlighted_when_active() {
	//test =extent.createTest(" 4 Verify that the new payment menu is highlighted when active");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_NEW_PAYMENT")).click();
	System.out.println("TC4 Verify_that_the_new_payment_menu_is_highlighted_when_active |Success:");

}
//***********************************************************************************************************************************
@Test(priority = 91)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify_the_user_is_able_to_view_the_search_by_input_field")
public void Verify_the_user_is_able_to_view_the_search_by_input_field() {
	//test =extent.createTest(" 5 Verify the user is able to view the search by input field");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	dropdown.findElement(By.xpath("//option[. = 'Account Number']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	dropdown.findElement(By.xpath("//option[. = 'School ID']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	System.out.println("TC5 Verify_the_user_is_able_to_view_the_search_by_input_field |Success:");

}

//***********************************************************************************************************************************
@Test(priority = 92)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify_the_user_is_able_to_click_the_search_school_Tab")
public void Verify_the_user_is_able_to_click_the_search_school_Tab() {
	//test =extent.createTest(" 6 Verify the user is able to click the search school Tab");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	    dropdown.findElement(By.xpath("//option[. = 'Account Number']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	    dropdown.findElement(By.xpath("//option[. = 'School ID']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	System.out.println("TC6 Verify_the_user_is_able_to click_the_search_school_Tab |Success:");

}

//***********************************************************************************************************************************
@Test(priority = 93)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify_that_when_user_clicks_on_search_by_tab_acnumber_and_school_code_options_are_displayed")
public void Verify_that_when_user_clicks_on_search_by_tab_acnumber_and_school_code_options_are_displayed() {
	//test =extent.createTest(" 7 Verify that when user clicks on search by tab acnumber and school code options are displayed");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	    dropdown.findElement(By.xpath("//option[. = 'Account Number']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	System.out.println("TC7 Verify_that_when_user_clicks_on_search_by_tab_acnumber_and_school_code_options_are_displayed |Success:");

	
}

//***********************************************************************************************************************************
@Test(priority = 94)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify_that_customer_is_able_to_select_Account_number_options")
public void Verify_that_customer_is_able_to_select_Account_number_options() {
	//test =extent.createTest(" 8 Verify that customer is able to select Account number options");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	    dropdown.findElement(By.xpath("//option[. = 'Account Number']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	System.out.println("TC8 Verify_that_customer_is_able_to_select_Account_number_options |Success:");

}

//***********************************************************************************************************************************
@Test(priority = 95)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify_that_when_user_selects_Account_number_option_the_system_will_display_an_account_number_inputfield")
public void Verify_that_when_user_selects_Account_number_option_the_system_will_display_an_account_number_inputfield() {
	//test =extent.createTest(" 9 Verify that when user selects Account number option the system will display an account number input field");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	    dropdown.findElement(By.xpath("//option[. = 'Account Number']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	driver.findElement(By.id("lbl_SF_ACCOUNT_NUMBER")).click();
	System.out.println(
		"TC9 Verify_that_when_user_selects_Account_number_option_the_system_will_display_an_account_number_inputfield |Success:");
}

//***********************************************************************************************************************************
@Test(priority = 96)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify_that_customer_is_able_to_select_School_code_options")
public void Verify_that_customer_is_able_to_select_School_code_options() {
	//test =extent.createTest(" 10 Verify that customer is able to select School code options");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	    dropdown.findElement(By.xpath("//option[. = 'School ID']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	System.out.println("TC10  Verify_that_customer_is_able_to_select_School_code_options |Success:");


}

//***********************************************************************************************************************************
@Test(priority = 97)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify that user can input the 14 digits account number")
public void Verify_that_user_can_input_the_14_digits_account_number() {
	//test =extent.createTest("11 Verify that user can input the 14 digits account number");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	    dropdown.findElement(By.xpath("//option[. = 'Account Number']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_ACCOUNT_NUMBER")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_ACCOUNT_NUMBER")).sendKeys("01129080146300");
	System.out.println("TC11 Verify_that_user_can_input_the_14_digits_account_number |Success:");

}

//********************************************************************************************************************************
@Test(priority = 98)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify that user is able to click on the search for school functionality")
public void Verify_that_user_is_able_to_click_on_the_search_for_school_functionality() {
	//test =extent.createTest(" 12 Verify that user is able to click on the search for school functionality");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	    dropdown.findElement(By.xpath("//option[. = 'Account Number']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_ACCOUNT_NUMBER")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_ACCOUNT_NUMBER")).sendKeys("01129080146300");
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL")).click();
	System.out.println("TC12 Verify_that_user_is_able_to_click_on_the_search_for_school_functionality |Success:");


}

@Test(priority = 99)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify that system is able to search and display correct school Name school code and Bank branch when user click on search for school functionality")
public void Verify_that_system_is_able_to_search_and_display_correct_school_name_school_code_and_Bank_branch_when_user_click_on_search_for_school_functionality() {
	//test =extent.createTest(" 13 Verify that system is able to search and display correct school Name school code and Bank branch when user click on search for school functionality");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	    dropdown.findElement(By.xpath("//option[. = 'Account Number']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_ACCOUNT_NUMBER")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_ACCOUNT_NUMBER")).sendKeys("01129080146300");
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL")).click();
	driver.findElement(By.cssSelector(".ct-formlayout-SCHOOL_NAME .ct-form__ip")).click();
	driver.findElement(By.cssSelector(".ct-formlayout-SCHOOL_CODE .ct-form__ip")).click();
	System.out.println("TC13 Verify_that_system_is_able_to_search_and_display_correct_school_name_school_code_and_Bank_branch_when_user_click_on_search_for_school_functionality |Success:");

	}
//********************************************************************************************************************************

@Test(priority = 100)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify that system displays the school code input field when user selects search by school ID option")
public void Verify_that_system_displays_the_school_code_input_field_when_user_selects_search_by_school_ID_option() {
	//test =extent.createTest(" 14 Verify that system displays the school code input field when user selects search by school ID option");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	    dropdown.findElement(By.xpath("//option[. = 'School ID']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).sendKeys("883");
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL")).click();
	driver.findElement(By.cssSelector(".ct-formlayout-SCHOOL_NAME .ct-form__ip")).click();
	driver.findElement(By.cssSelector(".ct-formlayout-SCHOOL_ACCOUNT_NUMBER .ct-form__ip")).click();
	System.out.println("TC14 Verify_that_system_displays_the_school_code_input_field_when_user_selects_search_by_school_ID_option |Success:");

	}
//********************************************************************************************************************************
@Test(priority = 101)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify that the system displays data input field for Registration number  Student name Narration")
public void Verify_that_the_system_displays_data_input_field_for_Registration_number_Student_name_Narration()
	    throws InterruptedException {
	//test =extent.createTest(" 15 Verify that the system displays data input field for Registration number  Student name Narration");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	    dropdown.findElement(By.xpath("//option[. = 'School ID']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).sendKeys("883");
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("NEXT")).click();
	WebDriverWait wait2 = new WebDriverWait(driver, 15);
	wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")));
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")).sendKeys("DMS05 R D1");
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-SEARCH_STUDENT")).click();
	driver.findElement(By.id("lbl_STUDENT_NAME")).click();
	driver.findElement(By.id("lbl_NARRATION")).click();
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-NARRATION")).sendKeys("Test@12");
	System.out.println("TC15 Verify_that_the_system_displays_data_input_field_for_Registration_number_Student_name_Narration |Success:");

	}

//********************************************************************************************************************************
@Test(priority = 102)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify that when user inputs a wrong registration number and clicks get student details the system is able to give a line error of registration number does not exist")
public void Verify_that_when_user_inputs_a_wrong_registration_number_and_clicks_get_student_details_the_system_is_able_to_give_a_line_error_of_registration_number_does_not_exist()
	    throws InterruptedException {
	//test =extent.createTest(" 16 Verify that when user inputs a wrong registration number and clicks get student details the system is able to give a line error of registration number does not exist");

	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	    dropdown.findElement(By.xpath("//option[. = 'School ID']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).sendKeys("883");
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL")).click();
	WebDriverWait wait3 = new WebDriverWait(driver, 15);
	wait3.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("NEXT")));
	driver.findElement(By.linkText("NEXT")).click();
	WebDriverWait wait2 = new WebDriverWait(driver, 15);
	wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")));
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")).sendKeys("DMS05 R D8");
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-SEARCH_STUDENT")).click();
	driver.findElement(By.xpath("//a[@class='btn  ct_btn_neg ct-right-btn dialogBtnOk']")).click();
	System.out.println(
		"TC16 Verify_that_when_user_inputs_a_wrong_registration_number_and_clicks_get_student_details_the_system_is_able_to_give_a_line_error_of_registration_number_does_not_exist |Success:");
}

//********************************************************************************************************************************
@Test(priority = 103)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify that the narration input field is alphanumeric and can take a maximum of 40 characters")
public void Verify_that_the_narration_input_fieldis_alphanumeric_and_can_take_a_maximum_of_40_characters()
	    throws InterruptedException {
	//test =extent.createTest(" 17 Verify that the narration input field is alphanumeric and can take a maximum of 40 characters");

	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	    dropdown.findElement(By.xpath("//option[. = 'School ID']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).sendKeys("883");
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("NEXT")).click();
	WebDriverWait wait2 = new WebDriverWait(driver, 15);
	wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")));
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")).sendKeys("DMS05 R D1");
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-SEARCH_STUDENT")).click();
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-NARRATION")).sendKeys("Test@12terstegsfdrefsreuikjhyterstendsju");
	System.out.println("TC17 Verify_that_the_narration_input_fieldis_alphanumeric_and_can_take_a_maximum_of_40_characters |Success:");
	}
//********************************************************************************************************************************
@Test(priority = 104)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify that the system displays save student details tab")
public void Verify_that_the_system_displays_save_student_details_tab() throws InterruptedException {
	//test =extent.createTest(" 18 Verify that the system displays save student details tab");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_SAVED_STUDENT_DETAILS")).click();
	System.out.println("TC18 Verify_that_the_system_displays_save_student_details_tab |Success:");

}
//********************************************************************************************************************************
@Test(priority = 105)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify that user is able to click on the next tab and move to the account details page")
public void Verify_that_user_is_able_to_click_on_the_next_tab_and_move_to_the_account_details_page() throws InterruptedException {
	//test =extent.createTest(" 19 Verify that user is able to click on the next tab and move to the account details page");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	    dropdown.findElement(By.xpath("//option[. = 'School ID']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).sendKeys("883");
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("NEXT")).click();
	WebDriverWait wait2 = new WebDriverWait(driver, 15);
	wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")));
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")).sendKeys("DMS05 R D1");
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-SEARCH_STUDENT")).click();
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-NARRATION")).click();
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-NARRATION")).sendKeys("test@qw");
	driver.findElement(By.linkText("NEXT")).click();
	System.out.println("TC19 Verify_that_user_is_able_to_click_on_the_next_tab_and_move_to_the_account_details_page |Success:");

}
//********************************************************************************************************************************

@Test(priority = 106)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify that user is able to select debit account from a dropdown")
public void Verify_that_user_is_able_to_select_debit_account_from_a_dropdown() throws InterruptedException {
	//test =extent.createTest(" 20 Verify that user is able to select debit account from a dropdown");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	    dropdown.findElement(By.xpath("//option[. = 'School ID']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).sendKeys("883");
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("NEXT")).click();
	WebDriverWait wait5 = new WebDriverWait(driver, 15);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")));
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")).sendKeys("DMS05 R D1");
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-SEARCH_STUDENT")).click();

	driver.findElement(By.id("FORM_SF_STUDENT_INFO-NARRATION")).sendKeys("DMS05 R D1");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-DEBIT_ACC_NO")).sendKeys("01105413334100");
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-DEBIT_ACC_NO")).click();
	System.out.println("TC20 Verify_that_user_is_able_to_select_debit_account_from_a_dropdown |Success:");

}
//********************************************************************************************************************************

@Test(priority = 107)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify that the currency for the account to debit is displayed in the currency icon")
public void Verify_that_the_currency_for_the_account_to_debit_is_displayed_in_the_currency_icon()
	    throws InterruptedException {
	//test =extent.createTest(" 21 Verify that the currency for the account to debit is displayed in the currency icon");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	    dropdown.findElement(By.xpath("//option[. = 'School ID']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).sendKeys("883");
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("NEXT")).click();
	WebDriverWait wait5 = new WebDriverWait(driver, 15);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")));
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")).sendKeys("DMS05 R D1");
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-SEARCH_STUDENT")).click();

	driver.findElement(By.id("FORM_SF_STUDENT_INFO-NARRATION")).sendKeys("DMS05 R D1");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-DEBIT_ACC_NO")).sendKeys("01105413334100");
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-DEBIT_ACC_NO")).click();
	{
	    List<WebElement> elements = driver.findElements(By.xpath("//span[@name=\'TRANSFER_CURRENCY\']"));
	    assert (elements.size() > 0);
	}
	System.out.println("TC21 Verify_that_the_currency_for_the_account_to_debit_is_displayed_in_the_currency_icon |Success:");

}

//********************************************************************************************************************************
@Test(priority = 108)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify that user is able to key in amount to pay on the fee amount to pay input field")
public void Verify_that_user_is_able_to_key_in_amount_to_pay_on_the_fee_amount_to_pay_input_field()
	    throws InterruptedException {
	//test =extent.createTest(" 22 Verify that user is able to key in amount to pay on the fee amount to pay input field");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	    dropdown.findElement(By.xpath("//option[. = 'School ID']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).sendKeys("883");
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("NEXT")).click();
	WebDriverWait wait5 = new WebDriverWait(driver, 15);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")));
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")).sendKeys("DMS05 R D1");
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-SEARCH_STUDENT")).click();

	driver.findElement(By.id("FORM_SF_STUDENT_INFO-NARRATION")).sendKeys("DMS05 R D1");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-DEBIT_ACC_NO")).sendKeys("01105413334100");
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-DEBIT_ACC_NO")).click();
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-PAYMENT_AMOUNT")).click();
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-PAYMENT_AMOUNT")).sendKeys("2000");
	System.out.println("TC22 Verify_that_user_is_able_to_key_in_amount_to_pay_on_the_fee_amount_to_pay_input_fieldn |Success:");

}

//********************************************************************************************************************************
@Test(priority = 109)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify that amount to pay limit is at Ksh 500000 per transaction")
public void Verify_that_amount_to_pay_limit_is_at_Ksh_500000_per_transaction() throws InterruptedException {
	//test =extent.createTest(" 23 Verify that amount to pay limit is at Ksh 500000 per transaction");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	    dropdown.findElement(By.xpath("//option[. = 'School ID']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).sendKeys("883");
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("NEXT")).click();
	WebDriverWait wait5 = new WebDriverWait(driver, 15);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")));
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")).sendKeys("DMS05 R D1");
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-SEARCH_STUDENT")).click();

	driver.findElement(By.id("FORM_SF_STUDENT_INFO-NARRATION")).sendKeys("DMS05 R D1");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-DEBIT_ACC_NO")).sendKeys("01105413334100");

	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-PAYMENT_AMOUNT")).click();
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-PAYMENT_AMOUNT")).clear();
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-PAYMENT_AMOUNT")).sendKeys("500001");
	driver.findElement(By.linkText("NEXT")).click();
	{
	    List<WebElement> elements = driver.findElements(By.cssSelector(".ct-model__panel-body"));
	    assert (elements.size() > 0);
	}

	driver.findElement(By.xpath("//a[@class='btn  ct_btn_neg ct-right-btn dialogBtnOk']")).click();
	System.out.println("TC23 Verify_that_amount_to_pay_limit_is_at_Ksh_500000_per_transaction |Success:");

}

//********************************************************************************************************************************
@Test(priority = 110)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify that when a customer cancels the request after putting the transaction details the user is taken to the home")
public void Verify_that_when_a_customer_cancels_the_request_after_putting_the_transaction_details_the_user_is_taken_to_the_home()
	    throws InterruptedException {
	//test =extent.createTest(" 24 Verify that when a customer cancels the request after putting the transaction details the user is taken to the home");

	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	    dropdown.findElement(By.xpath("//option[. = 'School ID']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).sendKeys("883");
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("NEXT")).click();
	WebDriverWait wait5 = new WebDriverWait(driver, 15);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")));
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")).sendKeys("DMS05 R D1");
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-SEARCH_STUDENT")).click();

	driver.findElement(By.id("FORM_SF_STUDENT_INFO-NARRATION")).sendKeys("DMS05 R D1");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-DEBIT_ACC_NO")).sendKeys("01105413334100");

	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-PAYMENT_AMOUNT")).click();
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-PAYMENT_AMOUNT")).clear();
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-PAYMENT_AMOUNT")).sendKeys("20000");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.linkText("CANCEL")).click();
	System.out.println("TC24 Verify_that_when_a_customer_cancels_the_request_after_putting_the_transaction_details_the_user_is_taken_to_the_home |Success:");
}

//********************************************************************************************************************************
@Test(priority = 111)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify that user is able to click the next button and a summary page is display")
public void Verify_that_user_is_able_to_click_the_next_button_and_a_summary_page_is_displayed()
	    throws InterruptedException {
	//test =extent.createTest(" 25 Verify that user is able to click the next button and a summary page is displayed");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	    dropdown.findElement(By.xpath("//option[. = 'School ID']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).sendKeys("883");
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("NEXT")).click();
	WebDriverWait wait5 = new WebDriverWait(driver, 15);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")));
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")).sendKeys("DMS05 R D1");
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-SEARCH_STUDENT")).click();

	driver.findElement(By.id("FORM_SF_STUDENT_INFO-NARRATION")).sendKeys("DMS05 R D1");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-DEBIT_ACC_NO")).sendKeys("01105413334100");

	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-PAYMENT_AMOUNT")).click();
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-PAYMENT_AMOUNT")).clear();
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-PAYMENT_AMOUNT")).sendKeys("20000");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(.,\'Summary\')]")).click();
	System.out.println("TC25 Verify_that_user_is_able_to_click_the_next_button_and_a_summary_page_is_displayed |Success:");

}

//********************************************************************************************************************************
@Test(priority = 112)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify that on the summary page the following are displayed Pay fees details Amount registration number student name narration institution name Debit account bank charge excise duty Total debit amount")
public void Verify_that_on_the_summary_page_the_following_are_displayed_Pay_fees_details_Amount_registration_number_student_name_narration_institution_name_Debit_account_bank_charge_excise_duty_Total_debit_amount()
	    throws InterruptedException {
	//test =extent.createTest(" 26 Verify that on the summary page the following are displayed Pay fees details Amount registration number student name narration institution name Debit account bank charge excise duty Total debit amount");

	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	    dropdown.findElement(By.xpath("//option[. = 'School ID']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).sendKeys("883");
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("NEXT")).click();
	WebDriverWait wait5 = new WebDriverWait(driver, 15);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")));
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")).sendKeys("DMS05 R D1");
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-SEARCH_STUDENT")).click();

	driver.findElement(By.id("FORM_SF_STUDENT_INFO-NARRATION")).sendKeys("DMS05 R D1");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-DEBIT_ACC_NO")).sendKeys("01105413334100");

	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-PAYMENT_AMOUNT")).click();
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-PAYMENT_AMOUNT")).clear();
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-PAYMENT_AMOUNT")).sendKeys("20000");
	driver.findElement(By.linkText("NEXT")).click();
	{
	    List<WebElement> elements = driver.findElements(By.xpath("//span[contains(.,\'Amount\')]"));
	    assert (elements.size() > 0);
	}
	{
	    List<WebElement> elements = driver.findElements(By.xpath("//span[contains(.,\'Registration Number\')]"));
	    assert (elements.size() > 0);
	}
	{
	    List<WebElement> elements = driver.findElements(By.xpath("//span[contains(.,\'Student Name\')]"));
	    assert (elements.size() > 0);
	}
	{
	    List<WebElement> elements = driver.findElements(By.xpath("//span[contains(.,\'Narration\')]"));
	    assert (elements.size() > 0);
	}
	{
	    List<WebElement> elements = driver.findElements(By.xpath("//span[contains(.,\'Institution\')]"));
	    assert (elements.size() > 0);
	}
	{
	    List<WebElement> elements = driver.findElements(By.xpath("//span[contains(.,\'Account\')]"));
	    assert (elements.size() > 0);
	}
	{
	    List<WebElement> elements = driver.findElements(By.xpath("//span[contains(.,\'Bank Charge\')]"));
	    assert (elements.size() > 0);
	}
	{
	    List<WebElement> elements = driver.findElements(By.xpath("//span[contains(.,\'Excise Duty\')]"));
	    assert (elements.size() > 0);
	}
	{
	    List<WebElement> elements = driver.findElements(By.xpath("//span[contains(.,\'Total Debit Amount\')]"));
	    assert (elements.size() > 0);
	}
	System.out.println(
		"TC26 Verify_that_on_the_summary_page_the_following_are_displayed_Pay_fees_details_Amount_registration_number_student_name_narration_institution_name_Debit_account_bank_charge_excise_duty_Total_debit_amount |Success:");
}

//********************************************************************************************************************************
@Test(priority = 113)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify that user is able to submit the payment by clicking on the Pay")
public void Verify_that_user_is_able_to_submit_the_payment_by_clicking_on_the_Pay() throws InterruptedException {
	//test =extent.createTest(" 27 Verify that user is able to submit the payment by clicking on the Pay");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	    dropdown.findElement(By.xpath("//option[. = 'School ID']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).sendKeys("883");
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL")).click();
	Thread.sleep(2000);
	;
	driver.findElement(By.linkText("NEXT")).click();
	WebDriverWait wait5 = new WebDriverWait(driver, 15);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")));
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")).sendKeys("DMS05 R D1");
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-SEARCH_STUDENT")).click();

	driver.findElement(By.id("FORM_SF_STUDENT_INFO-NARRATION")).sendKeys("DMS05 R D1");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-DEBIT_ACC_NO")).sendKeys("01105413334100");

	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-PAYMENT_AMOUNT")).click();
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-PAYMENT_AMOUNT")).clear();
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-PAYMENT_AMOUNT")).sendKeys("20000");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("PAY")).click();
	driver.findElement(By.xpath("//span[contains(.,\'Verify Transaction\')]")).click();
	System.out.println("TC27 Verify_that_user_is_able_to_submit_the_payment_by_clicking_on_the_Pay |Success:");

}

//********************************************************************************************************************************
@Test(priority = 114)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Severity(SeverityLevel.CRITICAL)
@Step ("Verify_that_user_is_not_able_to_proceed_with_transaction_if_they_dont_enter_the_OTP")
public void Verify_that_user_is_not_able_to_proceed_with_transaction_if_they_dont_enter_the_OTP()
	    throws InterruptedException {
	//test =extent.createTest(" 28 Verify that user is not able to proceed with transaction if they dont enter the OTP");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	    dropdown.findElement(By.xpath("//option[. = 'School ID']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).sendKeys("883");
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("NEXT")).click();
	WebDriverWait wait5 = new WebDriverWait(driver, 15);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")));
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")).sendKeys("DMS05 R D1");
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-SEARCH_STUDENT")).click();

	driver.findElement(By.id("FORM_SF_STUDENT_INFO-NARRATION")).sendKeys("DMS05 R D1");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-DEBIT_ACC_NO")).sendKeys("01105413334100");

	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-PAYMENT_AMOUNT")).click();
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-PAYMENT_AMOUNT")).clear();
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-PAYMENT_AMOUNT")).sendKeys("20000");
	driver.findElement(By.linkText("NEXT")).click();
	driver.findElement(By.linkText("PAY")).click();
	driver.findElement(By.linkText("Submit")).click();
	{
	    List<WebElement> elements = driver.findElements(By.xpath("//span[@type=\'Error_Msg_Position\']"));
	    assert (elements.size() > 0);
	}
	System.out.println("TC28 Verify_that_user_is_not_able_to_proceed_with_transaction_if_they_dont_enter_the_OTP( |Success:");

}

//********************************************************************************************************************************
@Test(priority = 115)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("Verify_that_user_is_able_to_proceed_with_transaction_when_they_enter_a_valid_OTP")
@Severity(SeverityLevel.BLOCKER)
public void Verify_that_user_is_able_to_proceed_with_transaction_when_they_enter_a_valid_OTP()
	    throws InterruptedException {
	//test =extent.createTest(" 29 Verify that user is able to proceed with transaction when they enter a valid OTP");
	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	WebDriverWait wait1 = new WebDriverWait(driver, 15);
	wait1.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Institutional Payments ']")));
	driver.findElement(By.xpath("//div[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//div[@class='col-in schoolFee']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	{
	    WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	    dropdown.findElement(By.xpath("//option[. = 'School ID']")).click();
	}
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).sendKeys("883");
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("NEXT")).click();
	WebDriverWait wait5 = new WebDriverWait(driver, 15);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")));
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")).sendKeys("DMS05 R D1");
	driver.findElement(By.id("FORM_SF_STUDENT_INFO-SEARCH_STUDENT")).click();

	driver.findElement(By.id("FORM_SF_STUDENT_INFO-NARRATION")).sendKeys("DMS05 R D1");
	driver.findElement(By.linkText("NEXT")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-DEBIT_ACC_NO")).sendKeys("01105413334100");

	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-PAYMENT_AMOUNT")).click();
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-PAYMENT_AMOUNT")).clear();
	driver.findElement(By.id("FORM_SF_PAYMENT_INFO-PAYMENT_AMOUNT")).sendKeys("20000");
	driver.findElement(By.linkText("NEXT")).click();
	WebDriverWait wait2 = new WebDriverWait(driver, 15);
	wait2.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("PAY")));
	driver.findElement(By.linkText("PAY")).click();
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_1")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_2")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_3")).sendKeys("3");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_4")).sendKeys("2");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_5")).sendKeys("1");
	driver.findElement(By.id("OTP_FORM-OTP_INPUT_6")).sendKeys("1");
	driver.findElement(By.linkText("Submit")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[text()=' Ok ']")).click();
	System.out.println("TC29 Verify_that_user_is_able_to_proceed_with_transaction_when_they_enter_a_valid_OTP( |Success:");

}

//********************************************************************************************************************************

@Test(priority = 116)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "SCHOOL FEES PAYMENTS") })
@Step ("END OF SCHOOL FEES TEST CASES")
@Severity(SeverityLevel.TRIVIAL)
public void End_Bills_school_fees_Test_cases() {
	//test =extent.createTest("END OF SCHOOL FEES TEST CASES");
	System.out.println("*************************End Bills School feesTestcases***********************************");

}
//********************************************************************************************************************************

@Test(priority = 86)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "RENT PAYMENT") })
@Step ("RENT PAYMENT")
@Severity(SeverityLevel.TRIVIAL)
public void Running_Rent_payment_Test_cases() {
	//test =extent.createTest("RUNNING RENT PAYMENT TESTCASES");
	System.out.println("*************************Running Rent payment Testcases***********************************");

}
//********************************************************************************************************************************
@Test(priority = 117)
@Epic("BILLS PAYMENT")
@Features(value = { @Feature(value = "RENT PAYMENT") })
@Severity(SeverityLevel.MINOR)
@Step ("Verify_that_user_is_able_to_view_the_Rent_Payment_menu_under_bill_payments")
public void Verify_that_user_is_able_to_view_the_Rent_Payment_menu_under_bill_payments() throws IOException {
    	//test =extent.createTest(" 1 Verify_that_user_is_able_to_view_the_Rent_Payment_menu_under_bill_payments");
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
  driver.findElement(By.linkText("Bill Payment")).click();
  driver.findElement(By.xpath("//*[text()=' Institutional Payments ']")).click();
  driver.findElement(By.xpath("//div[@onclick=\"schoolFees(\'RENTPAY\')\"]")).click();
}

  // ***********************************************************************************************************************************

  @Test(priority = 118)
  @Epic("BILLS PAYMENT")
  @Features(value = { @Feature(value = "RENT PAYMENT") })
  @Severity(SeverityLevel.MINOR)
  @Step ("Verify_that_the_user_can_click_on_the_Rent_Payment_menu")
  public void Verify_that_the_user_can_click_on_the_Rent_Payment_menu() {
      //test =extent.createTest(" 2 Verify_that_the_user_can_click_on_the_Rent_Payment_menu");
   driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));	
    driver.findElement(By.linkText("Bill Payment")).click();
    driver.findElement(By.cssSelector(".card:nth-child(11) > .bill-body")).click();
     driver.findElement(By.xpath("//*[text()=' Rent Payment ']")).click(); 
  }

    // ***********************************************************************************************************************************
  @Test(priority = 119)
  @Epic("BILLS PAYMENT")
  @Features(value = { @Feature(value = "RENT PAYMENT") })
  @Step ("Verify_that_when_the_user_is_able_to_view_new_payment_and_saved_Tenant_details_menu")
  public void Verify_that_when_the_user_is_able_to_view_new_payment_and_saved_Tenant_details_menu() {
      //test =extent.createTest("3 Verify_that_when_the_user_is_able_to_view_new_payment_and_saved_Tenant_details_menu");
	    driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
		driver.findElement(By.linkText("Bill Payment")).click();
		driver.findElement(By.xpath("//*[text()=' Institutional Payments ']")).click();
	     driver.findElement(By.xpath("//*[text()=' Rent Payment ']")).click();
	    driver.findElement(By.xpath("//button[contains(.,\'New Payment\')]")).click();
	    driver.findElement(By.xpath("//button[contains(.,\'Saved Tenant Details\')]")).click();
  }
  // ***********************************************************************************************************************************
  @Test(priority = 120)
  @Epic("BILLS PAYMENT")
  @Features(value = { @Feature(value = "RENT PAYMENT") })
  @Step ("Verify_that_user_is_able_to_click_on_new_payment_menu")
  public void Verify_that_user_is_able_to_click_on_new_payment_menu() {
      //test =extent.createTest(" 4 Verify_that_user_is_able_to_click_on_new_payment_menu");
	   driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
		driver.findElement(By.linkText("Bill Payment")).click();
	    {
	      WebElement element = driver.findElement(By.linkText("Bill Payment"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    {
	      WebElement element = driver.findElement(By.tagName("body"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	    }
	    driver.findElement(By.xpath("//*[text()=' Institutional Payments ']")).click();
	     driver.findElement(By.xpath("//*[text()=' Rent Payment ']")).click();
	    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_NEW_PAYMENT")).click();  
  
}    
  // ***********************************************************************************************************************************
  @Test(priority = 121)
  @Epic("BILLS PAYMENT")
  @Features(value = { @Feature(value = "RENT PAYMENT") })
  @Step ("Verify_that_the_new_payment_menu_is_highlighted_when_active")
  public void Verify_that_the_new_payment_menu_is_highlighted_when_active1() {
      //test =extent.createTest(" 5 Verify_that_the_new_payment_menu_is_highlighted_when_active1");
	    driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
		driver.findElement(By.linkText("Bill Payment")).click();
		driver.findElement(By.xpath("//*[text()=' Institutional Payments ']")).click();
	     driver.findElement(By.xpath("//*[text()=' Rent Payment ']")).click();
	    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_NEW_PAYMENT")).click();
	  }
  
  // ***********************************************************************************************************************************

  @Test(priority = 122)
  @Epic("BILLS PAYMENT")
  @Features(value = { @Feature(value = "RENT PAYMENT") })
  @Step ("Verify_the_user_is_able_to_view_the_search_by_input_field")
  public void Verify_the_user_is_able_to_view_the_search_by_input_field1() {
      //test =extent.createTest(" 6 Verify_the_user_is_able_to_view_the_search_by_input_field1");
	    driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
		driver.findElement(By.linkText("Bill Payment")).click();
		driver.findElement(By.xpath("//*[text()=' Institutional Payments ']")).click();
	     driver.findElement(By.xpath("//*[text()=' Rent Payment ']")).click();
	    driver.findElement(By.xpath("//span[contains(.,\'Search By\')]")).click();
	  }  
  // ***********************************************************************************************************************************
  @Test(priority = 123)  
  @Epic("BILLS PAYMENT")
  @Features(value = { @Feature(value = "RENT PAYMENT") })
  @Step ("Verify_the_user_is_able_to_click_the_search_landlord_Tab")
  public void Verify_the_user_is_able_to_click_the_search_landlord_Tab() {
      //test =extent.createTest(" 7 Verify_the_user_is_able_to_click_the_search_landlord_Tab");
	    driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
		driver.findElement(By.linkText("Bill Payment")).click();
		driver.findElement(By.xpath("//*[text()=' Institutional Payments ']")).click();
	    driver.findElement(By.cssSelector(".schoolFee")).click();
	    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL")).click();
	  }   
  // ***********************************************************************************************************************************
  @Test(priority = 124) 
  @Epic("BILLS PAYMENT")
  @Features(value = { @Feature(value = "RENT PAYMENT") })
  @Step ("Verify_that_when_user_clicks_on_search_by_tab_acnumber_and_Business_number_options_are_displayed")
  public void Verify_that_when_user_clicks_on_search_by_tab_acnumber_and_Business_number_options_are_displayed() {
      //test =extent.createTest(" 8 Verify_that_when_user_clicks_on_search_by_tab_acnumber_and_Business_number_options_are_displayed");
	   driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
		driver.findElement(By.linkText("Bill Payment")).click();
		driver.findElement(By.xpath("//*[text()=' Institutional Payments ']")).click();
	     driver.findElement(By.xpath("//*[text()=' Rent Payment ']")).click();
	    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	    {
	      WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	      dropdown.findElement(By.xpath("//option[. = 'Account Number']")).click();
	    }
	    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	    {
	      WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	      dropdown.findElement(By.xpath("//option[. = 'Business Number']")).click();
	    }
	    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	  } 
  
  // ***********************************************************************************************************************************
  @Test(priority = 125) 
  @Epic("BILLS PAYMENT")
  @Features(value = { @Feature(value = "RENT PAYMENT") })
  @Step ("Verify_that_customer_is_able_to_select_Account_number_options")
  public void Verify_that_customer_is_able_to_select_Account_number_options1() {
      //test =extent.createTest("9 Verify_that_customer_is_able_to_select_Account_number_options1");
	    driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
		driver.findElement(By.linkText("Bill Payment")).click();
		driver.findElement(By.xpath("//*[text()=' Institutional Payments ']")).click();
	     driver.findElement(By.xpath("//*[text()=' Rent Payment ']")).click();
	    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	    {
	      WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	      dropdown.findElement(By.xpath("//option[. = 'Account Number']")).click();
	    }
	    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	  }
  
  
  // ***********************************************************************************************************************************
  @Test(priority = 126)
  @Epic("BILLS PAYMENT")
  @Features(value = { @Feature(value = "RENT PAYMENT") })
  @Step ("Verify_that_customer_is_able_to_select_Business_number_options")
  public void Verify_that_customer_is_able_to_select_Business_number_options() {
      //test =extent.createTest(" 10 Verify_that_customer_is_able_to_select_Business_number_options");
	    driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
		driver.findElement(By.linkText("Bill Payment")).click();
		driver.findElement(By.xpath("//*[text()=' Institutional Payments ']")).click();
	    driver.findElement(By.xpath("//*[text()=' Rent Payment ']")).click();
	    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	    {
	      WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
	      dropdown.findElement(By.xpath("//option[. = 'Business Number']")).click();
	    }
	    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
	  }
  // ***********************************************************************************************************************************

  @Test (priority = 127) 
  @Epic("BILLS PAYMENT")
  @Features(value = { @Feature(value = "RENT PAYMENT") })
  @Step ("Verify_that_the_correct_name_account_number_is_displayed_when_user_clicks_search_for_landlord_tab_after_keying_in_the_Business_number")
  public void Verify_that_the_correct_name_account_number_is_displayed_when_user_clicks_search_for_landlord_tab_after_keying_in_the_Business_number() {
      //test =extent.createTest("11 Verify_that_the_correct_name_account_number_is_displayed_when_user_clicks_search_for_landlord_tab_after_keying_in_the_Business_number");  
      driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
		driver.findElement(By.linkText("Bill Payment")).click();
		driver.findElement(By.xpath("//*[text()=' Institutional Payments ']")).click();
	    driver.findElement(By.xpath("//*[text()=' Rent Payment ']")).click();
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
    {
      WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
      dropdown.findElement(By.xpath("//option[. = 'Business Number']")).click();
    }
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).click();
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).sendKeys("2614");
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL")).click();
    driver.findElement(By.id("lbl_SCHOOL_NAME")).click();
    driver.findElement(By.id("lbl_SCHOOL_ACCOUNT_NUMBER")).click();
  }
  // ***********************************************************************************************************************************

  @Test (priority = 128) 
  @Epic("BILLS PAYMENT")
  @Features(value = { @Feature(value = "RENT PAYMENT") })
  @Step ("Verify_that_when_user_selects_Account_number_option_the_system_will_display_an_account_number_input_field")
  public void Verify_that_when_user_selects_Account_number_option_the_system_will_display_an_account_number_input_field() {
      //test =extent.createTest(" 12 Verify_that_when_user_selects_Account_number_option_the_system_will_display_an_account_number_input_field");
	  driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
		driver.findElement(By.linkText("Bill Payment")).click();
		driver.findElement(By.xpath("//*[text()=' Institutional Payments ']")).click();
	    driver.findElement(By.xpath("//*[text()=' Rent Payment ']")).click();
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
    {
      WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
      dropdown.findElement(By.xpath("//option[. = 'Account Number']")).click();
    }
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
    driver.findElement(By.id("lbl_SF_ACCOUNT_NUMBER")).click();
  }
  // ***********************************************************************************************************************************

  @Test (priority = 129) 
  @Epic("BILLS PAYMENT")
  @Features(value = { @Feature(value = "RENT PAYMENT") })
  @Step ("Verify_that_user_can_input_the_14_digits_account_number")
  public void Verify_that_user_can_input_the_14_digits_account_number1() {
      //test =extent.createTest(" 13 Verify_that_user_can_input_the_14_digits_account_number1");
	  driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
		driver.findElement(By.linkText("Bill Payment")).click();
		driver.findElement(By.xpath("//*[text()=' Institutional Payments ']")).click();
	    driver.findElement(By.xpath("//*[text()=' Rent Payment ']")).click();
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
    {
      WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
      dropdown.findElement(By.xpath("//option[. = 'Account Number']")).click();
    }
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_ACCOUNT_NUMBER")).click();
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_ACCOUNT_NUMBER")).sendKeys("01136099595900");
  }
  // ***********************************************************************************************************************************

  @Test (priority = 130) 
  @Epic("BILLS PAYMENT")
  @Features(value = { @Feature(value = "RENT PAYMENT") })
  @Step ("Verify_that_user_is_able_to_click_on_the_search_for_landlord_functionality")
  public void Verify_that_user_is_able_to_click_on_the_search_for_landlord_functionality() {
      //test =extent.createTest(" 14 Verify_that_user_is_able_to_click_on_the_search_for_landlord_functionality");
	  driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
		driver.findElement(By.linkText("Bill Payment")).click();
		driver.findElement(By.xpath("//*[text()=' Institutional Payments ']")).click();
	    driver.findElement(By.xpath("//*[text()=' Rent Payment ']")).click();
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
    {
      WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
      dropdown.findElement(By.xpath("//option[. = 'Business Number']")).click();
    }
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).click();
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).sendKeys("2614");
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL")).click();
  }
  // ***********************************************************************************************************************************

  @Test (priority = 131)
  @Epic("BILLS PAYMENT")
  @Features(value = { @Feature(value = "RENT PAYMENT") })
  @Step ("Verify_that_system_is_able_to_search_and_display_correct_name_Business_code_when_user_click_on_search_for_Landlord_functionality")
  public void Verify_that_system_is_able_to_search_and_display_correct_name_Business_code_when_user_click_on_search_for_Landlord_functionality() {
      //test =extent.createTest("15 Verify_that_system_is_able_to_search_and_display_correct_name_Business_code_when_user_click_on_search_for_Landlord_functionality");  
      driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
		driver.findElement(By.linkText("Bill Payment")).click();
		driver.findElement(By.xpath("//*[text()=' Institutional Payments ']")).click();
	    driver.findElement(By.xpath("//*[text()=' Rent Payment ']")).click();
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
    {
      WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
      dropdown.findElement(By.xpath("//option[. = 'Business Number']")).click();
    }
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).click();
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).sendKeys("2614");
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL")).click();
    driver.findElement(By.id("lbl_SCHOOL_NAME")).click();
    driver.findElement(By.id("lbl_SCHOOL_ACCOUNT_NUMBER")).click();
  }
  // ***********************************************************************************************************************************

  @Test (priority = 132) 
  @Epic("BILLS PAYMENT")
  @Features(value = { @Feature(value = "RENT PAYMENT") })
  @Step ("Verify_that_system_displays_the_Business_number_input_field_when_user_selects_search_by_Business_number_option")
  public void Verify_that_system_displays_the_Business_number_input_field_when_user_selects_search_by_Business_number_option() {
      //test =extent.createTest("16 Verify_that_system_displays_the_Business_number_input_field_when_user_selects_search_by_Business_number_option");
	  driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
		driver.findElement(By.linkText("Bill Payment")).click();
		driver.findElement(By.xpath("//*[text()=' Institutional Payments ']")).click();
	    driver.findElement(By.xpath("//*[text()=' Rent Payment ']")).click();
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
    {
      WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
      dropdown.findElement(By.xpath("//option[. = 'Business Number']")).click();
    }
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
    driver.findElement(By.xpath("//span[contains(.,\'Business Number\')]")).click();
  }
  // ***********************************************************************************************************************************

  @Test (priority = 133) 
  @Epic("BILLS PAYMENT")
  @Features(value = { @Feature(value = "RENT PAYMENT") })
  @Step ("Verify_that_user_is_able_to_input_Business_number_on_the_Business_number_input_fields_when_he_she_selects_the_Business_number_options ")
  public void Verify_that_user_is_able_to_input_Business_number_on_the_Business_number_input_fields_when_he_she_selects_the_Business_number_options() {
      	//test =extent.createTest(" 17 Verify_that_user_is_able_to_input_Business_number_on_the_Business_number_input_fields_when_he_she_selects_the_Business_number_options  \r\n" +  	"");
      	driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
	driver.findElement(By.linkText("Bill Payment")).click();
	driver.findElement(By.xpath("//*[text()=' Institutional Payments ']")).click();
	driver.findElement(By.xpath("//*[text()=' Rent Payment ']")).click();
	driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
    {
      WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
      dropdown.findElement(By.xpath("//option[. = 'Business Number']")).click();
    }
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).click();
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).sendKeys("2614");
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL")).click();
  }
  // ***********************************************************************************************************************************

  @Test (priority = 134) 
  @Epic("BILLS PAYMENT")
  @Features(value = { @Feature(value = "RENT PAYMENT") })
  @Step ("Verify_that_the_Business_number_input_field_is_4digit")
  public void Verify_that_the_Business_number_input_field_is_4digit() {
      //test =extent.createTest(" 18 Verify_that_the_Business_number_input_field_is_4digit");  
      driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
		driver.findElement(By.linkText("Bill Payment")).click();
		driver.findElement(By.xpath("//*[text()=' Institutional Payments ']")).click();
	    driver.findElement(By.xpath("//*[text()=' Rent Payment ']")).click();
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
    {
      WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
      dropdown.findElement(By.xpath("//option[. = 'Business Number']")).click();
    }
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).click();
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).sendKeys("2614");
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL")).click();
  }
  // ***********************************************************************************************************************************

  @Test (priority = 135) 
  @Epic("BILLS PAYMENT")
  @Features(value = { @Feature(value = "RENT PAYMENT") })
  @Step ("Verify_that_the_system_displays_data_input_field_for_House_number_tenant_name_and_Narration")
  public void Verify_that_the_system_displays_data_input_field_for_House_number_tenant_name_and_Narration() throws InterruptedException {
      //test =extent.createTest(" 19 Verify_that_the_system_displays_data_input_field_for_House_number_tenant_name_and_Narration ");   
      driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
		driver.findElement(By.linkText("Bill Payment")).click();
		driver.findElement(By.xpath("//*[text()=' Institutional Payments ']")).click();
	    driver.findElement(By.xpath("//*[text()=' Rent Payment ']")).click();
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
    {
      WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
      dropdown.findElement(By.xpath("//option[. = 'Business Number']")).click();
    }
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).click();
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).sendKeys("2614");
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL")).click();
    Thread.sleep(3000);
    driver.findElement(By.linkText("NEXT")).click();
    driver.findElement(By.xpath("//span[contains(.,\'House Number\')]")).click();
    driver.findElement(By.xpath("//label[contains(.,\'Narration\')]")).click();
    driver.findElement(By.xpath("//span[contains(.,\'Tenant Name\')]")).click();
  }
  // ***********************************************************************************************************************************

  @Test (priority = 136) 
  @Epic("BILLS PAYMENT")
  @Features(value = { @Feature(value = "RENT PAYMENT") })
  
    @Step ("Verify_that_below_data_input_fields_are_mandatory_fields_1HouseNumber_2TenantName_3Narrationfield")
  public void Verify_that_below_data_input_fields_are_mandatory_fields_1HouseNumber_2TenantName_3Narrationfield() throws InterruptedException {
      //test =extent.createTest(" 20 Verify_that_below_data_input_fields_are_mandatory_fields_1HouseNumber_2TenantName_3Narrationfield");    
      driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Payment")));
		driver.findElement(By.linkText("Bill Payment")).click();
		driver.findElement(By.xpath("//*[text()=' Institutional Payments ']")).click();
	    driver.findElement(By.xpath("//*[text()=' Rent Payment ']")).click();
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
    {
      WebElement dropdown = driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY"));
      dropdown.findElement(By.xpath("//option[. = 'Business Number']")).click();
    }
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL_BY")).click();
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SF_CODE")).sendKeys("2614");
    driver.findElement(By.id("FORM_SF_SCHOOL_INFO-SEARCH_SCHOOL")).click();
    Thread.sleep(3000);
    driver.findElement(By.linkText("NEXT")).click();
    driver.findElement(By.id("FORM_SF_STUDENT_INFO-REGISTRATION_NUMBER")).sendKeys("214");
    driver.findElement(By.id("FORM_SF_STUDENT_INFO-STUDENT_NAME")).sendKeys("Test");
    driver.findElement(By.id("FORM_SF_STUDENT_INFO-NARRATION")).sendKeys("Test");
  }

//**********************************************************************************************************************************
	
  @Test(priority = 61)
  @Epic("BILLS PAYMENT")
  @Features(value = { @Feature(value = "RENT PAYMENT") })
  @Step ("Verify_that_user_is_able_to_view_the_Rent_Payment_menu_under_bill_payments")
  public void End_Of_Card_Module_Testcases() throws IOException, InterruptedException {
	//test =extent.createTest("END OF  CARD MODULE TESTCASES");
	System.out.println("*************************End of  Card Module TestCases***********************************");
  }
//  @AfterMethod
//  public void getResult(ITestResult result) throws Exception
//  {
//  	if(result.getStatus() == ITestResult.FAILURE)
//  	{
//  		//MarkupHelper is used to display the output in different colors
//  		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
//  		test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
//
//  		//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
//  		//We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method. 
//
//  		//	String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
//  		String screenshotPath = TakeScreenshot(driver, result.getName());
//  		//To add it in the extent report 
//
//  		test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));
//
//
//  	}
//  	else if(result.getStatus() == ITestResult.SKIP){
//  		//logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
//  		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
//  	} 
//  	else if(result.getStatus() == ITestResult.SUCCESS)
//  	{
//  		test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
//  	}
//
//  }
//
//  public static String TakeScreenshot(WebDriver driver, String screenshotName) throws IOException {
//  	String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//  	TakesScreenshot ts = (TakesScreenshot) driver;
//  	File source = ts.getScreenshotAs(OutputType.FILE);
//  	// after execution, you could see a folder "FailedTestsScreenshots" under src folder
//  	String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
//  	File finalDestination = new File(destination);
//  	FileUtils.copyFile(source, finalDestination);
//  	return destination;
//  }
  }