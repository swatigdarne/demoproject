package utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class screenshot {
	public static void takesScreenShort(WebDriver driver,String name) throws Exception {
		//WebDriver driver1=browser1.openBrowser("https://vctcpune.com/selenium/practice.html");
		 DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy h-m-s");
	        Date date = new Date();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
        File destination=new File("C:\\selinium\\screenshort\\"+name+"-"+dateFormat.format(date)+".png");
        //System.out.println(destination);
        FileHandler.copy(source, destination);

	}

}
