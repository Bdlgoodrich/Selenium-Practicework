package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.LandingPage;

public class VerifySubscribeBanner extends BaseTest{
	@Test
	public void subscribeFromLanding() {
		String email = "email@email.com";

		WebDriver driver = initializeDriver();
		LandingPage landingPage = new LandingPage(driver);

//		Verify email subscription feature works from landing page
		landingPage.scrollToBottom();
		Assert.assertTrue(landingPage.verifyBannerSubscribeText());
		landingPage.inputBannerSubscribeEmail(email);
		landingPage.clickBannerSubmitButton();
		Assert.assertTrue(landingPage.verifyBannerSubscriptionSubmissionText());

//		Verify email subscription feature works from cart page
		landingPage.headerGoToCart();
		CartPage cartPage = new CartPage(driver);
		cartPage.scrollToBottom();
		Assert.assertTrue(landingPage.verifyBannerSubscribeText());
		landingPage.inputBannerSubscribeEmail(email);
		landingPage.clickBannerSubmitButton();
		Assert.assertTrue(landingPage.verifyBannerSubscriptionSubmissionText());
		driver.close();
	}

}
