package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class AllProductsPage extends Utilities{
	WebDriver driver;
	public AllProductsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
        if (!this.verifyTitle(title)) throw new AssertionError("Previous step did not go to Products Page");
	}
	public final String title = "Automation Exercise - All Products";
	private final String expectedSearchTitleText = "SEARCHED PRODUCTS";

	private final By allProducts = By.className("productinfo");
	private final By continueButton = By.cssSelector("button[data-dismiss='modal']");
	private final By searchButton = By.id("submit_search");
	private final By searchInput = By.id("search_product");
	private final By searchTitleText = By.cssSelector(".title.text-center");
	private final By viewCartButton = By.cssSelector("a[href='/view_cart'] u");
	private final By viewFirstProductButton = By.cssSelector(".choose a");

	private final By addToCart_product = By.cssSelector(".btn.btn-default.add-to-cart");
	private final By productName_product = By.tagName("p");
	private final By productPrice_product= By.tagName("h2");

	public void addProductToCartByIndex (int number) {
		addProductToCart(getAllProducts().get(number-1));
	}
	
	public void addProductToCart(WebElement product) {
		scrollToElement(product);
		Actions a = new Actions(driver);
		WebElement addToCartButton = product.findElement(addToCart_product);
		a.moveToElement(addToCartButton).click().moveToLocation(0, 0).build().perform();
	}
	
	public void clickContinueShopping() {
		waitForElement(driver.findElement(continueButton));
		driver.findElement(continueButton).click();
	}
	
	public List<WebElement> getAllProducts (){
		return driver.findElements(allProducts);
	}
	public String getProductName(WebElement product){
		WebElement productName = product.findElement(productName_product);
		return productName.getText();
	}
	public List<String> getProductsNames (List<WebElement> products){
		return products.stream().map(this::getProductName).toList();
	}
	public String getProductPrice(WebElement product) {
		return product.findElement(productPrice_product).getText();
	}
//	 public int getProductQuantity (WebElement product) {
//		return 1;
//	}
	
	public String getProductNameByIndex(int i) {
		return getProductName(driver.findElements(allProducts).get(i-1));
	}
	public String getProductPriceByIndex(int i) {
		return getProductPrice(driver.findElements(allProducts).get(i-1));
	}

	public void searchForProduct (String term) {
		driver.findElement(searchInput).sendKeys(term);
		driver.findElement(searchButton).click();
	}
	
	public boolean verifyProductsPresent() {
		return !driver.findElements(allProducts).isEmpty();
	}

	//filters visible elements by search term and compares results
	//will not determine if products containing term were missed
	public boolean verifySearch (String term) {
		List<String> allProductNames= getProductsNames(driver.findElements(allProducts));
		if (allProductNames.isEmpty()) return false;
		List<String> filteredNames = allProductNames.stream().filter(p -> p.contains(term)).toList();
        return allProductNames.equals(filteredNames);
	}
	
	public boolean verifySearchText() {
		return driver.findElement(searchTitleText).getText().contentEquals(expectedSearchTitleText);
	}
	
	public void viewCart() {
		waitForElement(driver.findElement(viewCartButton));
		driver.findElement(viewCartButton).click();
	}
	
	public void viewFirstProduct () {
		waitForElement(driver.findElement(viewFirstProductButton));
		scrollToElement(driver.findElement(viewFirstProductButton));
		driver.findElement(viewFirstProductButton).click();
	}

}
