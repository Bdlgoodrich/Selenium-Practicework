package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.ProductPage;
import pageObjects.AllProductsPage;

public class VerifyProductPageDetails extends BaseTest{

	@Test
	public void verifyProductPageDetails() {
		WebDriver driver = initializeDriver();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.headerGoToProducts();

		AllProductsPage allProductsPage = new AllProductsPage(driver);
		Assert.assertTrue(allProductsPage.verifyProductsPresent());
		allProductsPage.viewFirstProduct();

		ProductPage productPage = new ProductPage(driver);
		Assert.assertTrue(productPage.containsProductName());
		Assert.assertTrue(productPage.containsProductCategory());
		Assert.assertTrue(productPage.containsProductPrice());
		Assert.assertTrue(productPage.containsProductAvailability());
		Assert.assertTrue(productPage.containsProductCondition());
		Assert.assertTrue(productPage.containsProductBrand());
		driver.close();
	}

}
