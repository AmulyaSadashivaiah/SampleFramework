package wRepeat.wFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractComponents.AbstractComp;

public class CartPage extends AbstractComp {

WebDriver driver;
	
    public CartPage(WebDriver driver)
    {
      super(driver);
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
    }
	
	
    @FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> orderedItems;
	
	
	public Boolean cartPage(String product)
	{
		Boolean match = orderedItems.stream().anyMatch(s->s.getText().equals(product));	
		return match;
	}
	
	
	public PaymentPage checkOut()
	{
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		PaymentPage pp = new PaymentPage(driver);
		return pp;
	}
	
	
	
	
	
	
	
	
}
