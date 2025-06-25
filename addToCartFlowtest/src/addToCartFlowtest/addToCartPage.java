package addToCartFlowtest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class addToCartPage {
	
	WebDriver driver;
	By addToCartItems= By.xpath("//div[@class='inventory_item_name']");
	
	public addToCartPage(WebDriver driver) {
		
		this.driver=driver;
	}
	public boolean validateAddToCartPage(List<String> items)
	{
		List<WebElement> cartItems=driver.findElements(addToCartItems);
		System.out.println(cartItems.size());
		
		for(WebElement i: cartItems)
		{
			if(!items.contains(i.getText()))
			{
				System.out.println(i.getText());
				return false;
			}
		}
		return true;
		
	}

}
