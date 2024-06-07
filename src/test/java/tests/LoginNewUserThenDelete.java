package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class LoginNewUserThenDelete extends BaseTest{

	@DataProvider 
	public Object[][] newUserLoginData () throws IOException
	{
		List<HashMap<String,String>> data = getJsonDataToMap(newUserLoginDataLocation);
		return new Object[][] {{data.getFirst()}};
	}
	
	@Test (dataProvider= "newUserLoginData")
	public void LoginNewUserThenDelete(HashMap<String,String> newUserInfo) {

			final String name = newUserInfo.get("firstName") + " " + newUserInfo.get("lastName");
			final String email = newUserInfo.get("email");

			WebDriver driver = initializeDriver();

			LandingPage landingPage = new LandingPage(driver);
			landingPage.headerGoToLogin();

			LoginPage loginPage = new LoginPage(driver);
			Assert.assertTrue(loginPage.verifyNewUserText());
			loginPage.inputNewUserInfo(name, email);
			loginPage.clickSignupButton();

			RegisterPage registerPage = new RegisterPage(driver);
			Assert.assertTrue(registerPage.verifySignupText());
			registerPage.InputNewUserInfo(newUserInfo);
			registerPage.clickCreateAccountButton();

			AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
			Assert.assertTrue(accountCreatedPage.verifyConfirmText());
			Assert.assertTrue(landingPage.verifyHeaderLoggedInAsText(name));
			landingPage.headerDeleteAccount();

			AccountDeletedPage accountDeletedPage = new AccountDeletedPage(driver);
			Assert.assertTrue(accountDeletedPage.verifyConfirmText(driver));
			driver.close();
	}

}
