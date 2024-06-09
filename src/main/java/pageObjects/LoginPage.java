package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;

public class LoginPage extends Utilities{
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		if (!this.verifyTitle(title)) throw new AssertionError("Previous step did not go to Login Page");
	}
	
	public final String title = "Automation Exercise - Signup / Login";
	private final String expectedLoginErrorText = "Your email or password is incorrect!";
	private final String expectedLoginText = "Login to your account";
	private final String expectedNewUserText = "New User Signup!";
	private final String expectedSignupErrorText = "Email Address already exist!";
	
	private By loginButton = By.cssSelector("button[data-qa='login-button']");
	private By loginText = By.cssSelector(".login-form h2");
	private By userEmailInput = By.cssSelector("input[data-qa='login-email']");
	private By userPasswordInput = By.name("password");
	private By errorText = By.cssSelector("p[style='color: red;']");
	private By newUserEmailInput = By.cssSelector("input[data-qa='signup-email']");
	private By newUserNameInput = By.name("name");
	private By newUserText = By.cssSelector(".signup-form h2");
	private By signupButton = By.cssSelector("button[data-qa='signup-button']");

	public void inputUserLoginInfo (String email, String password){
		driver.findElement(userEmailInput).sendKeys(email);
		driver.findElement(userPasswordInput).sendKeys(password);
	}
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
	
	public void inputNewUserInfo(String userName, String email){
		driver.findElement(newUserNameInput).sendKeys(userName);
		driver.findElement(newUserEmailInput).sendKeys(email);
	}
	public void clickSignupButton() {
		driver.findElement(signupButton).click();
	}

	public boolean verifyLoginError () {
		return driver.findElement(errorText).getText().contentEquals(expectedLoginErrorText);
	}

	public boolean verifyLoginText() {
        return driver.findElement(loginText).getText().contentEquals(expectedLoginText);
	}

	public boolean verifyNewUserText () {
        return driver.findElement(newUserText).getText().contentEquals(expectedNewUserText);
	}

	public boolean verifySignupErrorText() {
        return driver.findElement(errorText).getText().contentEquals(expectedSignupErrorText);
	}

	public boolean verifyTitle() {
        return driver.getTitle().contentEquals(title);
	}
}
