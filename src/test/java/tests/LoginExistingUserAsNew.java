package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginExistingUserAsNew extends BaseTest {

	@DataProvider 
	public Object[][] existingUserLoginData () throws IOException
	{
		List<HashMap<String,String>> data = getJsonDataToMap(existingUserLoginInfoLocation);
		return new Object[][] {{data.getFirst()}};
	}

	
	@Test (dataProvider= "existingUserLoginData")
	public void LoginExistingUserAsNew(HashMap<String,String> input){

		WebDriver driver = initializeDriver();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.headerGoToLogin();

		LoginPage loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.verifyNewUserText());
		loginPage.inputNewUserInfo(input.get("name"), input.get("email"));
		loginPage.clickSignupButton();
		Assert.assertTrue(loginPage.verifySignupErrorText());
		driver.close();
	}
}
