package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends Utilities {
	WebDriver driver;

	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		if (!this.verifyTitle(title)) throw new AssertionError("Previous step did not go to Product Page");
	}

	public final String title = "Automation Exercise - Product Details";

	private final By addToCartButton = By.cssSelector(".product-information button");
	private final By productAvailability = By.xpath("//b[text() = 'Availability:']/..");
	private final By productBrand = By.xpath("//b[text() = 'Brand:']/..");
	private final By productCategory = By.cssSelector(".product-information p");
	private final By productCondition = By.xpath("//b[text() = 'Condition:']/..");
	private final By productName = By.cssSelector(".product-information h2");
	private final By productPrice = By.cssSelector(".product-information span span");
	private final By productQuantity = By.cssSelector(".product-information span input[id='quantity']");

	public boolean containsProductAvailability() {
		String Avail = driver.findElement(productAvailability).getText().replace("Availability:", "");
		return !Avail.isBlank();
	}
	public boolean containsProductBrand() {
		String brand = driver.findElement(productBrand).getText().replace("Brand:", "");
		return !brand.isBlank();
	}
	public boolean containsProductCategory() {
		String category = driver.findElement(productCategory).getText().replace("Category:", "");
		return !category.isBlank();
	}
	public boolean containsProductCondition() {
		String condition = driver.findElement(productCondition).getText().replace("Condition:", "");
		return !condition.isBlank();
	}
	public boolean containsProductName() {
		return !driver.findElement(productName).getText().isBlank();
	}
	public boolean containsProductPrice() {
		String price = driver.findElement(productPrice).getText().replace("Rs.", "");
		return !price.isBlank();
	}

}