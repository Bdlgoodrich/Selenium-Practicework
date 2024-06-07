package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

public class RegisterPage extends Utilities{
	WebDriver driver;
	public RegisterPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		if (!this.verifyTitle(title)) throw new AssertionError("Previous step did not go to Registration Page");
		PageFactory.initElements(driver, this); 
	}

	public final String title = "Automation Exercise - Signup";
	private final String expectedSignupText = "ENTER ACCOUNT INFORMATION";
	
	@FindBy(tagName="h2")
	private WebElement signupText;
	@FindBy(id="uniform-id_gender1")
	private WebElement titleMrButton;
	@FindBy(id="uniform-id_gender2")
	private WebElement titleMrsButton;
	@FindBy (id="name")
	private WebElement nameInput;
	@FindBy (id="password")
	private WebElement passwordInput;
	@FindBy (id="days")
	private WebElement daySelector;
	@FindBy (id="months")
	private WebElement monthSelector;
	@FindBy (id="years")
	private WebElement yearSelector;
	@FindBy (id="newsletter")
	private WebElement newsButton;
	@FindBy (id="optin")
	private WebElement optinButton;
	@FindBy (id="first_name")
	private WebElement firstNameInput;
	@FindBy (id="last_name")
	private WebElement lastNameInput;
	@FindBy (id="company")
	private WebElement companyInput;
	@FindBy (id="address1")
	private WebElement address1Input;
	@FindBy (id="address2")
	private WebElement address2Input;
	@FindBy (id="country")
	private WebElement countriesSelector;
	@FindBy (id="state")
	private WebElement stateInput;
	@FindBy (id="city")
	private WebElement cityInput;
	@FindBy (id="zipcode")
	private WebElement zipcodeInput;
	@FindBy (id="mobile_number")
	private WebElement mobileInput;
	@FindBy (css="button[data-qa='create-account']")
	private WebElement createAccountButton;


	public void clickCreateAccountButton () {
		waitForElement(createAccountButton);
		createAccountButton.click();
	}
	
	public void InputNewUserInfo (HashMap<String, String> input) {
		if (input.get("title").equalsIgnoreCase("Mr.")) {
			waitForElement(titleMrButton);
			titleMrButton.click();
		}
		else if (input.get("title").equalsIgnoreCase("Mrs.")) {
			waitForElement(titleMrsButton);
			titleMrsButton.click();
		}
		
		passwordInput.sendKeys(input.get("password"));
		Select day = new Select(daySelector);
		day.selectByVisibleText(input.get("day"));
		Select month = new Select(monthSelector);
		month.selectByVisibleText(input.get("month"));
		Select year = new Select(yearSelector);
		year.selectByVisibleText(input.get("year"));
		scrollToElement(newsButton);
		if (input.get("newsletter").equalsIgnoreCase("yes")) {
			newsButton.click();
		}
		if (input.get("optin").equalsIgnoreCase("yes")) {
			optinButton.click();
		}
		firstNameInput.sendKeys(input.get("firstName"));
		lastNameInput.sendKeys(input.get("lastName"));
		companyInput.sendKeys(input.get("company"));
		address1Input.sendKeys(input.get("address1"));
		scrollToElement(address2Input);
		address2Input.sendKeys(input.get("address2"));
		Select country = new Select(countriesSelector);
		country.selectByVisibleText(input.get("country"));
		stateInput.sendKeys(input.get("state"));
		cityInput.sendKeys(input.get("city"));
		zipcodeInput.sendKeys(input.get("zipcode"));
		mobileInput.sendKeys(input.get("mobileNumber"));
	}
	
	public boolean verifySignupText() {
        return signupText.getText().contentEquals(expectedSignupText);
	}
	
}
