package wRepeat.wFramework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractComponents.AbstractComp;

public class Validation extends AbstractComp {

WebDriver driver;
	
    public Validation(WebDriver driver)
    {
      super(driver);
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
    }
	
    @FindBy(css="h1[class='hero-primary']")
	WebElement message;
	
	
	public String validate()
	{
	
	String verify = message.getText();
	return verify;
	}
	
	
}
