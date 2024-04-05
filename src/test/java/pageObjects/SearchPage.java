package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage
{   
	WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		super(driver);
	}	
	
		@FindBy(xpath="//div[@class=\"caption\"]//a")
		List<WebElement> searchProducts;
				
		@FindBy(xpath="//input[@id='input-quantity']")
		WebElement txtquantity;
		
		@FindBy(xpath="//button[@id='button-cart']")
		WebElement btnaddToCart;
		
		@FindBy(xpath="//div[contains(text(),'Success: You have added')]")
		WebElement cnfMsg;
		
		public void selectProduct()
		{
			
			
			for(int i=0;i<searchProducts.size();i++)
			{		
				
				String prod_avl = searchProducts.get(i).getText();
				System.err.println(prod_avl);
				if(prod_avl.equals("MacBook Air"))
				{
					searchProducts.get(i).click();
				}
				
			}
		
		}
		
		public void setQuantity(String qty) throws InterruptedException
		{
			Thread.sleep(2000);
			txtquantity.clear();
			
			Thread.sleep(2000);
			txtquantity.sendKeys(qty);
		}
		
		public void addToCart()
		{
			btnaddToCart.click();
		}
		
		public boolean checkConfMsg()
		{
			try
			{
			return cnfMsg.isDisplayed();
			}
			catch(Exception e)
			{
				return false;
			}
		}
		
}

