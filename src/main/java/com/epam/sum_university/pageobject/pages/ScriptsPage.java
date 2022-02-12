package com.epam.sum_university.pageobject.pages;

import com.epam.sum_university.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScriptsPage extends BasePage {

    @FindBy(id = "description")
    private WebElement description;

    @FindBy(name = "file")
    private WebElement file;

    @FindBy(xpath = "//button[@class='w-100 btn']")
    private WebElement uploadButton;

    @FindBy(xpath = "//div[@class='card-body border mb-1']")
    private WebElement scriptName;
    @FindBy(xpath = "  /html/body/div/div/main/div[1]")
    private WebElement scriptLimitAlert;

    @FindBy(xpath = "//ion-icon[@name='trash']")
    private WebElement deleteScript;

    @FindBy(xpath = "//div[@class='card-list-body card-task']")
    private WebElement noScriptsMsg;

    public ScriptsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ScriptsPage upload(String description, String file) {
        this.description = new WebDriverWait(webDriver, 120)
                .until(ExpectedConditions.visibilityOf(this.description));
        this.file = new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.elementToBeClickable(this.file));
        uploadButton = new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.elementToBeClickable(uploadButton));
        Actions act = new Actions(webDriver);
        act.moveToElement(this.description).click();
        this.description.sendKeys(description);
        this.file.sendKeys(file);
        uploadButton.click();
        return new ScriptsPage(webDriver);
    }

    public boolean check() {
        return scriptName.isDisplayed();
    }
     public boolean checkDeletion() {
        return noScriptsMsg.isDisplayed();
     }

    public boolean scriptAmountErrorIsDisplayed() {
        return scriptLimitAlert.isDisplayed();
    }

    public ScriptsPage deleteScript() {
        deleteScript.click();
        return new ScriptsPage(webDriver);
    }

    @FindBy(xpath = "//ion-icon[@name='play']")
    private WebElement runScript;

    public RunScriptsPage runScript() {
        runScript.click();
        return new RunScriptsPage(webDriver);
    }
}
