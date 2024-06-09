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

		WebDriver driver = null;
		LoginPage loginPage = null;
		try {
			driver = initializeDriver();
			LandingPage landingPage = new LandingPage(driver);
			landingPage.headerGoToLogin();
			loginPage = new LoginPage(driver);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		try {
			Assert.assertTrue(loginPage.verifyNewUserText());
			loginPage.inputNewUserInfo(input.get("name"), input.get("email"));
			loginPage.clickSignupButton();
			Assert.assertTrue(loginPage.verifySignupErrorText());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		finally {
			driver.close();
		}
	}
}
