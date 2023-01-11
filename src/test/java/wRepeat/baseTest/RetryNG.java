package wRepeat.baseTest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryNG implements IRetryAnalyzer{

	int count=0;
	int max=2;
	
	
	@Override
	public boolean retry(ITestResult result) 
	{
		if(count<max)
		{
			count++;
			return true;
		}
		return false;
	}

	
	
	
	
	
	
	
	
	
	

}
