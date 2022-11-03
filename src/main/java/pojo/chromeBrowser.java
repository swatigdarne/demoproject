package pojo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class chromeBrowser {
	public static WebDriver openBrowser()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:\\selinium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://kite.zerodha.com/");
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS); //implicitly wait
		return driver;
	}

}
