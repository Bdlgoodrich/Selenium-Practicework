package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends Header {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		goToUrl();
		if (!this.verifyTitle(title)) throw new AssertionError("Initialization of driver and landing page failed");
		PageFactory.initElements(driver, this);
	}

	public final String title = "Automation Exercise";
	private final String url = "https://automationexercise.com/";

	public void goToUrl(){
		driver.get(url);
	}

}
