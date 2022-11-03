package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.chromeBrowser;
import pom.zerodhaBuy;
import pom.zerodhaHomePage;
import pom.zerodhaloginpage;
import utility.Report;
import utility.excel;
@Listeners(samplelistener.class)
public class zerodhaGomepageTest extends BaseTest {
	//WebDriver driver;
	@BeforeTest
	public void configureReport()
	{
		extent=Report.generateReports();
	}
	@BeforeMethod
	public void zerodhaloginTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		listenerReport.CreateTest("LoginWithVerifyingdata");
		driver=chromeBrowser.openBrowser();
		zerodhaloginpage login=new zerodhaloginpage(driver);
	String user=	excel.getData("credential", 0, 0);
	String pass=excel.getData("credential", 1, 0);
	String pin=excel.getData("credential", 2, 0);
		login.enterUserId(user);
		login.enterPassword(pass);
		login.clickSubmit();
		Thread.sleep(2000);
		login.enterPin(driver,pin);
		login.conti();
		zerodhaHomePage home=new zerodhaHomePage(driver);
		Thread.sleep(2000);
		home.searchStock(driver,"Tata");
		home.searchStockFromSearchList(driver, "TATAMOTORS");
	}
	
//	public void searchStock()
//	{
//		zerodhaHomePage srch=new zerodhaHomePage(driver);
//		srch.searchStock(driver, "TATAMOTORS");
//		int size=zerodhaHomePage.getSearchListSize();
//		Assert.assertTrue(size>0);
//		srch.searchStockFromSearchList(driver, "TATAMOTORS");
//	}
@Test
	public void ToclickBuy() throws InterruptedException
	{
	listenerReport.CreateTest("Verifying intraday");
	Thread.sleep(3000);
		zerodhaBuy cl=new zerodhaBuy(driver);
		cl.buys();
	}
@Test(enabled=false)
public void buyLmt() throws InterruptedException
{
	listenerReport.CreateTest("Verifying Limit");
	Thread.sleep(2000);
	zerodhaBuy lm=new zerodhaBuy(driver);
	lm.lmt();
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
