package wRepeat.wFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComp;

public class OrderPage extends AbstractComp {

WebDriver driver;
	
    public OrderPage(WebDriver driver)
    {
      super(driver);
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
    }
	
	
    @FindBy(xpath="//tr[@class='ng-star-inserted']/td[2]")
	List<WebElement> orders;
	

	public Boolean checkOrders(String product)
	{   
		
	Boolean orderFound =orders.stream().anyMatch(a->a.getText().contains(product));
	return orderFound;	
	}
    
    
    
    
    
    
    
    
    
    
    
    

}
