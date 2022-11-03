package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class zerodhaloginpage {

	@FindBy (xpath="//input[@id='userid']") private WebElement userId;
	@FindBy(xpath="//input[@id='password']")private WebElement pass;
	@FindBy(xpath="//button[@type='submit']")private WebElement submit;
	@FindBy(xpath="//input[@id='pin']")private WebElement pinnumber;
	@FindBy(xpath="//button[@type='submit']")private WebElement continu;
	@FindBy(xpath="//a[text()='Don't have an account? Signup now!']")private WebElement signup;
	@FindBy(xpath="//a[text()='Forgot user ID or password?']")private WebElement forgot;
	//@FindBy(xpath="//a[text()='Forgot user ID or password?']")private WebElement search;
	@FindBy(xpath="//span[@class='tradingsymbol']")private WebElement searching;
	
	public zerodhaloginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void enterUserId(String user)
	{
		userId.sendKeys(user);
		//System.out.println(user);
	}
	public void enterPassword(String password)
	{
		pass.sendKeys(password);
	}
	public void enterPin(WebDriver driver,String pin)
	{
//	WebDriverWait wait=new	WebDriverWait(driver,Duration.ofMillis(3000)); //explicite
//	wait.until(ExpectedConditions.visibilityOf(pinnumber));
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofMillis(3000));
		wait.pollingEvery(Duration.ofMillis(4000));
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOf(pinnumber));
		pinnumber.sendKeys(pin);
	}
	public void conti()
	{
		continu.click();
	}
	public void clickSubmit()
	{
		submit.click();
	}
	public void clickSign()
	{
		signup.click();
	}
	public void clickForgot()
	{
		forgot.click();
	}
	public void search()
	{
	}

}
