package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends Utilities{
    WebDriver driver;

    public Header (WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private final String expectedFooterSubscriptionText = "SUBSCRIPTION";
    private final String expectedFooterSubmissionText = "You have been successfully subscribed!";

    private final By headerCart = By.cssSelector("a[href='/view_cart'");
    private final By headerContact = By.cssSelector("a[href='/contact_us']");
    private final By headerDelete = By.cssSelector("a[href='/delete_account']");
    private final By headerHome = By.cssSelector("a[href='/']");
    private final By headerLogin = By.cssSelector("a[href='/login']");
    private final By headerLogout = By.cssSelector("a[href='/logout']");
    private final By headerProducts = By.cssSelector("a[href='/products']");
    private final By headerTestCases = By.cssSelector("a[href='/test_cases']");
    private final By headerLoggedInAs = By.xpath("//i[@class='fa fa-user']/parent::a");
    
    private final By footerSubscribeButton = By.id("subscribe");
    private final By footerSubscriptionInput = By.id("susbscribe_email");
    private final By footerSubmissionText = By.id("success-subscribe");
    private final By footerSubscriptionText = By.cssSelector(".single-widget h2");



    public void headerGoToCart() {
        driver.findElement(headerCart).click();
    }
    public void headerGoToContact() {
        driver.findElement(headerContact).click();
    }
    public void headerGoToLogin() {
        driver.findElement(headerLogin).click();
    }
    public void headerGoToProducts() {
        driver.findElement(headerProducts).click();
    }
    public void headerGoToTestCases() {
        driver.findElement(headerTestCases).click();
    }
    public void headerLogout() {
        driver.findElement(headerLogout).click();
    }
    public void headerDeleteAccount() {
        driver.findElement(headerDelete).click();
    }

    public void inputFooterSubscribeEmail (String email) {
        driver.findElement(footerSubscriptionInput).sendKeys(email);
    }
    public void clickFooterSubmitButton () {
        driver.findElement(footerSubscribeButton).click();
    }

    public boolean verifyHeaderLoggedInAsText(String name) {
        return driver.findElement(headerLoggedInAs).getText().contentEquals("Logged in as " + name);
    }
    public boolean verifyFooterSubscriptionSubmissionText() {
        return driver.findElement(footerSubmissionText).getText().contentEquals(expectedFooterSubmissionText);
    }
    public boolean verifyFooterSubscribeText() {
        return driver.findElement(footerSubscriptionText).getText().contentEquals(expectedFooterSubscriptionText);
    }
}
