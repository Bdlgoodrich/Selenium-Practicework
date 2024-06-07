package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends Utilities{
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		if (!this.verifyTitle(title)) throw new AssertionError("Previous step did not go to Login Page");
		PageFactory.initElements(driver, this);
	}
	
	public final String title = "Automation Exercise - Signup / Login";
	private final String expectedLoginErrorText = "Your email or password is incorrect!";
	private final String expectedLoginText = "Login to your account";
	private final String expectedNewUserText = "New User Signup!";
	private final String expectedSignupErrorText = "Email Address already exist!";
	
	@FindBy (css="button[data-qa='login-button']")
	private WebElement loginButton;
	@FindBy(css=".login-form h2")
	private WebElement loginText;
	@FindBy (css="input[data-qa='login-email']")
	private WebElement userEmailInput;
	@FindBy (name="password")
	private WebElement userPasswordInput;
	@FindBy (css="p[style='color: red;']")
	private WebElement errorText;
	@FindBy (css="input[data-qa='signup-email']")
	private WebElement newUserEmailInput;
	@FindBy (name="name")
	private WebElement newUserNameInput;
	@FindBy (css=".signup-form h2")
	private WebElement newUserText;
	@FindBy (css="button[data-qa='signup-button']")
	private WebElement signupButton;
	
		
	public void inputUserLoginInfo (String email, String password){
		userEmailInput.sendKeys(email);
		userPasswordInput.sendKeys(password);
	}
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void inputNewUserInfo(String userName, String email){
		newUserNameInput.sendKeys(userName);
		newUserEmailInput.sendKeys(email);
	}
	public void clickSignupButton() {
		signupButton.click();
	}

	public boolean verifyLoginError () {
		return errorText.getText().contentEquals(expectedLoginErrorText);
	}

	public boolean verifyLoginText() {
        return loginText.getText().contentEquals(expectedLoginText);
	}

	public boolean verifyNewUserText () {
        return newUserText.getText().contentEquals(expectedNewUserText);
	}

	public boolean verifySignupErrorText() {
        return errorText.getText().contentEquals(expectedSignupErrorText);
	}

	public boolean verifyTitle() {
        return driver.getTitle().contentEquals(title);
	}
}
