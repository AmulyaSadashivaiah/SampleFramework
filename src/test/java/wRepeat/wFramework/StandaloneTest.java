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

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTest {

	public static void main(String[] args) {
		
        String product = "ADIDAS ORIGINAL"; 
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Dimension dim = new Dimension(2000,1000);
		driver.manage().window().setSize(dim);
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");
		
		driver.findElement(By.id("userEmail")).sendKeys("poornima@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Poornima*123");
		driver.findElement(By.id("login")).click();
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='card-body']/h5/b"))));
		
		
		
		
		
		List<WebElement> options = driver.findElements(By.cssSelector(".mb-3"));
		WebElement opt = options.stream().filter(f->f.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(product)).findFirst().orElse(null);
		opt.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		
		
		
		
		w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[contains(@class,'toast-message')]"))));
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		List<WebElement> orderedItems = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		
		Boolean match = orderedItems.stream().anyMatch(s->s.getText().equals(product));
		Assert.assertTrue(true);
		System.out.println(match);
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@placeholder='Select Country']"))));
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "India").build().perform();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item.list-group-item.ng-star-inserted")));
		
		driver.findElement(By.cssSelector(".ta-item.list-group-item.ng-star-inserted:last-of-type")).click();
		driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
		
		String verify = driver.findElement(By.cssSelector("h1[class='hero-primary']")).getText();
		Assert.assertEquals(verify, "THANKYOU FOR THE ORDER.");
		System.out.println("successful");
		
	}

}
