package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage extends Utilities{
	WebDriver driver;
	public AccountCreatedPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		if (!this.verifyTitle(title)) throw new AssertionError("Previous step did not go to Account Created Page");
		PageFactory.initElements(driver, this);
	}
	public final String title = "Automation Exercise - Account Created";
	private final String expectedConfirmText ="ACCOUNT CREATED!";

	@FindBy (css="a[data-qa='continue-button']")
	private WebElement continueButton;
	
	@FindBy (tagName="b")
	private WebElement createdText;
	
	
	public boolean verifyConfirmText() {
		String text = createdText.getText();
		boolean match = text.contentEquals(expectedConfirmText);
		continueButton.click();
		return match;
	}

}