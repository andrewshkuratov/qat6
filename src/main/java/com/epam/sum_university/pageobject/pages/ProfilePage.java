package com.epam.sum_university.pageobject.pages;

import com.epam.sum_university.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

    @FindBy(xpath = "//a[@href='/home']")
    private WebElement backToHome;

    @FindBy(xpath = "//button[contains(text(),'Upgrade')]")
    //@FindBy(xpath = "//button[@class='w-100 btn btn-lg btn-outline-primary']")
    private WebElement userUpgradeRoleButton;

    @FindBy(xpath = "//button[@class='btn-close']")
    private WebElement fineUpgradeLabel;

    @FindBy(xpath = "//li[@class='nav-item']/a[@href='/']")
    private WebElement backToHomePage;

    @FindBy(xpath = "//div[@class='container shadow border p-5 mb-3']")
    private WebElement changeLanguage;

    @FindBy(xpath = "//input[@id=\"public-api\"]")
    private WebElement publicKeyInput;

    @FindBy(xpath = "//input[@id=\"private-api\"]")
    private WebElement privateKeyInput;

    @FindBy(xpath = "//button[text()='Re-generate']")
    private WebElement regenerateButton;

    @FindBy(xpath = "//input[@id='web-password']")
    private WebElement passwordInput1;

    @FindBy(xpath = "//input[@id='db-password']")
    private WebElement dbPassInput;

    @FindBy(xpath = "//input[@id='web-password-c']")
    private WebElement passwordInput2;

    @FindBy(xpath = "//form[contains(@action,'reset-password')]//button[@class='btn']")
    private WebElement changePasswordButton;

    @FindBy(xpath = "//form[contains(@action,'reset-db')]//button[@class='btn']")
    private WebElement changeDBPasswordButton;

    @FindBy(xpath = "//div[@class=\'alert alert-success alert-dismissible fade show\']")
    private WebElement alert;

    @FindBy(xpath = "//button[contains(text(),'Remove account')]")
    private WebElement deleteAccButton;

    @FindBy(xpath = "//button[contains(text(),'removed')]")
    private WebElement message;

    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String[] getKeyValue() {
        String [] arr = new String[2];
        arr[0]=privateKeyInput.getAttribute("value");
        arr[1]=publicKeyInput.getAttribute("value");
        return arr;
    }
    public ProfilePage regenerate(){
        regenerateButton.click();
        return new ProfilePage(webDriver);
    }

    public ProfilePage open() {
        webDriver.get("https://elephant.tss2021.site/profile");
        return this;
    }

    public boolean getUpgradeRole() {
        alert = new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.visibilityOf(alert));
        Actions act = new Actions(webDriver);
        act.moveToElement(alert);
        return alert.isDisplayed();
    }

    public ProfilePage upgradeRole() {
        Actions act = new Actions(webDriver);
        act.moveToElement(userUpgradeRoleButton).click();
        return this;
    }

    public HomePage backToHomeLogo() {
        Actions act = new Actions(webDriver);
        act.moveToElement(backToHome).click().build().perform();
        return new HomePage(webDriver);
    }

    public ProfilePage UpgradeRoleClick() {
        userUpgradeRoleButton = new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Upgrade']")));
        return new ProfilePage(webDriver);
    }

    public HomePage backToHomePage() {
        backToHomePage.click();
        return new HomePage(webDriver);
    }

    public boolean changeLanguageIsDisplayed() {
        return changeLanguage.isDisplayed();
    }
    public ProfilePage changeWebPassword(String pass, String pass1) {
        Actions act = new Actions(webDriver);
        act.moveToElement(changePasswordButton);
        passwordInput1.sendKeys(pass);
        passwordInput2.sendKeys(pass1);
        changePasswordButton = new WebDriverWait(webDriver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Basic']")));
        changePasswordButton.click();
        return new ProfilePage(webDriver);
    }
    public boolean changePassAlertIsDisplayed() {
        return alert.isDisplayed();
    }

    public ProfilePage deleteUserAcc() {
        Actions act = new Actions(webDriver);
        act.moveToElement(deleteAccButton).click();
        return new ProfilePage(webDriver);
    }
    public boolean deleteAccAlertIsDisplayed() { return message.isDisplayed(); }

    public ProfilePage changeDBPassword(String pass) {
        Actions act = new Actions(webDriver);
        act.moveToElement(changeDBPasswordButton);
        dbPassInput.clear();
        dbPassInput.sendKeys(pass);
        changeDBPasswordButton = new WebDriverWait(webDriver, 20)
                .until(ExpectedConditions.elementToBeClickable(changeDBPasswordButton));
        changeDBPasswordButton.click();
        return new ProfilePage(webDriver);
    }
}
