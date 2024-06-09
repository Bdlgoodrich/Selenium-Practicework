package pageObjects;

import org.openqa.selenium.WebDriver;

public class LandingPage extends Header {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		goToUrl();
		if (!this.verifyTitle(title)) throw new AssertionError("Initialization of driver and landing page failed");
	}

	public final String title = "Automation Exercise";
	private final String url = "https://automationexercise.com/";

	public void goToUrl(){
		driver.get(url);
	}

}
