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

public class LoginIncorrectUser extends BaseTest{
	
	@DataProvider 
	public Object[][] incorrectUserLoginData () throws IOException
	{
		List<HashMap<String,String>> data = getJsonDataToMap(incorrectUserLoginDataLocation);
		return new Object[][] {{data.getFirst()}};
	}
	
	@Test (dataProvider= "incorrectUserLoginData")
	public void LoginIncorrectUser(HashMap<String,String> input){
		WebDriver driver = initializeDriver();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.headerGoToLogin();

		LoginPage loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.verifyLoginText());
		loginPage.inputUserLoginInfo(input.get("email"), input.get("password"));
		loginPage.clickLoginButton();
		Assert.assertTrue(loginPage.verifyLoginError());
		driver.close();
	}
	
}
