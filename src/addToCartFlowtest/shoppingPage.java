package addToCartFlowtest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;




public class shoppingPage {
	
	WebDriver driver;
	WebElement dropDown;
	Select productSortDropDown;
	By dropDownLocator= By.xpath("//select[@class='product_sort_container']");
	By addToCart1Locator= By.xpath("//div[@class='inventory_item'][1]/div/div[@class='pricebar']/button");
	By addToCart2Locator= By.xpath("//div[@class='inventory_item'][1]/following-sibling::div[1]/div/div[@class='pricebar']/button");
	By addToCartLocator= By.xpath("//a[@class='shopping_cart_link']");
	By item1=By.xpath("//div[@class='inventory_item'][1]  //div[@class='inventory_item_name ']");
	By item2= By.xpath("//div[@class='inventory_item'][1]/following-sibling::div[1] //div[@class='inventory_item_name ']");
	String currentURL;
	
	shoppingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public List<String> selectItems() throws InterruptedException
	{
		dropDown=driver.findElement(dropDownLocator);
		productSortDropDown=new Select(dropDown);
		productSortDropDown.selectByValue("lohi");
		
		WebElement addToCart1= driver.findElement(addToCart1Locator);
		WebElement addToCart2=driver.findElement(addToCart2Locator);
		
		addToCart1.click();
		System.out.println("clicked");
		addToCart2.click();
		System.out.println("clicked");
		
		List<String> items=getItemNames();
		
		driver.findElement(addToCartLocator).click();
		currentURL=driver.getCurrentUrl();
		items.add(currentURL);
		Thread.sleep(10000);
		return items;
		
	}
	public List<String> getItemNames()
	{
		String firstItem= driver.findElement(item1).getText();
		String secondItem=driver.findElement(item2).getText();
		List<String> items= new ArrayList<String>();
		items.add(firstItem);
		items.add(secondItem);
		return items;
	}
	
	

}
