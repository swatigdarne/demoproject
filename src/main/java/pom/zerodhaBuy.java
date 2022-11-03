package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class zerodhaBuy {
	@FindBy (xpath="//label[@class='su-radio-label'][1]")private WebElement bseClick;
	@FindBy(xpath="//label[text()='Intraday ']")private WebElement intra;
	@FindBy(xpath="//label[text()='Market']")private WebElement mark;
	@FindBy(xpath="//button[@class='submit']")private WebElement buyBtn;
	@FindBy(xpath="//input[@type='number'][1]")private WebElement buyQty;
	@FindBy(xpath="//label[text()='Limit']")private WebElement buylimt;
	@FindBy(xpath="//input[@label=\"Price\"]")private WebElement buypr;
	@FindBy (xpath="//input[@icon='search']")private WebElement search;
	public zerodhaBuy(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void buys() throws InterruptedException
	{
		bseClick.click();
		Thread.sleep(1000);
		intra.click();
		Thread.sleep(1000);
		buyQty.sendKeys("3");
		Thread.sleep(1000);
		mark.click();
		Thread.sleep(1000);
		buyBtn.click();
	}
	public void lmt() throws InterruptedException
	{
		bseClick.click();
		Thread.sleep(1000);
		intra.click();
		Thread.sleep(1000);
		buyQty.sendKeys("3");
		Thread.sleep(1000);
		buypr.sendKeys("4");
		Thread.sleep(1000);
		buylimt.click();
		Thread.sleep(1000);
		buyBtn.click();
	}
	

}
