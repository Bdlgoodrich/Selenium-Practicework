package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.LandingPage;

public class VerifySubscribeFooter extends BaseTest{
	@Test
	public void subscribeFromLanding() {
		String email = "email@email.com";

		WebDriver driver = initializeDriver();
		LandingPage landingPage = new LandingPage(driver);

//		Verify email subscription feature works from landing page
		landingPage.scrollToBottom();
		Assert.assertTrue(landingPage.verifyFooterSubscribeText());
		landingPage.inputFooterSubscribeEmail(email);
		landingPage.clickFooterSubmitButton();
		Assert.assertTrue(landingPage.verifyFooterSubscriptionSubmissionText());

//		Verify email subscription feature works from cart page
		landingPage.headerGoToCart();
		CartPage cartPage = new CartPage(driver);
		cartPage.scrollToBottom();
		Assert.assertTrue(landingPage.verifyFooterSubscribeText());
		landingPage.inputFooterSubscribeEmail(email);
		landingPage.clickFooterSubmitButton();
		Assert.assertTrue(landingPage.verifyFooterSubscriptionSubmissionText());
		driver.close();
	}

}
