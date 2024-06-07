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

public class LoginExistingUserThenLogOut extends BaseTest{

	@DataProvider
	public Object[][] existingUserInfo () throws IOException
	{
		List<HashMap<String,String>> data = getJsonDataToMap(existingUserLoginInfoLocation);
		return new Object[][] {{data.getFirst()}};
	}

	@Test (dataProvider="existingUserLoginData", enabled=false)
	public void LoginExistingUser(HashMap<String,String> existingUserLoginInfo) {
		WebDriver driver = initializeDriver();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.headerGoToLogin();

		LoginPage loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.verifyLoginText());
		loginPage.inputUserLoginInfo(existingUserLoginInfo.get("email"), existingUserLoginInfo.get("password"));
		loginPage.clickLoginButton();

		Assert.assertTrue(landingPage.verifyHeaderLoggedInAsText(existingUserLoginInfo.get("name")));
		landingPage.headerLogout();
		Assert.assertTrue(loginPage.verifyTitle());
		driver.close();
	}
}
