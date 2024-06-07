package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends Utilities{


	WebDriver driver;
	public CartPage (WebDriver driver) {
		super(driver);
		this.driver = driver;
		if (!this.verifyTitle(title)) throw new AssertionError("Previous step did not go to Cart Page");
		PageFactory.initElements(driver, this);
	}

	public final String title = "Automation Exercise - Checkout";
	@FindBy (id="empty_cart")
	private WebElement emptyCartMessage;
	
	public WebElement getCartProductByNumber(int i) {
		String productNumber = String.valueOf(i);
		return driver.findElement(By.id("product-"+productNumber));
	}
	
	public String getCartProductName(WebElement product){
		return product.findElement(By.cssSelector("h4 a")).getText(); 
	}
	
	public String getCartProductPrice(WebElement product) {
		return product.findElement(By.cssSelector("td[class ='cart_price'] p")).getText();
	}
	
	public int getCartProductQuantity (WebElement product) {
		String productQuantity = product.findElement(By.tagName("button")).getText();
		return Integer.parseInt(productQuantity);
	}

	public String getProductNameByIndex(int i) {
		return getCartProductName(getCartProductByNumber(i));
	}

	public String getProductPriceByIndex(int i) {
		return getCartProductPrice(getCartProductByNumber(i));
	}

	public int getProductQuantityByIndex(int i) {
		return getCartProductQuantity(getCartProductByNumber(i));

	}


}
