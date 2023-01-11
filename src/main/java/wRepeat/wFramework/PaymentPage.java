package wRepeat.wFramework;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstractComponents.AbstractComp;

public class PaymentPage extends AbstractComp {

WebDriver driver;
	
    public PaymentPage(WebDriver driver)
    {
      super(driver);
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
    }
	
    @FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
    @FindBy(css=".ta-item.list-group-item.ng-star-inserted:last-of-type")
	WebElement countryName;
	
    @FindBy(css=".btnn.action__submit.ng-star-inserted")
	WebElement placeOrder;
	
	public Validation makePayment()
	{
    waitForElementToAppear(country);
	Actions a = new Actions(driver);
	a.sendKeys(country, "India").build().perform();
	waitForElementToAppear(countryName);
	countryName.click();
	placeOrder.click();
	Validation v = new Validation(driver);
	return v;
	}
	

	
	
	
}
