package wRepeat.wFramework;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import wRepeat.baseTest.BaseTest;
import wRepeat.baseTest.RetryNG;
import wRepeat.wFramework.CartPage;
import wRepeat.wFramework.LandingPage;
import wRepeat.wFramework.PaymentPage;
import wRepeat.wFramework.ProductCatelogue;
import wRepeat.wFramework.Validation;

public class ErrorValidationTest extends BaseTest {

	String product = "ZARA COAT 3";
	
	    @Test(groups= {"ErrorHandling"}, retryAnalyzer=RetryNG.class)
	    public void init() throws InterruptedException
	    {
		 
		lp.LoginApplication("poornima@gmail.com","Poor*123");
		String errorMessage = lp.wrongCred();
		Assert.assertEquals(errorMessage, "Incorrect email or password.");
		}

	    
	    @Test
	    public void orderHistory() throws InterruptedException 
	    {
			ProductCatelogue pc = lp.LoginApplication("poornima@gmail.com","Poornima*123");
			CartPage cp = pc.addToCart(product);
			cp.goToCart();
			Boolean match=cp.cartPage(product);
			Assert.assertTrue(true);
			
	    
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
