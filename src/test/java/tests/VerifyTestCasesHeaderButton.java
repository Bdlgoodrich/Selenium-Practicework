package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LandingPage;

public class VerifyTestCasesHeaderButton extends BaseTest{
	
	@Test
	public void verifyTestCasesPage() {
		WebDriver driver = initializeDriver();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.headerGoToTestCases();
		Assert.assertEquals(driver.getTitle(), "Automation Practice Website for UI Testing - Test Cases");
		driver.close();
	}

}
