package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AllProductsPage;
import pageObjects.CartPage;
import pageObjects.LandingPage;

public class VerifyProductsAddedToCart extends BaseTest{

	@Test
	public void addItemsFromProductsPage() throws InterruptedException {
		WebDriver driver = initializeDriver();
		LandingPage landingPage = new LandingPage(driver);

		landingPage.headerGoToProducts();
		AllProductsPage allProductsPage = new AllProductsPage(driver);
		String firstProductName = allProductsPage.getProductNameByIndex(1);
		String firstProductPrice = allProductsPage.getProductPriceByIndex(1);
		int firstProductQuantity = 0;
		allProductsPage.addProductToCartByIndex(1);
		firstProductQuantity ++;
		allProductsPage.clickContinueShopping();
		String secondProductName = allProductsPage.getProductNameByIndex(2);
		String secondProductPrice = allProductsPage.getProductPriceByIndex(2);
		int secondProductQuantity = 0;
		allProductsPage.addProductToCartByIndex(2);
		secondProductQuantity ++;

		allProductsPage.viewCart();
		CartPage cartPage = new CartPage(driver);
		String firstCartProductName = cartPage.getProductNameByIndex(1);
		String firstCartProductPrice = cartPage.getProductPriceByIndex (1);
		int firstCartProductQuantity = cartPage.getProductQuantityByIndex (1);
		String secondCartProductName = cartPage.getProductNameByIndex(2);
		String secondCartProductPrice = cartPage.getProductPriceByIndex (2);
		int secondCartProductQuantity = cartPage.getProductQuantityByIndex (2);
		Assert.assertEquals(firstCartProductName,firstProductName);
		Assert.assertEquals(firstCartProductPrice,firstProductPrice);
		Assert.assertEquals(firstCartProductQuantity,firstProductQuantity);
		Assert.assertEquals(secondCartProductName,secondProductName);
		Assert.assertEquals(secondCartProductPrice,secondProductPrice);
		Assert.assertEquals(secondCartProductQuantity,secondProductQuantity);
		driver.close();
	}

}
