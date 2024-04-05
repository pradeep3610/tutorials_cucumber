package stepDefinitions;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;

public class ProductSearch {
	
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	
	SearchPage sp;
	
	@When("the user search for a product \\(productName: {string})")
	public void the_user_search_for_a_product_product_name(String product) {
	   
		hp=new HomePage(BaseClass.getDriver());
		hp.enterProductName(product);
		hp.clickSearch();
		
	}

	@When("the user clicks on the required product from search result")
	public void the_user_clicks_on_the_required_product_from_search_result() {
		
	    sp= new SearchPage(BaseClass.getDriver());
	    
	    sp.selectProduct();	    
		
	}
	
	@When("the user navigates to the product details page and updates quantity \\(quantity: {string})")
	public void the_user_navigates_to_the_product_details_page_and_updates_quantity_quantity(String quantity) throws InterruptedException {
	   
		sp.setQuantity(quantity);
	}

	@When("the user clicks on Add to cart button")
	public void the_user_clicks_on_add_to_cart_button() {
	   
		sp.addToCart();
	}

	@Then("the user should see a message Added to cart Successfully")
	public void the_user_should_see_a_message_added_to_cart_successfully() throws InterruptedException {
	   sp.checkConfMsg();
	   Thread.sleep(2000);
	}
	
		
	

}
