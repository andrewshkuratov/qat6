package com.epam.sum_university.pageobject.pages;

import com.epam.sum_university.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BackUpPage extends BasePage {
    @FindBy(xpath = "//input[@id='floatingInput']")
    private WebElement backupNameInput;

    @FindBy(xpath = "//button[@class='w-100 btn']")
    private WebElement createNewBackupButton;

    @FindBy(xpath = "//input[@value='Update']")
    private WebElement updateButton;

    @FindBy(xpath = "//input[@value='Reset']")
    private WebElement resetButton;

    @FindBy(xpath = "/html/body/div/div/main/div[1]")
    private WebElement resetMessage;

    @FindBy(xpath = "//input[@value='Delete']")
    private WebElement removeButton;

    @FindBy(xpath = "//div[@class='card-list-body card-task']")
    private WebElement removeMessage;

    public BackUpPage(WebDriver webDriver) {
        super(webDriver);
    }

    public BackUpPage posCreateBackup(String backupName) {
        createNewBackupButton = new WebDriverWait(webDriver, 30)
                .until(ExpectedConditions.visibilityOf(createNewBackupButton));
        backupNameInput = new WebDriverWait(webDriver, 30)
                .until(ExpectedConditions.visibilityOf(backupNameInput));
        backupNameInput.sendKeys(backupName);
        createNewBackupButton.click();
        return new BackUpPage(webDriver);
    }

    public boolean backupObservationElementIsDisplayed() {
        return updateButton.isDisplayed();
    }

    public BackUpPage negativeBackup(String backupName) {
        Actions act = new Actions(webDriver);
        backupNameInput.sendKeys(backupName);
        act.moveToElement(createNewBackupButton).click();
        return new BackUpPage(webDriver);
    }

    public DBPage databaseUpdate() {
        Actions act = new Actions(webDriver);
        act.moveToElement(updateButton).click();
        return new DBPage(webDriver);
    }

    public BackUpPage resetDatabase() {
        Actions act = new Actions(webDriver);
        act.moveToElement(resetButton).click();
        return new BackUpPage(webDriver);
    }
    public boolean resetObservationElementIsDisplayed() {
        return resetMessage.isDisplayed();
    }

    public BackUpPage removeBackup() {
        Actions act = new Actions(webDriver);
        act.moveToElement(removeButton).click();
        return new BackUpPage(webDriver);
    }
    public boolean removeObservationElementIsDisplayed() {
        return removeMessage.isDisplayed();
    }

}
