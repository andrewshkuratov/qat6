package com.epam.sum_university.pageobject.pages;

import com.epam.sum_university.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RunScriptsPage extends BasePage {
    @FindBy(xpath = "//li/a[contains(@href,'/table')]")
    private WebElement databaseExplorerButton;
    @FindBy(xpath = "//div[@class='container']")
    private WebElement scriptContainer;
    @FindBy(xpath = "/html/body/div/div/main/table/tbody/tr[2]/td/a")
    private WebElement tableLabel;
    public RunScriptsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean scriptContainerIsDisplayed(){
        return scriptContainer.isDisplayed();
    }
    public TablePage clickDataExplorerButton() {
        Actions act = new Actions(webDriver);
        act.moveToElement(databaseExplorerButton).click();
        return new TablePage(webDriver);
    }
    public TablePage сlickdbTableName () {
        tableLabel.click();
        return new TablePage(webDriver);
    }
}

