package addToCartFlowtest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class loginPage {

	public static void main(String[] args) throws InterruptedException {
	
		String userName="standard_user";
		String password="secret_sauce";
		String logoName="Swag Labs";
		String actualURL;
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		String title=driver.getTitle();
		System.out.println(title);
		driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		String websiteName=driver.findElement(By.cssSelector(".app_logo")).getText();
		Assert.assertEquals(websiteName,logoName);
		
		shoppingPage sp= new shoppingPage(driver);
		List<String> items=sp.selectItems();
		actualURL=items.getLast();
		Assert.assertEquals(actualURL, "https://www.saucedemo.com/cart.html");
		
		items.removeLast();
		addToCartPage add=new addToCartPage(driver);
		Assert.assertTrue(add.validateAddToCartPage(items));
	}

}
