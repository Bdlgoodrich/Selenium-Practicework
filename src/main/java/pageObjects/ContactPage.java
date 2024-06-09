package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class ContactPage extends Utilities {
	private WebDriver driver;

	public ContactPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		if (!this.verifyTitle(title)) throw new AssertionError("Previous step did not go to Cart Page");
	}

	public final String title = "Automation Exercise - Contact Us";
	private final String expectedGetInTouchText = "GET IN TOUCH";
	private final String expectedSuccessText = "Success! Your details have been submitted successfully.";

	private final By getInTouch = By.cssSelector("div[class='contact-form'] h2");
	private final By nameInput = By.name("name");
	private final By emailInput = By.name("email");
	private final By subjectInput = By.name("subject");
	private final By messageInput = By.id("message");
	private final By fileButton = By.name("upload_file");
	private final By submitButton = By.name("submit");
	private final By success = By.cssSelector(".status.alert-success");
	private final By homeButton = By.className("btn-success");

	public void inputContactInfo(HashMap<String, String> input) {
		scrollToElement(driver.findElement(nameInput));
		driver.findElement(nameInput).sendKeys(input.get("name"));
		driver.findElement(emailInput).sendKeys(input.get("email"));
		driver.findElement(subjectInput).sendKeys(input.get("subject"));
		driver.findElement(messageInput).sendKeys(input.get("message"));
	}

	public void clickHomeButton() {
		scrollToElement(driver.findElement(messageInput));
		driver.findElement(homeButton).click();
	}

	public void submitContactInfo() {
		scrollToElement(driver.findElement(getInTouch));
		driver.findElement(submitButton).click();
	}

	//this method is incomplete at this time
	public void uploadFile() {
		driver.findElement(fileButton).click();
	}

	public boolean verifyBeInTouchText() {
		return driver.findElement(fileButton).getText().contentEquals(expectedGetInTouchText);
	}

	public boolean verifySuccessText() {
		return driver.findElement(success).getText().contentEquals(expectedSuccessText);
	}

}
