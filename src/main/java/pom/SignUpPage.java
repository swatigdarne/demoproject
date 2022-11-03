package pom;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

	
	@FindBy (xpath="//a[text()=\"Don't have an account? Signup now!\"]") private WebElement usersign;
	@FindBy (xpath="//input[@name='mobile']") private WebElement mobilnum;
	@FindBy (xpath="//button[@type='submit']") private WebElement cont;

public SignUpPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public void sign(WebDriver driver) throws InterruptedException 
{
	usersign.click();
	Set<String> handle=driver.getWindowHandles();
	//System.out.println(handle);
	Iterator<String> i=handle.iterator();
	while(i.hasNext())
	{
	String adress = i.next();
	Thread.sleep(2000);
		driver.switchTo().window(adress);
		String title="Signup and open a Zerodha trading and demat account online and start investing – Zerodha";
	String curtit=driver.getTitle();
  //System.out.println(curtit);
	if(title.equals(curtit))
	{
		mobilnum.sendKeys("9309122768");
		cont.click();
	}
	}
}
}