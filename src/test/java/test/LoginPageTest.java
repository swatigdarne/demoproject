package test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.chromeBrowser;
import pom.SignUpPage;
import pom.zerodhaloginpage;
import utility.Report;
import utility.excel;
@Listeners(samplelistener.class)
public class LoginPageTest extends BaseTest {
//	ExtentReports extent;
//	ExtentTest test;
	Logger log=Logger.getLogger("LoginPageTest");
	
	@BeforeTest
	public void configureReport()
	{
		extent=Report.generateReports();
	}
	@BeforeMethod
	public void launchBrowser()
	{		driver=chromeBrowser.openBrowser();
	}
	@Test (priority=1)
	public void LoginzerodhaTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		PropertyConfigurator.configure("log4j.properties");
		log.info("login open");
		listenerReport.CreateTest("LoginWithVerifyingdata");
	//	test=extent.createTest("veryfying login page");
		String title=driver.getTitle();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(title,"Kite - Zerodha's fast and elegant flagship trading platfor");
		zerodhaloginpage loginpage=new zerodhaloginpage(driver);
		String user=excel.getData("credential", 0, 0);
		String pass=excel.getData("credential", 1, 0);
		String pin=excel.getData("credential", 2, 0);
		loginpage.enterUserId(user);
		log.info("username enter");
		loginpage.enterPassword(pass);
		log.info("password enter");
		loginpage.clickSubmit();
		loginpage.enterPin(driver,pin);
		loginpage.conti();
		soft.assertAll();
	}
	@Test(priority=2)
	public void signup() throws InterruptedException
	{
		PropertyConfigurator.configure("log4j.properties");
		log.info("signup open");
		test=extent.createTest("verifying signup");
	//Thread.sleep(3000);
		SignUpPage s=new SignUpPage(driver);
		s.sign(driver);
	}
	@AfterMethod
	public void postExecution(ITestResult result)
	{
		listenerReport.CollectResult(result);
	}
	@AfterTest
	public void publishReport()
	{
		extent.flush();
	}
}
