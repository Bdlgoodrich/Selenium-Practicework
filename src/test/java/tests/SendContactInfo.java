package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.ContactPage;
import pageObjects.LandingPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SendContactInfo extends BaseTest{

	@DataProvider 
	public Object[][] contactData () throws IOException
	{
		List<HashMap<String,String>> data = getJsonDataToMap(contactDataLocation);  
		return new Object[][] {{data.getFirst()}};
	}

	
	@Test (dataProvider= "contactData")
	public void SendContactInfo(HashMap<String,String> contactInfo){
		WebDriver driver = initializeDriver();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.headerGoToContact();

		ContactPage contactPage = new ContactPage(driver);
		Assert.assertTrue(contactPage.verifyGetInTouchText());
		contactPage.inputContactInfo(contactInfo);
		contactPage.submitContactInfo();
		contactPage.acceptAlert();
		Assert.assertTrue(contactPage.verifySuccessText());

		contactPage.clickHomeButton();
		Assert.assertTrue(landingPage.verifyTitle(landingPage.title));
		driver.close();
	}

}
