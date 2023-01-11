package wRepeat.wFramework;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstractComponents.AbstractComp;

public class ProductCatelogue extends AbstractComp {

WebDriver driver;
	
    public ProductCatelogue(WebDriver driver)
    {
      super(driver);
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
    }
	
	
	@FindBy(xpath="//div[@class='card-body']/h5/b")
	WebElement wait1;
	
	@FindBy(xpath="//div[contains(@class,'toast-message')]")
	WebElement wait2;
	
	@FindBy(css=".mb-3")
	List<WebElement> options;
	
	
	By addtocart = By.cssSelector(".card-body button:last-of-type");
	
	By prod = By.cssSelector("b");
	
	
	
	public List<WebElement> getProductList()
	{
	waitForElementToAppear(wait1);
	return options;
	}
	
	public WebElement getProduct(String product)
	{
	WebElement opt = getProductList().stream().filter(f->f.findElement(prod).getText().equalsIgnoreCase(product)).findFirst().orElse(null);
	return opt;
	}
	
	public CartPage addToCart(String product) throws InterruptedException
	{
	WebElement opt = getProduct(product).findElement(addtocart);
	opt.click();
	waitForElementToDisappear(wait2);	
	CartPage cp = new CartPage(driver);
	return cp;
	}
	
	
	
	
	
	
}
