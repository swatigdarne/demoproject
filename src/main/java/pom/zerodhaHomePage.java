package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class zerodhaHomePage {
	@FindBy (xpath="//input[@icon='search']")private WebElement search;
	@FindBy(xpath="//span[@class='tradingsymbol']")private List<WebElement>stock;
	@FindBy(xpath="//button[@class='button-blue']")private WebElement buy;
	
	public zerodhaHomePage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	public void searchStock(WebDriver driver,String stockName)
	{
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(2000));
//		wait.until(ExpectedConditions.visibilityOf(search));
		search.sendKeys(stockName);
	}
	public void searchStockFromSearchList(WebDriver driver,String nameOfstock)
	{
		for(int i=0;i<stock.size();i++)
		{
			WebElement currentstock=stock.get(i);
		String name=currentstock.getText();
		
		if(name.equals(nameOfstock))
		{
			//System.out.println("1");
			Actions act=new Actions(driver);
			act.moveToElement(currentstock);
			act.perform();
			buy.click();
		}
			
		}
	}
	
//	public  int getSearchListSize()
//	{
//		int size=stock.size();
//		return size;
//	}
//	
	
	

}
