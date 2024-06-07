package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.PrivateKey;
import java.util.HashMap;

public class ContactPage extends Utilities {
	private WebDriver driver;

	public ContactPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		if (!this.verifyTitle(title)) throw new AssertionError("Previous step did not go to Cart Page");
		PageFactory.initElements(driver, this);
	}

	public final String title = "Automation Exercise - Contact Us";
	private final String expectedGetInTouchText = "GET IN TOUCH";
	private final String expectedSuccessText = "Success! Your details have been submitted successfully.";

	@FindBy(css = "div[class='contact-form'] h2")
	private WebElement getInTouch;
	@FindBy(name = "name")
	private WebElement nameInput;
	@FindBy(name = "email")
	private WebElement emailInput;
	@FindBy(name = "subject")
	private WebElement subjectInput;
	@FindBy(id = "message")
	private WebElement messageInput;
	@FindBy(name = "upload_file")
	private WebElement fileButton;
	@FindBy(name = "submit")
	private WebElement submitButton;
	@FindBy(css = ".status.alert-success")
	private WebElement success;
	@FindBy(className = "btn-success")
	private WebElement homeButton;

	public void inputContactInfo(HashMap<String, String> input) {
		scrollToElement(nameInput);
		nameInput.sendKeys(input.get("name"));
		emailInput.sendKeys(input.get("email"));
		subjectInput.sendKeys(input.get("subject"));
		messageInput.sendKeys(input.get("message"));
	}

	public void clickHomeButton() {
		scrollToElement(homeButton);
		homeButton.click();
	}

	public void submitContactInfo() {
		scrollToElement(getInTouch);
		submitButton.click();
	}
	
	public void uploadFile() {
		fileButton.click();
	}

	public boolean verifyBeInTouchText() {
		return getInTouch.getText().contentEquals(expectedGetInTouchText);
	}

	public boolean verifySuccessText() {
		return success.getText().contentEquals(expectedSuccessText);
	}

}
