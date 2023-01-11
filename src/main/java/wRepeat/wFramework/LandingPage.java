package wRepeat.wFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComp;

public class LandingPage extends AbstractComp{

	WebDriver driver;
	
    public LandingPage(WebDriver driver)
    {
      super(driver);	
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
    }
	
	@FindBy(id="userEmail")
	WebElement uname;
	
	@FindBy(id="userPassword")
	WebElement pwd;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css=".ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error")
	WebElement error;
	
	
	public void goTo()
	{
	driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public ProductCatelogue LoginApplication(String username, String password)
	{
	uname.sendKeys(username);
	pwd.sendKeys(password);
	submit.click();
	ProductCatelogue pc = new ProductCatelogue(driver);
	return pc;
	}
	
	
	public String wrongCred()
	{
	 String errorMessage=error.getText();
	 return errorMessage;
	}
	
}
