package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AccountDeletedPage extends Utilities{
	WebDriver driver;
	public AccountDeletedPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		if (!this.verifyTitle(title)) throw new AssertionError("Previous step did not go to Account Deleted Page");
//		PageFactory.initElements(driver, this);
	}
	
	public final String title = "Automation Exercise - Account Created";
	private final String confirmText = "ACCOUNT DELETED!";

	private final By accountDeletedText = By.tagName("b");
	private final By continueButton = By.cssSelector("a[data-qa='continue-button']");

	public boolean verifyConfirmText(WebDriver driver) {
		String text = driver.findElement(accountDeletedText).getText();
		boolean match = text.contentEquals(confirmText);
		driver.findElement(continueButton).click();
		return match;
	}
	
}
