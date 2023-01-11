package resources;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {

	
	
	public static ExtentReports getReports()
	{
		String filePath = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(filePath);
		reporter.config().setReportName("Automate everything");
		reporter.config().setDocumentTitle("Ecommerce report");
		
		ExtentReports extent  = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Amulya");
		return extent;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
