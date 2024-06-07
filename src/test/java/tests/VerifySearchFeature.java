package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AllProductsPage;
import pageObjects.LandingPage;

public class VerifySearchFeature extends BaseTest{
	
	@Test
	public void verifySearchFunction() {
		final String searchTerm = "blue";
		WebDriver driver = initializeDriver();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.headerGoToProducts();

		AllProductsPage allProductsPage = new AllProductsPage(driver);
		allProductsPage.searchForProduct(searchTerm);
		Assert.assertTrue(allProductsPage.verifySearchText());
		Assert.assertTrue(allProductsPage.verifySearch(searchTerm));
		driver.close();
	}

}
