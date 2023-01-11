package abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComp {
  
WebDriver driver;
	
    public AbstractComp(WebDriver driver)
    {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
    }
	
    
    @FindBy(xpath="//button[@routerlink='/dashboard/cart']")
    WebElement gotoCart;
    
    @FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
    WebElement gotoOrder;
    
    
    public void waitForElementToAppear(WebElement find)
    {
    WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
    w.until(ExpectedConditions.visibilityOf(find));
    }
	
    public void waitForElementToDisappear(WebElement find) throws InterruptedException
    {
    	Thread.sleep(3000);
   // WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
   // w.until(ExpectedConditions.invisibilityOf(find));
    }
    
    
    
    
    
    public void goToOrder()
    {
    gotoOrder.click();
    }
    
    
    public void goToCart()
    {
    gotoCart.click();
    }
    
    
}
