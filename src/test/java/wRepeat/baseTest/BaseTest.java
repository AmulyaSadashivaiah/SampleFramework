package wRepeat.baseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import wRepeat.wFramework.LandingPage;

public class BaseTest {
   
	public WebDriver driver;
	public LandingPage lp;
	
	@Test
	public WebDriver initializeDriver() throws IOException
	{	
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Globaldata.properties");	
	Properties prop = new Properties();	
	prop.load(fis);	
	
	
  String browserName=System.getProperty("browser")!= null ? System.getProperty("browser") : prop.getProperty("browser");
   
     
    if(browserName.contains("chrome"))
    {   ChromeOptions opt = new ChromeOptions();
        if(browserName.contains("headless"))
        {
        	opt.setHeadless(true);
        }
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver(opt);
    }
    else if(browserName.contains("msedge"))
    {
    	EdgeOptions opt = new EdgeOptions();
    	if(browserName.contains("headless"))
    	{
    		opt.setHeadless(true);
    	}
    	WebDriverManager.edgedriver().setup();
    	driver = new EdgeDriver(opt);
    }
    else if(browserName.contains("firefox"))
    {
    	FirefoxOptions opt = new FirefoxOptions();
    	if(browserName.contains("headless"))
    	{
    		opt.setHeadless(true);
    	}
    	WebDriverManager.firefoxdriver().setup();
    	driver = new FirefoxDriver(opt);
    }
	
	
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	Dimension dim = new Dimension(2000,1000);
	driver.manage().window().setSize(dim);
	return driver;
	}
	
	
	
	
	
	public List<HashMap<String, String>> jsonToMap(String filePath) throws IOException
	{
	String getFileContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
	
	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String,String>> data=mapper.readValue(getFileContent, new TypeReference<List<HashMap<String,String>>>(){});
	return data;
	
	}
	
	
	
	
	
	
	
	
	public String getScreenShot(String testName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"//reports//"+testName+".png");
		FileUtils.copyFile(src, dest);
	    return System.getProperty("user.dir")+"//reports//"+testName+".png";
	}
	
	
	
	
	
	
	
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage LaunchApplication() throws IOException
	{
		driver=initializeDriver();
		lp = new LandingPage(driver);
		lp.goTo();
		return lp;
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.close();
	}
	
	
	
}
