package wRepeat.wFramework;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wRepeat.baseTest.BaseTest;

public class SubmitOrderTest extends BaseTest {

	//String product = "ZARA COAT 3"; 
	
	    @Test(dataProvider="getData" ,groups={"Purchase"})
	    public void submitOrder(HashMap<String,String> input) throws InterruptedException
	    {
		ProductCatelogue pc = lp.LoginApplication(input.get("email"),input.get("password"));
		CartPage cp = pc.addToCart(input.get("product"));
		cp.goToCart();
		Boolean match=cp.cartPage(input.get("product"));
		Assert.assertTrue(true);
		System.out.println(match);
		PaymentPage pp = cp.checkOut();
		Validation v = pp.makePayment();
		String verify = v.validate();
		Assert.assertEquals(verify, "THANKYOU FOR THE ORDER.");
		System.out.println("successful");
		
		}

	    
	    @Test(dependsOnMethods={"submitOrder"})
	    public void orderHistory() 
	    {
	    	String product = "ZARA COAT 3"; 
	    	lp.LoginApplication("poornima@gmail.com","Poornima*123");
	    	lp.goToOrder();
	    	OrderPage op = new OrderPage(driver);
	    	Boolean orderFound = op.checkOrders(product);
	    	Assert.assertTrue(true);
	    
	    }
	    
	    
	    
	    
	    @DataProvider
	    public Object[][] getData() throws IOException
	    {
	    List<HashMap<String,String>> data=jsonToMap(System.getProperty("user.dir")+"src\\test\\java\\wRepeat\\json\\data\\inputdata.json");		
	    return new Object[][]{{data.get(0)},{data.get(1)}};
	    }
	    
	    
	    
	    
}
