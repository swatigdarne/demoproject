package test;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import test.BaseTest;

public class listenerReport  extends BaseTest{
	public static ExtentTest CreateTest(String TestName)
	{
		test=extent.createTest(TestName);
		return test;
	}
	public  static ExtentTest CollectResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
				test.log(Status.PASS, result.getName());
			}
			else if(result.getStatus()==ITestResult.FAILURE)
			{
				test.log(Status.FAIL, result.getName());
			}		else
			{
				test.log(Status.SKIP, result.getName());
			}
		return test;
		
	}
}
