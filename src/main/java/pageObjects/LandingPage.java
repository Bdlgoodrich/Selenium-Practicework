package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends Header {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	String title = "Automation Exercise";

	public boolean verifyLoggedInAsText(String name) {
        return headerLoggedInAs.getText().contentEquals("Logged in as " + name);
	}
	
	public boolean verifyTitle() {
        return driver.getTitle().contentEquals(title);
	}
}
