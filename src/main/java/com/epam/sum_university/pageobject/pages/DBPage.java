package com.epam.sum_university.pageobject.pages;

import com.epam.sum_university.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DBPage extends BasePage {

    @FindBy(xpath = "//div[@class=\"alert alert-success alert-dismissible fade show\"]")
    private WebElement dbCreatedAlert;
    @FindBy(xpath = "//span[@class=\"text-nowrap\"]/a")
    private WebElement userInformationLabel;
    @FindBy(xpath = "//a[@href='/home']")
    private WebElement backToHomePage;
    @FindBy(xpath = "//h5[contains(text(),'Explorer') or contains(text(),'Досліджувати')]")
    private WebElement DBElement;
    @FindBy(xpath = "//li/a[contains(@href,'/table')]")
    private WebElement databaseExplorerButton;
    @FindBy(xpath = "//li/a[contains(@href,'/point')]")
    private WebElement backupButton;
    @FindBy(xpath = "//li/a[contains(@href,'/sql')]")
    private WebElement sqlLabel;
    @FindBy(xpath = "//table")
    private WebElement dbExplCheck;
    @FindBy(xpath = "//li/a[contains(@href,'/script')]")
    private WebElement scriptLabel;

    public DBPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean dBElementIsDisplayed() {
        DBElement = new WebDriverWait(webDriver, 30)
                .until(ExpectedConditions.visibilityOf(DBElement));
        return DBElement.isDisplayed();
    }

    public boolean checkDB() {
        dbCreatedAlert = new WebDriverWait(webDriver, 30)
                .until(ExpectedConditions.visibilityOf(dbCreatedAlert));
        return dbCreatedAlert.isDisplayed();
    }

    public boolean userInfo() {
        return userInformationLabel.isDisplayed();
    }

    public ProfilePage clickProfileButton() {
        userInformationLabel.click();
        return new ProfilePage(webDriver);
    }

    public boolean dBObservationElementIsDisplayed() {
        dbCreatedAlert = new WebDriverWait(webDriver, 30).until(ExpectedConditions.visibilityOf(dbCreatedAlert));
        return dbCreatedAlert.isDisplayed();
    }

    public HomePage ReturnToHomePage() {
        backToHomePage.click();
        return new HomePage(webDriver);
    }
    public boolean checkTable(){
        return dbExplCheck.isDisplayed();
    }


    public TablePage clickDataExplorerButton() {
        Actions act = new Actions(webDriver);
        act.moveToElement(databaseExplorerButton).click();
        return new TablePage(webDriver);
    }
    public ScriptsPage clickScript(){
        scriptLabel.click();
        return new ScriptsPage(webDriver);
    }
    public BackUpPage clickBackupButton() {
        Actions act = new Actions(webDriver);
        act.moveToElement(backupButton).click();
        return new BackUpPage(webDriver);
    }
    public SQLPage clickSQL(){
        sqlLabel.click();
        return new SQLPage(webDriver);
    }

}
