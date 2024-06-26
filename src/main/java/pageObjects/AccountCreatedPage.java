package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AccountCreatedPage extends Utilities{
	WebDriver driver;
	public AccountCreatedPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		if (!this.verifyTitle(title)) throw new AssertionError("Previous step did not go to Account Created Page");
	}
	public final String title = "Automation Exercise - Account Created";
	private final String expectedConfirmText ="ACCOUNT CREATED!";

	private final By continueButton = By.cssSelector("a[data-qa='continue-button']");
	private final By createdText = By.tagName("b");
	
	
	public boolean verifyConfirmText() {
		String text = driver.findElement(createdText).getText();
		boolean match = text.contentEquals(expectedConfirmText);
		driver.findElement(continueButton).click();
		return match;
	}

}