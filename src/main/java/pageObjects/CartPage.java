package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends Utilities{


	WebDriver driver;
	public CartPage (WebDriver driver) {
		super(driver);
		this.driver = driver;
		if (!this.verifyTitle(title)) throw new AssertionError("Previous step did not go to Cart Page");
	}

	public final String title = "Automation Exercise - Checkout";

	private final By emptyCartMessage = By.id("empty_cart");
	private final By productName_product = By.cssSelector("h4 a");
	private final By productPrice_product = By.cssSelector("td[class ='cart_price'] p");
	private final By productQuantity_product = By.tagName("button");

	public WebElement getCartProductByIndex(int i) {
		String productNumber = String.valueOf(i);
		return driver.findElement(By.id("product-"+productNumber));
	}
	
	public String getCartProductName(WebElement product){
		return product.findElement(productName_product).getText();
	}
	
	public String getCartProductPrice(WebElement product) {
		return product.findElement(productPrice_product).getText();
	}
	
	public int getCartProductQuantity (WebElement product) {
		String productQuantity = product.findElement(productQuantity_product).getText();
		return Integer.parseInt(productQuantity);
	}

	public String getProductNameByIndex(int i) {
		return getCartProductName(getCartProductByIndex(i));
	}

	public String getProductPriceByIndex(int i) {
		return getCartProductPrice(getCartProductByIndex(i));
	}

	public int getProductQuantityByIndex(int i) {
		return getCartProductQuantity(getCartProductByIndex(i));

	}


}
