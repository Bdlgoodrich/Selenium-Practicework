package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

public class RegisterPage extends Utilities{
	WebDriver driver;
	public RegisterPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		if (!this.verifyTitle(title)) throw new AssertionError("Previous step did not go to Registration Page");
	}

	public final String title = "Automation Exercise - Signup";
	private final String expectedSignupText = "ENTER ACCOUNT INFORMATION";
	
	private final By signupText = By.tagName("h2");
	private final By titleMrButton = By.id("uniform-id_gender1");
	private final By titleMrsButton = By.id("uniform-id_gender2");
	private final By nameInput = By.id("name");
	private final By passwordInput = By.id("password");
	private final By daySelector = By.id("days");
	private final By monthSelector = By.id("months");
	private final By yearSelector = By.id("years");
	private final By newsButton = By.id("newsletter");
	private final By optinButton = By.id("optin");
	private final By firstNameInput = By.id("first_name");
	private final By lastNameInput = By.id("last_name");
	private final By companyInput = By.id("company");
	private final By address1Input = By.id("address1");
	private final By address2Input = By.id("address2");
	private final By countriesSelector = By.id("country");
	private final By stateInput = By.id("state");
	private final By cityInput = By.id("city");
	private final By zipcodeInput = By.id("zipcode");
	private final By mobileInput = By.id("mobile_number");
	private final By createAccountButton = By.cssSelector("button[data-qa='create-account']");

	public void clickCreateAccountButton () {
		waitForElement(driver.findElement(createAccountButton));
		driver.findElement(createAccountButton).click();
	}
	
	public void InputNewUserInfo (HashMap<String, String> input) {
		if (input.get("title").equalsIgnoreCase("Mr.")) {
			waitForElement(driver.findElement(titleMrButton));
			driver.findElement(titleMrButton).click();
		}
		else if (input.get("title").equalsIgnoreCase("Mrs.")) {
			waitForElement(driver.findElement(titleMrsButton));
			driver.findElement(titleMrsButton).click();
		}
		
		driver.findElement(passwordInput).sendKeys(input.get("password"));
		Select day = new Select(driver.findElement(daySelector));
		day.selectByVisibleText(input.get("day"));
		Select month = new Select(driver.findElement(monthSelector));
		month.selectByVisibleText(input.get("month"));
		Select year = new Select(driver.findElement(yearSelector));
		year.selectByVisibleText(input.get("year"));
		scrollToElement(driver.findElement(newsButton));
		if (input.get("newsletter").equalsIgnoreCase("yes")) {
			driver.findElement(newsButton).click();
		}
		if (input.get("optin").equalsIgnoreCase("yes")) {
			driver.findElement(optinButton).click();
		}
		driver.findElement(firstNameInput).sendKeys(input.get("firstName"));
		driver.findElement(lastNameInput).sendKeys(input.get("lastName"));
		driver.findElement(companyInput).sendKeys(input.get("company"));
		driver.findElement(address1Input).sendKeys(input.get("address1"));
		scrollToElement(driver.findElement(address2Input));
		driver.findElement(address2Input).sendKeys(input.get("address2"));
		Select country = new Select(driver.findElement(countriesSelector));
		country.selectByVisibleText(input.get("country"));
		driver.findElement(stateInput).sendKeys(input.get("state"));
		driver.findElement(cityInput).sendKeys(input.get("city"));
		driver.findElement(zipcodeInput).sendKeys(input.get("zipcode"));
		driver.findElement(mobileInput).sendKeys(input.get("mobileNumber"));
	}
	
	public boolean verifySignupText() {
        return driver.findElement(signupText).getText().contentEquals(expectedSignupText);
	}
	
}
