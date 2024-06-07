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
    private WebElement headerCart;
    @FindBy(css="a[href='/contact_us']")
    private WebElement headerContact;
    @FindBy(css = "a[href='/delete_account']")
    private WebElement headerDelete;
    @FindBy(css = "a[href='/']")
    private WebElement headerHome;
    @FindBy(css = "a[href='/login']")
    private WebElement headerLogin;
    @FindBy(css = "a[href='/logout']")
    private WebElement headerLogout;
    @FindBy(css = "a[href='/products']")
    private WebElement headerProducts;
    @FindBy(css="a[href='/test_cases']")
    private WebElement headerTestCases;
    @FindBy(xpath = "//i[@class='fa fa-user']/parent::a")
    private WebElement headerLoggedInAs;

    private String expectedSubscriptionText = "SUBSCRIPTION";
    private String expectedSubmissionText = "You have been successfully subscribed!";

    @FindBy(id="subscribe")
    private WebElement subscribeButton;
    @FindBy(id="susbscribe_email")
    private WebElement subscriptionInput;
    @FindBy(id="success-subscribe")
    private WebElement submissionText;
    @FindBy(css=".single-widget h2")
    private WebElement subscriptionText;



    public void headerGoToCart() {
        headerCart.click();
    }
    public void headerGoToContact() {
        headerContact.click();
    }
    public void headerGoToLogin() {
        headerLogin.click();
    }
    public void headerGoToProducts() {
        headerProducts.click();
    }
    public void headerGoToTestCases() {
        headerTestCases.click();
    }
    public void headerLogout() {
        headerLogout.click();
    }
    public void headerDeleteAccount() {
        headerDelete.click();
    }

    public void inputBannerSubscribeEmail (String email) {
        subscriptionInput.sendKeys(email);
    }
    public void clickBannerSubmitButton () {
        subscribeButton.click();
    }

    public boolean verifyHeaderLoggedInAsText(String name) {
        return headerLoggedInAs.getText().contentEquals("Logged in as " + name);
    }
    public boolean verifyBannerSubscriptionSubmissionText() {
        return submissionText.getText().contentEquals(expectedSubmissionText);
    }
    public boolean verifyBannerSubscribeText() {
        return subscriptionText.getText().contentEquals(expectedSubscriptionText);
    }
}
