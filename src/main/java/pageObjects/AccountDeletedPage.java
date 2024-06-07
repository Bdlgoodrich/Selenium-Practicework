package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDeletedPage extends Utilities{
	WebDriver driver;
	public AccountDeletedPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		if (!this.verifyTitle(title)) throw new AssertionError("Previous step did not go to Account Deleted Page");
		PageFactory.initElements(driver, this);
	}
	
	public final String title = "Automation Exercise - Account Created";
	private final String confirmText = "ACCOUNT DELETED!";
	
	@FindBy(tagName="b")
	private WebElement accountDeletedText;
	
	@FindBy (css="a[data-qa='continue-button']")
	private WebElement continueButton;

	public boolean verifyConfirmText(WebDriver driver) {
		String text = accountDeletedText.getText();
		boolean match = text.contentEquals(confirmText);
		continueButton.click();
		return match;
	}
	
}
