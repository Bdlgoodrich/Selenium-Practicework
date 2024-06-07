package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class AllProductsPage extends Utilities{
	WebDriver driver;
	public AllProductsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
        if (!this.verifyTitle(title)) throw new AssertionError("Previous step did not go to Products Page");
		PageFactory.initElements(driver, this);
	}
	public final String title = "Automation Exercise - All Products";
	private final String expectedSearchTitleText = "SEARCHED PRODUCTS";
	
	@FindBy (className="productinfo")
	private List<WebElement> allProducts;
	@FindBy (css="button[data-dismiss='modal']")
	private WebElement continueButton;
	@FindBy (id="submit_search")
	private WebElement searchButton;
	@FindBy (id="search_product")
	private WebElement searchInput;
	@FindBy (css=".title.text-center")
	private WebElement searchTitleText;
	@FindBy (css="a[href='/view_cart'] u")
	private WebElement viewCartButton;
	@FindBy (css=".choose a")
	private WebElement viewFirstProductButton;

	public void addProductToCartByIndex (int number) {
		addProductToCart(allProducts.get(number-1));
	}
	
	public void addProductToCart(WebElement product) {
		scrollToElement(allProducts.getFirst());
		Actions a = new Actions(driver);
		WebElement addToCartButton = product.findElement(By.cssSelector(".btn.btn-default.add-to-cart"));
		a.moveToElement(addToCartButton).click().moveToLocation(0, 0).build().perform();
	}
	
	public void clickContinueShopping() {
		continueButton.click();
	}
	
	public List<WebElement> getProductList (){
		return driver.findElements(By.className("productinfo"));
	}
	public String getProductName(WebElement product){
		WebElement productName = product.findElement(By.tagName("p"));
		return productName.getText();
	}
	public List<String> getProductsNames (List<WebElement> products){
		return products.stream().map(this::getProductName).collect(Collectors.toList());
	}
	public String getProductPrice(WebElement product) {
		WebElement productPrice = product.findElement(By.tagName("h2"));
		return productPrice.getText();
	}
	public int getProductQuantity (WebElement product) {
		return 1;
	}
	
	public String getProductNameByIndex(int i) {
		return getProductName(allProducts.get(i-1));
	}
	public String getProductPriceByIndex(int i) {
		return getProductPrice(allProducts.get(i-1));
	}

	public int getIndexedProductQuantity(int i) {
		return getProductQuantity(allProducts.get(i-1));
	}

	public void searchForProduct (String term) {
		searchInput.sendKeys(term);
		searchButton.click();
	}
	
	public boolean verifyProductsPresent() {
		return !allProducts.isEmpty();
	}
	
	public boolean verifySearch (String term) {
		List<WebElement> searchProducts = getProductList();
		List<String> allProductNames= getProductsNames(allProducts);
		List<String> searchProductNames = getProductsNames(searchProducts);
        return allProductNames.equals(searchProductNames);
	}
	
	public boolean verifySearchText() {
		return searchTitleText.getText().contentEquals(expectedSearchTitleText);
	}
	
	public void viewCart() {
		waitForElement(viewCartButton);
		viewCartButton.click();
	}
	
	public void viewFirstProduct () {
		waitForElement(viewFirstProductButton);
		scrollToElement(viewFirstProductButton);
		viewFirstProductButton.click();
	}

}
