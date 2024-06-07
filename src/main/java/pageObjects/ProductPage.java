package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Utilities {
	WebDriver driver;

	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		if (!this.verifyTitle(title)) throw new AssertionError("Previous step did not go to Product Page");
		PageFactory.initElements(driver, this);
	}

	public final String title = "Automation Exercise - Product Details";

	@FindBy(css = ".product-information button")
	private WebElement addToCartButton;
	@FindBy(xpath = "//b[text() = 'Availability:']/..")
	private WebElement productAvailability;
	@FindBy(xpath = "//b[text() = 'Brand:']/..")
	private WebElement productBrand;
	@FindBy(css = ".product-information p")
	private WebElement productCategory;
	@FindBy(xpath = "//b[text() = 'Condition:']/..")
	private WebElement productCondition;
	@FindBy(css = ".product-information h2")
	private WebElement productName;
	@FindBy(css = ".product-information span span")
	private WebElement productPrice;
	@FindBy(css = ".product-information span input[id='quantity']")
	private WebElement productQuantity;

	public boolean containsProductAvailability() {
		String Avail = productAvailability.getText().replace("Availability:", "");
		return !Avail.isBlank();
	}
	public boolean containsProductBrand() {
		String brand = productBrand.getText().replace("Brand:", "");
		return !brand.isBlank();
	}
	public boolean containsProductCategory() {
		String category = productCategory.getText().replace("Category:", "");
		return !category.isBlank();
	}
	public boolean containsProductCondition() {
		String condition = productCondition.getText().replace("Condition:", "");
		return !condition.isBlank();
	}
	public boolean containsProductName() {
		return !productName.getText().isBlank();
	}
	public boolean containsProductPrice() {
		String price = productPrice.getText().replace("Rs.", "");
		return !price.isBlank();
	}

}