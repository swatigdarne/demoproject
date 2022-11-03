package test;



import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import utility.screenshot;

public class samplelistener extends BaseTest implements ITestListener {
	
	public void onTestStart(ITestResult result)
	{
		System.out.println("Test Started "+result.getName());
	}
	public void onTestSuccess(ITestResult result)
	{
//		try {
//			screenshot.takesScreenShort(driver, result.getName());
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
	System.out.println("Test Successed "+result.getName());
	}
	public void onTestFailure(ITestResult result) 
	{
		try {
			screenshot.takesScreenShort(driver, result.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Test Failure "+result.getName());

	System.out.println("Test Failure "+result.getName());
}
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Test skipped"+result.getName());
	}
	

}
