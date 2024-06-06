package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header extends Utilities{
    WebDriver driver;

    public Header (WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "a[href='/view_cart'")
    WebElement headerCart;

    @FindBy(css="a[href='/contact_us']")
    WebElement headerContact;

    @FindBy(css = "a[href='/delete_account']")
    WebElement headerDelete;

    @FindBy(css = "a[href='/']")
    protected WebElement headerHome;

    @FindBy(xpath = "//i[@class='fa fa-user']/parent::a")
    WebElement headerLoggedInAs;

    @FindBy(css = "a[href='/login']")
    WebElement headerLogin;

    @FindBy(css = "a[href='/logout']")
    WebElement headerLogout;

    @FindBy(css = "a[href='/products']")
    protected WebElement headerProducts;

    @FindBy(css="a[href='/test_cases']")
    WebElement headerTestCases;

    String expectedSubscriptionText = "SUBSCRIPTION";
    String expectedSubmissionText = "You have been successfully subscribed!";


    @FindBy(id="subscribe")
    WebElement subscribeButton;

    @FindBy(id="susbscribe_email")
    WebElement subscriptionInput;

    @FindBy(id="success-subscribe")
    WebElement submissionText;

    @FindBy(css=".single-widget h2")
    WebElement subscriptionText;



    public void goToCart() {
        headerCart.click();
    }

    public void goToContact() {
        headerContact.click();

    }

    public void goToLogin() {
        headerLogin.click();

    }

    public void goToProducts() {
        headerProducts.click();
    }

    public void goToTestCases() {
        headerTestCases.click();
    }

    public void headerLogout() {
        waitForElement(headerLogout);
        headerLogout.click();
    }

    public void headerDeleteAccount() {
        headerDelete.click();
    }

    public void subscribe (String email) {
        subscriptionInput.sendKeys(email);
        subscribeButton.click();
    }

    public boolean verifySubmissionText() {
        return submissionText.getText().contentEquals(expectedSubmissionText);
    }

    public boolean verifySubscrptionText() {
        return subscriptionText.getText().contentEquals(expectedSubscriptionText);
    }

    public String getLoggedInText() {
        return headerLoggedInAs.getText();
    }
}
